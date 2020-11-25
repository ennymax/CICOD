package CICOD.ModuleCOM.CustomerManagment;

import CICOD.base.TestBase;
import CICOD.utility.*;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class VatExemptionforCustomer extends TestBase {

    @Test
    public void VatExemptionforCustomer() throws IOException, InterruptedException {
        test = extent.createTest("VAT EXEMPTION FORM CUSTOMER");
        ScreenShot screenshot = new ScreenShot(driver);
        Login login = new Login(driver);
        Randomstuff randomstuff = new Randomstuff();
        SecureRandom rn = new SecureRandom();
        int a = rn.nextInt(60000) + 1;
        int aa = rn.nextInt(60000) + 1;
        int tom = rn.nextInt(8) + 1;
        int tomm = rn.nextInt(30) + 1;
        int tommm = rn.nextInt(10) + 1;
        int st = rn.nextInt(3) + 1;

        login.Login();

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        //CUSTOMER MANAGEMENT BUTTON
        Thread.sleep(2000);
        screenshot.ScreenShot();
        driver.findElement(By.xpath(Utility.fetchLocator("Customermanagmentbtn_XPATH"))).click();
        test.log(Status.PASS, "Customer Management button fully Functional");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SelectCustomerbtn_XPATH"))).click();
        screenshot.ScreenShot();

        //SELECT ACTION
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("ActionSuspend_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);
        WebElement elementq = driver.findElement(By.xpath(Utility.fetchLocator("UpdateCustoo_XPATH")));
        JavascriptExecutor jsq = (JavascriptExecutor) driver;
        jsq.executeScript("arguments[0].click();", elementq);

        Thread.sleep(2000);
        WebElement elementqk = driver.findElement(By.xpath(Utility.fetchLocator("EnableVatExemption_XPATH")));
        JavascriptExecutor jsqk = (JavascriptExecutor) driver;
        jsqk.executeScript("arguments[0].click();", elementqk);

        Thread.sleep(2000);
        WebElement ch = driver.findElement(By.xpath(Utility.fetchLocator("FirstName_XPATH")));
        JavascriptExecutor jsex = (JavascriptExecutor) driver;
        jsex.executeScript("arguments[0].scrollIntoView();", ch);
        ch.clear();
        ch.sendKeys(randomstuff.ListRandom());


        Thread.sleep(2000);
        WebElement checkBox1 = driver.findElement(By.xpath(Utility.fetchLocator("EnableVatExemption_XPATH")));
        if (checkBox1.isSelected()) {
            test.log(Status.PASS, "Enable VAT Exemption has been selected");
        } else {
            checkBox1.click();
            test.log(Status.PASS, "Enable VAT Exemption has been selected");
        }

        Thread.sleep(1200);
        WebElement ttn = driver.findElement(By.xpath(Utility.fetchLocator("Houshhh_XPATH")));
        ttn.clear();
        ttn.sendKeys("4544");

        Thread.sleep(2000);
        WebElement ttss = driver.findElement(By.xpath(Utility.fetchLocator("Strrrr_XPATH")));
        ttss.clear();
        ttss.sendKeys(randomstuff.ListRandom());

        Thread.sleep(2000);
        WebElement ttaa = driver.findElement(By.xpath(Utility.fetchLocator("cLan_XPATH")));
        ttaa.clear();
        ttaa.sendKeys(randomstuff.ListRandom());

        Thread.sleep(1000);
        WebElement ele111j = driver.findElement(By.xpath(Utility.fetchLocator("Country_XPATH")));
        Select sel11j = new Select(ele111j);
        sel11j.selectByVisibleText("Nigeria");

        Thread.sleep(1000);
        WebElement ele111jm = driver.findElement(By.xpath(Utility.fetchLocator("Cstate_XPATH")));
        Select sel11jm = new Select(ele111jm);
        sel11jm.selectByIndex(tomm);

        Thread.sleep(1000);
        WebElement ele111jn = driver.findElement(By.xpath(Utility.fetchLocator("MarchantState_XPATH")));
        Select sel11jn = new Select(ele111jn);
        sel11jn.selectByIndex(tommm);

        Thread.sleep(1000);
        WebElement ele111jj = driver.findElement(By.xpath(Utility.fetchLocator("Clga_XPATH")));
        Select sel11jj = new Select(ele111jj);
        sel11jj.selectByIndex(tommm);

        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("Csave_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();

        Thread.sleep(2000);
        WebElement msg11 = driver.findElement(By.xpath(Utility.fetchLocator("cccg_XPATH")));
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains("Customer updated")) {
            test.log(Status.PASS, "Customer Updated Successfully");
        } else {
            test.log(Status.FAIL, "Customer Update failed");
        }

        //Creating  Order To Verify Tax Exemption
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("CreatV_XPATH"))).click();

        //SEARCH PRODUCT
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SearchProductinput_XPATH"))).sendKeys(Utility.fetchLocator("ID_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SearchProductbtnq_XPATH"))).click();


        //Add button
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("AddBTN_XPATH"))).click();

        Thread.sleep(2000);
        WebElement ti11p = driver.findElement(By.xpath(Utility.fetchLocator("jjregion_XPATH")));
        JavascriptExecutor jsep = (JavascriptExecutor) driver;jse.executeScript("arguments[0].scrollIntoView();", ti11p);
        ti11p.click();

        Thread.sleep(2000);
        WebElement ele111 = driver.findElement(By.xpath(Utility.fetchLocator("SelectRegion_XPATH")));
        Select sel11 = new Select(ele111);
        sel11.selectByIndex(st);

        Thread.sleep(2000);
        WebElement ti112 = driver.findElement(By.xpath(Utility.fetchLocator("MakePayment_XPATH")));
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView();", ti112);
        ti112.click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PayOnline_XPATH"))).click();

        Thread.sleep(13000);
        driver.switchTo().frame(0);

        Thread.sleep(2000);
        System.out.println(driver.findElement(By.id("option-payment-amount-xs")).getText());
        assertEquals("NGN188.84", driver.findElement(By.id("option-payment-amount-xs")).getText());
        test.log(Status.PASS, "Vat Exemption is confirmed");
    }
}
