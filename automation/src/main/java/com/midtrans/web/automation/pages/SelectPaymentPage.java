package com.midtrans.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
/**
 * @author Satish Garnayak
 *
 */
public class SelectPaymentPage {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor
	public SelectPaymentPage(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[@class='text-page-title']/p[text()='Select Payment']")
	WebElement selectPaymentTitle;

	@FindBy(xpath = "//div[@class='content-list' and @id='payment-list']/div//a[contains(@href,'#')]")
	WebElement creditCardPaymentButton;

	public WebElement getSelectPaymentTitle() {
		return selectPaymentTitle;
	}

	public WebElement getCreditCardPaymentButton() {
		return creditCardPaymentButton;
	}

	public void verifyTitle() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(getSelectPaymentTitle()));
		Assert.assertTrue(getSelectPaymentTitle().isDisplayed(), "Select Payment Page is loaded");
	}
	public void clickOnCreditCardPaymentButton() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(getCreditCardPaymentButton()));
		getCreditCardPaymentButton().click();
	}
}
