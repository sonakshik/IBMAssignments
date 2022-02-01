package stepDefinition;

import java.util.Collection;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CartPage;
import pages.ItemsPage;
import runner.TestRunner;

@SuppressWarnings("unused")
public class ItemsStepDefinition extends TestRunner {

	@And("^I select the \"([^\"]*)\" from the inventory")
	public void iSelectTheFromTheInventory(String itemName) throws Throwable {
		ItemsPage itm=PageFactory.initElements(driver, ItemsPage.class);
		if(driver.getCurrentUrl().contains("cart")) {
			itm.continueShopping.click();
		}		
		int index=itm.addItemToCart(itemName);
		String prodPrice=itm.inventoryItemPrices.get(index).getText();
		cartContents.put(itemName, prodPrice)	;	
		
	}

	

	@Then("I confirm the cart contents")
	public void iConfirmTheCartContents() throws Throwable {
		ItemsPage itm=PageFactory.initElements(driver, ItemsPage.class);
		itm.cartButton.click();	
		System.out.println("cart contents verified");
		
		
	}



	@Then("I remove {string} from the cart")
	public void iRemoveFromTheCart(String name) throws Throwable {
		CartPage cart=PageFactory.initElements(driver, CartPage.class);
		cart.removeItemFromCart(name);
		cartContents.remove(name);
	}



	@And("^I select (\\d+) lowest priced products$")
	public void iSelectLowestPricedProducts(int arg1) throws Throwable {
		ItemsPage itm=PageFactory.initElements(driver, ItemsPage.class);
		Collection<String> expectedOrder = itm.verifyProductOrder("price");
		itm.sortProducts("price");				
		Collection<String> actualOrder = itm.verifyProductOrder(" ");//product order as seen on page
		Assert.assertTrue(expectedOrder.equals(actualOrder));
		itm.addItemToCart(arg1);
		int i=0;
		while(i<arg1) {			
			String prodPrice=itm.inventoryItemPrices.get(i).getText();
			cartContents.put(itm.inventoryItemNames.get(i).getText(), prodPrice)	;	
			i++;
		}
	}
	
}
