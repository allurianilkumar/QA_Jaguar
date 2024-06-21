/**
 * Created by admin-aneel on 12/3/16.
 */
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

public class IgniteBarComponent {
    public static void main(String[] args) throws InterruptedException {
        DesiredCapabilities capabilities= DesiredCapabilities.firefox();
        capabilities.setJavascriptEnabled(true);
        WebDriver driver = new FirefoxDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://www.jaguar.co.uk");
        System.out.println(driver.getTitle());


        WebElement mainSection = driver.findElement(By.className("main-section"));
        WebElement igniteBarComponent = mainSection.findElement(By.className("igniteBar-component"));
        System.out.println("the X value name is "+igniteBarComponent.getLocation().getX());
        System.out.println("the Y value name is "+igniteBarComponent.getLocation().getY());
        System.out.println("the width is "+igniteBarComponent.getCssValue("width"));
        System.out.println("the height is "+igniteBarComponent.getCssValue("height"));
        WebElement  igniteBarItemsUl = igniteBarComponent.findElement(By.className("igniteBar__items"));
        new Actions(driver).moveToElement(igniteBarItemsUl).perform();
        List<WebElement> igniteBarItems = igniteBarItemsUl.findElements(By.className("igniteBar__item"));
        for(int i=0;i< igniteBarItems.size();i++){
            WebElement igniteBarLink = igniteBarItems.get(i).findElement(By.className("igniteBar__link"));
            WebElement igniteBarLabelName =  igniteBarLink.findElement(By.className("igniteBar__label"));
            try{
                new Actions(driver).moveToElement(igniteBarLabelName).perform();
                Thread.sleep(4000);
            }catch(Exception e){
                e.printStackTrace();
            }

            System.out.println("the name is "+igniteBarLabelName.getText());
        }

        driver.findElement(By.tagName("body")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.tagName("body")).sendKeys(Keys.ARROW_DOWN);
        WebElement mainSection2 = driver.findElement(By.className("main-section"));
        WebElement igniteBarComponent2 = mainSection2.findElement(By.className("igniteBar-component"));
        String classNameForIgniteBarComponent = igniteBarComponent2.getAttribute("class");
        //if(classNameForIgniteBarComponent.contains("js--closing") )&& (igniteBarComponent2.getLocation().getY() != igniteBarComponent.getLocation().getY() )){
        int y1 = igniteBarComponent.getLocation().getY();
        int y2 = igniteBarComponent2.getLocation().getY();
        if(y1 != y1){
            //Assert.assertTrue(true);
            System.out.println("true");
        }else{
            //Assert.assertTrue(false);
            System.out.println("False");
        }
        System.out.println("the X value name is "+igniteBarComponent2.getLocation().getX());
        System.out.println("the Y value name is "+igniteBarComponent2.getLocation().getY());
        System.out.println("the width is "+igniteBarComponent2.getCssValue("width"));
        System.out.println("the height is "+igniteBarComponent2.getCssValue("height"));

    }
    public static void scrollInToElement(WebDriver driver,WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
