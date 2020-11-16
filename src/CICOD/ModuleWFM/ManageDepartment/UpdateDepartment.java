package CICOD.ModuleWFM.ManageDepartment;

import CICOD.base.TestBase;
import CICOD.utility.Login;
import CICOD.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.SecureRandom;

public class UpdateDepartment extends TestBase {

    @Test
    public void CREATE_DEPARTMENT() throws IOException, InterruptedException {
        test = extent.createTest("SUSPEND UNSUSPEND DEPARTMENT");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        Login login = new Login(driver);
        SecureRandom rn = new SecureRandom();
        int tom = rn.nextInt(1500000) + 1;


        login.LoginPremium();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Wfm_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("UserManagement_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("DepartmentBTN_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ActionDep_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("UpdateDEP_XPATH"))).click();

        WebElement rr = driver.findElement(By.xpath(Utility.fetchLocator("TeamDescription_XPATH")));
        rr.clear();
        rr.sendKeys(Utility.fetchLocator("Decrib_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("savedep_XPATH"))).click();

        Thread.sleep(200);
        WebElement msg =(new WebDriverWait(driver, 45)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("AssertCreateDepartment_XPATH"))));
        String text = msg.getText();
        if (msg.isEnabled() && text.contains("Successful")) {
            test.log(Status.PASS, "New Department Created successfully");
        } else {
            test.log(Status.FAIL, "No department was created");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("OKBTN1_XPATH"))).click();

        driver.quit();
    }
}
