package healthcalc;

public class AmericanHealthCalc extends HealthHospitalDecoratorRegion {

    public AmericanHealthCalc(HealthHospital wrappee) {
        super(wrappee);
    }

    @Override
    public double bmr(char genero, int edad, float alturaFeet, int pesoLibras) {
        float alturaCm = alturaFeet * 30.48f;
        int pesoKg = (int) (pesoLibras / 2.20462);
        return wrappee.bmr(genero, edad, alturaCm, pesoKg);
    }
}
