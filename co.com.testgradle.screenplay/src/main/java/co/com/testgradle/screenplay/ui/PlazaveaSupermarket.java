package co.com.testgradle.screenplay.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class PlazaveaSupermarket {

	//Opcion de menu de naranjas y mandarinas
	public static final Target PLAZAVEA_SUPER_ORANGES = Target.the("Plazavea SUPERMARKET Oranges menu option").located(By.cssSelector("div.MainMenu__subcategory__section > ul > li > a"));
	
}
