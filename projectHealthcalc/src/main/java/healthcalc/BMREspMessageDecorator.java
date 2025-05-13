package healthcalc;

public class BMREspMessageDecorator extends HealthHospitalDecoratorLanguage {

    public BMREspMessageDecorator(HealthHospital wrappee) {
        super(wrappee);
    }

    @Override
    public double bmr(char genero, int edad, float altura, int peso) {
        double result = wrappee.bmr(genero, edad, altura, peso);
        System.out.printf("La persona con altura %.2f cm y peso %d kg tiene un BMR de %.2f.%n", altura, peso, result);
        return result;
    }
}


