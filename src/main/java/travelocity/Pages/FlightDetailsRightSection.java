package travelocity.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class FlightDetailsRightSection extends BasePage {

    public FlightDetailsRightSection(WebDriver pDriver) {
        super(pDriver);
    }

    @FindBy(css="h2[class='uitk-heading-4']")
    private WebElement flightItineraryText;

    @FindBy(css="button[data-test-id='select-button']")
    private WebElement continueButton;



    public String getTextItinerary(){
        String text = getTextElement(flightItineraryText);
        return text;
    }

    public void clickContinueButton(){
        click(continueButton);
    }




}
