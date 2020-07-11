package com.midtrans.web.automation.StepDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.midtrans.web.automation.pages.BasePage;
import com.midtrans.web.automation.pages.CreditCardPage;
import com.midtrans.web.automation.pages.IssuingBankPage;
import com.midtrans.web.automation.pages.MidtransHomePage;
import com.midtrans.web.automation.pages.OrderSummaryPage;
import com.midtrans.web.automation.pages.SelectPaymentPage;
import com.midtrans.web.automation.pages.ShoppingCartPage;
import com.midtrans.web.automation.pages.TransactionFailedPage;
import com.midtrans.web.automation.utilities.PropertyManager;

import io.cucumber.java8.En;
import io.cucumber.java8.Scenario;
/**
 * @author Satish Garnayak
 *
 */
public class PurchasePillowStepDefs implements En {

	WebDriver driver;
	MidtransHomePage midtransHomePage;
	ShoppingCartPage shoppingCartPage;
	OrderSummaryPage orderSummaryPage;
	SelectPaymentPage selectPaymentPage;
	CreditCardPage creditCardPage;
	IssuingBankPage issuingBankPage;
	TransactionFailedPage transactionFailedPage;
	BasePage base;

	public PurchasePillowStepDefs() {

		//Hook steps for after first step scenario operation
		Before((Scenario scenario) -> {
			Properties prop;
			try {
				//Reading properties from properties file
				prop = PropertyManager.readPropertiesFile("resources/application.properties");
               
				//It supports browser execution for chrome and firefox browser
				switch (prop.getProperty("browser")) {
				case "chrome":
					//Setting driver path for  chrome browser
					System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome.driver.path"));
					driver = new ChromeDriver();
					break;
				case "firefox":
					//Setting driver path for  firefox browser
					System.setProperty("webdriver.gecko.driver", prop.getProperty("gecko.driver.path"));
					driver = new FirefoxDriver();
					break;
				default:
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		//BDD Scenario steps starts from here
		Given("user launches {string} url", (String url) -> {
			System.out.println("==========URL has been Launched========");
			driver.get(url);
			driver.manage().window().maximize();
		});

		Then("midtrans home page loads", () -> {
			base = new BasePage(driver);
			midtransHomePage = base.getmidtransHomePage();
			midtransHomePage.verifyTitle();
		});

		Then("user clicks on BUY NOW button", () -> {
			midtransHomePage = base.getmidtransHomePage();
			midtransHomePage.clickOnBuyNowButton();
		});
		Then("user should see shopping cart section", () -> {
			shoppingCartPage = base.getshoppingCartPage();
			shoppingCartPage.verifyTitle();

		});
		Then("user clicks on CHECKOUT button", () -> {
			shoppingCartPage = base.getshoppingCartPage();
			shoppingCartPage.clickOnCheckoutButton();
		});

		Then("order summary page loads", () -> {
			orderSummaryPage = base.getorderSummaryPage();
			driver.switchTo().frame(0);
			orderSummaryPage.verifyTitle();
		});

		Then("user clicks on CONTINUE button on order summary page", () -> {
			orderSummaryPage = base.getorderSummaryPage();
			orderSummaryPage.clickOnContinueButton();
		});

		Then("select payment page loads", () -> {
			selectPaymentPage = base.getselectPaymentPage();
			selectPaymentPage.verifyTitle();
		});
		Then("user clicks on Credit Card option", () -> {
			selectPaymentPage = base.getselectPaymentPage();
			selectPaymentPage.clickOnCreditCardPaymentButton();
		});
		Then("credit card page loads", () -> {
			creditCardPage = base.getcreditCardPage();
			creditCardPage.verifyCreditCardTitle();
		});
		When("user fills valid credit card details", () -> {
			creditCardPage = base.getcreditCardPage();
			creditCardPage.FillCreditCardDetailsWithValidData();
		});

		When("user fills invalid credit card details", () -> {
			creditCardPage = base.getcreditCardPage();
			creditCardPage.FillCreditCardDetailsWithInvalidData();
		});

		Then("user clicks on PAY NOW button on credit card page", () -> {
			creditCardPage = base.getcreditCardPage();
			creditCardPage.clickOnPayNowButton();
			Thread.sleep(15000);
		});

		Then("issuing bank page loads", () -> {
			creditCardPage = base.getcreditCardPage();
			creditCardPage.verifyCreditCardTitle();

		});

		Then("user enters valid password", () -> {
			issuingBankPage = base.getissuingBankPage();
			driver.switchTo().frame(0);
			issuingBankPage.enterPassword();
		});

		Then("user clicks on OK button", () -> {
			issuingBankPage = base.getissuingBankPage();
			issuingBankPage.clickOnOkButton();

		});

		Then("user able to see successful message on thank you page", () -> {
			midtransHomePage = base.getmidtransHomePage();
			driver.switchTo().defaultContent();
			midtransHomePage.verifyThankYouForYourPurchaseText();

		});
		Then("transaction failed page loads", () -> {
			transactionFailedPage = base.getTransactionFailedPage();
			driver.switchTo().parentFrame();
			transactionFailedPage.verifyTransactionPageLoads();

		});

		//BDD Scenario steps ends here
		//Hook steps for after last step scenario operation
		After((Scenario scenario) -> {
			System.out.println("==========Browser has been closed========");
			driver.quit();
		});

	}
}