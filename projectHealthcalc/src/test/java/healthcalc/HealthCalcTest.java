package healthcalc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests for the health calculator.")
public class HealthCalcTest {

    @Test
    @DisplayName("Test 1: Calculate ideal weight for a man.")
    public void testIdealWeightMen() throws Exception {
        
        HealthCalc calc = new HealthCalcImpl();
        int height = 175;  
        Gender gender = Gender.MALE;  
        float expectedWeight = 68.75f;  

        // Act
        float actualWeight = calc.idealWeight(height, gender);

        // Assert
        assertEquals(expectedWeight, actualWeight);
    }

    @Test
    @DisplayName("Test 2: Calculate ideal weight for a woman.")
    public void testIdealWeightWomen() throws Exception {
        
        HealthCalc calc = new HealthCalcImpl();
        int height = 170;  
        Gender gender = Gender.FEMALE;  
        float expectedWeight = 62;  

        // Act
        float actualWeight = calc.idealWeight(height, gender);

        // Assert
        assertEquals(expectedWeight, actualWeight);
    }

    @Test
    @DisplayName("Test 3: Handle negative height values.")
    public void testIdealWeightNegativeHeight() {
        
        HealthCalc calc = new HealthCalcImpl();
        int negativeHeight = -160;  
        Gender gender = Gender.MALE;  

        // Act & Assert
        assertThrows(Exception.class, () -> {
            calc.idealWeight(negativeHeight, gender);
        });
    }

    @Test
    @DisplayName("Test 4: Handle invalid gender input.")
    public void testIdealWeightInvalidGender() {
        
        HealthCalc calc = new HealthCalcImpl();
        int height = 175;  
        Gender invalidGender = null;  // Invalid Gender enum value, should not be null

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            calc.idealWeight(height, invalidGender);
        });
    }

    @Test
    @DisplayName("Test 5: Calculate ideal weight for a man with minimum valid height (84 cm).")
    public void testIdealWeightMenMinHeight() throws Exception {
        HealthCalc calc = new HealthCalcImpl();
        int height = 84;
        Gender gender = Gender.MALE;
        float expectedWeight = 0.5f;

        // Act
        float actualWeight = calc.idealWeight(height, gender);

        // Assert
        assertEquals(expectedWeight, actualWeight);
    }

    @Test
    @DisplayName("Test 6: Calculate ideal weight for a woman with minimum valid height (67 cm).")
    public void testIdealWeightWomenMinHeight() throws Exception {
        HealthCalc calc = new HealthCalcImpl();
        int height = 67;
        Gender gender = Gender.FEMALE;
        float expectedWeight = 0.2f;

        // Act
        float actualWeight = calc.idealWeight(height, gender);

        // Assert
        assertEquals(expectedWeight, actualWeight, 0.0001);
    }

    @Test
    @DisplayName("Test 7: Handle height below minimum valid height for men (83 cm).")
    public void testIdealWeightHeightBelowMinMen() {
        HealthCalc calc = new HealthCalcImpl();
        int height = 83;
        Gender gender = Gender.MALE;

        // Act & Assert
        assertThrows(InvalidHeightException.class, () -> {
            calc.idealWeight(height, gender);
        }, "Height must be >= 84 cm for men. Provided height: 83");
    }

    @Test
    @DisplayName("Test 8: Handle height below minimum valid height for women (66 cm).")
    public void testIdealWeightHeightBelowMinWomen() {
        HealthCalc calc = new HealthCalcImpl();
        int height = 66;
        Gender gender = Gender.FEMALE;

        // Act & Assert
        assertThrows(InvalidHeightException.class, () -> {
            calc.idealWeight(height, gender);
        }, "Height must be >= 67 cm for women. Provided height: 66");
    }

    @Test
    @DisplayName("Test 1: Calculate Basal Metabolic Rate (BMR) for a man.")
    public void testBmrMen() throws Exception {
        
        HealthCalc calc = new HealthCalcImpl();
        float weight = 70;  
        int height = 175;  
        int age = 25;  
        Gender gender = Gender.MALE;  
        float expectedBmr = 1724.052f;  

        // Act
        float actualBmr = calc.basalMetabolicRate(weight, height, age, gender);

        // Assert
        assertEquals(expectedBmr, actualBmr);
    }

    @Test
    @DisplayName("Test 2: Calculate Basal Metabolic Rate (BMR) for a woman.")
    public void testBmrWomen() throws Exception {
        
        HealthCalc calc = new HealthCalcImpl();
        float weight = 60;  
        int height = 165;  
        int age = 30;  
        Gender gender = Gender.FEMALE;  
        float expectedBmr = 1383.683f;  

        // Act
        float actualBmr = calc.basalMetabolicRate(weight, height, age, gender);

        // Assert
        assertEquals(expectedBmr, actualBmr);
    }

    @Test
    @DisplayName("Test 3: Test for a man with zero weight")
    void testBmrZeroWeight() {
        HealthCalc calc = new HealthCalcImpl();
        
        assertThrows(InvalidValueException.class, () -> {
            calc.basalMetabolicRate(0, 175, 30, Gender.MALE);
        });
    }

    @Test
    @DisplayName("Test 4: Handle negative age for BMR calculation.")
    public void testBmrNegativeAge() {
        HealthCalc calc = new HealthCalcImpl();
        float weight = 70;
        int height = 160;
        int negativeAge = -5;
        Gender gender = Gender.FEMALE;

        // Act & Assert
        assertThrows(InvalidValueException.class, () -> {
            calc.basalMetabolicRate(weight, height, negativeAge, gender);
        });
    }

    @Test
    @DisplayName("Test 5: Handle invalid gender input for BMR calculation.")
    public void testBmrInvalidGender() {
        // Arrange
        HealthCalc calc = new HealthCalcImpl();
        float weight = 70;  
        int height = 175;  
        int age = 25;  
        Gender invalidGender = null;  // Invalid Gender enum value, should not be null

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            calc.basalMetabolicRate(weight, height, age, invalidGender);
        });
    }

    @Test
    @DisplayName("Test 6: Handle negative result in BMR calculation for men.")
    public void testBmrNegativeResultMen() {
        HealthCalc calc = new HealthCalcImpl();
        float weight = 1;
        int height = 1;
        int age = 20;
        Gender gender = Gender.MALE;

        // Act & Assert
        assertThrows(InvalidValueException.class, () -> {
            calc.basalMetabolicRate(weight, height, age, gender);
        });
    }

    @Test
    @DisplayName("Test 7: Handle negative result in BMR calculation for women.")
    public void testBmrNegativeResultWomen() {
        HealthCalc calc = new HealthCalcImpl();
        float weight = 1;
        int height = 1;
        int age = 107;
        Gender gender = Gender.FEMALE;

        // Act & Assert
        assertThrows(InvalidValueException.class, () -> {
            calc.basalMetabolicRate(weight, height, age, gender);
        });
    }
}
