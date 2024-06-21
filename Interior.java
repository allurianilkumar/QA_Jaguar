import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by admin-aneel on 14/3/16.
 */
public class Interior {
    public static void main(String[] args) throws InterruptedException {
        DesiredCapabilities capabilities= DesiredCapabilities.firefox();
        capabilities.setJavascriptEnabled(true);
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().window().maximize();
        driver.get("http://www.jaguar.co.uk");
        driver.findElement(By.linkText("XE")).click();
        WebElement clickOnButton =  driver.findElement(By.xpath("//*[@id=\"tcm91x215340\"]/div[2]/a"));
        clickOnButton.click();
        System.out.println("clicking ...");
        WebElement clickBtn = driver.findElement(By.xpath("//*[@id=\"tcm91x215340\"]"));
        clickBtn.click();
        Thread.sleep(1000);
	try {
          Thread.sleep(1000);
          Robot r = new Robot();
	}catch (AWTException awte){
          awte.printStackTrace();
	}
        r.keyPress(KeyEvent.VK_RIGHT); // one time right side key pressing
        r.keyPress(KeyEvent.VK_RIGHT); // 2nd time right key pressing
        r.keyPress(KeyEvent.VK_RIGHT); // 3rd time also
	driver.findElement(By.cssSelector("#tcm91x215340 > div > a.interior360__reset__control")).click();
    }

}
