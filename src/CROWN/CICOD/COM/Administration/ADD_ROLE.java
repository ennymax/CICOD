package CROWN.CICOD.COM.Administration;

import CROWN.Base.TestBase;
import CROWN.utility.*;
import com.aventstack.extentreports.Status;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class ADD_ROLE extends TestBase {

    @Test(priority = 1)
    public void login() throws IOException, InterruptedException {
        Login login = new Login(driver);
        login.Login();
    }

    @Test(priority = 2)
    public void CustomerOrderManagement() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        utility.DoclickWhenReady("com_XPATH", "comm_TEXT", 60);
    }

    @Test(priority = 3)
    public void AdministrationModule() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Adminbtn_XPATH"))).click();
    }

    @Test(priority = 4)
    public void RoleManagement() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Rolemanagementbtn_XPATH"))).click();
    }

    @Test(priority = 5)
    public void AddRoleButton() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("AddRolebtn_XPATH"))).click();
    }

    @Test(priority = 6)
    public void RoleName() throws IOException, InterruptedException {
        Thread.sleep(1200);
        Randomstuff randomstuff = new Randomstuff();
        driver.findElement(By.xpath(Utility.fetchLocator("RoleName_XPATH"))).sendKeys(randomstuff.ListRandom());
    }

    @Test(priority = 7)
    public void ClickAll() throws IOException, InterruptedException, AWTException {
        ClickAll clickAll = new ClickAll(driver);
        clickAll.ClickAll("aa_CLASS");
    }

    @Test(priority = 8)
    public void AddButton() throws IOException, InterruptedException, AWTException {
        Thread.sleep(2000);
        ScreenShot screenShot = new ScreenShot(driver);
        screenShot.ScreenShotFullPage();
        driver.findElement(By.xpath(Utility.fetchLocator("Roleaa_XPATH"))).click();
    }

    @Test(priority = 9)
    public void AssertAddRole() throws IOException, InterruptedException, AWTException {
        Thread.sleep(2000);
        WebElement msg11 = driver.findElement(By.xpath(Utility.fetchLocator("AlertRoleSSS_XPATH")));
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains("Role Saved")) {
            test.log(Status.PASS, "ROle has been Added Successfully");
        } else {
            test.log(Status.FAIL, "Fail to Add Role");
        }
    }
}
