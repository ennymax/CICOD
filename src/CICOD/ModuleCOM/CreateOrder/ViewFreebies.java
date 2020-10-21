package CICOD.ModuleCOM.CreateOrder;

import CICOD.base.TestBase;
import CICOD.utility.Login;
import CICOD.utility.RavePay;
import CICOD.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class ViewFreebies extends TestBase {
    @Test
    public void VIEW_FREEBIES() throws IOException, InterruptedException {
        test = extent.createTest("VIEW FREEBIES");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        Login login = new Login(driver);
        RavePay ravePay = new RavePay(driver);
        SecureRandom rn = new SecureRandom();
        int st = rn.nextInt(3) + 1;
        Utility utility = new Utility(driver);

        login.Login();
        test.log(Status.PASS, "Login Was Successful");

        utility.DoclickWhenReady("com_XPATH", "comm_TEXT",60);
        utility.DoclickWhenReady("Createorderbtn_XPATH", "CreateOrder_TEXT",40);
        utility.DoclickWhenReady("SearchByName_XPATH", "SearchBox_TEXT",40);
        utility.DoSendKeysWhenReady("SeaerchInput_XPATH","CustomerFirstname_TEXT" ,"CustomerName_TEXT", 40);
        utility.DoclickWhenReady("Searchbtn_XPATH", "SearchBTN_TEXT",40);
        utility.DoscrolltoViewClickWhenReady("ViewDetails_XPATH", "Cus_TEXT",40);


        utility.DoAssertContainsWhenReady("AssertSearchByName_XPATH", "Searched_TEXT","em_TEXT", "SBN_TEXT",30);

        //SEARCH PRODUCT
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SearchProductinput_XPATH"))).sendKeys(Utility.fetchLocator("ID_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SearchProductbtnq_XPATH"))).click();

        Thread.sleep(2000);
        WebElement ti11z = driver.findElement(By.xpath(Utility.fetchLocator("AddBTN_XPATH")));
        JavascriptExecutor jsez = (JavascriptExecutor) driver;
        jsez.executeScript("arguments[0].scrollIntoView();", ti11z);
        ti11z.click();

        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("ViewFreebies_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("SelectFreebiesone_XPATH")))).click();
        test.log(Status.PASS, "Freebies can be Viewed and added");

        Thread.sleep(2000);
        WebElement ti11k = driver.findElement(By.xpath(Utility.fetchLocator("AddFreeBee_XPATH")));
        JavascriptExecutor jsek = (JavascriptExecutor) driver;
        jsek.executeScript("arguments[0].scrollIntoView();", ti11k);
        ti11k.click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("CheckOffer_XPATH")))).click();

        Thread.sleep(2000);
        assertEquals("Math set\n" + "Delete\n" + "Quantity\n" + "1\n" + "₦0.00", driver.findElement(By.xpath(Utility.fetchLocator("Assertfreebies_XPATH"))).getText());
        test.log(Status.PASS, "Confirmed Freebies was added Successfully");

        System.out.println("********************VIEW FREEBIES********************");
        driver.quit();
    }
}
