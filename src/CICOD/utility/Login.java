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
        Utility utility = new Utility(driver);
        utility.DoSendKeysByActionClassWhenReady("DomainName_XPATH", "DefaultShop_TEXT", "DOma_TEXT",20);
        utility.DoSendKeysByActionClassWhenReady("Email_XPATH", "Defem_TEXT","Emailf_TEXT" ,20);
        utility.DoSendKeysByActionClassWhenReady("Password_XPATH", "defpass_TEXT", "Passw_TEXT",20);
        utility.DoscrolltoViewClickWhenReady("LoginBTN_XPATH", "Logi_TEXT",30);
        utility.DoGetPageCurrentUrl( 45 , "yyyy_TEXT");
    }

    public void LoginNexus()  throws IOException, InterruptedException  {
        Utility utility = new Utility(driver);
        utility.DoSendKeysByActionClassWhenReady("DomainName_XPATH", "NexusDomainName1_TEXT", "DOma_TEXT",20);
        utility.DoSendKeysByActionClassWhenReady("Email_XPATH", "NexusEmail1_TEXT", "Emailf_TEXT",20);
        utility.DoSendKeysByActionClassWhenReady("Password_XPATH", "NexusPassword1_TEXT", "Passw_TEXT",20);
        utility.DoclickWhenReady("LoginBTN_XPATH","Logi_TEXT" ,30);
    }

    public void LoginPremium() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("DomainName_XPATH"))).sendKeys(Utility.fetchLocator("PshopName_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Email_XPATH"))).sendKeys(Utility.fetchLocator("Pemail_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Password_XPATH"))).sendKeys(Utility.fetchLocator("Ppassword_TEXT"));
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("LoginBTN_XPATH"))).click();
    }

    public void LoginWFM() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("interEmail_XPATH"))).sendKeys(Utility.fetchLocator("WfmEmail1_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("interPassword_XPATH"))).sendKeys(Utility.fetchLocator("WfmPassword1_TEXT"));
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("interLoginBTN_XPATH"))).click();
    }
    public void LoginWrongDomainName() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("Domain_XPATH"))).sendKeys(Utility.fetchLocator("DefaultShopName_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Email_XPATH"))).sendKeys(Utility.fetchLocator("UcgEmail1_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Password_XPATH"))).sendKeys(Utility.fetchLocator("UcgPassword1_TEXT"));
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("LoginBTN_XPATH"))).click();
    }

    public void LoginWrongEmail() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("Domain_XPATH"))).sendKeys(Utility.fetchLocator("UcgDomainName1_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Email_XPATH"))).sendKeys(Utility.fetchLocator("DefaultEmail_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Password_XPATH"))).sendKeys(Utility.fetchLocator("UcgPassword1_TEXT"));
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("LoginBTN_XPATH"))).click();
    }

    public void LoginWrongPassWord() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("Domain_XPATH"))).sendKeys(Utility.fetchLocator("UcgDomainName1_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Email_XPATH"))).sendKeys(Utility.fetchLocator("UcgEmail1_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Password_XPATH"))).sendKeys(Utility.fetchLocator("DefaultPassWord_TEXT"));
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("LoginBTN_XPATH"))).click();
    }

    public void LoginCorrectDetails() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("Domain_XPATH"))).sendKeys(Utility.fetchLocator("UcgDomainName1_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Email_XPATH"))).sendKeys(Utility.fetchLocator("UcgEmail1_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Password_XPATH"))).sendKeys(Utility.fetchLocator("UcgPassword1_TEXT"));
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("LoginBTN_XPATH"))).click();
    }
    public void LoginDefault()  throws IOException, InterruptedException  {
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("shop_XPATH"))).sendKeys(Utility.fetchLocator("DefaultShop_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Email_XPATH"))).sendKeys(Utility.fetchLocator("Defem_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Password_XPATH"))).sendKeys(Utility.fetchLocator("defpass_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Loginbtn_XPATH"))).click();
    }

    public void Loginlupin() throws IOException, InterruptedException {

        driver.findElement(By.xpath(Utility.fetchLocator("shop_XPATH"))).sendKeys(Utility.fetchLocator("lupinDomainName_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Email_XPATH"))).sendKeys(Utility.fetchLocator("lupinEmail_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Password_XPATH"))).sendKeys(Utility.fetchLocator("lupinPass_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Loginbtn_XPATH"))).click();
    }

    public void Login() throws IOException, InterruptedException {
        driver.findElement(By.xpath(Utility.fetchLocator("shop_XPATH"))).sendKeys(Utility.fetchLocator("UcgDomainName1_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Email_XPATH"))).sendKeys(Utility.fetchLocator("UcgEmail1_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Password_XPATH"))).sendKeys(Utility.fetchLocator("UcgPassword1_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Loginbtn_XPATH"))).click();
    }

    public void LoginActiveAccount() throws IOException, InterruptedException {

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("shop_XPATH"))).sendKeys(Utility.fetchLocator("ActShopName_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Email_XPATH"))).sendKeys(Utility.fetchLocator("ActEmail_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Password_XPATH"))).sendKeys(Utility.fetchLocator("UpPassword_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Loginbtn_XPATH"))).click();
    }

    public void LoginExpiredAccount() throws IOException, InterruptedException {

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("shop_XPATH"))).sendKeys(Utility.fetchLocator("Cshopname_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Email_XPATH"))).sendKeys(Utility.fetchLocator("Cemail_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Password_XPATH"))).sendKeys(Utility.fetchLocator("Cpassword_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Loginbtn_XPATH"))).click();
    }

    public void LoginUpgrade() throws IOException, InterruptedException {

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("shop_XPATH"))).sendKeys(Utility.fetchLocator("TestShopName_XPATH"));
        driver.findElement(By.xpath(Utility.fetchLocator("Email_XPATH"))).sendKeys(Utility.fetchLocator("TestEmail_XPATH"));
        driver.findElement(By.xpath(Utility.fetchLocator("Password_XPATH"))).sendKeys(Utility.fetchLocator("UpPassword_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Loginbtn_XPATH"))).click();
    }

    public void LoginTestAccount() throws IOException, InterruptedException {

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("shop_XPATH"))).sendKeys(Utility.fetchLocator("Shopname_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Email_XPATH"))).sendKeys(Utility.fetchLocator("Email_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Password_XPATH"))).sendKeys(Utility.fetchLocator("Password_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Loginbtn_XPATH"))).click();
    }

    public void LoginTestAccountSetUp() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("shop_XPATH"))).sendKeys(Utility.fetchLocator("Ashop_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Email_XPATH"))).sendKeys(Utility.fetchLocator("Aemail_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Password_XPATH"))).sendKeys(Utility.fetchLocator("Apassword_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Loginbtn_XPATH"))).click();
    }
}
