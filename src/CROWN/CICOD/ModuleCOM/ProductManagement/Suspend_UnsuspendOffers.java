package CROWN.CICOD.ModuleCOM.ProductManagement;

import CROWN.base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.IOException;
import java.security.SecureRandom;

public class Suspend_UnsuspendOffers extends TestBase {
    @Test
    public void Suspend_Unsuspend_Offers_Settings() throws IOException, InterruptedException, AWTException {
        Login login = new Login(driver);
        SecureRandom rn = new SecureRandom();

        login.Login();

        //Com
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        //product Management
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ProductManagementbtn_XPATH"))).click();

        Thread.sleep(2000);
        WebElement ti11o = driver.findElement(By.xpath(Utility.fetchLocator("OffersBTN_XPATH")));
        JavascriptExecutor jseo = (JavascriptExecutor) driver;
        jseo.executeScript("arguments[0].scrollIntoView();", ti11o);
        ti11o.click();

        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("OfferActionBTN_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SuspendOfferbtn_XPATH"))).click();

        login.AcceptAlert();

        Thread.sleep(2000);
        WebElement msg1 = driver.findElement(By.xpath(Utility.fetchLocator("aSS_XPATH")));
        String text1 = msg1.getText();
        if (msg1.isEnabled() && text1.contains("Offer Settings suspended")) {
            test.log(Status.PASS, "Offer Settings suspended");
        } else {
            test.log(Status.FAIL, "Offer Settings suspension failed ");
        }

        Thread.sleep(2000);
        WebElement ti1 = driver.findElement(By.xpath(Utility.fetchLocator("OfferActionBTN_XPATH")));
        JavascriptExecutor jsek = (JavascriptExecutor) driver;
        jsek.executeScript("arguments[0].scrollIntoView();", ti1);
        ti1.click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("UnsuspendOffer_XPATH"))).click();

        login.AcceptAlert();

        Thread.sleep(2000);
        WebElement msg11 = driver.findElement(By.xpath(Utility.fetchLocator("aSS_XPATH")));
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains("Offer Settings unsuspended")) {
            test.log(Status.PASS, "Offer Setting was unsuspended");
        } else {
            test.log(Status.FAIL, "Unsuspension failed");
        }

    }
}
