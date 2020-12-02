package CROWN.CICOD.COM.Settings;

import CROWN.base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.io.IOException;

public class THEME_AND_CONFIG extends TestBase {

    @Test
    public void THEME_CONFIG() throws IOException, InterruptedException {
        Login login = new Login(driver);

        login.Login();

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Settings_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("WebshopSettings_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("WorkShopConfiguration_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("UpdateTheme_XPATH"))).click();
        test.log(Status.PASS, "Theme Update page was Displayed successfully");

        Thread.sleep(1000);
        WebElement ele111c = driver.findElement(By.xpath(Utility.fetchLocator("StoreLocation_XPATH")));
        Select sel11c = new Select(ele111c);
        sel11c.selectByIndex(1);

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("ThemeSaveBTN_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(3000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("assertThemeUpdate_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Theme was saved Successfully");
        } else {
            test.log(Status.FAIL, "Theme cant be updated");
        }
    }
}
