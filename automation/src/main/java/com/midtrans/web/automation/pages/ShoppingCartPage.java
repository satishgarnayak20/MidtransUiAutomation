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
public class ShoppingCartPage {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor
	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='cart-head']/span[starts-with(text(),'Shopping Cart')]")
	WebElement shoppingCartTitle;

	@FindBy(xpath = "//div[@class='cart-checkout']")
	WebElement checkoutButton;

	@FindBy(xpath = "//div[@class='cancel-btn']")
	WebElement cancelButton;

	public WebElement getShoppingCartTitle() {
		return shoppingCartTitle;
	}

	public WebElement getCheckoutButton() {
		return checkoutButton;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}

	public void verifyTitle() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(getShoppingCartTitle()));
		Assert.assertTrue(getShoppingCartTitle().isDisplayed(), "Shopping cart title is displayed");
	}

	public void clickOnCheckoutButton() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(getCheckoutButton()));
		getCheckoutButton().click();
	}

}
