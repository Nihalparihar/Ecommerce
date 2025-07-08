package base;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private DriverFactory() {}

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final DriverFactory instance = new DriverFactory();

    public static DriverFactory getInstance() {
        return instance;
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);
    }


    public void closeDriver() {
WebDriver driverInstance = driver.get();
if (driverInstance != null) {
driverInstance.quit(); // Properly closes all browser windows and ends the session
driver.remove();// Cleans up the ThreadLocal reference
}
    }

}

