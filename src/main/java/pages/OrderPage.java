package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PageObjectUtils;

import java.util.List;

public class OrderPage extends PageObjectUtils {
    WebDriver driver;
    public OrderPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
   private WebElement btnOrders;

    @FindBy(xpath = "//tr/td[2]")
    private List<WebElement> productOrdersList;
    public String clickOnOrder(String productName )
    {
        waitUntilElementClickable(btnOrders);
        btnOrders.click();
       return getList(productName);
    }

    public String getList(String productName)
    {
        for (WebElement ele:productOrdersList)
        {
            if(ele.getText().equalsIgnoreCase(productName))
            {

                return productName;
            }
        }
        return null;
    }
}

