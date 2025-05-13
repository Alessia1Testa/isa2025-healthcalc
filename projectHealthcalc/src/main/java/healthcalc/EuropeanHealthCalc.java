package healthcalc;

public class EuropeanHealthCalc extends HealthHospitalDecorator {
    public EuropeanHealthCalc(HealthHospital wrappee) {
        super(wrappee);
    }

    @Override
    public double bmr(Gender gender, int edad, float alturaMetros, int pesoGramos) {
        float alturaCm = alturaMetros * 100;
        int pesoKg = pesoGramos / 1000;
        return super.bmr(gender, edad, alturaCm, pesoKg);
    }
}