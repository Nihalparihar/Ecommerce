package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.PageObjectUtils;

import java.util.List;

public class PlaceOrderPage extends PageObjectUtils {
    WebDriver driver;
    public PlaceOrderPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//input[@placeholder='Select Country']")
    private WebElement txtCountry;

   /* @FindBy(xpath = "//section[contains(@class,'ta-results')]")
    private WebElement countryOptions;*/

    By countryOptions=By.xpath("//section[contains(@class,'ta-results')]");

    @FindBy(xpath = "//a[text()='Place Order ']")
    private WebElement btnPlaceOrder;

    @FindBy(xpath = "//button[contains(@class,'ta-item')]")
    private List<WebElement> allCountryName;

public void enterAndSelectCountry()
{
    txtCountry.sendKeys("India");
    visibilityOfElementLocated(countryOptions);

    Actions actions = new Actions(driver);
    actions.moveToElement(btnPlaceOrder).perform();
    for (WebElement ele:allCountryName)
    {

        if(ele.getText().equalsIgnoreCase("India"))
        {
            System.out.println(ele.getText());
            ele.click();
            break;
        }
    }
}
    public void clickOnPlaceOrder()
    {
        waitUntilElementClickable(btnPlaceOrder);
        btnPlaceOrder.click();
    }
}
