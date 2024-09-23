package stepdef;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSteps {
	WebDriver driver;
	String actTitle;
	
	@Given("Open google application")
	public void open_google_application() {
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	 
		driver.get("https://www.google.com");
	}

	@When("Get the application title")
	public void get_the_application_title() {
	   actTitle=driver.getTitle();
	}

	@Then("Application should be Google")
	public void application_should_be_google() {
	   
	    Assert.assertTrue(actTitle.contains("Google"),"Title not Matched....Test fail!");
	   System.out.println("Title Matched Test Pass !");
	}

	
	@When("User enter valid keyword as {string} in the search box")
	public void user_enter_valid_keyword_as_in_the_search_box(String keyword) {
		driver.findElement(By.name("q")).sendKeys(keyword);
	    
	}

	@Then("User should get the appropriate search result")
	public void user_should_get_the_appropriate_search_result() {
	  List<WebElement> list=driver.findElements(By.xpath("(//ul[@class=\"G43f7e\"])[1]//li"));
	  System.out.println("Total no. of  list are: "+list.size());
	  
	  
	 for(WebElement i:list) {
		
		
	System.out.println("*"+i.getText());	  
	
	 }
	
}}
	
	
	

