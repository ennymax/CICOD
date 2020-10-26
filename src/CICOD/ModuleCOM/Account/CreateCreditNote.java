package CICOD.ModuleCOM.Account;

import CICOD.base.TestBase;
import CICOD.utility.FileUpload;
import CICOD.utility.Login;
import CICOD.utility.ScreenShot;
import CICOD.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class CreateCreditNote extends TestBase {
    @Test
    public void Create_Credit_Note() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("Create Credit Note");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        Login login = new Login(driver);
        SecureRandom rn = new SecureRandom();
        int a = rn.nextInt(60000) + 1;
        int aa = rn.nextInt(60000) + 1;
        FileUpload fileUpload = new FileUpload();
        Utility utility = new Utility(driver);

        login.Login();
        test.log(Status.PASS, "Login Was Successful");

        utility.DoclickWhenReady("com_XPATH", "comm_TEXT",60);
        utility.DoclickWhenReady("AccountBTN_XPATH", "AcctBTN_TEXT",60);
        utility.DoclickWhenReady("CreditNote_XPATH", "CreditN_TEXT",60);
        utility.DoscrolltoViewClickFluentWait("CreateCreditNote_XPATH","CreateCN_TEXT",60);
        utility.DoSendKeysRobotClassFluentWait("CCustomer_XPATH","EnterName_TEXT","EnterName_TEXT",60);
        utility.DoSelectValuesByIndex("cReason_XPATH","SS_TEXT",2,60);

        Thread.sleep(1200);
        driver.findElement(By.xpath(Utility.fetchLocator("InvoiceNum_XPATH"))).sendKeys(Utility.fetchLocator("h_TEXT") + aa );

        Thread.sleep(1200);
        driver.findElement(By.xpath(Utility.fetchLocator("Quant_XPATH"))).sendKeys("2000");

        Thread.sleep(1200);
        driver.findElement(By.xpath(Utility.fetchLocator("Amount_XPATH"))).sendKeys(Utility.fetchLocator("h_TEXT") + a );

        Thread.sleep(1200);
        driver.findElement(By.xpath(Utility.fetchLocator("Cdes_XPATH"))).sendKeys("Testing Credit note");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Senddd_XPATH"))).click();

        Thread.sleep(2000);
        assertEquals("×\n" + "Credit note created successfully", driver.findElement(By.xpath(Utility.fetchLocator("AssertBanner_XPATH"))).getText());
        test.log(Status.PASS, "Credit Note was Created");

        System.out.println("**************************Create Credit Note*********************************");
        driver.quit();
    }
}
