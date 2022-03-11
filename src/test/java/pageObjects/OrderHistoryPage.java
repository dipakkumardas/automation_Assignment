package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.JavaUtility;
import utils.TestContextSetup;
import utils.TestUtil;

public class OrderHistoryPage {
	public WebDriver driver;
	JavaUtility javautil;
	LoginPage loginpage;
	TestContextSetup textcontextsetup;
	TestUtil testutility;
	public String orderreference;
	
	
	public OrderHistoryPage(WebDriver driver)
	{
		this.driver = driver;
		javautil = new JavaUtility(this.driver);
		testutility = new TestUtil(this.driver);
	}
	
	
	 By order_History_Breadcrumb_Text = By.xpath("//span[contains(@class,'navigation_page')]");
	 By order_Reference = By.xpath("//tr[contains(@class,'first_item')]//a[@class='color-myaccount']");
	// By order_Price = By.xpath("//tr[contains(@class,'first_item')]//span[@class='price']");
	// By payment_Method = By.xpath("//tr[contains(@class,'first_item')]//td[@class='history_method']");
	
	
	 public String get_Breadcrumb_Text() {

			String breadcrumb_text = testutility.gettext(order_History_Breadcrumb_Text);
			return breadcrumb_text;
		}
	 
	 public String get_Order_Reference_Id() {

		 orderreference = testutility.gettext(order_Reference);
		// String orderreference = TestUtil.gettext(TestUtil.getElement(OrderHistoryPage.order_Reference));
			return orderreference;
		}

}
