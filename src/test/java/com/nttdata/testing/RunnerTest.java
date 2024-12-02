package com.nttdata.testing;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/feature",
        glue = "com.nttdata.testing",
        tags = "@Logeo")
public class RunnerTest {

}
