package TestRunner;

import Config.Setup;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestRunner extends Setup {

    @Test(priority = 1, description = "Valid credential")
    public void doLoginWithValidCred() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123"); //Login
        Thread.sleep(2000);

        //Assertion
        WebElement MatchText = driver.findElement(By.xpath("//span/h6[text()='Dashboard']"));
        String TextActual = MatchText.getText();
        String TextExpected = "Dashboard";
        Assert.assertEquals(TextActual.trim(), TextExpected);
        Thread.sleep(2000);


    }

//    @Test(priority = 2,description = "wrong credential")
//    public void doLoginWithWrongCred() throws InterruptedException {
//        LoginPage loginPage=new LoginPage(driver);
//        loginPage.login("Admin251","78945");
//        Thread.sleep(2000);
//
//    }

}
