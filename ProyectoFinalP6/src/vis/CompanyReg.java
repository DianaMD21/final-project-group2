package vis;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import java.awt.TextArea;
import java.awt.Dialog.ModalityType;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;

import log.Company;

import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CompanyReg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtCity;
	private JTextField txtEmail;
	private JTextField txtTelefono;
	private JComboBox cbxArea;
	private JTextArea txtAreaAddress;
	private JComboBox<String> cbxProvince;
	private JTextField txtRnc;

	/*
	public static void main(String[] args) {
		try {
			Company company= new Company( "Diana", "Salud", "Gurabo", "Duarte", "Santiago", "5266", "hi");
			company.setId("h");
			CompanyReg dialog = new CompanyReg(company);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	 @param company 
	 */
	public CompanyReg(Company company) {
		setTitle("Registrar Empresa");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 577, 594);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		contentPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblInformacionGeneral = new JLabel("Informaci\u00F3n general");
		lblInformacionGeneral.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInformacionGeneral.setBounds(10, 10, 187, 21);
		panel.add(lblInformacionGeneral);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 38, 525, 2);
		panel.add(separator_2);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(10, 96, 70, 27);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombre.setColumns(10);
		txtNombre.setBounds(100, 97, 435, 28);
		panel.add(txtNombre);
		
		JLabel lblArea = new JLabel("\u00C1rea:");
		lblArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblArea.setBounds(10, 143, 70, 27);
		panel.add(lblArea);
		
		cbxArea = new JComboBox();
		cbxArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbxArea.setModel(new DefaultComboBoxModel(new String[] {"<Sin especificar>", "Turismo", "Salud", "Educaci\u00F3n", "Tecnolog\u00EDa", "Construcci\u00F3n", "Venta de veh\u00EDculos"}));
		cbxArea.setBounds(100, 142, 181, 27);
		panel.add(cbxArea);
		
		JLabel lblInformacionContacto = new JLabel("Informaci\u00F3n de contacto");
		lblInformacionContacto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInformacionContacto.setBounds(10, 187, 227, 21);
		panel.add(lblInformacionContacto);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(10, 215, 523, 2);
		panel.add(separator_2_1);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDireccin.setBounds(10, 275, 89, 27);
		panel.add(lblDireccin);
		
		JLabel label_7 = new JLabel("Provincia:");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_7.setBounds(10, 230, 89, 27);
		panel.add(label_7);
		
		cbxProvince = new JComboBox<String>();
		cbxProvince.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Azua", "Bahoruco", "Barahona", "Dajab\u00F3n", "Distrito Nacional", "Duarte", "El\u00EDas Pi\u00F1a", "El Seibo", "Espaillat", "Hato Mayor", "Hermanas Mirabal", "Independencia", "La Altagracia", "La Romana", "La Vega", "Mar\u00EDa Trinidad S\u00E1nchez", "Monse\u00F1or Nouel", "Monte Cristi", "Monte Plata"}));
		cbxProvince.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbxProvince.setBounds(100, 230, 179, 27);
		panel.add(cbxProvince);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCiudad.setBounds(317, 230, 89, 27);
		panel.add(lblCiudad);
		
		txtCity = new JTextField();
		txtCity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
                if (((caracter < 'a') || (caracter > 'z')) && ((caracter < 'A') || (caracter > 'Z'))
                        && (caracter != '\b') && (caracter!=32)) {
                    e.consume();
                }
			}
		});
		txtCity.setColumns(10);
		txtCity.setBounds(390, 229, 145, 28);
		panel.add(txtCity);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		
		txtAreaAddress = new JTextArea();
		txtAreaAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAreaAddress.setBounds(100, 272, 435, 58);
		panel.add(txtAreaAddress);
		txtAreaAddress.setBorder(BorderFactory.createCompoundBorder(border,
	            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		txtAreaAddress.setLineWrap(true);
		txtAreaAddress.setWrapStyleWord(true);

		
		JLabel lblInformacionContacto_1 = new JLabel("Informaci\u00F3n de contacto");
		lblInformacionContacto_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInformacionContacto_1.setBounds(10, 350, 227, 21);
		panel.add(lblInformacionContacto_1);
		
		JSeparator separator_2_1_1 = new JSeparator();
		separator_2_1_1.setBounds(10, 378, 523, 2);
		panel.add(separator_2_1_1);
		
		JLabel lblCorreoElectronico = new JLabel("Correo electr\u00F3nico ");
		lblCorreoElectronico.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCorreoElectronico.setBounds(10, 393, 145, 27);
		panel.add(lblCorreoElectronico);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(165, 390, 311, 28);
		panel.add(txtEmail);
		
		JLabel lblNmeroTelefnico = new JLabel("N\u00FAmero telef\u00F3nico:");
		lblNmeroTelefnico.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNmeroTelefnico.setBounds(10, 439, 145, 27);
		panel.add(lblNmeroTelefnico);
		
		txtTelefono = new JTextField();
		txtTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9'))
                        && (caracter != '\b') ) {
                    e.consume();
                }
			}
		});
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(165, 440, 145, 28);
		panel.add(txtTelefono);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkAllTextBox()==false) {
					JOptionPane.showMessageDialog(null, "No deje ning�n campo vac�o, por favor", "Problema de registo", JOptionPane.CLOSED_OPTION);
				}
				else {
					company.setAddress(txtAreaAddress.getText());
					company.setCity(txtCity.getText());
					company.setEmail(txtEmail.getText());
					company.setName(txtNombre.getText());
					company.setPhoneNumber(txtTelefono.getText());
					company.setProvince((String) cbxProvince.getSelectedItem());
				}
			}
		});
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistrar.setBounds(141, 496, 106, 27);
		panel.add(btnRegistrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(300, 496, 106, 27);
		panel.add(btnCancelar);
		
		JLabel lblRnc = new JLabel("RNC:");
		lblRnc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRnc.setBounds(10, 50, 70, 27);
		panel.add(lblRnc);
		
		txtRnc = new JTextField();
		txtRnc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9'))
                        && (caracter != '\b') ) {
                    e.consume();
                }
			}
		});
		txtRnc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtRnc.setColumns(10);
		txtRnc.setBounds(100, 51, 435, 28);
		panel.add(txtRnc);
		
		if(company.getId().equals("")==false) {
			setCompanyValuesToModify(company);
		}
	}

	private void setCompanyValuesToModify(Company company) {
		txtNombre.setText(company.getName());
		txtCity.setText(company.getCity());
		txtEmail.setText(company.getEmail());
		txtTelefono.setText(company.getPhoneNumber());
		cbxProvince.setSelectedItem(company.getProvince());
		cbxArea.setSelectedItem(company.getArea());
		txtAreaAddress.setText(company.getAddress());
		
	}

	protected boolean checkAllTextBox() {
		Boolean check=true;
		if(txtNombre.getText().equals("")|| txtCity.getText().equals("") || txtEmail.getText().equals("")
				|| txtTelefono.getText().equals("")|| cbxArea.getSelectedIndex()==-1 || txtAreaAddress.getText().equals("")
				|| cbxProvince.getSelectedIndex()==-1) {
			check=false;
		}
		return check;
	}
}