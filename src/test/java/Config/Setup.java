package Config;

import UtilsFolder.UtilsPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class Setup {
    public WebDriver driver;

    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeTest (groups = "smoke")
    public void StartBrowser(){
//        ChromeOptions options = new ChromeOptions();
//        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
//        driver = new ChromeDriver(options);

        extent= UtilsPage.getInstance();
        test=extent.createTest("Browser start Successfully");

        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterTest(groups = "smoke")

    public void CloseBrowser(){
        test=extent.createTest("Browser Close Successfully");
        driver.quit();
        extent.flush();
    }
}
