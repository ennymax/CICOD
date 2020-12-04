package CROWN.EKEDC;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.io.IOException;

public class Remove_Primary_Account extends TestBase {

    @Test
    public void REMOVE_ACCOUNT() throws InterruptedException, IOException {
        Login login = new Login(driver);

        login.LoginEKEDC();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("AccountBTNEKE_XPATH"))).click();
        driver.findElement(By.xpath(Utility.fetchLocator("ManageAccountBTN_XPATH"))).click();

        Thread.sleep(1200);
        driver.findElement(By.xpath(Utility.fetchLocator("AddAccountBTN_XPATH"))).click();

        WebElement ele111 = driver.findElement(By.xpath(Utility.fetchLocator("AccountIndex_XPATH")));
        Select sel11 = new Select(ele111);
        sel11.selectByIndex(0);

        Thread.sleep(1200);
        driver.findElement(By.xpath(Utility.fetchLocator("AddAccountContinueBTN_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("AccountInput_XPATH"))).sendKeys(Utility.fetchLocator("NewAccount_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("CcontinueBTN_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AassertDetails_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Account Details was successfully Displayed");
        } else {
            test.log(Status.FAIL, "Account Details wasnt displayed");
        }

        Thread.sleep(2000);
        WebElement element5 = driver.findElement(By.xpath(Utility.fetchLocator("MakePrimaryBTN_XPATH")));
        JavascriptExecutor js5 = (JavascriptExecutor) driver;
        js5.executeScript("arguments[0].click();", element5);

        Thread.sleep(2000);

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("AddTheAccountBTN_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);
        WebElement element1 = driver.findElement(By.xpath(Utility.fetchLocator("AccountAccountBNT_XPATH")));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", element1);

        Thread.sleep(2000);
        WebElement element21 = driver.findElement(By.xpath(Utility.fetchLocator("MakeAAPrimary_XPATH")));
        JavascriptExecutor js21 = (JavascriptExecutor) driver;
        js21.executeScript("arguments[0].click();", element21);

        Thread.sleep(3000);
        WebElement element212 = driver.findElement(By.xpath(Utility.fetchLocator("AcceptPrimary_XPATH")));
        JavascriptExecutor js212 = (JavascriptExecutor) driver;
        js212.executeScript("arguments[0].click();", element212);


        Thread.sleep(3000);
        WebElement element2 = driver.findElement(By.xpath(Utility.fetchLocator("DeleteAccountBTN_XPATH")));
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].click();", element2);

        Thread.sleep(2000);
        WebElement element3 = driver.findElement(By.xpath(Utility.fetchLocator("DeleteACCT_XPATH")));
        JavascriptExecutor js3 = (JavascriptExecutor) driver;
        js3.executeScript("arguments[0].click();", element3);
    }
}
