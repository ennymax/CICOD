package CROWN.CICOD.WFM.ResourceAllocationManagement;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Randomstuff;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateResourceLevel extends TestBase {

    @Test
    public void CREATE_RESOURCE_LEVEL() throws IOException, InterruptedException {
        Login login = new Login(driver);
        Randomstuff randomStuff = new Randomstuff();

        login.LoginPremium();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Wfm_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ResourceManagement_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ManageResouceLevel_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("NewResouceLevel_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ResourceLevelName_XPATH"))).sendKeys(Utility.fetchLocator("High_TEXT") + randomStuff.RandomWords());

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ResourceLevelDiscription_XPATH"))).sendKeys(Utility.fetchLocator("Decrib_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("CreateResourceLevelBTN_XPATH"))).click();
        test.log(Status.PASS, "Resource Level Created Successfully");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ResourceLevelOKBTN_XPATH"))).click();
    }
}
