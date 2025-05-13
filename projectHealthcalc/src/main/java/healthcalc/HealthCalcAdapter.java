package healthcalc;

public class HealthCalcAdapter implements HealthHospital {

    private final HealthCalc calc;

    public HealthCalcAdapter(HealthCalc calc) {
        this.calc = calc;
    }

    @Override
    public double bmr(Gender gender, int edad, float altura, int peso) {
        float alturaCm = altura * 100; 
        float pesoKg = peso / 1000f;   
        return calc.basalMetabolicRate(pesoKg, (int) alturaCm, edad, gender);
    }

    @Override
    public int pesoIdeal(Gender gender, float altura) {
        int alturaCm = (int) (altura * 100); 
        return (int) calc.idealWeight(alturaCm, gender);
    }
}