package stepdefinitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;
import pages.DashboardPage;
import utils.BaseTest;

public class DashboardSteps {
	private AppiumDriver driver;
    private DashboardPage dashboard;

   
    public DashboardSteps() {
    	this.driver = BaseTest.getDriver();
        dashboard = new DashboardPage(driver);
    }

    @Then("user lands on dashboard page")
    public void dashboardList() throws InterruptedException {
    	dashboard.allMenuList();
        dashboard.allHotelList();
        dashboard.allHolidayList();
    }
}