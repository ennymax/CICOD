package CROWN.CICOD.COM.DashBoard;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;

public class SalesTargetDashBoard extends TestBase {
    @Test
    public void SALES_TARGET_DASHBOARD() throws IOException, InterruptedException {
        Login login = new Login(driver);

        login.Login();

        //Com
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("SaleTarget_XPATH")))).click();

        WebElement msg = driver.findElement(By.xpath(Utility.fetchLocator("AssertSalesTarget_XPATH")));
        String text = msg.getText();
        if (msg.isEnabled() && text.contains("Annual sales targe")) {
            test.log(Status.PASS, "Annual Sales Target is displayed");
        } else {
            test.log(Status.FAIL, "Annual sales target is not displayed");
        }

        Thread.sleep(2000);
        WebElement Element11 = driver.findElement(By.xpath(Utility.fetchLocator("AssertTodaysTarget_XPATH")));
        JavascriptExecutor jsk11 = (JavascriptExecutor) driver;
        jsk11.executeScript("arguments[0].scrollIntoView();", Element11);

        WebElement msg1 = driver.findElement(By.xpath(Utility.fetchLocator("AssertTodaysTarget_XPATH")));
        String text1 = msg1.getText();
        if (msg1.isEnabled() && text1.contains("Todays Target")) {
            test.log(Status.PASS, "Today Sales Target is displayed");
        } else {
            test.log(Status.FAIL, "Today sales target is not displayed");
        }

        WebElement msg2 = driver.findElement(By.xpath(Utility.fetchLocator("AssertWeeksTarget_XPATH")));
        String text2 = msg2.getText();
        if (msg2.isEnabled() && text2.contains("Week Target")) {
            test.log(Status.PASS, "Weekly Sales Target is displayed");
        } else {
            test.log(Status.FAIL, "Weekly sales target is not displayed");
        }

        WebElement msg3 = driver.findElement(By.xpath(Utility.fetchLocator("AssertQuaterTarget_XPATH")));
        String text3 = msg3.getText();
        if (msg3.isEnabled() && text3.contains("Week Target")) {
            test.log(Status.PASS, "Quarterly Sales Target is displayed");
        } else {
            test.log(Status.FAIL, "Quarterly sales target is not displayed");
        }

        Thread.sleep(2000);
        WebElement tom = (new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("FilterSalesTargetStartDate_XPATH"))));
        tom.clear();
        tom.sendKeys(Utility.fetchLocator("Datefrom_TEXT"));

        Thread.sleep(2000);
        WebElement tomm = (new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("FilterSalesTargetEndDate_XPATH"))));
        tomm.clear();
        tomm.sendKeys(Utility.fetchLocator("Dateto_TEXT"));

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("AssertWeeksTarget_XPATH")))).click();

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("FilterBTN_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
}
