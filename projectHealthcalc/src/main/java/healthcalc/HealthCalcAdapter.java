package healthcalc;

public class HealthCalcAdapter implements HealthHospital {

    private final HealthCalc calc;

    public HealthCalcAdapter() {
        this.calc = HealthCalcImpl.getInstance(); 
    }

    @Override
    public double bmr(char genero, int edad, float altura, int peso) {
        float alturaCm = altura * 100; 
        float pesoKg = peso / 1000f;   
        return calc.basalMetabolicRate(pesoKg, (int) alturaCm, edad, genero);
    }

    @Override
    public int pesoIdeal(char genero, float altura) {
        int alturaCm = (int) (altura * 100); 
        return (int) calc.idealWeight(alturaCm, genero);
    }
}