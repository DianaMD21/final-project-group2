package vis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Dialog.ModalityType;

import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import log.JobCenter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FindIDVisual extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtID;
	private JLabel lblTitle;
	private JButton btnEliminar;
	private String myID;

	/**
	 
	public static void main(String[] args) {
		try {
			final String id="";
			FindIDVisual dialog = new FindIDVisual();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setTitleAndLabel(1);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param id 
	 */
	public FindIDVisual(String id,JobCenter jobCenter,int status) {
		this.myID=id;
		setTitle("Eliminar");
		setBounds(100, 100, 445, 198);
		setModalityType(ModalityType.APPLICATION_MODAL);
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
			panel.setBackground(Color.WHITE);
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				lblTitle = new JLabel("Introduzca el RNC de la Empresa a eliminar:");
				lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblTitle.setBounds(68, 22, 315, 14);
				panel.add(lblTitle);
			}
			
			setTitleAndLabel(status);
			
			txtID = new JTextField();
			txtID.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtID.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char caracter = e.getKeyChar();
	                if (((caracter < '0') || (caracter > '9'))
	                        && (caracter != '\b') ) {
	                    e.consume();
	                }
				}
			});
			txtID.setBounds(78, 47, 262, 31);
			panel.add(txtID);
			txtID.setColumns(10);
			
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					myID=txtID.getText();
					if(txtID.getText().equalsIgnoreCase(""))
						JOptionPane.showMessageDialog(null, "No deje el campo vacío", "Problema de búsqueda", JOptionPane.CLOSED_OPTION);	
					else if(jobCenter.findCompanyById(myID)==null && (status==0 || status==2))
						JOptionPane.showMessageDialog(null, "Esta empresa no existe", "Empresa no encontrada", JOptionPane.CLOSED_OPTION);
					else if(jobCenter.findPersonById(myID)==null && (status==1||status==3))
						JOptionPane.showMessageDialog(null, "Esta persona no existe", "Persona no encontrada", JOptionPane.CLOSED_OPTION);
					else 
						dispose();
					
					
				}
			});
			btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnEliminar.setBounds(78, 103, 101, 31);
			panel.add(btnEliminar);
			
			JButton btnSalir = new JButton("Salir");
			btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					myID="";
					dispose();
				}
			});
			btnSalir.setBounds(239, 103, 101, 31);
			panel.add(btnSalir);
		}
	}
	
	public String getID() {
		return this.myID;
	}

	private void setTitleAndLabel(int status) {
		if(status==0) {
			this.setTitle("Eliminar Empresa");
			this.lblTitle.setText("Introduzca el RNC:");
		}
		else if (status==1) {
			this.setTitle("Eliminar Persona");
			this.lblTitle.setText("Introduzca la cédula:");
		}
		else if(status==2) {
			this.setTitle("Eliminar Solicitud de Empresa");
			this.lblTitle.setText("Introduzca el RNC de la Empresa:");
			this.btnEliminar.setText("Acceder");
		}
		else {
			this.setTitle("Eliminar Solicitud de Persona");
			this.lblTitle.setText("Introduzca la cédula de la persona:");
			this.btnEliminar.setText("Acceder");
		}
		
	}
}
