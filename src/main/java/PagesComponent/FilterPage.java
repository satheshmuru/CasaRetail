package PagesComponent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import UtilisComponent.UIUtilis;

public class FilterPage extends UIUtilis{

	
	@FindBy(xpath="//span[text()='email']")
	WebElement email;
	
	
	@FindBy(xpath="(//span[text()='email']//following::i[contains(text(),'filter_list')])[1]")
	WebElement emailfilter;
	
	@FindBy(xpath="//div[@class='c-beta-filter-entry__value ember-view']//input[@class='c-beta-input c-beta-input--basic ']")
	WebElement searchtextfield;
	
	@FindBy(xpath="//span[text()='Apply filters']")
	WebElement filtersbutton;
	
	@FindBy(xpath="(//div[@class=\"collectionList__content\"]//tr)[2]//td//div[text()='carlie43@example.com']")
	WebElement filteredvalue;
	
	@FindBy(xpath="(//div[@class=\"collectionList__content\"]//tr)[3]")
	WebElement checkfiltersize;
	
	@FindBy(xpath="(//div[@class=\"collectionList__content\"]//tr)[2]//td//div[text()='candace.kunze@example.com']")
	WebElement ascendingfilter;
	

	
	
	
	public FilterPage() {
		PageFactory.initElements(UIUtilis.driver, this);
	}

	
	public void filterandsorting() throws InterruptedException
	{
		Assert.assertEquals(true, waitfor(email, "Email Lable"));
		Assert.assertEquals(true, click(email, "Email Lable"));
		Assert.assertEquals(true, click(email, "Email Lable"));	
		Assert.assertEquals(true, waitfor(ascendingfilter, "candace.kunze@example.com"));		
		Assert.assertEquals(true, waitfor(emailfilter, "Email Filter"));
		Assert.assertEquals(true, click(emailfilter, "Email Filter"));
		Assert.assertEquals(true, waitfor(searchtextfield, "Filter Text Field"));
		Assert.assertEquals(true, typetext(searchtextfield, "carlie43@example.com", "Filter Text Field"));
		Assert.assertEquals(true, waitfor(filtersbutton, "Filter button"));
		Assert.assertEquals(true, click(filtersbutton, "Filter button"));		
		Assert.assertEquals(true, waitfor(filteredvalue, "carlie43@example.com"));
		Assert.assertEquals(true, elementnotpresent(checkfiltersize, "one filter value"));
		
		Thread.sleep(10000);
		
	}
}
