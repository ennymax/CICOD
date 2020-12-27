package CROWN.utility;

import CROWN.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class DatePicker extends TestBase {

    WebDriver driver;

    public DatePicker(WebDriver driver) {
        this.driver = driver;
    }

    public void DatePickerJE(String locator, String Date) throws IOException {
        WebElement select = driver.findElement(By.xpath(Utility.fetchLocator(locator)));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].type = arguments[1]", select, "text");
        select.sendKeys(Date);
    }

    public static void SetDate(String locator, String Date, WebDriver driver) {
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        String script = "arguments[0].setAttribute('value','"+Date+"');";
        jse.executeScript(script, locator);
    }

}