#Author: priyanka.tripathi@williamscommerce.com
Feature: Add To Cart Functionality

  @V3dev4
  Scenario Outline: Verify Add To Cart functionality with (in stock) product through search
    Given User is signed in on website
    When User search Product Name <ProductName> in auto suggest Search box on Home page
    And User clicks on Add To Basket button
    #Fetch Price of Product
    Then Price for Product Name <ProductName> should be added in basket on Home Page
    And User clicks on Proceed to Checkout button in Basket
    And User checks I Accept checkbox in Basket
    And User clicks on Place Order Now button in Basket
    And Order should be placed successfully

    Examples: 
      | ProductName |
      | SKU111      |

  @V3dev4
  Scenario Outline: Verify Add To Cart functionality with (in stock) product through Category Menu (without VAT and Delivery Charges)
    Given User is signed in on website
    When User clicks on SubCategory <SubCategory> under Category <Category> in Product Menu
    And User clicks on Product Name <ProductName> in Product List
    And User clicks on Add To Basket button
    #Fetch Price of Product
    Then Price for Product Name <ProductName> should be added in basket on Home Page
    And User clicks on Proceed to Checkout button in Basket
    And User checks I Accept checkbox in Basket
    And User clicks on Place Order Now button in Basket
    And Order should be placed successfully

    Examples: 
      | SubCategory | Category                | ProductName                                        |
      | Mobiles     | Mobiles and Accessories | OPPO A74 5G (Fantastic Purple, 6GB RAM, 128GB Stor |
