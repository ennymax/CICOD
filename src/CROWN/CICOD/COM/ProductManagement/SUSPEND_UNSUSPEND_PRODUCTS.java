package CROWN.CICOD.COM.ProductManagement;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class SUSPEND_UNSUSPEND_PRODUCTS extends TestBase {

    @Test
    public void SUSPEND_UNSUSPEND_PRODUCT() throws IOException, InterruptedException {
        Login login = new Login(driver);

        login.Login();

        //Com
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        //product Management
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ProductManagementbtn_XPATH"))).click();

        //Click On Product
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Productbtn_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ActionSuspendbtn_XPATH"))).click();

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("Suspendbtn_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        Thread.sleep(2000);
        WebElement msg1 = driver.findElement(By.xpath(Utility.fetchLocator("Assertsusp_XPATH")));
        String text1 = msg1.getText();
        if (msg1.isEnabled() && text1.contains("Product suspended")) {
            test.log(Status.PASS, "Product suspended successfully");
        } else {
            test.log(Status.FAIL, "suspension Failed");
        }

        Thread.sleep(1500);
        WebElement k = driver.findElement(By.xpath(Utility.fetchLocator("ActionSuspendbtn_XPATH")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", k);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ActionSuspendbtn_XPATH"))).click();

        Thread.sleep(2000);
        WebElement element2 = driver.findElement(By.xpath(Utility.fetchLocator("Suspendbtn_XPATH")));
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].click();", element2);

        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        Thread.sleep(2000);
        assertEquals("×\n" + "Product unsuspended", driver.findElement(By.xpath(Utility.fetchLocator("Assertsusp_XPATH"))).getText());
        test.log(Status.PASS, "Product Unsuspended successfully");
    }
}
