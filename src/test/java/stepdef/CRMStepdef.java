package stepdef;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;

public class CRMStepdef {

	WebDriver driver;
@Given("open CRM application")
public void open_crm_application() {
    driver=new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://automationplayground.com/crm/");

}

@When("user click on sisgn link")
public void user_click_on_sisgn_link() {
    WebElement ele=driver.findElement(By.linkText("Sign In"));
    if(ele.isDisplayed() && ele.isEnabled()) {
    	ele.click();
    }
}

@Then("use should naviagate to login page")
public void use_should_naviagate_to_login_page() {
    Assert.assertTrue(driver.getCurrentUrl().contains("login"),"Navigation Failed...");
    System.out.println("User navigated to login page");
}

@When("user navigated to login page")
public void user_navigated_to_login_page() {
    driver.findElement(By.linkText("Sign In")).click();
}

@When("user enters valid email {string} and password {string} and click on submit button")
public void user_enters_valid_email_and_password_and_click_on_submit_button(String email, String pwd) {
	driver.findElement(By.id("email-id")).sendKeys(email);
	driver.findElement(By.id("password")).sendKeys(pwd);
	driver.findElement(By.id("submit-id")).click();
}

@Then("user should able to login and  navigate to customers page")
public void user_should_able_to_login_and_navigate_to_customers_page() {
	Assert.assertTrue(driver.getCurrentUrl().contains("customers"),"Login Failed");
	System.out.println("Login Successfull !");
}


}
