package pageObjects;

/**
 * 
 * @author Dipak
 *
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.JavaUtility;
import utils.TestUtil;

public class LoginPage {

	public WebDriver driver;
	JavaUtility javautil;
	TestUtil testutility;
	
	/**
	 * This is the default constructor of the Login page
	 * 
	 * @param driver holds the driver reference of the TestBase class
	 */

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		javautil = new JavaUtility(this.driver);
		testutility = new TestUtil(this.driver);
	}

	private By email_Textfield = By.id("email");
	private By password_Textfield = By.id("passwd");
	private By login_Button = By.id("SubmitLogin");
	public String loginpage_expecetd_page_title = "Login - My Store";

	/**
	 * This Function return Login Page Title
	 * 
	 */

	public String return_Login_Page_Title() {

		return driver.getTitle();
	}

	/**
	 * This Function accept
	 * 
	 * @param value for Email Text Box
	 * 
	 */
	public void enter_EmailId(String email) {

		testutility.entertext(email_Textfield, email);
	}

	/**
	 * This Function accept
	 * 
	 * @param value for Email password Text Box
	 * 
	 */

	public void enter_Password(String password) {
		testutility.entertext(password_Textfield, password);
	}

	/**
	 * This Function Click Login Button
	 * 
	 * 
	 */

	public void submitButton() {
		javautil.wait_For_Element_Clickable(javautil.waittime, login_Button);
		testutility.click(login_Button);
	}

}
