package Stepdefinition;

import com.pages.SignInPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Sign_in {
		
	SignInPage loginPage= new SignInPage();
	
	@Given("^User clicks on Sign in text on home page$")
	public void user_clicks_on_Sign_in_text_on_home_page() {
		SignInPage.AcceptCookies();
	    SignInPage.clickSignInLink();
	}
	
	@When("^User enters username (.+) on Sign in page$")
	public void user_enters_username_on_Sign_in_page(String UserName) {
		SignInPage.enterUserName(UserName);
	}

	@And("^User enters password (.+) on Sign in page$")
	public void user_enters_password_on_Sign_in_page(String Password) {
		SignInPage.enterPwd(Password);
	}	

	@And("^User clicks on Sign in button on Sign in page$")
	public void user_clicks_on_sign_in_button() {
		SignInPage.clickSignInButton();
	}
	
	@Then("^User should be signed in successfully$")
    public void user_should_be_signed_in_successfully() {
	    SignInPage.MyAccount();
	}
	
	@Then("^User should not be signed in successfully$")
    public void user_should_not_be_signed_in_successfully() {
	    SignInPage.NotMyAccount();
	}
}
