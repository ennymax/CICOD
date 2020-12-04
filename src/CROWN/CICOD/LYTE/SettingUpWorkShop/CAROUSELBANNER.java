package CROWN.CICOD.LYTE.SettingUpWorkShop;

import CROWN.Base.TestBase;
import CROWN.utility.FileUpload;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class CAROUSELBANNER extends TestBase {
    @Test
    public void CAROUSEL_BANNER() throws IOException, InterruptedException, AWTException {
        FileUpload fileUpload = new FileUpload();
        Login login = new Login(driver);

        login.LoginTestAccount();

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("WebshopandConfLyte_XPATH"))).click();

        WebElement ti = driver.findElement(By.xpath(Utility.fetchLocator("WebshopandConfLyte_XPATH")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ti);

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("CarouselLyte_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("AddCoruselBanner_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Caption_XPATH"))).sendKeys(Utility.fetchLocator("Caption_TEXT"));

        Thread.sleep(1000);
        WebElement ele111c = driver.findElement(By.xpath(Utility.fetchLocator("DisplayLocation_XPATH")));
        Select sel11c = new Select(ele111c);
        sel11c.selectByIndex(1);

        driver.findElement(By.xpath(Utility.fetchLocator("OrderOfAppearance_XPATH"))).sendKeys(Utility.fetchLocator("OrderOfPreference_TEXT"));
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
    }
}
