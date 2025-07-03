package org.example.ui.pages;

import org.example.ui.elements.UiElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreatePostPage extends PostEntityPage{
    private final WebDriver driver;

    private final By createPostPageTitle = By.xpath("//a[@href='/admin/resources/Post/actions/new']");

    @Autowired
    public CreatePostPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public UiElement createPublisherPageTitle() {
        return new UiElement(driver, createPostPageTitle);
    }
}