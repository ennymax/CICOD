package CROWN.CICOD.ModuleCOM.CustomerManagment;

import CROWN.base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Randomstuff;
import CROWN.utility.ScreenShot;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.io.IOException;
import java.security.SecureRandom;

public class UpdateCustomer extends TestBase {

    @Test
    public void UPDATE_CUSTOMER() throws IOException, InterruptedException {
        ScreenShot screenshot = new ScreenShot(driver);
        Login login = new Login(driver);
        Randomstuff randomstuff = new Randomstuff();
        SecureRandom rn = new SecureRandom();
        int a = rn.nextInt(60000) + 1;
        int aa = rn.nextInt(60000) + 1;
        int tomm = rn.nextInt(30) + 1;
        int tommm = rn.nextInt(10) + 1;

        login.Login();

        //COM
        Thread.sleep(2000);

        //CUSTOMER MANAGEMENT BUTTON
        Thread.sleep(2000);
        screenshot.ScreenShot();
        driver.findElement(By.xpath(Utility.fetchLocator("Customermanagmentbtn_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SelectCustomerbtn_XPATH"))).click();

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
        WebElement ch = driver.findElement(By.xpath(Utility.fetchLocator("FirstName_XPATH")));
        JavascriptExecutor jsex = (JavascriptExecutor) driver;
        jsex.executeScript("arguments[0].scrollIntoView();", ch);
        ch.clear();
        ch.sendKeys(randomstuff.ListRandom());

        Thread.sleep(1200);
        WebElement tt = driver.findElement(By.xpath(Utility.fetchLocator("LastName_XPATH")));
        tt.clear();
        tt.sendKeys(randomstuff.ListRandom());

        Thread.sleep(1200);
        WebElement ttt = driver.findElement(By.xpath(Utility.fetchLocator("CLandMark_XPATH")));
        ttt.clear();
        ttt.sendKeys(randomstuff.ListRandom());

        Thread.sleep(1200);
        WebElement tttt = driver.findElement(By.xpath(Utility.fetchLocator("ChouseN_XPATH")));
        tttt.clear();
        tttt.sendKeys(Utility.fetchLocator("h_TEXT")+ a );

        Thread.sleep(1200);
        WebElement ttk = driver.findElement(By.xpath(Utility.fetchLocator("CHouseNo_XPATH")));
        ttk.clear();
        ttk.sendKeys(Utility.fetchLocator("h_TEXT")+ aa );

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
    }
}
