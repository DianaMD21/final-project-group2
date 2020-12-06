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
import log.CompanyRequest;
import log.EmployeeRequest;
import log.JobCenter;
import log.Person;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;

public class JobCenterVisual extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				try {
					FileInputStream fileJobCenterIn = new FileInputStream("JobCenter.dat");
					ObjectInputStream streamJobCenterIn = new ObjectInputStream(fileJobCenterIn);
					JobCenter.setInstance((JobCenter) streamJobCenterIn.readObject());
					EmployeeRequest.cod = streamJobCenterIn.readInt();
					CompanyRequest.cod = streamJobCenterIn.readInt();
					fileJobCenterIn.close();
				} catch (IOException | ClassNotFoundException e1) {
					
				}
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				
				try {
					FileOutputStream fileJobCenterOut = new FileOutputStream("JobCenter.dat");
					ObjectOutputStream streamJobCenterOut = new ObjectOutputStream(fileJobCenterOut);
					streamJobCenterOut.writeObject(JobCenter.getInstance());
					streamJobCenterOut.flush();
					streamJobCenterOut.writeInt(EmployeeRequest.cod);
					streamJobCenterOut.flush();
					streamJobCenterOut.writeInt(CompanyRequest.cod);
					fileJobCenterOut.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				} 
			}
		});
		setTitle("Bolsa de Trabajo Dominicana");
		setBounds(100, 100, 638, 306);
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
								" "+personToEliminate.getLastName()+", y todas las solicitudes que creó?",
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
					FindIDVisual findCompany=new FindIDVisual(RNC,JobCenter.getInstance(),0);
					findCompany.setVisible(true);
					RNC=findCompany.getID();
					if(RNC.equalsIgnoreCase("")==false) {
						Company companyToEliminate=JobCenter.getInstance().findCompanyById(RNC);
						int result = JOptionPane.showConfirmDialog((Component) null, "¿Seguro que desea eliminar la empresa "+companyToEliminate.getName()+
								", y todas las solicitudes que creó?",
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
					FindIDVisual findCompany=new FindIDVisual(RNC,JobCenter.getInstance(),2);
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
					FindIDVisual findPersona=new FindIDVisual(cedula,JobCenter.getInstance(),3);
					findPersona.setVisible(true);
					cedula=findPersona.getID();
					if(cedula.equalsIgnoreCase("")==false) {
						ListarSolicitudes deletePersonRequest=new ListarSolicitudes(true, cedula);
						deletePersonRequest.setVisible(true);
					}
				}
			});
			mntmElimPersonReq.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmEliminarSol.add(mntmElimPersonReq);
			
			JMenu mnnmModificar = new JMenu("Modificar");
			mnnmModificar.setFont(new Font("Tahoma", Font.PLAIN, 16));
			menuBar.add(mnnmModificar);
			
			JMenuItem mntmModPersona = new JMenuItem("Persona");
			mntmModPersona.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String cedula="";
					FindIDVisual findPersona=new FindIDVisual(cedula,JobCenter.getInstance(),4);
					findPersona.setVisible(true);
					cedula=findPersona.getID();
					if(cedula.equalsIgnoreCase("")==false) {
						Person personToModify=JobCenter.getInstance().findPersonById(cedula);
						EmployeeReg newEmployee=new EmployeeReg(personToModify);
						newEmployee.setVisible(true);
					}
				}
			});
			mntmModPersona.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmModificar.add(mntmModPersona);
			
			JMenuItem mntmModEmpresa = new JMenuItem("Empresa");
			mntmModEmpresa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String RNC="";
					FindIDVisual findCompany=new FindIDVisual(RNC,JobCenter.getInstance(),5);
					findCompany.setVisible(true);
					RNC=findCompany.getID();
					if(RNC.equalsIgnoreCase("")==false) {
						Company companyToModify=JobCenter.getInstance().findCompanyById(RNC);
						CompanyReg newComp=new CompanyReg(companyToModify);
						newComp.setVisible(true);
					}
				}
			});
			mntmModEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmModificar.add(mntmModEmpresa);
			
			JMenu mnnmSolicitud = new JMenu("Solicitud");
			mnnmSolicitud.setFont(new Font("Tahoma", Font.PLAIN, 16));
			menuBar.add(mnnmSolicitud);
			
			JMenuItem mntmSolEmpleo = new JMenuItem("Solicitud de empleo");
			mntmSolEmpleo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						EmployeeRequestReg employeeRequestReg = new EmployeeRequestReg(null);
						employeeRequestReg.setVisible(true);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});
			mntmSolEmpleo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmSolicitud.add(mntmSolEmpleo);
			
			JMenuItem mntmSolVacante = new JMenuItem("Solicitud de vacante");
			mntmSolVacante.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						CompanyRequestReg companyRequestReg = new CompanyRequestReg(null);
						companyRequestReg.setVisible(true);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});
			mntmSolVacante.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmSolicitud.add(mntmSolVacante);
			
			JMenu mnNewMenu = new JMenu("Match");
			mnNewMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
			menuBar.add(mnNewMenu);
			
			JMenuItem mntmNewMenuItem = new JMenuItem("Enlazar");
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EmployeeMatch match = new EmployeeMatch();
					match.setLocationRelativeTo(null);
					match.setVisible(true);
				}
			});
			mnNewMenu.add(mntmNewMenuItem);
			
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
			
			JMenu mnnmEstadisticas = new JMenu("Estad\u00EDsticas / Datos");
			mnnmEstadisticas.setFont(new Font("Tahoma", Font.PLAIN, 16));
			menuBar.add(mnnmEstadisticas);
			
			JMenuItem mntmnSolicitudPorPersona = new JMenuItem("Tipo de vacantes solicitadas por empresas");
			mntmnSolicitudPorPersona.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					DataGraphs dataGraph = new DataGraphs(1);
					dataGraph.setVisible(true);
				}
			});
			mntmnSolicitudPorPersona.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmEstadisticas.add(mntmnSolicitudPorPersona);
			
			JMenuItem mntmnCantEmpresasArea = new JMenuItem("Cantidad de empresas por \u00E1rea");
			mntmnCantEmpresasArea.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					DataGraphs dataGraph = new DataGraphs(0);
					dataGraph.setVisible(true);
				}
			});
			mntmnCantEmpresasArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmEstadisticas.add(mntmnCantEmpresasArea);
			
			JMenuItem mntmnCantSolSatisfechas = new JMenuItem("Cantidad de solicitudes de empleo satisfechas");
			mntmnCantSolSatisfechas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DataGraphs dataGraph = new DataGraphs(3);
					dataGraph.setVisible(true);
				}
			});
			mntmnCantSolSatisfechas.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmEstadisticas.add(mntmnCantSolSatisfechas);
		}
	}
}
