package CICOD.ModuleCOM.ProductManagement;

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

import static org.testng.AssertJUnit.assertEquals;

public class SUSPEND_UNSUSPEND_PRODUCTS extends TestBase {

    @Test
    public void SUSPEND_UNSUSPEND_PRODUCT() throws IOException, InterruptedException {
        test = extent.createTest("SUSPEND UNSUSPEND PRODUCT");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        Login login = new Login(driver);

        login.Login();
        test.log(Status.PASS, "Login Was Successful");

        //Com
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

        //product Management
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ProductManagementbtn_XPATH"))).click();
        test.log(Status.PASS, "Product Management button fully functional");

        //Click On Product
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Productbtn_XPATH"))).click();
        test.log(Status.PASS, "Product button fully Functional");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ActionSuspendbtn_XPATH"))).click();

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("Suspendbtn_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        Thread.sleep(2000);
        WebElement msg1 = driver.findElement(By.xpath(Utility.fetchLocator("Assertsusp_XPATH")));
        String text1 = msg1.getText();
        if (msg1.isEnabled() && text1.contains("Product suspended")) {
            test.log(Status.PASS, "Product suspended successfully");
        } else {
            test.log(Status.FAIL, "suspension Failed");
        }

        Thread.sleep(1500);
        WebElement k = driver.findElement(By.xpath(Utility.fetchLocator("ActionSuspendbtn_XPATH")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", k);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ActionSuspendbtn_XPATH"))).click();

        Thread.sleep(2000);
        WebElement element2 = driver.findElement(By.xpath(Utility.fetchLocator("Suspendbtn_XPATH")));
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].click();", element2);

        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        Thread.sleep(2000);
        assertEquals("×\n" + "Product unsuspended", driver.findElement(By.xpath(Utility.fetchLocator("Assertsusp_XPATH"))).getText());
        test.log(Status.PASS, "Product Unsuspended successfully");

        System.out.println("********************SUSPEND PRODUCT TEST IS COMPLETED********************");
        driver.quit();
    }
}
