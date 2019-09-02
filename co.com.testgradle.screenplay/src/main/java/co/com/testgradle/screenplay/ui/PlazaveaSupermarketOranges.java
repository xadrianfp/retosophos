package co.com.testgradle.screenplay.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class PlazaveaSupermarketOranges {
	
	//Objeto checkbox para Happy Fruit
	public static final Target PLAZAVEA_HAPPY_FRUIT_OPTION = Target.the("Plazavea Oranges type product HAPPY FRUIT ").located(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Marca'])[2]/following::label[1]"));
	//Producto Naranja, botón Agregar del producto
	public static final Target PLAZAVEA_ADD_ORANGES = Target.the("Plazavea Oranges Add Orange product").located(By.cssSelector("div.Showcase__buttonWrapper__add"));
	
}
