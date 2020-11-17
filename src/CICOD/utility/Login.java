package CICOD.utility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Login {
    WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void AcceptAlert() throws IOException, InterruptedException {
        if (driver.switchTo().alert() != null)//switches only if alert is displayed
        {
            Alert alert = driver.switchTo().alert();
            alert.accept(); // alert.accept();
        }
    }

    public void AlertDismis() throws IOException, InterruptedException {
        if (driver.switchTo().alert() != null) {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        }
    }

    public void LoginDef1()  throws IOException, InterruptedException  {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        utility.DoSendKeysByActionClassWhenReady("DomainName_XPATH", "DefShopName_TEXT", "DefShopName_TEXT",20);
        utility.DoSendKeysByActionClassWhenReady("Email_XPATH", "DefEmail_TEXT","DefEmail_TEXT" ,20);
        utility.DoSendKeysByActionClassWhenReady("Password_XPATH", "DefPassword_TEXT", "DefPassword_TEXT",20);
        utility.DoscrolltoViewClickWhenReady("LoginBTN_XPATH", "Logi_TEXT",30);
        utility.DoGetPageCurrentUrl( 45 , "yyyy_TEXT");
    }

    public void LoginNexus()  throws IOException, InterruptedException  {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        utility.DoSendKeysByActionClassWhenReady("DomainName_XPATH", "NexusDomainName1_TEXT", "DOma_TEXT",20);
        utility.DoSendKeysByActionClassWhenReady("Email_XPATH", "NexusEmail1_TEXT", "Emailf_TEXT",20);
        utility.DoSendKeysByActionClassWhenReady("Password_XPATH", "NexusPassword1_TEXT", "Passw_TEXT",20);
        utility.DoclickWhenReady("LoginBTN_XPATH","Logi_TEXT" ,30);
    }

    public void LoginPremium() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        utility.DoSendKeysByActionClassWhenReady("DomainName_XPATH", "PshopName_TEXT", "DOma_TEXT",20);
        utility.DoSendKeysByActionClassWhenReady("Email_XPATH", "Pemail_TEXT", "Emailf_TEXT",20);
        utility.DoSendKeysByActionClassWhenReady("Password_XPATH", "Ppassword_TEXT", "Passw_TEXT",20);
        utility.DoclickWhenReady("LoginBTN_XPATH","Logi_TEXT" ,30);
    }

    public void LoginWrongDomainName() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        utility.DoSendKeysByActionClassWhenReady("DomainName_XPATH", "DefaultShopName_TEXT", "DOma_TEXT",20);
        utility.DoSendKeysByActionClassWhenReady("Email_XPATH", "UcgEmail1_TEXT", "Emailf_TEXT",20);
        utility.DoSendKeysByActionClassWhenReady("Password_XPATH", "UcgPassword1_TEXT", "Passw_TEXT",20);
        utility.DoclickWhenReady("LoginBTN_XPATH","Logi_TEXT" ,30);
    }

    public void LoginWrongEmail() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        utility.DoSendKeysByActionClassWhenReady("DomainName_XPATH", "UcgDomainName1_TEXT", "DOma_TEXT",20);
        utility.DoSendKeysByActionClassWhenReady("Email_XPATH", "DefaultEmail_TEXT", "Emailf_TEXT",20);
        utility.DoSendKeysByActionClassWhenReady("Password_XPATH", "UcgPassword1_TEXT", "Passw_TEXT",20);
        utility.DoclickWhenReady("LoginBTN_XPATH","Logi_TEXT" ,30);
    }

    public void LoginWrongPassWord() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        utility.DoSendKeysByActionClassWhenReady("DomainName_XPATH", "UcgDomainName1_TEXT", "UcgDomainName1_TEXT",20);
        utility.DoSendKeysByActionClassWhenReady("Email_XPATH", "UcgEmail1_TEXT", "UcgEmail1_TEXT",20);
        utility.DoSendKeysByActionClassWhenReady("Password_XPATH", "DefaultPassWord_TEXT", "UcgPassword1_TEXT",20);
        utility.DoclickWhenReady("LoginBTN_XPATH","Logi_TEXT" ,30);
    }

    public void LoginCorrectDetails() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        utility.DoSendKeysByActionClassWhenReady("DomainName_XPATH", "UcgDomainName1_TEXT", "UcgDomainName1_TEXT",20);
        utility.DoSendKeysByActionClassWhenReady("Email_XPATH", "UcgEmail1_TEXT", "UcgEmail1_TEXT",20);
        utility.DoSendKeysByActionClassWhenReady("Password_XPATH", "UcgPassword1_TEXT", "UcgPassword1_TEXT",20);
        utility.DoclickWhenReady("LoginBTN_XPATH","Logi_TEXT" ,30);
    }
    public void LoginDefault()  throws IOException, InterruptedException  {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        utility.DoSendKeysByActionClassWhenReady("DomainName_XPATH", "DefaultShop_TEXT", "DOma_TEXT",20);
        utility.DoSendKeysByActionClassWhenReady("Email_XPATH", "Defem_TEXT", "Emailf_TEXT",20);
        utility.DoSendKeysByActionClassWhenReady("Password_XPATH", "defpass_TEXT", "Passw_TEXT",20);
        utility.DoclickWhenReady("LoginBTN_XPATH","Logi_TEXT" ,30);
    }

    public void Loginlupin() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        utility.DoSendKeysByActionClassWhenReady("DomainName_XPATH", "lupinDomainName_TEXT", "DOma_TEXT",20);
        utility.DoSendKeysByActionClassWhenReady("Email_XPATH", "lupinEmail_TEXT", "Emailf_TEXT",20);
        utility.DoSendKeysByActionClassWhenReady("Password_XPATH", "lupinPass_TEXT", "Passw_TEXT",20);
        utility.DoclickWhenReady("LoginBTN_XPATH","Logi_TEXT" ,30);
    }

    public void Login() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        utility.DoSendKeysByActionClassWhenReady("DomainName_XPATH", "NexusDomainName1_TEXT", "DOma_TEXT",20);
        utility.DoSendKeysByActionClassWhenReady("Email_XPATH", "NexusEmail1_TEXT", "Emailf_TEXT",20);
        utility.DoSendKeysByActionClassWhenReady("Password_XPATH", "NexusPassword1_TEXT", "Passw_TEXT",20);
        utility.DoclickWhenReady("LoginBTN_XPATH","Logi_TEXT" ,30);
    }

    public void LoginExpiredAccount() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        utility.DoSendKeysByActionClassWhenReady("DomainName_XPATH", "Cshopname_TEXT", "DOma_TEXT",20);
        utility.DoSendKeysByActionClassWhenReady("Email_XPATH", "Cemail_TEXT", "Emailf_TEXT",20);
        utility.DoSendKeysByActionClassWhenReady("Password_XPATH", "Cpassword_TEXT", "Passw_TEXT",20);
        utility.DoclickWhenReady("LoginBTN_XPATH","Logi_TEXT" ,30);
    }

    public void LoginUpgrade() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        utility.DoSendKeysByActionClassWhenReady("DomainName_XPATH", "TestShopName_XPATH", "DOma_TEXT",20);
        utility.DoSendKeysByActionClassWhenReady("Email_XPATH", "TestEmail_XPATH", "Emailf_TEXT",20);
        utility.DoSendKeysByActionClassWhenReady("Password_XPATH", "UpPassword_TEXT", "Passw_TEXT",20);
        utility.DoclickWhenReady("LoginBTN_XPATH","Logi_TEXT" ,30);
    }

    public void LoginTestAccount() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        utility.DoSendKeysByActionClassWhenReady("DomainName_XPATH", "Shopname_TEXT", "DOma_TEXT",20);
        utility.DoSendKeysByActionClassWhenReady("Email_XPATH", "Email_TEXT", "Emailf_TEXT",20);
        utility.DoSendKeysByActionClassWhenReady("Password_XPATH", "Password_TEXT", "Passw_TEXT",20);
        utility.DoclickWhenReady("LoginBTN_XPATH","Logi_TEXT" ,30);
    }

    public void LoginTestAccountSetUp() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        Utility utility = new Utility(driver);
        utility.DoSendKeysByActionClassWhenReady("DomainName_XPATH", "Ashop_TEXT", "DOma_TEXT",20);
        utility.DoSendKeysByActionClassWhenReady("Email_XPATH", "Aemail_TEXT", "Emailf_TEXT",20);
        utility.DoSendKeysByActionClassWhenReady("Password_XPATH", "Apassword_TEXT", "Passw_TEXT",20);
        utility.DoclickWhenReady("LoginBTN_XPATH","Logi_TEXT" ,30);
    }
}
