package vis;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import log.JobCenter;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
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
					EmployeeReg reg = new EmployeeReg(null);
					reg.setLocationRelativeTo(null);
					reg.setVisible(true);
				}
			});
			mntmPersona.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmRegistrar.add(mntmPersona);
			
			JMenuItem mntmEmpresa = new JMenuItem("Empresa");
			mntmEmpresa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CompanyReg reg = new CompanyReg(null);
					reg.setLocationRelativeTo(null);
					reg.setVisible(true);
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
					Listar list = new Listar(JobCenter.getInstance(), false);
					list.setLocationRelativeTo(null);
					list.setVisible(true);
				}
			});
			mntmListPersona.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmListar.add(mntmListPersona);
			
			JMenuItem mntmListEmpresa = new JMenuItem("Empresa");
			mntmListEmpresa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Listar list = new Listar(JobCenter.getInstance(), true);
					list.setLocationRelativeTo(null);
					list.setVisible(true);
				}
			});
			mntmListEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmListar.add(mntmListEmpresa);
		}
	}
}
