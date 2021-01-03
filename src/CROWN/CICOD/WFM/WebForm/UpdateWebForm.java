package CROWN.CICOD.WFM.WebForm;

import CROWN.Base.TestBase;
import CROWN.utility.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.springframework.context.annotation.Description;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.IOException;

@Epic("Update WebForm")
@Story("Test Webform Module Module..")
public class UpdateWebForm extends TestBase {

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

    @Description("Acton Button")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 7)
    public void ActonButton() throws IOException, InterruptedException {
        Thread.sleep(4000);
         driver.findElement(By.name("yt9")).click();
    }

    @Description("Update")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 8)
    public void Update() throws IOException, InterruptedException {
        ActionsClass actionsClass = new ActionsClass(driver);
        actionsClass.DoClickActionclassWhenReady("webformUpdate_XPATH", 30);
    }

    @Description("Save Web Form")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 22)
    public void SaveWebForm() throws IOException, InterruptedException, AWTException {
        Utility utility = new Utility(driver);
        utility.DoclickWhenReady("s11_XPATH","Ooo_TEXT",30);
    }
}
