package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.HomePage;
import Pages.WishlistPage;
import Util.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeStepDefinition extends TestBase {
	HomePage homePage;
	WishlistPage wishlistPage;
	public static String price;
	@Given("^I add four different products to my wishlist$")
	public void I_add_four_different_products_to_my_wishlist() throws InterruptedException  {
		TestBase.initialization();
		homePage=new HomePage();
		wishlistPage=new WishlistPage();
		
		homePage.addFourItemsToWishlist();
		
			
	}


@When("^I visit my wishlist table$")
public void I_visit_my_wishlist_table() throws InterruptedException  {
	homePage.ClickOnWishlist();
	String title = wishlistPage.verifyPageLabel();
	System.out.print(title);
	Assert.assertEquals(title, "My wishlist");
}
@Then("^I find total total four selected items in my Wishlist$")
public void I_find_total_total_four_selected_items_in_my_Wishlist()  {
	System.out.print("I_find_total_total_four_selected_items_in_my_Wishlist");
	int wishlistItemSize=wishlistPage.itemsInWishlist();
	   String str1 = Integer.toString(wishlistItemSize);
		Assert.assertEquals(str1, "4");
   
}
@When("^I search for lowest price product$")
public void I_search_for_lowest_price_product() {
	price=wishlistPage.searchForLowestPriceProduct();
	
	System.out.print("lowest price is"+ price);
}
@And("^I am able to add lowest price item in my cart$")
public void I_am_able_to_add_lowest_price_item_in_my_cart(String price) {
	
	wishlistPage.addLowestPriceItemToCart(price);
	
}
@Then("^I am able to verify item in my cart$")
public void I_am_able_to_verify_item_in_my_cart(String price) {
	String ActualitemName=wishlistPage.VerifyItemInCart();
	String ExpectedLowestPriceItemName=wishlistPage.LowestPriceItemName();
		Assert.assertEquals(ExpectedLowestPriceItemName, ActualitemName);
	
}
	 
}
