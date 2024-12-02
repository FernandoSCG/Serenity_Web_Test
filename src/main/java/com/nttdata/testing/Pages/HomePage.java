package com.nttdata.testing.Pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Attribute;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.Actor;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

@DefaultUrl("https://www.demoblaze.com/")
public class HomePage extends PageObject {

    private static int idProduct;

    public static final Target BTN_SIGN_UP = Target.the("Boton para hacer el registro").located(By.id("signin2"));
    public static final Target REGISTER_MODAL = Target.the("Modal de registro").located(By.id("signInModalLabel"));
    public static final Target INP_USERNAME = Target.the("Nombre de usuario").located(By.id("sign-username"));
    public static final Target INP_PASSWORD = Target.the("Contraseña").located(By.id("sign-password"));
    public static final Target BTN_REGISTRAR = Target.the("Boton Registrar").located(By.xpath("//button[text()='Sign up']"));
    public static final Target BTN_LOGEO = Target.the("Boton Logear").located(By.xpath("//button[text()='Log in']"));
    public static final Target BTN_LOGIN = Target.the("Boton para iniciar sesion").located(By.id("login2"));
    public static final Target RGT_USERNAME = Target.the("Nombre de usuario").located(By.id("loginusername"));
    public static final Target RGT_PASSWORD = Target.the("Contraseña").located(By.id("loginpassword"));
    public static final Target BTN_NEXT= Target.the("Botón Next para cargar más productos").located(By.id("next2"));



    public static Target productById(String nameProduct) {
        boolean isProductVisible = Target.the("Producto").located(By.xpath("//a[text()='" + nameProduct + "']")).resolveFor(theActorInTheSpotlight()).isVisible();
        if (isProductVisible) {
            String productUrl = Target.the("Producto")
                    .located(By.xpath("//a[text()='" + nameProduct + "']"))
                    .resolveFor(theActorInTheSpotlight())
                    .getAttribute("href");
            String productId = productUrl.split("idp_=")[1];
            setIdProduct(Integer.parseInt(productId));
            return Target.the("Producto").located(By.xpath("//a[text()='" + nameProduct + "']"));
        } else {
            theActorInTheSpotlight().attemptsTo(Click.on(HomePage.BTN_NEXT));
            String productUrl = Target.the("Producto")
                    .located(By.xpath("//a[text()='" + nameProduct + "']"))
                    .resolveFor(theActorInTheSpotlight())
                    .getAttribute("href");
            String productId = productUrl.split("idp_=")[1];
            setIdProduct(Integer.parseInt(productId));
            return Target.the("Producto").located(By.xpath("//a[text()='" + nameProduct + "']"));

        }
    }

    public static Target cardById() {
        return Target.the("Carrito").located(By.xpath("//a[@onclick='addToCart("+ getIdProduct() + ")']"));
    }

    public static int getIdProduct() {
        return idProduct;
    }

    public static void setIdProduct(int idProduct) {
        HomePage.idProduct = idProduct;
    }
}
