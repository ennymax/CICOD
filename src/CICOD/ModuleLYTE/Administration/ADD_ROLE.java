package CICOD.ModuleLYTE.Administration;

import CICOD.base.TestBase;
import CICOD.utility.Login;
import CICOD.utility.Randomstuff;
import CICOD.utility.ScreenShot;
import CICOD.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class ADD_ROLE extends TestBase {

    @Test
    public void Add_Role() throws IOException, InterruptedException {
        test = extent.createTest("ADD ROLE");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        ScreenShot screenshot = new ScreenShot(driver);
        Login login = new Login(driver);
        Randomstuff randomStuff = new Randomstuff();

        login.LoginTestAccount();
        test.log(Status.PASS, "Login Was Successful");

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

        screenshot.ScreenShot();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("AdminLyte_XPATH"))).click();
        test.log(Status.PASS, "Administration button Fully functional");

        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("RoleLyte_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();
        test.log(Status.PASS, "Role button fully Functional ");

        Thread.sleep(2000);
        String a = "AddRolebtn_XPATH";
        driver.findElement(By.xpath(Utility.fetchLocator(a))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("RoleName_XPATH"))).sendKeys(randomStuff.ListRandom());

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("UsermanagementCheckBox_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("DashBoardCheckBox_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("VarienceCheckBox_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("rolesaveLyte_XPATH"))).click();

        Thread.sleep(2000);
        WebElement msg11 = driver.findElement(By.xpath(Utility.fetchLocator("Sorry_XPATH")));
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains(": Invalid argument supplied for foreach()")) {
            test.log(Status.FAIL, "Bug In Add Role See ScreenShot");
        } else {
            test.log(Status.PASS, "Add Role Successful");
        }

        Thread.sleep(5000);
        System.out.println("********************ADD ROLE TEST IS COMPLETED********************");
        driver.quit();
    }
}
