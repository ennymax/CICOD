package CICOD.ModuleWFM.RightTemplate;

import CICOD.base.TestBase;
import CICOD.utility.ExcelUtil;
import CICOD.utility.FileUpload;
import CICOD.utility.Login;
import CICOD.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

public class UpdateUser  extends TestBase {

    @Test
    public void UpdateUser() throws IOException, InterruptedException{
        test = extent.createTest("UPDATE USER");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Login login = new Login(driver);
        FileUpload fileUpload = new FileUpload();
        Utility utility = new Utility(driver);
        ExcelUtil excelUtil = new ExcelUtil(driver);

        SecureRandom rn = new SecureRandom();
        int resourcetype = rn.nextInt(3) + 1;

        login.LoginNexus();

        utility.DoclickWhenReady("Wfm_XPATH", "wfm_TEXT",50);
        utility.DoclickWhenReady("UserManagement_XPATH", "Usermgt_TEXT",50);
        utility.DoclickWhenReady("Usr_XPATH", "UsersBTN_TEXT",50);
        utility.DoclickWhenReady("UserActionBTNN_XPATH", "ActionBBTN_TEXT",50);
        utility.DoscrolltoViewClickWhenReady("UpdateBtton_XPATH","UpdateBTNN_TEXT",40);
        utility.DosendKeysRandomListwordsWhenReady("NewUserFname_XPATH", "NewUser_TEXT",50);
        utility.DosendKeysRandomListwordsWhenReady("NewUserLastName_XPATH", "FirstNa_TEXT",50);

        utility.DoclickWhenReady("CreateNewUser_XPATH", "UpCreta_TEXT",50);
        utility.DoAssertContainsWhenReady("AssertNewUserCreation_XPATH","Su_TEXT" ,"DplPass1_XPATH", "DplFail1_XPATH",30);
        utility.DoclickWhenReady("NewUserOKBTN_XPATH","Ok_TEXT",40);

        driver.quit();
    }
}
