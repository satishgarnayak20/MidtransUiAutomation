package com.midtrans.web.automation.pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.midtrans.web.automation.utilities.PropertyManager;
import com.midtrans.web.automation.utilities.TestUtility;
/**
 * @author Satish Garnayak
 *
 */
public class CreditCardPage {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor
	public CreditCardPage(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//p[@class='text-page-title-content']")
	WebElement creditCardTitle;

	@FindBy(xpath = "//div[@class='card-container']//input[@name='cardnumber']")
	WebElement cardNumberTextbox;

	@FindBy(xpath = "//div[@class='card-container']//input[@placeholder='MM / YY']")
	WebElement expiryDateTextbox;

	@FindBy(xpath = "//div[@class='card-container']//input[@placeholder='123']")
	WebElement cvvTextbox;

	@FindBy(xpath = "//a[@class='button-main-content']")
	WebElement payNowButton;

	public WebElement getCreditCardTitle() {
		return creditCardTitle;
	}

	public WebElement getCardNumberTextbox() {
		return cardNumberTextbox;
	}

	public WebElement getExpiryDateTextbox() {
		return expiryDateTextbox;
	}

	public WebElement getCvvTextbox() {
		return cvvTextbox;
	}

	public WebElement getPayNowButton() {
		return payNowButton;
	}

	public void verifyCreditCardTitle(){
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(getCreditCardTitle()));
		Assert.assertTrue(getCreditCardTitle().isDisplayed(), "Title is displayed");
	}
	
	public void FillCreditCardDetailsWithValidData() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(getCardNumberTextbox()));
		try {
			Properties prop = PropertyManager.readPropertiesFile("resources/application.properties");
			String creditCardNumber = TestUtility.encodeString(prop.getProperty("validcreditcardnumber"));
			String cvv = TestUtility.encodeString(prop.getProperty("cvv"));
			String expireDate = TestUtility.encodeString(prop.getProperty("expiredate"));
			getCardNumberTextbox().sendKeys(TestUtility.decodedString(creditCardNumber));
			getExpiryDateTextbox().sendKeys(TestUtility.decodedString(expireDate));
			getCvvTextbox().sendKeys(TestUtility.decodedString(cvv));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void FillCreditCardDetailsWithInvalidData() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(getCardNumberTextbox()));
		try {
			Properties prop = PropertyManager.readPropertiesFile("resources/application.properties");
			String creditCardNumber = TestUtility.encodeString(prop.getProperty("invalidcreditcardnumber"));
			String cvv = TestUtility.encodeString(prop.getProperty("cvv"));
			String expireDate = TestUtility.encodeString(prop.getProperty("expiredate"));
			getCardNumberTextbox().sendKeys(TestUtility.decodedString(creditCardNumber));
			getExpiryDateTextbox().sendKeys(TestUtility.decodedString(expireDate));
			getCvvTextbox().sendKeys(TestUtility.decodedString(cvv));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void clickOnPayNowButton() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(getPayNowButton()));
		getPayNowButton().click();
	}

}
