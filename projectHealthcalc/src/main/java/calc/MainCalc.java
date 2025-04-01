package calc;
  
import healthcalc.HealthCalcImpl; 

import java.awt.EventQueue;

public class MainCalc {


public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				HealthCalcImpl model = new HealthCalcImpl();
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
