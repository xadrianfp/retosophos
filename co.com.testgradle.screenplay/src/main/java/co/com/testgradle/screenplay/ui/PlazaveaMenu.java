package co.com.testgradle.screenplay.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class PlazaveaMenu {
	
	//Opcion de menu supermercado
	public static final Target PLAZAVEA_MENU_SUPERMARKET = Target.the("Plazavea SUPERMARKET menu button").located(By.linkText("SUPERMERCADO"));
}
