package healthcalc;

public interface HealthCalc {

    public float getIdealBodyWeight(Person person) throws InvalidHeightException, InvalidGenderException;

    public float basalMetabolicRate(Person person) throws InvalidValueException, InvalidGenderException;
}
