package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Dipak
 *
 */
public class JSLibrary {

	public WebDriver driver;
	
	public JSLibrary(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This function scrolls the screen and brings the WebElement into view
	 * 
	 * @param driver  driver reference
	 * @param element WebElement
	 */
	public void scroll_Into_View(By by) {

		WebElement element=driver.findElement(by);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
		
	

	


	

}
