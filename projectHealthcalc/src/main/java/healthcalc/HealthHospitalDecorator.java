package healthcalc;

public abstract class HealthHospitalDecorator implements HealthHospital {
    protected HealthHospital wrappee;

    public HealthHospitalDecorator(HealthHospital wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public int pesoIdeal(char genero, float altura) {
        return wrappee.pesoIdeal(genero, altura);
    }

    @Override
    public double bmr(char genero, int edad, float altura, int peso) {
        return wrappee.bmr(genero, edad, altura, peso);
    }
}