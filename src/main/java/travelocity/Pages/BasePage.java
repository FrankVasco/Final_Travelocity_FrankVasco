package travelocity.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    private WebDriver driver;
    private WebDriverWait webDriverWait;

    public BasePage(WebDriver pDriver) {
        PageFactory.initElements(pDriver, this);
        driver = pDriver;
    }

    protected WebDriver getDriver(){
        return driver;
    }

    /***
     * Define WebDriverWait method for the project
     * @return WebDriverWait
     */
    public WebDriverWait getWait(){
        WebDriverWait wait =  new WebDriverWait(driver, 20);
        this.webDriverWait = wait;
        return webDriverWait;
    }

    /***
     *
     * @param element
     */
    public void findElementUntillVisibility(String element){
        getWait().until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(element))));
    }

    /**
     * Generic method to wait until an element is vivible
     * @param element
     */
    public void findElementUntillVisibility(WebElement element){
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public void findElementUntilClickable(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public void findElementUntiltextToBePresentInElementValue(WebElement element, String text){
        getWait().until(ExpectedConditions.textToBePresentInElementValue(element, text));
    }

    /***
     *
     * @param element Web Element in String format
     * @return
     */
    public String getTextElement(String element){
        return driver.findElement(By.cssSelector(element)).getText();
    }

    public String getTextElement(WebElement element){
        return element.getText();
    }




    /***
     * Click in the button First Selected
     * @param element
     */
    public void click(String element){
        getDriver().findElement(By.cssSelector(element)).click();
    }

    public void click(WebElement element){
        element.click();
    }

    public void sendKeys(WebElement element, String text){
        element.sendKeys(text);
    }

    public void sendKeys(WebElement element, Keys text){
        element.sendKeys(text);
    }


    /**
     * Select an option of a dropdown
     * @param element
     * @param value
     */
    public void selectDropdown(WebElement element, String value ){
        Select dropdown = new Select(element);
        dropdown.selectByValue(value);
    }

    /**
     *
     */
    public void dispose(){
        if(driver != null){
            driver.quit();
        }
    }


}
