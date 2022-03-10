package pageObjects;

import java.io.IOException;

/**
 * 
 * @author Dipak
 *
 */

import org.openqa.selenium.WebDriver;

import utils.JSLibrary;
import utils.JavaUtility;
import utils.TestBase;
import utils.TestUtil;

public class PageObjectManager {

	/**
	 * This Page Object Manger is creating the Object and assigning to the driver
	 * 
	 */

	public WebDriver driver;
	public LandingPage landingpage;
	public CheckoutPage checkoutPage;
	public MyAccountPage myaccountPage;
	public LoginPage loginPage;
	public TestBase testBase;
	public JavaUtility javautility;
	public JSLibrary jslibrary;
	public TestUtil testutility;
	
	/**
	 *  PageObjectManagerConstructor 
	 * @param driver
	 */

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Create landing Page object and Assign to driver 
	 * @return
	 */

	public LandingPage getLandingPage() {
		landingpage = new LandingPage(driver);
		return landingpage;
	}

	/**
	 * Create Checkout Page object and Assign to driver 
	 * @return
	 */
	public CheckoutPage getCheckoutPage() {
		checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}
	
	/**
	 * Create MyAccountPage object and Assign to driver 
	 * @return
	 */
	
	public MyAccountPage getMyaccountPage() {
		myaccountPage = new MyAccountPage(driver);
		return myaccountPage;
	}

	/**
	 * Create LoginPage object and Assign to driver 
	 * @return
	 */
	public LoginPage getLoginPage() throws IOException {
		loginPage = new LoginPage(driver);
		return loginPage;
	}


	/**
	 * Create TestBase object and Assign to driver 
	 * @return
	 */
	public TestBase getTestBase() throws IOException {
		testBase = new TestBase();
		return testBase;
	}

	/**
	 * Create JavaUtility object and Assign to driver 
	 * @return
	 */	
	public JavaUtility getJavaUtility() {
		javautility = new JavaUtility(driver);
		return javautility;
	}

	/**
	 * Create JSLibrary object and Assign to driver 
	 * @return
	 */	

	public JSLibrary getJSLibrary() {
		jslibrary = new JSLibrary(driver);
		return jslibrary;
	}
	/**
	 *  Create TestUtil objects and Assign to driver
	 * @return
	 */
	
	public TestUtil getTestUtils()
	{
		testutility = new TestUtil(driver);
		return testutility;
	}
	
	
}
