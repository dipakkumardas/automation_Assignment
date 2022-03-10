package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TestUtil {

	/**
	 * This function returns the page title of a page
	 * 
	 * @return PageTitle
	 */

	public WebDriver driver;

	public TestUtil(WebDriver driver) {
		this.driver = driver;
	}

	public String pageTitle() {
		String pageTitle = null;
		try {
			pageTitle = driver.getTitle();
		} catch (Exception e) {
			e.getMessage();
		}
		return pageTitle;
	}

	/**
	 * This function clears default text from the text field
	 * 
	 * @param ele
	 */

	public void clear(By by) {

		try {
			driver.findElement(by).clear();
		} catch (Exception e) {
			e.getMessage();
		}

	}

	/**
	 * This function enters the input into the text field
	 * 
	 * @param ele   WebElement
	 * @param value desired input
	 */

	public void entertext(By by, String value) {

		try {
			driver.findElement(by).clear();
			driver.findElement(by).sendKeys(value);
		} catch (Exception e) {
			e.getMessage();
		}

	}

	/**
	 * This function clicks an Element
	 * 
	 * @param ele WebElement
	 */

	public void click(By by) {

		try {
			driver.findElement(by).click();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 * This function return the text from the dom
	 * 
	 * @param ele WebElement
	 * @return String
	 */

	public String gettext(By by) {
		String text = null;
		try {
			String text_raw = driver.findElement(by).getText();
			text = text_raw.trim();

		} catch (Exception e) {
			e.getMessage();
		}
		return text;
	}

	/**
	 * This Function is used to Enter Key press
	 * 
	 * @param by
	 */
	public void PressEnter(By by) {

		try {
			driver.findElement(by).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			e.getMessage();
		}

	}

	/**
	 * Fetch First Name From Header user Name
	 * 
	 * @param header_user_name
	 * @return
	 */
	public String getFirstName(String header_user_name) {
		String[] splited = header_user_name.split(" ");
		return splited[0].trim();
	}
}
