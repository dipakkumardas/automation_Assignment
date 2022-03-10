package cucumberOptions;
/**
 * 
 * @author Dipak
 * 
 *This Runner File Runs only Fail Test Case scenario
 */

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ="@target/failed_scenarios.txt",glue ="stepDefinations",monochrome=true,dryRun=false,tags="@UpdatePersonalInfo or @OrderTShart",
plugin= {"html:target/cucumber.html","json:target/cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class FailedTestNGTestRunner extends AbstractTestNGCucumberTests {
	
}
