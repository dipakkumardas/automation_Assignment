package stepDefinations;

import java.io.IOException;

/**
 * 
 * @author Dipak
 *
 */

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;

public class CheckOutPageStepDefination {

	public WebDriver driver;
	public CheckoutPage checkoutPage;
	TestContextSetup textcontextsetup;
	String orderconfirm;

	/**
	 * Create a Constructor and Pass the instance of Test Content setup
	 * 
	 * @param textcontextsetup
	 * @throws IOException 
	 */

	public CheckOutPageStepDefination(TestContextSetup textcontextsetup) {
		this.textcontextsetup = textcontextsetup;
		this.checkoutPage = textcontextsetup.pageObjectManager.getCheckoutPage();
		
	}

	/**
	 * Click on TShirt category and verify title
	 * 
	 */
	@And("Click on the T-shirts category Link")
	public void click_on_the_t_shirts_category_link() {

		checkoutPage.chooseProductCategory();
		checkoutPage.return_checkout_Page_Title();
		Assert.assertEquals(checkoutPage.expected_checkout_page_title, checkoutPage.return_checkout_Page_Title());
	}

	/**
	 * Search Product
	 * 
	 */
	@When("Search with {string} for purchase")
	public void search_with_for_purchase(String tShirt) throws InterruptedException {
		checkoutPage.enter_product_name(tShirt);

	}

	/**
	 * Completing the checkout process
	 * 
	 */
	@Then("click on proceed to checkout button and complete check out process and verify order")
	public void click_on_proceed_to_checkout_button_and_complete_check_out_process() throws InterruptedException {
		checkoutPage.checkoutItems();
		checkoutPage.ContinueShopping();
		checkoutPage.ProceedToCheckout();
		Assert.assertEquals(checkoutPage.expected_checkout_order_page_title, checkoutPage.return_checkout_Page_Title());
		checkoutPage.terms_AndCondition_Check_Box();
		checkoutPage.shipping_Proceed_to_checkout();
		checkoutPage.payment();
		checkoutPage.confirm_Order();
		orderconfirm =checkoutPage.get_Order_Confirmation_Reference_Id();
		checkoutPage.open_Order_History();
		Assert.assertTrue(checkoutPage.validateOrderHistory(orderconfirm));
	}

}
