package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.Assert;
import ObjectRepository.HomePage;

public class SearchByWord {
	
	@Test
	public void CheckWord()   
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ds\\Selenium\\TrainningFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
		
		// Select "Books" from the dropdown menu
		Select droplist = new Select(driver.findElement(By.id("searchDropdownBox")));
		droplist.selectByVisibleText("Books");
		
		// Search for "Nike" into Search text box field
		HomePage hp=new HomePage(driver);
		hp.CheckWord().sendKeys("Nike");
		
		// Hit ENTER in order to execute the book search user action
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		
		// Select 'Hardcover' book version 
		driver.findElement(By.linkText("Hardcover")).click();
		
		// Select the book with requested title "Shoe Dog: A Memoir by the Creator of Nike"
		driver.findElement(By.linkText("Shoe Dog: A Memoir by the Creator of Nike")).click();
	
		// Get book amount from product page (Before it was added to the Shopping Cart)
		String amountBefore = driver.findElement(By.id("buyNewSection")).getText();
		String amountExpected = "$16.60";
		
	    // Validation 1: Assert book amount before it was added to the Shopping Cart
		Assert.assertTrue(amountBefore.contains(amountExpected));
		
		// Add 'Hardcover' book version to the Shopping cart by clicking on "Add to Cart" button
		HomePage ad=new HomePage(driver);
		ad.AddToShopCart().click();
					
		// Navigate to Shopping Cart (by clicking on the "Cart" button)
		HomePage vw=new HomePage(driver);
		vw.ViewShopCart().click();
			       
		// Get 'Subtotal' book amount (After book added to Shopping cart)
		String amountShoppCart = driver.findElement(By.id("sc-subtotal-label-activecart")).getText();
		// Validation 2: Assert book amount after book added to the Shopping Cart
		Assert.assertTrue(amountShoppCart.contains (amountExpected));
		
		// Close the browser
		driver.quit();
	   }
}
