package healthcalc;

public interface HealthCalc {

    /**
     * Calculate the ideal weight (IW) of a person following the Lorentz formula:
     * For men: IW = height - 100 - (height - 150) / 4
     * For women: IW = height - 100 - (height - 150) / 2.5
     *
     * @param height  Height of the person (cm).
     * @param gender  Gender of the person ('m' or 'w').
     * @return        The ideal weight of the person (kg).
     * @throws InvalidHeightException  If height is invalid (negative or zero).
     * @throws InvalidGenderException If gender is invalid.
     */
    public float idealWeight(int height, char gender) throws InvalidHeightException, InvalidGenderException;

    /**
     * Calculate the Basal Metabolic Rate (BMR) of a person with the Harris-Benedict formula:
     * For men: BMR = 88.362 + 13.397 * weight + 4.799 * height - 5.677 * age
     * For women: BMR = 447.593 + 9.247 * weight + 3.098 * height - 4.330 * age
     *
     * @param weight  Weight of the person (kg).
     * @param height  Height of the person (cm).
     * @param age     Age of the person.
     * @param gender  Gender of the person ('m' or 'w').
     * @return        The Basal Metabolic Rate of the person (kcal/day).
     * @throws InvalidValueException If any value (height, weight, age) is invalid (negative or zero).
     * @throws InvalidGenderException If gender is invalid.
     */
    public float basalMetabolicRate(float weight, int height, int age, char gender) throws InvalidValueException, InvalidGenderException;
}

public class HealthCalcImpl implements HealthCalc {

    @Override
    public float idealWeight(int height, char gender) throws InvalidHeightException, InvalidGenderException {
        // Validate height
        if (height <= 0) {
            throw new InvalidHeightException("Invalid height: " + height);
        }

        // Validate gender
        if (gender != 'm' && gender != 'w') {
            throw new InvalidGenderException("Invalid gender: " + gender);
        }

        // Calculate ideal weight based on gender
        if (gender == 'm') {
            return height - 100 - (height - 150) / 4f;
        } else { // 'w'
            return height - 100 - (height - 150) / 2.5f;
        }
    }

    @Override
    public float basalMetabolicRate(float weight, int height, int age, char gender) throws InvalidValueException, InvalidGenderException {
        // Validate weight, height, and age
        if (weight <= 0 || height <= 0 || age <= 0) {
            throw new InvalidValueException("Invalid values: weight, height, and age must be positive.");
        }

        // Validate gender
        if (gender != 'm' && gender != 'w') {
            throw new InvalidGenderException("Invalid gender: " + gender);
        }

        // Calculate BMR based on gender
        if (gender == 'm') {
            return 88.362f + (13.397f * weight) + (4.799f * height) - (5.677f * age);
        } else { // 'w'
            return 447.593f + (9.247f * weight) + (3.098f * height) - (4.330f * age);
        }
    }
}

public class InvalidGenderException extends RuntimeException {
    public InvalidGenderException() {
        super("Invalid Gender Exception");
    }
}

public class InvalidHeightException extends RuntimeException {
    public InvalidHeightException() {
        super("Invalid Height Exception");
    }
}

public class InvalidValueException extends RuntimeException {
    public InvalidValueException() {
        super("Invalid Value Exception");
    }
}




