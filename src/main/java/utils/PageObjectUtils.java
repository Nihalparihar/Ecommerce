package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageObjectUtils {
    WebDriver driver;
    WebDriverWait wait;
    public PageObjectUtils(WebDriver driver)
    {
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void visibilityOfElementLocated(By locator)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void visibilityOfElement(WebElement element)
    {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void invisibilityOfElement(WebElement element)
    {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void JSClick(WebElement ele) {
        boolean flag = false;
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", ele);
            flag = true;
        }
        catch (Exception e) {
            throw e;

        } finally {
            if (flag) {
                System.out.println("Click Action is performed on ");
            } else if (!flag) {
                System.out.println("Click Action is not performed on ");
            }
        }


    }
    public void waitUntilElementClickable(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e) {
           // System.err.println("Element was not clickable within " + timeoutInSeconds + " seconds.");
            e.printStackTrace();
            // or throw a custom exception if preferred
        } catch (Exception e) {
            System.err.println("Unexpected error while waiting for element to be clickable.");
            e.printStackTrace();

        } finally {
            // Optional: Add any cleanup code here if needed
            System.out.println("waitUntilElementClickable execution completed.");
        }
    }
    public void clickElement(WebElement element) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }

    }
}
