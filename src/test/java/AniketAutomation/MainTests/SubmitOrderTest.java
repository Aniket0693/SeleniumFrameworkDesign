package AniketAutomation.MainTests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AniketAutomation.TestComponents.BaseTest;
import AniketAutomation.TestComponents.Retry;
import AniketAutomation.Tests.CartPage;
import AniketAutomation.Tests.CheckoutPage;
import AniketAutomation.Tests.ConfirmationPage;
import AniketAutomation.Tests.LandingPage;
import AniketAutomation.Tests.OrderPage;
import AniketAutomation.Tests.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest{
	String Pname = "ZARA COAT 3";
	@Test (dataProvider="getData", groups= {"Purchase"})
	
	//public void SubmitOrder(String email, String Pass, String Pname) throws IOException  - Array method 
	public void SubmitOrder(HashMap<String,String> input) throws IOException // Hashmap Method
, InterruptedException
		{
		// TODO Auto-generated method stub
		
		//LandingPage landingPage = launchApplication();
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("pass"));
		List<WebElement> products =  productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("Pname"));
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean Match = cartPage.verifyProductDisplay(input.get("Pname"));
		Assert.assertTrue(Match);
		CheckoutPage checkoutPage = cartPage.goTocheckoutPage();
		checkoutPage.selectCountry("India");
		Thread.sleep(2000);
		ConfirmationPage confirmationPage = checkoutPage.submitorder(); 
		String confMsg =  confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	
	@Test(dependsOnMethods= {"SubmitOrder"})
	
	public void orderHistoryTest()
	{
		ProductCatalogue productCatalogue = landingPage.loginApplication("amp@xyz.com", "Aniket.123");
		OrderPage orderPage = productCatalogue.goToOrdersPage();
		Assert.assertTrue(orderPage.verifyOrderDisplay(Pname));
		
	}
	
	// ************Parameterization utility*****************
	
	@DataProvider
	public Object[][] getData() throws IOException
	{

		List<HashMap<String,String>> data = getJsonDataToMap("E:\\Selenium_RahulShetty\\Selenium_Restart\\SeleniumFrameworkDesign\\src\\test\\java\\AniketAutomation\\Data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
		//array method
		//return new Object[][] {{"amp@xyz.com"7, "Aniket.123","ZARA COAT 3"},{"anshika@gmail.com","Iamking@000","ADIDAS ORIGINAL"}};
		
		//Hashmap method
//		HashMap<String,String> map = new HashMap<String,String>();
//		map.put("email", "amp@xyz.com");
//		map.put("pass", "Aniket.123");
//		map.put("Pname", "ZARA COAT 3");
//		
//		HashMap<String,String> map1 = new HashMap<String,String>();
//		map1.put("email", "anshika@gmail.com");
//		map1.put("pass", "Iamking@000");
//		map1.put("Pname", "ADIDAS ORIGINAL");
//		return new Object[][] {{map},{map1}};
	}


}
