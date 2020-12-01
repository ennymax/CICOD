package CROWN.CICOD.ModuleCOM.ProductManagement;

import CROWN.base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.IOException;

public class SearchOffers extends TestBase {
    @Test
    public void SEARCH_OFFERS() throws IOException, InterruptedException, AWTException {
        Login login = new Login(driver);

        login.Login();

        //Com
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        //product Management
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ProductManagementbtn_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("OffersBTN_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("SelectPromotype_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Product Category Page is opened");
        } else {
            test.log(Status.FAIL, "Product Category Page is not accessible");
        }

        WebElement ele111 = driver.findElement(By.xpath(Utility.fetchLocator("SelectPromotype_XPATH")));
        Select sel11 = new Select(ele111);
        sel11.selectByIndex(0);

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("SearchPromotype_XPATH")))).click();

        WebElement msg1 = driver.findElement(By.xpath(Utility.fetchLocator("AssertOfferList_XPATH")));
        String text1 = msg1.getText();
        if (msg1.isEnabled() && text1.contains("Offer List")) {
            test.log(Status.PASS, "The Offer Lis is Fully Displayed");
        } else {
            test.log(Status.FAIL, "Offer List not Displayed");
        }
    }
}
