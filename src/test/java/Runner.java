import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
		glue = { "" }, monochrome = true, dryRun  = false,
		plugin = {"json:target/cucumber.json"})
public class Runner {

}