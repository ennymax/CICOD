package CROWN.Base;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Time {

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        while (true) {
            if (System.currentTimeMillis() == 0) {
                System.out.println("Starting TestScheduled for " + LocalDateTime.now().getHour());
                StartTest();
            }
            if (System.currentTimeMillis() == 10800000) {
                System.out.println("Starting TestScheduled for " + LocalDateTime.now().getHour());
                StartTest();
            }
            if (System.currentTimeMillis() == 21600000) {
                System.out.println("Starting TestScheduled for " + LocalDateTime.now().getHour());
                StartTest();
            }
            if (System.currentTimeMillis() == 32400000) {
                System.out.println("Starting TestScheduled for " + LocalDateTime.now().getHour());
                StartTest();
            }
            if (System.currentTimeMillis() == 43200000) {
                System.out.println("Starting TestScheduled for " + LocalDateTime.now().getHour());
                StartTest();
            }
            if (System.currentTimeMillis() == 54000000) {
                System.out.println("Starting TestScheduled for " + LocalDateTime.now().getHour());
                StartTest();
            }
            if (System.currentTimeMillis() == 64800000) {
                System.out.println("Starting TestScheduled for " + LocalDateTime.now().getHour());
                StartTest();
            }
            if (System.currentTimeMillis() == 75600000) {
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
