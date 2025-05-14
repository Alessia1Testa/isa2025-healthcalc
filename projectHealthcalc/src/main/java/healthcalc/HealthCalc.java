package healthcalc;

public interface HealthCalc {

    public double getIdealBodyWeight(Person person) throws InvalidHeightException, InvalidGenderException;

    public double basalMetabolicRate(Person person) throws InvalidValueException, InvalidGenderException;
}
