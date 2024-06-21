1) How to find out the body color in html file by using the selenium testing.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ImageBackgroundTest {


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://www.jaguar.co.uk/index.html");
        GoogleAbout(driver);

    }
    public static void GoogleAbout(WebDriver driver){
        WebElement  nav =  driver.findElement(By.tagName("body"));

        String colorName = nav.getCssValue("color"); // 'color' is the css attribute.
        System.out.println("the value is "+colorName);

        // the value is rgba(0,0,0,1)

         // we need the take firs three values i.e 0,0,0,1  

  // replace with rgba( to '' value same like ")" to ''. finally getting 0,0,0,1 value

// split means splitting into an array of string format like

        String[] hexValue = colorName.replace("rgba(", "").replace(")", "").split(",");

      int hexValue1 = Integer.parseInt(hexValue[0]);// parsing string value to int i.e 0 
 hexValue[1] = hexValue[1].trim(); // trim() remove the left side and right side spaces in that first value.
        int hexValue2 = Integer.parseInt(hexValue[1]);
        hexValue[2] = hexValue[2].trim();
        int hexValue3 = Integer.parseInt(hexValue[2]);

        String tabColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
        System.out.println("this color is "+tabColor); // #000000

        //Assert.assertEquals("#000", tabColor);
        //assertTrue(tabColor.contains(bodyColor));
    }
}



========================================
import java.util.List;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class real_time_project {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws Exception {
       
        WebDriver driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://www.jaguar.co.uk/index.html");
        String actualTitle = "Jaguar UK | Luxury Sports & Executive Saloon Cars";
        String allModelsName[] = {"XE","XF","XJ","F-TYPE","F-PACE","APPROVED USED"};
        String expectedTitle = driver.getTitle();
        if(expectedTitle.equals(actualTitle)) {
            System.out.println("title page is verified");
            Thread.sleep(2000);
            List<WebElement> modelsList=driver.findElements(By.xpath("//section[@class='itemsGrid']/div/div/h2"));
            for (int i =0; i<modelsList.size();i++) {
                System.out.println("title page is verified");
                System.out.println(allModelsName[i]+"="+modelsList.get(i).getText());
                //Assert.assertEquals(allModelsName[i],modelsList.get(i).getText().trim());
                }
            } else {
            //Assert.assertTrue(false);
        }
        driver.close();// close the window
    }

}

=======================================================================
package jaguar;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ItemGridContent {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		//driver.get("http://www.jaguar.co.uk/");
		driver.get("http://financecalculator.jaguar.co.uk/jag/en/gb/xe_jscwl01b__3behm__a-20d-163ps__/quote?product=54#table");
		Thread.sleep(2000);
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement siteMainClass =  driver.findElement(By.className("site-main"));
		WebElement quoteContainerElement = siteMainClass.findElement(By.className("quote-container"));
		WebElement quoteContainerSection = quoteContainerElement.findElement(By.className("section"));
		WebElement quoteContainerSectionForm = quoteContainerSection.findElement(By.tagName("form"));
		
		
		// js.executeScript("document.getElementById('colorPickIcon').setAttribute('style', '22.3333px')");
		
		
		/*WebElement itemgridcomponent=driver.findElement(By.tagName("article"));
		WebElement itemsGrid= itemgridcomponent.findElement(By.className("itemsGrid"));
		//System.out.println("item grid is");
		List<WebElement> listForItemGrid= itemsGrid.findElements(By.className("e1"));
		System.out.println("Size of the list is "+listForItemGrid.size());
		WebElement itemGridContent = listForItemGrid.get(0).findElement(By.className("itemsGrid-content"));
		WebElement itemTitle=itemGridContent.findElement(By.tagName("h2"));
		System.out.println("item title is "+itemTitle);*/
		
		// How to move a WebElement from one position to another position.
		
		
	}

}
================================================================================================

