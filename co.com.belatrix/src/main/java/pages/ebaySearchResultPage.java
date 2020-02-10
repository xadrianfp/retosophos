package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ebaySearchResultPage {

	WebDriver driver;
		
	//Constructor de la pagina e inicia los elementos pagefactory
	public ebaySearchResultPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	//Filtro de la marca PUMA
	public void setBrandFilter() {
	    try {
	    	driver.findElement(By.xpath("//input[@aria-label='PUMA']")).click();
	      } catch (Error e) {
	        //verificationErrors.append(e.toString());
	      }
	}
	
	//Filtro de la talla del zapato
	public void setSizeFilter() {
	    try {
			driver.findElement(By.xpath("//input[@aria-label='10']")).click();
	      } catch (Error e) {
	        //verificationErrors.append(e.toString());
	      }
	}

	//Se obtiene y se imprime la cantidad de resultados al aplicar los filtros
	public String getResultOfSearching() {
		String result;
		result = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']//span[@class='BOLD'][1]")).getText();
    	return result;
	}

	/*
	 * Action
	 */
	//Se ordena la busqueda ascendentemente por precio	
	public void sortByPrice() {
	    try {
	    	driver.findElement(By.xpath("//div[@class='srp-controls--selected-value']")).click();
	    	driver.findElement(By.xpath("//ul[@class='srp-sort__menu']//li[@class='btn'][3]//a")).click();
	    	//driver.findElement(By.xpath("//ul[@class='srp-sort__menu']//li[@class='btn']//a//span[contains(text(),'Precio + Envío: más bajo primero')]")).click();
	    } catch (Error e) {
	        //verificationErrors.append(e.toString());
	      }
	}
	
	
	//Se obtiene el nombre del producto de la lista
	public String getProductName(int product) {
		String name;
		//Nombre producto
		name = driver.findElement(By.xpath("//li[@id='srp-river-results-listing"+product+"']//h3[@class='s-item__title']")).getText();
		return name;
	}


	//Se obtiene el precio del producto de la lista
	public String getProductPrice(int product) {
		String price;
		//Nombre producto
		price = driver.findElement(By.xpath("//li[@id='srp-river-results-listing"+product+"']//span[@class='s-item__price']")).getText();
		return price;
	}

	
	//Title JavaBook
	public String getTitleJavaBook() {
		String title;
	    try {
	    	title = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Add quantity to cart'])[1]/following::td[1]")).getText().toString();
	    	return title;
	      } catch (Error e) {
	        //verificationErrors.append(e.toString());
	    	  
	    	  return "fail";
	      }
	}
	//InStock JavaBook
	public String getInstockJavaBook() {
		String inStock;
		inStock = driver.findElement(By.xpath("//table[@id='listing']/tbody/tr[2]/td[2]")).getText();
    	return inStock;
	}
	
	//Cost JavaBook
	public String getCostJavaBook() {
		String cost;
		cost = driver.findElement(By.xpath("//table[@id='listing']/tbody/tr[2]/td[3]")).getText();
    	return cost;
	}
	
	//Quantity JavaBook
	public void setQuatityJavaBook(String strPaquete) {
	    driver.findElement(By.name("q")).clear();
	    driver.findElement(By.name("q")).sendKeys(strPaquete);
	}
	
	
	//Adicionar al carrito cantidad de libros
	public void clickAdd (){
		driver.findElement(By.xpath("//input[@value='Add']")).click();
	}
	
	//Borrar del carrito cantidad de libros
	public void clickClear (){
	    driver.findElement(By.xpath("//input[@value='Clear']")).click();
	}
	
	//Boton de logout
	public void clickLogout () {
		driver.findElement(By.xpath("//input[@value='Logout']")).click();
	}
	
		
	/*
	 * *Segundo Libro
	 */
	//Title Ruby
	public String getTitleRubyBook() {
		String title;
	    try {
	    	title = driver.findElement(By.xpath("//table[@id='listing']/tbody/tr[3]/td")).getText().toString();
	    	return title;
	      } catch (Error e) {
	        //verificationErrors.append(e.toString());
	    	  
	    	  return "fail";
	      }
	}
	//InStock Ruby
	public String getInstockRubyBook() {
		String inStock;
		inStock = driver.findElement(By.xpath("//table[@id='listing']/tbody/tr[3]/td[2]")).getText();
    	return inStock;
	}
	
	//Cost Ruby
	public String getCostRubyBook() {
		String cost;
		cost = driver.findElement(By.xpath("//table[@id='listing']/tbody/tr[3]/td[3]")).getText();
    	return cost;
	}
	
	//Quantity Ruby
	public void setQuatityRubyBook(String strPaquete) {
      driver.findElement(By.xpath("(//input[@name='q'])[2]")).clear();
      driver.findElement(By.xpath("(//input[@name='q'])[2]")).sendKeys(strPaquete);
	}
	
	
		
		//Page Title
		public String title () {
			String title = driver.getTitle();
			return title;
		}
				
	
		
}
