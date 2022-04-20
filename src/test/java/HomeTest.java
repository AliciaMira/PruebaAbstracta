import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HomeTest {
    WebDriver driver;
    HomePage homePage;
    String articulo="camisetas";

    @Before
    public void setUp() throws InterruptedException {
        homePage=new HomePage(driver);
        driver=homePage.chromeDriverConnection();
        homePage.get("https://www.mercadolibre.com.ar/");
        homePage.waitUntilTitleVisible("Mercado Libre Argentina - Envíos Gratis en el día");
    }

    @Test
    public void testBuscarArticulo() throws InterruptedException {
        Thread.sleep(5000);
        homePage.acceptCookies();
        homePage.buscarArticulo(articulo);
        Assert.assertEquals(articulo.toUpperCase(), homePage.controlarMje());

        int cantPag=3;
        List<String> listaCompleta=new LinkedList<>();

        List<WebElement> listaTitulos;
        List<WebElement> listaPrecios;
        List<WebElement> listaLinks;
        String linea="";

        for (int j=1; j<=cantPag; j++) {
            listaTitulos = homePage.guardarListaTitulos();
            listaPrecios = homePage.guardarListaPrecios();
            listaLinks = homePage.guardarListaLinks();

            for (int i = 1; i < listaTitulos.size(); i++) {
                //Paso los webElements a la Lista Completa
                linea="Página: " + j + " Línea: " + i + " Titulo : " + listaTitulos.get(i).getText() +" Precio: " + listaPrecios.get(i).getText()+"\n"
                        + listaLinks.get(i).getAttribute("href");

                listaCompleta.add(linea);
            }
            Thread.sleep(2000);
            if (j<cantPag){
                homePage.nextPage();
            }
        }

        homePage.WriteFile(listaCompleta,"ResultadoBusqueda.txt");
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}