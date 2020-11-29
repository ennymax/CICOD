package CICOD.base;

import CICOD.utility.BrokenLink;
import CICOD.utility.JavaScriptUtil;
import CICOD.utility.Utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.mail.SimpleMailMessage;
import org.testng.ITestResult;
import org.testng.annotations.*;

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
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver;
    public static ExtentReports extent;
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentTest test;

    private static final String OUTPUT_FOLDER = "./Report/";
    private static final String FILE_NAME = "Report" + System.currentTimeMillis() + ".html";


    @BeforeSuite
    public void setup() throws IOException {

        Path path = Paths.get(OUTPUT_FOLDER);
        // if directory exists?
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                // fail to create directory
                e.printStackTrace();
            }
        }
        htmlReporter = new ExtentHtmlReporter(OUTPUT_FOLDER + FILE_NAME);

        htmlReporter.config().setDocumentTitle(Utility.fetchProperty("ProjectName").toString());
        htmlReporter.config().setReportName(Utility.fetchProperty("Tname").toString());
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setReportUsesManualConfiguration(true);

        extent.setSystemInfo("Hostname", "LocalHost");
        extent.setSystemInfo("TesterName", Utility.fetchProperty("Tname").toString());
        extent.setSystemInfo("OS", "Window10");
        extent.setSystemInfo("Browser", Utility.fetchProperty("browserName").toString());
    }

    @BeforeClass
    public void setUp() throws IOException {
        if (Utility.fetchProperty("browserName").toString().equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            if (Boolean.parseBoolean(Utility.fetchProperty("LunchOption").toString())) {
                driver = new ChromeDriver();
            } else {
                ChromeOptions options = new ChromeOptions();
                if (Utility.fetchProperty("headless").toString().trim().equals("true"))
                    options.addArguments("--headless");
                if (Utility.fetchProperty("incognito").toString().trim().equals("true"))
                    options.addArguments("--incognito");
                driver = new ChromeDriver(options);
            }
            System.out.println("*****************************" + Utility.fetchProperty("browserName") + " browser running ****************************************");

        } else if (Utility.fetchProperty("browserName").toString().equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            if (Boolean.parseBoolean(Utility.fetchProperty("LunchOption").toString())) {
                driver = new FirefoxDriver();
            } else {
                FirefoxOptions options = new FirefoxOptions();
                if (Utility.fetchProperty("headless").toString().trim().equals("true"))
                    options.addArguments("--headless");
                if (Utility.fetchProperty("incognito").toString().trim().equals("true"))
                    options.addArguments("--incognito");
                driver = new FirefoxDriver(options);
            }
            System.out.println("*****************************" + Utility.fetchProperty("browserName") + " browser running ****************************************");

        } else if (Utility.fetchProperty("browserName").toString().equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            System.out.println("*****************************" + Utility.fetchProperty("browserName") + " browser running ****************************************");
        } else if (Utility.fetchProperty("browserName").toString().equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
            System.out.println("*****************************" + Utility.fetchProperty("browserName") + " browser running ****************************************");
        } else if (Utility.fetchProperty("browserName").toString().equalsIgnoreCase("RemoteFirefox")) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("version", "85.0");
            caps.setCapability("enableVNC", true);
            //cap.setCapability("enableVideo", true);
            if (Utility.fetchProperty("headless").toString().trim().equals("true"))
                caps.setCapability("headless", true);

            try {
                driver = new RemoteWebDriver(new URL(Utility.fetchProperty("applicationUrl").toString()), caps);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        } else if (Utility.fetchProperty("browserName").toString().equalsIgnoreCase("RemoteChrome")) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("version", "85.0");
            caps.setCapability("enableVNC", true);
            //cap.setCapability("enableVideo", true);
            if (Utility.fetchProperty("headless").toString().trim().equals("true"))
                caps.setCapability("headless", true);


            try {
                driver = new RemoteWebDriver(new URL(Utility.fetchProperty("applicationUrl").toString()), caps);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Please pass the correct browser name....");
        }

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        driver.get(Utility.fetchProperty("applicationUrl").toString());
    }

    @AfterMethod
    public void getResult(ITestResult result) throws InterruptedException {
        String methodName = result.getMethod().getMethodName();
        String qualifiedName = result.getMethod().getQualifiedName();
        int last = qualifiedName.lastIndexOf(".");
        int mid = qualifiedName.substring(0, last).lastIndexOf(".");
        String className = qualifiedName.substring(mid + 1, last);
        JavaScriptUtil javaScriptUtil = new JavaScriptUtil(driver);

        if (result.getStatus() == ITestResult.STARTED) {
            System.out.println("***************************" + methodName + " started!************************************");
            ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
            extentTest.assignCategory(result.getTestContext().getSuite().getName());
            extentTest.assignCategory(className);
            test = extent.createTest(result.getMethod().getMethodName().toLowerCase());
            javaScriptUtil.generateAlert("Test Started");
        }

        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(MarkupHelper.createLabel(result.getName() + " The Test Case Failed", ExtentColor.RED));
            test.fail(result.getThrowable());
            javaScriptUtil.generateAlert("Test Failed");
            System.out.println("***************************Failed********************* " + (result.getMethod().getMethodName() + " ********************Failed******************"));
            System.out.println("***************************Failed********************* " + getTime(result.getEndMillis()) + " ********************Failed******************");
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass(MarkupHelper.createLabel(result.getName() + " The Test Case Passed", ExtentColor.GREEN));
            javaScriptUtil.generateAlert("Test Passed");
            System.out.println("***************************Passed********************* " + (result.getMethod().getMethodName() + " ********************Passed******************"));
            System.out.println("***************************Passed********************* " + getTime(result.getEndMillis()) + " ********************Passed******************");
            test.getModel().setEndTime(getTime(result.getEndMillis()));
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip(MarkupHelper.createLabel(result.getName() + " The Test Case Skipped", ExtentColor.YELLOW));
            test.skip(result.getThrowable());
            javaScriptUtil.generateAlert("Test Skipped");
            System.out.println("***************************Skipped********************* " + (result.getMethod().getMethodName() + " ********************Skipped******************"));
            System.out.println("***************************Skipped********************* " + getTime(result.getEndMillis()) + " ********************Skipped******************");

            try {
                test.skip(result.getThrowable(),
                        MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build());
            } catch (IOException e) {
                System.err.println("Exception thrown while updating test skip status " + Arrays.toString(e.getStackTrace()));
            }
            test.getModel().setEndTime(getTime(result.getEndMillis()));
        }
        extent.flush();

    }

    public void SendReport(String RecipientEmail) throws IOException {
        final String username = Utility.fetchProperty("HostEmail").toString();
        final String password = Utility.fetchProperty("HostPassword").toString();
        String emailID = Utility.fetchProperty(RecipientEmail).toString();

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");


        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailID));
            message.setSubject("Test Report");
            message.setText("Cicod");

            MimeBodyPart messageBodyPart = new MimeBodyPart();

            Multipart multipart = new MimeMultipart();

            messageBodyPart = new MimeBodyPart();
            File file = getTheNewestFile(System.getProperty("user.dir") + "\\Report\\","html");
            String fileName = "Cicod Test Report";
            DataSource source = new FileDataSource(file);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(fileName);
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);

            System.out.println("*************************************Sending Report******************************************");

            Transport.send(message);

            System.out.println("****************************************Done***************************************************");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public File getTheNewestFile(String filePath, String ext) {
        File theNewestFile = null;
        File dir = new File(filePath);
        FileFilter fileFilter = new WildcardFileFilter("*." + ext);
        File[] files = dir.listFiles(fileFilter);

        if (files.length > 0) {
            /** The newest file comes first **/
            Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
            theNewestFile = files[0];
        }

        return theNewestFile;
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }


    public String getScreenshot() {
        Path path = Paths.get(OUTPUT_FOLDER);
        // if directory exists?
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                // fail to create directory
                e.printStackTrace();
            }
        }

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path1 = System.getProperty("user.dir") + OUTPUT_FOLDER + System.currentTimeMillis() + FILE_NAME;
        File destination = new File(path1);
        try {
            FileUtils.copyFile(src, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path1;
    }

    @AfterClass
    public void tearDown() throws InterruptedException, IOException {
        if (driver != null)
            driver.quit();
    }


    @AfterTest
    public void AfterTest() throws IOException, InterruptedException {
        if (Boolean.parseBoolean(Utility.fetchProperty("SendReport").toString())) {
            SendReport("Reciever1");
            SendReport("gmail");
        } else {
            SendReport("Emax");
        }
    }
}
