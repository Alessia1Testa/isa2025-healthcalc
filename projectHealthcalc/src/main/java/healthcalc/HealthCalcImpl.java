package healthcalc;

public class HealthCalcImpl implements HealthCalc {

    private static HealthCalcImpl instance;

    private final CardiovascularMetrics cardio = new CardiovascularMetrics();
    private final MetabolicMetrics metabolic = new MetabolicMetrics();

    HealthCalcImpl() {}

    public static HealthCalcImpl getInstance() {
        if (instance == null) {
            instance = new HealthCalcImpl();
        }
        return instance;
    }

    @Override
    public double getIdealBodyWeight(Person person) throws InvalidHeightException, InvalidGenderException {
        return cardio.idealWeight(person);
    }

    @Override
    public double basalMetabolicRate(Person person)
            throws InvalidValueException, InvalidGenderException {
        return metabolic.basalMetabolicRate(person);
    }
}