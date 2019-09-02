package co.com.testgradle.screenplay.stepdefinitions;

import org.openqa.selenium.WebDriver;

import co.com.testgradle.screenplay.tasks.DoHover;
import co.com.testgradle.screenplay.tasks.FillInformationTo;
import co.com.testgradle.screenplay.tasks.GoTo;
import co.com.testgradle.screenplay.tasks.OpenTheBrowser;
import co.com.testgradle.screenplay.ui.PlazaveaHomePage;
import co.com.testgradle.screenplay.ui.PlazaveaInformationToBuy;
import co.com.testgradle.screenplay.ui.PlazaveaMenu;
import co.com.testgradle.screenplay.ui.PlazaveaSupermarket;
import co.com.testgradle.screenplay.ui.PlazaveaSupermarketOranges;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Managed;

public class SophosComprarPlazaveaStepDefinitios {
	
	@Managed(driver = "chrome")
	//Se instancia el driver 
	private WebDriver hisBrowser;
	private Actor adrian = Actor.named("adrian");
	private PlazaveaHomePage plazaveaHomePage;
	
	@Before
	public void setUp() {
		adrian.can(BrowseTheWeb.with(hisBrowser));
		
	}
	
	@Given("^that adrian wants to go to Plazavea in the supermarket section$")
	public void thatAdrianWantsToGoToPlazaveaInTheSupermarketSection() throws Exception {
		//Preconditions: Login and to be in the main page
		
		//Vamos a la pagina principal
		adrian.wasAbleTo(OpenTheBrowser.on(plazaveaHomePage));
		//Accedemos al menu principal de supermercado
		adrian.wasAbleTo(GoTo.theOption(PlazaveaMenu.PLAZAVEA_MENU_SUPERMARKET));
		//Maximizamos la ventana
		hisBrowser.manage().window().maximize();
		
	}


	@When("^he goes to fruits section$")
	public void heGoesToFruitsSection() throws Exception {
		//Vamos a la opcion de menu Naranjas y mandarinas del menu supermercado
		adrian.attemptsTo(GoTo.theOption(PlazaveaSupermarket.PLAZAVEA_SUPER_ORANGES));

	}

	@And("^he adds an orange on oranges page$")
	public void heAddsAnOrangeOnOrangesPage() throws Exception {
		
		//Seleccionamos la opcion Happy Fruit de las opciones de productos
		adrian.attemptsTo(GoTo.theOption(PlazaveaSupermarketOranges.PLAZAVEA_HAPPY_FRUIT_OPTION));
		//Activamos el boton al hacerle hover over
		adrian.attemptsTo(DoHover.theButton(PlazaveaSupermarketOranges.PLAZAVEA_ADD_ORANGES));
		//Damos clic en el boton activado
		adrian.attemptsTo(GoTo.theOption(PlazaveaSupermarketOranges.PLAZAVEA_ADD_ORANGES));


	}
	
	@And("^he fills the email to buy with (.*)$")
	public void heFillsTheEmailToBuyWith(String email) throws Exception {
		
		//Ingresa el correo en la ventana de compra
		adrian.attemptsTo(FillInformationTo.buyProduct(PlazaveaInformationToBuy.PLAZAVEA_EMAIL, email));

	}
	


	@Then("^i should see the product orange in the shoppingcar$")
	public void iShouldSeeTheProductOrangeInTheShoppingcar() throws Exception {

		//Acepta las politicas
		adrian.attemptsTo(GoTo.theOption(PlazaveaInformationToBuy.PLAZAVEA_ACEPT_TERMS));
		//Presiona Continuar
		adrian.attemptsTo(GoTo.theOption(PlazaveaInformationToBuy.PLAZAVEA_BTN_CONTINUE));

	}


}
