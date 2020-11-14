package vis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class EmployeeReg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtLastName;
	private JTextField txtAddress;
	private JTextField txtCity;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JPanel pnlGeneral;
	private JComboBox<String> cbxProvince;
	private JComboBox<String> cbxMaritalStatus;
	private JComboBox<String> cbxGenre;
	private JSpinner spnBirth;
	private JPanel pnlJobInfo;
	private JButton btnFinish;
	private JButton btnNext;
	private JButton btnBack;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EmployeeReg dialog = new EmployeeReg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EmployeeReg() {
		setBounds(100, 100, 680, 749);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		pnlJobInfo = new JPanel();
		pnlJobInfo.setVisible(false);
		
		pnlGeneral = new JPanel();
		pnlGeneral.setLayout(null);
		pnlGeneral.setBorder(null);
		pnlGeneral.setBackground(Color.WHITE);
		pnlGeneral.setBounds(0,0,664,667);
		contentPanel.add(pnlGeneral);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 35, 644, 2);
		pnlGeneral.add(separator_2);
		
		JLabel lblInformacinGeneral = new JLabel("Informaci\u00F3n general");
		lblInformacinGeneral.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInformacinGeneral.setBounds(21, 11, 187, 21);
		pnlGeneral.add(lblInformacinGeneral);
		
		JLabel label_2 = new JLabel("ID:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(21, 61, 36, 27);
		pnlGeneral.add(label_2);
		
		JLabel label_3 = new JLabel("Nombres:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_3.setBounds(21, 107, 70, 27);
		pnlGeneral.add(label_3);
		
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(67, 61, 145, 28);
		pnlGeneral.add(txtID);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtName.setColumns(10);
		txtName.setBounds(111, 108, 191, 28);
		pnlGeneral.add(txtName);
		
		JLabel label_4 = new JLabel("Apellidos:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_4.setBounds(22, 158, 82, 27);
		pnlGeneral.add(label_4);
		
		txtLastName = new JTextField();
		txtLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtLastName.setColumns(10);
		txtLastName.setBounds(111, 157, 191, 28);
		pnlGeneral.add(txtLastName);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDireccin.setBounds(21, 319, 89, 27);
		pnlGeneral.add(lblDireccin);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(111, 318, 494, 28);
		pnlGeneral.add(txtAddress);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 245, 644, 2);
		pnlGeneral.add(separator_3);
		
		JLabel lblInformacinDeUbicacin = new JLabel("Informaci\u00F3n de ubicaci\u00F3n");
		lblInformacinDeUbicacin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInformacinDeUbicacin.setBounds(21, 219, 202, 21);
		pnlGeneral.add(lblInformacinDeUbicacin);
		
		JLabel label_7 = new JLabel("Provincia:");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_7.setBounds(21, 271, 89, 27);
		pnlGeneral.add(label_7);
		
		cbxProvince = new JComboBox<String>();
		cbxProvince.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbxProvince.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>", "Azua", "Bahoruco", "Barahona", "Dajab\u00F3n", "Distrito Nacional", "Duarte", "El\u00EDas Pi\u00F1a", "El Seibo", "Espaillat", "Hato Mayor", "Hermanas Mirabal", "Independencia", "La Altagracia", "La Romana", "La Vega", "Mar\u00EDa Trinidad S\u00E1nchez", "Monse\u00F1or Nouel", "Monte Cristi", "Monte Plata", "Pedernales", "Peravia", "Puerto Plata", "Saman\u00E1", "S\u00E1nchez Ram\u00EDrez", "San Crist\u00F3bal", "San Jos\u00E9 de Ocoa", "San Juan", "San Pedro de Macor\u00EDs", "Santiago", "Santiago Rodr\u00EDguez", "Santo Domingo", "Valverde"}));
		cbxProvince.setBounds(111, 271, 179, 27);
		pnlGeneral.add(cbxProvince);
		
		JLabel label_8 = new JLabel("Ciudad:");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_8.setBounds(328, 271, 89, 27);
		pnlGeneral.add(label_8);
		
		txtCity = new JTextField();
		txtCity.setColumns(10);
		txtCity.setBounds(401, 270, 145, 28);
		pnlGeneral.add(txtCity);
		
		JLabel lblEstadoCivil = new JLabel("Estado Civil:");
		lblEstadoCivil.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEstadoCivil.setBounds(327, 158, 94, 27);
		pnlGeneral.add(lblEstadoCivil);
		
		cbxMaritalStatus = new JComboBox<String>();
		cbxMaritalStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbxMaritalStatus.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>", "Soltero ", "Casado", "Uni\u00F3n Libre", "Viudo"}));
		cbxMaritalStatus.setBounds(431, 158, 179, 27);
		pnlGeneral.add(cbxMaritalStatus);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSexo.setBounds(327, 107, 103, 27);
		pnlGeneral.add(lblSexo);
		
		cbxGenre = new JComboBox<String>();
		cbxGenre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbxGenre.setModel(new DefaultComboBoxModel<String>(new String[] {"<Sin especificar>", "Masculino", "Femenino"}));
		cbxGenre.setBounds(391, 109, 145, 27);
		pnlGeneral.add(cbxGenre);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFechaDeNacimiento.setBounds(285, 61, 202, 27);
		pnlGeneral.add(lblFechaDeNacimiento);
		
		spnBirth = new JSpinner();
		spnBirth.setModel(new SpinnerDateModel(new Date(1605240000000L), null, null, Calendar.DAY_OF_YEAR));
		spnBirth.setBounds(447, 61, 163, 27);
		pnlGeneral.add(spnBirth);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 408, 644, 2);
		pnlGeneral.add(separator);
		
		JLabel lblInformacinDeContacto = new JLabel("Informaci\u00F3n de contacto");
		lblInformacinDeContacto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInformacinDeContacto.setBounds(21, 382, 202, 21);
		pnlGeneral.add(lblInformacinDeContacto);
		
		JLabel lblCorreoElectronico = new JLabel("Correo electronico:");
		lblCorreoElectronico.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCorreoElectronico.setBounds(21, 437, 145, 27);
		pnlGeneral.add(lblCorreoElectronico);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(176, 434, 311, 28);
		pnlGeneral.add(txtEmail);
		
		JLabel lblNmeroTelefnico = new JLabel("N\u00FAmero telef\u00F3nico:");
		lblNmeroTelefnico.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNmeroTelefnico.setBounds(21, 483, 145, 27);
		pnlGeneral.add(lblNmeroTelefnico);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(176, 484, 145, 28);
		pnlGeneral.add(txtPhone);
		
		JCheckBox checkBox = new JCheckBox("Disponibilidad para viajar");
		checkBox.setBackground(Color.WHITE);
		checkBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		checkBox.setBounds(52, 596, 193, 23);
		pnlGeneral.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("Disponibilidad para mudarse");
		checkBox_1.setBackground(Color.WHITE);
		checkBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		checkBox_1.setBounds(398, 596, 212, 23);
		pnlGeneral.add(checkBox_1);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(10, 570, 644, 2);
		pnlGeneral.add(separator_5);
		
		JLabel lblCondicionesLaborales = new JLabel("Condiciones laborales");
		lblCondicionesLaborales.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCondicionesLaborales.setBounds(21, 544, 202, 21);
		pnlGeneral.add(lblCondicionesLaborales);
		pnlJobInfo.setBackground(Color.WHITE);
		pnlJobInfo.setBounds(0, 0, 664, 677);
		contentPanel.add(pnlJobInfo);
		pnlJobInfo.setLayout(null);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 35, 644, 2);
		pnlJobInfo.add(separator_1);
		
		JLabel lblProfesin = new JLabel("Informaci\u00F3n Laboral");
		lblProfesin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProfesin.setBounds(21, 11, 187, 21);
		pnlJobInfo.add(lblProfesin);
		
		JLabel lblStudent = new JLabel("New label");
		Image student = new ImageIcon(this.getClass().getResource("/student.png")).getImage();
		lblStudent.setIcon(new ImageIcon(student));
		lblStudent.setBounds(20, 116, 161, 141);
		pnlJobInfo.add(lblStudent);
		
		JLabel lblTech = new JLabel("");
		Image tech = new ImageIcon(this.getClass().getResource("/technician.png")).getImage();
		lblTech.setIcon(new ImageIcon(tech));
		lblTech.setBounds(243, 116, 161, 141);
		pnlJobInfo.add(lblTech);
		
		JLabel lblWorker = new JLabel("");
		Image worker = new ImageIcon(this.getClass().getResource("/worker.png")).getImage();
		lblWorker.setIcon(new ImageIcon(worker));
		lblWorker.setBounds(470, 116, 161, 141);
		pnlJobInfo.add(lblWorker);
		
		JRadioButton rdbTech = new JRadioButton("T\u00E9cnico");
		rdbTech.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbTech.setHorizontalAlignment(SwingConstants.CENTER);
		rdbTech.setBackground(Color.WHITE);
		rdbTech.setBounds(253, 86, 109, 23);
		pnlJobInfo.add(rdbTech);
		
		JRadioButton rdbWorker = new JRadioButton("Obrero");
		rdbWorker.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbWorker.setHorizontalAlignment(SwingConstants.CENTER);
		rdbWorker.setBackground(Color.WHITE);
		rdbWorker.setBounds(486, 86, 109, 23);
		pnlJobInfo.add(rdbWorker);
		
		JLabel lblProfesin_1 = new JLabel("Profesi\u00F3n:");
		lblProfesin_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProfesin_1.setBounds(20, 48, 224, 27);
		pnlJobInfo.add(lblProfesin_1);
		
		JRadioButton rdbStudent = new JRadioButton("Estudiante");
		rdbStudent.setSelected(true);
		rdbStudent.setHorizontalAlignment(SwingConstants.CENTER);
		rdbStudent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbStudent.setBackground(Color.WHITE);
		rdbStudent.setBounds(44, 86, 109, 23);
		pnlJobInfo.add(rdbStudent);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(10, 294, 644, 2);
		pnlJobInfo.add(separator_4);
		
		JLabel lblExperienciaLaboral = new JLabel("Experiencia Laboral");
		lblExperienciaLaboral.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblExperienciaLaboral.setBounds(21, 268, 187, 21);
		pnlJobInfo.add(lblExperienciaLaboral);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 307, 644, 359);
		pnlJobInfo.add(panel);
		panel.setLayout(null);
		
		JLabel label_5 = new JLabel("Idiomas dominados:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_5.setBounds(23, 11, 161, 27);
		panel.add(label_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(23, 49, 161, 20);
		panel.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(384, 11, 238, 205);
		panel.add(scrollPane);
		
		JButton button = new JButton("A\u00F1adir >");
		button.setBounds(57, 89, 89, 23);
		panel.add(button);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(23, 188, 330, 28);
		panel.add(textField);
		
		JLabel lblUniversidad = new JLabel("Universidad:");
		lblUniversidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUniversidad.setBounds(23, 148, 161, 27);
		panel.add(lblUniversidad);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(23, 291, 285, 28);
		panel.add(textField_1);
		
		JLabel lblCarrera = new JLabel("Carrera:");
		lblCarrera.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCarrera.setBounds(23, 251, 161, 27);
		panel.add(lblCarrera);
		
		JLabel lblCuatrimestresCursados = new JLabel("Cuatrimestres cursados");
		lblCuatrimestresCursados.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuatrimestresCursados.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCuatrimestresCursados.setBounds(405, 251, 198, 27);
		panel.add(lblCuatrimestresCursados);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinner.setBounds(481, 292, 63, 28);
		panel.add(spinner);
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnBack = new JButton("< Atr\u00E1s");
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnBack.setEnabled(false);
						pnlJobInfo.setVisible(false);
						pnlGeneral.setVisible(true);
						btnNext.setEnabled(true);
						btnFinish.setEnabled(false);
					}
				});
				btnBack.setEnabled(false);
				buttonPane.add(btnBack);
			}
			{
				btnNext = new JButton("Siguiente >");
				btnNext.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						pnlGeneral.setVisible(false);
						pnlJobInfo.setVisible(true);
						btnNext.setEnabled(false);
						btnBack.setEnabled(true);
						btnFinish.setEnabled(true);
					}
				});
				btnNext.setActionCommand("OK");
				buttonPane.add(btnNext);
				getRootPane().setDefaultButton(btnNext);
			}
			
			btnFinish = new JButton("Finalizar");
			btnFinish.setEnabled(false);
			buttonPane.add(btnFinish);
			{
				JButton btnCancel = new JButton("Cancelar");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
	}
}
