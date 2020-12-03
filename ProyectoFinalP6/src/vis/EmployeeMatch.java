package vis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import log.Company;
import log.CompanyRequest;
import log.EmployeeRequest;
import log.JobCenter;
import log.Person;

import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EmployeeMatch extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtRNC;
	private JTextField txtName;
	private JTable table;
	private JComboBox<String> cbxRequest;
	private Company c;
	private DefaultTableModel model;
	@SuppressWarnings("unused")
	private int chooses[];
	private JButton btnHire;
	private JButton btnInfo;
	private JButton btnJob;
	private List<CompanyRequest> requests;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EmployeeMatch dialog = new EmployeeMatch();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EmployeeMatch() {
		requests = new ArrayList<CompanyRequest>();
		chooses = null;
		c = null;
		setBounds(100, 100, 981, 650);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmpresa.setBounds(298, 13, 79, 27);
		contentPanel.add(lblEmpresa);
		
		cbxRequest = new JComboBox<String>();
		cbxRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!cbxRequest.getSelectedItem().toString().equalsIgnoreCase("<Seleccione>")) {
					load(requests);
					table.setModel(model);
				}else {
					model.setRowCount(0);
					table.setModel(model);
				}
			}
		});
		cbxRequest.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbxRequest.setModel(new DefaultComboBoxModel<String>(new String[] {" Ingrese RNC"}));
		cbxRequest.setEnabled(false);
		cbxRequest.setBounds(494, 71, 310, 27);
		contentPanel.add(cbxRequest);
		
		txtRNC = new JTextField();
		txtRNC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if(caracter != '-') {
	                if (((caracter < '0') || (caracter > '9'))
	                        && (caracter != '\b')  ) {
	                    e.consume();
	                }					
				}
			}		
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(!(txtRNC.getText().equalsIgnoreCase(""))) {
					model.setRowCount(0);
					table.setModel(model);
					c = JobCenter.getInstance().findCompanyById(txtRNC.getText());
					if(c != null) {
						txtName.setText(" "+c.getName());
						requests = JobCenter.getInstance().getCompanyRequest(c);
						updateCbx(requests);
						cbxRequest.setEnabled(true);
					}else {
						txtName.setText("");
						cbxRequest.setModel(new DefaultComboBoxModel<String>(new String[] {" Ingrese RNC Valido"}));
						cbxRequest.setEnabled(false);
						model.setRowCount(0);
						btnInfo.setEnabled(false);
						btnJob.setEnabled(false);
						btnHire.setEnabled(false);
					}
				}else {
					c = null;
					txtName.setText(" Ingrese RNC");
					cbxRequest.setModel(new DefaultComboBoxModel<String>(new String[] {" Ingrese RNC"}));
					cbxRequest.setEnabled(false);
					model.setRowCount(0);
					btnInfo.setEnabled(false);
					btnJob.setEnabled(false);
					btnHire.setEnabled(false);
				}
			}
		});
		txtRNC.setBounds(80, 13, 136, 27);
		contentPanel.add(txtRNC);
		txtRNC.setColumns(10);
		
		JLabel lblRnc = new JLabel("RNC:");
		lblRnc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRnc.setBounds(26, 13, 51, 27);
		contentPanel.add(lblRnc);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 56, 945, 8);
		contentPanel.add(separator);
		
		JLabel lblEmpleadosConPorcentaje = new JLabel("Empleados con porcentaje de emparejamiento para la solicitud:");
		lblEmpleadosConPorcentaje.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmpleadosConPorcentaje.setBounds(26, 70, 458, 29);
		contentPanel.add(lblEmpleadosConPorcentaje);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 117, 945, 450);
		contentPanel.add(scrollPane);
		
		String[] colums = {"Solicitud No.","Cédula", "Nombre", "Sexo","Salario Mín","Horas de trabajo","Porcentaje de enlace"};
		model = new DefaultTableModel();
		model.setColumnIdentifiers(colums);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(table.getSelectedRows().length > 1) {
					chooses = table.getSelectedRows();
					btnInfo.setEnabled(false);
					btnJob.setEnabled(false);
					btnHire.setEnabled(true);
					
				}if(table.getSelectedRows().length == 1) {
					chooses = table.getSelectedRows();
					btnInfo.setEnabled(true);
					btnJob.setEnabled(true);
					btnHire.setEnabled(true);
				}
				if(table.getSelectedRows().length<1) {
					chooses = null;
					btnInfo.setEnabled(false);
					btnJob.setEnabled(false);
					btnHire.setEnabled(false);
				}
			}
		});
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtName.setText(" Ingrese RNC");
		txtName.setEditable(false);
		txtName.setColumns(10);
		txtName.setBounds(387, 13, 554, 27);
		contentPanel.add(txtName);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnInfo = new JButton("Informaci\u00F3n Personal");
			btnInfo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Person aux = JobCenter.getInstance().findEmployeeRequestById((String)model.getValueAt(chooses[0], 0)).getApplicant();
					InformacionPersonVisual info = new InformacionPersonVisual(aux);
					info.setLocationRelativeTo(null);
					info.setVisible(true);
				}
			});
			btnInfo.setEnabled(false);
			buttonPane.add(btnInfo);
			
			btnJob = new JButton("Informaci\u00F3n Laboral");
			btnJob.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EmployeeRequest aux = JobCenter.getInstance().findEmployeeRequestById((String)model.getValueAt(chooses[0], 0));
					InfoJobRequest info = new InfoJobRequest(aux);
					info.setLocationRelativeTo(null);
					info.setVisible(true);
				}
			});
			btnJob.setEnabled(false);
			buttonPane.add(btnJob);
			
			JLabel label = new JLabel("                                                                                                                                                  ");
			buttonPane.add(label);
			{
				btnHire = new JButton("Contratar");
				btnHire.setEnabled(false);
				btnHire.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chooses.length > 0) {
							int position = cbxRequest.getSelectedIndex();
							CompanyRequest selected = requests.get(position);
							List<EmployeeRequest> requestsSelected = new ArrayList<EmployeeRequest>();
							for (int i : chooses) {
								requestsSelected.add(JobCenter.getInstance().findEmployeeRequestById((String) model.getValueAt(chooses[i], 0)));			
							}
							
							for (EmployeeRequest r : requestsSelected) {
								r.getApplicant().setWorkingStatus(true);
								r.setStatus(false);	
							}
							int amount = selected.getQuantity();
							selected.setQuantity(--amount);
							if(selected.getQuantity() == 0) {
								selected.setStatus(false);
							}
							clear();
						}		
					}
				});
				btnHire.setActionCommand("OK");
				buttonPane.add(btnHire);
				getRootPane().setDefaultButton(btnHire);
			}
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
	private void updateCbx(List<CompanyRequest> requests) {
		DefaultComboBoxModel<String> model1 = new DefaultComboBoxModel<String>();
		if(requests.size()>=1) {
			model1.addElement("<Seleccione>");
			for (CompanyRequest cr : requests) {
				model1.addElement("Solicitud > "+cr.getTypeOfEmployee()+" Cantidad: "+cr.getQuantity());
			}
			cbxRequest.setModel(model1);	
		}else {
			model1.addElement("<No existe solicitud>");
		}
		cbxRequest.setModel(model1);
	}	
	
	private void load(List<CompanyRequest> requests) {
		model.setRowCount(0);
		Object[] row = new Object[model.getColumnCount()];
		int position = cbxRequest.getSelectedIndex();
		CompanyRequest selected = requests.get(position);
		List<EmployeeRequest> req_persons = JobCenter.getInstance().match(selected);
		for (EmployeeRequest er : req_persons) {
			row[0] = er.getId();
			row[1] = er.getApplicant().getId();
			row[2] = er.getApplicant().getName()+" "+er.getApplicant().getLastName();
			row[3] = er.getApplicant().getGender();
			row[4] = ""+er.getMinSalary();
			row[5] = ""+er.getWorkingHours();
			row[6] = ""+JobCenter.getInstance().getMatchPercentage(er, selected)+" %";
			model.addRow(row);
		}	
	}
	private void clear() {
		txtRNC.setText("");
		txtName.setText(" Ingrese RNC");
		cbxRequest.setModel(new DefaultComboBoxModel<String>(new String[] {" Ingrese RNC"}));
		cbxRequest.setEnabled(false);
		model.setRowCount(0);
		btnInfo.setEnabled(false);
		btnJob.setEnabled(false);
		btnHire.setEnabled(false);
	}
}
