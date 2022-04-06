#Author: priyanka.tripathi@williamscommerce.com
Feature: Discount Functionality

  @V3dev4 @Discount @ProductVoucher @Run1
  Scenario Outline: Verify Checkout functionality is working (with Product Voucher in percentage)
    Given User is signed in on website
    And User clicks on SubCategory <SubCategory> under Category <Category> in Product Menu
    #And User search Product Name <ProductName> in auto suggest Search box on Home page
    And User clicks on Product Name <ProductName> in Product List
    #And User waits for Product Name to be displayed
    When User clicks on Add To Basket button
    #Fetch Price of Product
    Then Price for Product Name <ProductName> should be added in basket on Home Page
    And User clicks on Proceed to Checkout button in Basket
    And User enters Voucher Code <VoucherCode> in Voucher Code textbox on Checkout Page
    #Calculate Discount for Product Added to Cart
    And Discount Price as per Discount percent <DiscountPercentage> should be displayed on Checkout Page
    #And User checks I Accept checkbox in Basket
    And User clicks on Place Order Now button in Basket
    And Order should be placed successfully

    Examples: 
      | SubCategory | Category                | ProductName                                        | VoucherCode | DiscountPercentage |
      | Mobiles     | Mobiles and Accessories | OPPO A74 5G (Fantastic Purple, 6GB RAM, 128GB Stor | 10pc        |                 10 |

  @V3dev4 @Discount @ProductVoucher
  Scenario Outline: Verify Checkout functionality is working (with Product Voucher in amount)
    Given User is signed in on website
    And User clicks on SubCategory <SubCategory> under Category <Category> in Product Menu
    #And User search Product Name <ProductName> in auto suggest Search box on Home page
    And User clicks on Product Name <ProductName> in Product List
    #And User waits for Product Name to be displayed
    When User clicks on Add To Basket button
    #Fetch Price of Product
    Then Price for Product Name <ProductName> should be added in basket on Home Page
    And User clicks on Proceed to Checkout button in Basket
    And User enters Voucher Code <VoucherCode> in Voucher Code textbox on Checkout Page
    #Calculate Discount for Product Added to Cart
    And Discount Price as per Discount amount <DiscountAmount> should be displayed on Checkout Page
    #And User checks I Accept checkbox in Basket
    And User clicks on Place Order Now button in Basket
    And Order should be placed successfully

    Examples: 
      | SubCategory | Category                | ProductName                                        | VoucherCode | DiscountAmount |
      | Mobiles     | Mobiles and Accessories | OPPO A74 5G (Fantastic Purple, 6GB RAM, 128GB Stor | FNPSD10     |             50 |

  @V3dev4 @Discount @CategoryVoucher
  Scenario Outline: Verify Checkout functionality is working (with Category Voucher in percentage)
    Given User is signed in on website
    And User clicks on SubCategory <SubCategory> under Category <Category> in Product Menu
    #And User search Product Name <ProductName> in auto suggest Search box on Home page
    And User clicks on Product Name <ProductName> in Product List
    #And User waits for Product Name to be displayed
    When User clicks on Add To Basket button
    #Fetch Price of Product
    Then Price for Product Name <ProductName> should be added in basket on Home Page
    And User clicks on Proceed to Checkout button in Basket
    And User enters Voucher Code <VoucherCode> in Voucher Code textbox on Checkout Page
    #Calculate Discount for Product Added to Cart
    And Discount Price as per Discount percent <DiscountPercentage> should be displayed on Checkout Page
    #And User checks I Accept checkbox in Basket
    And User clicks on Place Order Now button in Basket
    And Order should be placed successfully

    Examples: 
      | SubCategory | Category                | ProductName                                        | VoucherCode | DiscountPercentage |
      | Mobiles     | Mobiles and Accessories | OPPO A74 5G (Fantastic Purple, 6GB RAM, 128GB Stor | 10pc        |                 10 |

  @V3dev4 @Discount @CategoryVoucher
  Scenario Outline: Verify Checkout functionality is working (with Category Voucher in amount)
    Given User is signed in on website
    And User clicks on SubCategory <SubCategory> under Category <Category> in Product Menu
    #And User search Product Name <ProductName> in auto suggest Search box on Home page
    And User clicks on Product Name <ProductName> in Product List
    #And User waits for Product Name to be displayed
    When User clicks on Add To Basket button
    #Fetch Price of Product
    Then Price for Product Name <ProductName> should be added in basket on Home Page
    And User clicks on Proceed to Checkout button in Basket
    And User enters Voucher Code <VoucherCode> in Voucher Code textbox on Checkout Page
    #Calculate Discount for Product Added to Cart
    And Discount Price as per Discount amount <DiscountAmount> should be displayed on Checkout Page
    #And User checks I Accept checkbox in Basket
    And User clicks on Place Order Now button in Basket
    And Order should be placed successfully

    Examples: 
      | SubCategory | Category                | ProductName                                        | VoucherCode | DiscountAmount |
      | Mobiles     | Mobiles and Accessories | OPPO A74 5G (Fantastic Purple, 6GB RAM, 128GB Stor | FNPSD10     |             50 |

  # ----------------------------------------Negative Scenarios-------------------------------------------------------------------
  @V3dev4 @Discount
  Scenario Outline: Verify invalid Discount Voucher Code check is working on Checkout
    Given User is signed in on website
    And User clicks on SubCategory <SubCategory> under Category <Category> in Product Menu
    #And User search Product Name <ProductName> in auto suggest Search box on Home page
    And User clicks on Product Name <ProductName> in Product List
    #And User waits for Product Name to be displayed
    When User clicks on Add To Basket button
    #Fetch Price of Product
    Then Price for Product Name <ProductName> should be added in basket on Home Page
    And User clicks on Proceed to Checkout button in Basket
    And User enters Voucher Code <InvalidVoucherCode> in Voucher Code textbox on Checkout Page
    And Enter Valid Voucher Code message should be displayed on Checkout Page
    #PLEASE ENTER A VALID VOUCHER CODE.
    And User removes Product Name <ProductName> from basket on Checkout Page

    Examples: 
      | SubCategory | Category                | ProductName                                        | InvalidVoucherCode |
      | Mobiles     | Mobiles and Accessories | OPPO A74 5G (Fantastic Purple, 6GB RAM, 128GB Stor | Invalid            |
      | Mobiles     | Mobiles and Accessories | OPPO A74 5G (Fantastic Purple, 6GB RAM, 128GB Stor | EXPIRED            |

  @V3dev4 @Discount
  Scenario Outline: Verify Discount Voucher Code check is working on Checkout (Discount on Basket Sub Total)
    Given User is signed in on website
    And User clicks on SubCategory <SubCategory> under Category <Category> in Product Menu
    #And User search Product Name <ProductName> in auto suggest Search box on Home page
    And User clicks on Product Name <ProductName> in Product List
    #And User waits for Product Name to be displayed
    When User clicks on Add To Basket button
    #Fetch Price of Product
    Then Price for Product Name <ProductName> should be added in basket on Home Page
    And User clicks on Proceed to Checkout button in Basket
    And User enters Voucher Code <SubTotalVoucherCode> in Voucher Code textbox on Checkout Page
    And Enter Valid Voucher Code message should be displayed on Checkout Page
    #PLEASE ENTER A VALID VOUCHER CODE.
    And User removes Product Name <ProductName> from basket on Checkout Page

    Examples: 
      | SubCategory | Category                | ProductName                                        | SubTotalVoucherCode |
      | Mobiles     | Mobiles and Accessories | Mi 11X Pro 5G (Lunar White, 8GB RAM, 128GB Storage | STV10               |
