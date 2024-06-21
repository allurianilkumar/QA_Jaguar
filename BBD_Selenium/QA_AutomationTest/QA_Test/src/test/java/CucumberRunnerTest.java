import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        tags = {"@testTwo"},
        format = {"pretty"}

)
// Tag functionality defined in https://github.com/cucumber/cucumber/wiki/Tags
// Logic:
// OR: Separate tags with commas, ",", to act as OR (e.g. "@run_me,@regression_suite" targets features tagged with @run_me OR @regression_suite)
// AND: Separate tags with spaces, " ", to act as AND (e.g. "@run_me @regression_suite" targets features tagged with @run_me AND also @regression_suite)

public class CucumberRunnerTest {
}
