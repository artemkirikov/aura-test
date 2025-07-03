package org.example.ui.pages;

import org.example.ui.elements.UiElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostEntityPage {
    private final WebDriver driver;

    private final By postTitleTextInput = By.xpath("//input[@id='title']");
    private final By postContentTextInput = By.xpath("//input[@id='content']");
    private final By postStatusDropDown = By.xpath("//div[contains(@class, 'css-uayuwa-Input')]");
    private final By postStatusActiveButton = By.xpath("//div[contains(@class, 'option') and text()='ACTIVE']");
    private final By postStatusRemovedButton = By.xpath("//div[contains(@class, 'option') and text()='REMOVED']");
    private final By postPublishedCheckBox = By.xpath("//input[@id='published']/following-sibling::a");
    private final By linkToPublisherDropDown = By.xpath("//section[@data-testid='property-edit-publisher']//div[contains(@class, 'css-uayuwa-Input')]");
    private final By savePostButton = By.xpath("//button[@data-testid='button-save']");

    @Autowired
    public PostEntityPage(WebDriver driver) {
        this.driver = driver;
    }

    public UiElement postTitleTextInput(){
        return new UiElement(driver, postTitleTextInput);
    }

    public UiElement postContentTextInput(){
        return new UiElement(driver, postContentTextInput);
    }

    public UiElement postStatusDropDown(){
        return new UiElement(driver, postStatusDropDown);
    }

    public UiElement postStatusActiveButton(){
        return new UiElement(driver, postStatusActiveButton);
    }

    public UiElement postStatusRemovedButton(){
        return new UiElement(driver, postStatusRemovedButton);
    }

    public UiElement postPublishedCheckBox(){
        return new UiElement(driver, postPublishedCheckBox);
    }

    public UiElement linkToPublisherDropDown(){
        return new UiElement(driver, linkToPublisherDropDown);
    }

    public UiElement publisherButtonByText(String text) {
        By locator = By.xpath(String.format("//div[contains(@class, 'option') and text()='%s']", text));
        return new UiElement(driver, locator);
    }

    public UiElement savePostButton(){
        return new UiElement(driver, savePostButton);
    }

}