package TestRunner;

import Config.Setup;
import Pages.LoginPage;
import UtilsFolder.UtilsPage;
import org.testng.annotations.Test;

public class LoginWithCSV extends Setup {

    @Test(dataProvider = "loginWithCSV", dataProviderClass = UtilsPage.class)
    public void doLoginWithCSV(String username,String password) throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login(username,password);
        Thread.sleep(4000);
    }
}
