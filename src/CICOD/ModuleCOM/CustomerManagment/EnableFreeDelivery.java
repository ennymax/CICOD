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

public class EnableFreeDelivery extends TestBase {
    @Test
    public void Enable_free_Delivery() throws IOException, InterruptedException {
        test = extent.createTest("Enable free Delivery");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        ScreenShot screenshot = new ScreenShot(driver);
        Login login = new Login(driver);
        Randomstuff randomstuff = new Randomstuff();

        login.Login();

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        //CUSTOMER MANAGEMENT BUTTON
        Thread.sleep(2000);
        screenshot.ScreenShot();
        driver.findElement(By.xpath(Utility.fetchLocator("Customermanagmentbtn_XPATH"))).click();

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

        Thread.sleep(1200);
        WebElement tt = driver.findElement(By.xpath(Utility.fetchLocator("LastName_XPATH")));
        tt.clear();
        tt.sendKeys(randomstuff.ListRandom());

        Thread.sleep(2000);
        WebElement check_box1 = driver.findElement(By.xpath(Utility.fetchLocator("EnableFreeDeliv_XPATH")));
        if(check_box1.isSelected()) {
            test.log(Status.PASS, "Enable Free Delivery has been selected");
        } else {
            check_box1.click();
            test.log(Status.PASS, "Enable Free Delivery has been selected");
        }

        Thread.sleep(2000);
        WebElement check_box = driver.findElement(By.xpath(Utility.fetchLocator("EnableVatExemption_XPATH")));
        if(check_box.isSelected()) {
            check_box.click();
            test.log(Status.PASS, "Enable Exemption has been Unselected");
        } else {
            System.out.println("The checkbox is Selected");
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

        Thread.sleep(2000);
        WebElement ele111j = driver.findElement(By.xpath(Utility.fetchLocator("Country_XPATH")));
        Select sel11j = new Select(ele111j);
        sel11j.selectByVisibleText("Nigeria");

        Thread.sleep(1000);
        WebElement ele111jm = driver.findElement(By.xpath(Utility.fetchLocator("Cstate_XPATH")));
        Select sel11jm = new Select(ele111jm);
        sel11jm.selectByVisibleText("Lagos");

        Thread.sleep(1000);
        WebElement ele111jj = driver.findElement(By.xpath(Utility.fetchLocator("Clga_XPATH")));
        Select sel11jj = new Select(ele111jj);
        sel11jj.selectByVisibleText("Ikeja");

        Thread.sleep(2000);
        WebElement check_box2 = driver.findElement(By.xpath(Utility.fetchLocator("SetAsDef_XPATH")));
        if(check_box2.isSelected()) {
            test.log(Status.PASS, "Set As Default Is Selected");
        } else {
            check_box2.click();
            test.log(Status.PASS, "Set as Default is Selected");
        }

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

        //Del
        Thread.sleep(2000);
        WebElement ti11l = driver.findElement(By.xpath(Utility.fetchLocator("Deliv_XPATH")));
        JavascriptExecutor jsel = (JavascriptExecutor) driver;
        jsel.executeScript("arguments[0].scrollIntoView();", ti11l);
        ti11l.click();

        //Delivery
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("DELLL_XPATH"))).click();

        Thread.sleep(2000);
        WebElement check_box3 = driver.findElement(By.xpath(Utility.fetchLocator("SpecificCusAddress_XPATH")));
        if(check_box3.isSelected()) {
            test.log(Status.PASS, "Customer Address has Been Selected");
        } else {
            check_box3.click();
            test.log(Status.PASS, "Customer Address Has been Selected");
        }

        Thread.sleep(3400);
        WebElement ti11pp = driver.findElement(By.xpath(Utility.fetchLocator("SelectAdd_XPATH")));
        JavascriptExecutor jsepp = (JavascriptExecutor) driver;jse.executeScript("arguments[0].scrollIntoView();", ti11pp);
        ti11pp.click();

        Thread.sleep(5000);
        WebElement ti11p = driver.findElement(By.xpath(Utility.fetchLocator("jjregion_XPATH")));
        JavascriptExecutor jsep = (JavascriptExecutor) driver;jse.executeScript("arguments[0].scrollIntoView();", ti11p);
        ti11p.click();

        Thread.sleep(2000);
        WebElement ele111 = driver.findElement(By.xpath(Utility.fetchLocator("SelectRegion_XPATH")));
        Select sel11 = new Select(ele111);
        sel11.selectByIndex(1);

        //Delivery
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("DELLL_XPATH"))).click();

        Thread.sleep(2000);
        WebElement check_box33 = driver.findElement(By.xpath(Utility.fetchLocator("SpecificCusAddress_XPATH")));
        if(check_box33.isSelected()) {
            test.log(Status.PASS, "Customer Address has Been Selected");
        } else {
            check_box33.click();
            test.log(Status.PASS, "Customer Address Has been Selected");
        }

        Thread.sleep(3400);
        WebElement ti11pp3 = driver.findElement(By.xpath(Utility.fetchLocator("SelectAdd_XPATH")));
        JavascriptExecutor jsepp3 = (JavascriptExecutor) driver;jse.executeScript("arguments[0].scrollIntoView();", ti11pp3);
        ti11pp3.click();

        Thread.sleep(5000);
        WebElement ti11pv = driver.findElement(By.xpath(Utility.fetchLocator("jjregion_XPATH")));
        JavascriptExecutor jsepv = (JavascriptExecutor) driver;jse.executeScript("arguments[0].scrollIntoView();", ti11pv);
        ti11pv.click();

        Thread.sleep(2000);
        WebElement ele111z = driver.findElement(By.xpath(Utility.fetchLocator("SelectRegion_XPATH")));
        Select sel11z = new Select(ele111z);
        sel11z.selectByIndex(1);

        Thread.sleep(4000);
        WebElement ti112 = driver.findElement(By.xpath(Utility.fetchLocator("MakePayment_XPATH")));
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView();", ti112);
        ti112.click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PayOnline_XPATH"))).click();

        Thread.sleep(13000);
        driver.switchTo().frame(0);

        Thread.sleep(2000);
        Utility utility = new Utility(driver);
        utility.DoAssertEqualWhenReady("ASSenable_XPATH","NGN203.00",70);

        driver.quit();
    }
}
