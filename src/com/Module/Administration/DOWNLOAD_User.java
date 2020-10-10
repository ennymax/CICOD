package com.Module.Administration;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DOWNLOAD_User extends TestBase {

    @Test
    public void DOWNLOAD_USER() throws IOException, InterruptedException {
        test = extent.createTest("DOWNLOAD USER");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        Login login = new Login(driver);
        API_Watch_Service api_watch_service = new API_Watch_Service();

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
        driver.findElement(By.xpath(Utility.fetchLocator("UserManagementbtn_XPATH"))).click();
        test.log(Status.PASS, "Administration button Fully functional");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("UserDownload_XPATH"))).click();

        api_watch_service.ApiWatchService();

        Thread.sleep(2000);

        System.out.println("********************DOWNLOAD USER TEST IS COMPLETED********************");
        driver.quit();
    }
}
