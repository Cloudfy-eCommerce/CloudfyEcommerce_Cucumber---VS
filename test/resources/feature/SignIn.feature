#Author: priyanka.tripathi@williamscommerce.com
Feature: Sign in Functionality

  @V3dev4
  Scenario Outline: Verify Sign in functionality with valid credentials
    Given User clicks on Sign in text on home page
    When User enters username <UserName> on Sign in page
    And User enters password <Password> on Sign in page
    And User clicks on Sign in button on Sign in page
    Then User should be signed in successfully

    Examples: 
      | UserName                               | Password     |
      | priyanka.tripathi@williamscommerce.com | Priyanka@123 |

  @V3dev4
  Scenario Outline: Verify Sign in functionality with invalid credentials
    Given User clicks on Sign in text on home page
    When User enters username <UserName> on Sign in page
    And User enters password <Password> on Sign in page
    And User clicks on Sign in button on Sign in page
    Then User should not be signed in successfully

    Examples: 
      | UserName | Password     |
      | williams | Priyanka@123 |
