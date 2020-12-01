package CROWN.CICOD.ModuleCOM.ProductManagement;

import CROWN.base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.IOException;

public class
RemoveMultipleProductFromWebshop extends TestBase {
    @Test
    public void REMOVE_MULTIPLE_PRODUCT_FROM_WEBSHO() throws IOException, InterruptedException, AWTException {
        Login login = new Login(driver);

        login.Login();

        //Com
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        //product Management
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ProductManagementbtn_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ProductManagementProduct_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("RemoveProduct_XPATH"))).click();

        Thread.sleep(1200);
        WebElement ele111 = driver.findElement(By.xpath(Utility.fetchLocator("ProductBulkAction_XPATH")));
        Select sel11 = new Select(ele111);
        sel11.selectByIndex(2);
    }
}
