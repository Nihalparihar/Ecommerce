package tests;

import base.testBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.List;

public class OrderProductTest extends testBase {
     WebDriver driver;
    String productName="ZARA COAT 3";
    @Test
    public void ecomTest() throws InterruptedException {
        driver=getDriver();

        LandingPage landingPage=new LandingPage(driver);
        landingPage.login("nihalsinghparihar@gmail.com","Indira123#$");

        ProductCatalogPage productCatalogPage=new ProductCatalogPage(driver);
        productCatalogPage.addToCart(productName);
        productCatalogPage.clickOnCartButton();

        List<WebElement> cartProducts=driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
        for(WebElement ele:cartProducts)
        {
            if(ele.getText().equalsIgnoreCase(productName))
            {
                Assert.assertEquals(ele.getText(),productName);
                System.out.println("Product name ="+ele.getText());
                break;
            }
        }

        CheckoutPage checkoutPage=new CheckoutPage(driver);
        checkoutPage.clickOnCheckoutButton();

        PlaceOrderPage placeOrderPage=new PlaceOrderPage(driver);
        placeOrderPage.enterAndSelectCountry();
        placeOrderPage.clickOnPlaceOrder();

        ConfirmationPage confirmationPage=new ConfirmationPage(driver);
        String actText=confirmationPage.verifyConfirmationMessage();
         String expText=" THANKYOU FOR THE ORDER. ";
         Assert.assertEquals(actText.trim(),expText.trim());

    }

@Test(dependsOnMethods = "ecomTest")
    public void orderHistoryTest()
{
    driver=getDriver();
    LandingPage landingPage=new LandingPage(driver);
    landingPage.login("nihalsinghparihar@gmail.com","Indira123#$");

    OrderPage orderPage=new OrderPage(driver);
    String actualName=orderPage.clickOnOrder("ADIDAS ORIGINAL");
    String expectedName="ADIDAS ORIGINAL";

  Assert.assertEquals(actualName,expectedName);

}

}
