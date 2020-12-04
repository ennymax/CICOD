package CROWN.CICOD.UCG;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.ScreenShot;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;

public class FilterAllCollectionByProvider extends TestBase {

    @Test
    public void FILTER_ALL_COLLECTION_USING_PROVIDERS() throws IOException, InterruptedException {
        ScreenShot screenShot = new ScreenShot(driver);
        Login login = new Login(driver);

        login.LoginCorrectDetails();

        Thread.sleep(1200);
        driver.findElement(By.xpath(Utility.fetchLocator("UcgBTN_XPATH"))).click();

        Thread.sleep(1000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("CollectionBTN_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(1000);
        WebElement element1 = driver.findElement(By.xpath(Utility.fetchLocator("AllCollectionBTN_XPATH")));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", element1);

        Thread.sleep(1000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AllCollectionPage_XPATH"))).size() != 0) {
            test.log(Status.PASS, "All Collection Page Displayed");
        } else {
            test.log(Status.FAIL, "All Collection Page not Displayed");
        }

        Thread.sleep(1200);
        WebElement Element1 = driver.findElement(By.xpath(Utility.fetchLocator("AllCollectionPage_XPATH")));
        JavascriptExecutor jsk1 = (JavascriptExecutor) driver;
        jsk1.executeScript("arguments[0].scrollIntoView();", Element1);

        //FILTER BY CASH
        WebElement ele11 = driver.findElement(By.xpath(Utility.fetchLocator("Privders_XPATH")));
        Select sel1 = new Select(ele11);
        sel1.selectByVisibleText("CASH");

        WebElement jj = driver.findElement(By.xpath(Utility.fetchLocator("UCGStartDate_XPATH")));
        jj.clear();
        jj.sendKeys(Utility.fetchLocator("Date_TEXT"));

        Thread.sleep(1200);
        driver.findElement(By.xpath(Utility.fetchLocator("DisplayBTN_XPATH"))).click();

        Thread.sleep(1200);
        WebElement Element = driver.findElement(By.xpath(Utility.fetchLocator("AllCollectionPage_XPATH")));
        JavascriptExecutor jsk = (JavascriptExecutor) driver;
        jsk.executeScript("arguments[0].scrollIntoView();", Element);

        //FILTER BY FLUTERWAVE
        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("filterscrowltoview_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);

        Thread.sleep(2000);
        WebElement ele11p = driver.findElement(By.xpath(Utility.fetchLocator("Privders_XPATH")));
        Select sel1p = new Select(ele11p);
        sel1p.selectByVisibleText("FLUTTERWAVE");

        Thread.sleep(2000);
        WebElement jjl = driver.findElement(By.xpath(Utility.fetchLocator("UCGStartDate_XPATH")));
        jjl.clear();
        jjl.sendKeys(Utility.fetchLocator("Date_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("DisplayBTN_XPATH"))).click();

        Thread.sleep(2000);
        WebElement Elementl = driver.findElement(By.xpath(Utility.fetchLocator("AllCollectionPage_XPATH")));
        JavascriptExecutor jskl = (JavascriptExecutor) driver;
        jskl.executeScript("arguments[0].scrollIntoView();", Elementl);

        Thread.sleep(3000);
        WebElement ele11pm = driver.findElement(By.xpath(Utility.fetchLocator("Privders_XPATH")));
        Select sel1pm = new Select(ele11p);
        sel1pm.selectByVisibleText("INTERSWITCH");

        Thread.sleep(2000);
        WebElement jjlm = driver.findElement(By.xpath(Utility.fetchLocator("UCGStartDate_XPATH")));
        jjlm.clear();
        jjlm.sendKeys(Utility.fetchLocator("Date_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("DisplayBTN_XPATH"))).click();

        Thread.sleep(2000);
        screenShot.ScreenShotFullPage();

        Thread.sleep(1200);
        WebElement ElementlN = driver.findElement(By.xpath(Utility.fetchLocator("AllCollectionPage_XPATH")));
        JavascriptExecutor jsklN = (JavascriptExecutor) driver;
        jsklN.executeScript("arguments[0].scrollIntoView();", ElementlN);
    }
}
