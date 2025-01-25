package steps;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.TestBase;

public class LoginStepsDefinition extends TestBase{
	
	LoginPage loginPage;
	
	
	//Now, How can we make sure that if let's say we are entering the data starting from password instead of username it will still work (we will switch up the steps in the feature file)
	//Let's initialize the driver, and the pageFactory
	
	@Before
	public void initDriverandPageFactory() {
		
		initDriver();
		loginPage = PageFactory.initElements(driver, LoginPage.class); //here we are initializing the pageFactory (POM), that calls the driver, and initialize the LoginPage class
		
	}

	
	@Given ("^User is on the OrangeHRM login page$")
	public void user_is_on_the_OrangeHRM_login_page (){
// 1. In order to run this method, we need to call the initDriver method here. Remember that it is a static method, and we want to call it here (non-static method).
//	         which means, calling the method would generally work because the method is static (TestBase.initDriver()) but doing it that way would mean, we would always call that method everywhere we want to use it; so, instead we will extend the whole class
			
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@When("User enters username as {string}")
	public void user_enters_username_as(String username) {
		
// 2. In order to be able to call a non-static method here (the username element), we have to define the object;
//    Note: We can't extend more than one class; so "extends LoginPage" wouldn't work. But you can implement multiple interfaces.
//          and we can't just call it using its class (LoginPage.enterUserName) because it is non-static, so we have to create an object (LoginPage loginPage) 
//          and since we are using Page Object Model, we must define the PageFactory using the method we created;
		

		
		loginPage.enterUserName(username);
		
	 
	}
	@When("User enters password as {string}")
	public void user_enters_password_as(String password) {
		
		loginPage.enterPassWord(password);
		
		if(password.equalsIgnoreCase("admin123")) {
			
			System.out.println("Noice!!!!!!!!You have entered the right password!");
			
		}else {
			
			System.out.println("Oooops!!!!!!!You have entered the Wrong password");
			
		}
	  	}
	
	@And("User clicks on the submit button")
	public void user_clicks_on_the_submit_button() {
		
		loginPage.clickSignInButton();
	    
	}
	
	@Then("User should not land on the Dashboard page")
	public void user_should_not_land_on_the_dashboard_page() {
		
		
		
		Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login", loginPage.getPageUrl());
	    takeScreenshot(driver);

	}
	
	@Then("User should land on the Dashboard page")
	public void user_should_land_on_the_dashboard_page() {
		
		Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index", loginPage.getPageUrl()); //Remember here not insert the Assert.assertEquals from "junit.framework.Assert" because it is deprecated; instead we use the "org.junit.Assert"
	    takeScreenshot(driver);
	}
	
	
	//Now let's close the browser
	
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
		
		}

}
