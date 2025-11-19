package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(name = "username")
    WebElement textUsername;

    @FindBy(xpath = "//input[@type=\"password\"]")
    WebElement textPassword;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement submitButton;



    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void login(String username,String password) throws InterruptedException {
        textUsername.sendKeys(username);
        Thread.sleep(1000);
        textPassword.sendKeys(password);
        Thread.sleep(1000);
        submitButton.click();
        Thread.sleep(2000);

    }
}
