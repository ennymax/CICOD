package CROWN.CICOD.LYTE.CreateOrder;

import CROWN.Base.TestBase;
import CROWN.utility.BrokenLink;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class SELECT_DELIVERY_DETAILS extends TestBase {

    @Test
    public void SELECT_DELIVERY_DETAIL() throws IOException, InterruptedException {
        BrokenLink brokenLink = new BrokenLink(driver);
        Login login = new Login(driver);

        login.LoginTestAccount();

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        brokenLink.BrokenLink();

        //CREATE ORDER BUTTON
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("Createorderbtn_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        //DELIVERY DETAILS
        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("DeliveryDetailbtn_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();
    }
}
