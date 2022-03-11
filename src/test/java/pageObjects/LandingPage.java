package pageObjects;

/**
 * 
 * @author Dipak
 *
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.JSLibrary;
import utils.JavaUtility;
import utils.TestContextSetup;
import utils.TestUtil;

public class LandingPage {

	public WebDriver driver;
	TestContextSetup textcontextsetup;
	LandingPage landingpage;
	JavaUtility javautil;
	JSLibrary jslibrary;
	TestUtil testutility;
	
	/**
	 * This is the default constructor of the Landing page
	 * 
	 * @param driver holds the driver reference of the TestBase class
	 */

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		javautil = new JavaUtility(this.driver);
		testutility = new TestUtil(this.driver);
	}

	private By sign_In_link = By.xpath("//a[contains(text(),'Sign in')]");
	public String expected_page_title = "My Store";

	/**
	 * This function will get the page title of index page and return that title
	 * 
	 * @return the title of landing page
	 */

	public String return_Landing_Page_Title() {
		return testutility.pageTitle();
	}

	/**
	 * This function will click the sign in button from header And Login to the
	 * Application
	 */

	public void sign_In() {
		javautil.wait_For_Element_Clickable(javautil.waittime, sign_In_link);
		testutility.click(sign_In_link);
	}

}
