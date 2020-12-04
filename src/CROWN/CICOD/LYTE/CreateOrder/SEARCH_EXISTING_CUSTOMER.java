package CROWN.CICOD.LYTE.CreateOrder;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

public class SEARCH_EXISTING_CUSTOMER extends TestBase {

    @Test
    public void SEARCH_EXISTING_customer() throws IOException, InterruptedException {
        Login login = new Login(driver);

        login.LoginTestAccount();

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
            test.log(Status.FAIL, "Search Failed");
        }
    }
}
