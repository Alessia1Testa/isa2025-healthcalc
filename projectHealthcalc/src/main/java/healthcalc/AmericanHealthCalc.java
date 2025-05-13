package healthcalc;

public class AmericanHealthCalc extends HealthHospitalDecorator {
    public AmericanHealthCalc(HealthHospital wrappee) {
        super(wrappee);
    }

    @Override
    public double bmr(Gender gender, int edad, float alturaPies, int pesoLibras) {
        float alturaCm = alturaPies * 30.48f;
        int pesoKg = (int) (pesoLibras / 2.20462);
        return super.bmr(gender, edad, alturaCm, pesoKg);
    }
}