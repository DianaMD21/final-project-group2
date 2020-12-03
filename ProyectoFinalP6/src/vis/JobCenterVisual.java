package vis;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import log.Company;
import log.JobCenter;
import log.Person;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JobCenterVisual extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Dimension dim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JobCenterVisual dialog = new JobCenterVisual();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JobCenterVisual() {
		setTitle("Bolsa de Trabajo Dominicana");
		setBounds(100, 100, 450, 300);
		dim= getToolkit().getScreenSize();
		super.setSize(dim.width, dim.height);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			
			JMenuBar menuBar = new JMenuBar();
			menuBar.setToolTipText("Listar");
			panel.add(menuBar, BorderLayout.NORTH);
			
			JMenu mnnmRegistrar = new JMenu("Registrar");
			mnnmRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
			menuBar.add(mnnmRegistrar);
			
			JMenuItem mntmPersona = new JMenuItem("Persona");
			mntmPersona.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Person employee = null;
					EmployeeReg newEmployee=new EmployeeReg(employee);
					newEmployee.setVisible(true);
				}
			});
			mntmPersona.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmRegistrar.add(mntmPersona);
			
			JMenuItem mntmEmpresa = new JMenuItem("Empresa");
			mntmEmpresa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Company company=new Company("", "", "", "", "", "", "", "");
					CompanyReg newCompany=new CompanyReg(company);
					newCompany.setVisible(true);
					System.out.println("cant empresas: "+JobCenter.getInstance().getMyCompanies().size());
				}
			});
			mntmEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmRegistrar.add(mntmEmpresa);
			
			JMenu mnnmEliminar = new JMenu("Eliminar");
			mnnmEliminar.setFont(new Font("Tahoma", Font.PLAIN, 16));
			menuBar.add(mnnmEliminar);
			
			JMenuItem mntmElimPersona = new JMenuItem("Persona");
			mntmElimPersona.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String cedula="";
					FindIDVisual findPersona=new FindIDVisual(cedula,JobCenter.getInstance(),1);
					findPersona.setVisible(true);
					cedula=findPersona.getID();
					if(cedula.equalsIgnoreCase("")==false) {
						Person personToEliminate=JobCenter.getInstance().findPersonById(cedula);
						int result = JOptionPane.showConfirmDialog((Component) null, "¿Seguro que desea eliminar la persona "+personToEliminate.getName()+
								" "+personToEliminate.getLastName()+"?",
						        "alert", JOptionPane.OK_CANCEL_OPTION);
						if(result==JOptionPane.OK_OPTION) {
							JobCenter.getInstance().getMyPersons().remove(personToEliminate);
							JobCenter.getInstance().eliminateAllActivePersonRequests(personToEliminate);
							JOptionPane.showMessageDialog(null, "La persona ha sido eliminada con éxito", "Persona Eliminada", JOptionPane.CLOSED_OPTION);
						}
					}
				}
			});
			mntmElimPersona.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmEliminar.add(mntmElimPersona);
			
			JMenuItem mntmElimEmpresa = new JMenuItem("Empresa");
			mntmElimEmpresa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String RNC="";
					FindIDVisual findCompany=new FindIDVisual(RNC,JobCenter.getInstance(),1);
					findCompany.setVisible(true);
					RNC=findCompany.getID();
					if(RNC.equalsIgnoreCase("")==false) {
						Company companyToEliminate=JobCenter.getInstance().findCompanyById(RNC);
						int result = JOptionPane.showConfirmDialog((Component) null, "¿Seguro que desea eliminar la empresa "+companyToEliminate.getName()+"?",
						        "alert", JOptionPane.OK_CANCEL_OPTION);
						if(result==JOptionPane.OK_OPTION) {
							JobCenter.getInstance().getMyCompanies().remove(companyToEliminate);
							JobCenter.getInstance().eliminateAllActiveCompanyRequests(companyToEliminate);
							JOptionPane.showMessageDialog(null, "La empresa ha sido eliminada con éxito", "Empresa Eliminada", JOptionPane.CLOSED_OPTION);
						}	
					}
				}
			});
			mntmElimEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmEliminar.add(mntmElimEmpresa);
			
			JMenu mnnmEliminarSol = new JMenu("Solicitud");
			mnnmEliminarSol.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmEliminar.add(mnnmEliminarSol);
			
			JMenuItem mntmElimCompanyReq = new JMenuItem("Empresa");
			mntmElimCompanyReq.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String RNC="";
					FindIDVisual findCompany=new FindIDVisual(RNC,JobCenter.getInstance(),1);
					findCompany.setVisible(true);
					RNC=findCompany.getID();
					if(RNC.equalsIgnoreCase("")==false) {
						ListarSolicitudes deleteCompanyRequest=new ListarSolicitudes(false, RNC);
						deleteCompanyRequest.setVisible(true);
					}
				}
			});
			mntmElimCompanyReq.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmEliminarSol.add(mntmElimCompanyReq);
			
			JMenuItem mntmElimPersonReq = new JMenuItem("Persona");
			mntmElimPersonReq.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String cedula="";
					FindIDVisual findPersona=new FindIDVisual(cedula,JobCenter.getInstance(),1);
					findPersona.setVisible(true);
					cedula=findPersona.getID();
					if(cedula.equalsIgnoreCase("")==false) {
						ListarSolicitudes deletePersonRequest=new ListarSolicitudes(false, cedula);
						deletePersonRequest.setVisible(true);
					}
				}
			});
			mntmElimPersonReq.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmEliminarSol.add(mntmElimPersonReq);
			
			JMenu mnnmSolicitud = new JMenu("Solicitud");
			mnnmSolicitud.setFont(new Font("Tahoma", Font.PLAIN, 16));
			menuBar.add(mnnmSolicitud);
			
			JMenuItem mntmSolEmpleo = new JMenuItem("Solicitud de empleo");
			mntmSolEmpleo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			mntmSolEmpleo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmSolicitud.add(mntmSolEmpleo);
			
			JMenuItem mntmSolVacante = new JMenuItem("Solicitud de vacante");
			mntmSolVacante.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			mntmSolVacante.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmSolicitud.add(mntmSolVacante);
			
			JMenu mnnmListar = new JMenu("Listar");
			mnnmListar.setFont(new Font("Tahoma", Font.PLAIN, 16));
			menuBar.add(mnnmListar);
			
			JMenuItem mntmListPersona = new JMenuItem("Persona");
			mntmListPersona.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Listar listPerson=new Listar(JobCenter.getInstance(),false);
					listPerson.setVisible(true);
				}
			});
			mntmListPersona.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmListar.add(mntmListPersona);
			
			JMenuItem mntmListEmpresa = new JMenuItem("Empresa");
			mntmListEmpresa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Listar listCompany=new Listar(JobCenter.getInstance(),true);
					listCompany.setVisible(true);
				}
			});
			mntmListEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmListar.add(mntmListEmpresa);
		}
	}
}
