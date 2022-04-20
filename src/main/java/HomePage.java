import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class HomePage extends Base{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    By textLocator = By.name("as_word");
    By searchBtn=By.cssSelector("button.nav-search-btn");
    By articulosLocator=By.className("ui-search-result__wrapper");
    By titulosLocator=By.cssSelector("h2.ui-search-item__title");
    By preciosLocator=By.xpath("//div/span/span/span [@class='price-tag-fraction']");
    By linksLocator=By.cssSelector(".ui-search-item__group__element.ui-search-link");
    By rdoLocator=By.xpath("//h1");
    By nextLocator=By.cssSelector ("a[role='button'][title='Siguiente']");
    By acceptCookies =By.xpath("//button[@type='button'] [contains(.,'Entendido')]");

    public void buscarArticulo(String articulo)  {
        clear(textLocator);
        sendKeys(textLocator, articulo);
        click(searchBtn);
    }

    public void nextPage(){

        //Implicit Wait
        //waitNSeconds(5);
        //Explicit wait
        waitUntilClickleable(nextLocator);
        waitNSeconds(10);
        click(nextLocator);
    }

    public List<WebElement> guardarListaArticulos(){
        List<WebElement> listaArticulos=findElements(articulosLocator);
        return listaArticulos;
    }

    public List<WebElement> guardarListaTitulos(){
        List<WebElement> listaArticulos=findElements(titulosLocator);
        return listaArticulos;
    }

    public List<WebElement> guardarListaPrecios(){
        List<WebElement> listaPrecios=findElements(preciosLocator);
        return listaPrecios;
    }

    public List<WebElement> guardarListaLinks(){
        List<WebElement> listaLinks=findElements(linksLocator);
        return listaLinks;
    }

    public String controlarMje(){
        return getText(rdoLocator).toUpperCase();
    }

    public void acceptCookies(){
        click(acceptCookies);
    }
}
