package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PageObjectUtils;

import java.util.List;

public class ProductCatalogPage extends PageObjectUtils {
    WebDriver driver;
    public ProductCatalogPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='card-body']/h5/b")
    private List<WebElement> productList;
    @FindBy(xpath="//button[@class='btn w-10 rounded']")
    private WebElement btnAddToCart;
    @FindBy(css = "button[routerlink *='cart']")
    private WebElement btnCart;
    @FindBy(css = ".ng-animating")
    private WebElement spinning;
    By locator=By.xpath("//div[@class='card-body']/h5/b");
    By toastMsg=By.id("toast-container");
    public void addToCart(String productName)
    {
        visibilityOfElementLocated(locator);
        for(WebElement element:productList)
        {
            if(element.getText().equalsIgnoreCase(productName))
            {
                btnAddToCart.click();
            }
        }
    }
    public void clickOnCartButton()
    {
        visibilityOfElementLocated(toastMsg);
        invisibilityOfElement(spinning);
        btnCart.click();
    }


}
