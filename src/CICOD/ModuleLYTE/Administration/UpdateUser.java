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

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class UpdateUser extends TestBase {

    @Test
    public void UPDATE_USER() throws IOException, InterruptedException {
        test = extent.createTest("UPDATE USER");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        Login login = new Login(driver);

        login.LoginTestAccount();
        test.log(Status.PASS, "Login Was Successful");

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("AdminLyte_XPATH"))).click();
        test.log(Status.PASS, "Administration button Fully functional");

        driver.findElement(By.xpath(Utility.fetchLocator("UserManagementLYTE_XPATH"))).click();
        test.log(Status.PASS, "Administration button Fully functional");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("UserAction_XPATH"))).click();

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("Update_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        driver.findElement(By.xpath(Utility.fetchLocator("RFirsteName_XPATH"))).sendKeys(Utility.fetchLocator("CustomerFirstname_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("RLastName_XPATH"))).sendKeys(Utility.fetchLocator("CustomerLastName_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("RPhoneNumber_XPATH"))).sendKeys(Utility.fetchLocator("CustomerPhoneNumber_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("CreateUserSaveBTN_XPATH"))).click();

        System.out.println("********************UPDATE USER TEST IS COMPLETED********************");
        driver.quit();
    }
}
