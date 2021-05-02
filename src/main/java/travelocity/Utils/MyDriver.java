package travelocity.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyDriver {


    private WebDriver driver;

    public MyDriver(String browser){
        switch (browser){
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "C:\\driver\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "chrome":
                //Si no se configuran las variables de entorno, se debe configurar esto
                System.setProperty ("webdriver.chrome.driver","C:\\driver\\chromedriver.exe" );
                driver = new ChromeDriver();
                break;
            default:
                driver = new ChromeDriver();
                break;
        }
    }

    public WebDriver getDriver(){
        return this.driver;
    }


}
