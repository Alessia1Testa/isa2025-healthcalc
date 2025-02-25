package healthcalc;

public class HealthCalcImpl implements HealthCalc {

    @Override
    public float idealWeight(int height, char gender) throws InvalidHeightException, InvalidGenderException {
        if (height <= 0) {
            throw new InvalidHeightException("Invalid height: " + height);
        }
        if (gender != 'm' && gender != 'w') {
            throw new InvalidGenderException("Invalid gender: " + gender);
        }
        return (gender == 'm') ? (height - 100 - (height - 150) / 4f) : (height - 100 - (height - 150) / 2.5f);
    }

    @Override
    public float basalMetabolicRate(float weight, int height, int age, char gender) throws InvalidValueException, InvalidGenderException {
        if (weight <= 0 || height <= 0 || age <= 0) {
            throw new InvalidValueException("Invalid values: weight, height, and age must be positive.");
        }
        if (gender != 'm' && gender != 'w') {
            throw new InvalidGenderException("Invalid gender: " + gender);
        }
        return (gender == 'm')
                ? (88.362f + (13.397f * weight) + (4.799f * height) - (5.677f * age))
                : (447.593f + (9.247f * weight) + (3.098f * height) - (4.330f * age));
    }
}
