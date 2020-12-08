package vis;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Dialog.ModalityType;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import log.Company;
import log.CompanyRequest;
import log.EmployeeRequest;
import log.JobCenter;
import log.Person;
import log.Student;
import log.Technician;
import log.Worker;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class ListarSolicitudes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableSolicitud;
	private List<EmployeeRequest> employRequest;
	private List<CompanyRequest> compRequest;

	public ListarSolicitudes(Boolean status,String id) {
		//False=companyReq, TRUE=employeeReq
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListarSolicitudes.class.getResource("/logo.png")));
		setBounds(100, 100, 718, 343);
		setResizable(false);
		setLocationRelativeTo(null);
		setModalityType(ModalityType.APPLICATION_MODAL);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JScrollPane scrollPaneEmpresa = new JScrollPane();
			scrollPaneEmpresa.setBounds(10, 75, 671, 171);
			panel.add(scrollPaneEmpresa);
			
			tableSolicitud = new JTable(){
				   public boolean isCellEditable(int row, int column){
				        return false;
				   }
				};
			tableSolicitud.setBackground(Color.WHITE);
			tableSolicitud.setFont(new Font("Tahoma", Font.PLAIN, 12));
			scrollPaneEmpresa.setViewportView(tableSolicitud);
			
			DefaultTableModel model = new DefaultTableModel() {
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
							return Float.class;
					}
				}
			};
			
			tableSolicitud.setModel(model);
			tableSolicitud.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			JLabel lblNewLabel = new JLabel("Solitictudes de vacantes habilitadas:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel.setBounds(152, 27, 411, 24);
			panel.add(lblNewLabel);
			
			JButton btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(tableSolicitud.getSelectedRow()>=0) {
						if(status==false) {
							int result = JOptionPane.showConfirmDialog((Component) null, "¿Seguro que desea eliminar la solicitud No. "+tableSolicitud.getValueAt(tableSolicitud.getSelectedRow(), 1)+"?",
							        "alert", JOptionPane.OK_CANCEL_OPTION);
							if(result==JOptionPane.OK_OPTION) {
								CompanyRequest companyReToEliminate=JobCenter.getInstance().findCompanyRequestById((String) tableSolicitud.getValueAt(tableSolicitud.getSelectedRow(), 1));
								JobCenter.getInstance().getMyCompanyRequests().remove(companyReToEliminate);
								compRequest=JobCenter.getInstance().getAllCompRequestByID(JobCenter.getInstance().findCompanyById(id));
								setTableCompany(model,compRequest);
							}
						}
						else {
							int result = JOptionPane.showConfirmDialog((Component) null, "¿Seguro que desea eliminar la solicitud No. "+tableSolicitud.getValueAt(tableSolicitud.getSelectedRow(), 1)+"?",
							        "alert", JOptionPane.OK_CANCEL_OPTION);
							if(result==JOptionPane.OK_OPTION) {
								EmployeeRequest employeeReToEliminate=JobCenter.getInstance().findEmployeeRequestById((String) tableSolicitud.getValueAt(tableSolicitud.getSelectedRow(), 1));
								JobCenter.getInstance().getMyEmployeeRequests().remove(employeeReToEliminate);
								employRequest=JobCenter.getInstance().getAllEmployeeRequestByID(JobCenter.getInstance().findPersonById(id));
								setTablePerson(model,employRequest);
							}
						}
					}
					else {
						if(status==false)
							JOptionPane.showMessageDialog(null, "Seleccione una solicitud de empresa", "Problema de selección", JOptionPane.CLOSED_OPTION);
						else
							JOptionPane.showMessageDialog(null, "Seleccione una solicitud de persona", "Problema de selección", JOptionPane.CLOSED_OPTION);
					}
				}
			});
			btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnEliminar.setBounds(217, 257, 96, 24);
			panel.add(btnEliminar);
			
			JButton btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnSalir.setBounds(372, 257, 96, 24);
			panel.add(btnSalir);
			if(status==false) {
				Company comp=JobCenter.getInstance().findCompanyById(id);
				lblNewLabel.setText("Solicitudes de vacantes habilitadas de la empresa "+comp.getName());
				model.addColumn("RNC");
				model.addColumn("No. Solicitud");
				model.addColumn("Tipo de Vacante");
				model.addColumn("Habilidad/Carrera");
				model.addColumn("Cant. Vacantes");
				model.addColumn("Salario mínimo");
				compRequest=JobCenter.getInstance().getAllCompRequestByID(comp);
				setTableCompany(model,compRequest);
			}
			else {
				Person person=JobCenter.getInstance().findPersonById(id);
				lblNewLabel.setText("Solicitudes de vacantes habilitadas de la persona ");
				model.addColumn("Cédula");
				model.addColumn("No. Solicitud");
				model.addColumn("Tipo de persona");
				model.addColumn("Habilidad/Carrera");
				model.addColumn("Horas de trabajo");
				model.addColumn("Salario mínimo");
				employRequest=JobCenter.getInstance().getAllEmployeeRequestByID(person);
				setTablePerson(model,employRequest);
			}
		}
	}

	private void setTablePerson(DefaultTableModel model, List<EmployeeRequest> employeeRequest) {
		model.setRowCount(0);
		for(int b=0;b<employeeRequest.size();b++) {
			model.addRow(new Object[0]);	
			model.setValueAt(employeeRequest.get(b).getApplicant().getId(), b, 0);
			model.setValueAt(employeeRequest.get(b).getId(), b, 1);
			if(employeeRequest.get(b).getApplicant() instanceof Student) {
				model.setValueAt("Estudiante", b, 2);
				Student student=(Student) employeeRequest.get(b).getApplicant();
				model.setValueAt(student.getCareer(), b, 3);
			}
			else if(employeeRequest.get(b).getApplicant() instanceof Technician) {
				model.setValueAt("Técnico", b, 2);
				Technician tech=(Technician) employeeRequest.get(b).getApplicant();
				model.setValueAt(tech.getArea(), b, 3);
			}
			else {
				model.setValueAt("Obrero", b, 2);
				Worker worker=(Worker) employeeRequest.get(b).getApplicant();
				model.setValueAt(worker.getSkills(), b, 3);
			}
			//model.setValueAt(employeeRequest.get(b).ge, b, 3);
			model.setValueAt(String.valueOf(employeeRequest.get(b).getWorkingHours()), b, 4);
			model.setValueAt(employeeRequest.get(b).getMinSalary(), b, 5);
			
		}
	}

	private void setTableCompany(DefaultTableModel model, List<CompanyRequest> compRequest) {
		model.setRowCount(0);
		for(int b=0;b<compRequest.size();b++) {
			model.addRow(new Object[0]);	
			model.setValueAt(compRequest.get(b).getCompany().getRnc(), b, 0);
			model.setValueAt(compRequest.get(b).getId(), b, 1);
			model.setValueAt(compRequest.get(b).getTypeOfEmployee(), b, 2);
			model.setValueAt(compRequest.get(b).getSkillRequired(), b, 3);
			model.setValueAt(compRequest.get(b).getQuantity(), b, 4);
			model.setValueAt(compRequest.get(b).getMinSalary(), b, 5);
			
		}
	}
}
