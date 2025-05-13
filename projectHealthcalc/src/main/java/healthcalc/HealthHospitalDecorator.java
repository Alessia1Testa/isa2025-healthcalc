package healthcalc;

public abstract class HealthHospitalDecorator implements HealthHospital {
    protected HealthHospital wrappee;

    public HealthHospitalDecorator(HealthHospital wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public int pesoIdeal(Gender gender, float altura) {
        return wrappee.pesoIdeal(gender, altura);
    }

    @Override
    public double bmr(Gender gender, int edad, float altura, int peso) {
        return wrappee.bmr(gender, edad, altura, peso);
    }
}