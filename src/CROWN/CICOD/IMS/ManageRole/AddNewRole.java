package CROWN.CICOD.IMS.ManageRole;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Randomstuff;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddNewRole extends TestBase {
    @Test
    public void ADD_ROLE() throws IOException, InterruptedException {
        test = extent.createTest("ADD ROLE");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
        Login login = new Login(driver);
        Randomstuff randomstuff = new Randomstuff();

        login.LoginCorrectDetails();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertLogin_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Login was successful");
        } else {
            test.log(Status.FAIL, "Login failed");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("IMS_XPATH"))).click();

        WebElement element11 = driver.findElement(By.xpath(Utility.fetchLocator("ManageRoleBTN_XPATH")));
        Actions action = new Actions(driver);
        action.moveToElement(element11).click();

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("ManageRoleBTN_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertRoleName_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Role Could be Viewed ");
        } else {
            test.log(Status.FAIL, "Role page could not be Viewed");
        }

        Thread.sleep(2000);
        WebElement elementuu = driver.findElement(By.xpath(Utility.fetchLocator("AddNewRoleBTN_XPATH")));
        JavascriptExecutor jsuu = (JavascriptExecutor) driver;
        jsuu.executeScript("arguments[0].click();", elementuu);

        driver.findElement(By.xpath(Utility.fetchLocator("RoleName1_XPATH"))).sendKeys(Utility.fetchLocator("a_TEXT")+ randomstuff.RandomWords());

        Thread.sleep(2000);

        List<WebElement> li= driver.findElements(By.id("checkbox"));
        System.out.println(li.size());
        for(int i=0;i<=li.size()-1;i++)
        {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView();", li.size()-1);
            li.get(i).click();
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertManageSupplierCreation_XPATH"))).size() != 0) {
            test.log(Status.PASS, "New Role added successfully");
        } else {
            test.log(Status.FAIL, "Role cant be added");
        }

        driver.quit();
        System.out.println("********************ADD ROLE********************");
    }
}
