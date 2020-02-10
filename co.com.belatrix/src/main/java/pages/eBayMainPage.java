package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class eBayMainPage {
	
	//Usando PageFactory para algunos elementos
	WebDriver driver;
	
	//Texto del Usuario
	//@FindBy(className="//input[@id='gh-ac']")
	@FindBy(id="gh-ac")
	WebElement searchingBox;
	
	@FindBy(id="gh-btn")
	////input[@id='gh-btn']
	WebElement btnSearching;
	
	
	//Constructor de la pagina e inicia los webelements del pagefactory
	public eBayMainPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * Steps
	 */
	//Usuario
	public void setSearching(String strTxtSearching) {
	    //Borro el campo e ingreso la búsqueda
		searchingBox.clear();
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		searchingBox.sendKeys(strTxtSearching);
	}
	
	
	//Boton de busqueda
	public void clickSubmit () {
		btnSearching.click();
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
	}
	
	
	
	
	//Page Title
	public String title () {
		String title = driver.getTitle();
		return title;
	}
	
	/*
	 * Actions
	 */
	//Login
	public void search (String txtSearch) {
		setSearching(txtSearch);
		clickSubmit();
	}
	
}
