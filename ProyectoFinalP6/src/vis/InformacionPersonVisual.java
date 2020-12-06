package vis;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import log.Person;
import log.Student;
import log.Technician;
import log.Worker;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;

public class InformacionPersonVisual extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextArea textAreaSkills;
	private JTextArea txtAreaAddress;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtBirthdate;
	private JTextField txtAge;
	private JTextField txtProvince;
	private JTextField txtCity;
	private JTextField txtGender;
	private JTextField txtCivilStatus;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JTextField txtWorkingStatus;

	/**
	
	 * @param person 
	 */
	public InformacionPersonVisual(Person person) {
		setTitle("Datos");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 394, 497);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblDatosPersonales = new JLabel("Datos Personales");
			lblDatosPersonales.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblDatosPersonales.setBounds(133, 11, 144, 26);
			panel.add(lblDatosPersonales);
			
			JLabel lblID = new JLabel("C\u00E9dula:");
			lblID.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblID.setBounds(26, 57, 93, 14);
			panel.add(lblID);
			
			JLabel lblName = new JLabel("Nombre:");
			lblName.setBackground(Color.WHITE);
			lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblName.setBounds(26, 82, 93, 14);
			panel.add(lblName);
			
			JLabel lblBirthDate = new JLabel("Fecha de nacimiento:");
			lblBirthDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblBirthDate.setBounds(26, 107, 135, 14);
			panel.add(lblBirthDate);
			
			JLabel lblProvince = new JLabel("Provincia:");
			lblProvince.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblProvince.setBounds(26, 132, 93, 14);
			panel.add(lblProvince);
			
			JLabel lblCity = new JLabel("Ciudad:");
			lblCity.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblCity.setBounds(26, 157, 93, 14);
			panel.add(lblCity);
			
			JLabel lblAddress = new JLabel("Direcci\u00F3n:");
			lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblAddress.setBounds(26, 182, 93, 14);
			panel.add(lblAddress);
			
			JLabel lblGender = new JLabel("G\u00E9nero:");
			lblGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblGender.setBounds(26, 246, 64, 14);
			panel.add(lblGender);
			
			JLabel lblPhone = new JLabel("Tel\u00E9fono:");
			lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPhone.setBounds(26, 271, 93, 14);
			panel.add(lblPhone);
			
			JLabel lblEmail = new JLabel("Email:");
			lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEmail.setBounds(26, 296, 93, 14);
			panel.add(lblEmail);
			
			JLabel lblSkills = new JLabel("Habilidad/es:");
			lblSkills.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblSkills.setBounds(26, 321, 93, 14);
			panel.add(lblSkills);
			
			JLabel lblWorkingStatus = new JLabel("Estado laboral:");
			lblWorkingStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblWorkingStatus.setBounds(26, 391, 93, 14);
			panel.add(lblWorkingStatus);
			
			JLabel lblAge = new JLabel("Edad:");
			lblAge.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblAge.setBounds(267, 108, 39, 14);
			panel.add(lblAge);
			
			JLabel lblMaritalStatus = new JLabel("Estado civil:");
			lblMaritalStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblMaritalStatus.setBounds(181, 246, 86, 14);
			panel.add(lblMaritalStatus);
			
			txtID = new JTextField();
			txtID.setEnabled(false);
			txtID.setDisabledTextColor(Color.GRAY);
			txtID.setBounds(114, 56, 234, 20);
			panel.add(txtID);
			txtID.setColumns(10);
			
			txtName = new JTextField();
			txtName.setEnabled(false);
			txtName.setDisabledTextColor(Color.GRAY);
			txtName.setBounds(114, 81, 234, 20);
			panel.add(txtName);
			txtName.setColumns(10);
			
			txtBirthdate = new JTextField();
			txtBirthdate.setEnabled(false);
			txtBirthdate.setDisabledTextColor(Color.GRAY);
			txtBirthdate.setBounds(171, 106, 86, 20);
			panel.add(txtBirthdate);
			txtBirthdate.setColumns(10);
			
			txtAge = new JTextField();
			txtAge.setEnabled(false);
			txtAge.setDisabledTextColor(Color.GRAY);
			txtAge.setBounds(309, 106, 39, 20);
			panel.add(txtAge);
			txtAge.setColumns(10);
			
			txtProvince = new JTextField();
			txtProvince.setEnabled(false);
			txtProvince.setDisabledTextColor(Color.GRAY);
			txtProvince.setBounds(114, 132, 234, 20);
			panel.add(txtProvince);
			txtProvince.setColumns(10);
			
			txtCity = new JTextField();
			txtCity.setEnabled(false);
			txtCity.setDisabledTextColor(Color.GRAY);
			txtCity.setColumns(10);
			txtCity.setBounds(114, 156, 234, 20);
			panel.add(txtCity);
			
			Border border = BorderFactory.createLineBorder(Color.GRAY);
			txtAreaAddress = new JTextArea();
			txtAreaAddress.setEnabled(false);
			txtAreaAddress.setDisabledTextColor(Color.GRAY);
			txtAreaAddress.setBounds(114, 182, 234, 55);
			panel.add(txtAreaAddress);
			txtAreaAddress.setBorder(BorderFactory.createCompoundBorder(border,
		            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
			txtAreaAddress.setLineWrap(true);
			txtAreaAddress.setWrapStyleWord(true);
			
			txtGender = new JTextField();
			txtGender.setEnabled(false);
			txtGender.setDisabledTextColor(Color.GRAY);
			txtGender.setBounds(114, 245, 54, 20);
			panel.add(txtGender);
			txtGender.setColumns(10);
			
			txtCivilStatus = new JTextField();
			txtCivilStatus.setEnabled(false);
			txtCivilStatus.setDisabledTextColor(Color.GRAY);
			txtCivilStatus.setBounds(262, 245, 86, 20);
			panel.add(txtCivilStatus);
			txtCivilStatus.setColumns(10);
			
			txtPhone = new JTextField();
			txtPhone.setEnabled(false);
			txtPhone.setDisabledTextColor(Color.GRAY);
			txtPhone.setBounds(114, 270, 234, 20);
			panel.add(txtPhone);
			txtPhone.setColumns(10);
			
			txtEmail = new JTextField();
			txtEmail.setEnabled(false);
			txtEmail.setDisabledTextColor(Color.GRAY);
			txtEmail.setBounds(114, 295, 234, 20);
			panel.add(txtEmail);
			txtEmail.setColumns(10);
			
			textAreaSkills = new JTextArea();
			textAreaSkills.setEnabled(false);
			textAreaSkills.setDisabledTextColor(Color.GRAY);
			textAreaSkills.setWrapStyleWord(true);
			textAreaSkills.setLineWrap(true);
			textAreaSkills.setBounds(114, 321, 234, 59);
			panel.add(textAreaSkills);
			textAreaSkills.setBorder(BorderFactory.createCompoundBorder(border,
		            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
			textAreaSkills.setLineWrap(true);
			textAreaSkills.setWrapStyleWord(true);
			
			txtWorkingStatus = new JTextField();
			txtWorkingStatus.setEnabled(false);
			txtWorkingStatus.setDisabledTextColor(Color.GRAY);
			txtWorkingStatus.setBounds(123, 390, 225, 20);
			panel.add(txtWorkingStatus);
			txtWorkingStatus.setColumns(10);
			
			JButton btnExit = new JButton("Salir");
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnExit.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnExit.setBounds(151, 429, 89, 23);
			panel.add(btnExit);
			
			setData(person);
			setBirthdate(person.getBirthDate());
			
		}
	}

	private void setBirthdate(Date birthDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(birthDate);
		int year = cal.get(Calendar.YEAR);
		System.out.println(year);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		txtBirthdate.setText(String.valueOf(day)+ " / "+ String.valueOf(month+1)+ " / "+ String.valueOf(year));
	}

	private void setData(Person person) {
		txtID.setText(person.getId());
		txtName.setText(person.getName()+person.getLastName());
		txtProvince.setText(person.getProvince());
		txtCity.setText(person.getCity());
		txtAreaAddress.setText(person.getAddress());
		txtGender.setText(person.getGender());
		txtCivilStatus.setText(person.getMaritalStatus());
		txtEmail.setText(person.getEmail());
		txtPhone.setText(person.getPhoneNumber());
		if(person.isWorkingStatus())
			txtWorkingStatus.setText("Empleado");
		else
			txtWorkingStatus.setText("Desempleado");
		if(person instanceof Student) {
			Student student=(Student)person;
			textAreaSkills.setText(student.getCareer());
		}
		else if(person instanceof Technician) {
			Technician tech=(Technician)person;
			textAreaSkills.setText(tech.getArea());
		}
		else {
			Worker worker=(Worker)person;
			String skills="";
			for(int i=0;i<worker.getSkills().size();i++)
				skills= skills+", "+worker.getSkills().get(i);
			textAreaSkills.setText(skills);
			
		}
	}
}
