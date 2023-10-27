package stepDefinitionsAPI.base;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;

import java.sql.Timestamp;

import static driver.DriverFactory.getDriver;

public class Hooks {
    @Before
    public void setup() {}
    // Attach a screenshot in the report if a scenario fails and adds it on the report generated
    @AfterStep
    public void captureExceptionImage() { }
    @After
    public void tearDown() {}
}
