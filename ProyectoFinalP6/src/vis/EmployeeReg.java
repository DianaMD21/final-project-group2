package vis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import log.JobCenter;
import log.Person;
import log.Student;
import log.Technician;
import log.Worker;
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
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SpinnerNumberModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;

public class EmployeeReg extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5978503155461006358L;
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
	private JTextField txtCollege;
	private JTextField txtCareer;
	private JRadioButton rdbStudent;
	private JRadioButton rdbWorker;
	private JRadioButton rdbTech;
	private JPanel pnlStudent;
	private JPanel pnlTech;
	private JPanel pnlWorker;
	private JComboBox<String> cbxLanguage;
	private ArrayList<String> languages;
	private JList<String> listLanguages;
	private DefaultListModel<String> modelLanguages;
	private ArrayList<String> areasS;
	private DefaultListModel<String> areasSel;
	private ArrayList<String> areasAva;
	private JList<String> listAvAreas;
	private DefaultListModel<String> areasA;
	private JList<String> listSelectedAreas;
	private int choose;
	private int choose2;
	private JButton btnAddArea;
	private JButton btnRemoveArea;
	private DefaultListModel<String> SkillsA;
	private DefaultListModel<String> SkillsS;
	private JList<String> listSkillsSelected;
	private JList<String> listSkillsAva;
	private ArrayList<String> SkillsAva;
	private ArrayList<String> SkillsSelected;
	private JButton btnRemoveSkill;
	private JButton btnAddSkill;
	private int choose3;
	private int choose4;
	private JCheckBox checkTravel;
	private JCheckBox checkMove;
	private JSpinner spnYearExp;
	private JSpinner spnExpYears;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EmployeeReg dialog = new EmployeeReg(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EmployeeReg(Person mod) {
		choose = -1;
		choose2 = -1;
		choose3 = -1;
		choose4 = -1;
		areasS = new ArrayList<String>();
		SkillsAva =new ArrayList<String>();
		SkillsSelected = new ArrayList<String>();
		modelLanguages = new DefaultListModel<String>();
		languages = new ArrayList<String>();
		setTitle("Registar Empleado");
		setBounds(100, 100, 680, 749);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		SkillsS = new DefaultListModel<>();
		
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
		
		JLabel lblCedula = new JLabel("C\u00E9dula:");
		lblCedula.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCedula.setBounds(21, 61, 70, 27);
		pnlGeneral.add(lblCedula);
		
		JLabel label_3 = new JLabel("Nombres:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_3.setBounds(21, 107, 70, 27);
		pnlGeneral.add(label_3);
		
		txtID = new JTextField();
		txtID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				updateNext();
			}
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9'))
                        && (caracter != '\b')  || (txtID.getText().length()==11)) {
                    e.consume();
                    
                }
			}
		});
		txtID.setColumns(10);
		txtID.setBounds(88, 62, 145, 28);
		pnlGeneral.add(txtID);
		
		txtName = new JTextField();
		txtName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				updateNext();
			}
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
                if (((caracter < 'a') || (caracter > 'z')) && ((caracter < 'A') || (caracter > 'Z'))
                        && (caracter != '\b') && (caracter!=32)) {
                    e.consume();
                }
			}
		});
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtName.setColumns(10);
		txtName.setBounds(111, 108, 191, 28);
		pnlGeneral.add(txtName);
		
		JLabel label_4 = new JLabel("Apellidos:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_4.setBounds(22, 158, 82, 27);
		pnlGeneral.add(label_4);
		
		txtLastName = new JTextField();
		txtLastName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				updateNext();
			}
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
                if (((caracter < 'a') || (caracter > 'z')) && ((caracter < 'A') || (caracter > 'Z'))
                        && (caracter != '\b') && (caracter!=32)) {
                    e.consume();
                }
			}
		});
		txtLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtLastName.setColumns(10);
		txtLastName.setBounds(111, 157, 191, 28);
		pnlGeneral.add(txtLastName);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDireccin.setBounds(21, 319, 89, 27);
		pnlGeneral.add(lblDireccin);
		
		txtAddress = new JTextField();
		txtAddress.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				updateNext();
			}
		});
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
		cbxProvince.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateNext();
			}
		});
		cbxProvince.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbxProvince.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>", "Azua", "Bahoruco", "Barahona", "Dajab\u00F3n", "Distrito Nacional", "Duarte", "El\u00EDas Pi\u00F1a", "El Seibo", "Espaillat", "Hato Mayor", "Hermanas Mirabal", "Independencia", "La Altagracia", "La Romana", "La Vega", "Mar\u00EDa Trinidad S\u00E1nchez", "Monse\u00F1or Nouel", "Monte Cristi", "Monte Plata", "Pedernales", "Peravia", "Puerto Plata", "Saman\u00E1", "S\u00E1nchez Ram\u00EDrez", "San Crist\u00F3bal", "San Jos\u00E9 de Ocoa", "San Juan", "San Pedro de Macor\u00EDs", "Santiago", "Santiago Rodr\u00EDguez", "Santo Domingo", "Valverde"}));
		cbxProvince.setBounds(111, 271, 179, 27);
		pnlGeneral.add(cbxProvince);
		
		JLabel label_8 = new JLabel("Ciudad:");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_8.setBounds(328, 271, 70, 27);
		pnlGeneral.add(label_8);
		
		txtCity = new JTextField();
		txtCity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				updateNext();
			}
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
                if (((caracter < 'a') || (caracter > 'z')) && ((caracter < 'A') || (caracter > 'Z'))
                        && (caracter != '\b') && (caracter!=32)) {
                    e.consume();
                }
			}
		});
		txtCity.setColumns(10);
		txtCity.setBounds(401, 270, 145, 28);
		pnlGeneral.add(txtCity);
		
		JLabel lblEstadoCivil = new JLabel("Estado Civil:");
		lblEstadoCivil.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEstadoCivil.setBounds(327, 158, 94, 27);
		pnlGeneral.add(lblEstadoCivil);
		
		cbxMaritalStatus = new JComboBox<String>();
		cbxMaritalStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateNext();
			}
		});
		cbxMaritalStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbxMaritalStatus.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>", "Soltero ", "Casado", "Uni\u00F3n Libre", "Viudo"}));
		cbxMaritalStatus.setBounds(431, 158, 179, 27);
		pnlGeneral.add(cbxMaritalStatus);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSexo.setBounds(327, 107, 103, 27);
		pnlGeneral.add(lblSexo);
		
		cbxGenre = new JComboBox<String>();
		cbxGenre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateNext();
			}
		});
		cbxGenre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbxGenre.setModel(new DefaultComboBoxModel<String>(new String[] {"<Sin especificar>", "Masculino", "Femenino"}));
		cbxGenre.setBounds(391, 109, 145, 27);
		pnlGeneral.add(cbxGenre);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFechaDeNacimiento.setBounds(285, 61, 160, 27);
		pnlGeneral.add(lblFechaDeNacimiento);
		
		spnBirth = new JSpinner();
		spnBirth.setModel(new SpinnerDateModel(new Date(1009857600000L), new Date(-1577906844000L), new Date(1072929600000L), Calendar.DAY_OF_YEAR));
		spnBirth.setBounds(447, 61, 70, 27);
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
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				updateNext();
			}
		});
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(176, 434, 311, 28);
		pnlGeneral.add(txtEmail);
		
		JLabel lblNmeroTelefnico = new JLabel("N\u00FAmero telef\u00F3nico:");
		lblNmeroTelefnico.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNmeroTelefnico.setBounds(21, 483, 145, 27);
		pnlGeneral.add(lblNmeroTelefnico);
		
		txtPhone = new JTextField();
		txtPhone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				updateNext();
			}
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9'))
                        && (caracter != '\b')  ) {
                    e.consume();
                    
                }
			}
		});
		txtPhone.setColumns(10);
		txtPhone.setBounds(176, 484, 145, 28);
		pnlGeneral.add(txtPhone);
		
		checkTravel = new JCheckBox("Disponibilidad para viajar");
		checkTravel.setBackground(Color.WHITE);
		checkTravel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		checkTravel.setBounds(52, 596, 193, 23);
		pnlGeneral.add(checkTravel);
		
		checkMove = new JCheckBox("Disponibilidad para mudarse");
		checkMove.setBackground(Color.WHITE);
		checkMove.setFont(new Font("Tahoma", Font.PLAIN, 14));
		checkMove.setBounds(398, 596, 212, 23);
		pnlGeneral.add(checkMove);
		
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
		
		JLabel lblProfesion = new JLabel("Informaci\u00F3n laboral");
		lblProfesion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProfesion.setBounds(21, 11, 187, 21);
		pnlJobInfo.add(lblProfesion);
		
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
		
		rdbTech = new JRadioButton("T\u00E9cnico");
		rdbTech.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbStudent.setSelected(false);
				rdbWorker.setSelected(false);
				pnlStudent.setVisible(false);
				pnlTech.setVisible(true);
				pnlWorker.setVisible(false);
			}
		});
		rdbTech.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbTech.setHorizontalAlignment(SwingConstants.CENTER);
		rdbTech.setBackground(Color.WHITE);
		rdbTech.setBounds(253, 86, 109, 23);
		pnlJobInfo.add(rdbTech);
		
		rdbWorker = new JRadioButton("Obrero");
		rdbWorker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbTech.setSelected(false);
				rdbStudent.setSelected(false);
				pnlStudent.setVisible(false);
				pnlTech.setVisible(false);
				pnlWorker.setVisible(true);
			}
		});
		rdbWorker.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbWorker.setHorizontalAlignment(SwingConstants.CENTER);
		rdbWorker.setBackground(Color.WHITE);
		rdbWorker.setBounds(486, 86, 109, 23);
		pnlJobInfo.add(rdbWorker);
		
		JLabel lblProfesin_1 = new JLabel("Profesi\u00F3n:");
		lblProfesin_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProfesin_1.setBounds(20, 48, 224, 27);
		pnlJobInfo.add(lblProfesin_1);
		
		rdbStudent = new JRadioButton("Estudiante");
		rdbStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbTech.setSelected(false);
				rdbWorker.setSelected(false);
				pnlStudent.setVisible(true);
				pnlTech.setVisible(false);
				pnlWorker.setVisible(false);	
			}
		});
		rdbStudent.setSelected(true);
		rdbStudent.setHorizontalAlignment(SwingConstants.CENTER);
		rdbStudent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbStudent.setBackground(Color.WHITE);
		rdbStudent.setBounds(44, 86, 109, 23);
		pnlJobInfo.add(rdbStudent);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(10, 294, 644, 2);
		pnlJobInfo.add(separator_4);
		
		JLabel lblExperienciaLaboral = new JLabel("Experiencia laboral");
		lblExperienciaLaboral.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblExperienciaLaboral.setBounds(21, 268, 187, 21);
		pnlJobInfo.add(lblExperienciaLaboral);
		
		pnlStudent = new JPanel();
		pnlStudent.setBackground(Color.WHITE);
		pnlStudent.setBounds(10, 304, 644, 359);
		pnlJobInfo.add(pnlStudent);
		pnlStudent.setLayout(null);
		
		JLabel label_5 = new JLabel("Idiomas dominados:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_5.setBounds(23, 11, 161, 27);
		pnlStudent.add(label_5);
		
		cbxLanguage = new JComboBox<String>();
		cbxLanguage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbxLanguage.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>", "\u00C1rabe", "Alem\u00E1n", "Creole", "Espa\u00F1ol", "Franc\u00E9s", "Ingl\u00E9s", "Japon\u00E9s", "Mandar\u00EDn", "Portugu\u00E9s", "Ruso", "", ""}));
		cbxLanguage.setBounds(23, 49, 161, 27);
		pnlStudent.add(cbxLanguage);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(384, 11, 238, 205);
		pnlStudent.add(scrollPane);
		
		listLanguages = new JList<String>();
		scrollPane.setViewportView(listLanguages);
		
		JButton btnAddLanguage = new JButton("A\u00F1adir >");
		btnAddLanguage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbxLanguage.getSelectedIndex()!= 0) {
					languages.add(cbxLanguage.getSelectedItem().toString());
					loadLanguages();
					listLanguages.setModel(modelLanguages);	
					cbxLanguage.setSelectedIndex(0);
				}
			}
		});
		btnAddLanguage.setBounds(57, 89, 89, 23);
		pnlStudent.add(btnAddLanguage);
		
		txtCollege = new JTextField();
		txtCollege.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCollege.setColumns(10);
		txtCollege.setBounds(23, 188, 330, 28);
		pnlStudent.add(txtCollege);
		
		JLabel lblUniversidad = new JLabel("Universidad:");
		lblUniversidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUniversidad.setBounds(23, 148, 161, 27);
		pnlStudent.add(lblUniversidad);
		
		txtCareer = new JTextField();
		txtCareer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCareer.setColumns(10);
		txtCareer.setBounds(23, 291, 285, 28);
		pnlStudent.add(txtCareer);
		
		JLabel lblCarrera = new JLabel("Carrera:");
		lblCarrera.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCarrera.setBounds(23, 251, 161, 27);
		pnlStudent.add(lblCarrera);
		
		JLabel lblCuatrimestresCursados = new JLabel("Cuatrimestres cursados");
		lblCuatrimestresCursados.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuatrimestresCursados.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCuatrimestresCursados.setBounds(405, 251, 198, 27);
		pnlStudent.add(lblCuatrimestresCursados);
		
		JSpinner spnPeriods = new JSpinner();
		spnPeriods.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnPeriods.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spnPeriods.setBounds(481, 292, 63, 28);
		pnlStudent.add(spnPeriods);
		
		JButton btnClear = new JButton("Limpiar");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelLanguages.clear();
				listLanguages.setModel(modelLanguages);
				languages.removeAll(languages);
			}
		});
		btnClear.setBounds(461, 217, 89, 23);
		pnlStudent.add(btnClear);
		
		pnlTech = new JPanel();
		pnlTech.setVisible(false);
		pnlTech.setIgnoreRepaint(true);
		pnlTech.setLayout(null);
		pnlTech.setBackground(Color.WHITE);
		pnlTech.setBounds(10, 304, 644, 359);
		pnlJobInfo.add(pnlTech);
		
		JLabel lblAosDeExperiencia = new JLabel("A\u00F1os de experiencia");
		lblAosDeExperiencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblAosDeExperiencia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAosDeExperiencia.setBounds(196, 281, 177, 27);
		pnlTech.add(lblAosDeExperiencia);
		
		spnExpYears = new JSpinner();
		spnExpYears.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnExpYears.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spnExpYears.setBounds(375, 281, 63, 28);
		pnlTech.add(spnExpYears);
		
		JLabel lblAreasDeDesempeo = new JLabel("Areas de desempe\u00F1o");
		lblAreasDeDesempeo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAreasDeDesempeo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAreasDeDesempeo.setBounds(52, 11, 161, 27);
		pnlTech.add(lblAreasDeDesempeo);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(23, 49, 224, 193);
		pnlTech.add(scrollPane_1);
		
		listAvAreas = new JList<String>();
		listAvAreas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				choose = listAvAreas.getSelectedIndex();
				if(choose != -1) {
					btnAddArea.setEnabled(true);
				}else {
					btnAddArea.setEnabled(false);
				}
			}
		});
		String[] areasAv = {"Informática","Electricidad","Contabilidad","Diseño Gráfico","Enfermería","Mercadeo","Administración","Publicidad"};
		areasA = new DefaultListModel<>();
		areasAva = new ArrayList<String>();
		for (String string : areasAv) {
			areasAva.add(string);
		}
		loadAreas(true);
		listAvAreas.setModel(areasA);
		scrollPane_1.setViewportView(listAvAreas);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(395, 49, 224, 193);
		pnlTech.add(scrollPane_2);
		
		areasSel = new DefaultListModel<String>();
		listSelectedAreas = new JList<String>();
		listSelectedAreas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				choose2 = listSelectedAreas.getSelectedIndex();
				if(choose2 != -1) {
					btnRemoveArea.setEnabled(true);
				}else {
					btnRemoveArea.setEnabled(false);
				}
			}
		});
		listSelectedAreas.setModel(areasSel);
		scrollPane_2.setViewportView(listSelectedAreas);
		
		btnAddArea = new JButton("A\u00F1adir >");
		btnAddArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(choose != -1) {
					String selection = areasA.get(choose);
					areasAva.remove(selection);
					areasS.add(selection);
					loadAreas(true);
					loadAreas(false);
					listAvAreas.setModel(areasA);
					listSelectedAreas.setModel(areasSel);
					btnAddArea.setEnabled(false);
				}
			}
		});
		btnAddArea.setEnabled(false);
		btnAddArea.setBounds(271, 99, 102, 23);
		pnlTech.add(btnAddArea);
		
		btnRemoveArea = new JButton("< Sustraer");
		btnRemoveArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(choose2 != -1) {
					String selection = areasSel.get(choose2);
					areasS.remove(selection);
					areasAva.add(selection);
					loadAreas(true);
					loadAreas(false);
					listAvAreas.setModel(areasA);
					listSelectedAreas.setModel(areasSel);
					btnRemoveArea.setEnabled(false);
				}
			}
		});
		btnRemoveArea.setEnabled(false);
		btnRemoveArea.setBounds(271, 158, 102, 23);
		pnlTech.add(btnRemoveArea);
		
		JLabel lblAreasDominadas = new JLabel("Areas dominadas");
		lblAreasDominadas.setHorizontalAlignment(SwingConstants.CENTER);
		lblAreasDominadas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAreasDominadas.setBounds(426, 11, 161, 27);
		pnlTech.add(lblAreasDominadas);
		
		pnlWorker = new JPanel();
		pnlWorker.setVisible(false);
		pnlWorker.setBackground(Color.WHITE);
		pnlWorker.setBounds(10, 304, 644, 362);
		pnlJobInfo.add(pnlWorker);
		pnlWorker.setLayout(null);
		
		JLabel label = new JLabel("A\u00F1os de experiencia");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(198, 295, 177, 27);
		pnlWorker.add(label);
		
		spnYearExp = new JSpinner();
		spnYearExp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spnYearExp.setBounds(377, 295, 63, 28);
		pnlWorker.add(spnYearExp);
		
		JLabel lblHabilidades = new JLabel("Habilidades");
		lblHabilidades.setHorizontalAlignment(SwingConstants.CENTER);
		lblHabilidades.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHabilidades.setBounds(55, 25, 161, 27);
		pnlWorker.add(lblHabilidades);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(25, 63, 224, 193);
		pnlWorker.add(scrollPane_3);
		
		listSkillsAva = new JList<String>();
		listSkillsAva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				choose3 = listSkillsAva.getSelectedIndex();
				if(choose3 != -1) {
					btnAddSkill.setEnabled(true);
				}else {
					btnAddSkill.setEnabled(false);
				}
			}
		});
		scrollPane_3.setViewportView(listSkillsAva);
		
		String[] skillsSTRINGS = {"Plomería","Ebanistería","Mecánica","Construcción","Pintura","Soldadura","Jardinería"};
		for(String s: skillsSTRINGS) {
			SkillsAva.add(s);
		}
		SkillsA = new DefaultListModel<String>();
		loadSkills(true);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(397, 63, 224, 193);
		pnlWorker.add(scrollPane_4);
		
		listSkillsSelected = new JList<String>();
		listSkillsSelected.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				choose4 = listSkillsSelected.getSelectedIndex();
				if(choose4 != -1) {
					btnRemoveSkill.setEnabled(true);
				}else {
					btnRemoveSkill.setEnabled(false);
				}
			}
		});
		listSkillsSelected.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		SkillsS = new DefaultListModel<String>();
		loadSkills(false);
		scrollPane_4.setViewportView(listSkillsSelected);
		
		btnAddSkill = new JButton("A\u00F1adir >");
		btnAddSkill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(choose3 != -1) {
					String selection = SkillsA.get(choose3);
					SkillsAva.remove(selection);
					SkillsSelected.add(selection);
					loadSkills(true);
					loadSkills(false);
					listSkillsAva.setModel(SkillsA);
					listSkillsSelected.setModel(SkillsS);
					btnAddSkill.setEnabled(false);
				}	
			}
		});
		btnAddSkill.setEnabled(false);
		btnAddSkill.setBounds(273, 114, 102, 23);
		pnlWorker.add(btnAddSkill);
		
		btnRemoveSkill = new JButton("< Sustraer");
		btnRemoveSkill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(choose4 != -1) {
					String selection = SkillsS.get(choose4);
					SkillsSelected.remove(selection);
					SkillsAva.add(selection);
					loadSkills(true);
					loadSkills(false);
					listSkillsAva.setModel(SkillsA);
					listSkillsSelected.setModel(SkillsS);
					btnRemoveSkill.setEnabled(false);
				}	
			}
		});
		btnRemoveSkill.setEnabled(false);
		btnRemoveSkill.setBounds(273, 174, 102, 23);
		pnlWorker.add(btnRemoveSkill);
		
		JLabel lblTusHabilidades = new JLabel("Tus habilidades");
		lblTusHabilidades.setHorizontalAlignment(SwingConstants.CENTER);
		lblTusHabilidades.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTusHabilidades.setBounds(427, 25, 161, 27);
		pnlWorker.add(lblTusHabilidades);
		if(mod != null) {
			loadData(mod);
		}
		
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
				btnNext.setEnabled(false);
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
			btnFinish.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
						Person aux = null;
						if(rdbStudent.isSelected()) {
							aux = new Student(txtID.getText(), txtName.getText(), txtLastName.getText(), (Date) spnBirth.getValue(), txtAddress.getText(),
							txtEmail.getText(), cbxProvince.getSelectedItem().toString(),txtCity.getText(),cbxGenre.getSelectedItem().toString(),
							cbxMaritalStatus.getSelectedItem().toString(), txtPhone.getText(), checkTravel.isSelected(), checkMove.isSelected(),txtCollege.getText(),
							txtCareer.getText(),Integer.valueOf(spnPeriods.getValue().toString()),languages);
						}
						if(rdbTech.isSelected()) {
							aux = new Technician(txtID.getText(), txtName.getText(), txtLastName.getText(), (Date) spnBirth.getValue(), txtAddress.getText(),
							txtEmail.getText(), cbxProvince.getSelectedItem().toString(),txtCity.getText(),cbxGenre.getSelectedItem().toString(),
							cbxMaritalStatus.getSelectedItem().toString(), txtPhone.getText(), checkTravel.isSelected(), checkMove.isSelected(),Integer.valueOf(spnExpYears.getValue().toString()),areasS);
						}
						if(rdbWorker.isSelected()) {
							aux = new Worker(txtID.getText(), txtName.getText(), txtLastName.getText(), (Date) spnBirth.getValue(), txtAddress.getText(),
							txtEmail.getText(), cbxProvince.getSelectedItem().toString(),txtCity.getText(),cbxGenre.getSelectedItem().toString(),
							cbxMaritalStatus.getSelectedItem().toString(), txtPhone.getText(), checkTravel.isSelected(), checkMove.isSelected(),Integer.valueOf(spnYearExp.getValue().toString()),SkillsSelected);
						}
						if(mod == null) {
							JobCenter.getInstance().addPerson(aux);
							JOptionPane.showMessageDialog(null, "El registro fue completado con exito", "Aviso", JOptionPane.INFORMATION_MESSAGE);
							dispose();
						}else {
							JobCenter.getInstance().modPerson(mod,aux);
							JOptionPane.showMessageDialog(null, "Se modificó con exito", "Aviso", JOptionPane.INFORMATION_MESSAGE);
							dispose();
						}
				}
			});
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
	
	private void loadData(Person mod) {
		txtID.setText(mod.getId());
		txtName.setText(mod.getName());
		txtLastName.setText(mod.getLastName());
		spnBirth.setValue(mod.getBirthDate());
		txtAddress.setText(mod.getAddress());
		txtEmail.setText(mod.getEmail());
		cbxProvince.setSelectedItem(mod.getProvince());
		txtCity.setText(mod.getCity());
		cbxGenre.setSelectedItem(mod.getGender());
		cbxMaritalStatus.setSelectedItem(mod.getMaritalStatus());
		txtPhone.setText(mod.getPhoneNumber());
		checkTravel.setSelected(mod.isTravelAv());
		checkMove.setSelected(mod.isMoveAv());
		if(mod instanceof Student) {
			languages = (ArrayList<String>) ((Student) mod).getLanguages();
			txtCollege.setText(((Student) mod).getUniversity());
			txtCareer.setText(((Student) mod).getCareer());
			rdbStudent.setSelected(true);
			rdbTech.setSelected(false);
			rdbWorker.setSelected(false);
			pnlStudent.setVisible(true);
			pnlTech.setVisible(false);
			pnlWorker.setVisible(false);
		}
		if(mod instanceof Technician) {
			areasS = ((ArrayList<String>)((Technician) mod).getAreas());
			for (String s : areasS) {
				areasAva.remove(s);
			}
			loadAreas(true);
			loadAreas(false);
			spnExpYears.setValue(Integer.valueOf(((Technician) mod).getWorkExperienceYears()));	
			rdbStudent.setSelected(false);
			rdbTech.setSelected(true);
			rdbWorker.setSelected(false);
			pnlStudent.setVisible(false);
			pnlTech.setVisible(true);
			pnlWorker.setVisible(false);
		}
		if(mod instanceof Worker) {
			SkillsSelected = ((ArrayList<String>)((Technician) mod).getAreas());
			for (String s : SkillsSelected) {
				SkillsAva.remove(s);
			}
			loadSkills(true);
			loadSkills(false);
			spnYearExp.setValue(Integer.valueOf(((Technician) mod).getWorkExperienceYears()));
			rdbStudent.setSelected(false);
			rdbTech.setSelected(false);
			rdbWorker.setSelected(true);
			pnlStudent.setVisible(false);
			pnlTech.setVisible(false);
			pnlWorker.setVisible(true);
		}
		
	}

	private void updateNext() {
		if(!txtID.getText().isEmpty() && !txtName.getText().isEmpty() && !txtLastName.getText().isEmpty() && !txtPhone.getText().isEmpty() &&
			!txtAddress.getText().isEmpty() && !txtCity.getText().isEmpty() && !txtEmail.getText().isEmpty()
			&& cbxMaritalStatus.getSelectedIndex() != 0 && cbxProvince.getSelectedIndex() != 0) {
			
			btnNext.setEnabled(true);	
		}else {
			btnNext.setEnabled(false);
		}
	}
	
	private void loadLanguages() {
		modelLanguages.clear();
		for (String s : languages) {
			modelLanguages.addElement(s);	
		}	
	}
	
	private void loadAreas(boolean condition) {
		if(condition) {
			areasA.clear();
			for (String string : areasAva) {
				areasA.addElement(string);
			}	
		}else {
			areasSel.clear();
			for (String string : areasS) {
				areasSel.addElement(string);
			}
		}
	}
	
	private void loadSkills(boolean condition) {
		if(condition) {
			SkillsA.clear();
			for (String string : SkillsAva) {
				SkillsA.addElement(string);
			}
			listSkillsAva.setModel(SkillsA);	
		}else {
				SkillsS.clear();
			for (String string : SkillsSelected) {
				SkillsS.addElement(string);
			}
			listSkillsSelected.setModel(SkillsS);
		}
	}
	
}
