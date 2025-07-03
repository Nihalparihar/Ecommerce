package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {

    WebDriver driver;
    public ConfirmationPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(tagName = "h1")
    private WebElement confirmMessage;
    public String verifyConfirmationMessage()
    {
        return confirmMessage.getText();
    }
}
