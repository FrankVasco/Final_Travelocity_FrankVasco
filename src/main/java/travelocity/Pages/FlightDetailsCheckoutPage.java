package travelocity.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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
        String label = getTextElement(labels.get(7));
        String labelText = removeLettersFromTime(label);
        return labelText;
    }

    public String getTextMiddleNameText(){
        String label = getTextElement(labels.get(8));
        String labelText = removeLettersFromTime(label);
        return labelText;
    }

    public String getTextLastNameText(){
        String label = getTextElement(labels.get(9));
        String labelText = removeLettersFromTime(label);
        return labelText;
    }

    public String getTextCountryText(){
        String label = getTextElement(labels.get(10));
        String labelText = removeLettersFromTime(label);
        return labelText;
    }

    /**
     * Removes the \n(intro) and the character * from the strings that gets
     * @param word Get a word with special characters
     * @return Return the word with no special characters and the intro
     */
    public String removeLettersFromTime(String word){
        String label = word.replaceAll("\n", "");
        String label1 = label.replaceAll("\\*", "");
        return label1;
    }



}
