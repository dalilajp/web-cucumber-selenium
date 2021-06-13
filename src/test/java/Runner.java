import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
        glue = {"steps"}, monochrome = true, dryRun = false,
        plugin = {"json:target/cucumber.json"})
public class Runner {

}
