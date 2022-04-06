package Stepdefinition;

import com.pages.VATPage;

import cucumber.api.java.en.And;

public class VAT {
	
	VATPage vatPage = new VATPage();
	
	@And("^User compares Country Name (.+) of Billing Address on Checkout Page$")
	public void user_compares_country_name_of_Billing_address(String Country) {
		vatPage.CompareBillingCountry(Country);
	}
	
	@And("^Vat Price as per VAT percent (.+) should be displayed on Checkout Page$")
	public void Vat_Price_for_Product_Name_should_be_displayed(String Percentage) {
		//String[] arr = CommonHelper.StringValueSeparator(Percentage);
		Double P= 0.00;
		//for (int i=0; i < arr.length; i++)
		//{
			//P = Double.parseDouble(arr[i]);
		//}
		P = Double.parseDouble(Percentage);
		vatPage.VATPriceforProduct(P);
	}
	
	@And("^User clicks on Tab (.+) in Business Manager$")
    public void Click_on_Tab_in_Business_Manager(String SiteSettingTab) {
    	vatPage.ClickSiteSettingTab(SiteSettingTab);
    }
	
	@And ("^User clicks on Section (.+) in Business Manager$")
	public void Click_on_Section_in_Business_Manager(String TransactionalSettingSection) {
		vatPage.ClickTransactionalSettingSection(TransactionalSettingSection);
	}
	
	@And ("^User selects (.+) from Calculate VAT From dropdown in Business Manager$")
	public void Select_Calculate_VAT_From_Option(String CalculateVATFrom) {
		vatPage.SelectCalculateVATFromOption(CalculateVATFrom);
	}
	
	@And ("^User selects (.+) from VAT Method Type dropdown in Business Manager$")
	public void Select_VAT_Method_Type_Option(String VATMethodType) {
		vatPage.SelectVATMethodTypeOption(VATMethodType);
	}
	
	@And ("^User selects (.+) from Delivery Type dropdown in Business Manager$")
	public void Select_Delivery_Type_Option(String DeliveryType) {
		vatPage.SelectDeliveryTypeOption(DeliveryType);
	}
	
	@And ("^User clicks on Submit button in Business Manager$")
	public void Click_on_Submit_button_in_Business_Manager() {
		vatPage.ClickSubmitButton();
	}
	
}

