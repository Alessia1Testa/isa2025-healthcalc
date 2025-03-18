package healthcalc.bdd;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.*;
import healthcalc.HealthCalcImpl;
import healthcalc.InvalidGenderException;
import healthcalc.InvalidHeightException;


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

    @When("I enter a height of {int} cm and gender {string}")
    public void i_enter_a_height_of_n_cm_and_gender(Integer height, String gender) {
        // Act: Call the idealWeight method with provided height and gender
        try {
            result = healthCalc.idealWeight(height, gender.charAt(0)); // Convert string gender to char
        } catch (Exception e) {
            exception = e;
        }
    }

    @Then("the system returns an ideal weight of {double}")
    public void the_system_returns_an_ideal_weight_of_value(Double expectedWeight) {
        // Assert: Verify the expected result
        assertNull(exception, "An exception was thrown: " + exception);
        assertEquals(expectedWeight, result, 0.01);
    }

    @Then("the system throws an InvalidHeightException")
    public void the_system_throws_an_invalid_height_exception() {
        // Assert: Check if an exception was thrown and if it's the correct type
        Exception exception = assertThrows(InvalidHeightException.class, () -> {
            healthCalc.idealWeight(-160, 'w');
        });
        
        assertNotNull(exception, "Exception should not be null"); 
    }

    @Then("the system throws an InvalidGenderException")
    public void the_system_throws_an_invalid_gender_exception() {
        assertThrows(InvalidGenderException.class, () -> {
            healthCalc.idealWeight(160, 'x'); // 'x' invalid gender
        });
    }



    private double calculatedBMR;

    @When("I enter weight {int} kg, height {int} cm, age {int}, and gender {string}")
    public void i_enter_weight_kg_height_cm_age_and_gender(Integer weight, Integer height, Integer age, String gender) {
        calculatedBMR = healthCalc.basalMetabolicRate(weight, height, age, gender.charAt(0));
    }

    @Then("the system returns a BMR of {double}")
    public void the_system_returns_a_bmr_of(Double expectedBMR) {
        assertEquals(expectedBMR, calculatedBMR, 0.01, "BMR calculation is incorrect");
    }

}




