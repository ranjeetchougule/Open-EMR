package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

	private WebDriver driver;
	
	@FindBy (xpath="//*[@id='username']")
	private WebElement username;
	
	@FindBy (xpath="//*[@id='password']")
	private WebElement password;
	
	@FindBy (xpath="//*[@id='Registration Desk']")
	private WebElement registrationdesk;
	
	@FindBy (xpath="//*[@id='loginButton']")
	private WebElement loginbutton;
	
	@FindBy (xpath= "//*[@class='icon-user']")
	private WebElement rgisterbutton;
	
	public LoginPage(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void enterUsername(String uname) {
		
		username.sendKeys(uname);
	}
	
	public void enterPassword(String pwd) {
		
		password.sendKeys(pwd);
	}
	
	public void selectSession() {
		
		registrationdesk.click();
	}
	public void clickLogin() {
		
		loginbutton.click();
	}
	
	public NewPatientRegisterPage doLogin(String usname, String pass) {
		
		username.sendKeys(usname);
		password.sendKeys(pass);
		registrationdesk.click();
		loginbutton.click();
		
		return new NewPatientRegisterPage(driver);
	}
	
	public boolean confirmLogin() {
		
		boolean value = rgisterbutton.isDisplayed();
		
		return value;
		
	}
	public String getTitlePage() {
		
		String title = driver.getTitle();
		
		return title;
	}

}
