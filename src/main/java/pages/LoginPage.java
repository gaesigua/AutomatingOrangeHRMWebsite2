package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	//1. Initializing the driver
	
	WebDriver driver;
	
	
	//2. Let's create a parameterized constructor
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	//3. Let's find our Elements using: POM (Page Object Model) and the WebElement:
	
                                            //	By USERNAME_FIELD = By.XPATH("");    //In Page Object Model (POM), the By method to find the element is NOT ADVISED
                                            //    By PASSWORD-FIELD = By.XPATH("");
                                            //    By SIGNIN_BUTTON =  By.XPATH("");

	
	@FindBy(how = How.XPATH, using = "//input[@name=\"username\"]")WebElement userName;
	@FindBy(how = How.XPATH, using = "//input[@name=\"password\"]")WebElement passWord;
	@FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")WebElement singInButton;
	
	
	//4. Let's create methods to interact with the elements
	
	public void enterUserName(String username) {
		userName.sendKeys(username);
		
		//We are using the try/catch method to catch the error instead of using the throws, because the try/catch will be handled inside the methods; if we used the throws, then we would need to use throws again in the other classes like the LoginStepDefinition
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	public void enterPassWord(String password) {
		passWord.sendKeys(password);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	public void clickSignInButton() {
		singInButton.click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	public String getPageUrl() {
		
			return driver.getCurrentUrl();	
		}
			
	}
