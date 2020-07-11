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
public class OrderSummaryPage {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor
	public OrderSummaryPage(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[@class='text-page-title']")
	WebElement orderSummaryTitle;

	@FindBy(xpath = "//a[@href='#/select-payment']")
	WebElement continueButton;

	public WebElement getOrderSummaryTitle() {
		return orderSummaryTitle;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

	public void verifyTitle() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(getOrderSummaryTitle()));
		Assert.assertTrue(getOrderSummaryTitle().isDisplayed(), "Order Summary title is displayed");
	}

	public void clickOnContinueButton() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(getContinueButton()));
		getContinueButton().click();
	}
}
