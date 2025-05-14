package healthcalc;

public class EuropeanHealthCalc extends HealthHospitalDecorator {

    public EuropeanHealthCalc(HealthHospital wrappee) {
        super(wrappee);
    }

    @Override
    public double bmr(Person person) {
        
        Gender gender = person.gender();           
        int edad = person.age();                   
        float alturaMetros = person.height();      
        float pesoGramos = person.weight();          

        
        float alturaCm = alturaMetros * 100;       
        float pesoKg = pesoGramos / 1000;            

        
        Person personWithConvertedData = new PersonImpl(pesoKg, alturaCm, edad, gender); 

        return super.bmr(personWithConvertedData);  
    }
    
}
