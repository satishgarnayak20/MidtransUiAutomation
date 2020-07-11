Feature: Purchase a Midtrans pillow

  #Valid scenario
  Scenario: Purchase pillow from midtrans website with successful credit card payment
  Given user launches 'https://demo.midtrans.com' url
  And midtrans home page loads
  And user clicks on BUY NOW button
  And user should see shopping cart section
  And user clicks on CHECKOUT button
  And order summary page loads
  And user clicks on CONTINUE button on order summary page
  And select payment page loads
  And user clicks on Credit Card option
  And credit card page loads
  When user fills invalid credit card details
  And user clicks on PAY NOW button on credit card page
  And issuing bank page loads
  And user enters valid password
  And user clicks on OK button
  Then user able to see successful message on thank you page
  
  ##Invalid scenario
  Scenario: Purchase pillow from midtrans website with unsuccessful credit card payment
    Given user launches 'https://demo.midtrans.com' url
    And midtrans home page loads
    And user clicks on BUY NOW button
    And user should see shopping cart section
    And user clicks on CHECKOUT button
    And order summary page loads
    And user clicks on CONTINUE button on order summary page
    And select payment page loads
    And user clicks on Credit Card option
    And credit card page loads
    When user fills invalid credit card details
    And user clicks on PAY NOW button on credit card page
    And issuing bank page loads
    And user enters valid password
    And user clicks on OK button
    Then transaction failed page loads
