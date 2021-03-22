package uitest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;

public class PesquisaTextoTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void pesquisaTexto() {
        driver.get("https://www.google.com/");
        driver.manage().window().setSize(new Dimension(953, 734));
        driver.findElement(By.name("q")).click();
        driver.findElement(By.name("q")).sendKeys("sisnema");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        assertThat(driver.findElement(By.cssSelector(".g > div > .tF2Cxc .LC20lb")).getText(), is("Sisnema | Inovação e Conhecimento sem Limites"));
        {
            WebElement element = driver.findElement(By.id("abar_button_opt"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
    }
}

