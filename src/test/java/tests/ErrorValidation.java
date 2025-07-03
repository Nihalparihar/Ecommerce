package tests;

import base.DriverFactory;
import base.testBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LandingPage;

public class ErrorValidation extends testBase {

@Test
    public void showErrMessage()
{

    LandingPage landingPage=new LandingPage(getDriver());
    landingPage.login("nihalsinghparihar@gmail.com","Indira123#$1");
    String actualMessage=landingPage.getErrMessage().trim();
    String expectedMessage=" Incorrect email or password. ".trim();
    Assert.assertEquals(actualMessage,expectedMessage);
}
}
