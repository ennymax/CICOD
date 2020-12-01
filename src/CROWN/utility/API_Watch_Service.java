package CROWN.utility;

import CROWN.base.TestBase;
import com.aventstack.extentreports.Status;

import java.io.IOException;
import java.nio.file.*;

public class API_Watch_Service extends TestBase {

    public void ApiWatchService() throws InterruptedException, IOException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        final long NANOSEC_PER_SEC = 40*1000*1000;
        long startTime = System.nanoTime();
        Path directory = Paths.get("C:\\Users\\CROWN_STAFF\\Downloads");

        WatchKey watchKey = directory.register(watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);

        while ((System.nanoTime()-startTime)< 3*60*NANOSEC_PER_SEC){
            for (WatchEvent<?> event : watchKey.pollEvents()) {
                System.out.println(event.kind());
                Path file = directory.resolve((Path) event.context());
                System.out.println(file + " was last modified at " + file.toFile().lastModified());
                test.log(Status.PASS, file + "  was last modified at " + file.toFile().lastModified());
                test.log(Status.PASS, file + "  WAS DOWNLOADED SUCCESSFULLY");
            }
        }
    }

    public void ApiWatchServiceC() throws InterruptedException, IOException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        final long NANOSEC_PER_SEC = 40*1000*1000;
        long startTime = System.nanoTime();
        Path directory = Paths.get("C:\\Users\\CROWN_STAFF\\Downloads");

        WatchKey watchKey = directory.register(watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);

        while ((System.nanoTime()-startTime)< 3*60*NANOSEC_PER_SEC){
            for (WatchEvent<?> event : watchKey.pollEvents()) {
                System.out.println(event.kind());
                Path file = directory.resolve((Path) event.context());
                System.out.println(file + " was last modified at " + file.toFile().lastModified());
                test.log(Status.PASS, file + "  was last modified at " + file.toFile().lastModified());
                test.log(Status.PASS, file + "  WAS DOWNLOADED SUCCESSFULLY");
            }
        }
    }
}