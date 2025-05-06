package healthcalc;

public class HealthCalcImpl implements HealthCalc {


    private static HealthCalcImpl instance;

    
    private HealthCalcImpl() {
        
    }

    public static HealthCalcImpl getInstance() {
        if (instance == null) {
            instance = new HealthCalcImpl();
        }
        return instance;
    }

    @Override
public float idealWeight(int height, char gender) throws InvalidHeightException, InvalidGenderException {
    
    if (height <= 0 || height > 230) {
        throw new InvalidHeightException("Invalid height: " + height + ". It must be a positive value (>= 84 cm for men and >= 67 cm for women) and smaller than 230 cm");
    }

    
    if (gender != 'm' && gender != 'w') {
        throw new InvalidGenderException("Invalid gender: " + gender);
    }

    
    if (gender == 'm' && height < 84) {
        throw new InvalidHeightException("Height must be >= 84 cm for men. Provided height: " + height);
    }

    
    if (gender == 'w' && height < 67) {
        throw new InvalidHeightException("Height must be >= 67 cm for women. Provided height: " + height);
    }

    
    if (gender == 'm') {
        return height - 100 - (height - 150) / 4f;  
    } else {
        return height - 100 - (height - 150) / 2.5f;  
    }
}


    @Override
    public float basalMetabolicRate(float weight, int height, int age, char gender) throws InvalidValueException, InvalidGenderException {
    	if (weight <= 0 || weight > 300) {
            throw new InvalidValueException("Weight must be positive and less than or equal to 300.");
        }

        
        if (height <= 0 || height > 230) {
            throw new InvalidValueException("Height must be positive and less than or equal to 230.");
        }

        
        if (age <= 0 || age > 120) {
            throw new InvalidValueException("Age must be positive and less than or equal to 120.");
        }
        if (gender != 'm' && gender != 'w') {
            throw new InvalidGenderException("Invalid gender: " + gender);
        }

        float bmr = (gender == 'm')
                ? (88.362f + (13.397f * weight) + (4.799f * height) - (5.677f * age))
                : (447.593f + (9.247f * weight) + (3.098f * height) - (4.330f * age));

        if (bmr <= 0) {
            throw new InvalidValueException("Calculated BMR is not valid (<= 0). Please check input values.");
        }

        return bmr;
    }

}
