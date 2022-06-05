import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/Features",
        glue = "StepDefs",
        plugin = {
                "json:target/cucumber.json"
        }
)


public class TestRunner extends AbstractTestNGCucumberTests {

}