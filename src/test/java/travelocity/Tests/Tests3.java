package travelocity.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import travelocity.Pages.FlightDetailsRightSection;
import travelocity.Pages.FlightSearchPage;
import travelocity.Pages.FlightSumaryPage;
import travelocity.Utils.MyDriver;

public class Tests3 {

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

    @Test(description = "Select the first result that containes las Vegas (LAS) as destination and click on continue, and verify the info in the new page")
    public void Test5_6() {
        FlightSearchPage flightSearchPage = new FlightSearchPage(driver);
        flightSearchPage.clickOnOptionFlightTo("LAX");
        FlightDetailsRightSection flightDetailsRightSection = new FlightDetailsRightSection(driver);
        String itineraryDepartureText = flightDetailsRightSection.getTextItinerary();
        System.out.println("Test " + itineraryDepartureText);
        flightDetailsRightSection.clickContinueButton();
        flightSearchPage.clickOnOptionFlightTo("LAS");
        String itineraryReturningText = flightDetailsRightSection.getTextItinerary();
        System.out.println("Test " + itineraryReturningText);
        Assert.assertEquals(flightDetailsRightSection.getTextItinerary(), "Los Angeles to Las Vegas");
        flightDetailsRightSection.clickContinueButton();
        flightSearchPage.changeTab("Flight Details");
        FlightSumaryPage flightSumaryPage = new FlightSumaryPage(driver);
        Assert.assertEquals(itineraryDepartureText, flightSumaryPage.selectTextDeparture());
        Assert.assertEquals(itineraryReturningText, flightSumaryPage.selectTextReturning());
        Assert.assertTrue(flightSumaryPage.verifyPrice());


    }


}
