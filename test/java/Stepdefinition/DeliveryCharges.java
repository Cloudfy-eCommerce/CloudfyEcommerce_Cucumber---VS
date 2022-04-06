package Stepdefinition;

import com.helper.CommonHelper;
import com.pages.DeliveryChargesPage;
import com.pages.objectRepository.AddToCartPageLocators;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class DeliveryCharges {
	
	DeliveryChargesPage deliverycharges = new DeliveryChargesPage();
	
	@And("^User selects Delivery Method (.+) from Delivery Method on Checkout page$")
	public void Select_Delivery_Type_from_Delivery_Method(String DeliveryMethod) {
		deliverycharges.SelectDeliveryMethod(DeliveryMethod);
	}
	
	@And("^Delivery Charge (.+) for Product Count (.+) of Delivery Method (.+) should be displayed on Checkout Page$")
	public void Delivery_Charge_for_Product_Count_of_Delivery_Method_should_be_displayed(String DeliveryCharge,String ProductCount, String DeliveryMethod) {
		Double Charge= 0.00;
		Double Count = 0.00;
		Charge = Double.parseDouble(DeliveryCharge);
		Count = Double.parseDouble(ProductCount);
		deliverycharges.DeliveryChargeOfDeliveryMethodforProductCountDisplayed(Charge, Count, DeliveryMethod);
	}
	
	@When("^User clicks on Add To Basket button (.+) times$")
	public void Click_on_Add_To_Basket_button_Product_Count_times(String ProductCount) {
		int Count = 0;
		Count = Integer.parseInt(ProductCount);
		for (int i=0; i < Count; i++)
		{
			CommonHelper.clickElement(AddToCartPageLocators.AddToBasketButton);
		}

	}
	
	@And("^User selects (.+) from Delivery Breakdown Level From dropdown in Business Manager$")
	public void User_Selects_Delivery_Breakdown_Level_from_dropdown(String DeliveryBreakdownLevel) {
		deliverycharges.SelectDeliveryBreakdownLevel(DeliveryBreakdownLevel);
	}
	
}
