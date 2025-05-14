package healthcalc;


public class BMRMessageDecorator extends HealthHospitalDecorator {

    public BMRMessageDecorator(HealthHospital wrappee) {
        super(wrappee);
    }

    @Override
    public double bmr(Person person) {
        Gender gender = person.gender();
        int edad = person.age();
        float altura = person.height();
        int peso = (int) person.weight();

        double result = super.bmr(person);

        System.out.printf("La persona con altura %d cm y peso %d Kg tiene un BMR de %.2f.%n", altura, peso, result);
        System.out.printf("The person with height %d cm and weight %d Kg has a BMR of %.2f.%n", altura, peso, result);
        
        return result;
    }
}


