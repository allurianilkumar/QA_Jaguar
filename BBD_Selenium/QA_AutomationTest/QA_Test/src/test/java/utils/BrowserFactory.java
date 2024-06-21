package utils;

import constants.ApplicationConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by zeeshan.edwards on 28/01/2015.
 */

public class BrowserFactory {


    public static WebDriver driver = null;
    public static Browsers browser;

    // enum for the browsers
    public enum Browsers {
        CHROME, FIREFOX, SAFARI
    }

    static {
        loadProperties();
        if ((ApplicationConstants.EMPTY_STRING).equals(System.getProperty(ApplicationConstants.PROPERTY_BROWSER_KEY)) || System.getProperty(ApplicationConstants.PROPERTY_BROWSER_KEY) == null) {
            browser = Browsers.FIREFOX;
        } else {
            browser = Browsers.valueOf(System.getProperty(ApplicationConstants.PROPERTY_BROWSER_KEY));
        }
    }


    public static WebDriver getDriver() {
        switch (browser) {
            case CHROME:
                driver = new ChromeDriver();
                break;
            case SAFARI:
                driver = new SafariDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            default:
                driver = new FirefoxDriver();
                break;
        }
        return driver;
    }

    private static void loadProperties() {
        Properties p;
        try (FileInputStream propFile = new FileInputStream(ApplicationConstants.APPLICATION_PROPERTIES_FILE)) {
            p = new Properties(System.getProperties());
            p.load(propFile);
            System.setProperties(p);
            System.setProperty(ApplicationConstants.CHROME_DRIVER, ApplicationConstants.CHROME_DRIVER_EXE_PATH);
            System.setProperty(ApplicationConstants.FIREFOX_DRIVER_DEFAULT, ApplicationConstants.FIREFOX_DRIVER_EXE_PATH_DEFAULT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
