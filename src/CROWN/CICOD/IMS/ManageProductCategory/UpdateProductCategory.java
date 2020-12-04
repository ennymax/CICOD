package CROWN.CICOD.IMS.ManageProductCategory;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class UpdateProductCategory extends TestBase {

    @Test
    public void UPDATE_PRODUCT_CATEGORY() throws IOException, InterruptedException {
        test = extent.createTest("UPATE_PRODUCT_CATEGORY");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        Login login = new Login(driver);

        login.LoginCorrectDetails();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertLogin_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Login was successful");
        } else {
            test.log(Status.FAIL, "Login failed");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("IMS_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("ProductCategoryBTN_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("ActionBTNProductCategory_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("UpdateProductCategory_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("ProductCategoryDescription_XPATH"))).sendKeys(Utility.fetchLocator("Decrib_TEXT"));

        driver.findElement(By.xpath(Utility.fetchLocator("IMSSubmitBTN_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertManageSupplierCreation_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Product Category Updated Successfully");
        } else {
            test.log(Status.FAIL, "Product category Not Updated");
        }

        driver.quit();
        System.out.println("********************UPDATE PRODUCT CATEGORY********************");
    }
}
