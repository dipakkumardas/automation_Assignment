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

public class MyAccountPage {

	public WebDriver driver;
	JavaUtility javautil;
	TestUtil testutility;
	
	/**
	 * This is the default constructor of the My Account page
	 * 
	 * @param driver holds the driver reference of the TestBase class
	 */

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		javautil = new JavaUtility(this.driver);
		testutility = new TestUtil(this.driver);
	}

	private By header_User_Name = By.xpath("//div[contains(@class,'header_user_info')]//span");
	private By personal_Information = By.xpath("//span[contains(text(),'My personal information')]");
	private By page_Breadcrumb = By.xpath("//span[contains(@class,'navigation_page')]");
	private By firstname_Id = By.id("firstname");
	private By current_Password_Id = By.id("old_passwd");
	private By save_Personal_Info_Button = By.xpath("//button[contains(@name,'submitIdentity')]");
	public String my_account_expected_page_title = "Identity - My Store";
	public String personal_info_Page="Your personal information";

	/**
	 * This function will get the page title of MyAccount page and return that title
	 * 
	 * @return the title of MyAccount page
	 */

	public String return_MyAccount_Page_Title() {

		return testutility.pageTitle();
	}

	/**
	 * This function will get the header user name of MyAccount page and return that
	 * Name
	 * 
	 * @return the Header name of MyAccount page
	 */

	public String return_Header_User_Name() {

		return testutility.gettext(header_User_Name);
	}

	/**
	 * This function click on Personal Information Button on MyAccount Page
	 *
	 */

	public void personal_Information_button() {

		javautil.wait_For_Element_Clickable(javautil.waittime, personal_Information);
		testutility.click(personal_Information);
	}

	/**
	 * This function fatch BreadCrumb text on MyAccount Page
	 *
	 */

	public String personal_info_Breadcrumb_text() {

		return testutility.gettext(page_Breadcrumb);
		}

	/**
	 * This function Updating Personal Information
	 *
	 */

	public void update_First_name_personal_info(String firstname, String old_password) {

		testutility.entertext(firstname_Id, firstname);
		testutility.entertext(current_Password_Id, old_password);
		testutility.click(save_Personal_Info_Button);
	}

	/**
	 * Fatch Updated Header Text
	 */
	public String get_Updated_user_name_from_Header() {
		return testutility.gettext(header_User_Name);
		
	}

}
