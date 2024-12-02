package com.nttdata.testing.stepDefinition;

import com.nttdata.testing.Pages.HomePage;
import com.nttdata.testing.Tasks.CarUsuario;
import com.nttdata.testing.Tasks.NavigateTo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.messages.types.Product;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RegistarUsuarioStepDefinition {

    @Given("el {actor} esta en la pagina de inicio")
    public void elUsuarioEstaEnLaPaginaDeInicio(Actor actor) {

        actor.attemptsTo(NavigateTo.theHomePage());
    }

    @And("selecciona el boton de registro")
    public void seleccionaElBotonDeRegistro() {

        theActorInTheSpotlight().attemptsTo(Click.on(HomePage.BTN_SIGN_UP));
    }

    @And("ingresa nombre de usuario {string} y contraseña {string}")
    public void ingresaNombreDeUsuarioYContraseña(String username, String password) {
        theActorInTheSpotlight().attemptsTo(Enter.theValue(username).into(HomePage.INP_USERNAME));
        theActorInTheSpotlight().attemptsTo(Enter.theValue(password).into(HomePage.INP_PASSWORD));


    }

    @And("selecciona el boton de registrar")
    public void seleccionaElBotonDeRegistrar() {
        theActorInTheSpotlight().attemptsTo(Click.on(HomePage.BTN_REGISTRAR));
    }


    @Then("se realiza el registro de manera exitosa")
    public void seRealizaElRegistroDeManeraExitosa() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("selecciona el boton de logeo")
    public void seleccionaElBotonDeLogeo() {
        theActorInTheSpotlight().attemptsTo(Click.on(HomePage.BTN_LOGIN));
    }

    @And("selecciona el boton de logear")
    public void seleccionaElBotonDeLogear() {
        theActorInTheSpotlight().attemptsTo(Click.on(HomePage.BTN_LOGEO));
    }

    @And("ingresa nombre de usuario {string} y contraseña {string} en el login")
    public void ingresaNombreDeUsuarioYContraseñaEnElLogin(String username, String password) {
        theActorInTheSpotlight().attemptsTo(Enter.theValue(username).into(HomePage.RGT_USERNAME));
        theActorInTheSpotlight().attemptsTo(Enter.theValue(password).into(HomePage.RGT_PASSWORD));
    }

    @Then("se realiza el logeo de manera exitosa")
    public void seRealizaElLogeoDeManeraExitosa() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("selecciona producto con nombre {string}")
    public void seleccionaProductoConNombre(String nameProducto) {
        theActorInTheSpotlight().attemptsTo(Click.on(HomePage.productById(nameProducto)));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("agrega al carrito")
    public void agregaAlCarrito() {
        theActorInTheSpotlight().attemptsTo(Click.on(HomePage.cardById()));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
