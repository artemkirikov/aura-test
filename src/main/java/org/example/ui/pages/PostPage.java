package org.example.ui.pages;

import org.example.ui.elements.UiElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostPage {
    private final WebDriver driver;

    private final By postPageTitle = By.xpath("//h2[contains(@class, 'adminjs_Header') and contains(@class, 'adminjs_H2') and text()='Show']");
    private final By editPostButton = By.xpath("//a[@data-testid='action-edit']");
    private final By postTitle = By.xpath("//section[@data-testid='property-show-title']//label[text()='Title']/following-sibling::text()[1]");
    private final By postStatus = By.xpath("//section[@data-testid='property-show-status']//label[text()='Status']/following-sibling::span[contains(@class, 'adminjs_Badge')]");

    @Autowired
    public PostPage(WebDriver driver) {
        this.driver = driver;
    }

    public UiElement postPageTitle() {
        return new UiElement(driver, postPageTitle);
    }

    public UiElement editPostButton(){
        return new UiElement(driver, editPostButton);
    }

    public UiElement postTitle(){
        return new UiElement(driver, postTitle);
    }

    public UiElement postStatus(){
        return new UiElement(driver, postStatus);
    }

}