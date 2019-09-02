package co.com.testgradle.screenplay.ui;

import co.com.testgradle.screenplay.tasks.GoTo;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class PlazaveaInformationToBuy {
	
	public static final Target PLAZAVEA_EMAIL = Target.the("Plazavea Email to Buy").located(By.name("email"));
	
	//Acepta las politicas
	public static final Target PLAZAVEA_ACEPT_TERMS = Target.the("Plazavea Accept Terms and Conditions").located(By.cssSelector("span.ModalEmail__checkmark"));
	//Boton Continuar
	public static final Target PLAZAVEA_BTN_CONTINUE = Target.the("Plazavea Continuar Button").located(By.cssSelector("button.ModalBasePreferences__button.ModalEmail__buttonNext"));

	
}
