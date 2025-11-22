package TestRunner;

import Config.Setup;
import Pages.LoginPage;
import Pages.PIMPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static Pages.LoginPage.node;

public class LoginWithWrongCred extends Setup {
    @Test(priority = 1, description = "Invalid credential")
    public void doLoginWithWrongCred() throws InterruptedException, IOException {
        test=extent.createTest("Do login with valid cred");
        node=test.createNode("Login Screen found as expected!!");
        LoginPage loginPage = new LoginPage(driver,node);
        loginPage.login("Admin123", "124"); //Login
        node.pass("Enter Login with wrong cred");
        Thread.sleep(2000);
        //Assertion


    }
}
