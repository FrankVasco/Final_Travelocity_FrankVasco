package travelocity.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import travelocity.Pages.FlightDetailsCheckoutPage;
import travelocity.Pages.FlightSumaryPage;
import travelocity.Utils.MyDriver;

public class Tests4 {

    public MyDriver myDriver;
    public WebDriver driver;


    @BeforeClass(alwaysRun = true)
    @Parameters({"browser"})
    public void beforeSuite(String browser){
        myDriver =new MyDriver(browser);
        driver = myDriver.getDriver();
        driver.manage().window().maximize();
        driver.get("https://www.travelocity.com/Flight-Information?journeyContinuationId=AQrzAgrUAnY1LXNvcy03OTdjMDg5YTI4ZTY0M2FmYWEwNmYxZDhjZmFmMmE3Yi0xNS0xLXN0LXY1LXNvcy1kODg1NmUyZGEzY2I0ZmNkYWI4NzZkMDQ1NDExYzQxZi0zMy0xLTI0NzB-Mi5TfkFRb0VDSUh4QkJJSENOUUVFQWNZR3lBSElBRWdEQ0FOSUFrb0FsSUUyUFFCQUZnQ2NBQndBQX5BUW9qQ2lFSXhuSVNCREl4TmpVWWk1QUJJSXU0QVNqY3hmQUJNS19HOEFFNFIwQUFXQUVTQ2dnQkVBRVlBU29DUmprWUFTSUVDQUVRQVNnQ0tBTW9CREFDLkFRb25DaVVJd213U0JERXdPREFZaTdnQklJdVFBU2pWbXZNQk1KeWI4d0U0VEVBQVdBRnFBa1JPRWdvSUFSQUJHQUVxQWtJMkdBRWlCQWdCRUFFb0FpZ0RLQVF3QWcRSOF6FK6nYEAiAQEqBRIDCgExKgcIARIDCgExEj8KFgoKMjAyMS0wNi0yORIDTEFTGgNMQVgKFgoKMjAyMS0wNy0yORIDTEFYGgNMQVMSBxIFQ09BQ0gaAhABIAIaCAgBEgQaACIAIAE%3D");
        driver.navigate().refresh();
    }


    @Test
    public void Test7_8(){
        FlightSumaryPage flightSumaryPage = new FlightSumaryPage(driver);
        flightSumaryPage.clickOnCheckOutButton();
        FlightDetailsCheckoutPage flightDetailsCheckoutPage = new FlightDetailsCheckoutPage(driver);
        System.out.println(flightDetailsCheckoutPage.getTextWhosTravellingText());
        System.out.println(flightDetailsCheckoutPage.getTextFirstNameText());
        System.out.println(flightDetailsCheckoutPage.getTextMiddleNameText());
        System.out.println(flightDetailsCheckoutPage.getTextLastNameText());
        System.out.println(flightDetailsCheckoutPage.getTextCountryText());

    }

}
