package CROWN.EKEDC;

import CROWN.Base.TestBase;
import CROWN.utility.FileUpload;
import CROWN.utility.Randomstuff;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class WhistleBlowing_User_Not_LoggedIn extends TestBase {

    @Test
    public void WHISTLBLOWING() throws IOException, InterruptedException, AWTException {

            driver.findElement(By.linkText("Whistleblowing")).click();
            driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
            driver.findElement(By.id("form_business_unit")).click();
            new Select(driver.findElement(By.id("form_business_unit"))).selectByVisibleText("APAPA");
            driver.findElement(By.id("form_business_unit")).click();
            driver.findElement(By.id("form_address_line_1")).click();
            driver.findElement(By.id("form_address_line_1")).clear();
            driver.findElement(By.id("form_address_line_1")).sendKeys("20 RAHMAN ADEGBOYEJO STREET LEKKI");
            driver.findElement(By.id("form_nearest_bus_stop")).click();
            driver.findElement(By.id("form_nearest_bus_stop")).clear();
            driver.findElement(By.id("form_nearest_bus_stop")).sendKeys("alapere");
            driver.findElement(By.id("form_queue_type_id")).click();
            new Select(driver.findElement(By.id("form_queue_type_id"))).selectByVisibleText("EXTORTION OR SCAM ALERT");
            driver.findElement(By.id("form_queue_type_id")).click();
            driver.findElement(By.id("form_customer_name")).click();
            driver.findElement(By.id("form_customer_name")).clear();
            driver.findElement(By.id("form_customer_name")).sendKeys("R. HARUNA RILWAN ALHAJI");
            driver.findElement(By.id("form_contact_number")).click();
            driver.findElement(By.id("form_contact_number")).clear();
            driver.findElement(By.id("form_contact_number")).sendKeys("08155341117");
            driver.findElement(By.xpath("//div[@id='app']/div/div[2]/form/div[7]")).click();
            driver.findElement(By.id("form_email")).clear();
            driver.findElement(By.id("form_email")).sendKeys("demotestng@yopmail.com");
            driver.findElement(By.id("form_summary")).click();
            driver.findElement(By.id("form_summary")).clear();
            driver.findElement(By.id("form_summary")).sendKeys("summary");
            driver.findElement(By.id("form_description")).click();
            driver.findElement(By.id("form_description")).clear();
            driver.findElement(By.id("form_description")).sendKeys("decriptiom");
            driver.findElement(By.xpath("//div[@id='app']/div/div[2]/form/div[10]/div/button/i")).click();
            driver.findElement(By.xpath("//div[@id='app']/div/div[2]/form/div[10]/div/a/i")).click();
            driver.findElement(By.xpath("//div[@id='app']/div/div[2]/form/div[10]/div/button/i")).click();

            driver.findElement(By.xpath("//div[@id='app']/div/div[2]/form/div[11]/label")).click();
            driver.findElement(By.id("form_contact_number")).click();
            driver.findElement(By.id("form_contact_number")).clear();
            driver.findElement(By.id("form_contact_number")).sendKeys("08155341117");
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            driver.findElement(By.xpath("//div[2]/div/div/img")).click();
            driver.findElement(By.xpath("//a[contains(text(),'Go\n                                    back')]")).click();

    }
}
