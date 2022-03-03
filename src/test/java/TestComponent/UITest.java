package TestComponent;

import org.testng.Assert;
import org.testng.annotations.Test;

import EngineComponent.Runner;
import PagesComponent.CollectionPage;
import PagesComponent.DashboardPage;

public class UITest extends Runner {
	DashboardPage LP = new DashboardPage();
	CollectionPage ocp = new CollectionPage();
	
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
}
