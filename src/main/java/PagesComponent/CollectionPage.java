package PagesComponent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import UtilisComponent.UIUtilis;

public class CollectionPage extends UIUtilis{
	
	@FindBy(xpath="//span[@title='Customers']")
	WebElement collectionmodule;
	
	@FindBy(xpath="//div[text()='Micah Mosciski']")
	WebElement customer_Micah;
	
	@FindBy(xpath="//ol[@class='ember-view c-side-menu__list c-related-data-menu']//span[@title='Orders']")
	WebElement order_button;
	
	@FindBy(xpath="//div[@role='button']//i[text()='add']")
	WebElement Plus_button;
	
	@FindBy(xpath="//span[text()='Create a new order']")
	WebElement New_order;
	
	
	@FindBy(xpath="(//span[text()='Product']//following::div[@role='button'])[1]")
	WebElement Product_dropdown;
	
	@FindBy(xpath="//li[text()='Star Wars: Rogue One TIE Striker']")
	WebElement Product_option;
	
	@FindBy(xpath="//input[@placeholder='Link to an existing delivery address…']")
	WebElement deliveryaddress;
		
	
	@FindBy(xpath="(//span[text()='Shipped at']//following::input)[1]")
	WebElement Shippedat;
	
	@FindBy(xpath="(//span[text()='Being processed at']//following::input)[1]")
	WebElement Beingproceesedat;
	
	@FindBy(xpath="(//span[text()='Ready for shipping at']//following::input)[1]")
	WebElement Readyforshippingat;
			
	@FindBy(xpath="(//span[text()='In transit at']//following::input)[1]")
	WebElement intrasmitat;
	
	@FindBy(xpath="//input[@type='number']")
	WebElement Deliveryid;
	
	@FindBy(xpath="(//span[text()='Ref']//following::input)[1]")
	WebElement Ref;
	
	
	
	public CollectionPage() {
		PageFactory.initElements(UIUtilis.driver, this);
	}

	
	public void ordertheproduct() throws InterruptedException
	{
		Assert.assertEquals(true, waitfor(collectionmodule, "Collection Module"));
		Assert.assertEquals(true, click(collectionmodule, "Collection Module"));
		Assert.assertEquals(true, waitfor(customer_Micah, "Customer - Micah"));
		Assert.assertEquals(true, click(customer_Micah, "Customer - Micah"));
		Assert.assertEquals(true, waitfor(order_button, "Order button"));
		Assert.assertEquals(true, click(order_button, "Order button"));
		Assert.assertEquals(true, waitfor(Plus_button, "Plus button"));
		Assert.assertEquals(true, click(Plus_button, "Plus button"));
		Assert.assertEquals(true, waitfor(New_order, "Create a new Order button"));
		Assert.assertEquals(true, click(New_order, "Create a new Order button"));
		Thread.sleep(2000);
		Assert.assertEquals(true, waitfor(Product_dropdown, "Product dropdown button"));
		Assert.assertEquals(true, click(Product_dropdown, "Product dropdown button"));
		Thread.sleep(2000);
		Assert.assertEquals(true, waitfor(Product_option, "Star Wars: Rogue One TIE Striker Option"));
		Assert.assertEquals(true, click(Product_option, "Star Wars: Rogue One TIE Striker Option"));
		Assert.assertEquals(true, waitfor(deliveryaddress, "Delivery address"));
		Assert.assertEquals(true, typetext(deliveryaddress, "Chennai", "Delivery Address"));
		Assert.assertEquals(true, waitfor(Shippedat, "Shipped at calender"));
		Assert.assertEquals(true, jstypetext(Shippedat, "03/13/2022 8:33:26 PM", "Shipped at calender"));
		Thread.sleep(2000);
		Assert.assertEquals(true, waitfor(Beingproceesedat, "Being proceesed at"));
		Assert.assertEquals(true, jstypetext(Beingproceesedat, "03/13/2022 8:33:26 PM", "Being proceesed at"));
		Thread.sleep(2000);
		Assert.assertEquals(true, waitfor(intrasmitat, "in transmit at"));
		Assert.assertEquals(true, jstypetext(intrasmitat, "03/13/2022 8:33:26 PM", "in transmit at"));
		Thread.sleep(2000);
		Assert.assertEquals(true, waitfor(Readyforshippingat, "Ready for shipping at"));
		Assert.assertEquals(true, jstypetext(Readyforshippingat, "03/13/2022 8:33:26 PM", "Ready for shipping at"));
		Assert.assertEquals(true, waitfor(Deliveryid, "Delivery Id"));
		Assert.assertEquals(true, jstypetext(Deliveryid, "11111", "Delivery Id"));
		Assert.assertEquals(true, waitfor(Deliveryid, "Delivery Id"));
		Assert.assertEquals(true, jstypetext(Deliveryid, "11111", "Delivery Id"));
		Assert.assertEquals(true, waitfor(Ref, "Ref"));
		Assert.assertEquals(true, jstypetext(Ref, "Ref","Ref"));	
		Thread.sleep(10000);
		
	}
}
