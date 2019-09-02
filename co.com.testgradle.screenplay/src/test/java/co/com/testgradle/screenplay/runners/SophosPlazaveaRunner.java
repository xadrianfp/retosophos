package co.com.testgradle.screenplay.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(
		//Permite limpiar la consola de informacion irrelevante y de caracteres basura.
		monochrome=true,
		//Al poner la opcion dryRun en true permite ejecutar sin abrir navegador para observar posibles errores
		dryRun=false,
		//Ubicacion del archivo(s) .feature que contiene las historias, para utilizar varios se deben utilizar {"",""}
		features="src/test/resources/features/sophos_comprar_plazavea.feature",
		//Ubicacion de las clases que contienen la implementacion de los pasos
		glue="co.com.testgradle.screenplay.stepdefinitions",
		snippets = SnippetType.CAMELCASE
		//,
		//tags= {" @Basico"},
		//plugin= {"pretty","html:target/cucumber-htmlreport",
		//			"json:target/cucumber-report.json",
		//			"com.cucumber.listener.ExtentCucumberFormatter:target/ExtendReport.html"}
		
		)

public class SophosPlazaveaRunner {

}
