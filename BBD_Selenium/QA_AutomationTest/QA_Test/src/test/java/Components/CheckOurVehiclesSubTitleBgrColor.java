package Components;

import constants.ApplicationConstants;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.CommonUtil;

/**
 * Created by admin-aneel on 28/3/16.
 */
public class CheckOurVehiclesSubTitleBgrColor {

    private static WebDriver driver;
    private static String ourVehicleTitle;
    private static String ourVehicleBackgroundColor;


    @Before("@testTwo")
    public static void setUp() throws Exception {
        driver = BrowserFactory.getDriver();
        CommonUtil.setWindowSize(driver, ApplicationConstants.DESKTOP);
        CommonUtil.setImplicitlyWaitTime(driver, 5);

    }

    @After("@testTwo")
    public static void tearDown() throws Exception {
        CommonUtil.quitBrowser(driver);
    }

    @Given("^I open landrover home page with title \"(.*)\"$")
    public void openHomePage(String homePageTitle) throws Throwable {
        driver.get("http://www.landrover.co.uk/index.html");
        Assert.assertEquals( homePageTitle, driver.getTitle().toString().trim());


    }
    @When("^I view Our Vehicle sub title and background color in Stacked Blocks$")
    public void ourVehicleTitleAndBackgroundColor(){
        // our vehicle title heading
        CommonUtil.scrollInToElement(driver, driver.findElement(By.cssSelector("#\\32 95-131615 > div.headerBlock > h2 > span > span")));
        ourVehicleTitle = driver.findElement(By.cssSelector("#\\32 95-131615 > div.headerBlock > h2 > span > span")).getText();

        // Logic for Our Vehicles Background Color
        CommonUtil.scrollInToElement(driver, driver.findElement(By.cssSelector("#\\32 95-131615")));
        WebElement ourVehicle = driver.findElement(By.cssSelector("#\\32 95-131615")); // #e9ecec
        // gettign the rgba(233, 236, 236, 1) format
        ourVehicleBackgroundColor = ourVehicle.getCssValue("background-color");

    }

    @Then("^I will check Our Vehicle title is \"(.*)\" and background color is \"(.*)\"$")
    public void checkOurVehicleTitleAndBackgroundColor(String subtitle, String subtitleBackgroundColor){
        Assert.assertEquals(subtitle,ourVehicleTitle.toString().trim());
        // converting the rgba to hexa value format
        String[] hexValue = ourVehicleBackgroundColor.replace("rgba(", "").replace(")", "").split(",");
        int hexValue1 = Integer.parseInt(hexValue[0]);
        hexValue[1] = hexValue[1].trim();
        int hexValue2 = Integer.parseInt(hexValue[1]);
        hexValue[2] = hexValue[2].trim();
        int hexValue3 = Integer.parseInt(hexValue[2]);
        String ourVehiclesBgrColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
        Assert.assertEquals(subtitleBackgroundColor, ourVehiclesBgrColor);
    }

}
