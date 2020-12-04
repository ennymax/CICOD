package CROWN.EKEDC;

import CROWN.Base.TestBase;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.IOException;

public class Raise_A_Complaint_User_Multiple_Account extends TestBase {

    @Test
    public void RAISE_A_COMPLAINT_USER_LOGGED_IN_MULTIPLE_ACCOUNT() throws IOException, InterruptedException, AWTException {
        /*
        Login login = new Login(driver);
        FileUpload fileUpload = new FileUpload();
        RandomStuff randomStuff = new RandomStuff();

        login.LoginMultipleAccountEKEDC();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("RaiseComplaintBTN_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("CAccountNumber_XPATH"))).sendKeys(Utility.fetchLocator("NewAccount_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ClicOutSideBTN_XPATH"))).click();

        Thread.sleep(2000);
        WebElement ele3a = driver.findElement(By.xpath(Utility.fetchLocator("Category_XPATH")));
        Select sel2a = new Select(ele3a);
        sel2a.selectByIndex(4);

        Thread.sleep(2000);
        WebElement ele3aa = driver.findElement(By.xpath(Utility.fetchLocator("SubCategory_XPATH")));
        Select sel2aa = new Select(ele3aa);
        sel2aa.selectByIndex(3);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("NearestBusStop_XPATH"))).sendKeys(randomStuff.ListRandom());

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Summary_XPATH"))).sendKeys(Utility.fetchLocator("Summary_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Discription_XPATH"))).sendKeys(Utility.fetchLocator("Discription_TEXT"));

        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("EkedpUploader_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);

        Thread.sleep(2000);
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath(Utility.fetchLocator("EkedpUploader_XPATH")))).click().build().perform();

        fileUpload.UploadAbove5MB();

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("AgreeLoggedIn_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("CSubMitBTN_XPATH"))).click();

        Thread.sleep(2000);
        WebElement msg =(new WebDriverWait(driver, 155)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("m_XPATH"))));
        String text = msg.getText();
        if (msg.isEnabled() && text.contains("Complaint submitted successfully and we will get back to you")) {
            test.log(Status.PASS, "Complaint was Raised Successfully");
        } else {
            test.log(Status.FAIL, "Raised Complaint Failed");
        }

        driver.quit();

         */
    }
}
