package cucumberOptions;

/**
 * 
 * @author Dipak
 *  Extent report also generated 
 */

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/feature", glue = "stepDefinations", monochrome = true, dryRun = false, tags = "@OrderTShirt", plugin = {
		"html:target/cucumber.html", "json:target/cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "rerun:target/failed_scenarios.txt" })
/**
 * AbstractTestNGCucumberTests is used to helped to execute the Feature File
 *
 */
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
