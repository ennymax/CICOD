package CROWN.EKEDC;

import CROWN.Base.TestBase;
import CROWN.utility.Utility;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.io.IOException;

public class Registration_With_Matching_Password extends TestBase {

    @Test
    public void REGISTER_WITH_MATCHING_PASSWORD() throws IOException, InterruptedException {

        driver.get("http://52.50.169.238/register/setup/3OwLfCgdoTqAZy2vHn%252BdV5cLGjELeEV%252F%252BgMTWp0xP6mpFVz%252BJhzVTiEc9%252FhMEjw%253D");

        driver.findElement(By.xpath(Utility.fetchLocator("Regpasswodone_XPATH"))).sendKeys(Utility.fetchLocator("RegPassword_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Regpasswordtwo_XPATH"))).sendKeys(Utility.fetchLocator("RegPassword_TEXT"));
        //driver.findElement(By.xpath(Utility.fetchLocator("RegContinueBtn_XPATH"))).click();

        driver.quit();
    }
}
