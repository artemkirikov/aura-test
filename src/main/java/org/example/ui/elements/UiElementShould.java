package org.example.ui.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.TimeoutException;

public class UiElementShould extends UiElement{
    private final WebDriver driver;
    private final By locator;

    public UiElementShould(WebDriver driver, By locator) {
        super(driver, locator);
        this.driver = driver;
        this.locator = locator;
    }

    public UiElement beVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return this;
        } catch (TimeoutException e) {
            throw new AssertionError("Element don't exist or not visible by locator: " + locator, e);
        }
    }
} 