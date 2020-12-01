package CROWN.CICOD.ModuleCOM.Administration;

import CROWN.base.TestBase;
import CROWN.utility.ClickAll;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.IOException;

public class UPDATE_ROLE extends TestBase {

    @Test
    public void UPDATE_ROLE() throws IOException, InterruptedException, AWTException {
        Login login = new Login(driver);
        ClickAll clickAll = new ClickAll(driver);

        login.Loginlupin();

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Adminbtn_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Rolemanagementbtn_XPATH"))).click();
        test.log(Status.PASS, "Role button fully Functional ");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("RoleActionbtn_XPATH"))).click();

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("RoleUpdatebtn_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        clickAll.ClickAll("aa_CLASS");

        Thread.sleep(1200);
        driver.findElement(By.xpath(Utility.fetchLocator("SaveRoleBTN_XPATH"))).click();

        Thread.sleep(2000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("assertUpdateRole_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Role was successfully Updated");
        } else {
            test.log(Status.FAIL, "Role cant be update");
        }

    }
}