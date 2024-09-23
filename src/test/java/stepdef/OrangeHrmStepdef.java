package stepdef;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;

public class OrangeHrmStepdef {
	
	WebDriver driver;
	
	@Given("Open OrangeHRM application with {string}")
	public void open_orange_hrm_application_with(String url) {
	    driver=new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
	}


	@When("User enters valid userid {string} and password {string} and click on login button")
	public void user_enters_valid_userid_and_password_and_click_on_login_button(String un, String pwd) {
	    
		driver.findElement(By.name("username")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).sendKeys(Keys.SPACE);
	}

	@Then("user should navigate to Dashboard page")
	public void user_should_navigate_to_dashboard_page() {
	    
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"),"Login Failed...");
		System.out.println("Login Successfull");
	}

	@Given("user already logined with valid username {string} and password {string}")
	public void user_already_logined_with_valid_username_and_password(String un, String pwd) {
	   
		driver.findElement(By.name("username")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).sendKeys(Keys.SPACE);
	}

	@When("user click on profile logo and click on logout")
	public void user_click_on_profile_logo_and_click_on_logout() {
	    
		driver.findElement(By.xpath("//div//ul//li//i")).click();
		driver.findElement(By.linkText("Logout")).click();
	}

	@Then("user should be able to checkout and navigate to login page")
	public void user_should_be_able_to_checkout_and_navigate_to_login_page() {
	    Assert.assertTrue(driver.getCurrentUrl().contains("login"),"Logout Failed....");
	    System.out.println("Logout Successfull !");
	}



}
