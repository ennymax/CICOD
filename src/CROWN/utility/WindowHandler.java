package CROWN.utility;

import org.openqa.selenium.WebDriver;

public class WindowHandler {

    WebDriver driver;

    public static String switchToWindowTest(WebDriver driver, String title) {

        return driver.getWindowHandles()
                .stream()
                .map(handler -> driver.switchTo().window(handler).getTitle())
                .filter(ele -> ele.contains(title))
                .findFirst()
                .orElseThrow(() -> {
                    throw new RuntimeException("No Such window");
                });
    }
}
