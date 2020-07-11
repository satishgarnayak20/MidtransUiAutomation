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
public class IssuingBankPage {
	WebDriver driver;
	WebDriverWait wait;

	// Constructor
	public IssuingBankPage(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//h1[text()='Issuing Bank']")
	WebElement issuingBankTitle;

	@FindBy(xpath = "//div[@class='col-xs-7']/input[@id='PaRes']")
	WebElement passwordTextbox;

	@FindBy(xpath = "//button[@class='btn btn-sm btn-success']")
	WebElement okButton;

	@FindBy(xpath = "//button[@name='cancel']")
	WebElement cancelButton;

	@FindBy(xpath = "//button[@name='resend']")
	WebElement resendButton;

	public WebElement getIssuingBankTitle() {
		return issuingBankTitle;
	}

	public WebElement getPasswordTextbox() {
		return passwordTextbox;
	}

	public WebElement getOkButton() {
		return okButton;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}

	public WebElement getResendButton() {
		return resendButton;
	}

	public void verifyIssuingBankTitle() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(getIssuingBankTitle()));
		Assert.assertTrue(getIssuingBankTitle().isDisplayed(), "Issuing Bank title is displayed");
	}

	public void clickOnOkButton() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(getOkButton()));
		getOkButton().click();
	}
	
	public void enterPassword(){
		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(getPasswordTextbox()));
		Properties prop;
		try {
			prop = PropertyManager.readPropertiesFile("resources/application.properties");
			String password = TestUtility.encodeString(prop.getProperty("password"));
			getPasswordTextbox().clear();
			getPasswordTextbox().sendKeys(TestUtility.decodedString(password));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
