package com.midtrans.web.automation.pages;

import org.openqa.selenium.WebDriver;

/**
 * @author Satish Garnayak
 *
 */
public class BasePage {

	private WebDriver driver;
	private MidtransHomePage midtransHomePage;
	private ShoppingCartPage shoppingCartPage;
	private OrderSummaryPage orderSummaryPage;
	private SelectPaymentPage selectPaymentPage;
	private CreditCardPage creditCardPage;
	private IssuingBankPage issuingBankPage;
	private TransactionFailedPage transactionFailedPage;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public MidtransHomePage getmidtransHomePage() {
		return (midtransHomePage == null) ? midtransHomePage = new MidtransHomePage(driver) : midtransHomePage;
	}

	public ShoppingCartPage getshoppingCartPage() {
		return (shoppingCartPage == null) ? shoppingCartPage = new ShoppingCartPage(driver) : shoppingCartPage;
	}

	public OrderSummaryPage getorderSummaryPage() {
		return (orderSummaryPage == null) ? orderSummaryPage = new OrderSummaryPage(driver) : orderSummaryPage;
	}

	public SelectPaymentPage getselectPaymentPage() {
		return (selectPaymentPage == null) ? selectPaymentPage = new SelectPaymentPage(driver) : selectPaymentPage;
	}

	public CreditCardPage getcreditCardPage() {
		return (creditCardPage == null) ? creditCardPage = new CreditCardPage(driver) : creditCardPage;
	}

	public IssuingBankPage getissuingBankPage() {
		return (issuingBankPage == null) ? issuingBankPage = new IssuingBankPage(driver) : issuingBankPage;
	}

	public TransactionFailedPage getTransactionFailedPage() {
		return (transactionFailedPage == null) ? transactionFailedPage = new TransactionFailedPage(driver)
				: transactionFailedPage;
	}

}
