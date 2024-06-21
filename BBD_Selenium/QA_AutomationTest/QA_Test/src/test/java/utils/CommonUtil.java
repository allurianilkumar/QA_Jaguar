package utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

/**
 * Created by zeeshan.edwards on 28/01/2015.
 */
public class CommonUtil {

    public static Dimension dimension;
    public enum Devices{
        DESKTOP, LARGE_DESKTOP, TABLET, MOBILE
    }

    public static void setWindowSize(final WebDriver driver, String device) {
        driver.manage().window().setSize(snapPoint(device));
    }
    public static void setImplicitlyWaitTime(final WebDriver driver, int timeInSeconds) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    public static void quitBrowser(final WebDriver driver) {
        driver.close();
        driver.quit();
    }

    private static Dimension snapPoint(String device) {
        switch (Devices.valueOf(device)) {
            case DESKTOP:
                dimension = getDimensions(1024,768);
                break;
            case LARGE_DESKTOP:
                dimension = getDimensions(1366,768);
                break;
            case TABLET:
                dimension = getDimensions(768,1024);
                break;
            case MOBILE:
                dimension = getDimensions(320,568);
                break;
            default:
                dimension = getDimensions(1024,768);
                break;
        }
        return dimension;
    }

    private static Dimension getDimensions(int width, int height) {
        return new Dimension(width,height);
    }
    public static void scrollInToElement(WebDriver driver, WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
