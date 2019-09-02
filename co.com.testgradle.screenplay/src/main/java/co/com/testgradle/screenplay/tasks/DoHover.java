package co.com.testgradle.screenplay.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Hover;
import net.serenitybdd.screenplay.targets.Target;

public class DoHover implements Task {

	//Variable target para el objeto a recibir
	private Target menuOption;
	
	//Constructor que recibe el elemento web
	public DoHover (Target option) {
		this.menuOption = option;
	}
	
	@Override
	//Comportamiento del actor. El actor hace hover sobre el objeto recibido
	public <T extends Actor> void performAs(T actor) {
	
		actor.attemptsTo(Hover.over(menuOption));

	}
	
	//Haciendo uso de sustitucion de liskov. 
	//El hijo(OpenTheBrowser) sustituye al padre Performable
	//El comportamiento devuelve un objeto del tipo de la clase haciendo cargo de su responsabilidad
	
	public static DoHover theButton(Target option) {
	
		return instrumented(DoHover.class, option);		
	}

}
