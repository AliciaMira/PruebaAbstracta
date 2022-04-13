import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.io.*;

public class Base {
    private WebDriver driver;
    public Base (WebDriver driver){
        this.driver=driver;
    }

    public WebDriver chromeDriverConnection(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }
    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }
    public void sendKeys(By locator, String text){
        driver.findElement(locator).sendKeys(text);
    }
    public void clear(By locator){
        driver.findElement(locator).clear();
    }
    public String getText(By locator){
        return driver.findElement(locator).getText();
    }
    public String getText(WebElement element){
        return element.getText();
    }
    public void click (By locator){
        driver.findElement(locator).click();
    }
    public void click (WebElement element){
        element.click();
    }
    public void get(String url){
        driver.get(url);
    }
    public Boolean isDisplayed(By locator){
        try {
            return driver.findElement(locator).isDisplayed();}
        catch  (org.openqa.selenium.NoSuchElementException e )
        {
            return false;
        }
    }

    public void WriteFile(List<WebElement> listaArticulos, String nombreArchivo){
        File f;
        FileWriter w;
        BufferedWriter bw;
        PrintWriter wr;

        try{
            f=new File(nombreArchivo);
            w=new FileWriter(nombreArchivo);
            bw=new BufferedWriter(w);
            wr=new PrintWriter(bw);

            for (int i=0; i< listaArticulos.size();i++){
                wr.append(getText(listaArticulos.get(i)));
            }
            wr.close();
            bw.close();
        }catch (Exception e){
            System.out.println("Error");
        }
    }
}
