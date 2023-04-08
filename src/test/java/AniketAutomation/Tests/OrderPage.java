package AniketAutomation.Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AniketAutomation.AbstractComponent.AbstractComponent;

public class OrderPage extends AbstractComponent{
	
	WebDriver driver;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	@FindBy(css="tr td:nth-child(3)")
	private List<WebElement> productsNames;
	
	
	
	public OrderPage (WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public Boolean verifyOrderDisplay(String Pname) 
	{
		Boolean Match =  productsNames.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(Pname));
		return Match;
	}
	
	
}
