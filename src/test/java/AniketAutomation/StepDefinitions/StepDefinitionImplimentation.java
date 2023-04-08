package AniketAutomation.StepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import AniketAutomation.TestComponents.BaseTest;
import AniketAutomation.Tests.CartPage;
import AniketAutomation.Tests.CheckoutPage;
import AniketAutomation.Tests.ConfirmationPage;
import AniketAutomation.Tests.LandingPage;
import AniketAutomation.Tests.ProductCatalogue;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class StepDefinitionImplimentation extends BaseTest {

	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage;
	@Given("User lands on Ecommerce page")
	public void User_lands_on_Ecommerce_page() throws IOException
	{
		landingPage = launchApplication();
	}
		
	@Given ("^User logged in with Username (.+) and Password (.+)$")
	public void User_logged_in_with_Username_and_Password(String userName, String pass)
	{
		productCatalogue = landingPage.loginApplication(userName, pass);
	}
	@When ("^User add the product (.+) to cart$")
	public void User_add_the_product_to_cart(String productName) throws InterruptedException
	{
		List<WebElement> products =  productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
	}
	
	@And ("^Checkout (.+) and submit the order$")
		
	public void Checkout_and_submit_the_order(String productName) throws InterruptedException
	{
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean Match = cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(Match);
		CheckoutPage checkoutPage = cartPage.goTocheckoutPage();
		checkoutPage.selectCountry("India");
		Thread.sleep(2000);
		confirmationPage = checkoutPage.submitorder(); 
	}
	
	@Then ("{string} message is displayed on confirmation Page")
	public void verify_message_displayed_on_confirmation_Page(String msg)
	{
		String confMsg =  confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confMsg.equalsIgnoreCase(msg));
		driver.close();
	}
	
	@Then("{string} message is displayed")
    public void Error_message_is_displayed(String errMsg) throws Throwable 
	{
		Assert.assertEquals(errMsg,  landingPage.getErrorMessage());
		driver.close();
    }
}
