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
        Person person = new PersonImpl(70f, 175, 30, Gender.MALE);  // Use PersonImpl
        float expectedWeight = 68.75f;  

        // Act
        double actualWeight = calc.getIdealBodyWeight(person);  

        // Assert
        assertEquals(expectedWeight, actualWeight);
    }

    @Test
    @DisplayName("Test 2: Calculate ideal weight for a woman.")
    public void testIdealWeightWomen() throws Exception {
        HealthCalc calc = new HealthCalcImpl();
        Person person = new PersonImpl(60f, 170, 30, Gender.FEMALE);  // Use PersonImpl
        float expectedWeight = 62;  

        // Act
        double actualWeight = calc.getIdealBodyWeight(person);  

        // Assert
        assertEquals(expectedWeight, actualWeight);
    }

    @Test
    @DisplayName("Test 3: Handle negative height values.")
    public void testIdealWeightNegativeHeight() {
        HealthCalc calc = new HealthCalcImpl();
        Person person = new PersonImpl(60f, -160, 30, Gender.MALE);  // Use PersonImpl

        // Act & Assert
        assertThrows(Exception.class, () -> {
            calc.getIdealBodyWeight(person);  
        });
    }

    @Test
    @DisplayName("Test 4: Handle invalid gender input.")
    public void testIdealWeightInvalidGender() {
        HealthCalc calc = new HealthCalcImpl();
        Person person = new PersonImpl(70f, 175, 30, null);  // Invalid gender, should not be null

        // Act & Assert
        assertThrows(InvalidGenderException.class, () -> {
            calc.getIdealBodyWeight(person);  
        });
    }

    @Test
    @DisplayName("Test 5: Calculate ideal weight for a man with minimum valid height (84 cm).")
    public void testIdealWeightMenMinHeight() throws Exception {
        HealthCalc calc = new HealthCalcImpl();
        Person person = new PersonImpl(70f, 84, 30, Gender.MALE);  // Use PersonImpl
        float expectedWeight = 0.5f;

        // Act
        double actualWeight = calc.getIdealBodyWeight(person);  

        // Assert
        assertEquals(expectedWeight, actualWeight);
    }

    @Test
    @DisplayName("Test 6: Calculate ideal weight for a woman with minimum valid height (67 cm).")
    public void testIdealWeightWomenMinHeight() throws Exception {
        HealthCalc calc = new HealthCalcImpl();
        Person person = new PersonImpl(60f, 67, 30, Gender.FEMALE);  // Use PersonImpl
        float expectedWeight = 0.2f;

        // Act
        double actualWeight = calc.getIdealBodyWeight(person);  

        // Assert
        assertEquals(expectedWeight, actualWeight, 0.0001);
    }

    @Test
    @DisplayName("Test 7: Handle height below minimum valid height for men (83 cm).")
    public void testIdealWeightHeightBelowMinMen() {
        HealthCalc calc = new HealthCalcImpl();
        Person person = new PersonImpl(70f, 83, 30, Gender.MALE);  // Use PersonImpl

        // Act & Assert
        assertThrows(InvalidHeightException.class, () -> {
            calc.getIdealBodyWeight(person);  
        }, "Height must be >= 84 cm for men. Provided height: 83");
    }

    @Test
    @DisplayName("Test 8: Handle height below minimum valid height for women (66 cm).")
    public void testIdealWeightHeightBelowMinWomen() {
        HealthCalc calc = new HealthCalcImpl();
        Person person = new PersonImpl(60f, 66, 30, Gender.FEMALE);  // Use PersonImpl

        // Act & Assert
        assertThrows(InvalidHeightException.class, () -> {
            calc.getIdealBodyWeight(person);  
        }, "Height must be >= 67 cm for women. Provided height: 66");
    }

    @Test
    @DisplayName("Test 1: Calculate Basal Metabolic Rate (BMR) for a man.")
    public void testBmrMen() throws Exception {
        HealthCalc calc = new HealthCalcImpl();
        Person person = new PersonImpl(70f, 175, 25, Gender.MALE);  // Use PersonImpl
        float expectedBmr = 1724.052f;  

        // Act
        double actualBmr = calc.basalMetabolicRate(person);  

        // Assert
        assertEquals(expectedBmr, actualBmr);
    }

    @Test
    @DisplayName("Test 2: Calculate Basal Metabolic Rate (BMR) for a woman.")
    public void testBmrWomen() throws Exception {
        HealthCalc calc = new HealthCalcImpl();
        Person person = new PersonImpl(60f, 165, 30, Gender.FEMALE);  // Use PersonImpl
        float expectedBmr = 1383.683f;  

        // Act
        double actualBmr = calc.basalMetabolicRate(person);  

        // Assert
        assertEquals(expectedBmr, actualBmr);
    }

    @Test
    @DisplayName("Test 3: Test for a man with zero weight")
    void testBmrZeroWeight() {
        HealthCalc calc = new HealthCalcImpl();
        Person person = new PersonImpl(0f, 175, 30, Gender.MALE);  // Zero weight

        assertThrows(InvalidValueException.class, () -> {
            calc.basalMetabolicRate(person);  
        });
    }

    @Test
    @DisplayName("Test 4: Handle negative age for BMR calculation.")
    public void testBmrNegativeAge() {
        HealthCalc calc = new HealthCalcImpl();
        Person person = new PersonImpl(70f, 160, -5, Gender.FEMALE);  // Negative age

        assertThrows(InvalidValueException.class, () -> {
            calc.basalMetabolicRate(person);  
        });
    }

    @Test
    @DisplayName("Test 5: Handle invalid gender input for BMR calculation.")
    public void testBmrInvalidGender() {
        HealthCalc calc = new HealthCalcImpl();
        Person person = new PersonImpl(70f, 175, 25, null);  // Invalid gender, should not be null

        assertThrows(InvalidGenderException.class, () -> {
            calc.basalMetabolicRate(person);  
        });
    }

    @Test
    @DisplayName("Test 6: Handle negative result in BMR calculation for men.")
    public void testBmrNegativeResultMen() {
        HealthCalc calc = new HealthCalcImpl();
        Person person = new PersonImpl(1f, 1, 20, Gender.MALE);  // Invalid values

        assertThrows(InvalidValueException.class, () -> {
            calc.basalMetabolicRate(person);  
        });
    }

    @Test
    @DisplayName("Test 7: Handle negative result in BMR calculation for women.")
    public void testBmrNegativeResultWomen() {
        HealthCalc calc = new HealthCalcImpl();
        Person person = new PersonImpl(1f, 1, 107, Gender.FEMALE);  // Invalid values

        assertThrows(InvalidValueException.class, () -> {
            calc.basalMetabolicRate(person);  
        });
    }
}
