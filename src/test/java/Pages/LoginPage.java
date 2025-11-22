package Pages;

import UtilsFolder.UtilsPage;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static Config.Setup.test;

public class LoginPage {
    WebDriver driver;
    public static ExtentTest node;

    @FindBy(name = "username")
    WebElement textUsername;

    @FindBy(xpath = "//input[@type=\"password\"]")
    WebElement textPassword;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement submitButton;



    public LoginPage(WebDriver driver,ExtentTest node){
        this.driver=driver;

        this.node=node;
        PageFactory.initElements(driver,this);
    }
    public void login(String username,String password) throws InterruptedException, IOException {
        textUsername.sendKeys(username);
        node.info("username Input field found as expected");
        UtilsPage.getScreenShot(driver,"User name Input field found as expected",node);
        Thread.sleep(1000);
        textPassword.sendKeys(password);
        node.info("Password Input field found as expected");
        UtilsPage.getScreenShot(driver,"Password Input field found as expected",node);
        Thread.sleep(1000);
        submitButton.click();
        node.info("Submit button found as expected");
        UtilsPage.getScreenShot(driver,"Submit button found as expected",node);

        Thread.sleep(2000);

    }
}
