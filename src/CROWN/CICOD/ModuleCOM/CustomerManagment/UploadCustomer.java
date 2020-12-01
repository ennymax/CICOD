package CROWN.CICOD.ModuleCOM.CustomerManagment;

import CROWN.base.TestBase;
import CROWN.utility.FileUpload;
import CROWN.utility.Login;
import CROWN.utility.ScreenShot;
import CROWN.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.IOException;

public class UploadCustomer extends TestBase {
    @Test
    public void UPLOAD_CUSTOMER() throws IOException, InterruptedException, AWTException {
        ScreenShot screenshot = new ScreenShot(driver);
        Utility utility = new Utility(driver);
        Login login = new Login(driver);
        FileUpload fileUpload = new FileUpload();

        login.Login();

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        //CUSTOMER MANAGEMENT BUTTON
        Thread.sleep(2000);
        screenshot.ScreenShot();
        driver.findElement(By.xpath(Utility.fetchLocator("Customermanagmentbtn_XPATH"))).click();

        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("SelectCustomerbtn_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();

        //SELECT ACTION
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("uPLAODcUSTOMER_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);
        WebElement elementq = driver.findElement(By.xpath(Utility.fetchLocator("ChooseFille_XPATH")));
        JavascriptExecutor jsq = (JavascriptExecutor) driver;
        jsq.executeScript("arguments[0].click();", elementq);

        fileUpload.UploadXLSX1();

        utility.DoAssertContainsWhenReady("AsserfileUp_XPATH","Assertfileupstr_TEXT","Assertionpp_TEXT","Assertionpf_TEXT",20);
    }
}
