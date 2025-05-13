package healthcalc;

public abstract class HealthHospitalDecoratorLanguage implements HealthHospital {
    protected HealthHospital wrappee;

    public HealthHospitalDecoratorLanguage(HealthHospital wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public int pesoIdeal(char genero, float altura) {
        return wrappee.pesoIdeal(genero, altura);
    }

    @Override
    public abstract double bmr(char genero, int edad, float altura, int peso);
}