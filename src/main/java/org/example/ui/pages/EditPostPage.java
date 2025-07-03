package org.example.ui.pages;

import org.example.ui.elements.UiElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EditPostPage extends PostEntityPage{
    private final WebDriver driver;

    private final By editPostPageTitle = By.xpath("//h2[contains(@class, 'adminjs_Header') and contains(@class, 'adminjs_H2') and text()='Edit']");

    @Autowired
    public EditPostPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public UiElement editPostPageTitle() {
        return new UiElement(driver, editPostPageTitle);
    }
}