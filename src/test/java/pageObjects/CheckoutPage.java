package pageObjects;

import java.io.IOException;
import java.util.List;

/**
 * 
 * @author Dipak
 *
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.CheckoutPage;
import utils.JSLibrary;
import utils.JavaUtility;
import utils.TestUtil;

public class CheckoutPage {

	public WebDriver driver;
	TestUtil testutility;
	JavaUtility javautil;
	JSLibrary jslibrary;
	

	/**
	 * This is the default constructor of the CheckoutPage
	 * 
	 * @param driver holds the driver reference of the TestBase class
	 * @throws IOException
	 */

	public CheckoutPage(WebDriver driver){
		this.driver = driver;
		javautil = new JavaUtility(this.driver);
		testutility = new TestUtil(this.driver);
		jslibrary = new JSLibrary(this.driver);

	}

	private By tshirtcategory = By.xpath("(//a[@title='T-shirts'][normalize-space()='T-shirts'])[2]");
	private By tshirtname = By.xpath("//h5[@itemprop='name']//a");
	private By searchtshirt_textbox = By.xpath("//input[@id='search_query_top']");
	private By address_ProceedToCheckout = By.xpath("//button[@name='processAddress']");
	private By addedSuccessfully = By
			.xpath("//div[@class='layer_cart_product col-xs-12 col-md-6']//span[@class='cross']//following::h2[1]");
	private By shipping_proceed_to_Checkout = By.xpath("//button[@name='processCarrier']");
	private By add_To_Cart = By.xpath("//p[@id='add_to_cart']/button");
	private By shipping_Pages_Terms_Checkbox_Id = By.id("cgv");
	private By payment = By.xpath("//p/a[@class='bankwire']");
	private By confirmOrder = By.xpath("//span[contains(text(),'I confirm my order')]");
	private By order_Confirmation_Text = By.xpath("//div[@class='box']");
	private By continueshopping = By.xpath("//div//a[@title='Proceed to checkout']//span");
	private By Summary_ProceedToCheckout = By.xpath("//p//a[@title='Proceed to checkout']//span");
	private By order_History_Link = By.xpath("//a[contains(@title,'Back to orders')]");
	public String expected_checkout_page_title = "T-shirts - My Store";
	public String expected_checkout_order_page_title = "Order - My Store";
	public String reference_id = null;
		
	/**
	 * This Method Returns Checkout page title
	 * 
	 * @return
	 */
	

	public String return_checkout_Page_Title() {

		return testutility.pageTitle();

	}
	
	

	/**
	 * This functions brings the product listing section and Click TShart Category
	 *
	 */

	public void chooseProductCategory() {
		testutility.click(tshirtcategory);
	}

	/**
	 * After adding product to Cart this function fetching Add Successful Text
	 *
	 */

	public String added_Successfully_GetText() {

		return testutility.gettext(addedSuccessfully).trim();
	}

	/**
	 * This Function is used to search the product.
	 *
	 */

	public void enter_product_name(String tshirt) throws InterruptedException {
		testutility.entertext(searchtshirt_textbox, tshirt);
		testutility.PressEnter(searchtshirt_textbox);
		jslibrary.scroll_Into_View(tshirtname);
		javautil.wait_For_Element_Clickable(javautil.waittime, tshirtname);
		testutility.click(tshirtname);
	}

	/**
	 * This Function is used to add to cart.
	 *
	 */

	public void checkoutItems() throws InterruptedException {
		jslibrary.scroll_Into_View(add_To_Cart);
		testutility.click(add_To_Cart);

	}

	/**
	 * This Function is used for After adding cart it's move to continue shopping
	 *
	 */

	public void continueShopping() throws InterruptedException {
		jslibrary.scroll_Into_View(continueshopping);
		javautil.wait_For_Element_Clickable(javautil.waittime, continueshopping);
		testutility.click(continueshopping);
	}

	/**
	 * This Function is used for Final Proceed To checkout Process
	 *
	 */

	public void proceedToCheckout() {

		jslibrary.scroll_Into_View(Summary_ProceedToCheckout);
		javautil.wait_For_Element_Clickable(javautil.waittime, Summary_ProceedToCheckout);
		testutility.click(Summary_ProceedToCheckout);
		jslibrary.scroll_Into_View(address_ProceedToCheckout);
		testutility.click(address_ProceedToCheckout);
	}

	/**
	 * This Function is used for click terms and condition on checkout process
	 *
	 */

	public void terms_AndCondition_Check_Box() {

		jslibrary.scroll_Into_View(shipping_Pages_Terms_Checkbox_Id);
		testutility.click(shipping_Pages_Terms_Checkbox_Id);
	}

	/**
	 * This Function is used Shipping page checkout process
	 *
	 */
	public void shipping_Proceed_to_checkout() {
		javautil.wait_For_Element_Clickable(javautil.waittime, shipping_proceed_to_Checkout);
		testutility.click(shipping_proceed_to_Checkout);
	}

	/**
	 * This Function is used payment page choose payment Wait For Element is waiting
	 * till Element Visible
	 *
	 */
	public void payment() {
		javautil.wait_For_Element_Visible(javautil.waittime, payment);
		testutility.click(payment);
	}

	/**
	 * This Function is used for Confirm Order button Click
	 *
	 */
	public void confirm_Order() {
		javautil.wait_For_Element_Clickable(javautil.waittime, confirmOrder);
		testutility.click(confirmOrder);
		javautil.wait_For_Element_Visible(javautil.waittime, order_Confirmation_Text);
	}

	/**
	 * Click Back to order history page
	 */

	public void open_Order_History() {

		javautil.wait_For_Element_Clickable(javautil.waittime, order_History_Link);
		testutility.click(order_History_Link);
	}

	/**
	 * Fatch Order Ref Id
	 * 
	 * @return
	 */

	public String get_Order_Confirmation_Reference_Id() {

		String order_confirmation_text = testutility.gettext(order_Confirmation_Text);
		int index_reference_text = order_confirmation_text.indexOf("reference");
		reference_id = order_confirmation_text.substring(index_reference_text + 10, index_reference_text + 19);
		return reference_id;

	}
	
	/**
	 *  validate order from Order table
	 * @param refId
	 * @return
	 */
	
	public boolean validateOrderHistory(String refId) {
		   List<WebElement> rowsOfTable = driver.findElements(By.xpath("//*[@id='order-list']/tbody/tr"));
		   boolean flag = false;
		   for (int i = 1; i < rowsOfTable.size(); i++) {
		      if (rowsOfTable.get(i).findElement(By.xpath("//td[1]")).getText().contains(refId)) {
		         flag = true;
		         break;
		      }
		   }

		   return flag;

		}
	

}
