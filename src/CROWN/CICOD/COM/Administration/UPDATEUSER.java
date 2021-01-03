package CROWN.CICOD.COM.Administration;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.ScreenShot;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Description;
import org.testng.annotations.Test;
import java.io.IOException;

public class UPDATEUSER extends TestBase {

    @Description("Login")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1)
    public void login() throws IOException, InterruptedException {
        Login login = new Login(driver);
        login.Login();
    }

    @Description("Customer Order Management")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 2)
    public void CustomerOrderManagement() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        utility.DoclickWhenReady("com_XPATH", "comm_TEXT", 60);
    }

    @Description("Administration Module")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 3)
    public void AdministrationModule() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Adminbtn_XPATH"))).click();
    }

    @Description("User Management Button")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 4)
    public void UserManagementButton() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("UserManagementbtn_XPATH"))).click();
    }

    @Description("Update User")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 5)
    public void UpdateUser() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("UserAction_XPATH"))).click();

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("Update_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }


    @Description("Update First name")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 6)
    public void UpdateFirstname() throws IOException, InterruptedException {
        Thread.sleep(2000);
        ScreenShot screenShot = new ScreenShot(driver);
        screenShot.ScreenShot();
        WebElement ty = driver.findElement(By.xpath(Utility.fetchLocator("RFirsteName_XPATH")));
        ty.clear();
        ty.sendKeys(Utility.fetchLocator("CustomerFirstname_TEXT"));
    }

    @Description("Update Last name")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 7)
    public void UpdateLastname() throws IOException, InterruptedException {
        Thread.sleep(1000);
        WebElement tom = driver.findElement(By.xpath(Utility.fetchLocator("RLastName_XPATH")));
        tom.clear();
        tom.sendKeys(Utility.fetchLocator("CustomerLastName_TEXT"));
    }

    @Description("Update Phone Number")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 8)
    public void UpdatePhoneNumber() throws IOException, InterruptedException {
        Thread.sleep(1200);
        WebElement top = driver.findElement(By.xpath(Utility.fetchLocator("RPhoneNumber_XPATH")));
        top.clear();
        top.sendKeys(Utility.fetchLocator("CustomerPhoneNumber_TEXT"));
    }

    @Description("Update")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 9)
    public void Update() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("CreateUserSaveBTN_XPATH"))).click();
    }

    @Description("Assert Update User")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 10)
    public void AssertUpdateUser() throws IOException, InterruptedException {
        Thread.sleep(2000);
        WebElement msg11 = driver.findElement(By.xpath(Utility.fetchLocator("yyggg_XPATH")));
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains("User Updated")) {
            test.log(Status.PASS, "User was Updated Successfully");
        } else {
            test.log(Status.FAIL, "User Updated Successfully");
        }
    }
}
