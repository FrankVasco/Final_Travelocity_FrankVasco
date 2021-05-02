package travelocity.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class HomePage extends BasePage {


    public HomePage(WebDriver pDriver) {
        super(pDriver);
    }

    @FindBy(css="a[aria-controls='wizard-flight-pwa']")
    private WebElement flightsIcon;
    //Click

    @FindBy(css="button[aria-label='Leaving from']")
    private WebElement leavingFrom;

    @FindBy(id="location-field-leg1-origin")
    private WebElement leavingTxt;

    @FindBy(css="button[aria-label='Going to']")
    private WebElement goingTo;

    @FindBy(id="location-field-leg1-destination")
    private WebElement goingToTxt;

    @FindBy(css="button[data-testid='submit-button']")
    private WebElement searchButton;


    public void clickOnFlights(){
        findElementUntillVisibility(flightsIcon);
        click(flightsIcon);
    }

    public void clickOnLeavingFromTxt(){
        findElementUntilClickable(leavingFrom);
        click(leavingFrom);
    }

    public void sendKeysLeavingFrom(String leavingFrom){
        findElementUntilClickable(leavingTxt);
            click(leavingTxt);
            sendKeys(leavingTxt, leavingFrom);
            sendKeys(leavingTxt, Keys.ENTER);
    }

    public void clickOnGoingToTxt(){
        findElementUntilClickable(goingTo);
        click(goingTo);
    }

    public void sendKeysGoingTo(String leavingFrom){
        findElementUntilClickable(goingToTxt);
        click(goingToTxt);
        sendKeys(goingToTxt, leavingFrom);
        sendKeys(goingToTxt, Keys.ENTER);
    }

    public void clickSearchButton(){
        findElementUntilClickable(searchButton);
        click(searchButton);
    }




}
