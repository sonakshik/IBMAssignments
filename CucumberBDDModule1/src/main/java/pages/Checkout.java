package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Checkout extends LoginPage{
	
	public Checkout(WebDriver driver) {
		super(driver);		
	}

	//@FindBy(id="first-name")
	//public WebElement firstName;	
	
	@FindBy(id="finish")
	public WebElement finishButton;
	
		 
	
	
	
}
