package healthcalc;

public class HealthCalcAdapter implements HealthHospital {

    private final HealthCalc calc;

    public HealthCalcAdapter(HealthCalc calc) {
        this.calc = calc;
    }

    @Override
    public double bmr(Person person) {
        
        return calc.basalMetabolicRate(person);
    }

    @Override
    public int pesoIdeal(Person person) {
        
        return (int) calc.idealWeight(person);
    }
}

