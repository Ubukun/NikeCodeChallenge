package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
	this.driver=driver;
    }
	
	By searchfield = By.id("twotabsearchtextbox");
	By clickOnButton = By.id("add-to-cart-button");
	By goToCart = By.id("hlb-view-cart-announce");

    public WebElement CheckWord()
    {
	return driver.findElement(searchfield);
    }
    public WebElement AddToShopCart()
    {
	return driver.findElement(clickOnButton);
    }
    public WebElement ViewShopCart()
    {
	return driver.findElement(goToCart);
    }
}
