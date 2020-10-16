package CICOD.ModuleCOM.Administration;

import CICOD.base.TestBase;
import CICOD.utility.Login;
import CICOD.utility.Randomstuff;
import CICOD.utility.ScreenShot;
import CICOD.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ADD_ROLE extends TestBase {

    @Test
    public void Add_Role() throws IOException, InterruptedException {
        test = extent.createTest("ADD ROLE");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        Login login = new Login(driver);
        Randomstuff randomstuff = new Randomstuff();
        ScreenShot screenShot = new ScreenShot(driver);

        login.Login();
        test.log(Status.PASS, "Login Was Successful");

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Adminbtn_XPATH"))).click();
        test.log(Status.PASS, "Administration button Fully functional");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Rolemanagementbtn_XPATH"))).click();
        test.log(Status.PASS, "Role button fully Functional ");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("AddRolebtn_XPATH"))).click();

        screenShot.ScreenShotFullPage();

        driver.findElement(By.xpath(Utility.fetchLocator("RoleName_XPATH"))).sendKeys(randomstuff.ListRandom());

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("UsermanagementCheckBox_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("DashBoardCheckBox_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("VarienceCheckBox_XPATH"))).click();

        screenShot.ScreenShotFullPage();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SaveRoleBTN_XPATH"))).click();

        Thread.sleep(2000);
        WebElement msg11 = driver.findElement(By.xpath(Utility.fetchLocator("Sorry_XPATH")));
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains(": Invalid argument supplied for foreach()")) {
            test.log(Status.FAIL, "Bug In Add Role See ScreenShot");
        } else {
            test.log(Status.PASS, "Add Role Successful");
        }

        Thread.sleep(500);
        screenShot.ScreenShotFullPage();

        System.out.println("********************ADD ROLE TEST IS COMPLETED********************");
        driver.quit();
    }
}
