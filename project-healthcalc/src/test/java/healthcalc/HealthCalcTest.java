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
        char gender = 'm';  
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
        char gender = 'w';  
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
        char gender = 'm';  

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
        char invalidGender = 'x';  

        // Act & Assert
        assertThrows(Exception.class, () -> {
            calc.idealWeight(height, invalidGender);
        });
    }

    @Test
    @DisplayName("Test 1: Calculate Basal Metabolic Rate (BMR) for a man.")
    public void testBmrMen() throws Exception {
        
        HealthCalc calc = new HealthCalcImpl();
        float weight = 70;  
        int height = 175;  
        int age = 25;  
        char gender = 'm';  
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
        char gender = 'w';  
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
			calc.basalMetabolicRate(0, 175, 30, 'm');
		});
	}



    @Test
    @DisplayName("Test 4: Handle negative values for BMR calculation.")
    public void testBmrNegativeValues() {
        
        HealthCalc calc = new HealthCalcImpl();
        float negativeWeight = -70;  
        int negativeHeight = -175;  
        int negativeAge = -25;  
        char gender = 'm';  

        // Act & Assert
        assertThrows(Exception.class, () -> {
            calc.basalMetabolicRate(negativeWeight, negativeHeight, negativeAge, gender);
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
        char invalidGender = 'x';  

        // Act & Assert
        assertThrows(Exception.class, () -> {
            calc.basalMetabolicRate(weight, height, age, invalidGender);
        });
    }
}
