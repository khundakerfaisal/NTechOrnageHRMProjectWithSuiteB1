package TestRunner;

import Config.Setup;
import Pages.LoginPage;
import Pages.PIMPages;
import UtilsFolder.UtilsPage;
import com.github.javafaker.Faker;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static Pages.PIMPages.node;

public class PIMTestRunner extends Setup {
    @Test(priority = 1, description = "Login with Valid credential")
    public void doLoginWithValidCred() throws InterruptedException, IOException {
        test=extent.createTest("PIM Module");
        node=test.createNode("Login Screen found as expected!!");

        LoginPage loginPage = new LoginPage(driver,node);
//        String username=System.getProperty("username");
//        String password=System.getProperty("password");
//        loginPage.login(username,password);
        loginPage.login("Admin", "admin123"); //Login
        node.pass("Login Successfully!!");
        UtilsPage.getScreenShot(driver,"Login Successfully!!",node);


        //Assertion
        WebElement MatchText = driver.findElement(By.xpath("//span/h6[text()='Dashboard']"));
        String TextActual = MatchText.getText();
        String TextExpected = "Dashboard";
        Assert.assertEquals(TextActual.trim(), TextExpected);
        Thread.sleep(2000);

    }

    @Test(priority = 2, description = "Create New User")
    public void enterPimInfo() throws InterruptedException, IOException, ParseException {
        node=test.createNode("PIM Screen Found as expected");
        PIMPages pimPages=new PIMPages(driver,node);
        Faker faker=new Faker();
        String firstName=faker.name().firstName();
        String middleName=faker.name().nameWithMiddle();
        String lastName=faker.name().lastName();
        String userName=faker.name().lastName();
        String password="Aa@123456";
        String confirmPassword="Aa@123456";
        pimPages.inputPIMInfo(firstName,middleName,lastName,userName,password,confirmPassword);
        node.pass("User info created successfully!!");
        UtilsPage.saveUserInfo(firstName,userName,password,confirmPassword);
        node.pass("User info save successfully!!");
        Thread.sleep(2000);
    }


}
