package CROWN.CICOD.UCG;

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

public class FilterVarienceReport extends TestBase {
    @Test
    public void FILTER_VARIANCE_REPORT() throws IOException, InterruptedException {
        Login login = new Login(driver);

        login.LoginCorrectDetails();

        Thread.sleep(1200);
        driver.findElement(By.xpath(Utility.fetchLocator("UcgBTN_XPATH"))).click();

        Thread.sleep(1200);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("CollectionBTN_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(1200);
        WebElement element1 = driver.findElement(By.xpath(Utility.fetchLocator("VarianceReport_XPATH")));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", element1);

        Thread.sleep(1200);
        WebElement k = driver.findElement(By.xpath(Utility.fetchLocator("From_XPATH")));
        k.clear();
        k.sendKeys(Utility.fetchLocator("From_TEST"));

        Thread.sleep(1200);
        WebElement kk = driver.findElement(By.xpath(Utility.fetchLocator("To_XPATH")));
        kk.clear();
        kk.sendKeys(Utility.fetchLocator("to_TEXT"));

        Thread.sleep(1500);
        WebElement ele111 = driver.findElement(By.xpath(Utility.fetchLocator("Against_XPATH")));
        Select sel11 = new Select(ele111);
        sel11.selectByVisibleText("January");

        Thread.sleep(1200);
        WebElement l = driver.findElement(By.xpath(Utility.fetchLocator("Year_XPATH")));
        l.clear();
        l.sendKeys(Utility.fetchLocator("Year_TEXT"));

        Thread.sleep(1200);
        WebElement element13 = driver.findElement(By.xpath(Utility.fetchLocator("Submit_XPATH")));
        JavascriptExecutor js13 = (JavascriptExecutor) driver;
        js13.executeScript("arguments[0].click();", element13);

        Thread.sleep(1200);
        WebElement Elementl = driver.findElement(By.xpath(Utility.fetchLocator("AssertVarianceGraPH_XPATH")));
        JavascriptExecutor jskl = (JavascriptExecutor) driver;
        jskl.executeScript("arguments[0].scrollIntoView();", Elementl);

        Thread.sleep(1200);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertVarianceGraPH_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Variance Graph was displayed");
        } else {
            test.log(Status.FAIL, "Variance Graph wasn't displayed");
        }

        Thread.sleep(2000);
        WebElement Elementlf = driver.findElement(By.xpath(Utility.fetchLocator("DailyVendedAmount_XPATH")));
        JavascriptExecutor jsklf = (JavascriptExecutor) driver;
        jsklf.executeScript("arguments[0].scrollIntoView();", Elementlf);

        Thread.sleep(1200);
        if (driver.findElements(By.xpath(Utility.fetchLocator("DailyVendedAmount_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Daily Vended Amount  was displayed");
        } else {
            test.log(Status.FAIL, "Daily Vended Amount wasnt displayed");
        }
    }
}
