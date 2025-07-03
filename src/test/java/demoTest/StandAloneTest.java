package demoTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.PropertyReader;

import java.time.Duration;
import java.util.List;

public class StandAloneTest {

    @Test
    public void ecomTest() throws InterruptedException {
        String productName="ZARA COAT 3";
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        System.out.println("==========STARTED=========");
        driver.get(PropertyReader.getValue("url"));
       // driver.get("https://rahulshettyacademy.com/client");

        /*driver.findElement(By.id("userEmail")).sendKeys("nihalsinghparihar@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Indira123#$");
        driver.findElement(By.id("login")).click();*/

        //div[@class='card-body']

        //div[@class='card-body']/h5/b
        LandingPage landingPage=new LandingPage(driver);
        landingPage.login("nihalsinghparihar@gmail.com","Indira123#$");

       //WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card-body']/h5/b")));

      /* int productCount= driver.findElements(By.xpath("//div[@class='card-body']/h5/b")).size();
        List<WebElement> element= driver.findElements(By.xpath("//div[@class='card-body']/h5/b"));
       for(int i=0;i<productCount;i++)
       {
           if(element.get(i).getText().equalsIgnoreCase(productName))
           {
               driver.findElement(By.xpath("//button[@class='btn w-10 rounded']")).click();
           }
       }*/
        ProductCatalogPage productCatalogPage=new ProductCatalogPage(driver);
        productCatalogPage.addToCart(productName);

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
        //wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
        productCatalogPage.clickOnCartButton();
       /* driver.findElement(By.cssSelector("button[routerlink *='cart']")).click();*/

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

       // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='totalRow']/button")));
       /*WebElement btnCheckout= driver.findElement(By.xpath("//li[@class='totalRow']/button"));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",btnCheckout);*/
        CheckoutPage checkoutPage=new CheckoutPage(driver);
        checkoutPage.clickOnCheckoutButton();


        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        PlaceOrderPage placeOrderPage=new PlaceOrderPage(driver);
        placeOrderPage.enterAndSelectCountry();
        placeOrderPage.clickOnPlaceOrder();
        /*driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("india");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[contains(@class,'ta-results')]")));
        List<WebElement> countryName=driver.findElements(By.xpath("//button[contains(@class,'ta-item')]"));
//Thread.sleep(6000);
WebElement btnPlaceOrder=driver.findElement(By.xpath("//a[text()='Place Order ']"));


        Actions actions = new Actions(driver);
        actions.moveToElement(btnPlaceOrder).perform();
        for (WebElement ele:countryName)
        {

            if(ele.getText().equalsIgnoreCase("India"))
            {
                System.out.println(ele.getText());
                ele.click();
                break;
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(btnPlaceOrder));
        btnPlaceOrder.click();
*/
        ConfirmationPage confirmationPage=new ConfirmationPage(driver);

         //String actText=driver.findElement(By.tagName("h1")).getText();
        String actText=confirmationPage.verifyConfirmationMessage();
         String expText=" THANKYOU FOR THE ORDER. ";
         Assert.assertEquals(actText.trim(),expText.trim());

    }



}
