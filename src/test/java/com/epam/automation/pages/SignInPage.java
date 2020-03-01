package com.epam.automation.pages;

import com.epam.automation.model.HomePage;
import com.epam.automation.model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Srinivas Duggi on 9/24/2019
 * 24 May 2019 - now login returns HomePage class
 * 12 May 2019 - make login work with User object
 */
public class SignInPage {

    public static final String GITHUB_BASE_URL = "http://www.github.com";// не используется апер кейс и подчеркивание

    @FindBy(id = "login_field")
    private WebElement input1; // зачем нумеровать импут не понятно зачем это

    @FindBy(id = "password")
    private WebElement input2; // зачем нумеровать импут не понятно зачем это

    @FindBy(xpath = "//input[@value='Sign in']")
    private WebElement buttonSubmit; // зачем сдесь этот елемент если он не используется

    private WebDriver mDriver;

    public SignInPage(WebDriver mDriver) {
        this.mDriver = mDriver;
        PageFactory.initElements(mDriver, this);
    }

    public HomePage signIn(String username, String password){
        input1.sendKeys(username); // можно переписать на ввод юзер нейма и ввлд пароля изначально
        input2.sendKeys(password);
        buttonSubmit.click();
        return new HomePage(mDriver);
    }

    public boolean isReadyToSignIn() throws Exception {
        if (buttonSubmit.isDisplayed()){
            return true;
        }
        else {
            throw new Exception(); // какой есепшин
        }
    }

    public void open() {
        mDriver.get(GITHUB_BASE_URL);
    }

    public HomePage signIn(User user){
        return this.signIn(user.getUsername(), user.getPassword());
    }

}
