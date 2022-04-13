import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Base{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    By textLocator = By.name("as_word");
    By searchBtn=By.cssSelector("button.nav-search-btn");
    By articulosLocator=By.className("ui-search-result__wrapper");
    By rdoLocator=By.xpath("//h1");

    public void buscarArticulo(String articulo){
        clear(textLocator);
        sendKeys(textLocator, articulo);
        click(searchBtn);
    }

    public List<WebElement> guardarListaArticulos(){
        List<WebElement> listaArticulos=findElements(articulosLocator);
        return listaArticulos;
    }

    public String controlarMje(){
        return getText(rdoLocator);
    }

}
