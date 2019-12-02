package stepdefination;

import Testcase.Login;
import Testcase.PDP;
import Testcase.PLP;
import Testcase.cart;
import Testcase.checkout;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class smoke{

	Login lo = new Login();
	PLP plp = new PLP();
	PDP pdp = new PDP();
	cart Cart= new cart();
	checkout check = new checkout();

	@Given("^A browser session with the website$")
	public void a_browser_session_with_the_website() throws Exception{
		lo.validateHomepage();
	}

	@When("^the user clicks on sigin$")
	public void the_user_clicks_on_sigin() throws Exception {
		lo.Signin();
	}

	@Then("^Login page is displayed$")
	public void login_page_is_displayed() throws Exception {
		lo.loginpage();
	}

	@When("^the user provides username and password$")
	public void the_user_provides_username_and_password() throws Exception  {
		lo.credentials();
	}

	@When("^user clicks on login button$")
	public void user_clicks_on_login_button() throws Exception{
		lo.myaccount();
	}

	@Then("^Home page is displayed$")
	public void home_page_is_displayed() throws Exception  {
		lo.dashboard();
	}

	@When("^user click on Jackets from Men menu$")
	public void user_click_on_Jackets_from_Men_menu() throws Exception {
		plp.Fluids();
	}

	@Then("^Jackets PLP page is displayed$")
	public void Jackets_PLP_page_is_displayed() throws Exception{
		plp.Plppage();
	}

	@When("^the user clicks on any product$")
	public void the_user_clicks_on_any_product() throws Exception {
		plp.add();
	}

	@Then("^user is navigated to pdp$")
	public void user_is_navigated_to_pdp() throws Exception  {
		pdp.PDPpage();
	}
	@When("^the user select the colour$")
	public void the_user_select_the_colour() throws Exception{
		pdp.colours();
	}
	@And("^the user enter the quantity$")
	public void the_user_enter_the_quantity() throws Exception{
		pdp.QTY();
	}
	@And("^click on add to cart button$")
	public void click_on_add_to_cart_button() throws Exception{
		pdp.Add();
	}
	@Then("^product is added to cart$")
	public void product_is_added_to_cart() throws Exception{
		pdp.itemadded();
	}
	@When("^user clicks on view cart button from minicart$")
	public void user_clicks_on_view_cart_button_from_minicart() throws Exception{
		Cart.minicart();
	}
	@Then("^cart page is displayed$")
	public void cart_page_is_displayed() throws Exception{
		Cart.cartpage();
	}
	@When("^the user clicks on proceeed to checkout$")
	public void the_user_clicks_on_proceeed_to_checkout() throws Exception{
		Cart.proceed();
	}
	@Then("^checkout page is displayed$")
	public void checkout_page_is_displayed() throws Exception{
	   check.checkoutpage1();
	}

	@Given("^Website is on checkout1 page$")
	public void website_is_on_checkout_page() throws Exception  {
	    check.checkoutpage1();
	}

	@When("^user select the shipping method checkbox$")
	public void user_select_the_shipping_method_checkbox() throws Throwable {
	    check.checkbox();
	}

	@And("^user clicks on next button$")
	public void user_clicks_on_next_button() throws Exception  {
	    check.next();
	}

	@Then("^Checkout page2 is displayed$")
	public void checkout_page2_is_displayed() throws Exception{
	    check.checkoutpage2();
	}

	@When("^user clicks on the check&money checkbox$")
	public void user_clicks_on_the_check_money_checkbox() throws Exception  {
	    check.checkmo();
	}

	@And("^clicks on placeorder$")
	public void clicks_on_placeorder() throws Exception {
	    check.placeorder();
	}

	@Then("^Sucess page is displayed$")
	public void sucess_page_is_displayed() throws Exception  {
	   check.success();
	}
}