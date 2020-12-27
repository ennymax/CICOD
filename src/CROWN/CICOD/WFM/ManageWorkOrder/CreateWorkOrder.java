package CROWN.CICOD.WFM.ManageWorkOrder;

import CROWN.Base.TestBase;
import CROWN.utility.*;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateWorkOrder extends TestBase {

    @Test
    public void CREATE_WORK_ORDER() throws IOException, InterruptedException {
        ScreenShot screenShot = new ScreenShot(driver);
        Login login = new Login(driver);
        Randomstuff randomStuff = new Randomstuff();
        JavaScriptUtil javaScriptUtil = new JavaScriptUtil(driver);

        login.LoginPremium();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Wfm_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("WorkOrderManager_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ManageWorkOrder_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("All_XPATH"))).click();

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("NewRecord_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);
        WebElement ele111 = driver.findElement(By.xpath(Utility.fetchLocator("Queue_XPATH")));
        Select sel11 = new Select(ele111);
        sel11.selectByVisibleText("Cicod");

        Thread.sleep(2000);
        WebElement ele11 = driver.findElement(By.xpath(Utility.fetchLocator("a_XPATH")));
        Select sel1 = new Select(ele11);
        sel1.selectByVisibleText("Sales");

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("Summary_XPATH_XPATH"))).sendKeys(Utility.fetchLocator("Summary_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Discription_XPATH"))).sendKeys(Utility.fetchLocator("Description_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("WfmEmail_XPATH"))).sendKeys(randomStuff.ListRandom() + "@gmail.com");
        driver.findElement(By.xpath(Utility.fetchLocator("CustomerName_XPATH"))).sendKeys(Utility.fetchLocator("CustomerName_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("ContactNumber_XPATH"))).sendKeys(Utility.fetchLocator("ContactPhoneNumber_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("AddressLine1_XPATH"))).sendKeys(Utility.fetchLocator("AddressLine1_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("AddressLine2_XPATH"))).sendKeys(Utility.fetchLocator("AddressLine1_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("cont_XPATH"))).click();

        ExcelUtil excelUtil = new ExcelUtil(driver);
        excelUtil.DoscrolltoViewClickFluentWait("cont_XPATH", 20);
        excelUtil.DoSelectValuesByIndex("cont_XPATH",5,20);
        excelUtil.DoclickWhenReady("niger_XPATH", 20);
        javaScriptUtil.DoClickFluentwaitJS("niger_XPATH", 30);

        Thread.sleep(999999999);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("city_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.sendKeys(randomStuff.ListRandom());

        Thread.sleep(2000);
        WebElement ele11lg = driver.findElement(By.xpath(Utility.fetchLocator("WorkOrderRegion_XPATH")));
        Select sel1lg = new Select(ele11lg);
        sel1lg.selectByIndex(1);

        Thread.sleep(2000);
        WebElement ele11l = driver.findElement(By.xpath(Utility.fetchLocator("Priority_XPATH")));
        Select sel1l = new Select(ele11l);
        sel1l.selectByIndex(1);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("CreateBtn_XPATH"))).click();

        Thread.sleep(2000);
        screenShot.ScreenShot();
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertTrue_XPATH"))).size() != 0) {
            test.log(Status.PASS, "New WORK Order Created SuccessFULLY");
        } else {
            test.log(Status.FAIL, "Work Order Cant be Created");
        }

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("OkBTN_XPATH"))).click();
    }
}
