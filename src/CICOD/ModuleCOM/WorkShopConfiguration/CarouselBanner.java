package CICOD.ModuleCOM.WorkShopConfiguration;

import CICOD.base.TestBase;
import CICOD.utility.FileUpload;
import CICOD.utility.Login;
import CICOD.utility.ScreenShot;
import CICOD.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class CarouselBanner extends TestBase {

    @Test
    public void CAROUSEL_BANNER() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("CAROUSEL BANNER");
        FileUpload fileUpload = new FileUpload();
        Login login = new Login(driver);

        login.Login();

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("WorkShopConfiguration_XPATH"))).click();

        Thread.sleep(800);
        WebElement ti = driver.findElement(By.xpath(Utility.fetchLocator("WorkShopConfiguration_XPATH")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ti);

        Thread.sleep(900);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("CarouselBanner_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("AddCoruselBanner_XPATH"))).click();
        test.log(Status.PASS, "Add Carousel Banner was fully Functional");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Caption_XPATH"))).sendKeys(Utility.fetchLocator("Caption_TEXT"));
        test.log(Status.PASS, "Caption was Updated Successfully");

        Thread.sleep(1000);
        WebElement ele111c = driver.findElement(By.xpath(Utility.fetchLocator("DisplayLocation_XPATH")));
        Select sel11c = new Select(ele111c);
        sel11c.selectByIndex(1);

        Thread.sleep(999);
        driver.findElement(By.xpath(Utility.fetchLocator("OrderOfAppearance_XPATH"))).sendKeys(Utility.fetchLocator("OrderOfPreference_TEXT"));

        Thread.sleep(900);
        driver.findElement(By.xpath(Utility.fetchLocator("ActiUERL_XPATH"))).sendKeys(Utility.fetchLocator("ActionUrl_TEXT"));

        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath("//input[@type='file']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);

        Thread.sleep(2000);
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath("//input[@type='file']"))).click().build().perform();

        Thread.sleep(4000);
        fileUpload.UploadFileImage3MB();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("CarouselSaveBtn_XPATH"))).click();
        test.log(Status.PASS, "Carousel Banner was Created Successfully");

        Thread.sleep(2000);
        assertEquals("×\n" + "Frontend Banner Carousel created", driver.findElement(By.xpath(Utility.fetchLocator("AssertBanner_XPATH"))).getText());
        test.log(Status.PASS, "Frontend Banner Carousel created");
    }
}
