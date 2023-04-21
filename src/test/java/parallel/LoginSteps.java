package parallel;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import qa.DriverFactory;

public class LoginSteps {

	LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	
	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
	   
		WebDriver driver = DriverFactory.getDriver();
		
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		
	}

	@When("user enters the username {string}")
	public void user_enters_the_username(String string) {
		loginpage.enterUsername(string);
	}

	@When("user enters the password {string}")
	public void user_enters_the_password(String string) {
		loginpage.enterPassword(string);
	}

	@When("user click on registration desk")
	public void user_click_on_registration_desk() {
	    loginpage.selectSession();
	}
	
	@When("user click on log in button")
	public void user_click_on_log_in_button() {
		loginpage.clickLogin();
	}
	
	@Then("user should land on home page")
	public void user_should_land_on_home_page() {
	   
		boolean value1 = loginpage.confirmLogin();
		
		Assert.assertEquals(value1, true);
	}

}
