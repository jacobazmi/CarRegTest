package com.azmi.jacob.e2e.test;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber"},
        features={"src/test/resources/features/CheckCarDetails.feature"}
)
public class CucumberRunner {
}
