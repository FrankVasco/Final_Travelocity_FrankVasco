package travelocity.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import travelocity.Utils.MyDriver;


public class BaseTests {

        public MyDriver myDriver;
        public WebDriver driver;


        @BeforeSuite(alwaysRun = true)
        @Parameters({"browser"})
        public void beforeSuite(String browser){
            myDriver =new MyDriver(browser);
            driver = myDriver.getDriver();
            driver.manage().window().maximize();
            driver.get("https://www.travelocity.com/");
        }

    }



