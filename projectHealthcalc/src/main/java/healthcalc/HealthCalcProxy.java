package healthcalc;

import java.util.ArrayList;
import java.util.List;

public class HealthCalcProxy implements HealthHospital, HealthStats {

    private HealthHospital hCalc;

    private List<Float> alturas = new ArrayList<>();
    private List<Integer> pesos = new ArrayList<>();
    private List<Integer> edades = new ArrayList<>();
    private List<Double> bmrs = new ArrayList<>();

    private int hombres = 0;
    private int mujeres = 0;

    public HealthCalcProxy(HealthHospital realCalc) {
        this.hCalc = realCalc;
    }

    @Override
    public int pesoIdeal(char genero, float altura) {
        int peso = hCalc.pesoIdeal(genero, altura);
        alturas.add(altura);
        pesos.add(peso);
        if (genero == 'H') hombres++;
        else if (genero == 'M') mujeres++;
        return peso;
    }

    @Override
    public double bmr(char genero, int edad, float altura, int peso) {
        double bmr = hCalc.bmr(genero, edad, altura, peso);
        edades.add(edad);
        alturas.add(altura);
        pesos.add(peso);
        bmrs.add(bmr);
        if (genero == 'H') hombres++;
        else if (genero == 'M') mujeres++;
        return bmr;
    }


    @Override
    public float alturaMedia() {
        return (float) alturas.stream().mapToDouble(Float::doubleValue).average().orElse(0);
    }

    @Override
    public float pesoMedio() {
        return (float) pesos.stream().mapToInt(Integer::intValue).average().orElse(0);
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