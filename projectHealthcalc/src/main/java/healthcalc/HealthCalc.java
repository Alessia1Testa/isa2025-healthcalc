package healthcalc;

public interface HealthCalc {

    public float idealWeight(int height, Gender gender) throws InvalidHeightException, InvalidGenderException;

    public float basalMetabolicRate(float weight, int height, int age, Gender gender) throws InvalidValueException, InvalidGenderException;
}
