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

    public void ClickAll(String locator) throws IOException, AWTException {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
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

    public void ClickRandom(String locator) throws IOException, InterruptedException, AWTException {
        Thread.sleep(1200);
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        Robot robot = new Robot();
        List<WebElement> checkBoxList = driver.findElements(By.className(Utility.fetchLocator(locator)));
        System.out.println(checkBoxList.size());
        System.out.println("About to zoom out");
        for (int i = 0; i < 10; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

        for (int i = 0; i < checkBoxList.size(); i++) {
            Thread.sleep(599);
            SecureRandom rn = new SecureRandom();
            int st = rn.nextInt(checkBoxList.size());

            JavascriptExecutor jsl = (JavascriptExecutor) driver;
            jsl.executeScript("arguments[0].click();", checkBoxList.get(st));
            Thread.sleep(500);
            checkBoxList.get(st).click();
        }
    }
}
