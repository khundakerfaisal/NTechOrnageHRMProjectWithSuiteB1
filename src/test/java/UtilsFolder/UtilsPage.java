package UtilsFolder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UtilsPage {
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


}
