package TestRunner;

import Config.Setup;
import Pages.LoginPage;
import Pages.PIMPages;
import UtilsFolder.UtilsPage;
import com.github.javafaker.Faker;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class PIMTestRunner extends Setup {
    @Test(priority = 1, description = "Login with Valid credential")
    public void doLoginWithValidCred() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        String username=System.getProperty("username");
        String password=System.getProperty("password");
        loginPage.login(username,password);
//        loginPage.login("Admin", "admin123"); //Login
//        Thread.sleep(2000);
        //Assertion
//        WebElement MatchText = driver.findElement(By.xpath("//span/h6[text()='Dashboard']"));
//        String TextActual = MatchText.getText();
//        String TextExpected = "Dashboard";
//        Assert.assertEquals(TextActual.trim(), TextExpected);
//        Thread.sleep(2000);

    }

    @Test(priority = 2, description = "Create New User")
    public void enterPimInfo() throws InterruptedException, IOException, ParseException {
        PIMPages pimPages=new PIMPages(driver);
        Faker faker=new Faker();
        String firstName=faker.name().firstName();
        String middleName=faker.name().nameWithMiddle();
        String lastName=faker.name().lastName();
        String userName=faker.name().lastName();
        String password="Aa@123456";
        String confirmPassword="Aa@123456";
        pimPages.inputPIMInfo(firstName,middleName,lastName,userName,password,confirmPassword);
        UtilsPage.saveUserInfo(firstName,userName,password,confirmPassword);
        Thread.sleep(2000);
    }

}
