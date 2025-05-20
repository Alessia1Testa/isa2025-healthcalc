package healthcalc;
  
import healthcalc.*; 


public class MainCalc {


public static void main(String[] args) {

	HealthCalc model = HealthCalcImpl.getInstance();

    
    HealthHospital adapter = new HealthCalcAdapter(model);

    HealthStats proxy = new HealthCalcProxy(adapter);
    
    HealthHospital hospital = (HealthHospital) proxy;

    HealthHospital european = new EuropeanHealthCalc(adapter);

    HealthHospital englishCalc = new BMREngMessageDecorator(adapter);

    double bmrValue = englishCalc.bmr('m', 30, 1.70f, 70000);

    System.out.println("BMR Value: " + bmrValue);

	

	}
}

