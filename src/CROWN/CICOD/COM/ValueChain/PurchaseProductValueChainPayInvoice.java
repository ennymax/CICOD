package CROWN.CICOD.COM.ValueChain;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.io.IOException;
import java.security.SecureRandom;

import static org.testng.AssertJUnit.assertEquals;

public class PurchaseProductValueChainPayInvoice extends TestBase {
    @Test
    public void PURCHASE_PRODUCT_VIA_VALUE_CHAIN_PAYINVOICE() throws IOException, InterruptedException {
        Login login = new Login(driver);
        SecureRandom rn = new SecureRandom();

        login.LoginDefault();

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        //CUSTOMER MANAGEMENT BUTTON
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Customermanagmentbtn_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("ValuechainBTN_XPATH"))).click();

        Thread.sleep(1400);
        driver.findElement(By.xpath(Utility.fetchLocator("Suppliers_XPATH"))).click();

        Thread.sleep(1000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("BuyerActionBTN_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("SuppliersProduct_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("CreateOrderfromSuppler_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("ProductCategoryPlus_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("SelectBeverages_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("AddProduct_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("AddProduct_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("AddProduct_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("AddProduct_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("AddProduct_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("AddProduct_XPATH"))).click();

        Thread.sleep(2000);
        WebElement ti11l = driver.findElement(By.xpath(Utility.fetchLocator("mdd_XPATH")));
        JavascriptExecutor jsel = (JavascriptExecutor) driver;
        jsel.executeScript("arguments[0].scrollIntoView();", ti11l);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("vpAymetnOPY_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Vpayin_XPATH"))).click();

        WebElement tid = driver.findElement(By.xpath(Utility.fetchLocator("Vgenr_XPATH")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", tid);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Vgenr_XPATH"))).click();
        test.log(Status.PASS, "Order Code Was Generated Successfully");

        Thread.sleep(2000);
        assertEquals("08155341117", driver.findElement(By.xpath(Utility.fetchLocator("ValAsseetPayinv_XPATH"))).getText());
        test.log(Status.PASS, "PayInVoice was Successful");
    }
}
