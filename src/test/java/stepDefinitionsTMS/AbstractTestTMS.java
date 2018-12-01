package stepDefinitionsTMS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.util.concurrent.TimeUnit.SECONDS;

public class AbstractTestTMS {
    protected static WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null) {
            System.out.println("--------------------------------SET UP -------------------------");
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\joeye\\Documents\\Automation Test\\geckodriver.exe");
            System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(10, SECONDS);
        }
        return driver;
    }
}
