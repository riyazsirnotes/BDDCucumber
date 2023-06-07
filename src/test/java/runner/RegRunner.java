package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(glue="steps",
								tags="@smoke",
								stepNotifications=true,
                               features=
                           {
							"src\\test\\resources\\Features\\regression\\ValidateLoginDataParameterization.feature" ,
							"src\\test\\resources\\Features\\regression\\ValidateLogin.feature" 
                           })

public class RegRunner {

}
