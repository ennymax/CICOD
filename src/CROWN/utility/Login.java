package CROWN.utility;

import org.openqa.selenium.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Login {
    WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void AcceptAlert() throws IOException, InterruptedException {
        if (driver.switchTo().alert() != null)
        {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
    }

    public void AlertDismis() throws IOException, InterruptedException {
        if (driver.switchTo().alert() != null) {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        }
    }

    public void LoginDef1() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility1 = new Utility(driver);

        ActionsClass utility = new ActionsClass(driver);

        utility.DoSendKeysByActionClassWhenReady("DomainName_XPATH", "DefShopName_TEXT", "DefShopName_TEXT", 20);
        utility.DoSendKeysByActionClassWhenReady("Email_XPATH", "DefEmail_TEXT", "DefEmail_TEXT", 20);
        utility.DoSendKeysByActionClassWhenReady("Password_XPATH", "DefPassword_TEXT", "DefPassword_TEXT", 20);
        utility1.DoclickWhenReady("LoginBTN_XPATH", "Logi_TEXT", 30);
    }

    public void LoginNexus() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility1 = new Utility(driver);
        ActionsClass utility = new ActionsClass(driver);

        utility.DoSendKeysByActionClassWhenReady("DomainName_XPATH", "NexusDomainName1_TEXT", "DOma_TEXT", 20);
        utility.DoSendKeysByActionClassWhenReady("Email_XPATH", "NexusEmail1_TEXT", "Emailf_TEXT", 20);
        utility.DoSendKeysByActionClassWhenReady("Password_XPATH", "NexusPassword1_TEXT", "Passw_TEXT", 20);
        utility1.DoclickWhenReady("LoginBTN_XPATH", "Logi_TEXT", 30);
    }

    public void LoginPremium() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility1 = new Utility(driver);
        ActionsClass utility = new ActionsClass(driver);

        utility.DoSendKeysByActionClassWhenReady("DomainName_XPATH", "PshopName_TEXT", "DOma_TEXT", 20);
        utility.DoSendKeysByActionClassWhenReady("Email_XPATH", "Pemail_TEXT", "Emailf_TEXT", 20);
        utility.DoSendKeysByActionClassWhenReady("Password_XPATH", "Ppassword_TEXT", "Passw_TEXT", 20);
        utility1.DoclickWhenReady("LoginBTN_XPATH", "Logi_TEXT", 30);
    }

    public void LoginWrongDomainName() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility1 = new Utility(driver);
        ActionsClass utility = new ActionsClass(driver);

        utility.DoSendKeysByActionClassWhenReady("DomainName_XPATH", "DefaultShopName_TEXT", "DOma_TEXT", 20);
        utility.DoSendKeysByActionClassWhenReady("Email_XPATH", "UcgEmail1_TEXT", "Emailf_TEXT", 20);
        utility.DoSendKeysByActionClassWhenReady("Password_XPATH", "UcgPassword1_TEXT", "Passw_TEXT", 20);
        utility1.DoclickWhenReady("LoginBTN_XPATH", "Logi_TEXT", 30);
    }

    public void LoginWrongEmail() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility1 = new Utility(driver);
        ActionsClass utility = new ActionsClass(driver);

        utility.DoSendKeysByActionClassWhenReady("DomainName_XPATH", "UcgDomainName1_TEXT", "DOma_TEXT", 20);
        utility.DoSendKeysByActionClassWhenReady("Email_XPATH", "DefaultEmail_TEXT", "Emailf_TEXT", 20);
        utility.DoSendKeysByActionClassWhenReady("Password_XPATH", "UcgPassword1_TEXT", "Passw_TEXT", 20);
        utility1.DoclickWhenReady("LoginBTN_XPATH", "Logi_TEXT", 30);
    }

    public void LoginWrongPassWord() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility1 = new Utility(driver);
        ActionsClass utility = new ActionsClass(driver);

        utility.DoSendKeysByActionClassWhenReady("DomainName_XPATH", "UcgDomainName1_TEXT", "UcgDomainName1_TEXT", 20);
        utility.DoSendKeysByActionClassWhenReady("Email_XPATH", "UcgEmail1_TEXT", "UcgEmail1_TEXT", 20);
        utility.DoSendKeysByActionClassWhenReady("Password_XPATH", "DefaultPassWord_TEXT", "UcgPassword1_TEXT", 20);
        utility1.DoclickWhenReady("LoginBTN_XPATH", "Logi_TEXT", 30);
    }

    public void LoginCorrectDetails() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility1 = new Utility(driver);
        ActionsClass utility = new ActionsClass(driver);

        utility.DoSendKeysByActionClassWhenReady("DomainName_XPATH", "UcgDomainName1_TEXT", "UcgDomainName1_TEXT", 20);
        utility.DoSendKeysByActionClassWhenReady("Email_XPATH", "UcgEmail1_TEXT", "UcgEmail1_TEXT", 20);
        utility.DoSendKeysByActionClassWhenReady("Password_XPATH", "UcgPassword1_TEXT", "UcgPassword1_TEXT", 20);
        utility1.DoclickWhenReady("LoginBTN_XPATH", "Logi_TEXT", 30);
    }

    public void LoginDefault() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility1 = new Utility(driver);
        ActionsClass utility = new ActionsClass(driver);

        utility.DoSendKeysByActionClassWhenReady("DomainName_XPATH", "DefaultShop_TEXT", "DOma_TEXT", 20);
        utility.DoSendKeysByActionClassWhenReady("Email_XPATH", "Defem_TEXT", "Emailf_TEXT", 20);
        utility.DoSendKeysByActionClassWhenReady("Password_XPATH", "defpass_TEXT", "Passw_TEXT", 20);
        utility1.DoclickWhenReady("LoginBTN_XPATH", "Logi_TEXT", 30);
    }

    public void Loginlupin() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility1 = new Utility(driver);
        ActionsClass utility = new ActionsClass(driver);

        utility.DoSendKeysByActionClassWhenReady("DomainName_XPATH", "lupinDomainName_TEXT", "DOma_TEXT", 20);
        utility.DoSendKeysByActionClassWhenReady("Email_XPATH", "lupinEmail_TEXT", "Emailf_TEXT", 20);
        utility.DoSendKeysByActionClassWhenReady("Password_XPATH", "lupinPass_TEXT", "Passw_TEXT", 20);
        utility1.DoclickWhenReady("LoginBTN_XPATH", "Logi_TEXT", 30);
    }

    public void Login() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility1 = new Utility(driver);
        ActionsClass utility = new ActionsClass(driver);

        utility.DoSendKeysByActionClassWhenReady("DomainName_XPATH", "NexusDomainName1_TEXT", "DOma_TEXT", 20);
        utility.DoSendKeysByActionClassWhenReady("Email_XPATH", "NexusEmail1_TEXT", "Emailf_TEXT", 20);
        utility.DoSendKeysByActionClassWhenReady("Password_XPATH", "NexusPassword1_TEXT", "Passw_TEXT", 20);
        utility1.DoclickWhenReady("LoginBTN_XPATH", "Logi_TEXT", 30);
    }

    public void LoginExpiredAccount() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility1 = new Utility(driver);
        ActionsClass utility = new ActionsClass(driver);

        utility.DoSendKeysByActionClassWhenReady("DomainName_XPATH", "Cshopname_TEXT", "DOma_TEXT", 20);
        utility.DoSendKeysByActionClassWhenReady("Email_XPATH", "Cemail_TEXT", "Emailf_TEXT", 20);
        utility.DoSendKeysByActionClassWhenReady("Password_XPATH", "Cpassword_TEXT", "Passw_TEXT", 20);
        utility1.DoclickWhenReady("LoginBTN_XPATH", "Logi_TEXT", 30);
    }

    public void LoginUpgrade() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility1 = new Utility(driver);
        ActionsClass utility = new ActionsClass(driver);

        utility.DoSendKeysByActionClassWhenReady("DomainName_XPATH", "TestShopName_XPATH", "DOma_TEXT", 20);
        utility.DoSendKeysByActionClassWhenReady("Email_XPATH", "TestEmail_XPATH", "Emailf_TEXT", 20);
        utility.DoSendKeysByActionClassWhenReady("Password_XPATH", "UpPassword_TEXT", "Passw_TEXT", 20);
        utility1.DoclickWhenReady("LoginBTN_XPATH", "Logi_TEXT", 30);
    }

    public void LoginTestAccount() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility1 = new Utility(driver);
        ActionsClass utility = new ActionsClass(driver);

        utility.DoSendKeysByActionClassWhenReady("DomainName_XPATH", "Shopname_TEXT", "DOma_TEXT", 20);
        utility.DoSendKeysByActionClassWhenReady("Email_XPATH", "Email_TEXT", "Emailf_TEXT", 20);
        utility.DoSendKeysByActionClassWhenReady("Password_XPATH", "Password_TEXT", "Passw_TEXT", 20);
        utility1.DoclickWhenReady("LoginBTN_XPATH", "Logi_TEXT", 30);
    }

    public void LoginTestAccountSetUp() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        Utility utility1 = new Utility(driver);
        ActionsClass utility = new ActionsClass(driver);

        utility.DoSendKeysByActionClassWhenReady("DomainName_XPATH", "Ashop_TEXT", "DOma_TEXT", 20);
        utility.DoSendKeysByActionClassWhenReady("Email_XPATH", "Aemail_TEXT", "Emailf_TEXT", 20);
        utility.DoSendKeysByActionClassWhenReady("Password_XPATH", "Apassword_TEXT", "Passw_TEXT", 20);
        utility1.DoclickWhenReady("LoginBTN_XPATH", "Logi_TEXT", 30);
    }


    public void LoginMultipleAccountEKEDC() throws IOException, InterruptedException {

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Loginbtn_XPATH"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Lemail_XPATH"))).sendKeys(Utility.fetchLocator("MultiEMail_TEXT"));
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Lpassword_XPATH"))).sendKeys(Utility.fetchLocator("MultiPassword_TEXT"));

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("Lcheckbox_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ActualRegisterBTN_XPATH"))).click();
    }

    public void LoginEKEDC() throws IOException, InterruptedException {

        driver.findElement(By.xpath(Utility.fetchLocator("Loginbtn_XPATH"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Lemail_XPATH"))).sendKeys(Utility.fetchLocator("ExistEmail_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Lpassword_XPATH"))).sendKeys(Utility.fetchLocator("password_TEXT"));

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("Lcheckbox_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        driver.findElement(By.xpath(Utility.fetchLocator("ActualRegisterBTN_XPATH"))).click();
    }


    public void Login_with_RegEmailEKEDC() throws IOException {

        driver.findElement(By.xpath(Utility.fetchLocator("Loginbtn_XPATH"))).click();
        driver.findElement(By.xpath(Utility.fetchLocator("Lemail_XPATH"))).sendKeys(Utility.fetchLocator("ExistEmail_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Lpassword_XPATH"))).sendKeys(Utility.fetchLocator("password_TEXT"));

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("Lcheckbox_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        driver.findElement(By.xpath(Utility.fetchLocator("ActualRegisterBTN_XPATH"))).click();

    }

    public void Login_with_Wrong_EmailEKEDC() throws IOException {

        driver.findElement(By.xpath(Utility.fetchLocator("Loginbtn_XPATH"))).click();
        driver.findElement(By.xpath(Utility.fetchLocator("Lemail_XPATH"))).sendKeys(Utility.fetchLocator("WrongEmail_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Lpassword_XPATH"))).sendKeys(Utility.fetchLocator("RegNumber_TEXT"));

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("Lcheckbox_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        driver.findElement(By.xpath(Utility.fetchLocator("ActualRegisterBTN_XPATH"))).click();

    }

    public void Login_with_Wrong_PasswordEKEDC() throws IOException {

        driver.findElement(By.xpath(Utility.fetchLocator("Loginbtn_XPATH"))).click();
        driver.findElement(By.xpath(Utility.fetchLocator("Lemail_XPATH"))).sendKeys(Utility.fetchLocator("WrongEmail_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Lpassword_XPATH"))).sendKeys(Utility.fetchLocator("WrongPassword_TEXT"));

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("Lcheckbox_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        driver.findElement(By.xpath(Utility.fetchLocator("ActualRegisterBTN_XPATH"))).click();

    }


    public void Login_PostPaidLandlordEKEDC() throws IOException {

        driver.findElement(By.xpath(Utility.fetchLocator("Loginbtn_XPATH"))).click();
        driver.findElement(By.xpath(Utility.fetchLocator("Lemail_XPATH"))).sendKeys(Utility.fetchLocator("EEmail_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Lpassword_XPATH"))).sendKeys(Utility.fetchLocator("EPassword_TEXT"));

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("Lcheckbox_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        driver.findElement(By.xpath(Utility.fetchLocator("ActualRegisterBTN_XPATH"))).click();
    }

    public void LoginPrePaidEKEDC() throws IOException {

        driver.findElement(By.xpath(Utility.fetchLocator("Loginbtn_XPATH"))).click();
        driver.findElement(By.xpath(Utility.fetchLocator("Lemail_XPATH"))).sendKeys(Utility.fetchLocator("PreEmail_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Lpassword_XPATH"))).sendKeys(Utility.fetchLocator("PrePassword_TEXT"));

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("Lcheckbox_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        driver.findElement(By.xpath(Utility.fetchLocator("ActualRegisterBTN_XPATH"))).click();

    }

}
