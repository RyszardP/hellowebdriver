import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;


public class HelloWebDriver {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        driver.get("https://www.selenium.dev/");
        //new WebDriverWait(driver,10).until(CustomConditions.jQueryAJAXsCompleted());
        new WebDriverWait(driver,10);
        WebElement searchInput = waitForElementLocated(driver, By.xpath("//*[@id='gsc-i-id1']"));

        //     WebElement searchInput = driver.findElement(By.xpath("//*[@id='gsc-i-id1']"));


        searchInput.sendKeys("selenium java");
        searchInput.sendKeys(Keys.ENTER);
        driver.quit();


    }

    private static WebElement waitForElementLocated(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
