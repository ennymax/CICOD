package CICOD.ModuleCOM.Filter;

import CICOD.base.TestBase;
import CICOD.utility.Login;
import CICOD.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FILTER_PRODUCT_SPECIFIC_SPEND extends TestBase {
    @Test
    public void FILTER_PRODUCT_SPECIFIC_SPEND() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("FILTER PRODUCT SPECIFIC SPEND");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        Login login = new Login(driver);
        Utility utility = new Utility(driver);

        login.Login();
        utility.DoclickWhenReady("com_XPATH", "comm_TEXT", 60);
        utility.DoclickWhenReady("LoyaltyBTN_XPATH", "LoyaltyBTN_TEXT", 40);
        utility.DoclickWhenReady("CreateProductSpecificSpendBTN_XPATH", "pss_TEXT", 40);

        //Product
        utility.DoSendKeysWhenReadyEnter("Fproduct_XPATH", "Fproduct_TEXT", "Fproduct_TEXT", 40);
        utility.DoAssertXpathPresentWhenReady("AssertPa_XPATH", "Fpassmsg_TEXT", "FFailmsg_TEXT", 15);
        driver.findElement(By.xpath(Utility.fetchLocator("Fproduct_XPATH"))).clear();

        //Product Spend
        utility.DoSendKeysWhenReadyEnter("ProductPoint_XPATH", "Productpoint_XPATH", "Productpoint_XPATH", 40);
        utility.DoAssertXpathPresentWhenReady("AssertPa_XPATH", "pppassmsg_TEXT", "ppailmsg_TEXT", 15);
        driver.findElement(By.xpath(Utility.fetchLocator("Productspend_XPATH"))).clear();

        //Product Point
        utility.DoSendKeysWhenReadyEnter("ProductPoint_XPATH", "Productpoint_XPATH", "Productpoint_XPATH", 40);
        utility.DoAssertXpathPresentWhenReady("AssertPa_XPATH", "pppassmsg_TEXT", "ppailmsg_TEXT", 15);
        driver.findElement(By.xpath(Utility.fetchLocator("Productspend_XPATH"))).clear();

        driver.quit();
    }
}
