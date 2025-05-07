package healthcalc;
  
import healthcalc.*; 


public class MainCalc {


public static void main(String[] args) {
	HealthCalc model = HealthCalcImpl.getInstance();

    
    HealthHospital hospitalCalc = new HealthCalcAdapter(model);

	}
}

