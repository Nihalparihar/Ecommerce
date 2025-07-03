package base;

import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.PropertyReader;

import java.time.Duration;

public class testBase {
    //WebDriver driver;
    @BeforeMethod
    public void launchApplication()
    {
        DriverFactory.getInstance().setDriver(BrowserFactory.createBrowserInstance("chrome"));
        WebDriver driver=DriverFactory.getInstance().getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(PropertyReader.getValue("url"));
    }
    @AfterMethod
    public void tearDown()
    {
        DriverFactory.getInstance().closeDriver();
    }

    public WebDriver getDriver()
    {
        return DriverFactory.getInstance().getDriver();
    }
}
