package Pages;

import UtilsFolder.UtilsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PIMPages {
    WebDriver driver;


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


    public PIMPages(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void inputPIMInfo(String firstName,String middleName,String lastName,String userName,String password,String confirmPassword) throws InterruptedException {
        pimMenu.get(1).click();
        Thread.sleep(2000);
        addButton.get(2).click();
        Thread.sleep(3000);
        inputFirstName.sendKeys(firstName);
        Thread.sleep(1000);
        inputMiddleName.sendKeys(middleName);
        Thread.sleep(1000);
        inputLastName.sendKeys(lastName);
        Thread.sleep(1000);
        switchButton.get(0).click();
        Thread.sleep(1000);

        inputUserName.get(5).sendKeys(userName);
        Thread.sleep(1000);
        UtilsPage.scrollDown(driver);
        inputPassword.get(6).sendKeys(password);
        Thread.sleep(1000);
        inputConfirmPassword.get(7).sendKeys(confirmPassword);
        Thread.sleep(1000);

        submitButton.click();
        Thread.sleep(1000);

    }
}
