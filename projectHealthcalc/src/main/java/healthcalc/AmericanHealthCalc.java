package healthcalc;

public class AmericanHealthCalc extends HealthHospitalDecorator {
    public AmericanHealthCalc(HealthHospital wrappee) {
        super(wrappee);
    }

    public double bmr(Person person) {
        
        Gender gender = person.gender();           
        int edad = person.age();                   
        float alturaPies = person.height();       
        int pesoLibras = (int) person.weight();   

        
        float alturaCm = alturaPies * 30.48f;  
        float pesoKg = pesoLibras / 2.20462f;  

        Person personWithConvertedData = new PersonImpl(pesoKg, (int) alturaCm, edad, gender); 

        return super.bmr(personWithConvertedData);

    }
}