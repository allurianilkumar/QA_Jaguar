import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * Created by antreetech on 13/4/16.
 */
public class LightweightAluminiumArchitecture {
    public static  void main(String[] arg) throws Exception {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://www.jaguar.co.uk");
        driver.findElement(By.linkText("XE")).click();
        driver.findElement(By.linkText("FEATURES")).click();
        scrollInToElement(driver,driver.findElement(By.cssSelector("body > div.main-section > div:nth-child(10) > div > div.el.width-2of3 > section > div > div > img.slide-img.before.twentytwenty-before")));
        WebElement button= driver.findElement(By.cssSelector("body > div.main-section > div:nth-child(10) > div > div.el.width-2of3 > section > div > div > div.twentytwenty-handle"));
        //WebElement button1= driver.findElement(By.cssSelector("body > div.main-section > div:nth-child(10) > div > div.el.width-2of3 > section > div > div > div.twentytwenty-handle"));
        System.out.println("this noUiSlider location values is "+button.getLocation());
        WebElement button1 =  driver.findElement(By.cssSelector("body > div.main-section > div:nth-child(10) > div > div.el.width-2of3 > section > div > div > div.twentytwenty-handle > span.twentytwenty-right-arrow"));
        //System.out.println("this noUiSlider location values is "+button1.getLocation());
        //Actions action = new Actions(driver);
        //action.clickAndHold(button).build().perform();
        //action.clickAndHold(button).moveByOffset(718,button.getLocation().getY()-1).build().perform();

        int x1=button.getLocation().getX();
        int y1= button.getLocation().getY();
        int x2= 13;
        int y2= button.getLocation().getY()-1;
        System.out.println("the value of x is "+x1);
        System.out.println("the value of y is "+y1);
        System.out.println("the value of width is "+button.getCssValue("width"));
        System.out.println("the value of height is "+button.getCssValue("height"));
        Actions action = new Actions(driver);
        //action.clickAndHold(button).build().perform();
        WebElement test = driver.findElement(By.cssSelector("body > div.main-section > div:nth-child(10) > div > div.el.width-1of3"));
        action.dragAndDropBy(button,715, 1539).release().build().perform();
        //action.moveByOffset(717,1539).build().perform();
        // Configure the Action
        //builder.clickAndHold(button).build().perform();
        //Action act= builder.clickAndHold(button).dragAndDropBy(button,718,button.getLocation().getY()-1).build();
        //act.perform();
        //dragAndDropBy(button,718,button.getLocation().getY()-1).build();


        try{
            //Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        //for (;x1<=x2 && y1<=y2;x1++,y1++){
            //action.moveByOffset(x2,y2).build().perform();
          //  Thread.sleep(1000);
        //}
        try{
            //Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        scrollInToElement(driver,driver.findElement(By.cssSelector("body > div.main-section > div:nth-child(10) > div > div.el.width-2of3 > section > div > div > img.slide-img.before.twentytwenty-before")));
        System.out.println("the value is"+driver.findElement(By.cssSelector("body > div.main-section > div:nth-child(10) > div > div.el.width-2of3 > section > div > div > div.twentytwenty-handle")).getLocation());
        //driver.quit();
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
