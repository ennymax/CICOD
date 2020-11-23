package CICOD.ModuleWFM.RightTemplate;

import CICOD.base.TestBase;
import CICOD.utility.*;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

public class CreateUsers extends TestBase {
    @Test
    public void CREATE_USER() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("CREATE USER");
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
        utility.DoclickWhenReady("RightTemplateUser_XPATH", "RightT_TEXT",50);
        utility.DosendKeysRandomListwordsWhenReady("NewUserFname_XPATH", "NewUser_TEXT",50);
        utility.DosendKeysRandomListwordsWhenReady("NewUserLastName_XPATH", "FirstNa_TEXT",50);
        utility.DosendKeysRandomEmailsWhenReady("NewUserEmail_XPATH", "LastNameField_TEXT",50 );
        utility.DosendKeyRRWhenReady("NewUserPhone_XPATH", "ContactPhoneNumber_TEXT", "Ph_TEXT",20);
        utility.DoSelectValuesByIndex("NewUserRightTemplate_XPATH", "ResourceT_TEXT",resourcetype, 20);
        utility.DoclickWhenReady("NewUserDepartment_XPATH", "Seler_TEXT",50);
        utility.DoclickWhenReady("NewUserA1_XPATH", "A_TEXT",50);
        utility.DoclickWhenReady("NewUserA2_XPATH", "A_TEXT",50);
        excelUtil.DoclickWhenReady("Cll_XPATH",60);
        utility.DoFileUpWhenReady("FileUpload_XPATH", "3mb_TEXT",50);
        fileUpload.UploadFileImage3MB();
        utility.DosendKeysRandomNumberWhenReady("NewUserStaffID_XPATH", "StaffID_TEXT",500000 , 60);
        utility.DosendKeysRandomListwordsWhenReady("NewserJobTittle_XPATH", "JobT_TEXT",50);
        excelUtil.DoclickWhenReady("Cll_XPATH",60);
        utility.DoclickWhenReady("NewUserRegion_XPATH", "U1_TEXT",50);
        utility.DoclickWhenReady("Newq11_XPATH", "u2_TEXT",50);
        excelUtil.DoclickWhenReady("Cll_XPATH",60);
        utility.DoclickWhenReady("CreateNewUser_XPATH", "Creta_TEXT",50);
        utility.DoAssertContainsWhenReady("AssertNewUserCreation_XPATH","Su_TEXT" ,"DplPass_XPATH", "DplFail_XPATH",30);
        utility.DoclickWhenReady("NewUserOKBTN_XPATH","Ok_TEXT",40);

        driver.quit();
    }
}
