package Components;


import constants.ApplicationConstants;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.BrowserFactory;
import utils.CommonUtil;
import java.util.List;

/**
 * Created by admin-aneel on 22/01/2016.
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
    public void openGoogle(String title_name) throws Throwable {
        driver.manage().window().maximize();
        driver.get("http://www.jaguar.co.uk");
        driver.findElement(By.linkText("XE")).click();
        driver.findElement(By.cssSelector("#tcm91x211931xv2 > section.frameSlider-container > div:nth-child(4) > a")).click();
        WebElement contentOverlayBlock = driver.findElement(By.cssSelector("#tcm91x211931xv2 > section:nth-child(3)"));
        String modelTitleName = contentOverlayBlock.findElement(By.tagName("h1")).getText();
        System.out.println("This is the Model Title Name is "+modelTitleName);
        String modelTitleNameComment = contentOverlayBlock.findElement(By.tagName("p")).getText();
        System.out.println("This is the Model Title Name is "+modelTitleNameComment);

        WebElement contentOverlayBlockInfoDetails= driver.findElement(By.cssSelector("#tcm91x211931xv2 > section:nth-child(5)"));
        String from= contentOverlayBlockInfoDetails.findElement(By.tagName("p")).getText();
        String price = contentOverlayBlockInfoDetails.findElement(By.tagName("h2")).getText();
        System.out.println("sub tile value is "+from+"::"+price);
        List<WebElement> listItemsUl= contentOverlayBlockInfoDetails.findElements(By.tagName("ul"));
        List<WebElement> subUlList1 = listItemsUl.get(0).findElements(By.tagName("li"));
        List<WebElement> subUlList2 = listItemsUl.get(1).findElements(By.tagName("li"));
        for(int i=0;i<subUlList1.size();i++){
            System.out.println(i+":: value is "+subUlList1.get(i).getText().trim());
        }
        for(int j=0;j<subUlList2.size();j++){
            System.out.println(j+":: value is "+subUlList2.get(j).getText().trim());
        }
        // Moving the scroll into from left side to right side
        WebElement noUiSlider = driver.findElement(By.cssSelector("#tcm91x211931xv2 > section.frameSlider-container > div.noUiSlider-container > div"));
        System.out.println("this noUiSlider location values is "+noUiSlider.getLocation());
        WebElement button = driver.findElement(By.cssSelector("#tcm91x211931xv2 > section.frameSlider-container > div.noUiSlider-container > div > div > div > div"));
        System.out.println("this noUiSlider location values is "+button.getLocation());
        Actions action = new Actions(driver);
        action.clickAndHold(button).build().perform();
        int x1=button.getLocation().getX();
        int y1= button.getLocation().getY();
        int x2= noUiSlider.getLocation().getX();
        int y2=noUiSlider.getLocation().getY();
        for (;x1<=x2 && y1<=y2;x1++,y1++){
            action.moveByOffset(x1,y1).build().perform();
            Thread.sleep(1000);
        }
        System.out.print("ending now");
    }
}
