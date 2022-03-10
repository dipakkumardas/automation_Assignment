package stepDefinations;

import java.io.FileInputStream;

/**
 * 
 * @author Dipak
 *
 */

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utils.JavaUtility;
import utils.TestContextSetup;

public class LandingPageStepDefination {

	public WebDriver driver;
	TestContextSetup textcontextsetup;
	LandingPage landingpage;
	LoginPage loginpage;
	MyAccountPage myaccount;
	JavaUtility javautil;
	public FileInputStream fis;

	/**
	 * Create a Constructor and Pass the instance of test Content setup
	 * 
	 * @param textcontextsetup
	 * @throws IOException
	 */

	public LandingPageStepDefination(TestContextSetup textcontextsetup) throws IOException {

		this.textcontextsetup = textcontextsetup;
		this.landingpage = textcontextsetup.pageObjectManager.getLandingPage();
		this.myaccount = textcontextsetup.pageObjectManager.getMyaccountPage();
		this.loginpage = textcontextsetup.pageObjectManager.getLoginPage();
		this.javautil = textcontextsetup.pageObjectManager.getJavaUtility();
		this.fis = textcontextsetup.testBase.fis;
		textcontextsetup.testBase.prop.load(fis);

	}

	/**
	 * Check user is on landing page
	 * 
	 * @throws InterruptedException
	 * 
	 */

	@Given("User is on the landing page")
	public void user_is_on_landing_page() throws InterruptedException {
		Assert.assertEquals(landingpage.expected_page_title,landingpage.return_Landing_Page_Title());
	}

	/**
	 * Login to the site Get user Details From Property File
	 * 
	 */
	@And("Log in with a valid user id and password")
	public void loging_with_valid_userid_and_password() {
		landingpage.sign_In();
		Assert.assertEquals(loginpage.loginpage_expecetd_page_title,loginpage.return_Login_Page_Title());
		loginpage.enter_EmailId(textcontextsetup.testBase.prop.getProperty("email"));
		loginpage.enter_Password(textcontextsetup.testBase.prop.getProperty("pass"));
		loginpage.submitButton();
	}

	/**
	 * After Login verify MyAccount Page
	 * 
	 */

	@And("Verify my account page after login")
	public void verify_my_account_page_after_login() {
		myaccount.return_MyAccount_Page_Title();
	}

}
