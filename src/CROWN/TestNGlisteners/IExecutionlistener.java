package CROWN.TestNGlisteners;

import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.testng.IExecutionListener;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import static CROWN.utility.Utility.fetchProperty;

public class IExecutionlistener extends ISuitelistener implements IExecutionListener {

    @Override
    public void onExecutionStart() {
        System.out.println("*************************************Master FrameWork*******************************************");
    }

    @Override
    public void onExecutionFinish() {

        System.out.println("Notify by mail, TestNG is finished");
        System.out.println("Total  Passed Test =" + passedtests.size());
        System.out.println("Total  Failed Test =" + failedtests.size());
        System.out.println("Total Skipped Test =" + skippedtests.size());

        try {
            if (Boolean.parseBoolean(fetchProperty("SendReport").toString())) {
                SendReport("gmail", passedtests.size(), failedtests.size(), skippedtests.size());
            } else {
                SendReport("gmail", passedtests.size(), failedtests.size(), skippedtests.size());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SendReport(String RecipientEmail, int f, int k, int t) throws IOException {
        String to = fetchProperty("HostEmail").toString();
        String from = fetchProperty(RecipientEmail).toString();

        final String username = fetchProperty("HostEmail").toString();
        final String password = fetchProperty("HostPassword").toString();

        String host = "smtp.gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

            message.setSubject("Testing Subject");
            BodyPart messageBodyPart = new MimeBodyPart();
            BodyPart messageBodyPart1 = new MimeBodyPart();


            messageBodyPart1.setContent("<h1>"+ "Test Summary" +"</h1>", "text/html");
            messageBodyPart.setContent("<h1>"+ "Passed:" + f +"" + " Failed:"+ k + " Skipped:" + t + "</h1>", "text/html");

            BodyPart messa = new MimeBodyPart();

            messa.setText(fetchProperty("MessageBody").toString());

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            messageBodyPart = new MimeBodyPart();
            File filename = getTheNewestFile(System.getProperty("user.dir") + "\\Report\\","html");
            String name = "CicodReport";
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(name);
            multipart.addBodyPart(messageBodyPart1);
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(messa);

            message.setContent(multipart);

            System.out.println("*************************************Sending Report******************************************");
            Transport.send(message);
            System.out.println("****************************************Done***************************************************");

        } catch (MessagingException e) {
            System.out.println("*************************************Failed to Send Report******************************************");
            throw new RuntimeException(e);

        }
    }

    public File getTheNewestFile(String filePath, String ext) {
        File theNewestFile = null;
        File dir = new File(filePath);
        FileFilter fileFilter = new WildcardFileFilter("*." + ext);
        File[] files = dir.listFiles(fileFilter);

        assert files != null;
        if (files.length > 0) {

            Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
            theNewestFile = files[0];
        }

        return theNewestFile;
    }

}