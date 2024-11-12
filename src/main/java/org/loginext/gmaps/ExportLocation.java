package org.loginext.gmaps;

import org.loginext.gmaps.pages.GoogleMapsPage;
import org.loginext.gmaps.utils.GoogleMapsUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ExportLocation {
    public void exportToSheet(String url, String from, String to) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        GoogleMapsPage googleMapsPage = new GoogleMapsPage(driver);

        googleMapsPage.openDirections();
        googleMapsPage.enterFromLocation(from);
        Thread.sleep(3000L); // Sometime the destiation placehold is not visible
        googleMapsPage.enterToLocation(to);
        googleMapsPage.selectFirstTripOption();

        List<String> directions = googleMapsPage.getDirectionsText();
        GoogleMapsUtils.write(directions, "directions.xlsx");
        GoogleMapsUtils.takeScreenshot(driver, "destination.png");
        driver.quit();
    }
}
