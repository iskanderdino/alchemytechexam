package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features= {"classpath:apifeatures"},
        glue= {"stepDefinitionsAPI"},
        tags= "@api",    // based on tags scenarios will run
        monochrome=true, dryRun=false,
        plugin = {
                "pretty", "html:target/reports/cucumber.html",
                "json:target/json-reports/cucumber.json"
        }
)

public class ApiRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
