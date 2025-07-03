package tests;

import base.DriverFactory;
import base.testBase;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.ProductCatalogPage;

public class ProductCatalogTest extends testBase {
    String productName="ZARA COAT 3";
    @Test
    public void productCatalog()
    {
        LandingPage landingPage=new LandingPage(getDriver());
        landingPage.login("nihalsinghparihar@gmail.com","Indira123#$");
        ProductCatalogPage productCatalogPage=new ProductCatalogPage(getDriver());
        productCatalogPage.addToCart(productName);
    }

}
