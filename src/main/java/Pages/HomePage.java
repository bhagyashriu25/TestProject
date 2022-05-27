package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import Util.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//span[contains(text(),'Add to wishlist')]")
	List<WebElement> AddToWishList;
	
	
	@FindBy(xpath="//i[@class='lar la-heart']")
	WebElement WishlistIcon;
	
	@FindBy(xpath="//a[contains(text(),'Browse wishlist')]")
	List<WebElement> BrowseAddedLabel;
	
	@FindBy(name="s")
	WebElement searchBox;
	@FindBy(xpath="//div[@id='yith-wcwl-message']")
	WebElement ProductAddedText;
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public void addFourItemsToWishlist() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[contains(text(),'Sale')]")).click();
		//driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
		System.out.println("inside");
		//featured.click();
		for (int i=0;i<4;i++) {
			System.out.println(AddToWishList.get(0).getText());
			//AddToWishList.get(0).click();
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click()", AddToWishList.get(0));
			WebDriverWait wait = new WebDriverWait(driver, 150);
			wait.until(ExpectedConditions.visibilityOf(ProductAddedText));
			//Thread.sleep(500);
			
		}
		
	}
	public void ClickOnWishlist() {
		WishlistIcon.click();
	}
	
}
