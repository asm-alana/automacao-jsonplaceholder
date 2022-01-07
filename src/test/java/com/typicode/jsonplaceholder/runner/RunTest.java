package com.typicode.jsonplaceholder.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/report.html", "json:target/report/cucumber.json"},
        features = {"src/test/resources/features"},
        glue = {"com/typicode/jsonplaceholder/steps"},
        tags = "@delete"
)

public class RunTest {
    @AfterClass
    public static void report() throws IOException {
        Runtime.getRuntime().exec("cmd.exe /c mvn cluecumber-report:reporting");
    }
}
