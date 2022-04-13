import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class HomeTest {
    WebDriver driver;
    HomePage homePage;
    String articulo="Camisetas";

    @Before
    public void setUp() throws InterruptedException {
        homePage=new HomePage(driver);
        driver=homePage.chromeDriverConnection();
        homePage.get("https://www.mercadolibre.com.ar/");
        Thread.sleep(2000);
    }
    @Test
    public void testBuscarArticulo() {
        homePage.buscarArticulo(articulo);
        Assert.assertEquals(articulo, homePage.controlarMje());
        List<WebElement> listaArticulos= homePage.guardarListaArticulos();
        homePage.WriteFile(listaArticulos,"ResultadoBusqueda.txt");
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}