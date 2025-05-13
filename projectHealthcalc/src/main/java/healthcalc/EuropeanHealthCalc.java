package healthcalc;

public class EuropeanHealthCalc extends HealthHospitalDecoratorRegion {
    public EuropeanHealthCalc(HealthHospital wrappee) {
        super(wrappee);
    }

    @Override
    public double bmr(char genero, int edad, float alturaMetros, int pesoGramos) {
        float alturaCm = alturaMetros * 100;
        int pesoKg = pesoGramos / 1000;
        return wrappee.bmr(genero, edad, alturaCm, pesoKg);
    }
}