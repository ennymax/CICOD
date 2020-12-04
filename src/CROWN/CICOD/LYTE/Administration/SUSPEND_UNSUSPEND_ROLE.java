package CROWN.CICOD.LYTE.Administration;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class SUSPEND_UNSUSPEND_ROLE extends TestBase {

    @Test
    public void SuspendRole() throws IOException, InterruptedException {
        Login login = new Login(driver);

        login.LoginTestAccount();

        //COM
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("AdminLyte_XPATH"))).click();

        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("RoleLyte_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("RoleActionbtn_XPATH"))).click();

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("suspend/unsuspendRole_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        driver.switchTo().alert().accept();

        Thread.sleep(2000);
        WebElement ti11l = driver.findElement(By.xpath(Utility.fetchLocator("RoleActionbtn_XPATH")));
        JavascriptExecutor jsel = (JavascriptExecutor) driver;
        jsel.executeScript("arguments[0].scrollIntoView();", ti11l);
        ti11l.click();

        Thread.sleep(2000);
        WebElement element1 = driver.findElement(By.xpath(Utility.fetchLocator("suspend/unsuspendRole_XPATH")));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", element1);

        Thread.sleep(2000);
        driver.switchTo().alert().accept();
    }
}
