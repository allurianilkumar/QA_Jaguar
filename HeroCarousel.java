import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by admin-aneel on 26/3/16.
 */
public class HeroCarousel {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://www.jaguar.co.uk");
        //System.out.println(driver.getTitle());
        WebElement mainSection = driver.findElement(By.className("main-section"));
        WebElement heroWrapperParent= mainSection.findElement(By.className("hero-wrapper-parent"));
        WebElement heroWrapper = heroWrapperParent.findElement(By.className("hero-wrapper"));

        WebElement pagination= heroWrapper.findElement(By.className("pagination"));
        List<WebElement> aList = pagination.findElements(By.tagName("a"));
        for(int i=0;i<aList.size();i++){
            System.out.println("the value is i "+i);
            aList.get(i).click();
            try{
                Thread.sleep(2000);
            }catch (Exception e){
                e.printStackTrace();
            }
            if(!aList.get(i).getCssValue("class").contains("selected")){
                System.out.println("checking selected class");
                Thread.sleep(2000);
            }
            System.out.println("link name is "+aList.get(i).findElement(By.tagName("span")).getText());
            try{
                Thread.sleep(2000);
            }catch (Exception e){
                e.printStackTrace();
            }
            WebElement caroufredselWrapper = heroWrapper.findElement(By.className("caroufredsel_wrapper"));
            WebElement heroSlides = caroufredselWrapper.findElement(By.className("hero-slides"));
            // Pagination list
            //List<WebElement> hero = heroSlides.findElements(By.className("hero"));
            //for(int j=i;j<hero.size();j++){
                WebElement heroNoCopy= heroSlides.findElement(By.className("hero")).findElement(By.className("hero"));
                // for imae
                WebElement heroImageNoCopy = heroNoCopy.findElement(By.className("hero-image-no-copy"));
                //
                WebElement heroContentWrapper = heroNoCopy.findElement(By.className("hero-content-wrapper"));
                // For hero-content
                WebElement heroContent = heroContentWrapper.findElement(By.className("hero-content"));
                String titleName = heroContent.findElement(By.tagName("p")).getText();
                System.out.println("this is the title name "+titleName);
                // For hero-subcontent
                WebElement heroSubcontent = heroContentWrapper.findElement(By.className("hero-subcontent"));
                String heroSubContentName = heroSubcontent.findElement(By.tagName("p")).getText();
                System.out.println("this is the title name "+heroSubContentName);
                // For Actions
                WebElement actions = heroContentWrapper.findElement(By.className("actions"));
                List<WebElement> alist = actions.findElements(By.tagName("a"));
                for(int k=0;k<alist.size();k++){
                    System.out.print("  title name is "+alist.get(k).getText());
                }

                mainSection = driver.findElement(By.className("main-section"));
                heroWrapperParent= mainSection.findElement(By.className("hero-wrapper-parent"));
                heroWrapper = heroWrapperParent.findElement(By.className("hero-wrapper"));
                pagination= heroWrapper.findElement(By.className("pagination"));
                aList = pagination.findElements(By.tagName("a"));

                try{
                 //   Thread.sleep(5000);
                }catch (Exception e){
                    e.printStackTrace();
                }


            //}
        }

    }
}
