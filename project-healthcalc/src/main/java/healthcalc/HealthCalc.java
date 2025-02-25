package healthcalc;

public interface HealthCalc {

    public float idealWeight(int height, char gender) throws InvalidHeightException, InvalidGenderException;

    public float basalMetabolicRate(float weight, int height, int age, char gender) throws InvalidValueException, InvalidGenderException;
}
