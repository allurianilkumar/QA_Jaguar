package Components;

import constants.ApplicationConstants;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.CommonUtil;

/**
 * Created by admin on 25/03/2016.
 */
public class OpenBasePage {


    private static WebDriver driver;


    @Before("@openBaseURL")
    public static void setUp() throws Exception {
        driver = BrowserFactory.getDriver();
        CommonUtil.setWindowSize(driver, ApplicationConstants.DESKTOP);
        CommonUtil.setImplicitlyWaitTime(driver, 5);

    }

    @After("@openBaseURL")
    public static void tearDown() throws Exception {
        CommonUtil.quitBrowser(driver);
    }

    @Given("^I open landrover$")
    public void openBaseURL() throws Throwable {
        driver.get("http://www.landrover.co.uk/index.html");
        System.out.println("the tile name is "+driver.getTitle());
        // Home Page Title
        Assert.assertEquals(driver.getTitle().toString().trim(),"Premium 4X4 Vehicles & Luxury SUV's - Land Rover UK");
        // Logic for Our Vehicle
        WebElement ourVehicle = driver.findElement(By.cssSelector("#\\32 95-131615")); // #e9ecec

        // gettign the rgba(233, 236, 236, 1) format
        String ourVehicleBackgroundColor = ourVehicle.getCssValue("background-color");
        System.out.println("the background color(#e9ecec) is "+ourVehicleBackgroundColor); // rgba(233, 236, 236, 1)
        // our vehicle title heading
        String  ourVehicleTitle = driver.findElement(By.cssSelector("#\\32 95-131615 > div.headerBlock > h2 > span > span")).getText();
        System.out.println("The Our Vehicle Title is "+ourVehicleTitle); // Our Vehicle

        // converting the rgba to hexa value format
        String[] hexValue = ourVehicleBackgroundColor.replace("rgba(", "").replace(")", "").split(",");

        int hexValue1 = Integer.parseInt(hexValue[0]);
        hexValue[1] = hexValue[1].trim();
        int hexValue2 = Integer.parseInt(hexValue[1]);
        hexValue[2] = hexValue[2].trim();
        int hexValue3 = Integer.parseInt(hexValue[2]);

        String ourVehicleBgrColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
        System.out.println("Our Vehicle Title background(#e9ecec) color is "+ourVehicleBgrColor);
        Assert.assertEquals(ourVehicleBgrColor,"#e9ecec");
    }
}
