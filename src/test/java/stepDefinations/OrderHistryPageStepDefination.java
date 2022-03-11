package stepDefinations;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.CheckoutPage;
import pageObjects.OrderHistoryPage;
import utils.TestContextSetup;

public class OrderHistryPageStepDefination {
	
	public WebDriver driver;
	
	
	TestContextSetup textcontextsetup;
	public OrderHistoryPage orderhistory;
	public CheckoutPage checkoutPage;
	
	public OrderHistryPageStepDefination(TestContextSetup textcontextsetup)
	{
		this.textcontextsetup = textcontextsetup;
		this.orderhistory = textcontextsetup.pageObjectManager.getOrderHistiry();
		this.checkoutPage=textcontextsetup.pageObjectManager.getCheckoutPage();
		
	}
	
	@Then("click back to order histry and verify the order")
	public void click_back_to_order_histry_and_verify_the_order() {
		//checkoutPage.get_Order_Confirmation_Reference_Id()
		//String refid= checkoutPage.get_Order_Confirmation_Reference_Id();
		//System.out.println(checkoutPage.reference_id);
		//orderhistory.get_Order_Reference_Id();
		//System.out.println(orderhistory.get_Order_Reference_Id());
		System.out.println("Cehckout page :"+checkoutPage.get_Order_Confirmation_Reference_Id());
		System.out.println("Order HistoryPage:"+orderhistory.get_Order_Reference_Id());
		Assert.assertEquals(checkoutPage.get_Order_Confirmation_Reference_Id(), orderhistory.get_Order_Reference_Id());
	}

}
