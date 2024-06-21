import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by admin-aneel on 26/3/16.
 */
public class StandradCarousel {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://www.jaguar.co.uk/index.html");

        // forward clicking
        //forwardClick(driver, next);
        // backward clicking
        //backwardClick(driver, prev);
        WebElement title = driver.findElement(By.cssSelector("body > div.main-section > div.carousel.section-wrapper.white > div.section > div > h2"));
        System.out.println("the title value is "+title.getText());

        WebElement shopingTools = driver.findElement(By.cssSelector("body > div.main-section > div.carousel.section-wrapper.white > div.carousel-outerwrap > div > div.carousel-wrapper > div > div:nth-child(1) > div > div > div"));
        System.out.println("the Shoping tools heading is "+shopingTools.findElement(By.className("shopping-tools-heading")).getText());
        List<WebElement> linksList = shopingTools.findElement(By.className("links")).findElements(By.tagName("li"));
        System.out.println("the total size is "+linksList.size());
        for(int p=0;p< linksList.size();p++){
            String linkTitleName = linksList.get(p).findElement(By.tagName("a")).findElement(By.tagName("span")).getText();
            System.out.println("this is the link title name is "+linkTitleName);
        }
        scrollInToElement(driver,driver.findElement(By.cssSelector("body > div.main-section > div.carousel.section-wrapper.white > div.carousel-outerwrap > div > div.carousel-wrapper > div")));
        WebElement slider = driver.findElement(By.cssSelector("body > div.main-section > div.carousel.section-wrapper.white > div.carousel-outerwrap > div > div.carousel-wrapper > div"));

        List<WebElement> carouselSlideList = slider.findElements(By.className("carousel-slide"));
        System.out.println("the total slider size is "+carouselSlideList.size());

        for(int j=1;j<carouselSlideList.size();j++){
            System.out.println("the index value is "+j);
            scrollInToElement(driver,carouselSlideList.get(j).findElement(By.className("with-caption")));
            WebElement imageWithCaption = carouselSlideList.get(j).findElement(By.className("with-caption"));
            if(imageWithCaption.findElement(By.className("wrap")).isDisplayed()){
                System.out.println("the  index value wrap is enabled "+j);
            }else{
                System.out.println("the  index value wrap is disenabled "+j);
                scrollInToElement(driver,driver.findElement(By.cssSelector("body > div.main-section > div.carousel.section-wrapper.white > div.carousel-outerwrap > div > span.carousel-nav.next")));
                if(!driver.findElement(By.cssSelector("body > div.main-section > div.carousel.section-wrapper.white > div.carousel-outerwrap > div > span.carousel-nav.next")).getAttribute("class").contains("disabled")){
                    WebElement nextButton = driver.findElement(By.cssSelector("body > div.main-section > div.carousel.section-wrapper.white > div.carousel-outerwrap > div > span.carousel-nav.next"));
                    nextButton.click();
                }
            }
            WebElement wrap = imageWithCaption.findElement(By.className("wrap"));
            WebElement imageTitleName = wrap.findElement(By.tagName("h2"));
            System.out.println("the image tile name is "+imageTitleName.getText());
            WebElement imageTitleInfo = wrap.findElement(By.tagName("p"));
            System.out.println("the imge title info is "+imageTitleInfo.getText());
        }
    }

    public static void forwardClick(WebDriver driver, WebElement next) {
        while (!next.getAttribute("class").contains("disabled")) {
            next.click();
            // need refreshed web element
            next = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div/span[2]"));
        }
    }

    public static void backwardClick(WebDriver driver, WebElement prev) {
        while (!prev.getAttribute("class").contains("disabled")) {
            prev.click();
            // need refreshed web element
            prev = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div/span[1]"));
        }
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
