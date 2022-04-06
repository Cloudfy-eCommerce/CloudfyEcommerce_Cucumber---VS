package Stepdefinition;

import com.pages.LoyaltyPointsPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class LoyaltyPoints {
	
	LoyaltyPointsPage LoyaltyPointsPage = new LoyaltyPointsPage();
	
	@Then("^Loyalty Points Balance should be displayed on top of Checkout Page$")
	public void Loyalty_Points_Balance_should_be_displayed_on_top_of_Checkout_Page() {
		LoyaltyPointsPage.LoyaltyPointsBalance();
	}
	
    @And("^User compares Calculated Award Points as per (.+) (.+) (.+) (.+) with Total Loyalty Award Points on Checkout Page$")
    public void Compare_Calculated_Award_Points(String ProductPrice, String Spend, String Award, String RateFactor) {
    	Double ProdPrice = 0.00;
    	Double Spend1 = 0.00;
    	Double Award1 = 0.00;
    	Double Rfactor = 0.00;
    	ProdPrice = Double.parseDouble(ProductPrice);
    	Spend1 = Double.parseDouble(Spend);
    	Award1 = Double.parseDouble(Award);
    	Rfactor = Double.parseDouble(RateFactor);
    	LoyaltyPointsPage.CompareTotalLoyaltyAwardPoints(ProdPrice, Spend1, Award1, Rfactor);
    }
    
    @And("^Loyalty Points Balance should be updated on top of Checkout Page$")
    public void Updated_Loyalty_Points_Balance() {
    	
    }
    
    @And("^User selects Loyalty Payment Method for Payment on Checkout Page$")
    public void Select_Loyalty_Payment_Method_for_Payment_on_Checkout_Page() {
    	LoyaltyPointsPage.SelectPaymentMethod();
    }
    
    @And("^User navigates to Business Manager URL$")
    public void Navigate_to_Business_Manager() {
    	LoyaltyPointsPage.OpenBusinessManager();
    }
    
    @And("^User clicks on Menu (.+) in Business Manager$")
    public void Click_on_Menu_in_Business_Manager(String Menu) {
    	LoyaltyPointsPage.ClickBusinessManagerMenu(Menu);
    }
    
    @And("^User clicks on SubMenu (.+) under Menu (.+) in Business Manager$")
    public void Click_on_Orders_SubMenu(String SubMenu, String Menu) {
    	LoyaltyPointsPage.ClickBusinessManagerSubMenu(SubMenu);
    }
    
    @And("^User checks Order entry checkbox on Manage Orders list Page in Business Manager$")
    public void Check_Order_Entry_on_Manager_Orders_List() {
    	LoyaltyPointsPage.CheckOrderEntry();
    }
    
    @And("^User selects Complete from Order Status dropdown on Manage Orders list Page in Business Manager$")
    public void Select_Complete_Order_Status_Dropdown() {
    	LoyaltyPointsPage.SelectOrderStatus();
    }
    
    @And("^User clicks Update Button on Manage Orders list Page in Business Manager$")
    public void Click_Update_Button_on_Manage_Orders_List_Page() {
    	
    }
    
    @And("^Change Order Status confirmation alert should be displayed on Manage Orders list Page in Business Manager$")
    public void Change_Order_Status_Confirmation_alert_displayed() {
    	
    }
    
    @And("^User clicks OK on Order Status confirmation alert on Manage Orders list Page in Business Manager$")
    public void Accept_Order_Status_Confirmation_Alert() {
    	
    }
    
    @And("^Success message should be displayed on Manage Orders list Page in Business Manager$")
    public void Success_Message_on_Manage_Orders_List_Page_displayed() {
    	
    }
    
    @And("^User returns to website$")
    public void Return_to_Website() {
    	
    }
    
    @And("^Calculated Award Points should be added in Loyalty Points Balance on Checkout Page$")
    public void Verify_Calculated_Award_Points_are_added_in_Loyalty_Points_Balance() {
    	
    }
    
    @And("^Calculated Award Points should be subtracted from Loyalty Points Balance on Checkout Page$")
    public void Verify_Calculated_Award_Points_are_subtracted_from_Loyalty_Points_Balance() {
    	
    }
    
}
