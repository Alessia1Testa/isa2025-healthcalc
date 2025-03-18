package healthcalc.bdd;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.*;
import healthcalc.HealthCalcImpl;

public class StepDefinitions {

    private HealthCalcImpl healthCalc;
    private float result;
    private Exception exception;

    @Given("I have a health calculator")
    public void i_have_a_health_calculator() {
        // Arrange: Instantiate the health calculator
        healthCalc = new HealthCalcImpl();
    }
    @When("I enter a height of {int} cm and a man gender")
    public void i_enter_a_height_of_cm_and_a_man_gender(Integer int1) {
        // Act: Call the idealWeight method for a man
        try {
            result = healthCalc.idealWeight(int1, 'm');
        } catch (Exception e) {
            exception = e;
        }
    }
    @Then("The system returns an ideal weight of {double}")
    public void the_system_returns_an_ideal_weight_of(Double double1) {
        // Assert: Check if the calculated weight matches the expected value
        assertEquals(double1, result, 0.01);
    }   
}



