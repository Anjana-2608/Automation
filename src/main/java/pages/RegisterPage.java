package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

	protected WebDriver driver;

	// Constructor
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	private By MyAccount = By.xpath("//span[text()='My Account']");
	private By registerLink = By.linkText("Register");

	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmPassword = By.id("input-confirm");
	private By agreeCheckbox = By.name("agree");
	private By continueButton = By.xpath("//input[@value='Continue']");

	private By successHeading = By.xpath("//div[@id='common-success']//h1");
	private By logoutLink = By.linkText("Logout");
	private By contentText = By.id("content");
	private By continueAfterRegister = By.xpath("//a[text()='Continue']");
	private By editAccountInfo = By.linkText("Edit your account information");

	// Actions
	public void openRegisterPage() {
		waitForElementToBeClickable(driver, MyAccount).click();
	}

	public void clickRegisterlink() {
		driver.findElement(registerLink).click();
	}

	public void enterFirstName(String fname) {
		driver.findElement(firstName).sendKeys(fname);
	}

	public void enterLastName(String lname) {
		driver.findElement(lastName).sendKeys(lname);
	}

	public void enterEmail(String emailValue) {
		driver.findElement(email).sendKeys(emailValue);
	}

	public void enterTelephone(String phone) {
		driver.findElement(telephone).sendKeys(phone);
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(confirmPassword).sendKeys(pwd);
	}

	public void agreeToPolicy() {
		driver.findElement(agreeCheckbox).click();
	}

	public void clickContinue() {
		driver.findElement(continueButton).click();
	}

	// Validations
	public boolean isLogoutDisplay() {
		return driver.findElement(logoutLink).isDisplayed();
	}

	public String getSuccessHeading() {
		return driver.findElement(successHeading).getText();
	}

	public String getContentText() {
		return driver.findElement(contentText).getText();
	}

	public void clickContinueAfterRegister() {
		driver.findElement(continueAfterRegister).click();
	}

	public boolean isEditInfoDisplay() {
		return driver.findElement(editAccountInfo).isDisplayed();
	}

	public WebElement waitForElementToBeClickable(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

}
