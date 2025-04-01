package calc;

import healthcalc.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import healthcalc.HealthCalc;   
import healthcalc.HealthCalcImpl;  

public class ControllerCalc implements ActionListener {

    private HealthCalcImpl model;  
    private VistaCalc view;

    
    public ControllerCalc(HealthCalcImpl model, VistaCalc view) {
        this.model = model; 
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Compute Ideal Weight")) {
            // Get height1 and gender (from combo box)
            String inputHeight1 = view.getInputHeight1Value();
            String gender1 = (String) view.getComboBoxSexo1().getSelectedItem();  // Get gender input

            try {
                int height = Integer.parseInt(inputHeight1);
                char gender = gender1.equals("M") ? 'm' : 'w';  // Convert gender to 'm' or 'w'

                // Call the method to compute ideal weight
                float idealWeight = model.idealWeight(height, gender);
                view.showIWText("The Ideal Weight is: " + idealWeight + " kg");

            } catch (NumberFormatException exc) {
                view.showIWText("Introduce a positive height. It must be >=84 cm for men, and >= 67 cm for women.");
            } catch (Exception exc) {
                view.showIWText(exc.getMessage());  // Show any exception messages (e.g., invalid height)
            }
        }

        if (e.getActionCommand().equals("Compute Body Mass Index")) {
            // Get inputs for BMI calculation
            String inputHeight2 = view.getInputHeight2Value();
            String inputWeight2 = view.getInputWeight2Value();
            String inputAge2 = view.getInputAge2Value();
            String gender2 = (String) view.getComboBoxSexo2().getSelectedItem();  // Get gender input

            try {
                int height = Integer.parseInt(inputHeight2);
                int weight = Integer.parseInt(inputWeight2);
                int age = Integer.parseInt(inputAge2);
                char gender = gender2.equals("M") ? 'm' : 'w';  // Convert gender to 'm' or 'w'

                // Calculate BMI using the model
                float bmi = model.basalMetabolicRate(weight, height, age, gender);  // Assuming BMR is used for BMI
                view.showBMIText(" The Body Mass Index is: " + bmi);

            } catch (NumberFormatException exc) {
                view.showBMIText("Introduce positive numbers.");
            } catch (Exception exc) {
                view.showBMIText(exc.getMessage());  // Show any exception messages
            }
        }
    }
}
