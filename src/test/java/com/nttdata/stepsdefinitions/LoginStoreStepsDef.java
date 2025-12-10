package com.nttdata.stepsdefinitions;

import com.nttdata.steps.LoginStoreSteps;
import io.cucumber.java.PendingException;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class LoginStoreStepsDef {

    private WebDriver driver;
    private LoginStoreSteps loginStoreSteps;

    public LoginStoreStepsDef() {
        this.driver = Hooks.getDriver();
    }

    @Dado("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/pe/iniciar-sesion");
        screenShot();
    }


    @Y("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String email, String password) {
        loginStoreSteps = new LoginStoreSteps(driver);
        loginStoreSteps.typeEmail(email);
        loginStoreSteps.typePassword(password);
        loginStoreSteps.clickLoginButton();
        screenShot();
    }





}
