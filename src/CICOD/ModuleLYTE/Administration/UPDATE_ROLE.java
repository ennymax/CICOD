package CICOD.ModuleLYTE.Administration;

import CICOD.base.TestBase;
import CICOD.utility.Login;
import CICOD.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class UPDATE_ROLE extends TestBase {

    @Test
    public void UPDATE_ROLE() throws IOException, InterruptedException{
        test = extent.createTest("UPDATE ROLE");
        Login login = new Login(driver);

        login.LoginTestAccount();

        //COM
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("AdminLyte_XPATH"))).click();

        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("RoleLyte_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();

        driver.findElement(By.xpath(Utility.fetchLocator("RoleActionbtn_XPATH"))).click();

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("RoleUpdatebtn_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        driver.findElement(By.xpath(Utility.fetchLocator("rolesaveLyte_XPATH"))).click();
    }
}
