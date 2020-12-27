package CROWN.EKEDC;

import CROWN.Base.TestBase;
import CROWN.utility.Utility;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.io.IOException;

public class View_Service_Alert_District extends TestBase {

    @Test
    public void VIEW_SERVICE_ALERT_HISTORY() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        driver.findElement(By.xpath(Utility.fetchLocator("View_XPATH"))).click();
        System.out.println(driver.getTitle());
        utility.DoAssertTittle("EDDCUTi_TEXT","BFPass_TEXT","BFFail_TEXT");
    }
}
