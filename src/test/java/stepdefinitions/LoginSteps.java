package stepdefinitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import reuseable.LoginData;
import reuseable.Readers;
import utils.BaseTest;

public class LoginSteps {
    private AppiumDriver driver;
    private LoginPage loginPage;
    private LoginData loginData;

    public LoginSteps() {
        loginData = Readers.getLoginData();
    }

    
    @Given("user launch the application")
    public void setUp() {
        BaseTest.startAppiumServer();
        driver = BaseTest.initializeDriver();
        loginPage = new LoginPage(driver);
    }

    @When("user logs into the app with valid credentials")
    public void userLogin() {
        System.out.println("Username: " + loginData.getUsername());
        System.out.println("Password: " + loginData.getPassword());

        loginPage.loginDetails(loginData.getUsername(), loginData.getPassword(), loginData.getDob());
     
    }

    @And("user close the application")
    public void tearDown() {
        BaseTest.quitDriver();
        BaseTest.stopAppiumServer();
    }
}
