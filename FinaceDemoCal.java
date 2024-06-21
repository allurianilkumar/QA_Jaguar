import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FinaceDemoCal {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		driver.get("http://financecalculator.jaguar.co.uk/jag/en/gb/xe_jscwl01b/quote");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement siteMain=driver.findElement(By.className("site-main"));
		WebElement siteMainSection=siteMain.findElement(By.className("quote-container")).findElement(By.className("section"));
		WebElement siteMainFinanceCalculatorForm=siteMainSection.findElement(By.className("finance-calculator-form"));
		List<WebElement> siteMainFinanceCalculatorFormList=siteMainFinanceCalculatorForm.findElements(By.className("section"));
		WebElement siteMainFinanceCalculatorFormOl=siteMainFinanceCalculatorFormList.get(0).findElement(By.tagName("ol"));
		List<WebElement> siteMainFinanceCalculatorFormOlAndLiList=siteMainFinanceCalculatorFormOl.findElements(By.tagName("li"));
		WebElement siteMainFinanceCalculatorFormOlAndLiDeposit=siteMainFinanceCalculatorFormOlAndLiList.get(0).findElement(By.id("deposit"));
		WebElement site=siteMainFinanceCalculatorFormOlAndLiDeposit.findElement(By.xpath(".."));
		WebElement siteMainFinanceCalculatorFormOlAndLiDepositButon=site.findElement(By.className("ui-slider-handle"));
		siteMainFinanceCalculatorFormOlAndLiDepositButon.click();
		siteMainFinanceCalculatorFormOlAndLiDepositButon.sendKeys(Keys.ARROW_RIGHT);// deposit is 250
		siteMainFinanceCalculatorFormOlAndLiDepositButon.sendKeys(Keys.ARROW_RIGHT); // deposit is 500
		
	}
}
