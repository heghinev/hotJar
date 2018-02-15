package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
    public void getTd(){
        List<WebElement> options = getTROptions();
        for (WebElement tdOption:options){
            if(i<101){
                String s = tdOption.toString();
                System.out.println(s);
            }i++;

        }
    }

   /* public String getSelectedOption(){
        List<WebElement> options = getTROptions();
        for (WebElement option:options){
            if (option.isSelected()){
                return option.getText();
            }
        }
        return null;
    }*/
/*

    public String staticUrl = "https://insights.hotjar.com/p?site=216793&recording=";
    public String uniqueCode = "";
    public String finalUrl = staticUrl + uniqueCode;
*/

    /*public String getFinalUrl(){
        //Class<? extends JavascriptExecutor> s = ((JavascriptExecutor) driver).getClass();
       String htmlText = driver.

        *//*for(int codeCount = 0; codeCount < 1; codeCount++){
            int indexOfCode = htmlText.indexOf("recordingRow-");
            uniqueCode = htmlText.substring(indexOfCode+1, indexOfCode + 11);
            System.out.println(uniqueCode);
            htmlText = htmlText.substring(indexOfCode+10);
            System.out.println(finalUrl);
        }*//*
        System.out.println(s);
        return String.valueOf(s);

    }
*/

}
