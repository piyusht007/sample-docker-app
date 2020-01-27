package com.example.docker;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "html:cucumber/test-reports"}, //
        features = {"classpath:features"}, //
        tags = {"@IntegrationTest"}, //
        glue = {"com.example.docker"})
public class CucumberRunner {
}
