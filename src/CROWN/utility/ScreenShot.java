package CROWN.utility;

import CROWN.base.TestBase;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenShot extends TestBase {

    WebDriver driver;

    public ScreenShot(WebDriver driver) {
        this.driver = driver;
    }

    private static final String OUTPUT_FOLDER = "./Screenshot/";
    private static final String FILE_NAME = "Screenshot" + System.currentTimeMillis() + ".png";

    public void ScreenShotWebElement(String locator, int timeOut) throws IOException, InterruptedException {
        Path path = Paths.get(OUTPUT_FOLDER);
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                // fail to create directory
                e.printStackTrace();
            }
        }
        Utility utility = new Utility(driver);
        utility.DowaitForElementWithFluentWait(locator, timeOut);
        String extentReportImageqm11 =System.getProperty("user.dir") + OUTPUT_FOLDER + "System.currentTimeMillis()" + FILE_NAME;
        WebElement logo = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullScreen = ImageIO.read(screenshot);
        Point location = logo.getLocation();
        int width = logo.getSize().getWidth();
        int height = logo.getSize().getHeight();

        BufferedImage logoImage = fullScreen.getSubimage(location.getX(), location.getY(), width, height);
        ImageIO.write(logoImage, "png", screenshot);
        FileUtils.copyFile(screenshot, new File(extentReportImageqm11));
        test.log(Status.INFO, "Screenshot from : " + extentReportImageqm11, MediaEntityBuilder.createScreenCaptureFromPath(extentReportImageqm11).build());

    }

    public void ScreenShot() throws IOException, InterruptedException {
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
        Thread.sleep(1000);
        String extentReportImageqm11 = System.getProperty("user.dir") + OUTPUT_FOLDER + System.currentTimeMillis()+ FILE_NAME;
        File srcam11 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            // now copy the screenshot to desired location using copyFile method
            FileUtils.copyFile(srcam11, new File(extentReportImageqm11));
            test.log(Status.INFO, "Screenshot from : " + extentReportImageqm11, MediaEntityBuilder.createScreenCaptureFromPath(extentReportImageqm11).build());
        } catch (IOException e) {
            System.out.println("Error in the captureAndDisplayScreenShot method: " + e.getMessage());
        }
    }

    public String ScreenShotFullPageTestBase() throws IOException, InterruptedException {
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
        Thread.sleep(1000);
        String extentReportImageqm11 =System.getProperty("user.dir") + OUTPUT_FOLDER + System.currentTimeMillis()+FILE_NAME;
        Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(),"PNG",new File(extentReportImageqm11));
        test.log(Status.INFO, "Screenshot from : " + extentReportImageqm11, MediaEntityBuilder.createScreenCaptureFromPath(extentReportImageqm11).build());
        return extentReportImageqm11;
    }

    public void ScreenShotFullPage() throws IOException, InterruptedException {
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
        Thread.sleep(1000);
        String extentReportImageqm11 =System.getProperty("user.dir") + OUTPUT_FOLDER + System.currentTimeMillis()+FILE_NAME;
        Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(),"PNG",new File(extentReportImageqm11));
        test.log(Status.INFO, "Screenshot from : " + extentReportImageqm11, MediaEntityBuilder.createScreenCaptureFromPath(extentReportImageqm11).build());
    }

}