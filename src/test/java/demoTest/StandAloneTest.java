package demoTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class StandAloneTest {

    @Test
    public void ecomTest()  {
        String productName="ZARA COAT 3";
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        System.out.println("==========STARTED=========");
        driver.get("https://rahulshettyacademy.com/client");
        driver.findElement(By.id("userEmail")).sendKeys("nihalsinghparihar@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Indira123#$");
        driver.findElement(By.id("login")).click();
        //div[@class='card-body']

        //div[@class='card-body']/h5/b
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card-body']/h5/b")));
       int productCount= driver.findElements(By.xpath("//div[@class='card-body']/h5/b")).size();
        List<WebElement> element= driver.findElements(By.xpath("//div[@class='card-body']/h5/b"));
       for(int i=0;i<productCount;i++)
       {
           if(element.get(i).getText().equalsIgnoreCase(productName))
           {
               driver.findElement(By.xpath("//button[@class='btn w-10 rounded']")).click();
           }
       }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

        driver.findElement(By.cssSelector("button[routerlink *='cart']")).click();

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
    }

}
