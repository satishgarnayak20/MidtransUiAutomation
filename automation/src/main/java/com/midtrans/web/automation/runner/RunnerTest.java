package com.midtrans.web.automation.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
/**
 * @author Satish Garnayak
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(strict = true, monochrome = true, features = "src/test/java/com/midtrans/web/automation/features/PurchaseMidtranPillow.feature", glue = {
		"com.midtrans.web.automation.StepDefinitions" }, plugin = { "pretty", "html:target/bdd" })
public class RunnerTest {
}
