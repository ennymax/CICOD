package CROWN.CICOD.COM.Account;

import CROWN.base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class ViewCreditNote extends TestBase {
    @Test
    public void View_Credit_Note() throws IOException, InterruptedException, AWTException {
        Login login = new Login(driver);

        login.Login();

        //Com
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("AccountBTN_XPATH")))).click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("CreditNote_XPATH")))).click();


        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("cAction_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();

        Thread.sleep(1200);
        driver.findElement(By.xpath(Utility.fetchLocator("CView_XPATH"))).click();

        Thread.sleep(2000);
        assertEquals("Credit Note", driver.findElement(By.xpath(Utility.fetchLocator("AssertViewCrerditNote_XPATH"))).getText());
        test.log(Status.PASS, "Credit Note can be Viewed");
    }
}
