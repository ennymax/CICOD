package CROWN.CICOD.ModuleCOM.CreateOrder;

import CROWN.base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.io.IOException;
import java.security.SecureRandom;

public class SaveOrder extends TestBase {

    @Test
    public void SAVE_ORDER() throws IOException, InterruptedException {
        test = extent.createTest("SAVE ORDER");
        Login login = new Login(driver);
        SecureRandom rn = new SecureRandom();

        login.Login();

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

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
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("sAVEorder_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();

        login.AcceptAlert();

        Thread.sleep(2000);
        WebElement msg11 = driver.findElement(By.xpath(Utility.fetchLocator("AssertSearchByProduct_XPATH")));
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains("Cannot save more than 5 orders!")) {
            test.log(Status.PASS, "Order was Saved Successfully");
        } else {
            test.log(Status.FAIL, "Order cant be Saved");
        }

    }
}
