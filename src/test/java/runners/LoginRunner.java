package runners;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features",
		glue = "steps",
		tags = "@Scenario1OfOtherLogin",
		monochrome = true,
		dryRun = false,      //The purpose of dryRun in cucumber is basically to check the initialization and syntax errors in the code, and write it in my interview prep and teaching course
		plugin = {
				"pretty",
				"html:target/cucumber.html",
				"json:target/cucumber.json"
		}
		
		)

public class LoginRunner {

}
