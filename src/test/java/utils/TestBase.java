package utils;


import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * 
 * @author Dipak
 *
 */



public class TestBase {

	public WebDriver driver;
	public FileInputStream fis;
	public Properties prop;
	
	/**
	 * 	Create Driver Object ,
	 *  Create File InputStream Object
	 *  Create Property Object 
	 */

	
	public WebDriver WebDriverManager() throws IOException {

		
		 fis = new FileInputStream( System.getProperty("user.dir") +"//src//test//resources//global.properties"); 
		 prop = new Properties();
		 prop.load(fis);
		 
		String url = prop.getProperty("QAUrl");
		
		/**
		 *Driver Initialize only once , If It's already Initialize then it's only
		* Return the driver
		* This Checking is hare Below 
		*/

		if (driver == null) {

			if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +"//src//test//resources//chromedriver.exe");
				driver = new ChromeDriver(); 
			}

			if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") +"//src//test//resources//geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get(url);
			

		}
		return driver;
	}

}
