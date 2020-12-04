package CROWN.EKEDC;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.io.IOException;

public class Download_Bills extends TestBase {

    @Test
    public void Download_Bills() throws IOException, InterruptedException {
        Login login = new Login(driver);

        login.LoginEKEDC();

        driver.findElement(By.xpath(Utility.fetchLocator("ViewBill_XPATH"))).click();
    }
}
