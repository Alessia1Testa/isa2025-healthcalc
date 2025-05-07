package healthcalc;

public interface HealthHospital {
    double bmr(char genero, int edad, float altura, int peso);
    int pesoIdeal(char genero, float altura);
}
