package travelocity.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class HomeDatePickerPage extends BasePage {


    public HomeDatePickerPage(WebDriver pDriver) {
        super(pDriver);
    }

    @FindBy(id="d1-btn")
    private WebElement departingDate;

    @FindBy(id="d2-btn")
    private WebElement returningDate;

    @FindBy(css="button[aria-label*='selected']")
    private WebElement currentDate;

    private String cssDepartingDate = "button[aria-label='" + getFutureDate(2)+ "']";

    @FindBy(css="div button[data-stid='date-picker-paging']:nth-child(2)")
    private WebElement nextMonthButton;

    private String cssReturningDate = "button[aria-label='" + getFutureDate(3)+ "']";

    @FindBy(css="button[data-stid='apply-date-picker']>span")
    private WebElement doneButton;


    public void clickOnDepartingDateTxt(){
        click(departingDate);
    }

    public void clickOnNextMonth(){
        findElementUntillVisibility(nextMonthButton);
        click(nextMonthButton);
    }

    public void clickOnDepartingDate(int month){
        findElementUntillVisibility(getFutureDate(month));
        System.out.println(getFutureDate(month));
        click(getFutureDate(month));
    }

    public void clickOnReturningDate(int month){

        findElementUntillVisibility(getFutureDate(month));
        System.out.println(getFutureDate(month));
        click(getFutureDate(month));
    }

    public void clickOnDoneButton(){
        findElementUntillVisibility(doneButton);
        click(doneButton);
    }

    /**
     * This method constructs the css selector for the dates in the datePicker
     * @param monthInAdvance
     * @return
     */

    public String getFutureDate(int monthInAdvance){
        LocalDate date = LocalDate.now();
        LocalDate futureDate = date.plusMonths(monthInAdvance);
        String month[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        int monthIndex = futureDate.getMonth().getValue()-1;
        String monthSelected = month[monthIndex];
        String futureDay = String.valueOf(futureDate.getDayOfMonth());
        String futureYear = String.valueOf(futureDate.getYear());
        String departureDate = monthSelected + " " + futureDay + ", " + futureYear ;
        String cssDepartureDate = "button[aria-label='" + departureDate + "']";
        //System.out.println("The date method: " + cssDepartureDate);
        return cssDepartureDate;
    }




}
