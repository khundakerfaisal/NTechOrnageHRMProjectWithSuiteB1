package TestRunner;

import Config.Setup;
import Pages.LoginPage;
import UtilsFolder.UtilsPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static Pages.LoginPage.node;

public class LoginWithCSV extends Setup {

    @Test(dataProvider = "loginWithCSV", dataProviderClass = UtilsPage.class)
    public void doLoginWithCSV(String username,String password) throws InterruptedException, IOException {
        LoginPage loginPage=new LoginPage(driver,node);
        loginPage.login(username,password);
        Thread.sleep(4000);
    }
}
