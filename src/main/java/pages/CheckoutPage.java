package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.PageObjectUtils;

public class CheckoutPage extends PageObjectUtils {
    WebDriver driver;
    public CheckoutPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//li[@class='totalRow']/button")
    private WebElement btnCheckout;
    @FindBy(xpath = "//li[@class='totalRow']/button")
    private WebElement ddlAllCountryOptions;


    public void clickOnCheckoutButton()
    {
        waitUntilElementClickable(ddlAllCountryOptions);
        JSClick(btnCheckout);
    }
}
