package org.example.ui.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class UiElement {
    private final WebDriver driver;
    private final By locator;

    public UiElement(WebDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
    }

    public UiElementShould should() {
        return new UiElementShould(driver, locator);
    }

    public void click() {
        driver.findElement(locator).click();
    }

    public String getText() {
        return driver.findElement(locator).getText();
    }

    public UiElement sendText(String text) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
        return this;
    }
} 