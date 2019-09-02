package co.com.testgradle.screenplay.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.Hover;
import net.serenitybdd.screenplay.targets.Target;

public class FillInformationTo implements Task{
	
	private Target field;
	private String value;
	
	//Constructor de la clase que fija el campo y el valor
	public FillInformationTo (Target field, String value) {
		this.field = field;
		this.value = value;
	}
	
	//Sobrescribimos para escribir el valor recibido en un elemento
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Enter.theValue(value).into(field));
		
		//Open, Click, Enter, Hit
	}
	
	//Devuelve un objeto de su clase
	public static FillInformationTo buyProduct(Target field, String value) {
	
		return instrumented(FillInformationTo.class, field, value);		
	}
}
