package parallel;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		plugin = {"pretty",
				
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		},
			
			glue = {"parallel"},
			
			features = {"src/test/resources/parallel"}
			)
public class RunOpenEMRTest extends AbstractTestNGCucumberTests {

	@DataProvider(parallel = false)
	public Object[][] scenario (){
		return super.scenarios();
		
	}
	
}
