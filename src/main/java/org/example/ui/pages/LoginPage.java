package org.example.ui.pages;

import org.example.ui.elements.UiElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LoginPage {
    private final WebDriver driver;

    private final By loginButton = By.xpath("//button[text()='Login']");

    @Value("${app.url}")
    private String appUrl;

    @Autowired
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(appUrl);
    }

    public UiElement loginButton() {
        return new UiElement(driver, loginButton);
    }

}