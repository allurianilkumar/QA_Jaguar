import java.util.List;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Predicate;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.NoSuchElementException;

public class DropDownBox {
    //public static final WebDriver driver = new FirefoxDriver();

    public static void main(String[] args) throws InterruptedException {
        final WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://www.jaguar.co.uk");
        System.out.println(driver.getTitle());
        //Assert.assertEquals("Luxury Sports & Executive Saloon Cars | Jaguar UK", driver.getTitle());
        driver.findElement(By.linkText("XE")).click();
        System.out.println(driver.getTitle());
        //Assert.assertEquals("Jaguar XE | Jaguar Saloon | Jaguar UK", driver.getTitle());
        driver.findElement(By.xpath("(//a[contains(text(),'PRICING & SPECIFICATIONS')])[2]")).click();
        //Assert.assertEquals("Jaguar XE Price | Jaguar Saloon Car | Jaguar UK", driver.getTitle());
        String[] modelName={"SE","PRESTIGE","R-SPORT","PORTFOLIO","S"};
        String[] modelEngine={"2.0 4 CYLINDER 163PS DIESEL RWD MANUAL","2.0 4 CYLINDER 163PS DIESEL RWD AUTO","2.0 4 CYLINDER 180PS DIESEL RWD MANUAL","2.0 4 CYLINDER 180PS DIESEL RWD AUTO","2.0 4 CYLINDER 180PS DIESEL AWD AUTO","2.0 4 CYLINDER 200PS PETROL RWD AUTO"};
        //String[] modelEngine={"2.0 4 CYLINDER 163PS DIESEL RWD MANUAL","2.0 4 CYLINDER 163PS DIESEL RWD AUTO","2.0 4 CYLINDER 180PS DIESEL RWD MANUAL","2.0 4 CYLINDER 180PS DIESEL RWD AUTO","2.0 4 CYLINDER 180PS DIESEL AWD AUTO","2.0 4 CYLINDER 200PS PETROL RWD AUTO"};
        for(int i=0;i<modelName.length;i++){
            WebElement modelDropdown = getDropdownElement(driver,"modelDropdown");
            modelDropdown.click();
            setModelDropdown(driver, "modelDropdown",modelName[i]);
            for(int j=0;j<modelEngine.length;j++){
                WebElement engineDropdown=getDropdownElement(driver,"engineDropdown");
                engineDropdown.click();

                System.out.println("value is "+i);
                setModelDropdown(driver, "engineDropdown",modelEngine[j]);
                String subIntroHeaderName = getNameplateSpecification(driver,"nameplateSpecification__intro__header");
                System.out.println(" the sub intro__header name is "+subIntroHeaderName);
                String nameplateSpecificationIntroSubHeader = getNameplateSpecification(driver,"nameplateSpecification__intro__subheader");
                System.out.println(" the nameplateSpecification__intro__sub header name is "+nameplateSpecificationIntroSubHeader);
                testAccordionContent(driver);
                try {
                    Thread.sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(2000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void testAccordionContent(WebDriver driver){
        List<WebElement> accordionItems = getAccordionElements(driver);
        System.out.println("the values total is "+accordionItems.size());
        for(int i=0;i<accordionItems.size();i++){
            try {
                Thread.sleep(2000);
            }catch (Exception e){
                e.printStackTrace();
            }
            WebElement accordionHeader = accordionItems.get(i).findElement(By.className("accordion__header"));
            System.out.println("the Header  size is "+accordionHeader.getText());
            //accordionItems.get(i).click();
            testAccordionContent(driver,accordionItems.get(i)); // for pricing table, bussiness pricing, Engines & Performance ...
        }
    }
    public static List<WebElement> getAccordionElements(WebDriver driver){
        //fluentlyWait(driver,new FluentWait<By>(By.className("main-section")));
        WebElement mainSection = driver.findElement(By.className("main-section"));
        //fluentlyWait(driver,new FluentWait<By>(By.className("nameplateSpecification-component")));
        WebElement  nameplateSpecificationComponent1= mainSection.findElement(By.className("nameplateSpecification-component"));
        //fluentlyWait(driver,new FluentWait<By>(By.id("specifications")));
        WebElement subTitleName = nameplateSpecificationComponent1.findElement(By.id("specifications"));
        //fluentlyWait(driver,new FluentWait<By>(By.id("accordion")));
        // START clicking the OPEN ALL link
        WebElement accordionToggle = subTitleName.findElement(By.className("accordion__toggle"));
        WebElement accordionToggleOpen= accordionToggle.findElement(By.className("accordion__toggle__open"));
        accordionToggleOpen.click();
        // END clicking the OPEN ALL link
        WebElement accordion  = subTitleName.findElement(By.id("accordion"));
        //fluentlyWait(driver,new FluentWait<By>(By.className("accordion__container")));
        WebElement ul  = accordion.findElement(By.className("accordion__container"));
        //fluentlyWait(driver,new FluentWait<By>(By.className("accordion__item")));
        List<WebElement> accordionItems =ul.findElements(By.className("accordion__item"));
        return accordionItems;
    }
    public static  void testAccordionContent(WebDriver driver,WebElement accordionItem){
        //fluentlyWait(driver,new FluentWait<By>(By.className("accordion__content")));
        WebElement accordionContent = accordionItem.findElement(By.className("accordion__content"));
        //fluentlyWait(driver,new FluentWait<By>(By.className("accordion__content__block")));
        WebElement accordionContentBlock = accordionContent.findElement(By.className("accordion__content__block"));
        //fluentlyWait(driver,new FluentWait<By>(By.tagName("table")));
        WebElement table = accordionContentBlock.findElement(By.tagName("table"));
        //fluentlyWait(driver,new FluentWait<By>(By.tagName("tbody")));
        WebElement tbody = table.findElement(By.tagName("tbody"));
        ////fluentlyWait(driver,new FluentWait<By>(By.tagName("tr")));
        List<WebElement> tr = tbody.findElements(By.tagName("tr"));
        for(int i=0;i<tr.size();i++){
            //fluentlyWait(driver,new FluentWait<By>(By.tagName("th")));
            String thname = tr.get(i).findElement(By.tagName("th")).getText();
            System.out.println(" th value is "+thname);
            //fluentlyWait(driver,new FluentWait<By>(By.tagName("td")));
            String tdname = tr.get(i).findElement(By.tagName("td")).getText();
            System.out.println("td value is "+tdname);
        }
    }
    public static String getNameplateSpecification(WebDriver driver, String webClassName){
        //fluentlyWait(driver,new FluentWait<By>(By.className("main-section")));
        WebElement mainSection = driver.findElement(By.className("main-section"));
        //fluentlyWait(driver,new FluentWait<By>(By.className("nameplateSpecification-component")));
        WebElement  nameplateSpecificationComponent= mainSection.findElement(By.className("nameplateSpecification-component"));
        //fluentlyWait(driver,new FluentWait<By>(By.id("specifications")));
        WebElement subTitleName = nameplateSpecificationComponent.findElement(By.id("specifications"));
        //fluentlyWait(driver,new FluentWait<By>(By.className(webClassName)));
        WebElement titleSubName = subTitleName.findElement(By.className(webClassName));
        return  titleSubName.getText();
    }


    public static WebElement getDropdownElement(WebDriver driver, String id) {
        ////fluentlyWait(driver,new FluentWait<By>(By.className("main-section")));
        WebElement mainSection = driver.findElement(By.className("main-section"));
        ////fluentlyWait(driver,new FluentWait<By>(By.className("nameplateSpecification-component")));
        WebElement nameplateSpecificationComponent= mainSection.findElement(By.className("nameplateSpecification-component"));
        ////fluentlyWait(driver,new FluentWait<By>(By.className("nameplateSpecification__hero__content")));
        WebElement nameplateSpecificationHeroContent = nameplateSpecificationComponent.findElement(By.className("nameplateSpecification__hero__content"));
        try {
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        //fluentlyWait(driver,new FluentWait<By>(By.id(id)));
        WebElement modelDropdown= nameplateSpecificationHeroContent.findElement(By.id(id));
        //fluentlyWait(driver,new FluentWait<By>(By.className("dropdownNav-component")));
        WebElement dropdownNavComponent = modelDropdown.findElement(By.className("dropdownNav-component"));
        //fluentlyWait(driver,new FluentWait<By>(By.className("dropdownNav-button")));
        WebElement dropdownNavButton= dropdownNavComponent.findElement(By.className("dropdownNav-button"));
        return  dropdownNavButton;
    }
    public static void setModelDropdown(WebDriver driver, String id,String typeName){
        //fluentlyWait(driver,new FluentWait<By>(By.className("main-section")));
        WebElement mainSection = driver.findElement(By.className("main-section"));
        //fluentlyWait(driver,new FluentWait<By>(By.className("nameplateSpecification-component")));
        WebElement nameplateSpecificationComponent= mainSection.findElement(By.className("nameplateSpecification-component"));
        //fluentlyWait(driver,new FluentWait<By>(By.className("nameplateSpecification__hero__content")));
        WebElement nameplateSpecificationHeroContent = nameplateSpecificationComponent.findElement(By.className("nameplateSpecification__hero__content"));
        //fluentlyWait(driver,new FluentWait<By>(By.id(id)));
        WebElement modelDropdown= nameplateSpecificationHeroContent.findElement(By.id(id));
        //fluentlyWait(driver,new FluentWait<By>(By.className("dropdownNav-component")));
        WebElement dropdownNavComponent = modelDropdown.findElement(By.className("dropdownNav-component"));
        //fluentlyWait(driver,new FluentWait<By>(By.className("dropdownNav-wrapper")));
        WebElement dropdownNavWrapper= dropdownNavComponent.findElement(By.className("dropdownNav-wrapper"));
        //fluentlyWait(driver,new FluentWait<By>(By.className("ul")));
        List<WebElement> li = dropdownNavWrapper.findElement(By.tagName("ul")).findElements(By.tagName("li"));
        System.out.println("number of list is "+li.size());
        for(int  i=0;i< li.size();i++) {
            WebElement name = li.get(i).findElement(By.tagName("a"));
            WebElement span = name.findElement(By.tagName("span"));
            if(span.getText().trim().equals(typeName.trim())){
                span.click();
                break;
            }
            System.out.println("the Model name is " + span.getText());
        }

    }
    public static void fluentlyWait(final WebDriver driver, FluentWait<By> fluentWait) {
    System.out.println("h1");
    fluentWait.pollingEvery(100, TimeUnit.MILLISECONDS);
    fluentWait.withTimeout(150000, TimeUnit.MILLISECONDS);
    fluentWait.until(new Predicate<By>() {
        public boolean apply(By by) {
            try {
                return driver.findElement(by) != null;
            } catch (NoSuchElementException ex) {
                return false;
            }
        }
    });
}
}
