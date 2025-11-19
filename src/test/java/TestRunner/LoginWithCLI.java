package TestRunner;

import Config.Setup;
import Pages.LoginPage;
import org.testng.annotations.Test;

public class LoginWithCLI extends Setup {
    @Test(priority = 1,description = "CLI Based Login",groups = "smoke")
    public void loginWithCLI() throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        String username=System.getProperty("username");
        String password=System.getProperty("password");
        loginPage.login(username,password);
    }
}
