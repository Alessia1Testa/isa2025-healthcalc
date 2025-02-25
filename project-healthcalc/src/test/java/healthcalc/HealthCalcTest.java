package healthcalc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests for the health calculator.")
public class HealthCalcTest {

    @Test
    @DisplayName("Test 1: Calculate ideal weight for a man.")
    public void testIdealWeightMen() throws Exception {
        
        HealthCalc calc = new HealthCalc();
        int height = 175;  // Height in cm
        char gender = 'm';  // Gender 'm' for male
        float expectedWeight = 75;  // Expected ideal weight in kg

        // Act
        float actualWeight = calc.idealWeight(height, gender);

        // Assert
        assertEquals(expectedWeight, actualWeight);
    }

    @Test
    @DisplayName("Test 2: Calculate ideal weight for a woman.")
    public void testIdealWeightWomen() throws Exception {
        
        HealthCalc calc = new HealthCalc();
        int height = 170;  // Height in cm
        char gender = 'w';  // Gender 'w' for female
        float expectedWeight = 64;  // Expected ideal weight in kg

        // Act
        float actualWeight = calc.idealWeight(height, gender);

        // Assert
        assertEquals(expectedWeight, actualWeight);
    }

    @Test
    @DisplayName("Test 3: Handle invalid gender input.")
    public void testIdealWeightInvalidGender() {
        
        HealthCalc calc = new HealthCalc();
        int height = 175;  // Height in cm
        char invalidGender = 'x';  // Invalid gender

        // Act & Assert
        assertThrows(Exception.class, () -> {
            calc.idealWeight(height, invalidGender);
        });
    }

    @Test
    @DisplayName("Test 4: Handle negative height values.")
    public void testIdealWeightNegativeHeight() {
        
        HealthCalc calc = new HealthCalc();
        int negativeHeight = -160;  // Invalid negative height
        char gender = 'm';  // Gender 'm' for male

        // Act & Assert
        assertThrows(Exception.class, () -> {
            calc.idealWeight(negativeHeight, gender);
        });
    }

    @Test
    @DisplayName("Test 5: Calculate Basal Metabolic Rate (BMR) for a man.")
    public void testBmrMen() throws Exception {
        
        HealthCalc calc = new HealthCalc();
        float weight = 70;  // Weight in kg
        int height = 175;  // Height in cm
        int age = 25;  // Age in years
        char gender = 'm';  // Gender 'm' for male
        float expectedBmr = 1772;  // Expected BMR

        // Act
        float actualBmr = Math.round(calc.basalMetabolicRate(weight, height, age, gender));

        // Assert
        assertEquals(expectedBmr, actualBmr);
    }

    @Test
    @DisplayName("Test 6: Calculate Basal Metabolic Rate (BMR) for a woman.")
    public void testBmrWomen() throws Exception {
        
        HealthCalc calc = new HealthCalc();
        float weight = 60;  // Weight in kg
        int height = 165;  // Height in cm
        int age = 30;  // Age in years
        char gender = 'w';  // Gender 'w' for female
        float expectedBmr = 1500;  // Expected BMR

        // Act
        float actualBmr = Math.round(calc.basalMetabolicRate(weight, height, age, gender));

        // Assert
        assertEquals(expectedBmr, actualBmr);
    }

    @Test
    @DisplayName("Test 7: Handle negative values for BMR calculation.")
    public void testBmrNegativeValues() {
        
        HealthCalc calc = new HealthCalc();
        float negativeWeight = -70;  // Invalid negative weight
        int negativeHeight = -175;  // Invalid negative height
        int negativeAge = -25;  // Invalid negative age
        char gender = 'm';  // Gender 'm' for male

        // Act & Assert
        assertThrows(Exception.class, () -> {
            calc.basalMetabolicRate(negativeWeight, negativeHeight, negativeAge, gender);
        });
    }

    @Test
    @DisplayName("Test 8: Handle invalid gender input for BMR calculation.")
    public void testBmrInvalidGender() {
        // Arrange
        HealthCalc calc = new HealthCalc();
        float weight = 70;  // Weight in kg
        int height = 175;  // Height in cm
        int age = 25;  // Age in years
        char invalidGender = 'x';  // Invalid gender

        // Act & Assert
        assertThrows(Exception.class, () -> {
            calc.basalMetabolicRate(weight, height, age, invalidGender);
        });
    }
}
