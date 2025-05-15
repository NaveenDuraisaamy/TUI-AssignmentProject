package pages;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import java.time.Duration;
import utils.BaseTest;
import utils.ScrollActions;

public class DashboardPage extends BaseTest {
    private WebDriverWait wait;
    private ScrollActions scrollActions;
    private AppiumDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(DashboardPage.class);

    public DashboardPage(AppiumDriver driver) {
        super();
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.scrollActions = new ScrollActions();
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"top_app_bar_hotels_tab\")")
    private WebElement hotelButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"top_app_bar_holidays_tab\")")
    private WebElement holidayButton;

    public List<String> getAllHotels() {
        Set<String> uniqueHotels = new LinkedHashSet<>();
        int lastCount = 0;
        boolean keepScrolling = true;

        while (keepScrolling) {
         
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(//android.widget.TextView[@resource-id])[1]")));

            List<WebElement> visibleHotels = driver.findElements(By.xpath("(//android.widget.TextView[@resource-id])[1]"));

            for (WebElement hotel : visibleHotels) {
                try {
                    if (hotel.isDisplayed()) {
                        String hotelName = hotel.getText().trim();
                        if (!hotelName.isEmpty()) {
                            uniqueHotels.add(hotelName);
                        }
                    }
                } catch (Exception e) {
                }
            }

           
            scrollActions.scrollDown(driver);

          
            if (uniqueHotels.size() == lastCount) {
                keepScrolling = false;
            } else {
                lastCount = uniqueHotels.size();
            }
        }

        return new ArrayList<>(uniqueHotels);
    }

    public void allMenuList() {
        List<String> hotels = getAllHotels();
        System.out.println("Total All List: " + hotels.size());
        for (int i = 0; i < hotels.size(); i++) {
            System.out.println("Hotel " + (i + 1) + ": " + hotels.get(i));
        }
    }

    public void allHotelList() {
    	getAllHotels().clear();
        hotelButton.click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(//android.widget.TextView[@resource-id])[1]")));
        System.out.println("Total hotels List: " + getAllHotels().size());
    }

    public void allHolidayList() {
    	getAllHotels().clear();
        holidayButton.click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(//android.widget.TextView[@resource-id])[1]")));
        System.out.println("Total Holiday List: " + getAllHotels().size());
    }
}
