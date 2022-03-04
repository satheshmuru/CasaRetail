package TestComponent;

import org.testng.Assert;
import org.testng.annotations.Test;

import EngineComponent.Runner;
import PagesComponent.CollectionPage;
import PagesComponent.DashboardPage;
import PagesComponent.FilterPage;

public class UITest extends Runner {
	@Test
	public void Scenarioone() throws InterruptedException {
		try {
			DashboardPage LP = new DashboardPage();
			LP.verfiydashboard();
			CollectionPage ocp = new CollectionPage();
			ocp.ordertheproduct();
		} catch (Exception | AssertionError e) {
			Assert.fail();
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void Scenariotwo() throws InterruptedException {
		try {
			DashboardPage LP = new DashboardPage();
			LP.verfiydashboard();
			FilterPage fp = new FilterPage();
			fp.filterandsorting();
		} catch (Exception | AssertionError e) {
			Assert.fail();
			e.printStackTrace();
		}
	}
}
