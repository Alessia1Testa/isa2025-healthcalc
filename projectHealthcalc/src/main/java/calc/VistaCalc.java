package calc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTabbedPane;

public class VistaCalc extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tFHeight2;
	private JTextField tFWeight2;
	private JTextField tFAge2;
	private JTextField tFHeight1;
	private JTextField tFResultBodyMassIndex;
	private JTextField tFResultIdealWeight;
	
	private JComboBox<String> cBSexo1;
    private JComboBox<String> cBSexo2;
    private JButton btnComputeIdealWeight, btnComputeBodyMassIndex;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaCalc frame = new VistaCalc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaCalc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setToolTipText("Body Mass Index\r\nIdeal Weight");
		contentPane.add(tabbedPane, BorderLayout.WEST);
		
		JPanel panelBodyMassIndex = new JPanel();
		tabbedPane.addTab("Body Mass Index", null, panelBodyMassIndex, null);
		panelBodyMassIndex.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_S = new JPanel();
		panelBodyMassIndex.add(panel_S, BorderLayout.SOUTH);
		panel_S.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_BMI_S_N = new JPanel();
		panel_S.add(panel_BMI_S_N, BorderLayout.NORTH);
		panel_BMI_S_N.setLayout(new BorderLayout(0, 0));
		
		btnComputeBodyMassIndex = new JButton("Compute Body Mass Index");
		btnComputeBodyMassIndex.setText("Compute Body Mass Index");
		panel_BMI_S_N.add(btnComputeBodyMassIndex, BorderLayout.NORTH);
		
		JPanel panel_BMI_S_S = new JPanel();
		panel_S.add(panel_BMI_S_S, BorderLayout.SOUTH);
		panel_BMI_S_S.setLayout(new BorderLayout(0, 0));
		
		tFResultBodyMassIndex = new JTextField();
		panel_BMI_S_S.add(tFResultBodyMassIndex, BorderLayout.CENTER);
		tFResultBodyMassIndex.setColumns(80);
		
		JPanel panel_N = new JPanel();
		panelBodyMassIndex.add(panel_N, BorderLayout.NORTH);
		panel_N.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitle = new JLabel("Health Calculator");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panel_N.add(lblTitle, BorderLayout.NORTH);
		
		JPanel panel_C = new JPanel();
		panelBodyMassIndex.add(panel_C, BorderLayout.CENTER);
		panel_C.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_C_WEST = new JPanel();
		panel_C.add(panel_C_WEST, BorderLayout.WEST);
		panel_C_WEST.setLayout(new GridLayout(4, 1, 0, 0));
		
		JLabel lblSexo = new JLabel("Sexo:");
		panel_C_WEST.add(lblSexo);
		
		JLabel lblHeight2 = new JLabel("Height:");
		panel_C_WEST.add(lblHeight2);
		
		JLabel lblWeight2 = new JLabel("Weight:");
		panel_C_WEST.add(lblWeight2);
		
		JLabel lblAge2 = new JLabel("Age:");
		panel_C_WEST.add(lblAge2);
		
		JPanel panel_C_EAST = new JPanel();
		panel_C.add(panel_C_EAST, BorderLayout.EAST);
		panel_C_EAST.setLayout(new GridLayout(4, 1, 0, 0));
		
		cBSexo2 = new JComboBox<String>();
        cBSexo2.setModel(new DefaultComboBoxModel<>(new String[] {"M", "F"}));
        cBSexo2.setToolTipText("");
        panel_C_EAST.add(cBSexo2);
		
		tFHeight2 = new JTextField();
		tFHeight2.setColumns(1);
		panel_C_EAST.add(tFHeight2);
		
		tFWeight2 = new JTextField();
		tFWeight2.setColumns(10);
		panel_C_EAST.add(tFWeight2);
		
		tFAge2 = new JTextField();
		tFAge2.setColumns(10);
		panel_C_EAST.add(tFAge2);
		
		JPanel panel_IdealWeight = new JPanel();
		tabbedPane.addTab("Ideal Weight", null, panel_IdealWeight, null);
		panel_IdealWeight.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_IW_N = new JPanel();
		panel_IdealWeight.add(panel_IW_N, BorderLayout.NORTH);
		panel_IW_N.setLayout(new BorderLayout(0, 0));
		
		JLabel lbl_IWTitle = new JLabel("Health Calculator");
		lbl_IWTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panel_IW_N.add(lbl_IWTitle, BorderLayout.NORTH);
		
		JPanel panel_IW_C = new JPanel();
		panel_IdealWeight.add(panel_IW_C, BorderLayout.CENTER);
		panel_IW_C.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_IW_C_WEST = new JPanel();
		panel_IW_C.add(panel_IW_C_WEST, BorderLayout.WEST);
		panel_IW_C_WEST.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblSexo1 = new JLabel("Sexo:");
		panel_IW_C_WEST.add(lblSexo1);
		
		JLabel lblHeight1 = new JLabel("Height:");
		panel_IW_C_WEST.add(lblHeight1);
		
		JPanel panel_IW_C_EAST = new JPanel();
		panel_IW_C.add(panel_IW_C_EAST, BorderLayout.EAST);
		panel_IW_C_EAST.setLayout(new GridLayout(2, 1, 0, 0));
		
		cBSexo1 = new JComboBox<String>();
        cBSexo1.setModel(new DefaultComboBoxModel<>(new String[] {"M", "F"}));
        cBSexo1.setToolTipText("");
        panel_IW_C_EAST.add(cBSexo1);
		
		tFHeight1 = new JTextField();
		panel_IW_C_EAST.add(tFHeight1);
		tFHeight1.setColumns(10);
		
		JPanel panel_IW_S = new JPanel();
		panel_IdealWeight.add(panel_IW_S, BorderLayout.SOUTH);
		panel_IW_S.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_IW_S_N = new JPanel();
		panel_IW_S.add(panel_IW_S_N, BorderLayout.NORTH);
		panel_IW_S_N.setLayout(new BorderLayout(0, 0));
		
		btnComputeIdealWeight = new JButton("Compute Ideal Weight");
		btnComputeIdealWeight.setText("Compute Ideal Weight");
		panel_IW_S_N.add(btnComputeIdealWeight, BorderLayout.NORTH);
		
		JPanel panel_IW_S_S = new JPanel();
		panel_IW_S.add(panel_IW_S_S, BorderLayout.SOUTH);
		panel_IW_S_S.setLayout(new BorderLayout(0, 0));
		
		tFResultIdealWeight = new JTextField();
		panel_IW_S_S.add(tFResultIdealWeight, BorderLayout.CENTER);
		tFResultIdealWeight.setColumns(80);
		
		this.pack();
		this.setVisible(true);
	}
	
	public String getInputHeight1Value() {
        return this.tFHeight1.getText();
    }

    public String getInputHeight2Value() {
        return this.tFHeight2.getText();
    }

    public String getInputWeight2Value() {
        return this.tFWeight2.getText();
    }

    public String getInputAge2Value() {
        return this.tFAge2.getText();
    }

    
    public JComboBox<String> getComboBoxSexo1() {
        return this.cBSexo1;  
    }

    public JComboBox<String> getComboBoxSexo2() {
        return this.cBSexo2; 
    }

    
    public void showIWText(String message) {
    	this.tFResultIdealWeight.setText(message);  
    	System.out.println(tFResultIdealWeight);
    }

    public void showBMIText(String message) {
        this.tFResultBodyMassIndex.setText(message); 
        System.out.println(tFResultBodyMassIndex);
    }

	public void registerController(ControllerCalc c) {
        this.btnComputeIdealWeight.addActionListener(c);
        this.btnComputeIdealWeight.setActionCommand("Compute Ideal Weight");

        this.btnComputeBodyMassIndex.addActionListener(c);
        this.btnComputeBodyMassIndex.setActionCommand("Compute Body Mass Index");
    }

}