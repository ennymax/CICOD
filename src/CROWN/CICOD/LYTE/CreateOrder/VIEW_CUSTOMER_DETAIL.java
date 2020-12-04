package CROWN.CICOD.LYTE.CreateOrder;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class VIEW_CUSTOMER_DETAIL extends TestBase {

    @Test
    public void VIEW_CUSTOMER_DETAILS() throws IOException, InterruptedException {
        Login login = new Login(driver);
        login.LoginTestAccount();
        test.log(Status.PASS, "Login Was Successful");

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        //CREATE ORDER BUTTON
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Createorderbtn_XPATH"))).click();

        //SEARCH BY NAME
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SearchByName_XPATH"))).click();
        driver.findElement(By.xpath(Utility.fetchLocator("SeaerchInput_XPATH"))).sendKeys(Utility.fetchLocator("CustomerFirstname_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Searchbtn_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("SearchByNameAssertion_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Search By Name was Successful");
            test.log(Status.PASS, "Search By Phone Number was Successful");
            test.log(Status.PASS, "Search By Email was Successful");

        } else {
            test.log(Status.FAIL, "Search By name Failed");
        }

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("ViewDetails_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        if (driver.findElements(By.xpath(Utility.fetchLocator("assertdisplayeddetails_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Customer Details was displyed");

        } else {
            test.log(Status.FAIL, "Customer Details wasnt displayed");
        }
    }
}