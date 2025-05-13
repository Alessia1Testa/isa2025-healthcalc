package healthcalc;

public class BMRMessageDecorator extends HealthHospitalDecorator {
    public BMRMessageDecorator(HealthHospital wrappee) {
        super(wrappee);
    }

    @Override
    public double bmr(Gender gender, int edad, float altura, int peso) {
        double result = super.bmr(gender, edad, altura, peso);
        System.out.printf("La persona con altura %.2f cm y peso %d Kg tiene un BMR de %.2f.%n", altura, peso, result);
        System.out.printf("The person with height %.2f cm and weight %d Kg has a BMR of %.2f.%n", altura, peso, result);
        return result;
    }
}

