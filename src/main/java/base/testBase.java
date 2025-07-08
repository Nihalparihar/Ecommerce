package base;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.PropertyReader;

import java.time.Duration;

public class testBase {

    @BeforeMethod(alwaysRun = true)
    public void launchApplication() {
        WebDriver driverInstance = BrowserFactory.createBrowserInstance("chrome");
        DriverFactory.getInstance().setDriver(driverInstance);

        WebDriver driver = DriverFactory.getInstance().getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(PropertyReader.getValue("url"));
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.getInstance().closeDriver();
    }

    public WebDriver getDriver() {
        return DriverFactory.getInstance().getDriver();
    }
}
