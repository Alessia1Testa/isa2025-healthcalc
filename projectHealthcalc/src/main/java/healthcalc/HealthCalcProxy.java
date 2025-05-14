package healthcalc;

import java.util.ArrayList;
import java.util.List;

public class HealthCalcProxy implements HealthHospital, HealthStats {

    private HealthHospital hCalc;

    private List<Float> alturas = new ArrayList<>();
    private List<Float> pesos = new ArrayList<>();
    private List<Integer> edades = new ArrayList<>();
    private List<Double> bmrs = new ArrayList<>();

    private int hombres = 0;
    private int mujeres = 0;


    public HealthCalcProxy(HealthHospital hCalc) {
        this.hCalc = hCalc;
    }

    @Override
    public int pesoIdeal(Person person) {
        float altura = person.height();
        Gender gender = person.gender();

        int peso = hCalc.pesoIdeal(person);
        alturas.add(altura);
        pesos.add((float) peso); 

        if (gender == Gender.MALE) {
            hombres++;
        } else if (gender == Gender.FEMALE) {
            mujeres++;
        }

        return peso;
    }

    @Override
    public double bmr(Person person) {
        float altura = person.height();
        float peso = person.weight();
        int edad = person.age();
        Gender gender = person.gender();

        double bmr = hCalc.bmr(person);
        edades.add(edad);
        alturas.add(altura);
        pesos.add(peso);
        bmrs.add(bmr);

        if (gender == Gender.MALE) {
            hombres++;
        } else if (gender == Gender.FEMALE) {
            mujeres++;
        }

        return bmr;
    }


    @Override
    public float alturaMedia() {
        return (float) alturas.stream().mapToDouble(Float::doubleValue).average().orElse(0);
    }

    @Override
    public float pesoMedio() {
        return (float) pesos.stream()
                            .mapToDouble(Float::doubleValue)
                            .average()
                            .orElse(0);
    }

    @Override
    public float edadMedia() {
        return (float) edades.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    @Override
    public float bmrMedio() {
        return (float) bmrs.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    @Override
    public int numSexoH() {
        return hombres;
    }

    @Override
    public int numSexoM() {
        return mujeres;
    }

    @Override
    public int numTotalPacientes() {
        return hombres + mujeres;
    }
}