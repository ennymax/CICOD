package CICOD.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ClickAll {

    WebDriver driver;

    public ClickAll(WebDriver driver) {
        this.driver = driver;
    }

    public void ClickAll(String locator) throws IOException, AWTException, InterruptedException {
        Thread.sleep(4000);
        Robot robot = new Robot();
        System.out.println("About to zoom out");
        for (int i = 0; i < 10; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

        List<WebElement> checkBoxList = driver.findElements(By.className(Utility.fetchLocator(locator)));
        checkBoxList.forEach(ele -> ele.click());
    }
}
