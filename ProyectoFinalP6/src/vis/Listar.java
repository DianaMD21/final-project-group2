package vis;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import log.Company;
import log.CompanyRequest;
import log.EmployeeRequest;
import log.JobCenter;
import log.Person;
import log.Student;
import log.Technician;
import log.Worker;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Listar extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tableEmpresa;
	private JTable tablePersona;
	private List<Company> myCompanies;
	private List<EmployeeRequest> myEmployeeRequest;
	private List<CompanyRequest> myCompRequest;
	private JRadioButton rdbtnTodos;
	private JRadioButton rdbtnStudent;
	private JRadioButton rdbtnTechnician;
	private JRadioButton rdbtnWorker;
	private List<Person> listPerson=new ArrayList<>();
	private DefaultTableModel model;

	/*
	  @param listar 
	  @param listar 
	 */
	public Listar(JobCenter jobCenter, int show) {
		setTitle("Listar");
		this.listPerson=jobCenter.getMyPersons();
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 746, 410);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panelEmpresa = new JPanel();
		panelEmpresa.setBackground(Color.WHITE);
		panelEmpresa.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelEmpresa.setBounds(10, 10, 708, 342);
		contentPanel.add(panelEmpresa);
		panelEmpresa.setLayout(null);
		
		JPanel panelPersona = new JPanel();
		panelPersona.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPersona.setBackground(Color.WHITE);
		panelPersona.setBounds(10, 10, 708, 342);
		contentPanel.add(panelPersona);
		panelPersona.setLayout(null);
		
		JScrollPane scrollPaneEmpresa = new JScrollPane();
		scrollPaneEmpresa.setBounds(20, 75, 668, 171);
		panelEmpresa.add(scrollPaneEmpresa);
		
		tableEmpresa = new JTable(){
			   public boolean isCellEditable(int row, int column){
			        return false;
			   }
			};
		tableEmpresa.setBackground(Color.WHITE);
		tableEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPaneEmpresa.setViewportView(tableEmpresa);
		
		if(show==0) {
			 model = new DefaultTableModel() {
				public Class<?> getColumnClass(int column){
					switch (column) {
					case 0:
						return String.class;
					case 1:
						return String.class;
					case 2:
						return String.class;
					case 3:
						return String.class;
					case 4:
						return String.class;
					default:
							return String.class;
					}
				}
			};
			
			tableEmpresa.setModel(model);
			tableEmpresa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			model.addColumn("RNC");
			model.addColumn("Nombre");
			model.addColumn("Provincia");
			model.addColumn("Área");
			model.addColumn("Teléfono");
		}
		else if(show==2) {
			model = new DefaultTableModel() {
				public Class<?> getColumnClass(int column){
					switch (column) {
					case 0:
						return String.class;
					case 1:
						return String.class;
					case 2:
						return String.class;
					case 3:
						return String.class;
					case 4:
						return String.class;
					default:
							return String.class;
					}
				}
			};
			
			tableEmpresa.setModel(model);
			tableEmpresa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			model.addColumn("ID Sol.");
			model.addColumn("RNC Empresa");
			model.addColumn("Habilidad");
			model.addColumn("Cantidad de Vacantes");
			model.addColumn("Estado");
		}
		else {
			model = new DefaultTableModel() {
				public Class<?> getColumnClass(int column){
					switch (column) {
					case 0:
						return String.class;
					case 1:
						return String.class;
					case 2:
						return String.class;
					case 3:
						return String.class;
					case 4:
						return String.class;
					default:
							return String.class;
					}
				}
			};
			
			tableEmpresa.setModel(model);
			tableEmpresa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			model.addColumn("ID Solicitud");
			model.addColumn("Cédula de Persona");
			model.addColumn("Tipo de Persona");
			model.addColumn("Salario Mínimo");
			model.addColumn("Estado");
		}
		
		JLabel lblEmpresasReg = new JLabel("Tabla de Empresas Registradas");
		lblEmpresasReg.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmpresasReg.setBounds(205, 21, 312, 28);
		panelEmpresa.add(lblEmpresasReg);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalir.setBounds(311, 291, 99, 28);
		panelEmpresa.add(btnSalir);
		
		JLabel lblCantEmpresas = new JLabel("Cantidad de Empresas Registradas");
		lblCantEmpresas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantEmpresas.setBounds(20, 256, 390, 28);
		panelEmpresa.add(lblCantEmpresas);
		
		JScrollPane scrollPanelPersona = new JScrollPane();
		scrollPanelPersona.setBounds(20, 100, 668, 171);
		panelPersona.add(scrollPanelPersona);
		
		tablePersona= new JTable(){
			   public boolean isCellEditable(int row, int column){
			        return false;
			   }
			};
		tablePersona.setBackground(Color.WHITE);
		tablePersona.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPanelPersona.setViewportView(tablePersona);
		
		DefaultTableModel modelPersona = new DefaultTableModel() {
			public Class<?> getColumnClass(int column){
				switch (column) {
				case 0:
					return String.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				case 3:
					return String.class;
				case 4:
					return String.class;
				case 5:
						return String.class;
				default:
						return String.class;
				}
			}
		};
		
		tablePersona.setModel(modelPersona);
		tablePersona.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modelPersona.addColumn("Cédula");
		modelPersona.addColumn("Nombre");
		modelPersona.addColumn("Provincia");
		modelPersona.addColumn("Ciudad");
		modelPersona.addColumn("Profesión");
		modelPersona.addColumn("Estado");
		
		JLabel lblCantPersonas = new JLabel("Cantidad de Personas Registradas: "+String.valueOf(jobCenter.getMyPersons().size()));
		lblCantPersonas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantPersonas.setBounds(20, 270, 271, 28);
		panelPersona.add(lblCantPersonas);
		
		rdbtnStudent = new JRadioButton("Estudiantes");
		rdbtnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnTodos.setEnabled(true);
				rdbtnStudent.setEnabled(false);
				rdbtnWorker.setEnabled(true);
				rdbtnTechnician.setEnabled(true);
				rdbtnWorker.setSelected(false);
				rdbtnTechnician.setSelected(false);
				rdbtnTodos.setSelected(false);
				listPerson=jobCenter.getAllStudents();
				setTablePersona(listPerson,modelPersona);
				lblCantPersonas.setText("Cantidad de Estudiantes registrados: "+String.valueOf(listPerson.size()));
			}
		});
		rdbtnStudent.setBackground(Color.WHITE);
		rdbtnStudent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnStudent.setBounds(20, 70, 103, 21);
		panelPersona.add(rdbtnStudent);
		
		rdbtnTechnician = new JRadioButton("T\u00E9cnico");
		rdbtnTechnician.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnTodos.setEnabled(true);
				rdbtnStudent.setEnabled(true);
				rdbtnWorker.setEnabled(true);
				rdbtnTechnician.setEnabled(false);
				rdbtnStudent.setSelected(false);
				rdbtnWorker.setSelected(false);
				rdbtnTodos.setSelected(false);
				listPerson=jobCenter.getAllTechnicians();
				setTablePersona(listPerson,modelPersona);
				lblCantPersonas.setText("Cantidad de Técnicos registrados: "+String.valueOf(listPerson.size()));
			}
		});
		rdbtnTechnician.setBackground(Color.WHITE);
		rdbtnTechnician.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnTechnician.setBounds(250, 70, 103, 21);
		panelPersona.add(rdbtnTechnician);
		
		rdbtnWorker = new JRadioButton("Obrero");
		rdbtnWorker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnTodos.setEnabled(true);
				rdbtnStudent.setEnabled(true);
				rdbtnWorker.setEnabled(false);
				rdbtnTechnician.setEnabled(true);
				rdbtnStudent.setSelected(false);
				rdbtnTechnician.setSelected(false);
				rdbtnTodos.setSelected(false);
				listPerson=jobCenter.getAllWorkers();
				setTablePersona(listPerson,modelPersona);
				lblCantPersonas.setText("Cantidad de Obreros registrados: "+String.valueOf(listPerson.size()));
			}
		});
		rdbtnWorker.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnWorker.setBackground(Color.WHITE);
		rdbtnWorker.setBounds(430, 70, 103, 21);
		panelPersona.add(rdbtnWorker);
		
		rdbtnTodos = new JRadioButton("Todos");
		rdbtnTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnTodos.setEnabled(false);
				rdbtnStudent.setEnabled(true);
				rdbtnWorker.setEnabled(true);
				rdbtnTechnician.setEnabled(true);
				rdbtnStudent.setSelected(false);
				rdbtnTechnician.setSelected(false);
				rdbtnWorker.setSelected(false);
				listPerson=jobCenter.getMyPersons();
				setTablePersona(listPerson,modelPersona);
				lblCantPersonas.setText("Cantidad de Personas registradas: "+String.valueOf(listPerson.size()));
			}
		});
		rdbtnTodos.setEnabled(false);
		rdbtnTodos.setSelected(true);
		rdbtnTodos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnTodos.setBackground(Color.WHITE);
		rdbtnTodos.setBounds(610, 70, 65, 21);
		panelPersona.add(rdbtnTodos);
		
		JLabel lblTablaDePersonas = new JLabel("Tabla de Personas Registradas");
		lblTablaDePersonas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTablaDePersonas.setBounds(210, 21, 262, 28);
		panelPersona.add(lblTablaDePersonas);
		
		JButton btnMasInfo = new JButton("M\u00E1s Informaci\u00F3n ");
		btnMasInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tablePersona.getSelectedRow()<0)
					JOptionPane.showMessageDialog(null, "Seleccione una persona", "Problema de selección", JOptionPane.CLOSED_OPTION);
				else {
					String cedula=(String) tablePersona.getValueAt(tablePersona.getSelectedRow(), 0);
					Person person= JobCenter.getInstance().findPersonById(cedula);
					InformacionPersonVisual info=new InformacionPersonVisual(person);
					info.setVisible(true);
				}
			}
		});
		btnMasInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMasInfo.setBounds(508, 291, 180, 28);
		panelPersona.add(btnMasInfo);
		
		JButton btnSalirPersona = new JButton("Salir");
		btnSalirPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalirPersona.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalirPersona.setBounds(311, 291, 99, 28);
		panelPersona.add(btnSalirPersona);
		
		if(show==0) { //LISTAR EMPRESA
			panelPersona.setVisible(false);
			setTitle("Listar Empresa");
			this.myCompanies=jobCenter.getMyCompanies();
			setTableEmpresa(model,myCompanies);
			lblCantEmpresas.setText("Cantidad de Empresas Registradas: "+ String.valueOf(myCompanies.size()));
		}
		else if (show==1){ //LISTAR PERSONA
			panelEmpresa.setVisible(false);
			setTitle("Listar Persona");
			setTablePersona(listPerson,modelPersona);
		}
		else if(show==2) {
			panelPersona.setVisible(false);
			lblEmpresasReg.setText("Tabla de Solicitudes de Empresas");
			setTitle("Listar Solicitud de Empresas");
			this.myCompRequest=jobCenter.getMyCompanyRequests();
			setTableEmpresaSolicitud(model,myCompRequest);
			lblCantEmpresas.setText("Cantidad de Solicitudes de Empresas Registradas: "+ String.valueOf(myCompRequest.size()));
		}
		else {
			panelPersona.setVisible(false);
			lblEmpresasReg.setText("Tabla de Solicitudes de Personas");
			setTitle("Listar Solicitud de Personas");
			this.myEmployeeRequest=jobCenter.getMyEmployeeRequests();
			setTablePersonaSolicitud(model,myEmployeeRequest);
			lblCantEmpresas.setText("Cantidad de Solicitudes de Personas Registradas: "+ String.valueOf(myEmployeeRequest.size()));
		}
	}

	private void setTablePersonaSolicitud(DefaultTableModel model, List<EmployeeRequest> list) {
		model.setRowCount(0);
		for(int b=0;b<list.size();b++) {
			model.addRow(new Object[0]);	
			model.setValueAt(list.get(b).getId(), b, 0);
			model.setValueAt(list.get(b).getApplicant().getId(), b, 1);
			if(list.get(b).getApplicant() instanceof Student)
				model.setValueAt("Estudiante", b, 2);
			else if(list.get(b).getApplicant() instanceof Technician)
				model.setValueAt("Técnico", b, 2);
			else
				model.setValueAt("Obrero", b, 2);
			model.setValueAt(String.valueOf(String.valueOf(list.get(b).getMinSalary())), b, 3);
			if(list.get(b).getStatus()==true) 
				model.setValueAt("Activa", b, 4);
			else
				model.setValueAt("Inactiva", b, 4);
		}
	}

	private void setTableEmpresaSolicitud(DefaultTableModel model, List<CompanyRequest> list) {
		model.setRowCount(0);
		for(int b=0;b<list.size();b++) {
			model.addRow(new Object[0]);	
			model.setValueAt(list.get(b).getId(), b, 0);
			model.setValueAt(list.get(b).getCompany().getRnc(), b, 1);
			model.setValueAt(list.get(b).getSkillRequired(), b, 2);
			model.setValueAt(String.valueOf(list.get(b).getQuantity()), b, 3);
			if(list.get(b).isStatus()==true) 
				model.setValueAt("Activa", b, 4);
			else
				model.setValueAt("Inactiva", b, 4);
		}
		
	}

	private void setTablePersona(List<Person> list, DefaultTableModel modelPersona) {
		modelPersona.setRowCount(0);
		for(int b=0;b<list.size();b++) {
			modelPersona.addRow(new Object[0]);	
			modelPersona.setValueAt(list.get(b).getId(), b, 0);
			modelPersona.setValueAt(list.get(b).getName()+" "+list.get(b).getLastName(), b, 1);
			modelPersona.setValueAt(list.get(b).getProvince(), b, 2);
			modelPersona.setValueAt(list.get(b).getCity(), b, 3);
			if(list.get(b) instanceof Student)
				modelPersona.setValueAt("Estudiante", b, 4);
			else if(list.get(b) instanceof Technician)
				modelPersona.setValueAt("Técnico", b, 4);
			else
				modelPersona.setValueAt("Obrero", b, 4);
			if(list.get(b).isWorkingStatus())
				modelPersona.setValueAt("Empleado", b, 5);
			else
				modelPersona.setValueAt("Desempleado", b, 5);
		}
	}

	private void setTableEmpresa(DefaultTableModel model, List<Company> list) {
		model.setRowCount(0);
		for(int b=0;b<list.size();b++) {
			model.addRow(new Object[0]);	
			model.setValueAt(list.get(b).getRnc(), b, 0);
			model.setValueAt(list.get(b).getName(), b, 1);
			model.setValueAt(list.get(b).getProvince(), b, 2);
			model.setValueAt(list.get(b).getArea(), b, 3);
			model.setValueAt(list.get(b).getPhoneNumber(), b, 4);
		}
		
	}
}
