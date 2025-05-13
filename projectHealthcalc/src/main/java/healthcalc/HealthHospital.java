package healthcalc;

public interface HealthHospital {
    double bmr(Gender gender, int edad, float altura, int peso);
    int pesoIdeal(Gender gender, float altura);
}
