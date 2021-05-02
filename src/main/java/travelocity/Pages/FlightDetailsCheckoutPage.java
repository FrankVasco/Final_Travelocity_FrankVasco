package travelocity.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FlightDetailsCheckoutPage extends BasePage {

    public FlightDetailsCheckoutPage(WebDriver pDriver) {
        super(pDriver);
    }

    @FindBy(css="h2[class='faceoff-module-title']")
    private WebElement whosTravellingLabel;

    @FindBy(css="span[class='label']")
    private List<WebElement> labels;

    public String getTextWhosTravellingText(){
        findElementUntillVisibility(whosTravellingLabel);
        String labelText = getTextElement(whosTravellingLabel);
        return labelText;
    }

    public String getTextFirstNameText(){
        String labelText = getTextElement(labels.get(7));
        return labelText;
    }

    public String getTextMiddleNameText(){
        String labelText = getTextElement(labels.get(8));
        return labelText;
    }

    public String getTextLastNameText(){
        String labelText = getTextElement(labels.get(9));
        return labelText;
    }

    public String getTextCountryText(){
        String labelText = getTextElement(labels.get(10));
        return labelText;
    }




}
