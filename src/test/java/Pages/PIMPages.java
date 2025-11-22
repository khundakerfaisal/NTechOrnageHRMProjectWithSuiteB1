package Pages;

import UtilsFolder.UtilsPage;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PIMPages {
    WebDriver driver;

    public static ExtentTest node;



    @FindBy(className = "oxd-main-menu-item-wrapper")
    List<WebElement> pimMenu;

    @FindBy(className = "oxd-button")
    List<WebElement> addButton;

    @FindBy(name = "firstName")
    WebElement inputFirstName;
    @FindBy(name = "middleName")
    WebElement inputMiddleName;
    @FindBy(name = "lastName")
    WebElement inputLastName;

    @FindBy(className = "oxd-switch-input")
    List<WebElement> switchButton;

    @FindBy(className = "oxd-input")
    List<WebElement> inputUserName;
    @FindBy(className = "oxd-input")
    List<WebElement> inputPassword;
    @FindBy(className = "oxd-input")
    List<WebElement> inputConfirmPassword;
    @FindBy(xpath="//button[@type='submit']")
    WebElement submitButton;


    public PIMPages(WebDriver driver,ExtentTest node){

        this.driver=driver;
        this.node=node;
        PageFactory.initElements(driver,this);
    }

    public void inputPIMInfo(String firstName,String middleName,String lastName,String userName,String password,String confirmPassword) throws InterruptedException {
        pimMenu.get(1).click();
        node.info("Pim Menu found successfully");
        Thread.sleep(2000);
        addButton.get(2).click();
        node.info("Add button found successfully");
        Thread.sleep(3000);
        inputFirstName.sendKeys(firstName);
        node.info("First name input successfully");
        Thread.sleep(1000);
        inputMiddleName.sendKeys(middleName);
        node.info("Middle name input successfully");
        Thread.sleep(1000);
        inputLastName.sendKeys(lastName);
        node.info("Last name input successfully");
        Thread.sleep(1000);
        switchButton.get(0).click();
        node.info("Switch button found as expected");
        Thread.sleep(1000);
        inputUserName.get(5).sendKeys(userName);
        node.info("username input successfully");
        Thread.sleep(1000);
        UtilsPage.scrollDown(driver);
        inputPassword.get(6).sendKeys(password);
        node.info("password input successfully");
        Thread.sleep(1000);
        inputConfirmPassword.get(7).sendKeys(confirmPassword);
        node.info("Confirm password input successfully");
        Thread.sleep(1000);
        submitButton.click();
        node.info("Submit button found as expected");
        Thread.sleep(1000);

    }
}
