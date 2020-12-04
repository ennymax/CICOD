package CROWN.CICOD.UCG;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class SearchSettlementReportUsingIncorrectCredentials extends TestBase {

    @Test
    public void SEARCH_SETTLEMENT_REPORT_WITH_INCORRECT_CREDENTIALS() throws IOException, InterruptedException {
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
        WebElement jjl = driver.findElement(By.xpath(Utility.fetchLocator("SearchSettlement_XPATH")));
        jjl.clear();
        jjl.sendKeys(Utility.fetchLocator("WTransactionID_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SearchBTN1_XPATH"))).click();

        Thread.sleep(3000);
        WebElement jjla = driver.findElement(By.xpath(Utility.fetchLocator("SearchSettlement_XPATH")));
        jjla.clear();
        jjla.sendKeys(Utility.fetchLocator("WInvoiceNumber_TEXT"));

        Thread.sleep(1200);
        driver.findElement(By.xpath(Utility.fetchLocator("SearchBTN1_XPATH"))).click();
    }
}
