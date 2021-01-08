package CROWN.Base;

import CROWN.utility.ScreenShot;
import CROWN.utility.Utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.testng.ITestResult.SUCCESS;

public class TestBase {

    public WebDriver driver;
    public static ExtentReports extent;
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentTest test;

    private static final String OUTPUT_FOLDER = "./Report/";
    private static final String FILE_NAME = "Report" + System.currentTimeMillis() + ".html";

    @BeforeSuite(alwaysRun = true)
    public void setup() throws Exception {
        Path path = Paths.get(OUTPUT_FOLDER);
        // if directory exists?
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                // fail to create directory
                e.printStackTrace();
            }
        }
        htmlReporter = new ExtentHtmlReporter(OUTPUT_FOLDER + FILE_NAME);

        htmlReporter.config().setDocumentTitle(Utility.fetchProperty("ProjectName").toString());
        htmlReporter.config().setReportName(Utility.fetchProperty("Tname").toString());
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setReportUsesManualConfiguration(true);

        extent.setSystemInfo("Hostname", "LocalHost");
        extent.setSystemInfo("TesterName", Utility.fetchProperty("Tname").toString());
        extent.setSystemInfo("OS", "Window10");
        extent.setSystemInfo("Browser", Utility.fetchProperty("browserName").toString());
    }

    @BeforeClass(alwaysRun = true)
    public void setUp() throws IOException {

        if (Utility.fetchProperty("browserName").toString().equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            if (Boolean.parseBoolean(Utility.fetchProperty("LunchOption").toString())) {
                driver = new ChromeDriver();
            } else {
                ChromeOptions options = new ChromeOptions();
                if (Utility.fetchProperty("headless").toString().trim().equals("true"))
                    options.addArguments("--headless");
                if (Utility.fetchProperty("incognito").toString().trim().equals("true"))
                    options.addArguments("--incognito");
                driver = new ChromeDriver(options);
            }
            System.out.println("*****************************" + Utility.fetchProperty("browserName") + " browser running ****************************************");

        } else if (Utility.fetchProperty("browserName").toString().equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            if (Boolean.parseBoolean(Utility.fetchProperty("LunchOption").toString())) {
                driver = new FirefoxDriver();
            } else {
                FirefoxOptions options = new FirefoxOptions();
                if (Utility.fetchProperty("headless").toString().trim().equals("true"))
                    options.addArguments("--headless");
                if (Utility.fetchProperty("incognito").toString().trim().equals("true"))
                    options.addArguments("--incognito");
                driver = new FirefoxDriver(options);
            }
            System.out.println("*****************************" + Utility.fetchProperty("browserName") + " browser running ****************************************");

        } else if (Utility.fetchProperty("browserName").toString().equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            System.out.println("*****************************" + Utility.fetchProperty("browserName") + " browser running ****************************************");
        } else if (Utility.fetchProperty("browserName").toString().equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
            System.out.println("*****************************" + Utility.fetchProperty("browserName") + " browser running ****************************************");
        } else if (Utility.fetchProperty("browserName").toString().equalsIgnoreCase("RemoteFirefox")) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("version", "85.0");
            caps.setCapability("enableVNC", true);
            //cap.setCapability("enableVideo", true);
            if (Utility.fetchProperty("headless").toString().trim().equals("true"))
                caps.setCapability("headless", true);

            try {
                driver = new RemoteWebDriver(new URL(Utility.fetchProperty("applicationUrl").toString()), caps);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        } else if (Utility.fetchProperty("browserName").toString().equalsIgnoreCase("RemoteChrome")) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("version", "85.0");
            caps.setCapability("enableVNC", true);
            //cap.setCapability("enableVideo", true);
            if (Utility.fetchProperty("headless").toString().trim().equals("true"))
                caps.setCapability("headless", true);


            try {
                driver = new RemoteWebDriver(new URL(Utility.fetchProperty("applicationUrl").toString()), caps);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Please pass the correct browser name....");
        }

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);


        if (Utility.fetchProperty("Project").toString().equalsIgnoreCase("CICOD")) {

            if (Boolean.parseBoolean(Utility.fetchProperty("CICODPROD").toString())) {
                driver.get(Utility.fetchProperty("applicationUrlCICODPROD").toString());
            } else {
                driver.get(Utility.fetchProperty("applicationUrlCICODSTAGGING").toString());
            }
        } else if (Utility.fetchProperty("Project").toString().equalsIgnoreCase("EKEDC")) {

            if (Boolean.parseBoolean(Utility.fetchProperty("EKEDCPROD").toString())) {
                driver.get(Utility.fetchProperty("applicationUrlEKEDCPROD").toString());
            } else {
                driver.get(Utility.fetchProperty("applicationUrlEKEDCSTAGGING").toString());
            }
        }
    }

    @AfterMethod(alwaysRun = true)
    public void getResult(ITestResult result) throws Exception {
        ScreenShot screenShot = new ScreenShot(driver);

        if (result.getStatus() == ITestResult.FAILURE) {
            screenShot.ScreenShot();
            test.fail(MarkupHelper.createLabel(result.getName() + " The Test Case Failed", ExtentColor.RED));
            test.fail(result.getThrowable());

        } else if (result.getStatus() == SUCCESS) {
            screenShot.ScreenShot();
            test.pass(MarkupHelper.createLabel(result.getName() + " The Test Case Passed", ExtentColor.GREEN));
            test.getModel().setEndTime(getTime(result.getEndMillis()));

        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip(MarkupHelper.createLabel(result.getName() + " The Test Case Skipped", ExtentColor.YELLOW));
        }

        extent.flush();
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }

    @BeforeMethod(alwaysRun = true)
    public void TestName(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName().toUpperCase());
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
