package CICOD.ModuleCOM.CreateOrder;

import CICOD.base.TestBase;
import CICOD.utility.Login;
import CICOD.utility.Randomstuff;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

public class SelectDeliveryDetails extends TestBase {
    @Test
    public void SELECT_DELIVERY_DETAILS() throws IOException, InterruptedException {
        test = extent.createTest("SELECT DELIVERY DETAILS");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        Login login = new Login(driver);
        RavePay ravePay = new RavePay(driver);
        SecureRandom rn = new SecureRandom();
        int stt = rn.nextInt(34) + 1;
        int sttt = rn.nextInt(13) + 1;
        Randomstuff randomstuff = new Randomstuff();

        login.Login();
        test.log(Status.PASS, "Login Was Successful");

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

        //CREATE ORDER BUTTON
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Createorderbtn_XPATH"))).click();

        //SEARCH BY NAME
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SearchByName_XPATH"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SeaerchInput_XPATH"))).sendKeys(Utility.fetchLocator("CustomerName_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Searchbtn_XPATH"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ViewDetails_XPATH"))).click();

        Thread.sleep(2000);
        WebElement msg1 = driver.findElement(By.xpath(Utility.fetchLocator("AssertSearchByName_XPATH")));
        String text1 = msg1.getText();
        if (msg1.isEnabled() && text1.contains("Email Address")) {
            test.log(Status.PASS, "Search By Name Success");
        } else {
            test.log(Status.FAIL, "Search By Name Failed");
        }

        //SEARCH PRODUCT
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SearchProductinput_XPATH"))).sendKeys(Utility.fetchLocator("ID_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SearchProductbtnq_XPATH"))).click();

        //Add button
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("AddBTN_XPATH"))).click();

        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("DeliveryDetails_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("AddDeliveryRate_XPATH")))).click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("AddAdd_XPATH")))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("DliveryName_XPATH"))).sendKeys(randomstuff.ListRandom());
        driver.findElement(By.xpath(Utility.fetchLocator("DeliveryStreet_XPATH"))).sendKeys(randomstuff.ListRandom());

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("DeliveryLandMark_XPATH"))).sendKeys(randomstuff.ListRandom());

        WebElement ele11 = driver.findElement(By.xpath(Utility.fetchLocator("DeliveryCountry_XPATH")));
        Select sel1 = new Select(ele11);
        sel1.selectByIndex(3);

        WebElement ele111 = driver.findElement(By.xpath(Utility.fetchLocator("DeliveryState_XPATH")));
        Select sel11 = new Select(ele111);
        sel11.selectByIndex(stt);

        WebElement ele1111 = driver.findElement(By.xpath(Utility.fetchLocator("DeliveryLGA_XPATH")));
        Select sel111 = new Select(ele1111);
        sel111.selectByIndex(sttt);

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("SAveDeiveryAddress_XPATH")))).click();

        Thread.sleep(2000);
        WebElement msg11 = driver.findElement(By.xpath(Utility.fetchLocator("as_XPATH")));
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains("Merchant delivery address added successfully")) {
            test.log(Status.PASS, "Delivery Details was Created");
        } else {
            test.log(Status.FAIL, "Delivery Details wasn't created");
        }

        System.out.println("********************SELECT DELIVERY DETAILS********************");
        driver.quit();
    }
}