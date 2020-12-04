package CROWN.CICOD.UCG;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class ViewSettlementReport extends TestBase {
    @Test
    public void VIEW_SETTLEMENT_REPORT() throws IOException, InterruptedException {
        Login login = new Login(driver);

        login.LoginCorrectDetails();

        Thread.sleep(1200);
        driver.findElement(By.xpath(Utility.fetchLocator("UcgBTN_XPATH"))).click();

        Thread.sleep(1200);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("CollectionBTN_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(1200);
        WebElement element1 = driver.findElement(By.xpath(Utility.fetchLocator("SettlementReport_XPATH")));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", element1);

        Thread.sleep(1200);
        if (driver.findElements(By.xpath(Utility.fetchLocator("SettlementScrowlView_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Settlement report Page was Displayed");
        } else {
            test.log(Status.FAIL, "Settlement report Page wasn't Displayed");
        }

        Thread.sleep(1200);
        WebElement Elementlb = driver.findElement(By.xpath(Utility.fetchLocator("SettlementScrowlView_XPATH")));
        JavascriptExecutor jsklb = (JavascriptExecutor) driver;
        jsklb.executeScript("arguments[0].scrollIntoView();", Elementlb);
    }
}
