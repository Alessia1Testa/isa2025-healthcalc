package healthcalc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

package healthcalc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests for the Health Calculator.")
public class HealthCalcTest {

@Test
@DisplayName("Test 1: Calculate ideal weight for a man.")
    public void testIdealWeightMen() throws Exception {
        // Arrange
        HealthCalc calc = new HealthCalc();
        int height = 175;
        char gender = 'm';
        float expectedWeight = 75;

        // Act
        float actualWeight = calc.idealWeight(height, gender);

        // Assert
        assertEquals(expectedWeight, actualWeight);
	
    }

@Test
@DisplayName("Test 2: Calculate ideal weight for a woman.")
    public void testIdealWeightWomen() throws Exception {
        // Arrange
        HealthCalc calc = new HealthCalc();
        int height = 170;
        char gender = 'w';
        float expectedWeight = 64;

        // Act
        float actualWeight = calc.idealWeight(height, gender);

        // Assert
        assertEquals(expectedWeight, actualWeight);
    }

@Test
@DisplayName("Test 3: Handle invalid gender input.")
    public void testIdealWeightInvalidGender() {
        // Arrange
        HealthCalc calc = new HealthCalc();
        int height = 175;
        char invalidGender = 'x';

        // Act & Assert
        assertThrows(Exception.class, () -> {
            calc.idealWeight(height, invalidGender);
        });
    }

@Test
@DisplayName("Test 5: Calculate Basal Metabolic Rate (BMR) for a man.")
    public void testBmrMen() throws Exception {
        // Arrange
        HealthCalc calc = new HealthCalc();
        float weight = 70;
        int height = 175;
        int age = 25;
        char gender = 'm';
        float expectedBmr = 1772;

        // Act
        float actualBmr = Math.round(calc.basalMetabolicRate(weight, height, age, gender));

        // Assert
        assertEquals(expectedBmr, actualBmr);
    }

@Test
@DisplayName("Test 6: Calculate Basal Metabolic Rate (BMR) for a woman.")
    public void testBmrWomen() throws Exception {
        // Arrange
        HealthCalc calc = new HealthCalc();
        float weight = 60;
        int height = 165;
        int age = 30;
        char gender = 'w';
        float expectedBmr = 1500;

        // Act
        float actualBmr = Math.round(calc.basalMetabolicRate(weight, height, age, gender));

        // Assert
        assertEquals(expectedBmr, actualBmr);
    }
}
