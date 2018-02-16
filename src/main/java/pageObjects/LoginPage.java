package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.WaitHelper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import static setup.DriverSetup.getDriver;

public class LoginPage extends BasePage {
    @FindBy(id = "email")
    private WebElement emailLocator;
    @FindBy(css = "input[type = password]")
    private WebElement passwordLocator;
    @FindBy(css = "button[type = submit]")
    private WebElement submitLocator;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/div[1]/ul/li[3]/a[2]")
    private WebElement recordingsLocator;
    @FindBy(xpath = "//*[@id=\"content-inner\"]/div[2]/div[1]/div[1]/div[2]/div[1]/ul/li[7]/a")
    private WebElement nextLocator;
    @FindBy(css = ".title h1")
    private WebElement titleLocator;
    @FindBy(css = "#ui-helper .close")
    private WebElement uiHelperLocator;



    public LoginPage() {
        super(getDriver());
        visit(getUrl());
    }

    public String getUrl() {
        return BASE_URL;
    }

    public void loginWith(String email, String password) {
        type(emailLocator, email);
        type(passwordLocator, password);
        click(submitLocator);
        WaitHelper.getWait().waitForElementToBeClickable(recordingsLocator);
        click(recordingsLocator);
        WaitHelper.getWait().waitForElementToBeVisible(titleLocator);
        click(uiHelperLocator);
    }


    public List<WebElement> getTROptions(){
        for(int nextClickCount = 0; nextClickCount < 0; nextClickCount++){
            driver.findElements(By.className("new"));
            WaitHelper.getWait().waitForElementToBeClickable(nextLocator);
            click(nextLocator);
        }
        return driver.findElements(By.className("new"));
    }

    public static ArrayList<String> codes = new ArrayList<String>();

    public String trId;
    public String staticUrl = "https://insights.hotjar.com/p?site=216793&recording=";


    public void getTd(){
        List<WebElement> options = getTROptions();
        for (WebElement tdOption:options){
            trId = tdOption.getAttribute("id");
            codes.add(staticUrl + trId.replace("recordingRow-", ""));
        }
    }

    public static void printURLs(ArrayList a){
        try{
            FileOutputStream exam = new FileOutputStream("D:\\urls.txt");
            PrintWriter out = new PrintWriter(exam, true);
            out.println(codes.size());
            for (String  url : codes){
                out.println(url);
            }
        }catch(IOException e){}
    }

}
