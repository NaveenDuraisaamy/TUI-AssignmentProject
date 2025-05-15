package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseTest;
import utils.KeyboardActions;

import java.time.Duration;

public class LoginPage extends BaseTest {

	private final WebDriverWait wait;
	private final AndroidDriver driver;
	private final KeyboardActions keyboardActions;

	public LoginPage(final AppiumDriver driver) {
		this.driver = (AndroidDriver) driver;
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
		this.keyboardActions = new KeyboardActions(this.driver);
		PageFactory.initElements(new AppiumFieldDecorator(this.driver, Duration.ofSeconds(10)), this);
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"username_input_field\")")
	private WebElement usernameField;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"password_input_field\")")
	private WebElement passwordField;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='date_of_birth_field_calendar_icon']/android.widget.Button")
	private WebElement dateIcon;

	@AndroidFindBy(uiAutomator = "new UiSelector().description(\"Switch to text input mode\")")
	private WebElement editIcon;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Date\")")
	private WebElement dateInputField;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"date_of_birth_dialog_confirm_button\")")
	private WebElement confirmButton;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"login_form_submit_button\")")
	private WebElement loginButton;

	public void loginDetails(String username, String password, String dob) {
		wait.until(ExpectedConditions.visibilityOf(usernameField)).clear();
		usernameField.sendKeys(username);

		wait.until(ExpectedConditions.visibilityOf(passwordField)).clear();
		passwordField.sendKeys(password);

		wait.until(ExpectedConditions.elementToBeClickable(dateIcon)).click();
		wait.until(ExpectedConditions.elementToBeClickable(editIcon)).click();
		wait.until(ExpectedConditions.elementToBeClickable(dateInputField)).click();

		// Assuming pressNumberKeys inputs the DOB - otherwise change to sendKeys(dob)
		keyboardActions.pressNumberKeys(dob);

		wait.until(ExpectedConditions.elementToBeClickable(confirmButton)).click();
		wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
	}
}
