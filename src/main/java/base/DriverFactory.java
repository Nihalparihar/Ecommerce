package base;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    private DriverFactory()
    {

    }

    ThreadLocal<WebDriver> driver=new ThreadLocal<>();
    private static  DriverFactory instance=new DriverFactory();
    public static DriverFactory getInstance()
    {
        return instance;
    }
    public WebDriver getDriver()
    {
       return driver.get();
    }
    public void setDriver(WebDriver driverPara)
    {
       driver.set(driverPara);
    }
    public void closeDriver()
    {
        driver.get().close();
        driver.remove();
    }
}
