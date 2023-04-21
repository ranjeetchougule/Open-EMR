package qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {

	static WebDriver driver;
	
	public WebDriver initBrowser(String browsername) {
		
		if(browsername.equals("Chrome")) {
			
			driver = new ChromeDriver();
		}
		else if(browsername.equals("Edge")) {
			
			driver= new EdgeDriver();
		}
		
		return driver;
	}
	
	public static WebDriver getDriver() {
		
		return driver;
	}
}
