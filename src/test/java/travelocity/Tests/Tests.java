package travelocity.Tests;

import org.testng.annotations.Test;
import travelocity.DataProviders.DataProviders;
import travelocity.Pages.FlightSearchPage;
import travelocity.Pages.HomePage;
import travelocity.Pages.HomeDatePickerPage;

public class Tests extends BaseTests {


    @Test(description = "Perform a search of a flight from LAS to LAX", dataProvider = "FlightDetails" , dataProviderClass = DataProviders.class)
    public void Test1(String departure, String destination) {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnFlights();
        homePage.clickOnLeavingFromTxt();
        homePage.sendKeysLeavingFrom(departure);
        homePage.clickOnGoingToTxt();
        homePage.sendKeysGoingTo(destination);
        HomeDatePickerPage datePicker = new HomeDatePickerPage(driver);
        datePicker.clickOnDepartingDateTxt();
        datePicker.clickOnNextMonth();
        datePicker.clickOnDepartingDate(2);
        datePicker.clickOnReturningDate(3);
        datePicker.clickOnDoneButton();
        homePage.clickSearchButton();
    }


    @Test(description = "Validate the options for the Sort By" ,dataProvider = "InputData", dataProviderClass = DataProviders.class)
    public void Test2a(String value){
        FlightSearchPage flightSearchPage = new FlightSearchPage(driver);
        System.out.println("The option is" + value);
        flightSearchPage.selectOptionSortBy(value);
    }



}
