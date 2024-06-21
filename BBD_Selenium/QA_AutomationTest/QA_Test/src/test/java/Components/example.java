package Components;

import constants.ApplicationConstants;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.CommonUtil;

/**
 * Created by vikkigregory on 22/01/2016.
 */
public class example {


    private static WebDriver driver;


    @Before("@testOne")
    public static void setUp() throws Exception {
        driver = BrowserFactory.getDriver();
        CommonUtil.setWindowSize(driver, ApplicationConstants.DESKTOP);
        CommonUtil.setImplicitlyWaitTime(driver, 5);

    }

    @After("@testOne")
    public static void tearDown() throws Exception {
        CommonUtil.quitBrowser(driver);
    }

    @Given("^I open google \"(.*)\"$")
    public void i_open_google(String title_name) throws Throwable {
      driver.get("http://www.google.com");
        System.out.println("this is tile name "+title_name);
    }
}
