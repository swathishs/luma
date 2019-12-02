Feature: Smoke testing
@SmokeTest
Scenario: Login successfully to the website

Given A browser session with the website
When the user clicks on sigin 
Then Login page is displayed
When the user provides username and password 
And user clicks on login button
Then Home page is displayed


Scenario: validation of navigating to PDP from PLP

Given A browser session with the website
When user click on Jackets from Men menu
Then Jackets PLP page is displayed
When the user clicks on any product
Then user is navigated to pdp 

@SmokeTest
Scenario: Validation of Adding  product to cart from PDP page
Given A browser session with the website
When the user select the colour
And the user enter the quantity 
And click on add to cart button
Then product is added to cart


Scenario: validation of cart functionality 

Given A browser session with the website
When user clicks on view cart button from minicart
Then cart page is displayed
When the user clicks on proceeed to checkout
Then checkout page is displayed


Scenario: Validation of checkout functionality  

Given Website is on checkout1 page 
When user select the shipping method checkbox 
And  user clicks on next button 
Then Checkout page2 is displayed
When user clicks on the check&money checkbox
And clicks on placeorder
Then Sucess page is displayed







