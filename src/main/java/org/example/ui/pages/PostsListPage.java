package org.example.ui.pages;

import org.example.ui.elements.UiElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostsListPage {
    private final WebDriver driver;

    private final By postPageTitle = By.xpath("//a[@href='/admin/resources/Post']");
    private final By createPostButton = By.xpath("//a[@data-testid='action-new']");

    @Autowired
    public PostsListPage(WebDriver driver) {
        this.driver = driver;
    }

    public UiElement postPageTitle() {
        return new UiElement(driver, postPageTitle);
    }

    public UiElement createPostButton(){
        return new UiElement(driver, createPostButton);
    }

    public UiElement postFromListByTitleButton(String title) {
        By locator = By.xpath(String.format("//tr[.//section[@data-testid='property-list-title' and text()='%s']]", title));
        return new UiElement(driver, locator);
    }

}