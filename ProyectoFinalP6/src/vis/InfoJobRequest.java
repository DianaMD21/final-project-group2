package vis;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import log.EmployeeRequest;
import log.Person;
import log.Student;
import log.Technician;
import log.Worker;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InfoJobRequest extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtMinSalary;
	private JTextField txtHours;
	private JPanel pnlGeneral;
	private JCheckBox chboxLicense;
	private JCheckBox chboxMove;
	private JCheckBox chboxTravel;
	private JTextField txtYear;
	private JLabel lblImage;
	private JLabel lblPerson;
	private JPanel pnlWorker;
	private JList<String> listLan1;
	private JList<String> listSkills;
	private JPanel pnlStudent;
	private JLabel label_3;
	private JScrollPane scrollPane_2;
	private JLabel lblCarrera;
	private JTextField txtCareer;
	private JLabel lblUniversidad;
	private JList<String> listLan2;
	private JTextPane txtUniversity;
	private JPanel pnlTech;
	private JLabel label_4;
	private JScrollPane scrollPane_3;
	private JLabel label_5;
	private JTextField txtYear2;
	private JLabel lblInstitucin;
	private JTextField txtInstitute;
	private JLabel lblArea;
	private JTextPane txtArea;
	private JList<String> listLan3;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InfoJobRequest dialog = new InfoJobRequest(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InfoJobRequest(EmployeeRequest aux) {
		setTitle("Datos Laborales");
		setBounds(100, 100, 420, 546);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		Person p = aux.getApplicant();
		
		pnlGeneral = new JPanel();
		pnlGeneral.setLayout(null);
		pnlGeneral.setBackground(Color.WHITE);
		pnlGeneral.setBounds(0, 0, 403, 507);
		contentPanel.add(pnlGeneral);
		
		lblImage = new JLabel("");
		lblImage.setBounds(24, 49, 161, 141);
		pnlGeneral.add(lblImage);
		
		lblPerson = new JLabel("");
		lblPerson.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerson.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPerson.setBounds(24, 11, 135, 26);
		pnlGeneral.add(lblPerson);
		
		JLabel lblSalarioMinimo = new JLabel("Salario minimo:");
		lblSalarioMinimo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSalarioMinimo.setBounds(195, 34, 93, 19);
		pnlGeneral.add(lblSalarioMinimo);
		
		txtMinSalary = new JTextField();
		txtMinSalary.setText((String) null);
		txtMinSalary.setEnabled(false);
		txtMinSalary.setDisabledTextColor(Color.GRAY);
		txtMinSalary.setColumns(10);
		txtMinSalary.setBounds(298, 33, 83, 20);
		pnlGeneral.add(txtMinSalary);
		
		JLabel lblHorasDeTrabajo = new JLabel("Horas de trabajo:");
		lblHorasDeTrabajo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHorasDeTrabajo.setBounds(195, 64, 121, 19);
		pnlGeneral.add(lblHorasDeTrabajo);
		
		txtHours = new JTextField();
		txtHours.setText((String) null);
		txtHours.setEnabled(false);
		txtHours.setDisabledTextColor(Color.GRAY);
		txtHours.setColumns(10);
		txtHours.setBounds(326, 64, 42, 20);
		pnlGeneral.add(txtHours);
		
		JLabel lblDisponibilidad = new JLabel("Disponibilidad");
		lblDisponibilidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblDisponibilidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDisponibilidad.setBounds(236, 105, 93, 19);
		pnlGeneral.add(lblDisponibilidad);
		
		chboxTravel = new JCheckBox("Viajar");
		chboxTravel.setBackground(Color.WHITE);
		chboxTravel.setBounds(201, 131, 59, 23);
		pnlGeneral.add(chboxTravel);
		
		chboxMove = new JCheckBox("Mudanza");
		chboxMove.setHorizontalAlignment(SwingConstants.CENTER);
		chboxMove.setBackground(Color.WHITE);
		chboxMove.setBounds(284, 131, 97, 23);
		pnlGeneral.add(chboxMove);
		
		JLabel lblNewLabel = new JLabel("Licencia de conducir");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(223, 161, 121, 14);
		pnlGeneral.add(lblNewLabel);
		
		chboxLicense = new JCheckBox("");
		chboxLicense.setBackground(Color.WHITE);
		chboxLicense.setBounds(267, 173, 21, 26);
		pnlGeneral.add(chboxLicense);
		
		pnlWorker = new JPanel();
		pnlWorker.setBackground(Color.WHITE);
		pnlWorker.setBounds(10, 199, 383, 255);
		pnlGeneral.add(pnlWorker);
		pnlWorker.setLayout(null);
		
		JLabel label = new JLabel("Idiomas");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(21, 60, 144, 26);
		pnlWorker.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 97, 170, 148);
		pnlWorker.add(scrollPane);
		
		listLan1 = new JList<String>();
		scrollPane.setViewportView(listLan1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(196, 97, 171, 148);
		pnlWorker.add(scrollPane_1);
		
		listSkills = new JList<String>();
		scrollPane_1.setViewportView(listSkills);
		
		JLabel label_1 = new JLabel("Habilidades");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(207, 60, 144, 26);
		pnlWorker.add(label_1);
		
		JLabel label_2 = new JLabel("A\u00F1os de experiencia");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(10, 0, 145, 19);
		pnlWorker.add(label_2);
		
		txtYear = new JTextField();
		txtYear.setText((String) null);
		txtYear.setEnabled(false);
		txtYear.setDisabledTextColor(Color.GRAY);
		txtYear.setColumns(10);
		txtYear.setBounds(66, 23, 36, 19);
		pnlWorker.add(txtYear);
		
		pnlStudent = new JPanel();
		pnlStudent.setBackground(Color.WHITE);
		pnlStudent.setBounds(10, 199, 383, 255);
		pnlGeneral.add(pnlStudent);
		pnlStudent.setLayout(null);
		
		label_3 = new JLabel("Idiomas");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_3.setBounds(21, 59, 144, 26);
		pnlStudent.add(label_3);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 96, 170, 148);
		pnlStudent.add(scrollPane_2);
		
		listLan2 = new JList<String>();
		scrollPane_2.setViewportView(listLan2);
		
		lblCarrera = new JLabel("Carrera:");
		lblCarrera.setHorizontalAlignment(SwingConstants.LEFT);
		lblCarrera.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCarrera.setBounds(10, 11, 69, 26);
		pnlStudent.add(lblCarrera);
		
		txtCareer = new JTextField();
		txtCareer.setBounds(89, 11, 284, 26);
		pnlStudent.add(txtCareer);
		txtCareer.setColumns(10);
		
		lblUniversidad = new JLabel("Universidad");
		lblUniversidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblUniversidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUniversidad.setBounds(215, 96, 133, 26);
		pnlStudent.add(lblUniversidad);
		
		txtUniversity = new JTextPane();
		txtUniversity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUniversity.setBounds(203, 127, 170, 91);
		pnlStudent.add(txtUniversity);
		
		pnlTech = new JPanel();
		pnlTech.setBackground(Color.WHITE);
		pnlTech.setBounds(10, 199, 383, 255);
		pnlGeneral.add(pnlTech);
		pnlTech.setLayout(null);
		
		label_4 = new JLabel("Idiomas");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_4.setBounds(21, 59, 144, 26);
		pnlTech.add(label_4);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 96, 170, 148);
		pnlTech.add(scrollPane_3);
		
		listLan3 = new JList<String>();
		scrollPane_3.setViewportView(listLan3);
		
		label_5 = new JLabel("A\u00F1os de experiencia");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(20, 6, 145, 19);
		pnlTech.add(label_5);
		
		txtYear2 = new JTextField();
		txtYear2.setText((String) null);
		txtYear2.setEnabled(false);
		txtYear2.setDisabledTextColor(Color.GRAY);
		txtYear2.setColumns(10);
		txtYear2.setBounds(76, 29, 36, 19);
		pnlTech.add(txtYear2);
		
		lblInstitucin = new JLabel("Instituci\u00F3n");
		lblInstitucin.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstitucin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblInstitucin.setBounds(226, 6, 128, 26);
		pnlTech.add(lblInstitucin);
		
		txtInstitute = new JTextField();
		txtInstitute.setText((String) null);
		txtInstitute.setEnabled(false);
		txtInstitute.setDisabledTextColor(Color.GRAY);
		txtInstitute.setColumns(10);
		txtInstitute.setBounds(209, 33, 164, 26);
		pnlTech.add(txtInstitute);
		
		lblArea = new JLabel("Area");
		lblArea.setHorizontalAlignment(SwingConstants.CENTER);
		lblArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblArea.setBounds(215, 109, 133, 26);
		pnlTech.add(lblArea);
		
		txtArea = new JTextPane();
		txtArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtArea.setBounds(203, 140, 170, 91);
		pnlTech.add(txtArea);
		
		load(aux);
		
		
		if(p instanceof Worker) {
			Image worker = new ImageIcon(this.getClass().getResource("/worker.png")).getImage();
			lblImage.setIcon(new ImageIcon(worker));
			lblPerson.setText("Obrero");
			pnlWorker.setVisible(true);
			pnlTech.setVisible(false);
			pnlStudent.setVisible(false);
			loadWorker(aux);
		}
		
		if(p instanceof Student) {
			Image student = new ImageIcon(this.getClass().getResource("/student.png")).getImage();
			lblImage.setIcon(new ImageIcon(student));
			lblPerson.setText("Egresado");
			pnlStudent.setVisible(true);
			pnlTech.setVisible(false);
			pnlWorker.setVisible(false);
			loadStudent(aux);
		}
		
		if(p instanceof Technician) {
			Image tech = new ImageIcon(this.getClass().getResource("/technician.png")).getImage();
			lblImage.setIcon(new ImageIcon(tech));
			lblPerson.setText("Técnico");
			pnlTech.setVisible(true);
			pnlStudent.setVisible(false);
			pnlWorker.setVisible(false);
			loadTechnician(aux);
		}
		
		
		
		btnNewButton = new JButton("Salir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(161, 473, 89, 23);
		pnlGeneral.add(btnNewButton);
	}

	private void load(EmployeeRequest aux) {
		txtMinSalary.setText(""+aux.getMinSalary());
		if(aux.isDrivingLicense()) {
			chboxLicense.setSelected(true);
		}else {
			chboxLicense.setSelected(false);
		}
		if(aux.isMoveAv()) {
			chboxMove.setSelected(true);
		}else {
			chboxMove.setSelected(false);
		}
		if(aux.isTravelAv()) {
			chboxTravel.setSelected(true);
		}else {
			chboxTravel.setSelected(false);
		}
		txtHours.setText(""+aux.getWorkingHours());
		
	}

	private void loadTechnician(EmployeeRequest aux) {
		Technician t = (Technician) aux.getApplicant();
		DefaultListModel<String> model = new DefaultListModel<String>();
		for (String l : aux.getLanguages()) {
			model.addElement(l);
		}
		listLan3.setModel(model);
		txtYear2.setText(""+t.getWorkExperienceYears());
		txtInstitute.setText(t.getInstitution());
		txtArea.setText(t.getArea());
	}

	private void loadStudent(EmployeeRequest aux) {
		Student s = (Student) aux.getApplicant();
		DefaultListModel<String> model = new DefaultListModel<String>();
		for (String l : aux.getLanguages()) {
			model.addElement(l);
		}
		listLan2.setModel(model);
		txtCareer.setText(s.getCareer());
		txtUniversity.setText(s.getUniversity());	
	}

	private void loadWorker(EmployeeRequest aux) {
		Worker w = (Worker) aux.getApplicant();
		DefaultListModel<String> model = new DefaultListModel<String>();
		for (String l : aux.getLanguages()) {
			model.addElement(l);
		}
		listLan1.setModel(model);
		DefaultListModel<String> model1 = new DefaultListModel<String>();
		for (String s : w.getSkills()) {
			model1.addElement(s);
		}
		listSkills.setModel(model1);
		txtYear.setText(""+w.getWorkExperience());
	}
}
