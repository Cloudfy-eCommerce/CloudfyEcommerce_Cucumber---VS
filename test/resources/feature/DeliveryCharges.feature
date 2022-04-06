#Author: priyanka.tripathi@williamscommerce.com
Feature: Delivery Charges Functionality

  # Extended Delivery scenarios:
  # 1. Basket         | Additional | Once
  # 2. Basket         | Choice     | Once
  # 3. Customer       | Additional | Once
  # 4. Customer       | Choice     | Once
  # 5. Customer Group | Additional | Once
  # 6. Customer Group | Choice     | Once
  # 7. Product        | Additional | Once
  # 8. Product        | Additional | Multiple
  # 9. Product Group  | Additional | Once
  # 10. Product Group | Additional | Multiple
  @V3dev4 @ExtendedDelivery @Basket
  Scenario Outline: Verify Checkout functionality is working (with Extended Delivery Charges on Basket- Additionally - Once)
    #Business Manager
    Given User navigates to Business Manager URL
    And User clicks on Menu <Menu> in Business Manager
    And User clicks on SubMenu <SubMenu> under Menu <Menu> in Business Manager
    And User clicks on Tab <SiteSettingTab> in Business Manager
    And User clicks on Section <OrderSettingsSection> in Business Manager
    And User selects <DeliveryType> from Delivery Type dropdown in Business Manager
    And User selects <DeliveryBreakdownLevel> from Delivery Breakdown Level From dropdown in Business Manager
    And User clicks on Submit button in Business Manager
    And User is signed in on website
    And User clicks on SubCategory <SubCategory> under Category <Category> in Product Menu
    #And User search Product Name <ProductName> in auto suggest Search box on Home page
    And User clicks on Product Name <ProductName> in Product List
    When User clicks on Add To Basket button
    #Fetch Price of Product
    Then Price for Product Name <ProductName> should be added in basket on Home Page
    And User clicks on Proceed to Checkout button in Basket
    #And Delivery Charges are applied on Basket on checkout page
    And Delivery Charge <ExtendedDeliveryCharges> for Product Count <ProductCount> of Delivery Method <DeliveryMethod> should be displayed on Checkout Page
    #And User checks I Accept checkbox in Basket
    And User clicks on Place Order Now button in Basket
    And Order should be placed successfully

    Examples: 
      | SubCategory | Category                | ProductName                                        | DeliveryMethod | ExtendedDeliveryCharges | ProductCount | Menu       | SubMenu       | SiteSettingTab         | OrderSettingsSection | DeliveryType      | DeliveryBreakdownLevel |
      | Mobiles     | Mobiles and Accessories | OPPO A74 5G (Fantastic Purple, 6GB RAM, 128GB Stor | BasketAd       |                       2 |            1 | Site Setup | Site Settings | Transactional Settings | Order Settings       | Extended Delivery | Detailed               |

  @V3dev4 @ExtendedDelivery @Basket 
  Scenario Outline: Verify Checkout functionality is working (with Extended Delivery Charges on Basket- Choice - Once)
    Given User navigates to Business Manager URL
    And User clicks on Menu <Menu> in Business Manager
    And User clicks on SubMenu <SubMenu> under Menu <Menu> in Business Manager
    And User clicks on Tab <SiteSettingTab> in Business Manager
    And User clicks on Section <OrderSettingsSection> in Business Manager
    And User selects <DeliveryType> from Delivery Type dropdown in Business Manager
    And User selects <DeliveryBreakdownLevel> from Delivery Breakdown Level From dropdown in Business Manager
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
    #And Delivery Charges are applied on Basket on checkout page
    And User selects Delivery Method <DeliveryMethod> from Delivery Method on Checkout page
    And Delivery Charge <ExtendedDeliveryCharges> for Product Count <ProductCount> of Delivery Method <DeliveryMethod> should be displayed on Checkout Page
    #And User checks I Accept checkbox in Basket
    And User clicks on Place Order Now button in Basket
    And Order should be placed successfully

    Examples: 
      | SubCategory | Category                | ProductName                                        | DeliveryMethod | ExtendedDeliveryCharges | ProductCount | Menu       | SubMenu       | SiteSettingTab         | OrderSettingsSection | DeliveryType      | DeliveryBreakdownLevel |
      | Mobiles     | Mobiles and Accessories | OPPO A74 5G (Fantastic Purple, 6GB RAM, 128GB Stor | BasketChoice   |                       1 |            1 | Site Setup | Site Settings | Transactional Settings | Order Settings       | Extended Delivery | Detailed               |

  @V3dev4 @ExtendedDelivery @Customer
  Scenario Outline: Verify Checkout functionality is working (with Extended Delivery Charges on Customer- Additionally - Once)
    Given User navigates to Business Manager URL
    And User clicks on Menu <Menu> in Business Manager
    And User clicks on SubMenu <SubMenu> under Menu <Menu> in Business Manager
    And User clicks on Tab <SiteSettingTab> in Business Manager
    And User clicks on Section <OrderSettingsSection> in Business Manager
    And User selects <DeliveryType> from Delivery Type dropdown in Business Manager
    And User selects <DeliveryBreakdownLevel> from Delivery Breakdown Level From dropdown in Business Manager
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
    #And Delivery Charges are applied on Basket on checkout page
    And Delivery Charge <ExtendedDeliveryCharges> for Product Count <ProductCount> of Delivery Method <DeliveryMethod> should be displayed on Checkout Page
    #And User checks I Accept checkbox in Basket
    And User clicks on Place Order Now button in Basket
    And Order should be placed successfully

    Examples: 
      | SubCategory | Category                | ProductName                                        | DeliveryMethod | ExtendedDeliveryCharges | ProductCount | Menu       | SubMenu       | SiteSettingTab         | OrderSettingsSection | DeliveryType      | DeliveryBreakdownLevel |
      | Mobiles     | Mobiles and Accessories | OPPO A74 5G (Fantastic Purple, 6GB RAM, 128GB Stor | CustomerAd     |                      10 |            1 | Site Setup | Site Settings | Transactional Settings | Order Settings       | Extended Delivery | Detailed               |

  @V3dev4 @ExtendedDelivery @Customer
  Scenario Outline: Verify Checkout functionality is working (with Extended Delivery Charges on Customer- Choice - Once)
    Given User navigates to Business Manager URL
    And User clicks on Menu <Menu> in Business Manager
    And User clicks on SubMenu <SubMenu> under Menu <Menu> in Business Manager
    And User clicks on Tab <SiteSettingTab> in Business Manager
    And User clicks on Section <OrderSettingsSection> in Business Manager
    And User selects <DeliveryType> from Delivery Type dropdown in Business Manager
    And User selects <DeliveryBreakdownLevel> from Delivery Breakdown Level From dropdown in Business Manager
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
    #And Delivery Charges are applied on Basket on checkout page
    And User selects Delivery Method <DeliveryMethod> from Delivery Method on Checkout page
    And Delivery Charge <ExtendedDeliveryCharges> for Product Count <ProductCount> of Delivery Method <DeliveryMethod> should be displayed on Checkout Page
    #And User checks I Accept checkbox in Basket
    And User clicks on Place Order Now button in Basket
    And Order should be placed successfully

    Examples: 
      | SubCategory | Category                | ProductName                                        | DeliveryMethod | ExtendedDeliveryCharges | ProductCount | Menu       | SubMenu       | SiteSettingTab         | OrderSettingsSection | DeliveryType      | DeliveryBreakdownLevel |
      | Mobiles     | Mobiles and Accessories | OPPO A74 5G (Fantastic Purple, 6GB RAM, 128GB Stor | CustomerChoice |                       3 |            1 | Site Setup | Site Settings | Transactional Settings | Order Settings       | Extended Delivery | Detailed               |

  @V3dev4 @ExtendedDelivery @CustomerGroup
  Scenario Outline: Verify Checkout functionality is working (with Extended Delivery Charges on Customer Group- Additionally - Once)
    Given User navigates to Business Manager URL
    And User clicks on Menu <Menu> in Business Manager
    And User clicks on SubMenu <SubMenu> under Menu <Menu> in Business Manager
    And User clicks on Tab <SiteSettingTab> in Business Manager
    And User clicks on Section <OrderSettingsSection> in Business Manager
    And User selects <DeliveryType> from Delivery Type dropdown in Business Manager
    And User selects <DeliveryBreakdownLevel> from Delivery Breakdown Level From dropdown in Business Manager
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
    #And Delivery Charges are applied on Basket on checkout page
    And Delivery Charge <ExtendedDeliveryCharges> for Product Count <ProductCount> of Delivery Method <DeliveryMethod> should be displayed on Checkout Page
    #And User checks I Accept checkbox in Basket
    And User clicks on Place Order Now button in Basket
    And Order should be placed successfully

    Examples: 
      | SubCategory | Category                | ProductName                                        | DeliveryMethod | ExtendedDeliveryCharges | ProductCount | Menu       | SubMenu       | SiteSettingTab         | OrderSettingsSection | DeliveryType      | DeliveryBreakdownLevel |
      | Mobiles     | Mobiles and Accessories | OPPO A74 5G (Fantastic Purple, 6GB RAM, 128GB Stor | CustGroupAd    |                      15 |            1 | Site Setup | Site Settings | Transactional Settings | Order Settings       | Extended Delivery | Detailed               |

  @V3dev4 @ExtendedDelivery @CustomerGroup
  Scenario Outline: Verify Checkout functionality is working (with Extended Delivery Charges on Customer Group- Choice - Once)
    Given User navigates to Business Manager URL
    And User clicks on Menu <Menu> in Business Manager
    And User clicks on SubMenu <SubMenu> under Menu <Menu> in Business Manager
    And User clicks on Tab <SiteSettingTab> in Business Manager
    And User clicks on Section <OrderSettingsSection> in Business Manager
    And User selects <DeliveryType> from Delivery Type dropdown in Business Manager
    And User selects <DeliveryBreakdownLevel> from Delivery Breakdown Level From dropdown in Business Manager
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
    #And Delivery Charges are applied on Basket on checkout page
    And User selects Delivery Method <DeliveryMethod> from Delivery Method on Checkout page
    And Delivery Charge <ExtendedDeliveryCharges> for Product Count <ProductCount> of Delivery Method <DeliveryMethod> should be displayed on Checkout Page
    #And User checks I Accept checkbox in Basket
    And User clicks on Place Order Now button in Basket
    And Order should be placed successfully

    Examples: 
      | SubCategory | Category                | ProductName                                        | DeliveryMethod  | ExtendedDeliveryCharges | ProductCount | Menu       | SubMenu       | SiteSettingTab         | OrderSettingsSection | DeliveryType      | DeliveryBreakdownLevel |
      | Mobiles     | Mobiles and Accessories | OPPO A74 5G (Fantastic Purple, 6GB RAM, 128GB Stor | CustGroupChoice |                       5 |            1 | Site Setup | Site Settings | Transactional Settings | Order Settings       | Extended Delivery | Detailed               |

  @V3dev4 @ExtendedDelivery @Product
  Scenario Outline: Verify Checkout functionality is working (with Extended Delivery Charges on Product- Additionally - Once)
    Given User navigates to Business Manager URL
    And User clicks on Menu <Menu> in Business Manager
    And User clicks on SubMenu <SubMenu> under Menu <Menu> in Business Manager
    And User clicks on Tab <SiteSettingTab> in Business Manager
    And User clicks on Section <OrderSettingsSection> in Business Manager
    And User selects <DeliveryType> from Delivery Type dropdown in Business Manager
    And User selects <DeliveryBreakdownLevel> from Delivery Breakdown Level From dropdown in Business Manager
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
    #And Delivery Charges are applied on Basket on checkout page
    And Delivery Charge <ExtendedDeliveryCharges> for Product Count <ProductCount> of Delivery Method <DeliveryMethod> should be displayed on Checkout Page
    #And User checks I Accept checkbox in Basket
    And User clicks on Place Order Now button in Basket
    And Order should be placed successfully

    Examples: 
      | SubCategory | Category                | ProductName                                        | DeliveryMethod | ExtendedDeliveryCharges | ProductCount | Menu       | SubMenu       | SiteSettingTab         | OrderSettingsSection | DeliveryType      | DeliveryBreakdownLevel |
      | Mobiles     | Mobiles and Accessories | OPPO A74 5G (Fantastic Purple, 6GB RAM, 128GB Stor | ProductAd      |                       9 |            1 | Site Setup | Site Settings | Transactional Settings | Order Settings       | Extended Delivery | Detailed               |

  @V3dev4 @ExtendedDelivery @Product
  Scenario Outline: Verify Checkout functionality is working (with Extended Delivery Charges on Product- Additionally - Multiple)
    Given User navigates to Business Manager URL
    And User clicks on Menu <Menu> in Business Manager
    And User clicks on SubMenu <SubMenu> under Menu <Menu> in Business Manager
    And User clicks on Tab <SiteSettingTab> in Business Manager
    And User clicks on Section <OrderSettingsSection> in Business Manager
    And User selects <DeliveryType> from Delivery Type dropdown in Business Manager
    And User selects <DeliveryBreakdownLevel> from Delivery Breakdown Level From dropdown in Business Manager
    And User clicks on Submit button in Business Manager
    And User is signed in on website
    And User clicks on SubCategory <SubCategory> under Category <Category> in Product Menu
    #And User search Product Name <ProductName> in auto suggest Search box on Home page
    And User clicks on Product Name <ProductName> in Product List
    #And User waits for Product Name to be displayed
    When User clicks on Add To Basket button <ProductCount> times
    #Fetch Price of Product
    Then Price for Product Name <ProductName> should be added in basket on Home Page
    And User clicks on Proceed to Checkout button in Basket
    #And Delivery Charges are applied on Basket on checkout page
    And Delivery Charge <ExtendedDeliveryCharges> for Product Count <ProductCount> of Delivery Method <DeliveryMethod> should be displayed on Checkout Page
    #And User checks I Accept checkbox in Basket
    And User clicks on Place Order Now button in Basket
    And Order should be placed successfully

    Examples: 
      | SubCategory | Category                | ProductName                                        | ExtendedDeliveryCharges | DeliveryMethod    | ProductCount | Menu       | SubMenu       | SiteSettingTab         | OrderSettingsSection | DeliveryType      | DeliveryBreakdownLevel |
      | Mobiles     | Mobiles and Accessories | OnePlus Nord CE 5G (Charcoal Ink, 8GB RAM, 128GB S |                       4 | ProductAdMultiple |            4 | Site Setup | Site Settings | Transactional Settings | Order Settings       | Extended Delivery | Detailed               |

  @V3dev4 @ExtendedDelivery @ProductGroup
  Scenario Outline: Verify Checkout functionality is working (with Extended Delivery Charges on Product Group- Additionally - Once)
    Given User navigates to Business Manager URL
    And User clicks on Menu <Menu> in Business Manager
    And User clicks on SubMenu <SubMenu> under Menu <Menu> in Business Manager
    And User clicks on Tab <SiteSettingTab> in Business Manager
    And User clicks on Section <OrderSettingsSection> in Business Manager
    And User selects <DeliveryType> from Delivery Type dropdown in Business Manager
    And User selects <DeliveryBreakdownLevel> from Delivery Breakdown Level From dropdown in Business Manager
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
    #And Delivery Charges are applied on Basket on checkout page
    And Delivery Charge <ExtendedDeliveryCharges> for Product Count <ProductCount> of Delivery Method <DeliveryMethod> should be displayed on Checkout Page
    #And User checks I Accept checkbox in Basket
    And User clicks on Place Order Now button in Basket
    And Order should be placed successfully

    Examples: 
      | SubCategory | Category                | ProductName                                        | DeliveryMethod | ExtendedDeliveryCharges | ProductCount | Menu       | SubMenu       | SiteSettingTab         | OrderSettingsSection | DeliveryType      | DeliveryBreakdownLevel |
      | Mobiles     | Mobiles and Accessories | OPPO A74 5G (Fantastic Purple, 6GB RAM, 128GB Stor | ProductGroupAd |                       7 |            1 | Site Setup | Site Settings | Transactional Settings | Order Settings       | Extended Delivery | Detailed               |

  @V3dev4 @ExtendedDelivery @ProductGroup
  Scenario Outline: Verify Checkout functionality is working (with Extended Delivery Charges on Product Group- Additionally - Multiple)
    Given User navigates to Business Manager URL
    And User clicks on Menu <Menu> in Business Manager
    And User clicks on SubMenu <SubMenu> under Menu <Menu> in Business Manager
    And User clicks on Tab <SiteSettingTab> in Business Manager
    And User clicks on Section <OrderSettingsSection> in Business Manager
    And User selects <DeliveryType> from Delivery Type dropdown in Business Manager
    And User selects <DeliveryBreakdownLevel> from Delivery Breakdown Level From dropdown in Business Manager
    And User clicks on Submit button in Business Manager
    And User is signed in on website
    And User clicks on SubCategory <SubCategory> under Category <Category> in Product Menu
    #And User search Product Name <ProductName> in auto suggest Search box on Home page
    And User clicks on Product Name <ProductName> in Product List
    #And User waits for Product Name to be displayed
    When User clicks on Add To Basket button <ProductCount> times
    #Fetch Price of Product
    Then Price for Product Name <ProductName> should be added in basket on Home Page
    And User clicks on Proceed to Checkout button in Basket
    #And Delivery Charges are applied on Basket on checkout page
    And Delivery Charge <ExtendedDeliveryCharges> for Product Count <ProductCount> of Delivery Method <DeliveryMethod> should be displayed on Checkout Page
    #And User checks I Accept checkbox in Basket
    And User clicks on Place Order Now button in Basket
    And Order should be placed successfully

    Examples: 
      | SubCategory | Category                | ProductName                                        | ExtendedDeliveryCharges | DeliveryMethod      | ProductCount | Menu       | SubMenu       | SiteSettingTab         | OrderSettingsSection | DeliveryType      | DeliveryBreakdownLevel |
      | Mobiles     | Mobiles and Accessories | Mi 11X Pro 5G (Lunar White, 8GB RAM, 128GB Storage |                      11 | ProdGroupAdMultiple |            3 | Site Setup | Site Settings | Transactional Settings | Order Settings       | Extended Delivery | Detailed               |
#------------------------------------------------POSTCODE VALIDATION-----------------------------------------------------------------
	@V3dev4 @ExtendedDelivery @PostCodeValidation
  Scenario Outline: Verify length of PostCode on Checkout lies between PostCode length range specified on Address page of Business Manager
    Given User navigates to Business Manager URL
    And User clicks on Menu <Menu> in Business Manager
    And User clicks on SubMenu <SubMenu> under Menu <Menu> in Business Manager
    And User clicks on Tab <SiteSettingTab> in Business Manager
    And User clicks on Section <OrderSettingsSection> in Business Manager
    And User selects <DeliveryType> from Delivery Type dropdown in Business Manager
    And User selects <DeliveryBreakdownLevel> from Delivery Breakdown Level From dropdown in Business Manager
    And User clicks on Submit button in Business Manager
    #NAVIGATE TO ADDRESS PAGE IN BM
    #FETCH POSTCODE LENGTH
    And User is signed in on website
    And User clicks on SubCategory <SubCategory> under Category <Category> in Product Menu
    #And User search Product Name <ProductName> in auto suggest Search box on Home page
    And User clicks on Product Name <ProductName> in Product List
    #And User waits for Product Name to be displayed
    When User clicks on Add To Basket button <ProductCount> times
    #Fetch Price of Product
    Then Price for Product Name <ProductName> should be added in basket on Home Page
    And User clicks on Proceed to Checkout button in Basket
    #ENTER NEW DELIVERY ADDRESS WITH POSTCODE AND OTHER DETAILS
    #
    #And Delivery Charges are applied on Basket on checkout page
    And Delivery Charge <ExtendedDeliveryCharges> for Product Count <ProductCount> of Delivery Method <DeliveryMethod> should be displayed on Checkout Page
    #And User checks I Accept checkbox in Basket
    And User clicks on Place Order Now button in Basket
    And Order should be placed successfully