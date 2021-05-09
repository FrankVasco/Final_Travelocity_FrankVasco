package travelocity.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import travelocity.DataProviders.DataProviders;
import travelocity.Pages.FlightSearchPage;
import travelocity.Pages.HomePage;
import travelocity.Pages.HomeDatePickerPage;
import travelocity.Utils.MyDriver;

public class Tests {

    public MyDriver myDriver;
    public WebDriver driver;
    HomePage homePage;
    FlightSearchPage flightSearchPage;


    @BeforeSuite(alwaysRun = true)
    @Parameters({"browser"})
    public void beforeSuite(String browser){
        myDriver =new MyDriver(browser);
        driver = myDriver.getDriver();
        driver.manage().window().maximize();
        driver.get("https://www.travelocity.com/");
    }


    @Test(description = "Perform a search of a flight from LAS to LAX", dataProvider = "FlightDetails" , dataProviderClass = DataProviders.class)
    public void Test1(String departure, String destination) {
        homePage = new HomePage(driver);
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
        flightSearchPage = new FlightSearchPage(driver);
        System.out.println("The option is" + value);
        flightSearchPage.selectOptionSortBy(value);
    }

    @AfterTest
    public void closePage(){
        homePage.dispose();
        flightSearchPage.dispose();
    }

}
