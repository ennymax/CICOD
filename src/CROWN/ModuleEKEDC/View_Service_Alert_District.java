package CROWN.ModuleEKEDC;

import CROWN.base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.io.IOException;

public class View_Service_Alert_District extends TestBase {

    @Test
    public void VIEW_SERVICE_ALERT_HISTORY() throws IOException, InterruptedException {
        Login login = new Login(driver);
        WebDriverWait wait = new WebDriverWait(driver, 20);

        driver.findElement(By.xpath(Utility.fetchLocator("View_XPATH"))).click();
    }
}
