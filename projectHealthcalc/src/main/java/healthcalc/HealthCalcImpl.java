package healthcalc;

public class HealthCalcImpl implements HealthCalc {

    private static HealthCalcImpl instance;

    HealthCalcImpl() {}

    public static HealthCalcImpl getInstance() {
        if (instance == null) {
            instance = new HealthCalcImpl();
        }
        return instance;
    }

    @Override
    public float idealWeight(int height, Gender gender) throws InvalidHeightException, InvalidGenderException {

        if (height <= 0 || height > 230) {
            throw new InvalidHeightException("Invalid height: " + height);
        }

        if (gender == null) {
            throw new InvalidGenderException("Gender cannot be null");
        }

        switch (gender) {
            case MALE:
                if (height < 84) {
                    throw new InvalidHeightException("Height must be >= 84 cm for men. Provided: " + height);
                }
                return height - 100 - (height - 150) / 4f;
            case FEMALE:
                if (height < 67) {
                    throw new InvalidHeightException("Height must be >= 67 cm for women. Provided: " + height);
                }
                return height - 100 - (height - 150) / 2.5f;
            default:
                throw new InvalidGenderException("Unrecognized gender");
        }
    }

    @Override
    public float basalMetabolicRate(float weight, int height, int age, Gender gender)
            throws InvalidValueException, InvalidGenderException {

        if (weight <= 0 || weight > 300) {
            throw new InvalidValueException("Invalid weight: " + weight);
        }

        if (height <= 0 || height > 230) {
            throw new InvalidValueException("Invalid height: " + height);
        }

        if (age <= 0 || age > 120) {
            throw new InvalidValueException("Invalid age: " + age);
        }

        if (gender == null) {
            throw new InvalidGenderException("Gender cannot be null");
        }

        return switch (gender) {
            case MALE -> 88.362f + (13.397f * weight) + (4.799f * height) - (5.677f * age);
            case FEMALE -> 447.593f + (9.247f * weight) + (3.098f * height) - (4.330f * age);
        };
    }
}
