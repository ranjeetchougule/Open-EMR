package parallel;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.NewPatientRegisterPage;
import qa.DriverFactory;

public class NewPatientRegisterSteps {
	
	LoginPage loginpage = new LoginPage(DriverFactory.getDriver());

	NewPatientRegisterPage newregister;
	
	
	@Given("user is already logged in with {string} and {string}")
	public void user_is_already_logged_in_with_and(String string, String string2) {
	    
		WebDriver driver = DriverFactory.getDriver();
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		
		newregister = loginpage.doLogin(string, string2);
	}

	@When("user click on register patient option")
	public void user_click_on_register_patient_option() {
	    
		newregister.clickRegister();
	}

	@When("user enter firstname as {string}")
	public void user_enter_firstname_as(String string) {
	    
		newregister.enterClientname(string);
	}

	@When("user enter lastname as {string}")
	public void user_enter_lastname_as(String string) {
	    
		newregister.enterLastname(string);
	}

	@When("user click on gender")
	public void user_click_on_gender() {
		newregister.clickGender();
	}

	@When("user select gender")
	public void user_select_gender() {

		newregister.selectGender();
	}

	@When("user click on birthday")
	public void user_click_on_birthday() {
	    
		newregister.clickBirthdate();
	}

	@When("user select birthdate as day {string}, month {int} and year {string}")
	public void user_select_birthdate_as_day_month_and_year(String string, int int1, String string3) {
	    
		newregister.selectBirthdate(string, int1, string3);
	}
	
	@When("user click on confirm")
	public void user_click_on_confirm() {

		newregister.confirmregister();
	}
}
