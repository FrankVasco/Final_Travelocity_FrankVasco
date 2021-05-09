package travelocity.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class FlightSearchPage extends BasePage {

    public FlightSearchPage(WebDriver pDriver) {
        super(pDriver);
    }


    @FindBy(id="listings-sort")
    private WebElement sortByDropdown;

    @FindBy(css="option[data-opt-id='ARRIVAL_DECREASING' ]")
    private WebElement lastElementList;

    @FindBy(css="button[data-test-id='select-link']")
    private WebElement tripDetails;

    @FindBy(css="div[data-test-id='journey-duration']")
    private List<WebElement> flightDuration;

    @FindBy(css="button[data-test-id='select-link']")
    private List<WebElement> flightCards;


    @FindBy(css="div[class='uitk-flex']")
    private List<WebElement> detailsFlightFrom_To;


    /**
     * Click on sort dropdown
     */
    public void clickOnSortByDropdown(){
        findElementUntilClickable(sortByDropdown);
        click(sortByDropdown);
    }

    /**
     * Select one option in the dropdown Sort by
     * @param value is the values of the option in the dropdown that needs to be selected
     */
    public void selectOptionSortBy(String value){
        findElementUntilClickable (sortByDropdown);
        click(sortByDropdown);
        findElementUntilClickable(lastElementList);
        selectDropdown(sortByDropdown, value);
    }


    /**
     * Verifies that flight duratin is displayed
     * @return
     */
    public int verifyFlightDurationIsDisplayed(){
        findElementUntilClickable(sortByDropdown);
        int cont = 0;
        for (int i = 0; i < flightDuration.size() ; i++) {
            if(flightDuration.get(i).getText()!=null){
                cont++;
            }
        }
       return cont;
    }

    /**
     * Counts the number of cards displayed in the web
     * @return
     */
    public int numberOfCardsDisplayed(){
        findElementUntilClickable(sortByDropdown);
        System.out.println(flightDuration.size());
       return flightDuration.size();
    }

    /**
     * Gets the times of each flight and verifies if it is sorted ascending
     * @return return a count of the number of elements that are sorted
     */
    public int listOfDurationTimeOrdered(){
        ArrayList<Integer> flightTimeList = new ArrayList<>();
        flightTimeList = listOfFlightDuration();
        int cont=0;
        for(int i=0; i<flightTimeList.size()-1; i++){
            if(flightTimeList.get(i)<=flightTimeList.get(i+1)){
                cont++;
            }
        }
        System.out.println("Counter: " + cont);
        return cont;
    }

    /**
     * Populates the arrayList with the duration time in this way hhmm (Where hh: hour, mm:minute)
     * @return An arrayList with all the time duration
     */
    public ArrayList<Integer> listOfFlightDuration(){
        ArrayList<Integer> flightTimeList = new ArrayList<>();
        for (int i = 0; i < flightCards.size() ; i++) {
            String flightTime = flightDuration.get(i).getText();
            flightTimeList.add(i, removeLettersFromTime(flightTime));
        }
        System.out.println(flightTimeList);
        return flightTimeList;
    }

    /**
     * This methos remove the text after(, and also remove all  letters ans spaces
     * @param word with special characters ex:
     * @return
     */
    public int removeLettersFromTime(String word){
        String[] time = word.split("\\(");
        String timeSplited = time[0];
        int flightTimeInt = Integer.parseInt(timeSplited.replaceAll("[^\\d.]", ""));
        return flightTimeInt;
    }

    /**
     * Select the value in the WebElement list (Flight destination-departure) that contains the variable destination
     * @param destination
     * @return It returns the position of the element
     */
    public int selectFirstOptionFlightTo(String destination){

        int cardPosition=0;
        for (int i = 0; i < detailsFlightFrom_To.size(); i++) {
            String departure_DestinationText = getTextElement( detailsFlightFrom_To.get(i));
            System.out.println(departure_DestinationText);
            if (departure_DestinationText.contains(destination)) {
                cardPosition = i;
                break;
            }
        }
        System.out.println(cardPosition);
        return cardPosition;
    }

    /**
     * Clicks in the element position given by the method selectFirstOptionFlightTo(destination)
     * @param destination destination String
     */
    public void clickOnOptionFlightTo(String destination){
    findElementUntilClickable(sortByDropdown);
    flightCards.get(selectFirstOptionFlightTo(destination)).click();
    }

    /**
     *Change the tab in the browser
     * @param tab
     */
    public void changeTab(String tab) {
        ArrayList<String> handles = new ArrayList<>(getDriver().getWindowHandles());
        for (String data : handles) {
            getDriver().switchTo().window(data);
            if (getDriver().getTitle().contains(tab)) {
                break;
            }
        }
    }



}
