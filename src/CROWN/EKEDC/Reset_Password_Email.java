package CROWN.EKEDC;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.io.IOException;

public class Reset_Password_Email extends TestBase {

    @Test
    public void RESET_PASSWORD_EMAIL() throws  IOException {
        Login login = new Login(driver);

        driver.findElement(By.xpath(Utility.fetchLocator("Loginbtn_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("ResetPasswordBTNEKE_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("ResetEmail_XPATH"))).sendKeys(Utility.fetchLocator("EEmail_TEXT"));

        driver.findElement(By.xpath(Utility.fetchLocator("SubmitRemail_XPATH"))).click();

        driver.navigate().to("http://52.50.169.238/change-password/1WuaAaMrUhckD%252FyU%252FXHpBp%252FZqv7%252FUoPBTvWLeDBI42MBqT0%253D");

        driver.findElement(By.xpath(Utility.fetchLocator("Rpassword1_XPATH"))).sendKeys(Utility.fetchLocator("Rpass1_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Rpassword2_XPATH"))).sendKeys(Utility.fetchLocator("Rpass1_TEXT"));

        //driver.findElement(By.xpath(Utility.fetchLocator("RcontinueBTN_XPATH"))).click();
    }
}
