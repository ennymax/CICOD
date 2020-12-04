package CROWN.EKEDC;

import CROWN.Base.TestBase;
import CROWN.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.io.IOException;

public class Registration_with_incomplete_PhoneNumber extends TestBase {

    @Test
    public void REGISTRATION_INCOMPLETE_PHONE_NUMBER() throws IOException, InterruptedException {
        driver.findElement(By.xpath(Utility.fetchLocator("RegisterBTN_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("RegEmail_XPATH"))).sendKeys(Utility.fetchLocator("Regemail_TEXT"));

        driver.findElement(By.xpath(Utility.fetchLocator("RegNumber_XPATH"))).sendKeys(Utility.fetchLocator("RegINnvalidnumber_TEXT"));

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("RegCheckBox_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        driver.findElement(By.xpath(Utility.fetchLocator("ActualRegisterBTN_XPATH"))).click();
    }
}
