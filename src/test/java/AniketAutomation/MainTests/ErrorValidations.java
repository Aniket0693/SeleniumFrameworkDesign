package AniketAutomation.MainTests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import AniketAutomation.TestComponents.BaseTest;
import AniketAutomation.TestComponents.Retry;
import AniketAutomation.Tests.CartPage;
import AniketAutomation.Tests.CheckoutPage;
import AniketAutomation.Tests.ConfirmationPage;
import AniketAutomation.Tests.LandingPage;
import AniketAutomation.Tests.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidations extends BaseTest {

	
	@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
	
	public void ErrorValidationLoginPage() throws IOException 
	
	{
	// TODO Auto-generated method stub
	String Pname = "ZARA COAT 3";
	landingPage.loginApplication("amp@xyz.com", "Aniket");
	//Assert.assertEquals("Incorrect email or password.",  landingPage.getErrorMessage());
	Assert.assertEquals("Incorrect email or password.",  landingPage.getErrorMessage());
	}
	
@Test
	
	public void ProductErrorValidation() throws IOException, InterruptedException 
		
		{
		// TODO Auto-generated method stub
		String Pname = "ZARA COAT 33";
		//LandingPage landingPage = launchApplication();
		ProductCatalogue productCatalogue = landingPage.loginApplication("amp@xyz.com", "Aniket.123");
		List<WebElement> products =  productCatalogue.getProductList();
		productCatalogue.addProductToCart("ZARA COAT 3");
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean Match = cartPage.verifyProductDisplay(Pname);
		Assert.assertFalse(Match);
		}


}
