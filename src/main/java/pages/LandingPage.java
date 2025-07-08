package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PageObjectUtils;

public class LandingPage extends PageObjectUtils {
    WebDriver driver;
    public LandingPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="userEmail")
    private WebElement txtEmail;
    @FindBy(id="userPassword")
    private WebElement txtPassword;
    @FindBy(id="login")
    private WebElement btnLogin;
    @FindBy(xpath="//div[text()=' Incorrect email or password. ']")
    private WebElement errMessage;


    public void login(String email,String password)
    {
        waitUntilElementClickable(btnLogin);
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        clickElement(btnLogin);
    }

    public String getErrMessage()
    {
        visibilityOfElement(errMessage);
        System.out.println("Error message ====================");
        System.out.println("Error message   => "+errMessage.getText());
        return errMessage.getText();
    }
}
