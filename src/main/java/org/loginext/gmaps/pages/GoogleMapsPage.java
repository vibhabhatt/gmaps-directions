package org.loginext.gmaps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class GoogleMapsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By directionsButton = By.xpath("//*[@id='omnibox-singlebox']//button[@aria-label='Directions']");
    private final By fromInput = By.xpath("//*[@id='omnibox-directions']//input[@placeholder='Choose starting point, or click on the map...']");
    private final By toInput = By.xpath("//*[@id='omnibox-directions']//input[@placeholder='Choose destination, or click on the map...']");
    private final By searchedFrom = By.xpath("//*[@id='omnibox-directions']//span[text()='Riddhi Gardens']");
    private final By searchedTo = By.xpath("//*[@id='omnibox-directions']//span[text()='91Springboard Vikhroli']");
    private final By tripOption = By.xpath("//div[@data-trip-index='0']");
    private final By directionsTextElements = By.cssSelector("[id^='directions-mode-group-title_0_']");

    public GoogleMapsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openDirections() {
        driver.findElement(directionsButton).click();
    }

    public void enterFromLocation(String fromLocation) {
        WebElement fromBox = wait.until(ExpectedConditions.visibilityOfElementLocated(fromInput));
        fromBox.sendKeys(fromLocation);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchedFrom)).click();
    }

    public void enterToLocation(String toLocation) {
        WebElement toBox = wait.until(ExpectedConditions.visibilityOfElementLocated(toInput));
        toBox.sendKeys(toLocation);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchedTo)).click();
    }

    public void selectFirstTripOption() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tripOption)).click();
    }

    public List<String> getDirectionsText() {
        List<WebElement> elements = driver.findElements(directionsTextElements);
        List<String> directions = new ArrayList<>();
        for (WebElement element : elements) {
            directions.add(element.getText());
        }
        return directions;
    }
}
