package travelocity.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import travelocity.Pages.FlightDetailsRightSection;
import travelocity.Pages.FlightSearchPage;
import travelocity.Utils.MyDriver;

public class Tests2 {

    public MyDriver myDriver;
    public WebDriver driver;


    @BeforeClass(alwaysRun = true)
    @Parameters({"browser"})
    public void beforeSuite(String browser){
        myDriver =new MyDriver(browser);
        driver = myDriver.getDriver();
        driver.manage().window().maximize();
        driver.get("https://www.travelocity.com/Flights-Search?leg1=from%3ALas%20Vegas%2C%20NV%20%28LAS-McCarran%20Intl.%29%2Cto%3ALos%20Angeles%2C%20CA%20%28LAX-Los%20Angeles%20Intl.%29%2Cdeparture%3A6%2F29%2F2021TANYT&leg2=from%3ALos%20Angeles%2C%20CA%20%28LAX-Los%20Angeles%20Intl.%29%2Cto%3ALas%20Vegas%2C%20NV%20%28LAS-McCarran%20Intl.%29%2Cdeparture%3A7%2F29%2F2021TANYT&mode=search&options=carrier%3A%2A%2Ccabinclass%3A%2Cmaxhops%3A1%2Cnopenalty%3AN&pageId=0&passengers=adults%3A1%2Cchildren%3A0%2Cinfantinlap%3AN&sortOrder=INCREASING&sortType=PRICE&trip=roundtrip");
        driver.navigate().refresh();
    }



    @Test(description = "Verify that the flight cards has flight Duration")
    public void Test2c(){
        FlightSearchPage flightSearchPage = new FlightSearchPage(driver);
        Assert.assertEquals(flightSearchPage.numberOfCardsDisplayed(), flightSearchPage.verifyFlightDurationIsDisplayed());
    }

    @Test(description = "Verify flight duration is ordered descending")
    public void Test3() {
        FlightSearchPage flightSearchPage = new FlightSearchPage(driver);
        flightSearchPage.selectOptionSortBy("DURATION_INCREASING");

        Assert.assertEquals(flightSearchPage.numberOfCardsDisplayed(), flightSearchPage.listOfDurationTimeOrdered());
    }


    @Test(description = "Select the first result that containes Los Angeles (LAX) as destination and click on continue")
    public void Test4() {
        FlightSearchPage flightSearchPage = new FlightSearchPage(driver);
        flightSearchPage.clickOnOptionFlightTo("LAX");
        FlightDetailsRightSection flightDetailsRightSection = new FlightDetailsRightSection(driver);
        Assert.assertEquals(flightDetailsRightSection.getTextItinerary(), "Las Vegas to Los Angeles");
        flightDetailsRightSection.clickContinueButton();
    }


}

