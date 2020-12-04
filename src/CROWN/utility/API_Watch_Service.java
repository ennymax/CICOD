package CROWN.utility;

import CROWN.Base.TestBase;
import com.aventstack.extentreports.Status;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class API_Watch_Service extends TestBase {

    public void ApiWatchService() throws InterruptedException, IOException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        final long NANOSEC_PER_SEC = 40 * 1000 * 1000;
        long startTime = System.nanoTime();
        Path directory = Paths.get("C:\\Users\\CROWN_STAFF\\Downloads");

        WatchKey watchKey = directory.register(watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);

        while ((System.nanoTime() - startTime) < 3 * 60 * NANOSEC_PER_SEC) {
            for (WatchEvent<?> event : watchKey.pollEvents()) {
                System.out.println(event.kind());
                Path file = directory.resolve((Path) event.context());
                System.out.println(file + " was last modified at " + file.toFile().lastModified());
                test.log(Status.PASS, file + "  was last modified at " + file.toFile().lastModified());
                test.log(Status.PASS, file + "  WAS DOWNLOADED SUCCESSFULLY");
            }
        }
    }

    public void Timer() {
        final long NANOSEC_PER_SEC = 400000 * 100000 * 100000;
        long startTime = System.nanoTime();
        while ((System.nanoTime() - startTime) < 3 * 60 * NANOSEC_PER_SEC) {

            java.util.List<String> files = new ArrayList<String>();
            files.add( System.getProperty("user.dir")  + "\\CICOD\\src\\TestNG\\CICOD\\COM\\testngA.xml");
            XmlSuite suite = new XmlSuite();
            suite.setSuiteFiles(files);
            List<XmlSuite> suites = new ArrayList<XmlSuite>();
            suites.add(suite);
            TestNG tng = new TestNG();
            tng.setXmlSuites(suites);
            tng.run();
        }
    }
}