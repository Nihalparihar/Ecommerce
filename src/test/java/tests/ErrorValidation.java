package tests;


import base.DriverFactory;
import base.testBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LandingPage;




public class ErrorValidation extends testBase {

@Test(groups = "Errorhandling")
    public void showErrMessage() throws InterruptedException {


    LandingPage landingPage=new LandingPage(getDriver());
    if(getDriver()!=null) {
        landingPage.login("nihalsinghparihar@gmail.com", "Indira123#$1");

        String actualMessage = landingPage.getErrMessage().trim();
        String expectedMessage = " Incorrect email or password. ".trim();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

}
}
