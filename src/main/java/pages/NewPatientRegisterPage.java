package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewPatientRegisterPage {

	private WebDriver driver;
	
	private WebDriverWait wait;
	
	Select sel;
	
	@FindBy (xpath= "//*[@class='icon-user']")
	private WebElement rgisterbutton;
	
	@FindBy (xpath= "//*[@name='givenName']")
	private WebElement clientname;
	
	@FindBy (xpath= "//*[@name='familyName']")
	private WebElement lastname;
	
	@FindBy (xpath="//*[@class='question-legend']//*[@id='genderLabel']")
	private WebElement gender;
	
	@FindBy (xpath="//*[@id=\"gender-field\"]")
	private WebElement genderdropdown;
	
	@FindBy (xpath= "//*[@id='next-button']//*[@class='fas fa-chevron-right']")
	private WebElement birthdate;
	
	@FindBy (xpath= "//*[@id='birthdateDay-field']")
	private WebElement day;
	
	@FindBy (xpath="//*[@id='birthdateMonth-field']")
	private WebElement month;
	
	@FindBy (xpath="//*[@id='birthdateYear-field']")
	private WebElement year;
	
	@FindBy (xpath="//*[@id='confirmation_label']")
	private WebElement confirm;
	
	@FindBy (xpath="//*[@id='submit']")
	private WebElement finalconfirm;
	
	public NewPatientRegisterPage(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	public void clickRegister() {
		
		wait.until(ExpectedConditions.visibilityOf(rgisterbutton));
		rgisterbutton.click();
	}
	
	public void enterClientname(String cltname) {
		
		clientname.sendKeys(cltname);
	}
	
	public void enterLastname(String lname) {
		
		lastname.sendKeys(lname);
	}
	
	public void clickGender() {
		
		gender.click();
	}
	public void selectGender() {
		
		sel = new Select(genderdropdown);
		sel.selectByIndex(1);
	}
	public void clickBirthdate() {
		
		wait.until(ExpectedConditions.visibilityOf(birthdate));
		birthdate.click();
	}
	
	public void selectBirthdate(String days, int months, String yrs) {
		
		wait.until(ExpectedConditions.visibilityOf(day));

		day.sendKeys(days);
		sel = new Select(month);
		sel.selectByIndex(months);
		year.sendKeys(yrs);
	}
	
	public void confirmregister() {
		
		confirm.click();
		finalconfirm.click();
	}
	
	public String getTitlePage() {
		
		String title = driver.getTitle();
		
		return title;
	}
}


