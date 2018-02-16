import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

import java.util.ArrayList;

import static pageObjects.LoginPage.codes;


/**
 * Created by IntelliJ IDEA.
 * User: Heghine
 * Date: 12/11/17
 * Time: 7:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage();
    }

    @Test
    public void getUrls() {
        loginPage.loginWith("helenvanetsyan@gmail.com", "Pumpumik123!");
        loginPage.getTd();
        loginPage.printURLs(codes);
    }
}



