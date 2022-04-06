#Author: priyanka.tripathi@williamscommerce.com
Feature: Loyalty Points Functionality

  #All Customers-Product Name-Rate Factor
  #All Customers-Product Group-Rate Factor
  #Customer Group-Product Name-Rate Factor
  #Customer Group-Product Group-Rate Factor
  #Customer Number-Product Name-Rate Factor
  #Customer Number-Product Group-Rate Factor
  @V3dev @LoyaltyPoints
  Scenario Outline: Verify award loyalty Points functionality is working on Checkout page (All Customers-Product Name-Rate Factor)
    Given User is signed in on website
    And User clicks on SubCategory <SubCategory> under Category <Category> in Product Menu
    #And User search Product Name <ProductName> in auto suggest Search box on Home page
    And User clicks on Product Name <ProductName> in Product List
    #And User waits for Product Name to be displayed
    When User clicks on Add To Basket button
    #Fetch Price of Product
    And Price for Product Name <ProductName> should be added in basket on Home Page
    And User clicks on Proceed to Checkout button in Basket
    Then Loyalty Points Balance should be displayed on top of Checkout Page
    And User compares Calculated Award Points as per <ProductPrice> <Spend> <Award> <RateFactor> with Total Loyalty Award Points on Checkout Page
    And User checks I Accept checkbox in Basket
    And User clicks on Place Order Now button in Basket
    And Order should be placed successfully
    #Business Manager
    And User navigates to Business Manager URL
    And User clicks on Menu <Menu> in Business Manager
    And User clicks on SubMenu <SubMenu> under Menu <Menu> in Business Manager
    And User checks Order entry checkbox on Manage Orders list Page in Business Manager
    And User selects Complete from Order Status dropdown on Manage Orders list Page in Business Manager
    And User clicks Update Button on Manage Orders list Page in Business Manager
    And Change Order Status confirmation alert should be displayed on Manage Orders list Page in Business Manager
    #Are you sure to change order status for total 5 orders?
    And User clicks OK on Order Status confirmation alert on Manage Orders list Page in Business Manager
    And Success message should be displayed on Manage Orders list Page in Business Manager
    #Order status has been changed to "Complete" for 5 orders.
    And User returns to website
    And User clicks on SubCategory <SubCategory> under Category <Category> in Product Menu
    And User clicks on Product Name <ProductName> in Product List
    And User clicks on Add To Basket button
    #Fetch Price of Product
    And Price for Product Name <ProductName> should be added in basket on Home Page
    And User clicks on Proceed to Checkout button in Basket
    And Loyalty Points Balance should be displayed on top of Checkout Page
    And Calculated Award Points should be added in Loyalty Points Balance on Checkout Page

    #All Customers	 	ProductSKU	SKU113	Each	2	20/10/2021	31/01/2022
    Examples: 
      | SubCategory | Category                | ProductName        | ProductPrice | Spend | Award | RateFactor | Menu                    | SubMenu |
      | Laptops     | Laptops and Accessories | Dell Inspiron 3502 |         1000 |   100 |     1 |          2 | Transactional Documents | Orders  |

  @V3dev @LoyaltyPoints
  Scenario Outline: Verify award loyalty Points functionality is working on Checkout page (All Customers-Product Group-Rate Factor)
    Given User is signed in on website
    And User clicks on SubCategory <SubCategory> under Category <Category> in Product Menu
    #And User search Product Name <ProductName> in auto suggest Search box on Home page
    And User clicks on Product Name <ProductName> in Product List
    #And User waits for Product Name to be displayed
    When User clicks on Add To Basket button
    #Fetch Price of Product
    And Price for Product Name <ProductName> should be added in basket on Home Page
    And User clicks on Proceed to Checkout button in Basket
    Then Loyalty Points Balance should be displayed on top of Checkout Page
    And User compares Calculated Award Points as per <ProductPrice> <Spend> <Award> <RateFactor> with Total Loyalty Award Points on Checkout Page
    And User checks I Accept checkbox in Basket
    And User clicks on Place Order Now button in Basket
    And Order should be placed successfully
    #Business Manager
    And User navigates to Business Manager URL
    And User clicks on Menu <Menu> in Business Manager
    And User clicks on SubMenu <SubMenu> under Menu <Menu> in Business Manager
    And User checks Order entry checkbox on Manage Orders list Page in Business Manager
    And User selects Complete from Order Status dropdown on Manage Orders list Page in Business Manager
    And User clicks Update Button on Manage Orders list Page in Business Manager
    And Change Order Status confirmation alert should be displayed on Manage Orders list Page in Business Manager
    #Are you sure to change order status for total 5 orders?
    And User clicks OK on Order Status confirmation alert on Manage Orders list Page in Business Manager
    And Success message should be displayed on Manage Orders list Page in Business Manager
    #Order status has been changed to "Complete" for 5 orders.
    And User returns to website
    And User clicks on SubCategory <SubCategory> under Category <Category> in Product Menu
    And User clicks on Product Name <ProductName> in Product List
    And User clicks on Add To Basket button
    #Fetch Price of Product
    And Price for Product Name <ProductName> should be added in basket on Home Page
    And User clicks on Proceed to Checkout button in Basket
    And Loyalty Points Balance should be displayed on top of Checkout Page
    And Calculated Award Points should be added in Loyalty Points Balance on Checkout Page

    #Refresh Loyalty points from BM
    #Lenovo Tab M10 FHD Plus Tablet belongs to PTProdGroup (Product Group) with Rate Factor=4
    #All Customers	 	ProductGroup	PTProdGroup	Each	4	09/11/2021	30/11/2023
    Examples: 
      | SubCategory | Category                | ProductName                    | ProductPrice | Spend | Award | RateFactor |
      | Tablets     | Laptops and Accessories | Lenovo Tab M10 FHD Plus Tablet |          200 |   100 |     1 |          4 |

  @V3dev @LoyaltyPoints
  Scenario Outline: Verify award loyalty Points functionality is working on Checkout page (Customer Group-Product Name-Rate Factor)
    Given User is signed in on website
    And User clicks on SubCategory <SubCategory> under Category <Category> in Product Menu
    #And User search Product Name <ProductName> in auto suggest Search box on Home page
    And User clicks on Product Name <ProductName> in Product List
    #And User waits for Product Name to be displayed
    When User clicks on Add To Basket button
    #Fetch Price of Product
    And Price for Product Name <ProductName> should be added in basket on Home Page
    And User clicks on Proceed to Checkout button in Basket
    Then Loyalty Points Balance should be displayed on top of Checkout Page
    And User compares Calculated Award Points as per <ProductPrice> <Spend> <Award> <RateFactor> with Total Loyalty Award Points on Checkout Page
    And User checks I Accept checkbox in Basket
    And User clicks on Place Order Now button in Basket
    And Order should be placed successfully
    #Business Manager
    And User navigates to Business Manager URL
    And User clicks on Menu <Menu> in Business Manager
    And User clicks on SubMenu <SubMenu> under Menu <Menu> in Business Manager
    And User checks Order entry checkbox on Manage Orders list Page in Business Manager
    And User selects Complete from Order Status dropdown on Manage Orders list Page in Business Manager
    And User clicks Update Button on Manage Orders list Page in Business Manager
    And Change Order Status confirmation alert should be displayed on Manage Orders list Page in Business Manager
    #Are you sure to change order status for total 5 orders?
    And User clicks OK on Order Status confirmation alert on Manage Orders list Page in Business Manager
    And Success message should be displayed on Manage Orders list Page in Business Manager
    #Order status has been changed to "Complete" for 5 orders.
    And User returns to website
    And User clicks on SubCategory <SubCategory> under Category <Category> in Product Menu
    And User clicks on Product Name <ProductName> in Product List
    And User clicks on Add To Basket button
    #Fetch Price of Product
    And Price for Product Name <ProductName> should be added in basket on Home Page
    And User clicks on Proceed to Checkout button in Basket
    And Loyalty Points Balance should be displayed on top of Checkout Page
    And Calculated Award Points should be added in Loyalty Points Balance on Checkout Page

    #Refresh Loyalty points from BM
    #User= Priyanka Tripathi belongs to 	PTCustGroup1 (Customer Group) with Rate Factor=6
    #CustomerGroup	PTCustGroup1	ProductSKU	SKU115		Each	6	08/11/2021	30/11/2023
    Examples: 
      | SubCategory | Category                | ProductName                                        | ProductPrice | Spend | Award | RateFactor |
      | Mobiles     | Mobiles and Accessories | Mi 11X Pro 5G (Lunar White, 8GB RAM, 128GB Storage |          250 |   100 |     1 |          6 |

  @V3dev @LoyaltyPoints
  Scenario Outline: Verify award loyalty Points functionality is working on Checkout page (Customer Group-Product Group-Rate Factor)
    Given User is signed in on website
    And User clicks on SubCategory <SubCategory> under Category <Category> in Product Menu
    #And User search Product Name <ProductName> in auto suggest Search box on Home page
    And User clicks on Product Name <ProductName> in Product List
    #And User waits for Product Name to be displayed
    When User clicks on Add To Basket button
    #Fetch Price of Product
    And Price for Product Name <ProductName> should be added in basket on Home Page
    And User clicks on Proceed to Checkout button in Basket
    Then Loyalty Points Balance should be displayed on top of Checkout Page
    And User compares Calculated Award Points as per <ProductPrice> <Spend> <Award> <RateFactor> with Total Loyalty Award Points on Checkout Page
    And User checks I Accept checkbox in Basket
    And User clicks on Place Order Now button in Basket
    And Order should be placed successfully
    #Business Manager
    And User navigates to Business Manager URL
    And User clicks on Menu <Menu> in Business Manager
    And User clicks on SubMenu <SubMenu> under Menu <Menu> in Business Manager
    And User checks Order entry checkbox on Manage Orders list Page in Business Manager
    And User selects Complete from Order Status dropdown on Manage Orders list Page in Business Manager
    And User clicks Update Button on Manage Orders list Page in Business Manager
    And Change Order Status confirmation alert should be displayed on Manage Orders list Page in Business Manager
    #Are you sure to change order status for total 5 orders?
    And User clicks OK on Order Status confirmation alert on Manage Orders list Page in Business Manager
    And Success message should be displayed on Manage Orders list Page in Business Manager
    #Order status has been changed to "Complete" for 5 orders.
    And User returns to website
    And User clicks on SubCategory <SubCategory> under Category <Category> in Product Menu
    And User clicks on Product Name <ProductName> in Product List
    And User clicks on Add To Basket button
    #Fetch Price of Product
    And Price for Product Name <ProductName> should be added in basket on Home Page
    And User clicks on Proceed to Checkout button in Basket
    And Loyalty Points Balance should be displayed on top of Checkout Page
    And Calculated Award Points should be added in Loyalty Points Balance on Checkout Page

    #Refresh Loyalty points from BM
    #User= Priyanka Tripathi belongs to	PTCustGroup1 (Customer Group) for PTCustGroup1 (Product Group) with Rate Factor=3
    #CustomerGroup	PTCustGroup1	ProductGroup	PTProdGroup1	Each	3	01/11/2021	30/11/2023
    Examples: 
      | SubCategory | Category | ProductName     | ProductPrice | Spend | Award | RateFactor |
      | Cameras     | Cameras  | Canon EOS 1500D |          600 |   100 |     1 |          3 |

  @V3dev @LoyaltyPoints
  Scenario Outline: Verify award loyalty Points functionality is working on Checkout page (Customer Number-Product Name-Rate Factor)
    Given User is signed in on website
    And User clicks on SubCategory <SubCategory> under Category <Category> in Product Menu
    #And User search Product Name <ProductName> in auto suggest Search box on Home page
    And User clicks on Product Name <ProductName> in Product List
    #And User waits for Product Name to be displayed
    When User clicks on Add To Basket button
    #Fetch Price of Product
    And Price for Product Name <ProductName> should be added in basket on Home Page
    And User clicks on Proceed to Checkout button in Basket
    Then Loyalty Points Balance should be displayed on top of Checkout Page
    And User compares Calculated Award Points as per <ProductPrice> <Spend> <Award> <RateFactor> with Total Loyalty Award Points on Checkout Page
    And User checks I Accept checkbox in Basket
    And User clicks on Place Order Now button in Basket
    And Order should be placed successfully
    #Business Manager
    And User navigates to Business Manager URL
    And User clicks on Menu <Menu> in Business Manager
    And User clicks on SubMenu <SubMenu> under Menu <Menu> in Business Manager
    And User checks Order entry checkbox on Manage Orders list Page in Business Manager
    And User selects Complete from Order Status dropdown on Manage Orders list Page in Business Manager
    And User clicks Update Button on Manage Orders list Page in Business Manager
    And Change Order Status confirmation alert should be displayed on Manage Orders list Page in Business Manager
    #Are you sure to change order status for total 5 orders?
    And User clicks OK on Order Status confirmation alert on Manage Orders list Page in Business Manager
    And Success message should be displayed on Manage Orders list Page in Business Manager
    #Order status has been changed to "Complete" for 5 orders.
    And User returns to website
    And User clicks on SubCategory <SubCategory> under Category <Category> in Product Menu
    And User clicks on Product Name <ProductName> in Product List
    And User clicks on Add To Basket button
    #Fetch Price of Product
    And Price for Product Name <ProductName> should be added in basket on Home Page
    And User clicks on Proceed to Checkout button in Basket
    And Loyalty Points Balance should be displayed on top of Checkout Page
    And Calculated Award Points should be added in Loyalty Points Balance on Checkout Page

    #Refresh Loyalty points from BM
    #User= Priyanka Tripathi with CustomerNumber I00407691 for SKU112 with Rate Factor=5
    #CustomerNumber	I00407691	ProductSKU	SKU112	Each	5	01/11/2021	30/11/2023
    Examples: 
      | SubCategory | Category                | ProductName        | ProductPrice | Spend | Award | RateFactor |
      | Mobiles     | Mobiles and Accessories | OnePlus Nord CE 5G |          650 |   100 |     1 |          5 |

  @V3dev @LoyaltyPoints
  Scenario Outline: Verify award loyalty Points functionality is working on Checkout page (Customer Number/ Product Group/ RateFactor)
    Given User is signed in on website
    And User clicks on SubSubCategory <SubSubCategory> under Category <Category> in Product Menu
    #And User search Product Name <ProductName> in auto suggest Search box on Home page
    And User clicks on Product Name <ProductName> in Product List
    #And User waits for Product Name to be displayed
    When User clicks on Add To Basket button
    #Fetch Price of Product
    And Price for Product Name <ProductName> should be added in basket on Home Page
    And User clicks on Proceed to Checkout button in Basket
    Then Loyalty Points Balance should be displayed on top of Checkout Page
    And User compares Calculated Award Points as per <ProductPrice> <Spend> <Award> <RateFactor> with Total Loyalty Award Points on Checkout Page
    And User checks I Accept checkbox in Basket
    And User clicks on Place Order Now button in Basket
    And Order should be placed successfully
    #Business Manager
    And User navigates to Business Manager URL
    And User clicks on Menu <Menu> in Business Manager
    And User clicks on SubMenu <SubMenu> under Menu <Menu> in Business Manager
    And User checks Order entry checkbox on Manage Orders list Page in Business Manager
    And User selects Complete from Order Status dropdown on Manage Orders list Page in Business Manager
    And User clicks Update Button on Manage Orders list Page in Business Manager
    And Change Order Status confirmation alert should be displayed on Manage Orders list Page in Business Manager
    #Are you sure to change order status for total 5 orders?
    And User clicks OK on Order Status confirmation alert on Manage Orders list Page in Business Manager
    And Success message should be displayed on Manage Orders list Page in Business Manager
    #Order status has been changed to "Complete" for 5 orders.
    And User returns to website
    And User clicks on SubCategory <SubCategory> under Category <Category> in Product Menu
    And User clicks on Product Name <ProductName> in Product List
    And User clicks on Add To Basket button
    #Fetch Price of Product
    And Price for Product Name <ProductName> should be added in basket on Home Page
    And User clicks on Proceed to Checkout button in Basket
    And Loyalty Points Balance should be displayed on top of Checkout Page
    And Calculated Award Points should be added in Loyalty Points Balance on Checkout Page

    #Refresh Loyalty points from BM
    #User= Priyanka Tripathi with CustomerNumber I00407691 for PTCustGroup2 (Product Group) with Rate Factor=7
    #CustomerNumber	I00407691	ProductGroup	PTProdGroup2	Each	7	21/12/2021	30/11/2023
    Examples: 
      | SubSubCategory | Category                | ProductName              | ProductPrice | Spend | Award | RateFactor |
      | Power Banks    | Mobiles and Accessories | Mi Pocket Power Bank Pro |          110 |   100 |     1 |          7 |

  @V3dev @LoyaltyPoints
  Scenario Outline: Verify redeem loyalty Points functionality is working on Checkout page
    Given User is signed in on website
    And User clicks on SubCategory <SubCategory> under Category <Category> in Product Menu
    #And User search Product Name <ProductName> in auto suggest Search box on Home page
    And User clicks on Product Name <ProductName> in Product List
    #And User waits for Product Name to be displayed
    When User clicks on Add To Basket button
    #Fetch Price of Product
    And Price for Product Name <ProductName> should be added in basket on Home Page
    And User clicks on Proceed to Checkout button in Basket
    Then Loyalty Points Balance should be displayed on top of Checkout Page
    And User compares Calculated Award Points as per <ProductPrice> <Spend> <Award> <RateFactor> with Total Loyalty Award Points on Checkout Page
    And User selects Loyalty Payment Method for Payment on Checkout Page
    And User checks I Accept checkbox in Basket
    And User clicks on Place Order Now button in Basket
    And Order should be placed successfully
    #Business Manager
    And User navigates to Business Manager URL
    And User clicks on Menu <Menu> in Business Manager
    And User clicks on SubMenu <SubMenu> under Menu <Menu> in Business Manager
    And User checks Order entry checkbox on Manage Orders list Page in Business Manager
    And User selects Complete from Order Status dropdown on Manage Orders list Page in Business Manager
    And User clicks Update Button on Manage Orders list Page in Business Manager
    And Change Order Status confirmation alert should be displayed on Manage Orders list Page in Business Manager
    #Are you sure to change order status for total 5 orders?
    And User clicks OK on Order Status confirmation alert on Manage Orders list Page in Business Manager
    And Success message should be displayed on Manage Orders list Page in Business Manager
    #Order status has been changed to "Complete" for 5 orders.
    And User returns to website
    And User clicks on SubCategory <SubCategory> under Category <Category> in Product Menu
    And User clicks on Product Name <ProductName> in Product List
    And User clicks on Add To Basket button
    #Fetch Price of Product
    And Price for Product Name <ProductName> should be added in basket on Home Page
    And User clicks on Proceed to Checkout button in Basket
    And Loyalty Points Balance should be displayed on top of Checkout Page
    And Calculated Award Points should be subtracted from Loyalty Points Balance on Checkout Page

    #Refresh Loyalty points from BM
    Examples: 
      | SubCategory | Category                | ProductName        | ProductPrice | Spend | Award | RateFactor |
      | Laptops     | Laptops and Accessories | Dell Inspiron 3502 |         1000 |   100 |     1 |          2 |
