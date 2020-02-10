package test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

import pages.eBayMainPage;
import pages.ebaySearchResultPage;

import org.openqa.selenium.support.ui.ExpectedConditions;

public class searchProductMain {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  
  String baseUrl = "";

  public String srtName;
  String strTxtSearching;
  String strTxtAmount;
  String testCase;
  WebDriver driver;
  public String mainPath = "C:\\eclipse\\Resources\\";
  public String browser = "Firefox"; //"IE" � Chrome � Firefox
  

  @Before
  public void setUp() throws Exception {
    //driver = new FirefoxDriver();
    
	 
	 //String browser = "Firefox"; //"IE" � Chrome � Firefox
	// driver = utilities.DriverFactory.open(mainPath, browser);

    //System.setProperty("webdriver.chrome.driver","C:\\eclipse\\Resources\\chromedriver.exe");
    //driver = new ChromeDriver();

    baseUrl = "https://www.ebay.com/";
    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCapacitacion() throws Exception {
	  
		//String fileName = System.getProperty("user.dir")+"\\Datos.xls";//, "DataDriven";
		//String [][] data = utilities.Excel.get(fileName);
		String testCase = "";
		String strTxtSearching = "";
		String strTxtAmount = "";
		String strName = "";
		int i = 0;
		mainPath = System.getProperty("user.dir")+"\\resources\\";
		browser = "Firefox"; //"IE" � Chrome � Firefox
		String strProduct1 = "Puma Adultos Unisex POPCAT";
		String strProduct2 = "Puma Golf para hombres Bunki";
		String strProduct3 = "Puma Hombres plomo Cat";
		String strProduct4 = "Puma Para Hombre Plomo Gato";
		String strProduct5 = "Puma Para Hombre Plomo Gato";

		
		System.out.println("El usuario se encuentra en la pagina principal");
  	    driver = utilities.DriverFactory.open(mainPath, browser);
		System.out.println("Abre el navegador");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
		driver.manage().window().maximize();  //maximizo mi browser
		
		
		//Inicio del caso	 
		strTxtSearching = "shoes";
		
		eBayMainPage searchPage = new eBayMainPage(driver);
		System.out.println("Estamos en la página:" + searchPage.title());
		
		//Realiza la busqueda deseada
		searchPage.search(strTxtSearching);
		Thread.sleep(2000);
		
		ebaySearchResultPage pageBusqueda = new ebaySearchResultPage(driver);
		System.out.println("Estamos en la página:" + pageBusqueda.title());
		
		//Se aplica el filtro de la marca
		pageBusqueda.setBrandFilter();
		//driver.findElement(By.xpath("//input[@aria-label='PUMA']")).click();
		Thread.sleep(2000);
		
		//Se aplica el filtro de la talla
		pageBusqueda.setSizeFilter();
		//driver.findElement(By.xpath("//input[@aria-label='10']")).click();
		Thread.sleep(4000);
		
		
		
		//Se obtiene y se imprime la cantidad de resultados al aplicar los filtros
		strTxtAmount=pageBusqueda.getResultOfSearching();
				//driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']//span[@class='BOLD'][1]")).getText();
		//assertThat(driver.findElement(By.cssSelector(".srp-controls__count-heading > .BOLD:nth-child(1)")).getText(), is("5,283"));
		System.out.println("La cantidad de resultados de la búsqueda filtrada es: "+strTxtAmount);
		Thread.sleep(4000);
		
		
		//Se ordena la búsqueda ascendentemente por precio		
		pageBusqueda.sortByPrice();
		Thread.sleep(4000);
		
		//Se obtiene el producto y el precio del resultado 1
			//Nombre producto
		i++;
		strName=pageBusqueda.getProductName(i);
		//Puma Adultos Unisex POPCAT Verano Playa Deportes Correa Diapositiva Sandalias Zapatos Blanco..
			//Precio producto
		strTxtAmount=pageBusqueda.getProductPrice(i);
		System.out.println("El producto " +i+ " es: "+strName+" y el precio es: "+strTxtAmount);
		assertThat(strName, containsString(strProduct1));
		
		//Se obtiene el producto y el precio del resultado 2
			//Nombre producto
		i++;
		strName=pageBusqueda.getProductName(i);
		//Puma Adultos Unisex leadcat Verano Playa Deportes Correa Diapositiva Sandalias Zapatos Negro.
			//Precio producto
		strTxtAmount=pageBusqueda.getProductPrice(i);
		System.out.println("El producto " +i+ " es: "+strName+" y el precio es: "+strTxtAmount);
		assertThat(strName, containsString(strProduct2));
		
		//Se obtiene el producto y el precio del resultado 3
			//Nombre producto
		i++;
		strName=pageBusqueda.getProductName(i);
		//Puma Golf para hombres Bunki Chanclas Sandalias Piscina Zapatos blanco flecos
			//Precio producto
		strTxtAmount=pageBusqueda.getProductPrice(i);
		System.out.println("El producto " +i+ " es: "+strName+" y el precio es: "+strTxtAmount);
		assertThat(strName, containsString(strProduct3));
		
		//Se obtiene el producto y el precio del resultado 4
			//Nombre producto
		i++;
		strName=pageBusqueda.getProductName(i);
		//Puma Hombres plomo Cat FTR Slipper Zapatillas Sandalias de diapositivas de playa de menta 37227603
			//Precio producto
		strTxtAmount=pageBusqueda.getProductPrice(i);
		System.out.println("El producto " +i+ " es: "+strName+" y el precio es: "+strTxtAmount);
		assertThat(strName, containsString(strProduct4));
		
		//Se obtiene el producto y el precio del resultado 5
			//Nombre producto
		i++;
		strName=pageBusqueda.getProductName(i);
		//Puma Para Hombre Plomo Gato FTR Zapatillas Running Shoes White Playa Sandalias de diapositiva 37227602
			//Precio producto
		strTxtAmount=pageBusqueda.getProductPrice(i);
		System.out.println("El producto " +i+ " es: "+strName+" y el precio es: "+strTxtAmount);
		assertThat(strName, containsString(strProduct5));
		
		driver.quit();
		
  }

  @After
  public void tearDown() throws Exception {
    //driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
