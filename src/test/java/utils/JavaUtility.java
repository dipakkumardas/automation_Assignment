package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Dipak
 *
 */

/**
 * 
 *All Explicit Wait Declare Below
 *
 */

public class JavaUtility {
	
public WebDriver driver;
public WebDriverWait wait;
public final Long waittime=(long) 5000;
	
 public JavaUtility(WebDriver driver)
 { 
	 this.driver=driver; 
 }

 	/**
	  * Explicit wait for Element Click able
	  * @param time
	  * @param by
	  */
	
	public void wait_For_Element_Clickable(long time, By by) {

		wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}
		
	/**
	  * Explicit wait for Element Visible
	  * @param time
	  * @param by
	  */
	
	public void wait_For_Element_Visible(long time, By by) {

		wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		
	}
	
	
	
	
	
}
