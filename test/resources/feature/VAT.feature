#Author: priyanka.tripathi@williamscommerce.com
Feature: VAT Charges Functionality

  @V3dev4 @VAT 
  Scenario Outline: Verify Checkout functionality is working (with Country Based VAT calculated for Country setting)
    #If website is based in UK then all orders are always charged inc. VAT when delivered to the UK
    #Country Tax (for Billing Country)
    #Calculate VAT From = Country
    #VAT Method Type = Country Based
    #Delivery Charges = Basic
    Given User navigates to Business Manager URL
    And User clicks on Menu <Menu> in Business Manager
    And User clicks on SubMenu <SubMenu> under Menu <Menu> in Business Manager
    And User clicks on Tab <SiteSettingTab> in Business Manager
    And User clicks on Section <OrderSettingsSection> in Business Manager
    And User selects <CalculateVATFromOption> from Calculate VAT From dropdown in Business Manager
    And User selects <VATMethodType> from VAT Method Type dropdown in Business Manager
    And User selects <DeliveryType> from Delivery Type dropdown in Business Manager
    And User clicks on Submit button in Business Manager
    And User is signed in on website
    And User clicks on SubCategory <SubCategory> under Category <Category> in Product Menu
    And User clicks on Product Name <ProductName> in Product List
    When User clicks on Add To Basket button
    #Fetch Price of Product
    Then Price for Product Name <ProductName> should be added in basket on Home Page
    And User clicks on Proceed to Checkout button in Basket
    And User compares Country Name <CountryName> of Billing Address on Checkout Page
    #Calculate VAT for Billing Country
    And Vat Price as per VAT percent <CountryTaxPercent> should be displayed on Checkout Page
    #And User checks I Accept checkbox in Basket
    And User clicks on Place Order Now button in Basket
    And Order should be placed successfully

    Examples: 
      | SubCategory | Category                | ProductName                                        | CountryName    | CountryTaxPercent | Menu       | SubMenu       | SiteSettingTab         | OrderSettingsSection | CalculateVATFromOption | VATMethodType | DeliveryType |
      | Mobiles     | Mobiles and Accessories | OPPO A74 5G (Fantastic Purple, 6GB RAM, 128GB Stor | United Kingdom |                10 | Site Setup | Site Settings | Transactional Settings | Order Settings       | Country                | Country Based | Basic        |

  @V3dev4 @VAT 
  Scenario Outline: Verify Checkout functionality is working (with Country Based VAT calculated for Product setting)
    #If website is based in UK then all orders are always charged inc. VAT when delivered to the UK
    #Product VAT (for each product added in Cart)
    #Calculate VAT From = Product
    #VAT Method Type = Country Based
    #Delivery Charges = Basic
    Given User navigates to Business Manager URL
    And User clicks on Menu <Menu> in Business Manager
    And User clicks on SubMenu <SubMenu> under Menu <Menu> in Business Manager
    And User clicks on Tab <SiteSettingTab> in Business Manager
    And User clicks on Section <OrderSettingsSection> in Business Manager
    And User selects <CalculateVATFromOption> from Calculate VAT From dropdown in Business Manager
    And User selects <VATMethodType> from VAT Method Type dropdown in Business Manager
    And User selects <DeliveryType> from Delivery Type dropdown in Business Manager
    And User clicks on Submit button in Business Manager
    And User is signed in on website
    And User clicks on SubCategory <SubCategory> under Category <Category> in Product Menu
    And User clicks on Product Name <ProductName> in Product List
    When User clicks on Add To Basket button
    #Fetch Price of Product
    Then Price for Product Name <ProductName> should be added in basket on Home Page
    And User clicks on Proceed to Checkout button in Basket
    #Calculate VAT for Product Added to Cart
    And Vat Price as per VAT percent <ProductVATPercent> should be displayed on Checkout Page
    #And User checks I Accept checkbox in Basket
    And User clicks on Place Order Now button in Basket
    And Order should be placed successfully

    Examples: 
      | SubCategory | Category                | ProductName                                        | ProductVATPercent | Menu       | SubMenu       | SiteSettingTab         | OrderSettingsSection | CalculateVATFromOption | VATMethodType | DeliveryType |
      | Mobiles     | Mobiles and Accessories | OPPO A74 5G (Fantastic Purple, 6GB RAM, 128GB Stor |                15 | Site Setup | Site Settings | Transactional Settings | Order Settings       | Product                | Country Based | Basic        |

  @V3dev4 @VAT 
  Scenario Outline: Verify Checkout functionality is working (with Region Based VAT calculated for Product Tax Class setting)
    #If website is based in UK then all orders are always charged inc. VAT when delivered to the UK
    #Product Tax Class (for each product added in Cart)
    #Calculate VAT From = Product/Country
    #VAT Method Type = Region Based
    #Delivery Charges = Basic
    Given User navigates to Business Manager URL
    And User clicks on Menu <Menu> in Business Manager
    And User clicks on SubMenu <SubMenu> under Menu <Menu> in Business Manager
    And User clicks on Tab <SiteSettingTab> in Business Manager
    And User clicks on Section <OrderSettingsSection> in Business Manager
    And User selects <CalculateVATFromOption> from Calculate VAT From dropdown in Business Manager
    And User selects <VATMethodType> from VAT Method Type dropdown in Business Manager
    And User selects <DeliveryType> from Delivery Type dropdown in Business Manager
    And User clicks on Submit button in Business Manager
    And User is signed in on website
    And User clicks on SubCategory <SubCategory> under Category <Category> in Product Menu
    #And User search Product Name <ProductName> in auto suggest Search box on Home page
    And User clicks on Product Name <ProductName> in Product List
    #And User waits for Product Name to be displayed
    When User clicks on Add To Basket button
    #Fetch Price of Product
    Then Price for Product Name <ProductName> should be added in basket on Home Page
    And User clicks on Proceed to Checkout button in Basket
    #Calculate VAT for Product Added to Cart
    And Vat Price as per VAT percent <ProductTaxClassPercent> should be displayed on Checkout Page
    #And User checks I Accept checkbox in Basket
    And User clicks on Place Order Now button in Basket
    And Order should be placed successfully

    Examples: 
      | SubCategory | Category                | ProductName                                        | ProductTaxClassPercent | Menu       | SubMenu       | SiteSettingTab         | OrderSettingsSection | CalculateVATFromOption | VATMethodType | DeliveryType |
      | Mobiles     | Mobiles and Accessories | OPPO A74 5G (Fantastic Purple, 6GB RAM, 128GB Stor |                     20 | Site Setup | Site Settings | Transactional Settings | Order Settings       | Product                | Region Based  | Basic        |

  #-----------------------------------------------VAT WITH DISCOUNT----------------------------------------------------------
  @V3dev4 @VAT @Discount 
  Scenario Outline: Verify Checkout functionality is working (with VAT and Discount)
    #If website is based in UK then all orders are always charged inc. VAT when delivered to the UK
    #Country Tax (for Billing Country)
    #Calculate VAT From = Country
    #VAT Method Type = Country Based
    #Delivery Charges = Basic
    #Business Manager
    Given User navigates to Business Manager URL
    And User clicks on Menu <Menu> in Business Manager
    And User clicks on SubMenu <SubMenu> under Menu <Menu> in Business Manager
    And User clicks on Tab <SiteSettingTab> in Business Manager
    And User clicks on Section <OrderSettingsSection> in Business Manager
    And User selects <CalculateVATFromOption> from Calculate VAT From dropdown in Business Manager
    And User selects <VATMethodType> from VAT Method Type dropdown in Business Manager
    And User selects <DeliveryType> from Delivery Type dropdown in Business Manager
    And User clicks on Submit button in Business Manager
    And User is signed in on website
    And User clicks on SubCategory <SubCategory> under Category <Category> in Product Menu
    And User clicks on Product Name <ProductName> in Product List
    When User clicks on Add To Basket button
    #Fetch Price of Product
    Then Price for Product Name <ProductName> should be added in basket on Home Page
    And User clicks on Proceed to Checkout button in Basket
    #Discount
    And User enters Voucher Code <VoucherCode> in Voucher Code textbox on Checkout Page
    #Calculate Discount for Product Added to Cart
    And Discount Price as per Discount percent <DiscountPercentage> should be displayed on Checkout Page
    #VAT
    And User compares Country Name <CountryName> of Billing Address on Checkout Page
    #Calculate VAT for Billing Country
    And Vat Price as per VAT percent <CountryTaxPercent> should be displayed on Checkout Page
    #And User checks I Accept checkbox in Basket
    And User clicks on Place Order Now button in Basket
    And Order should be placed successfully

    Examples: 
      | SubCategory | Category                | ProductName                                        | CountryName    | CountryTaxPercent | VoucherCode | DiscountPercentage | Menu       | SubMenu       | SiteSettingTab         | OrderSettingsSection | CalculateVATFromOption | VATMethodType | DeliveryType |
      | Mobiles     | Mobiles and Accessories | OPPO A74 5G (Fantastic Purple, 6GB RAM, 128GB Stor | United Kingdom |                10 | 10pc        |                 10 | Site Setup | Site Settings | Transactional Settings | Order Settings       | Country                | Country Based | Basic        |
