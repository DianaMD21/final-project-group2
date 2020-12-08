package vis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import log.JobCenter;
import log.Person;
import log.Student;
import log.Technician;
import log.Worker;
import log.EmployeeRequest;
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

public class EmployeeRequestReg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JSeparator separator;
	private JLabel lblCed;
	private JTextField txtCed;
	private JLabel lblLangs;
	private JCheckBox chckbxMoveAv;
	private JLabel lblInfLaboral;
	private JSeparator separator_1;
	private JLabel lblMinSal;
	private JSpinner spnMinSal;
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
	private JCheckBox chckbxTravelAv;

	/**
	  Create the dialog.
	 */
	public EmployeeRequestReg(EmployeeRequest req) {
		modelLangs = new DefaultListModel<String>();
		setModalityType(ModalityType.APPLICATION_MODAL);
		setResizable(false);
		setTitle("Solicitar empleo");
		setBounds(100, 100, 680, 680);
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
			
			lblCed = new JLabel("N\u00FAmero de c\u00E9dula:");
			lblCed.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblCed.setBounds(20, 75, 140, 23);
			pnlGeneral.add(lblCed);
			
			txtCed = new JTextField();
			txtCed.setBounds(175, 74, 400, 29);
			pnlGeneral.add(txtCed);
			txtCed.setColumns(10);
			txtCed.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char caracter = e.getKeyChar();
	                if (((caracter < '0') || (caracter > '9'))
	                        && (caracter != '\b')  || (txtCed.getText().length()==11)) {
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
			
			chckbxMoveAv = new JCheckBox(" Disponibilidad para mudarse");
			chckbxMoveAv.setFont(new Font("Tahoma", Font.PLAIN, 16));
			chckbxMoveAv.setBounds(20, 120, 240, 31);
			pnlGeneral.add(chckbxMoveAv);
			
			chckbxDriveLc = new JCheckBox(" Licencia de conducir");
			chckbxDriveLc.setFont(new Font("Tahoma", Font.PLAIN, 16));
			chckbxDriveLc.setBounds(20, 210, 180, 31);
			pnlGeneral.add(chckbxDriveLc);
			
			lblInfLaboral = new JLabel("Informaci\u00F3n laboral");
			lblInfLaboral.setFont(new Font("Tahoma", Font.PLAIN, 19));
			lblInfLaboral.setBounds(20, 410, 170, 23);
			pnlGeneral.add(lblInfLaboral);
			
			separator_1 = new JSeparator();
			separator_1.setBounds(10, 440, 640, 2);
			pnlGeneral.add(separator_1);
			
			lblMinSal = new JLabel("Salario m\u00EDnimo demandado:");
			lblMinSal.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblMinSal.setBounds(20, 475, 210, 23);
			pnlGeneral.add(lblMinSal);
			
			spnMinSal = new JSpinner();
			spnMinSal.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
			spnMinSal.setFont(new Font("Tahoma", Font.PLAIN, 16));
			spnMinSal.setBounds(245, 474, 100, 30);
			pnlGeneral.add(spnMinSal);
			
			lblWorkHours = new JLabel("Horas de trabajo semanales");
			lblWorkHours.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblWorkHours.setBounds(20, 530, 235, 23);
			pnlGeneral.add(lblWorkHours);
			
			spnWorkHours = new JSpinner();
			spnWorkHours.setModel(new SpinnerNumberModel(1, 1, 60, 1));
			spnWorkHours.setFont(new Font("Tahoma", Font.PLAIN, 16));
			spnWorkHours.setBounds(245, 526, 100, 30);
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
			btnLangAdd.setBounds(115, 310, 130, 31);
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
			
			lblLangsSel = new JLabel("Idiomas dominados:");
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
			
			chckbxTravelAv = new JCheckBox(" Disponibilidad para viajar");
			chckbxTravelAv.setFont(new Font("Tahoma", Font.PLAIN, 16));
			chckbxTravelAv.setBounds(20, 165, 220, 31);
			pnlGeneral.add(chckbxTravelAv);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnReg = new JButton("Solicitar");
				btnReg.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int reply = 0, reply1=0;
						
						if(JobCenter.getInstance().findPersonById(txtCed.getText()) != null) {
							Person person1=JobCenter.getInstance().findPersonById(txtCed.getText());
							if(person1.isWorkingStatus()==true) {
								 reply = JOptionPane.showConfirmDialog(null, "Su estado laboral es empleado. Debe de cambiarlo para realizar una solicitud. ¿Desea hacerlo?", "Conflicto con estado laboral", JOptionPane.YES_NO_OPTION);
								if (reply == JOptionPane.NO_OPTION) {
								    dispose();
								}
								
							}
							EmployeeRequest aux=JobCenter.getInstance().findEmployeeReqByPerson(person1);
							if(aux!=null && aux.getStatus()==true) {
								reply1 = JOptionPane.showConfirmDialog(null, "Usted ya tiene una solicitud activa. �Desea desactivarla para poder realizar otra solicitud?", "Conflicto con solicitud", JOptionPane.YES_NO_OPTION);
								if (reply1 == JOptionPane.NO_OPTION) {
									dispose();
								}
								else {
									aux.setStatus(false);
								}
							}
							if((person1.isWorkingStatus()==false || reply == JOptionPane.YES_OPTION) && (aux==null ||reply1 == JOptionPane.YES_OPTION)) {
								person1.setWorkingStatus(false);
								List<String> langs = new ArrayList<String>();
								for(int i = 0; i<modelLangs.getSize(); i++) {
									langs.add(modelLangs.getElementAt(i));
								}
								
								
								if(req == null) {
									String id = ""+EmployeeRequest.cod++;	
									EmployeeRequest request = new EmployeeRequest(id, person1, (float) spnMinSal.getValue(), 
											langs, (int) spnWorkHours.getValue(), chckbxTravelAv.isSelected(), chckbxMoveAv.isSelected(), chckbxDriveLc.isSelected());
									JobCenter.getInstance().addEmployeeRquest(request);
									
								}
								else {
									req.setApplicant(JobCenter.getInstance().findPersonById(txtCed.getText()));
									req.setStatus(true);
									req.setMinSalary((float) spnMinSal.getValue());
									req.setLanguages(langs);
									req.setWorkingHours((int) spnWorkHours.getValue());
									req.setTravelAv(chckbxTravelAv.isSelected());
									req.setMoveAv(chckbxMoveAv.isSelected());
									req.setDrivingLicense(chckbxDriveLc.isSelected());
								}
								
								JOptionPane.showMessageDialog(null, "El registro fue completado con exito.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
								dispose();
							}
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
		if(!txtCed.getText().isEmpty() && !modelLangs.isEmpty()) {
			btnReg.setEnabled(true);
		}else {
			btnReg.setEnabled(false);
		}
	}
}
