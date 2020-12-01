package CROWN.utility;

import org.openqa.selenium.StaleElementReferenceException;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class FileDownload {

    public void FireFoxDownloader() throws IOException, InterruptedException, AWTException {
        try {
            Robot robot = new Robot();
            Thread.sleep(3000);
            robot.keyRelease(KeyEvent.VK_DOWN);

            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_TAB);

            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_ENTER);

        } catch (StaleElementReferenceException e) {
            System.out.println("");
        }
    }
}
