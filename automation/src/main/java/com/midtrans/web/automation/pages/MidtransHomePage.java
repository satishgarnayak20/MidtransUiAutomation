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
public class MidtransHomePage {
	WebDriver driver;
	WebDriverWait wait;

	public MidtransHomePage(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='title']")
	WebElement titleText;

	@FindBy(xpath = "//a[@class='btn buy']")
	WebElement buyNowButton;

	@FindBy(xpath = "//span[text()='Thank you for your purchase.']")
	WebElement thankYouForYourPurchaseText;

	public WebElement getThankYouForYourPurchaseText() {
		return thankYouForYourPurchaseText;
	}

	public WebElement getTitleText() {
		return titleText;
	}

	public WebElement getBuyNowButton() {
		return buyNowButton;
	}

	public void clickOnBuyNowButton() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(getBuyNowButton()));
		getBuyNowButton().click();
	}

	public void verifyTitle() {

		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(getTitleText()));
		Assert.assertTrue(getTitleText().isDisplayed(), "Title is displayed");
	}

	public void verifyThankYouForYourPurchaseText() {

		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(getThankYouForYourPurchaseText()));
		Assert.assertTrue(getThankYouForYourPurchaseText().isDisplayed(), "Thank you for your purchase is displayed");
	}

}
