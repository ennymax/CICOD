package CROWN.CICOD.WFM.EscalationConfiguration;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import com.mifmif.common.regex.Generex;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;

public class UpdateRegionToRole extends TestBase {

    String regex = "\\w{10}\\@gmail\\.com";
    String regex1 = "2637(1|3|7|8)\\d{7}";

    @Test
    public void UPDATE_ESCALATION_ROLE() throws IOException, InterruptedException {
        Login login = new Login(driver);

        login.LoginPremium();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Wfm_XPATH"))).click();

        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("EscalationMainMenue_XPATH"))).click();

        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("RegionToRoleBTN_XPATH"))).click();

        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("RegiontoRoleActionBTN_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("UpdateRegionToRole_XPATH"))).click();

        Thread.sleep(2000);
        WebElement as = driver.findElement(By.xpath(Utility.fetchLocator("RegionEmail_XPATH")));
        as.clear();
        as.sendKeys(new Generex(regex).random());

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("CreateRegionToRole_XPATH"))).click();

        Thread.sleep(2000);
        WebElement msg =(new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("AssertUpdateRegiontorole_XPATH"))));
        String text = msg.getText();
        if (msg.isEnabled() && text.contains("Successful")) {
            test.log(Status.PASS, "Update was successful");
        } else {
            test.log(Status.FAIL, "Update failed");
        }

        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("OKBTN6_XPATH"))).click();
    }
}
