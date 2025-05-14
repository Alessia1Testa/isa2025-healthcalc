package healthcalc;

public abstract class HealthHospitalDecorator implements HealthHospital {
    protected HealthHospital wrappee;

    public HealthHospitalDecorator(HealthHospital wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public int pesoIdeal(Person person) {
        return wrappee.pesoIdeal(person);
    }

    @Override
    public double bmr(Person person) {
        return wrappee.bmr(person);
    }
}