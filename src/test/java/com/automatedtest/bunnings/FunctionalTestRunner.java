package com.automatedtest.bunnings;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/com/automatedtest/bunnings/SearchFunctionality.feature"},
        strict = false, plugin = {"pretty",
        "json:target/cucumber_json_reports/searchFunctionality.json",
        "html:target/searchFunctionality-html"},
        glue = {"com.automatedtest.bunnings.infrastructure.driver",
                "com.automatedtest.bunnings.functionalTests"})
public class FunctionalTestRunner {
}


