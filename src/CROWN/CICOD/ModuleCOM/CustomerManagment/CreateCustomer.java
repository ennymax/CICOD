package CROWN.CICOD.ModuleCOM.CustomerManagment;

import CROWN.base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Randomstuff;
import CROWN.utility.ScreenShot;
import CROWN.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.io.IOException;
import java.security.SecureRandom;

public class CreateCustomer extends TestBase {

    @Test
    public void Create_Customer() throws IOException, InterruptedException {
        ScreenShot screenshot = new ScreenShot(driver);
        Login login = new Login(driver);
        Randomstuff randomstuff =new Randomstuff();
        SecureRandom rn = new SecureRandom();
        int st = rn.nextInt(1000000) + 1;

        login.Login();

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        //CUSTOMER MANAGEMENT BUTTON
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Customermanagmentbtn_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SelectCustomerbtn_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("AdddCustomer_XPATH"))).click();

        //NEW CUSTOMER FORM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("FirstName_XPATH"))).sendKeys(randomstuff.ListRandom());

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("LastName_XPATH"))).sendKeys(randomstuff.ListRandom());

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("CustomerCode_XPATH"))).sendKeys("12" + st);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("CustomerEmail_XPATH"))).sendKeys(randomstuff.ListRandom() +"@gmail.com");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PhoneNumber_XPATH"))).sendKeys(Utility.fetchLocator("CustomerPhoneNumber_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("HouseNumber_XPATH"))).sendKeys(Utility.fetchLocator("CustomerHouseNo_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Street_XPATH"))).sendKeys(Utility.fetchLocator("CustomerStreet_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("LandMark_XPATH"))).sendKeys(Utility.fetchLocator("CustomerLandMark_TEXT"));

        Thread.sleep(1500);
        screenshot.ScreenShot();
        WebElement ele111 = driver.findElement(By.xpath(Utility.fetchLocator("CustomerState_XPATH")));
        Select sel11 = new Select(ele111);
        sel11.selectByIndex(25);

        Thread.sleep(1500);
        WebElement ele112 = driver.findElement(By.xpath(Utility.fetchLocator("CustomerLGA_XPATH")));
        Select sel12 = new Select(ele112);
        sel12.selectByIndex(15);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SameAddressAsCustomer_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("CussstomersaveBTN_XPATH"))).click();
    }
}
