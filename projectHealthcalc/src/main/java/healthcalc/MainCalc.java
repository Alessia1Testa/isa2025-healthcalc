package healthcalc;
  
import healthcalc.*; 


public class MainCalc {


public static void main(String[] args) {
	
        Person p = new PersonImpl(70, 175f, 30, Gender.MALE); 
        CardiovascularMetrics cvm = new CardiovascularMetrics();
		double idealWeight = cvm.idealWeight(p);

        System.out.println("Peso ideale: " + idealWeight + " kg");
        
	}
}

