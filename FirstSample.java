/**
 * Created by admin-aneel on 24/2/16.
 */
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class FirstSample {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("http://financecalculator.jaguar.co.uk/jag/en/gb/xe_jscwl01b/quote");
        driver.manage().window().maximize();
        // getting a section
        WebElement siteMainSection = getSection(driver);
        // getting a message by default
        String message =  getMessage(driver, siteMainSection);

        // from previouse dom web element we are calling "finance-calculator-form"
        WebElement siteMainFinanceCalculatorForm = siteMainSection.findElement(By.className("finance-calculator-form"));

        // We need to find out the web element in this finace-calculator-form of child class is "section" ( getting array type )
        List<WebElement> siteMainFinanceCalculatorFormList = siteMainFinanceCalculatorForm.findElements(By.className("section"));
        // In this "section" having the "ol" tag name" (using the child methods)
        WebElement siteMainFinanceCalculatorFormOl = siteMainFinanceCalculatorFormList.get(0).findElement(By.tagName("ol"));
        // find out the child dom web element under "ol"
        List<WebElement> siteMainFinanceCalculatorFormOlAndLiList = siteMainFinanceCalculatorFormOl.findElements(By.tagName("li"));
        setDeposit(siteMainFinanceCalculatorFormOlAndLiList.get(0), 1000); // Deposit  = 500
        setDuration(siteMainFinanceCalculatorFormOlAndLiList.get(1), 37); // duration = 37
        setMileage(siteMainFinanceCalculatorFormOlAndLiList.get(2), 7000); // milease = 7000
        // Logic For submit button
        WebElement submitContainer = siteMainFinanceCalculatorForm.findElement(By.className("cta-container"));
        WebElement submit = submitContainer.findElement(By.className("cta-primary-chevron-right"));
        // End of the logic for button
        submit.click();

    }
    public static WebElement getSection(WebDriver driver){
        WebElement siteMain = driver.findElement(By.className("site-main"));
        WebElement siteMainSection = siteMain.findElement(By.className("quote-container")).findElement(By.className("section"));
        return siteMainSection;
    }
    public static String getMessage(WebDriver driver, WebElement siteMainSection){
        // Finding the webElement for caluculator table information (Message).
        WebElement quoteGenerator = siteMainSection.findElement(By.className("quote-generator"));
        WebElement quoteInstructionsContainer = quoteGenerator.findElement(By.className("quote-instructions-container"));
        /*      WebElement t3 = t2.findElement(By.className("quote-instructions-wrapper"));
                WebElement t4 = t3.findElement(By.className("quote-instructions"));
        */
        WebElement quoteInstructionsContainerText = quoteInstructionsContainer.findElement(By.className("quote-instruction-text"));
        System.out.println("Deafult value is "+quoteInstructionsContainerText.getText());
        return quoteInstructionsContainerText.getText().trim();
    }
    public static void setDeposit(WebElement siteMainFinanceCalculatorFormOlAndLiListTemp, int amount){
        // find out the deposit web element
        WebElement siteMainFinanceCalculatorFormOlAndLiDeposit = siteMainFinanceCalculatorFormOlAndLiListTemp.findElement(By.id("deposit"));
        // Here getting the dynamic javascripting URl Locations so that, do like this with ".." in xpath.
        WebElement site = siteMainFinanceCalculatorFormOlAndLiDeposit.findElement(By.xpath(".."));
        // Finally  getting the "ui-slider-handle".
        WebElement siteMainFinanceCalculatorFormOlAndLiDepositButon = site.findElement(By.className("ui-slider-handle"));
        siteMainFinanceCalculatorFormOlAndLiDepositButon.click(); // apply click method
        // moved right side by arrow_right keys
        if(amount >= 250 && amount <=10250){
            for(int i=250; i<= 10250;i+=250) {
                if( i <= amount) {
                    siteMainFinanceCalculatorFormOlAndLiDepositButon.sendKeys(Keys.ARROW_RIGHT); // deposit is 250
                }else {
                    break;
                }
            }
        }else{
            System.out.println("Write the assert condion fails");
        }

    }
    public static void setDuration(WebElement siteMainFinanceCalculatorFormOlAndLiListTemp, int duration){
        // find out the deposit web element
        WebElement siteMainFinanceCalculatorFormOlAndLiDeposit = siteMainFinanceCalculatorFormOlAndLiListTemp.findElement(By.id("duration"));
        // Here getting the dynamic javascripting URl Locations so that, do like this with ".." in xpath.
        WebElement site = siteMainFinanceCalculatorFormOlAndLiDeposit.findElement(By.xpath(".."));
        // Finally  getting the "ui-slider-handle".
        WebElement siteMainFinanceCalculatorFormOlAndLiDepositButon = site.findElement(By.className("ui-slider-handle"));
        siteMainFinanceCalculatorFormOlAndLiDepositButon.click(); // apply click method
        // moved right side by arrow_right keys
        //
        if(duration >= 25 && duration <= 49) {
            for (int i = 25; i <= 49; i+=6) {
                if (i < duration) {
                    siteMainFinanceCalculatorFormOlAndLiDepositButon.sendKeys(Keys.ARROW_RIGHT); // deposit is 250
                } else {
                    break;
                }
            }
        }else{
            System.out.println("Write the assert condition fails");
        }
    }
    public static void setMileage(WebElement siteMainFinanceCalculatorFormOlAndLiListTemp, int mileage){
        // find out the deposit web element
        WebElement siteMainFinanceCalculatorFormOlAndLiDeposit = siteMainFinanceCalculatorFormOlAndLiListTemp.findElement(By.id("mileage"));
        // Here getting the dynamic javascripting URl Locations so that, do like this with ".." in xpath.
        WebElement site = siteMainFinanceCalculatorFormOlAndLiDeposit.findElement(By.xpath(".."));
        // Finally  getting the "ui-slider-handle".
        WebElement siteMainFinanceCalculatorFormOlAndLiDepositButon = site.findElement(By.className("ui-slider-handle"));
        siteMainFinanceCalculatorFormOlAndLiDepositButon.click(); // apply click method
        // moved right side by arrow_right keys
        if(mileage >= 6000 && mileage <=35000){
            for(int i=6000; i<= 35000;i+=1000) {
                if( i < mileage) {
                    siteMainFinanceCalculatorFormOlAndLiDepositButon.sendKeys(Keys.ARROW_RIGHT); // deposit is 250
                }else {
                    break;
                }
            }
        }else{
            System.out.println("Write the assert conditon fails");
        }

    }
}
