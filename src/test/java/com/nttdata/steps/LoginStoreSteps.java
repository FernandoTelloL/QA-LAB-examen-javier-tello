package com.nttdata.steps;

import com.nttdata.page.LoginStorePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginStoreSteps {
    private final WebDriver driver;

    public LoginStoreSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void typeEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailElement = wait.until(ExpectedConditions.elementToBeClickable(LoginStorePage.emailInput));
        emailElement.sendKeys(email);
    }

    public void typePassword(String password) {
        WebElement passwordElement = driver.findElement(LoginStorePage.passwordInput);
        passwordElement.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(LoginStorePage.loginButton);
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("return document.readyState").equals("complete"));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
