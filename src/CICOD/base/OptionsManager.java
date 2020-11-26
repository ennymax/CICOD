package CICOD.base;

import CICOD.utility.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;

public class OptionsManager {

	ChromeOptions co;
	FirefoxOptions fo;

	public void getChromeOptions(WebDriver driver) throws IOException {
		ChromeOptions chromeOptions = new ChromeOptions();
		if(Utility.fetchProperty("headless").toString().trim().equals("true")) co.addArguments("--headless");
		if(Utility.fetchProperty("incognito").toString().trim().equals("true")) co.addArguments("--incognito");

	}
	
	public FirefoxOptions getFirfoxOptions() throws IOException {
		fo = new FirefoxOptions();
		if(Utility.fetchProperty("incognito").toString().equals("true")) fo.addArguments("--headless");
		if(Utility.fetchProperty("incognito").toString().trim().equals("true")) fo.addArguments("--incognito");
		
		return fo;
	}
	
	

}
