package CICOD.ModuleCOM;

import CICOD.base.TestBase;
import CICOD.utility.Login;
import CICOD.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

public class tommy extends TestBase {

    @Test
    public void BUYERS_INSIGHT() throws IOException, InterruptedException {
        test = extent.createTest("BUYERS INSIGHT VALUE CHAIN");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        Utility utility = new Utility(driver);

        utility.SendKeyS("DomainName_XPATH", "DefaultShop_TEXT");
        utility.SendKeyS("Email_XPATH", "Defem_TEXT");
        utility.SendKeyS("Password_XPATH", "defpass_TEXT");
        utility.clickWhenReady("LoginBTN_XPATH", 50);

    }
}
