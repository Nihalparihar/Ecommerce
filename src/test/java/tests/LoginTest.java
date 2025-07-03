package tests;

import base.DriverFactory;
import base.testBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.LandingPage;

public class  LoginTest extends testBase {
    WebDriver driver;
    private LoginTest()
    {

    }
    @Test
    public void login()
    {
        LandingPage landingPage=new LandingPage(getDriver());
        landingPage.login("nihalsinghparihar@gmail.com","Indira123#$");
    }

}
