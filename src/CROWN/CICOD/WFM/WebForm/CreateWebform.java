package CROWN.CICOD.WFM.WebForm;

import CROWN.Base.TestBase;
import CROWN.utility.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.springframework.context.annotation.Description;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.IOException;

@Epic("WebForm")
@Story("Test Webform Module Module..")
public class CreateWebform extends TestBase {

    @Description("Login to Cicod")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1)
    public void login() throws IOException, InterruptedException {
        Login login = new Login(driver);
        login.Login();
    }

    @Description("Access WFM")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2)
    public void WorkFlowManager() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoscrolltoViewClickWhenReady("Wfm_XPATH", 30);
    }

    @Description("Assert Successful Access of WFM")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3)
    public void AssertWorkFlowManager() throws IOException, InterruptedException {
        Assertion assertion = new Assertion(driver);
        assertion.DoAssertXpathAbsentWhenReady("wfmConfig_XPATH", "EscalationPass_TEXT", "EscalationFailed_TEXT", 30);
    }

    @Description("Access Configuration")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4)
    public void AccessConfiguration() throws IOException, InterruptedException {
        ActionsClass actionsClass = new ActionsClass(driver);
        actionsClass.DoClickActionclassWhenReady("wfmConfig_XPATH", 30);
    }

    @Description("Assert Webform and WorkOrder Extension")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 5)
    public void AssertWebForm_WorkOrderExtension() throws IOException, InterruptedException {
        Assertion assertion = new Assertion(driver);
        assertion.DoAssertXpathAbsentWhenReady("webform_XPATH", "WebPass_Text", "WebFailed_Text", 30);
        assertion.DoAssertXpathAbsentWhenReady("ExtendedWorkOrder_XPATH", "ExtendedPass_Text", "ExtendedFailed_Text", 30);
    }

    @Description("Access WebForm")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 6)
    public void Accesswebform() throws IOException, InterruptedException {
        ActionsClass actionsClass = new ActionsClass(driver);
        actionsClass.DoClickActionclassWhenReady("webform_XPATH", 30);
    }

    @Description("Create Web Form")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 7)
    public void CreateWebform() throws IOException, InterruptedException {
        JavaScriptUtil javaScriptUtil = new JavaScriptUtil(driver);
        javaScriptUtil.DoClickWhenReadyJS("CreateWebF_XPATH", 30);
    }

    @Description("Create Web Form")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 8)
    public void Webform_Name() throws IOException, InterruptedException {
        ActionsClass actionsClass = new ActionsClass(driver);
        Thread.sleep(5000);
        actionsClass.DoActionsSendKeysRandomListword("WebFormName_XPATH", 30);
    }

    @Description("Create Web Form Banner")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 9)
    public void Webform_Banner() throws IOException, InterruptedException, AWTException {
        FileUpload fileUpload = new FileUpload();
        ActionsClass actionsClass = new ActionsClass(driver);
        actionsClass.DoActionsSendKeysRandomListword("WebformBanner_XPATH", 30);
        fileUpload.UploadFileImage3MB();
    }

    @Description("Web Form Description")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 10)
    public void Webform_Description() throws IOException, InterruptedException, AWTException {
        ActionsClass actionsClass = new ActionsClass(driver);
        actionsClass.DoSendKeysByActionClassFluentWait("WebformDecritpion_XPATH", "Decrib_TEXT", 30);
    }

    @Description("Web Form Queue")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 11)
    public void Webform_Queue() throws IOException, InterruptedException, AWTException {
        ActionsClass actionsClass = new ActionsClass(driver);
        actionsClass.DoDoubleClickActionWhenReady("Webformqueue_XPATH", 30);
    }

    @Description("Queue")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 12)
    public void SelectQueueType() throws IOException, InterruptedException, AWTException {
        ActionsClass actionsClass = new ActionsClass(driver);
        Thread.sleep(5000);
        actionsClass.DoClickWithMoveToElement("Orderfufil_XPATH", 30);
        actionsClass.DoClickWithMoveToElement("source_XPATH", 30);
        Thread.sleep(99999999);
    }
}
