package travelocity.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FlightSumaryPage extends BasePage {
    public FlightSumaryPage(WebDriver pDriver) {
        super(pDriver);
    }

    @FindBy(css="div[data-test-id='flight-review-header'] h2[class='uitk-heading-4']")
    private List<WebElement> routeLabel;

    @FindBy(css="span[class='uitk-type-500 uitk-type-bold uitk-text-emphasis-theme']")
    private WebElement priceLabel;

    @FindBy(css="button[data-test-id='goto-checkout-button']")
    private WebElement checkOutButton;


    public String selectTextDeparture(){
        return getTextElement(routeLabel.get(0));
    }

    public String selectTextReturning(){
        return getTextElement(routeLabel.get(1));
    }

    /**
     * Verify the price is present
     * @return
     */
    public boolean verifyPrice(){
        Boolean isPricePresent = false;
        if(getTextElement(priceLabel)!=null){
            System.out.println(getTextElement(priceLabel));
            isPricePresent = true;
        }
        return isPricePresent;
    }

    public void clickOnCheckOutButton(){
        findElementUntilClickable(checkOutButton);
        click(checkOutButton);
    }


}
