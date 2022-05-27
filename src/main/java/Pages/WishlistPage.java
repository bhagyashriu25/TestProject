package Pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;

import Util.TestBase;

public class WishlistPage extends TestBase {
	
	@FindBy(xpath="//h2[contains(text(),'My wishlist')]")
	WebElement MyWishlistLabel;
	
	
	@FindBy(xpath="//i[@class='lar la-heart']")
	WebElement WishlistIcon;
	
	@FindBy(xpath="//tbody[@class='wishlist-items-wrapper']/tr")
	List<WebElement> NumberOfItems;
	
	@FindBy(xpath="//td//ins/span[@class='woocommerce-Price-amount amount']")
	List<WebElement> AlltemPrices;

	@FindBy(xpath="//td//ins/span[contains(text(),'%s')]//following::td[@class='product-add-to-cart'][1]")
			WebElement AddToCartLink;
			
	@FindBy(xpath="//i[@class='la la-shopping-bag']")
	WebElement AddToCartIcon;
	
	@FindBy(xpath="//td[@class='product-name']/a")
	List<WebElement> ItemNameonAddToCart;

			public WishlistPage() {
		PageFactory.initElements(driver, this);
	}
	public String verifyPageLabel() throws InterruptedException {
		return MyWishlistLabel.getText();
		
	}
	public int itemsInWishlist() {
		int size=NumberOfItems.size();
		return size;
		
	}
	public String searchForLowestPriceProduct() {
		ArrayList<String> a = new ArrayList<String>();

		for(int i=0;i<AlltemPrices.size();i++) {
		System.out.println(AlltemPrices.get(i).getText());
		a.add(AlltemPrices.get(i).getText());
		
		}
		 Collections.sort(a);
		
		String element=a.get(0);
		return element;
	
		
	}
	public void addLowestPriceItemToCart(String element)
	{
		//String element=searchForLowestPriceProduct();
		String xpathlink="//td//ins/span[contains(text(),'%s')]//following::td[@class='product-add-to-cart'][1]";
		 
		driver.findElement(By.xpath(xpathlink.replace("%s", element))).click(); 
	}
	public String LowestPriceItemName() {
		String element=searchForLowestPriceProduct();
		String xpathlink="//td//ins/span[contains(text(),'%s')]//preceding::td[@class='product-name']/a";
		 
		String LowestPriceItemName=driver.findElement(By.xpath(xpathlink.replace("%s", element))).getText(); 
	return LowestPriceItemName;
		
		
	}
	public String VerifyItemInCart() {
		String val = null;
		String LowestPriceItemName=LowestPriceItemName();
		AddToCartIcon.click();
		for(int i=0;i<ItemNameonAddToCart.size();i++) {
			
			if(ItemNameonAddToCart.get(i).getText().equals(LowestPriceItemName)) {
				val=ItemNameonAddToCart.get(i).getText();
				
			}
		}
		
		return val;
		
	}
}
