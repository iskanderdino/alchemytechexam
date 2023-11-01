package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/* glue - will be used to identify where step definition is located
 * monochrome - will make log readable if set to true :: default set to false
 * dryrun - will not run existing step definition if set to true but it will identify
 * step without a linked step definition :: default set to false
 *
 * plugin will have the following values:
 * pretty - will create readable logs on the terminal
 * html:target/cucumber - will generate an html report
 *
 * please see Cucumber Reference documentations
 * https://cucumber.io/docs/cucumber/api/?lang=java
*/
@CucumberOptions(
    features = {"classpath:features"},
    glue = {"stepDefinitions"},
    tags = "@regression",
    monochrome = true, dryRun = false,
    plugin = {
        "pretty", "html:target/reports/cucumber.html",
        "json:target/json-reports/cucumber.json"
    }
)

// allows scenarios on feature to run in parallel
public class MainRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
