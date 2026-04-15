package lgautomation2.steps;

import io.cucumber.java.en.*;
import lgautomation2.pages.PaginaPrincipal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

import static org.junit.Assert.*;

public class ContactSteps {

    WebDriver driver;
    PaginaPrincipal pagina;
    WebDriverWait wait;

    @Given("I navigate to {string}")
    public void iNavigateTo(String url) {
        if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("URL no puede ser nula o vacía");
        }
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        pagina = new PaginaPrincipal(driver);
        driver.manage().window().maximize();
        driver.get(url);
        System.out.println("✅ Página abierta: " + url);
        // Esperar a que la página cargue completamente
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("li[id='menu-item-22140'] a")));
            System.out.println("✅ Botón 'Contact' encontrado en la página");
        } catch (Exception e) {
            System.out.println("⚠️ Botón 'Contact' no encontrado inmediatamente, continuando...");
        }
    }

    @When("I click the Contact button")
    public void iClickContactButton() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("li[id='menu-item-22140'] a")))
            .click();
            System.out.println("✅ Hicimos click en Contact");
        } catch (Exception e) {
            System.err.println("❌ Error al hacer click en Contact: " + e.getMessage());
            throw e;
        }
    }

    @Then("I should be redirected to the contact page")
    public void iShouldBeRedirected() {
        try {
            wait.until(ExpectedConditions.urlToBe("https://lgads.tv/contact/"));
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl != null) {
                System.out.println("🔎 URL actual: " + currentUrl);
                assertEquals("La URL debe ser https://lgads.tv/contact/", "https://lgads.tv/contact/", currentUrl);
            }
            System.out.println("✅ Página de Contact verificada correctamente");
        } catch (Exception e) {
            System.err.println("❌ Error en validación: " + e.getMessage());
            throw e;
        }
    }

    @When("I click the LG Ad Solutions link")
    public void iClickLGAdSolutionsLink() {
        try {
            pagina.clickLGAdSolutions();
            System.out.println("✅ Hicimos click en LG Ad Solutions");
        } catch (Exception e) {
            System.err.println("❌ Error al hacer click en LG Ad Solutions: " + e.getMessage());
            throw e;
        }
    }

    @Then("I should be redirected to the homepage")
    public void iShouldBeRedirectedToHomepage() {
        try {
            wait.until(ExpectedConditions.urlToBe("https://lgads.tv/"));
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl != null) {
                System.out.println("🏠 URL actual: " + currentUrl);
                assertEquals("La URL debe ser https://lgads.tv/", "https://lgads.tv/", currentUrl);
            }
            System.out.println("✅ Página de Homepage verificada correctamente");
            System.out.println("✅ TEST PASSED: Navegación completa exitosa");
            driver.quit();
            System.out.println("✅ Navegador cerrado correctamente");
        } catch (Exception e) {
            System.err.println("❌ Error en validación final: " + e.getMessage());
            if (driver != null) {
                driver.quit();
            }
            throw e;
        }
    }

    @Then("I click on the logo to return to the homepage")
    public void iClickLogoToReturn() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//img[@title='lg-ad-solution-allblack']")))
            .click();
            System.out.println("🔙 Click en el logo para volver al home");
        } catch (Exception e) {
            System.err.println("❌ Error al hacer click en logo: " + e.getMessage());
            throw e;
        }
    }

    @Then("I should be back on the homepage")
    public void iShouldBeBackOnHomepage() {
        try {
            wait.until(ExpectedConditions.urlToBe("https://lgads.tv/"));
            String currentUrl = driver.getCurrentUrl();
            System.out.println("🏠 URL actual luego de volver: " + currentUrl);
            assertEquals("Debe regresar al home", "https://lgads.tv/", currentUrl);
            System.out.println("✅ Regreso al homepage confirmado");
            driver.quit();
            System.out.println("✅ Navegador cerrado correctamente");
        } catch (Exception e) {
            System.err.println("❌ Error en validación final: " + e.getMessage());
            if (driver != null) {
                driver.quit();
            }
            throw e;
        }
    }
}
