package lgautomation2.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources",
    glue = "lgautomation2.steps",
    plugin = {
        "pretty",
        "html:build/reports/cucumber-report"},
        tags = "not @skipme",  // 👈 Excluye pruebas con esta etiqueta
    monochrome = true
)
public class TestRunner {
}







