package CROWN.CICOD.LYTE.Administration;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class AddUser extends TestBase {

    @Test
    public void ADD_USER() throws IOException, InterruptedException {
        Login login = new Login(driver);

        login.LoginTestAccount();

        //COM
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("AdminLyte_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("UserManagementLYTE_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("AddUserbtn_XPATH"))).click();

        Thread.sleep(1000);
        WebElement ele111c = driver.findElement(By.xpath(Utility.fetchLocator("Role_XPATH")));
        Select sel11c = new Select(ele111c);
        sel11c.selectByIndex(1);

        Thread.sleep(1000);
        WebElement ele111ca = driver.findElement(By.xpath(Utility.fetchLocator("Region_XPATH")));
        Select sel11ca = new Select(ele111ca);
        sel11ca.selectByIndex(1);

        driver.findElement(By.xpath(Utility.fetchLocator("RFirsteName_XPATH"))).sendKeys(Utility.fetchLocator("CustomerFirstname_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("RLastName_XPATH"))).sendKeys(Utility.fetchLocator("CustomerLastName_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("RPhoneNumber_XPATH"))).sendKeys(Utility.fetchLocator("CustomerPhoneNumber_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("REmail_XPATH"))).sendKeys(Utility.fetchLocator("CustomerEmail_TEXT"));

        driver.findElement(By.xpath(Utility.fetchLocator("CreateUserSaveBTN_XPATH"))).click();

        WebElement msg11 = driver.findElement(By.xpath(Utility.fetchLocator("qqq_XPATH")));
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains("Error creating user: \"MAXIMUM_USER_LICENSE_REACHED\"")) {
            test.log(Status.PASS, "Add User fully Functional");
        } else {
            test.log(Status.FAIL, "Add User ModuleEKEDC failed");
        }
    }
}
