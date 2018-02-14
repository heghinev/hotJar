package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.WaitHelper;

import static setup.DriverSetup.getDriver;

public class LoginPage extends BasePage {
    @FindBy(id = "identifierId")
    private WebElement emailLocator;
    @FindBy(xpath = "//span[@class='RveJvd snByac']")
    private WebElement nextLocator;
    @FindBy(css = "input[name='password']")
    private WebElement passwordLocator;
    @FindBy(xpath = "//*[@id=\":30\"]/div[1]/span")
    private WebElement checkboxLocator;
    @FindBy(xpath = "//*[@id=\":5\"]/div/div[1]/div[1]/div/div/div[2]/div[3]/div")
    private WebElement deleteLocator;
    @FindBy(xpath = "//*[@id=\":5\"]/div/div[1]/div[1]/div/div/div[4]/div/div/div")
    private WebElement refreshLocator;


    public LoginPage() {
        super(getDriver());
        visit(getUrl());
    }

    public String getUrl() {
        return BASE_URL;
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

    public void loginWith(String email, String password) {
        type(emailLocator, email);
        click(nextLocator);
        WaitHelper.getWait()
                .waitForElementToBeVisible(passwordLocator);
        type(passwordLocator, password);
        click(nextLocator);
    }

    public void deleteMails(){
        for(int i = 0; i < 100; i++) {
            WaitHelper.getWait()
                    .waitForElementToBeVisible(checkboxLocator);
            click(checkboxLocator);
            WaitHelper.getWait()
                    .waitForElementToBeVisible(deleteLocator);
            click(deleteLocator);
            WaitHelper.getWait()
                    .waitForElementToBeVisible(refreshLocator);
            click(refreshLocator);
        }
    }

}
