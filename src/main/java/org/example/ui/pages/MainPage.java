package org.example.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.example.ui.elements.UiElement;

@Component
public class MainPage {
    private final WebDriver driver;
    
    private final By welcomeMessage = By.xpath("//h2[contains(@class, 'adminjs_Header') and contains(@class, 'adminjs_H2')]");
    private final By happyFolderButton = By.xpath("//a[contains(@class, 'adminjs_Box')]//div[text()='Happy Folder']/parent::a");
    private final By publisherButton = By.xpath("//*[text()='Publisher']");
    private final By profileItem = By.xpath("//*[text()='Profile']");
    private final By postItem = By.xpath("//*[text()='Post']");

    @Autowired
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public UiElement welcomeMessage() {
        return new UiElement(driver, welcomeMessage);
    }

    public UiElement happyFolderButton() {
        return new UiElement(driver, happyFolderButton);
    }

    public UiElement publisherButton() {
        return new UiElement(driver, publisherButton);
    }

    public UiElement profileItem() {
        return new UiElement(driver, profileItem);
    }

    public UiElement postItem() {
        return new UiElement(driver, postItem);
    }

}