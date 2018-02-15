package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.WaitHelper;

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
    }


    public List<WebElement> getTROptions(){
        return driver.findElements(By.className("new"));
    }

    public int i = 0;
    public String trId;

    public void getTd(){
        List<WebElement> options = getTROptions();
        for (WebElement tdOption:options){
            if(i<101){
                trId = trId + tdOption.getAttribute("id");
            }i++;
        }System.out.println(trId);
    }


    public String staticUrl = "https://insights.hotjar.com/p?site=216793&recording=";
    public String uniqueCode = "";
    public String finalUrl;


    public String getFinalUrl(){

        for(int codeCount = 0; codeCount < 10; codeCount++){
            int indexOfCode = trId.indexOf("recordingRow-");
            uniqueCode = trId.substring(indexOfCode+1, indexOfCode + 11);
            System.out.println(uniqueCode);

            trId = trId.substring(indexOfCode+10);
            finalUrl = staticUrl + uniqueCode;
            System.out.println(finalUrl);
        }
        return null;

    }

}
