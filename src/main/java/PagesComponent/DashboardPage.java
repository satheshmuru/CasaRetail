package PagesComponent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import UtilisComponent.UIUtilis;

public class DashboardPage extends UIUtilis{
	
	@FindBy(xpath="//span[text()='Collections']")
	WebElement Dashboard;
	
	
	public DashboardPage() {
		PageFactory.initElements(UIUtilis.driver, this);
	}

	
	public void verfiydashboard()
	{
		Assert.assertEquals(true, waitfor(Dashboard, "Dashboard Page"));
	}
}
