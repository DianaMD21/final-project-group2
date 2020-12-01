package vis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import log.JobCenter;
import log.Person;
import log.Student;
import log.Technician;
import log.Worker;
import log.Company;
import log.CompanyRequest;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Image;
import java.awt.Dialog.ModalityType;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class CompanyRequestReg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JSeparator separator;
	private JLabel lblId;
	private JTextField txtId;
	private JLabel lblLangs;
	private JCheckBox chckbxMoveAv;
	private JLabel lblInfLaboral;
	private JSeparator separator_1;
	private JLabel lblMinSal;
	private JSpinner spnMaxSal;
	private JLabel lblWorkHours;
	private JSpinner spnWorkHours;
	private JComboBox cbxLangs;
	private JButton btnReg;
	private JButton btnLangAdd;
	private JScrollPane scrollPane;
	private JList<String> listLangs;
	private DefaultListModel<String> modelLangs;
	private JLabel lblLangsSel;
	private JButton btnRemoveLang;
	private JCheckBox chckbxDriveLc;
	private JLabel lblType;
	private JComboBox cbxType;
	private JLabel lblCant;
	private JCheckBox chckbxTravelAv;
	private JSpinner spnCant;
	private JLabel lblSkill;
	private JComboBox cbxSkill;

	/* Create the dialog.
	 */
	public CompanyRequestReg(CompanyRequest req) {
		modelLangs = new DefaultListModel<String>();
		setModalityType(ModalityType.APPLICATION_MODAL);
		setResizable(false);
		setTitle("Solicitar empleados");
		setBounds(100, 100, 680, 735);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel pnlGeneral = new JPanel();
			pnlGeneral.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(pnlGeneral, BorderLayout.CENTER);
			pnlGeneral.setLayout(null);
			{
				JLabel lblInfGen = new JLabel("Informaci\u00F3n general");
				lblInfGen.setFont(new Font("Tahoma", Font.PLAIN, 19));
				lblInfGen.setBounds(20, 15, 180, 23);
				pnlGeneral.add(lblInfGen);
			}
			
			separator = new JSeparator();
			separator.setBounds(10, 45, 640, 2);
			pnlGeneral.add(separator);
			
			lblId = new JLabel("RNC de la compa\u00F1\u00EDa:");
			lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblId.setBounds(20, 75, 150, 23);
			pnlGeneral.add(lblId);
			
			txtId = new JTextField();
			txtId.setBounds(185, 74, 400, 29);
			pnlGeneral.add(txtId);
			txtId.setColumns(10);
			txtId.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char caracter = e.getKeyChar();
	                if (((caracter < '0') || (caracter > '9'))
	                        && (caracter != '\b')  || (txtId.getText().length()==11)) {
	                    e.consume();
	                }
				}
				@Override
				public void keyReleased(KeyEvent arg0) {
					updateFin();
				}
			});
			
			lblLangs = new JLabel("Idiomas:");
			lblLangs.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblLangs.setBounds(20, 260, 70, 23);
			pnlGeneral.add(lblLangs);
			
			chckbxMoveAv = new JCheckBox(" Disponibilidad para mudarse requerida");
			chckbxMoveAv.setFont(new Font("Tahoma", Font.PLAIN, 16));
			chckbxMoveAv.setBounds(20, 120, 315, 31);
			pnlGeneral.add(chckbxMoveAv);
			
			chckbxDriveLc = new JCheckBox(" Licencia de conducir requerida");
			chckbxDriveLc.setFont(new Font("Tahoma", Font.PLAIN, 16));
			chckbxDriveLc.setBounds(20, 210, 260, 31);
			pnlGeneral.add(chckbxDriveLc);
			
			lblInfLaboral = new JLabel("Informaci\u00F3n laboral");
			lblInfLaboral.setFont(new Font("Tahoma", Font.PLAIN, 19));
			lblInfLaboral.setBounds(20, 495, 170, 23);
			pnlGeneral.add(lblInfLaboral);
			
			separator_1 = new JSeparator();
			separator_1.setBounds(10, 525, 640, 2);
			pnlGeneral.add(separator_1);
			
			lblMinSal = new JLabel("Salario m\u00E1ximo ofrecido:");
			lblMinSal.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblMinSal.setBounds(20, 555, 180, 23);
			pnlGeneral.add(lblMinSal);
			
			spnMaxSal = new JSpinner();
			spnMaxSal.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
			spnMaxSal.setFont(new Font("Tahoma", Font.PLAIN, 16));
			spnMaxSal.setBounds(210, 554, 100, 30);
			pnlGeneral.add(spnMaxSal);
			
			lblWorkHours = new JLabel("Horas de trabajo requeridas:");
			lblWorkHours.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblWorkHours.setBounds(340, 555, 210, 23);
			pnlGeneral.add(lblWorkHours);
			
			spnWorkHours = new JSpinner();
			spnWorkHours.setModel(new SpinnerNumberModel(1, 1, 12, 1));
			spnWorkHours.setFont(new Font("Tahoma", Font.PLAIN, 16));
			spnWorkHours.setBounds(560, 554, 70, 30);
			pnlGeneral.add(spnWorkHours);
			
			cbxLangs = new JComboBox();
			cbxLangs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(cbxLangs.getSelectedIndex()>0) {
						btnLangAdd.setEnabled(true);
					}
					else {
						btnLangAdd.setEnabled(false);
					}
				}
			});
			cbxLangs.setFont(new Font("Tahoma", Font.PLAIN, 16));
			cbxLangs.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Alem\u00E1n", "Chino", "Coreano", "Espa\u00F1ol", "Franc\u00E9s", "Ingl\u00E9s", "Italiano", "Japon\u00E9s", "Portugu\u00E9s"}));
			cbxLangs.setBounds(105, 259, 150, 29);
			pnlGeneral.add(cbxLangs);
			
			btnLangAdd = new JButton("A\u00F1adir >>");
			btnLangAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!modelLangs.contains(cbxLangs.getSelectedItem().toString())) {
						modelLangs.addElement(cbxLangs.getSelectedItem().toString());
						listLangs.setModel(modelLangs);	
					}
					cbxLangs.setSelectedIndex(0);
					btnRemoveLang.setEnabled(false);
					updateFin();
				}
			});
			btnLangAdd.setEnabled(false);
			btnLangAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnLangAdd.setBounds(110, 310, 130, 31);
			pnlGeneral.add(btnLangAdd);
			
			scrollPane = new JScrollPane();
			scrollPane.setViewportBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(380, 200, 200, 160);
			pnlGeneral.add(scrollPane);
			
			listLangs = new JList<String>();
			listLangs.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(listLangs.getSelectedIndex() != -1) {
						btnRemoveLang.setEnabled(true);
					}
					else {
						btnRemoveLang.setEnabled(false);
					}
				}
			});
			scrollPane.setViewportView(listLangs);
			
			lblLangsSel = new JLabel("Idiomas requeridos:");
			lblLangsSel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblLangsSel.setBounds(385, 165, 150, 23);
			pnlGeneral.add(lblLangsSel);
			
			btnRemoveLang = new JButton("Quitar");
			btnRemoveLang.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modelLangs.removeElement(listLangs.getSelectedValue());
					listLangs.setModel(modelLangs);	
					cbxLangs.setSelectedIndex(0);
					btnRemoveLang.setEnabled(false);
					updateFin();
				}
			});
			btnRemoveLang.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnRemoveLang.setEnabled(false);
			btnRemoveLang.setBounds(417, 370, 130, 31);
			pnlGeneral.add(btnRemoveLang);
			
			lblType = new JLabel("Tipo de empleado:");
			lblType.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblType.setBounds(20, 395, 150, 23);
			pnlGeneral.add(lblType);
			
			cbxType = new JComboBox();
			cbxType.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					updateFin();
				}
			});
			cbxType.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Universitario", "T\u00E9cnico", "Obrero"}));
			cbxType.setFont(new Font("Tahoma", Font.PLAIN, 16));
			cbxType.setBounds(165, 394, 130, 29);
			pnlGeneral.add(cbxType);
			
			lblCant = new JLabel("Cantidad de empleados a solicitar: ");
			lblCant.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblCant.setBounds(20, 440, 250, 23);
			pnlGeneral.add(lblCant);
			
			chckbxTravelAv = new JCheckBox(" Disponibilidad para viajar requerida");
			chckbxTravelAv.setFont(new Font("Tahoma", Font.PLAIN, 16));
			chckbxTravelAv.setBounds(20, 165, 290, 31);
			pnlGeneral.add(chckbxTravelAv);
			
			spnCant = new JSpinner();
			spnCant.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spnCant.setFont(new Font("Tahoma", Font.PLAIN, 16));
			spnCant.setBounds(285, 439, 70, 30);
			pnlGeneral.add(spnCant);
			
			lblSkill = new JLabel("Area de especialidad requerida:");
			lblSkill.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblSkill.setBounds(20, 605, 225, 23);
			pnlGeneral.add(lblSkill);
			
			cbxSkill = new JComboBox();
			cbxSkill.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					updateFin();
				}
			});
			cbxSkill.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Direcci\u00F3n Empresarial", "Administraci\u00F3n Hotelera", "Arquitectura", "Comunicaci\u00F3n Social", "Derecho", "Dise\u00F1o e Interiorismo", "\u200B\u200B\u200BEcolog\u00EDa y Gesti\u00F3n Ambiental", "Econom\u00EDa", "Educaci\u00F3n", "Estomatolog\u00EDa", "Filosof\u00EDa", "Gesti\u00F3n Financiera y Auditor\u00EDa", "Ingenier\u00EDa Civil", "Ingenier\u00EDa Mec\u00E1nica", "Ingenier\u00EDa El\u00E9ctrica", "Ingenier\u00EDa Industrial y de Sistemas", "Ingenier\u00EDa en Mecatr\u00F3nica", "Ingenier\u00EDa de Sistemas y Computaci\u00F3n", "Ingenier\u00EDa Telem\u00E1tica", "Medicina", "Marketing", "Nutrici\u00F3n y Diet\u00E9tica\u200B", "Psicolog\u00EDa", "Terapia F\u00EDsica"}));
			cbxSkill.setFont(new Font("Tahoma", Font.PLAIN, 16));
			cbxSkill.setBounds(265, 604, 290, 29);
			pnlGeneral.add(cbxSkill);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnReg = new JButton("Solicitar");
				btnReg.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(JobCenter.getInstance().findCompanyById(txtId.getText()) != null) {
							List<String> langs = new ArrayList<String>();
							for(int i = 0; i<modelLangs.getSize(); i++) {
								langs.add(modelLangs.getElementAt(i));
							}
							
							if(req == null) {
								String id = ""+CompanyRequest.cod++;	
								CompanyRequest request = new CompanyRequest(id, JobCenter.getInstance().findCompanyById(txtId.getText()), cbxType.getSelectedItem().toString(), 
										cbxSkill.getSelectedItem().toString(), (int) spnCant.getValue(), (float) spnMaxSal.getValue(), false, langs, chckbxTravelAv.isSelected(),
										chckbxMoveAv.isSelected(), chckbxDriveLc.isSelected(), (int) spnWorkHours.getValue());
								JobCenter.getInstance().addCompanyRequest(request);
							}
							else {
								req.setCompany(JobCenter.getInstance().findCompanyById(txtId.getText()));
								req.setStatus(false);
								req.setMaxSalary((float) spnMaxSal.getValue());
								req.setLanguages(langs);
								req.setWorkingHours((int) spnWorkHours.getValue());
								req.setTravelAv(chckbxTravelAv.isSelected());
								req.setMoveAv(chckbxMoveAv.isSelected());
								req.setDrivingLicense(chckbxDriveLc.isSelected());
								req.setQuantity((int) spnCant.getValue());
								req.setTypeOfEmployee(cbxType.getSelectedItem().toString());
								req.setSkillRequired(cbxSkill.getSelectedItem().toString());
							}
							
							JOptionPane.showMessageDialog(null, "El registro fue completado con exito.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "No se pudo crear la solicitud. Cédula incorrecta o inexistente.", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				btnReg.setEnabled(false);
				buttonPane.add(btnReg);
				getRootPane().setDefaultButton(btnReg);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
	
	private void updateFin() {
		if(!txtId.getText().isEmpty() && !modelLangs.isEmpty() && cbxType.getSelectedIndex()>0 && cbxSkill.getSelectedIndex()>0) {
			btnReg.setEnabled(true);
		}else {
			btnReg.setEnabled(false);
		}
	}
}
