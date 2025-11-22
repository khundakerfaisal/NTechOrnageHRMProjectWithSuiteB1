package UtilsFolder;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UtilsPage {

    public static ExtentReports extent;
    public static void saveUserInfo(String firstName,String userName,String password,String confirmPassword) throws IOException, ParseException {
        String filePath="./src/test/resources/user.json";
        JSONParser parser=new JSONParser();
        JSONArray addedUser= (JSONArray) parser.parse(new FileReader(filePath));
        JSONObject userObject=new JSONObject();
        userObject.put("FirstName",firstName);
        userObject.put("Username",userName);
        userObject.put("Password",password);
        userObject.put("ConfirmPassword",confirmPassword);
        addedUser.add(userObject);

        FileWriter writer=new FileWriter(filePath);
        writer.write(addedUser.toJSONString());
        writer.flush();
        writer.close();

    }

    public static JSONObject getUser() throws IOException, ParseException {
        String filePath="./src/test/resources/user.json";
        JSONParser parser=new JSONParser();
        JSONArray lastAddedArray= (JSONArray) parser.parse(new FileReader(filePath));
        JSONObject lastAddedUser= (JSONObject) lastAddedArray.get(lastAddedArray.size()-1);
        return lastAddedUser;
    }

    public static void scrollDown(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 600);");
    }


    @DataProvider(name = "loginWithCSV")
    public Object[][] getData() throws IOException {
        String filePath="./src/test/resources/loginWithCsv.csv";
        List<Object> getObject=new ArrayList<>();
        CSVParser getAllCsvData=new CSVParser(new FileReader(filePath), CSVFormat.DEFAULT.withFirstRecordAsHeader());
        for (CSVRecord getData:getAllCsvData){
            String username=getData.get("username");
            String password=getData.get("password");
            getObject.add(new Object[]{username,password});
        }
        return getObject.toArray(new Object[0][]);
    }

    public static ExtentReports getInstance(){
        if (extent==null){
            ExtentSparkReporter sparkReporter=new ExtentSparkReporter("reports/ExtentReport.html");
            extent=new ExtentReports();
            extent.attachReporter(sparkReporter);
        }
        return extent;

    }

    public static void getScreenShot(WebDriver driver, String message,ExtentTest node) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        String screenshotDir = "reports/screenshots/";
        new File(screenshotDir).mkdirs();
        String fileName = "screenshot_" + generateNumber() + ".jpg";
        String fullScreenshotPath = screenshotDir + fileName;
        File destFile=new File(fullScreenshotPath);
        FileUtils.copyFile(srcFile, destFile);
        String relativePath = "screenshots/" + fileName;
        node.pass(message, MediaEntityBuilder.createScreenCaptureFromPath(relativePath).build());


    }

    public static String generateNumber(){
        Random random=new Random();
        return String.valueOf(random.nextInt(9999)+1111);
    }



}
