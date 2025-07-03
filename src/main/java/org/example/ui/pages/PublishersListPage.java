package org.example.ui.pages;

import org.example.ui.elements.UiElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PublishersListPage {
    private final WebDriver driver;

    private final By publisherPageTitle = By.xpath("//section[contains(@class, 'adminjs_Breadcrumbs') and @data-css='Publisher-list-breadcrumbs']");
    private final By createPublisherButton = By.xpath("//a[contains(@class, 'adminjs_ButtonGroupItem') and contains(@class, 'adminjs_Button') and @data-testid='action-new']");


    @Autowired
    public PublishersListPage(WebDriver driver) {
        this.driver = driver;
    }

    public UiElement publisherPageTitle() {
        return new UiElement(driver, publisherPageTitle);
    }

    public UiElement createPublisherButton(){
        return new UiElement(driver, createPublisherButton);
    }

}