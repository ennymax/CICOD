package CROWN.CICOD.ModuleUCG;

import CROWN.base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;

public class FilterPendingCollectionsInCorrectCredentials extends TestBase {

    @Test
    public void FILTER_PENDING_COLLECTION_WITH_INCORRECT_CREDENTIALS() throws IOException, InterruptedException {
        Login login = new Login(driver);

        login.LoginCorrectDetails();

        Thread.sleep(1200);
        driver.findElement(By.xpath(Utility.fetchLocator("UcgBTN_XPATH"))).click();

        Thread.sleep(1200);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("CollectionBTN_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(1200);
        WebElement element1 = driver.findElement(By.xpath(Utility.fetchLocator("PendingCollection_XPATH")));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", element1);

        Thread.sleep(1200);
        //SEARCH WITH INVOICE NUMBER
        WebElement ele11p = driver.findElement(By.xpath(Utility.fetchLocator("DropDown_XPATH")));
        Select sel1p = new Select(ele11p);
        sel1p.selectByVisibleText("INVOICE NO");

        Thread.sleep(1200);
        WebElement jjla = driver.findElement(By.xpath(Utility.fetchLocator("SearchCollectionInputBox_XPATH")));
        jjla.clear();
        jjla.sendKeys(Utility.fetchLocator("WInvoiceNumber_TEXT"));

        Thread.sleep(1200);
        WebElement elementPPO = driver.findElement(By.xpath(Utility.fetchLocator("jj_XPATH")));
        JavascriptExecutor jsPPO = (JavascriptExecutor) driver;
        jsPPO.executeScript("arguments[0].click();", elementPPO);

        Thread.sleep(1200);
        WebElement Elementlbb = driver.findElement(By.xpath(Utility.fetchLocator("AllCollectionPage_XPATH")));
        JavascriptExecutor jsklbb = (JavascriptExecutor) driver;
        jsklbb.executeScript("arguments[0].scrollIntoView();", Elementlbb);
    }
}