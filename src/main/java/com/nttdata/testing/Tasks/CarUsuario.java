package com.nttdata.testing.Tasks;

import com.nttdata.testing.Pages.HomePage;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Attribute;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CarUsuario implements Task {
    private final String nameProduct;

    public CarUsuario(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Target productTarget = Target.the("Producto")
                .located(By.xpath("//a[text()='" + nameProduct + "']"));
    }

    public static CarUsuario of(String nameProduct) {
        return new CarUsuario(nameProduct);
    }
}
