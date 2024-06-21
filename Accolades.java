import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by antreetech on 11/4/16.
 */
public class Accolades {
    public static  void main(String[] arg) throws Exception{
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://www.jaguar.co.uk");
        driver.findElement(By.linkText("XE")).click();
        scrollInToElement(driver, driver.findElement(By.cssSelector("body > div.main-section > section.accolades-component.accolades-local-style-tcm91x211984.accolades--.carousel.section-wrapper > div > div > div.slideSelectors.slideID-0")));
        WebElement slideSelectors = driver.findElement(By.cssSelector("body > div.main-section > section.accolades-component.accolades-local-style-tcm91x211984.accolades--.carousel.section-wrapper > div > div > div.slideSelectors.slideID-0"));
        List<WebElement> slideSelectorsList = slideSelectors.findElements(By.tagName("a"));
        System.out.println("the sliderSelectors total is "+slideSelectorsList.size());
        for(int i=0;i< slideSelectorsList.size();i++) {
            System.out.println("the value is i " + i);
            //slideSelectorsList.get(i).click();
            //scrollInToElement(driver, slideSelectors.findElement(By.className("selected")).findElement(By.tagName("span")));
            slideSelectors.findElement(By.className("selected")).findElement(By.tagName("span")).click();
            Thread.sleep(2000);
            //slideSelectors.findElement(By.className("selected")).findElement(By.tagName("span")).click();
            /*try{
                //Thread.sleep(2000);
            }catch (Exception e){
                e.printStackTrace();
            }
            if(!slideSelectorsList.get(i).getCssValue("class").contains("selected")){
                System.out.println("checking selected class");
                //Thread.sleep(2000);
            }
            WebElement carouselSlider = driver.findElement(By.cssSelector("body > div.main-section > section.accolades-component.accolades-local-style-tcm91x211984.accolades--.carousel.section-wrapper > div > div > div.carousel-wrapper > div"));
            List<WebElement> sliderList      = carouselSlider.findElements(By.className("carousel-slide"));
            System.out.println("the total size is "+sliderList.size());
            for(int j=i;j<=i;j++){
                WebElement generic212ColumnContentBlock = sliderList.get(j).findElement(By.className("Generic212ColumnContentBlock"));
                List<WebElement> innerSliderSection = generic212ColumnContentBlock.findElement(By.className("section")).findElements(By.className("accolade"));
                System.out.println("the Inner section list total size is "+innerSliderSection.size());
                // For Section Title Name
                WebElement sectionTitleName = innerSliderSection.get(0).findElement(By.tagName("img"));
                System.out.println("the imge value is " + sectionTitleName.getAttribute("src"));
                // For Sectin Sub Title Name
                WebElement sectionSubTitleName = innerSliderSection.get(1).findElement(By.tagName("h2"));
                System.out.println("the section sub title value is " + sectionSubTitleName.getText());
                System.out.println("the section sub title class value is " + sectionSubTitleName.getAttribute("class"));
                // For Link Sub Title Name
                *//*if(sectionSubTitleName.getText() != "") {
                    WebElement link = innerSliderSection.get(1).findElement(By.className("link")).findElement(By.tagName("a"));
                    System.out.println("the link value is " + link.getText());
                }*//*
               *//* if(j== 2){
                    break;
                }*//*
            }
            slideSelectors = driver.findElement(By.cssSelector("body > div.main-section > section.accolades-component.accolades-local-style-tcm91x211984.accolades--.carousel.section-wrapper > div > div > div.slideSelectors.slideID-0"));
            slideSelectorsList = slideSelectors.findElements(By.tagName("a"));
            *//*if(i == 2) {
                break;
            }*/
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
