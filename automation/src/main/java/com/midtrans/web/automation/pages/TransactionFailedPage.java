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
public class TransactionFailedPage {
	WebDriver driver;
	WebDriverWait wait;

	// Constructor
	public TransactionFailedPage(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[text()='Transaction failed']")
	WebElement transactionFailedTitle;

	@FindBy(xpath = "//span[text()='Your card got declined by the bank']")
	WebElement yourCardGotDeclinedByBankText;

	public WebElement getTransactionFailedTitle() {
		return transactionFailedTitle;
	}

	public WebElement getYourCardGotDeclinedByBankText() {
		return yourCardGotDeclinedByBankText;
	}

	public void verifyTransactionPageLoads() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(getTransactionFailedTitle()));
		Assert.assertTrue(getTransactionFailedTitle().isDisplayed(), "Transaction Failed");
		wait.until(ExpectedConditions.visibilityOf(getYourCardGotDeclinedByBankText()));
		Assert.assertTrue(getYourCardGotDeclinedByBankText().isDisplayed(), "Your card got declined by the bank");
	}

}
