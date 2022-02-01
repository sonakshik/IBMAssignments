package stepDefinition;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.Checkout;
import pages.CompleteCheckOutpage;
import pages.Details;
import runner.TestRunner;

public class CheckoutStepDefinition extends TestRunner {

	@When("^I proceed to checkout")
	public void iProceedToCheckout() throws Throwable {			
		CartPage cart=PageFactory.initElements(driver, CartPage.class);
		cart.verifyProducts(cartContents);
		cart.checkoutButton.click();
		Details inf=PageFactory.initElements(driver, Details.class);
		inf.typeText(inf.firstName, "ABC");
		inf.typeText(inf.lastName, "XYZ");
		inf.typeText(inf.postalCode, "123");
		inf.continueButton.click();
		Checkout finCheckout=PageFactory.initElements(driver, Checkout.class);
		finCheckout.finishButton.click();
		
	}

	@Then("I should see checkout completion page")
	public void iShouldSeeCheckoutCompletionPage() throws Throwable {
		Assert.assertEquals( driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html");  
		CompleteCheckOutpage comp=PageFactory.initElements(driver, CompleteCheckOutpage.class);
		comp.completionMessageDisplayed();
		System.out.println("Checkout success!");
	}
}
