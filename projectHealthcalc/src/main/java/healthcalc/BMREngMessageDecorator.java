package healthcalc;

public class BMREngMessageDecorator extends HealthHospitalDecoratorLanguage {

    public BMREngMessageDecorator(HealthHospital wrappee) {
        super(wrappee);
    }

    @Override
    public double bmr(char genero, int edad, float altura, int peso) {
        double result = wrappee.bmr(genero, edad, altura, peso);
        System.out.printf("The person with height %.2f cm and weight %d kg has a BMR of %.2f.%n", altura, peso, result);
        return result;
    }
}