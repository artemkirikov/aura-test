package org.example.ui.pages;

import org.example.ui.elements.UiElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreatePublisherPage {
    private final WebDriver driver;

    private final By createPublisherPageTitle = By.xpath("//a[@href='/admin/resources/Publisher/actions/new']");
    private final By publisherNameTextInput = By.xpath("//input[contains(@class, 'adminjs_Input') and @name='name']");
    private final By publisherEmailTextInput = By.xpath("//input[contains(@class, 'adminjs_Input') and @name='email']");
    private final By savePublisherButton = By.xpath("//button[@data-testid='button-save']");

    @Autowired
    public CreatePublisherPage(WebDriver driver) {
        this.driver = driver;
    }

    public UiElement createPublisherPageTitle() {
        return new UiElement(driver, createPublisherPageTitle);
    }

    public UiElement publisherNameTextInput(){
        return new UiElement(driver, publisherNameTextInput);
    }

    public UiElement publisherEmailTextInput(){
        return new UiElement(driver, publisherEmailTextInput);
    }

    public UiElement savePublisherButton(){
        return new UiElement(driver, savePublisherButton);
    }

}