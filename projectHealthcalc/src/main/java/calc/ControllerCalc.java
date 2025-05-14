package calc;

import healthcalc.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerCalc implements ActionListener {

    private HealthCalc model;
    private VistaCalc view;

    public ControllerCalc(HealthCalc model, VistaCalc view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Compute Ideal Weight")) {

            String inputHeight1 = view.getInputHeight1Value();
            String gender1 = (String) view.getComboBoxSexo1().getSelectedItem();

            try {
                int height = Integer.parseInt(inputHeight1);
                Gender gender = gender1.equals("M") ? Gender.MALE : Gender.FEMALE;  

                
                Person person = new PersonImpl(70f, height, 30, gender);  

                
                double idealWeight = model.getIdealBodyWeight(person);
                view.showIWText("The Ideal Weight is equal to: " + idealWeight + " kg");

            } catch (NumberFormatException exc) {
                view.showIWText("Introduce a positive height. It must be >=84 cm for men, and >= 67 cm for women.");
            } catch (Exception exc) {
                view.showIWText(exc.getMessage());
            }
        }

        if (e.getActionCommand().equals("Compute Body Mass Index")) {

            String inputHeight2 = view.getInputHeight2Value();
            String inputWeight2 = view.getInputWeight2Value();
            String inputAge2 = view.getInputAge2Value();
            String gender2 = (String) view.getComboBoxSexo2().getSelectedItem();

            try {
                int height = Integer.parseInt(inputHeight2);
                int weight = Integer.parseInt(inputWeight2);
                int age = Integer.parseInt(inputAge2);
                Gender gender = gender2.equals("M") ? Gender.MALE : Gender.FEMALE;  

                
                Person person = new PersonImpl(weight, height, age, gender);

                
                double bmr = model.basalMetabolicRate(person);
                view.showBMIText("The Basal Metabolic Rate is equal to: " + bmr);

            } catch (NumberFormatException exc) {
                view.showBMIText("Introduce positive numbers. Height must be < 230 cm. Weight must be < 300 kg. Age must be < 120.");
            } catch (Exception exc) {
                view.showBMIText(exc.getMessage());
            }
        }
    }
}
