package Stepdefinition;

import com.pages.DiscountPage;
import com.pages.AddToCartPage;

import cucumber.api.java.en.And;

public class Discount {
	
	DiscountPage discount = new DiscountPage();
	
	@And("^User enters Voucher Code (.+) in Voucher Code textbox on Checkout Page$")
	public void Enter_Voucher_Code_in_Voucher_Code_Textbox(String VoucherCode) {
		discount.EnterVoucherCode(VoucherCode);
	}
	
	@And("^Enter Valid Voucher Code message should be displayed on Checkout Page$")
	public void Enter_Valid_Voucher_Code_Message_Should_Be_Displayed() {
		discount.EnterValidVoucherCodeMessage();
	}
	
	@And("^Discount Price as per Discount percent (.+) should be displayed on Checkout Page$")
	public void Discount_Price_as_per_Discount_Percentage_should_be_displayed(String DiscountPercentage) {
		Double Discount= 0.00;
		Discount = Double.parseDouble(DiscountPercentage);
		discount.CalculateDiscount(Discount);
	}
	
	@And("^Discount Price as per Discount amount (.+) should be displayed on Checkout Page$")
	public void Discount_Price_as_per_Discount_Amount_should_be_displayed(String DiscountAmount) {
		Double Discount= 0.00;
		Discount = Double.parseDouble(DiscountAmount);
		discount.CalculateDiscountAmt(Discount);
	}
	
	@And("^User removes Product Name (.+) from basket on Checkout Page$")
	public void Remove_Product_Name_from_Basket(String Product) {
		AddToCartPage.RemoveFromBasket(Product);
	}
		
}
