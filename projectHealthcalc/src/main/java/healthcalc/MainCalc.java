package calc;
  
import healthcalc.*; 

import java.awt.EventQueue;
import calc.ControllerCalc;

public class MainCalc {


public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				HealthCalc model = HealthCalcImpl.getInstance();
		        VistaCalc view = new VistaCalc();
		        ControllerCalc controller = new ControllerCalc(model, view);
		        
		        
		        view.registerController(controller);
		        
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}
}
