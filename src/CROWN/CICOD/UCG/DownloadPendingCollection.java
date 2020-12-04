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

public class DownloadPendingCollection extends TestBase {
    @Test
    public void DOWNLOAD_PENDING_COLLECTION() throws IOException, InterruptedException {
        Login login = new Login(driver);

        login.LoginCorrectDetails();

        Thread.sleep(1200);
        driver.findElement(By.xpath(Utility.fetchLocator("UcgBTN_XPATH"))).click();

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("CollectionBTN_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);
        WebElement element1 = driver.findElement(By.xpath(Utility.fetchLocator("PendingCollection_XPATH")));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", element1);

        Thread.sleep(2000);
        WebElement element13 = driver.findElement(By.xpath(Utility.fetchLocator("DownloadCollectionBTN_XPATH")));
        JavascriptExecutor js13 = (JavascriptExecutor) driver;
        js13.executeScript("arguments[0].click();", element13);

        Thread.sleep(2000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertSentEmail_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Report Sent To mail was Displayed");
        } else {
            test.log(Status.FAIL, "Report Sent Mail was not Displayed");
        }

        Thread.sleep(200);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertSentEmail_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Download was successful");
        } else {
            test.log(Status.FAIL, "Download was Failed");
        }
    }
}
