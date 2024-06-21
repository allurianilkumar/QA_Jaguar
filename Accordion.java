/**
 * Created by admin-aneel on 13/3/16.
 */
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Accordion {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://www.jaguar.co.uk");
        System.out.println(driver.getTitle());
        driver.findElement(By.linkText("XE")).click();
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("(//a[contains(text(),'PRICING & SPECIFICATIONS')])[2]")).click();
        WebElement  nameplateSpecificationComponent= driver.findElement(By.className("nameplateSpecification-component"));
        // parent class name
        WebElement nameplateSpecificationHeroContent= nameplateSpecificationComponent.findElement(By.className("nameplateSpecification__hero__content"));
        WebElement nameplateSpecificationHeroTitle = nameplateSpecificationHeroContent.findElement(By.className("nameplateSpecification__hero__title"));

        String titleName = nameplateSpecificationHeroTitle.findElement(By.tagName("h1")).getText();
        System.out.println("the title name is "+titleName);

        //
        getDropdownElement(nameplateSpecificationHeroContent,"modelDropdown").click();
        setModelDropdown(nameplateSpecificationHeroContent, "modelDropdown","R-SPORT");
        //getDropdownElement(nameplateSpecificationHeroContent,"engineDropdown").click();
        //setModelDropdown(nameplateSpecificationHeroContent, "engineDropdown");

        System.out.println(" the sub intro__header name is "+getNameplateSpecification(driver,"nameplateSpecification__intro__header"));
        System.out.println(" the nameplateSpecification__intro__sub header name is "+getNameplateSpecification(driver,"nameplateSpecification__intro__subheader"));
        testPricingAccordionContent(driver);
        //driver.close();

    }
    public static void testPricingAccordionContent(WebDriver driver){
        WebElement  nameplateSpecificationComponent1= driver.findElement(By.className("nameplateSpecification-component"));
        WebElement subTitleName = nameplateSpecificationComponent1.findElement(By.id("specifications"));
        WebElement accordion  = subTitleName.findElement(By.id("accordion"));
        WebElement ul  = accordion.findElement(By.className("accordion__container"));
        List<WebElement> accordionItem =ul.findElements(By.className("accordion__item"));
        // Accordion Heading
        WebElement accordionHeader = accordionItem.get(0).findElement(By.className("accordion__header"));

        System.out.println("the values total is "+accordionItem.size());
        System.out.println("the Header  is "+accordionHeader.getText());//Assert Condition
        accordionItem.get(0).click();
        accordionItem.get(1).click();
        accordionItem.get(2).click();
        testAccordionContent(accordionItem.get(0),0); // for pricing table
        testAccordionContent(accordionItem.get(1),1); // for bussiness pricing
        //testAccordionContent(accordionItem.get(2),2); // for Engines & Performance
    }

    public static  void testAccordionContent(WebElement accordionItem, int orderNumber){
        // accordion__content
        WebElement accordioncontent = accordionItem.findElement(By.className("accordion__content"));
        WebElement accordionContentBlock = accordioncontent.findElement(By.className("accordion__content__block"));
        WebElement table = accordionContentBlock.findElement(By.tagName("table"));
        WebElement tbody = table.findElement(By.tagName("tbody"));
        List<WebElement> tr = tbody.findElements(By.tagName("tr"));
        for(int i=0;i<tr.size();i++){
            String thname = tr.get(i).findElement(By.tagName("th")).getText();
            System.out.println(" th value is "+thname);
            String tdname = tr.get(i).findElement(By.tagName("td")).getText();
            System.out.println("td value is "+tdname);
        }

    }
    public  static  void getSelectWebElement(WebDriver driver, WebElement element, String str){
        //WebElement modelDropdown= nameplateSpecificationHeroContent.findElement(By.id(id));
        //return
    }
    public static String getNameplateSpecification(WebDriver driver, String webClassName){
        WebElement  nameplateSpecificationComponent= driver.findElement(By.className("nameplateSpecification-component"));
        WebElement subTitleName = nameplateSpecificationComponent.findElement(By.id("specifications"));
        WebElement titleSubName = subTitleName.findElement(By.className(webClassName));
        return  titleSubName.getText();
    }
    public static void setModelDropdown(WebElement nameplateSpecificationHeroContent, String id,String typeName){
        WebElement modelDropdown= nameplateSpecificationHeroContent.findElement(By.id(id));
        WebElement dropdownNavComponent = modelDropdown.findElement(By.className("dropdownNav-component"));
        WebElement dropdownNavWrapper= dropdownNavComponent.findElement(By.className("dropdownNav-wrapper"));
        List<WebElement> li = dropdownNavWrapper.findElement(By.tagName("ul")).findElements(By.tagName("li"));
        System.out.println("number of list is"+li.size());
        for(int  i=0;i< li.size();i++) {
            WebElement name = li.get(i).findElement(By.tagName("a"));
            WebElement span = name.findElement(By.tagName("span"));
            if(span.getText().equals(typeName)){
                span.click();
                break;
            }
            System.out.println("the Model name is " + span.getText());
        }

    }
    public static WebElement getDropdownElement(WebElement nameplateSpecificationHeroContent, String id){
        WebElement modelDropdown= nameplateSpecificationHeroContent.findElement(By.id(id));
        WebElement dropdownNavComponent = modelDropdown.findElement(By.className("dropdownNav-component"));
        WebElement dropdownNavButton= dropdownNavComponent.findElement(By.className("dropdownNav-button"));
        return  dropdownNavButton;
    }
}
