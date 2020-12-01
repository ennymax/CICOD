package CROWN.CICOD.ModuleCOM.OrderHistory;

import CROWN.base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.ScreenShot;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Downloadorderhistory extends TestBase {

    @Test
    public void DOWNLOAD_ORDER_HISTORY() throws IOException, InterruptedException {
        ScreenShot screenshot = new ScreenShot(driver);
        Login login = new Login(driver);

        login.Login();

        //COM
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("OrderHistorybtn_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("DownloadOrderHistorybtn_XPATH"))).click();
        test.log(Status.PASS, "Document Successfully Downloaded");

        Thread.sleep(2000);
        screenshot.ScreenShotFullPage();

        driver.quit();
    }
}