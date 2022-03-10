package stepDefinations;

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
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

import utils.TestContextSetup;
import utils.TestUtil;

public class MyAccountPageStepDefination {

	public WebDriver driver;
	TestContextSetup textcontextsetup;
	LandingPage landingpage;
	LoginPage loginpage;
	MyAccountPage myaccount;
	TestUtil testutility;

	/**
	 * Create a Constructor and Pass the instance of Test Content setup
	 * 
	 * @param textcontextsetup
	 */

	public MyAccountPageStepDefination(TestContextSetup textcontextsetup) {

		this.textcontextsetup = textcontextsetup;
		this.myaccount = textcontextsetup.pageObjectManager.getMyaccountPage();
		testutility = new TestUtil(this.driver);
		

	}

	/**
	 * This Method is used to Click on My Personal Info Button On My Account page
	 * 
	 */
	@And("User click on my personal info button")
	public void user_click_on_my_personal_info_button() {
		
		myaccount.personal_Information_button();

	}

	/**
	 * This Method is Checking For My Personal Info Page Title.
	 * 
	 */

	@When("Landed on My personal info page")
	public void landed_on_my_personal_info_page() {

		Assert.assertEquals(myaccount.my_account_expected_page_title, myaccount.return_MyAccount_Page_Title());
	}

	/**
	 * This Method are passing the argument for First Name and Password
	 * 
	 * @param string- First Name
	 * @param string - Current Password
	 */

	@Then("Update firstname with {string} and currentpassword {string}")
	public void update_firstname_with_and_currentpassword(String firstname, String currentpass) {
		myaccount.update_First_name_personal_info(firstname, currentpass);
		Assert.assertEquals(myaccount.personal_info_Page, myaccount.personal_info_Breadcrumb_text());
		}

	/**
	 * This Method is used to Checked Updated FirstName on Header
	 * 
	 * @param string - Updated First Name
	 */
	@And("Verify udpated first name {string}")
	public void verify_udpated_first_name(String firstname) {

		String header_user_name = myaccount.get_Updated_user_name_from_Header();
		Assert.assertEquals(testutility.getFirstName(header_user_name),firstname);
	}

}
