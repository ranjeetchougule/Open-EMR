package parallel;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import qa.ConfigReader;
import qa.DriverFactory;

public class AppHooks {

	ConfigReader cr;
	
	DriverFactory driverfactory;
	
	WebDriver driver;
	
	@Before
	public void lounchBrowser() {
		
		cr = new ConfigReader();
		
		String brname = cr.readProperties("browser");
		
		driverfactory = new DriverFactory();
				
		driver = driverfactory.initBrowser(brname);
		
		driver.manage().window().maximize();
	}
	
	@After(order =1)
	public void quitBrowser() {
		
		driver.quit();
	}
	
	@After(order =2)
	public void tearDown(Scenario scenario) {
		
		boolean isscenariofailed = scenario.isFailed();
		
		if (isscenariofailed) {
			
			String scenarioname = scenario.getName();
			
			String screenshotname = scenarioname.replaceAll(" ", "_");
			
			TakesScreenshot ts = (TakesScreenshot)driver;
			
			byte[] src = ts.getScreenshotAs(OutputType.BYTES);
			
			scenario.attach(src, "image/png", screenshotname);
		}
	}
}
