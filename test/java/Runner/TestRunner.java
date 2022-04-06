package Runner;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        features = "src/test/resources/feature/",
        monochrome = true,
        plugin = {
        "pretty", "html:target/cucumber-report/html", "json:target/cucumber-report/cucumber.json",
        "rerun:rerun/Cloudfy_failed_scenarios.txt"},
        glue = "",
        dryRun=false,
        tags = {"@ExtendedDelivery"}
        )

public class TestRunner  extends AbstractTestNGCucumberTests{	
	
}