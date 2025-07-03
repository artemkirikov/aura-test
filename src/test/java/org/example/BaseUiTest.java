package org.example;

import org.example.config.UiMainConfiguration;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = UiMainConfiguration.class)
public abstract class BaseUiTest {

    @Autowired
    protected WebDriver driver;
} 