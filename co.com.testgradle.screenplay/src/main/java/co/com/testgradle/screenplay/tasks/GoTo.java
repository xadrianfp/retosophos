package co.com.testgradle.screenplay.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.testgradle.screenplay.ui.PlazaveaMenu;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Hover;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;


public class GoTo implements Task {
	
	private Target menuOption;
	
	//Constructor de la clase que fija el campo o elemento
	public GoTo (Target option) {
		this.menuOption = option;
	}
	
	//Sobrescribimos el comportamiento para dar clic en un elemento
	@Override
	//Mas informacion para el informe acerca de la tarea que estamos ejecutando
	@Step("{0} goes to the menu option in Plazavea") 
	public <T extends Actor> void performAs(T actor) {
	
		actor.attemptsTo(Click.on(menuOption));
		
		//Open, Click, Enter, Hit
	}
	
	//Comportamiento que devuelve un objeto del tipo clase GoTo
	public static GoTo theOption(Target option) {

		return instrumented(GoTo.class, option);		
	}
	

}
