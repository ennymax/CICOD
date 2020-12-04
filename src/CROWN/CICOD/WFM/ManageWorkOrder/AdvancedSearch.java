package CROWN.CICOD.WFM.ManageWorkOrder;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.TabHandle;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class AdvancedSearch extends TestBase {
    @Test
    public void ADVANCED_SEARCH() throws IOException, InterruptedException {
        Login login = new Login(driver);
        TabHandle tabHandle = new TabHandle(driver);

        login.LoginPremium();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Wfm_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("WorkOrderManager_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ManageWorkOrder_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("All_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("WAdvancedSearch_XPATH"))).click();

        Thread.sleep(2000);
        WebElement ele111 = driver.findElement(By.xpath(Utility.fetchLocator("SQueue_XPATH")));
        Select sel11 = new Select(ele111);
        sel11.selectByVisibleText("Cicod");

        Thread.sleep(2000);
        WebElement ele11 = driver.findElement(By.xpath(Utility.fetchLocator("SQueueType_XPATH")));
        Select sel1 = new Select(ele11);
        sel1.selectByVisibleText("Online");

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("SStatus_XPATH"))).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("Sall_XPATH"))).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("SFixed_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SAddressLine1_XPATH"))).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("Ssdate_XPATH"))).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("changecalender_XPATH"))).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("changecalender_XPATH"))).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("ssdate_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ClickOut_XPATH"))).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("Sddate_XPATH"))).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("Sdate_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("AvSearchh_XPATH"))).click();

        Thread.sleep(2000);
        assertEquals("1041", driver.findElement(By.xpath(Utility.fetchLocator("AssertAdvancedSearchewo_XPATH"))).getText());
        test.log(Status.PASS, "Confirmed Advanced Search was successful");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Exporttoexcel_XPATH"))).click();

        tabHandle.TabHandle();

        Thread.sleep(2000);
        assertEquals("Excel generation in progress, You'll get a notification when it is done. Thank You!", driver.findElement(By.xpath(Utility.fetchLocator("AssertExcelgenerationinprocess_XPATH"))).getText());
        test.log(Status.PASS, "Moved to new Tab Excel generation in progress");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("clickOKexcelgeneration_XPATH"))).click();

        Thread.sleep(2000);
        Actions builder = new Actions(driver);
        WebElement element1 = driver.findElement(By.xpath(Utility.fetchLocator("HverDownload_XPATH")));
        builder.moveToElement(element1).build().perform();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ShowPendingDownload_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Downloadit_XPATH"))).click();
    }
}
