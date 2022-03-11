package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import pageObjects.MyAccountPage;
import pageObjects.PageObjectManager;

public class TestContextSetup {

	/** All Variable we declare on this Class
	 * 
	 */
	public WebDriver driver;
	public TestBase testBase;
	public JavaUtility javautil;
	public LandingPage landingpage;
	public MyAccountPage myaccountpage;
	public CheckoutPage checkoutpage;
	public JSLibrary jslibrary;
	public TestUtil testutility;
	
	public PageObjectManager pageObjectManager;
	
	/**
	 * This class is Initialization of Object of Page Object manager
	 * @throws IOException
	 */

	public TestContextSetup() throws IOException {
		
		testBase = new TestBase();
		pageObjectManager = new PageObjectManager(testBase.WebDriverManager());
		landingpage= new LandingPage(testBase.WebDriverManager());
		checkoutpage = new CheckoutPage(testBase.WebDriverManager());
		myaccountpage = new MyAccountPage(testBase.WebDriverManager());
		javautil= new JavaUtility(testBase.WebDriverManager());
		jslibrary = new JSLibrary(testBase.WebDriverManager());
		testutility = new TestUtil(testBase.WebDriverManager());
		
	}

}
