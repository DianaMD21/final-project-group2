package vis;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;

public class JobCenter extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Dimension dim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JobCenter dialog = new JobCenter();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JobCenter() {
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
			panel.add(menuBar, BorderLayout.NORTH);
			
			JMenu mnNewMenu = new JMenu("Registrar");
			mnNewMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
			menuBar.add(mnNewMenu);
			
			JMenuItem mntmNewMenuItem = new JMenuItem("Persona");
			mntmNewMenuItem.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnNewMenu.add(mntmNewMenuItem);
			
			JMenuItem mntmNewMenuItem_1 = new JMenuItem("Empresa");
			mntmNewMenuItem_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnNewMenu.add(mntmNewMenuItem_1);
			
			JMenu mnNewMenu_1 = new JMenu("Solicitud");
			mnNewMenu_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			menuBar.add(mnNewMenu_1);
			
			JMenuItem mntmNewMenuItem_2 = new JMenuItem("Solicitud de empleo");
			mntmNewMenuItem_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnNewMenu_1.add(mntmNewMenuItem_2);
			
			JMenuItem mntmNewMenuItem_3 = new JMenuItem("Solicitud de vacante");
			mntmNewMenuItem_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnNewMenu_1.add(mntmNewMenuItem_3);
		}
	}
}
