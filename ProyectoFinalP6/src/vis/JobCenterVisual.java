package vis;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import log.JobCenter;
import log.EmployeeRequest;
import log.CompanyRequest;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
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
					try {
						EmployeeReg employeeReg = new EmployeeReg(null);
						employeeReg.setVisible(true);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});
			mntmPersona.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmRegistrar.add(mntmPersona);
			
			JMenuItem mntmEmpresa = new JMenuItem("Empresa");
			mntmEmpresa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						CompanyReg companyReg = new CompanyReg(null);
						companyReg.setVisible(true);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});
			mntmEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmRegistrar.add(mntmEmpresa);
			
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
			
			JMenu mnnmListar = new JMenu("Listar");
			mnnmListar.setFont(new Font("Tahoma", Font.PLAIN, 16));
			menuBar.add(mnnmListar);
			
			JMenuItem mntmListPersona = new JMenuItem("Persona");
			mntmListPersona.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Listar listpersons = new Listar(JobCenter.getInstance(),false);
						listpersons.setVisible(true);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});
			mntmListPersona.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmListar.add(mntmListPersona);
			
			JMenuItem mntmListEmpresa = new JMenuItem("Empresa");
			mntmListEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmListar.add(mntmListEmpresa);
		}
	}
}
