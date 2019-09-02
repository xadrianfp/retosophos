package co.com.testgradle.screenplay.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class OpenTheBrowser implements Task {
	
	private PageObject page;
	
	//Constructor de la clase que fija la pagina recibida
	public OpenTheBrowser (PageObject page) {
		this.page = page;
	}
	
	//Comportamiento que abre una pagina recibida
	@Override
	//Mas informacion para el informe acerca de la tarea que estamos ejecutando
	@Step("{0} opens a page of Plazavea") 
	public <T extends Actor> void performAs(T actor) {
		
		actor.attemptsTo(Open.browserOn(page));
	}
	
	//Haciendo uso de sustitucion de liskov. 
	//Devuelve un objeto de la clase
	public static OpenTheBrowser on(PageObject page) {
		//Permite crear una instancia y se utiliza para la creacion del informe, debug, hallazgo de errores en tareas
		return instrumented(OpenTheBrowser.class, page);		
	}

}
