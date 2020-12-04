package CROWN.Base;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Time {

    public static void main(String[] args) {
        while (true) {
            System.out.println(LocalDateTime.now().getHour());
            if (LocalDateTime.now().getHour() == 24) {
                System.out.println("Starting TestScheduled for " + LocalDateTime.now().getHour());
                StartTest();
            }
            if (LocalDateTime.now().getHour() == 3) {
                System.out.println("Starting TestScheduled for " + LocalDateTime.now().getHour());
                StartTest();
            }
            if (LocalDateTime.now().getHour() == 6) {
                System.out.println("Starting TestScheduled for " + LocalDateTime.now().getHour());
                StartTest();
            }
            if (LocalDateTime.now().getHour() == 9) {
                System.out.println("Starting TestScheduled for " + LocalDateTime.now().getHour());
                StartTest();
            }
            if (LocalDateTime.now().getHour() == 12) {
                System.out.println("Starting TestScheduled for " + LocalDateTime.now().getHour());
                StartTest();
            }
            if (LocalDateTime.now().getHour() == 15) {
                System.out.println("Starting TestScheduled for " + LocalDateTime.now().getHour());
                StartTest();
            }
            if (LocalDateTime.now().getHour() == 18) {
                System.out.println("Starting TestScheduled for " + LocalDateTime.now().getHour());
                StartTest();
            }
            if (LocalDateTime.now().getHour() == 21) {
                System.out.println("Starting TestScheduled for " + LocalDateTime.now().getHour());
                StartTest();
            }
        }
    }


    public static void StartTest() {
        java.util.List<String> files = new ArrayList<String>();
        files.add(System.getProperty("user.dir") + "\\src\\TestNG\\CICOD\\COM\\testngA.xml");
        XmlSuite suite = new XmlSuite();
        suite.setSuiteFiles(files);
        List<XmlSuite> suites = new ArrayList<XmlSuite>();
        suites.add(suite);
        TestNG tng = new TestNG();
        tng.setXmlSuites(suites);
        tng.run();
    }
}
