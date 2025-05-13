package healthcalc;
  
import healthcalc.*; 


public class MainCalc {


public static void main(String[] args) {
	HealthCalc model = HealthCalcImpl.getInstance();

    
    HealthHospital adapter = new HealthCalcAdapter(model);

	HealthStats proxy = new HealthCalcProxy(adapter);
    
	HealthHospital hospital = (HealthHospital) proxy;

	HealthHospital european = new EuropeanHealthCalc(adapter);

	HealthHospital englishCalc = new BMREngMessageDecorator(european);

	}
}

