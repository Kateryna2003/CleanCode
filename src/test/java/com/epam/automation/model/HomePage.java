package com.epam.automation.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Srinivas Duggi on 9/24/2019
 */
public class HomePage {

    public static final String GithubBaseUrl = "http://www.github.com";//нельзя использовать нижнее подчеркивание и аперкейс

    @FindBy(xpath = "//button[@aria-label='Switch account context']/span")
    private WebElement linkLoggedInUser;// это нигде не используется, проще обьявить в методе

    private final WebDriver driver;

    /*
    Constructor
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(GithubBaseUrl);
    }

    public String getLoggedInUserName() {
        return linkLoggedInUser.getText();
    }

    public Integer hasUserLoggedIn() {
        if (linkLoggedInUser.getText() != "") {
            return 1;
        } else {
            return -1; //лучше переписать одной строкой так как метод не юзается
        }
    }
}
