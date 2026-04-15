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
import java.util.Objects;

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
            By contactLink = Objects.requireNonNull(By.cssSelector("li[id='menu-item-22140'] a"));
            wait.until(ExpectedConditions.presenceOfElementLocated(contactLink));
            System.out.println("✅ Botón 'Contact' encontrado en la página");
        } catch (Exception e) {
            System.out.println("⚠️ Botón 'Contact' no encontrado inmediatamente, continuando...");
        }
    }

    @When("I click the Contact button")
    public void iClickContactButton() {
        try {
            By contactLink = Objects.requireNonNull(By.cssSelector("li[id='menu-item-22140'] a"));
            wait.until(ExpectedConditions.elementToBeClickable(contactLink)).click();
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

    @Then("I should see the Contact page titles")
    public void iShouldSeeTheContactPageTitles() {
        try {
            By connectTitle = Objects.requireNonNull(By.xpath("//h1[normalize-space()='Connect with Our Team']"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(connectTitle));
            assertTrue(driver.findElement(connectTitle).isDisplayed());

            String contactParagraphXpath = "//p[contains(normalize-space(), 'Let us know how we can help you reach LG’s premium connected TV audiences and measure outcomes for your cross-screen campaigns. A team member will get back to you shortly.')]";
            By contactParagraph = Objects.requireNonNull(By.xpath(contactParagraphXpath));
            wait.until(ExpectedConditions.visibilityOfElementLocated(contactParagraph));
            assertTrue(driver.findElement(contactParagraph).isDisplayed());

            By ourOffices = Objects.requireNonNull(By.xpath("//*[normalize-space()='Our Offices']"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(ourOffices));
            assertTrue(driver.findElement(ourOffices).isDisplayed());

            By joinNewsletter = Objects.requireNonNull(By.xpath("//*[normalize-space()='Join the newsletter']"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(joinNewsletter));
            assertTrue(driver.findElement(joinNewsletter).isDisplayed());

            System.out.println("✅ Todos los títulos de Contact existen correctamente");
        } catch (Exception e) {
            System.err.println("❌ Error al verificar títulos de Contact: " + e.getMessage());
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
        } catch (Exception e) {
            System.err.println("❌ Error en validación: " + e.getMessage());
            throw e;
        }
    }

    @Then("I should see the welcome text {string}")
    public void iShouldSeeTheWelcomeText(String expectedText) {
        try {
            By welcomeText = Objects.requireNonNull(By.xpath("//*[contains(text(), '" + expectedText + "')]"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeText));
            assertTrue("El texto de bienvenida debe estar visible", driver.findElement(welcomeText).isDisplayed());
            System.out.println("✅ Texto de bienvenida verificado: " + expectedText);
            System.out.println("✅ TEST PASSED: Navegación completa exitosa");
            driver.quit();
            System.out.println("✅ Navegador cerrado correctamente");
        } catch (Exception e) {
            System.err.println("❌ Error al verificar texto de bienvenida: " + e.getMessage());
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
