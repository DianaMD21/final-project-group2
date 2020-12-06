package vis;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.util.ShadowGenerator;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import log.JobCenter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;

public class DataGraphs extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblTexto;
	private JPanel panel;

	/**
	 
	public static void main(String[] args) {
		try {
			int status=4;
			//0 grafico 1
			//1 grafico 2
			//2 Grafico 3 
			DataGraphs dialog = new DataGraphs(status);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	 @param status 
	 */
	public DataGraphs(int status) {
		setTitle("Datos y Estad\u00EDstica ");
		setModalityType(ModalityType.APPLICATION_MODAL);
		
		setBounds(100, 100, 569, 481);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			contentPanel.add(panel, BorderLayout.CENTER);
			
			lblTexto = new JLabel("New label");
			lblTexto.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblTexto.setBounds(50, 26, 500, 14);
			panel.add(lblTexto);
			
			setGraph(status);
			
			JButton btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnSalir.setBounds(236, 387, 98, 32);
			panel.add(btnSalir);
		}
	}

	private void setGraph(int status) {
		if(status==1) {
			lblTexto.setText("Datos sobre los tipo de empleados mas solicitados por empresas");
			DefaultPieDataset dataSet = new DefaultPieDataset();
			dataSet.setValue("Universitario", new Integer(JobCenter.getInstance().getAmountStudentRequestedByCompanies()));
			dataSet.setValue("Técnico", new Integer(JobCenter.getInstance().getAmountTechnicianRequestedByCompanies()));
			dataSet.setValue("Obrero", new Integer(JobCenter.getInstance().getAmountWorkerRequestedByCompanies()));
			
			JFreeChart pieChart=ChartFactory.createPieChart("Pie Chart", dataSet,true, true, true);
			PiePlot p=(PiePlot)pieChart.getPlot();
			ChartPanel fame= new ChartPanel(pieChart);
			fame.setBounds(59, 64, 428, 300);
			p.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} {2}"));
			fame.setVisible(true);
			panel.setLayout(null);
			panel.add(fame);
		}
		else if (status==0) {
			lblTexto.setText("        Datos sobre la cantidad de empresas para cada área");
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	        dataset.setValue(JobCenter.getInstance().amountCompaniesPerArea("Turismo"), "Turismo", "");
	        dataset.setValue(JobCenter.getInstance().amountCompaniesPerArea("Salud"), "Salud", "");
	        dataset.setValue(JobCenter.getInstance().amountCompaniesPerArea("Educación"), "Educación", "");
	        dataset.setValue(JobCenter.getInstance().amountCompaniesPerArea("Tecnología"), "Tecnología", "");
	        dataset.setValue(JobCenter.getInstance().amountCompaniesPerArea("Construcción"), "Construcción", "");
	        dataset.setValue(JobCenter.getInstance().amountCompaniesPerArea("Venta de Vehículos"), "Venta de Vehículos", "");
	       
	        JFreeChart chart = ChartFactory.createBarChart3D
	        ("Cantidad de empresas por área","Área", "Cant. Empresas", 
	        dataset, PlotOrientation.VERTICAL, true,true, false);
	        chart.setBackgroundPaint(Color.LIGHT_GRAY);
	        chart.getTitle().setPaint(Color.black); 
	        CategoryPlot p = chart.getCategoryPlot(); 
	        p.setRangeGridlinePaint(Color.red); 
	        ChartPanel chartPanel = new ChartPanel(chart);
	        chartPanel.setBounds(59, 64, 428, 300);
	        chartPanel.setVisible(true);
			panel.setLayout(null);
	        panel.add(chartPanel);
		}
		else {
			lblTexto.setText("  Datos sobre la cantidad de solicitudes de empleo satisfechas");
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	        dataset.setValue(JobCenter.getInstance().getMyEmployeeRequests().size(), "Solicitudes de empleo", "Solicitudes de empleo");
	        dataset.setValue(JobCenter.getInstance().getSatisfiedEmployeeRequest(), "Solicitudes satisfechas", "Solicitudes satisfechas");
	       
	        JFreeChart chart = ChartFactory.createBarChart3D
	        ("Cantidad de empresas por área","Área", "Cant. Empresas", 
	        dataset, PlotOrientation.VERTICAL, true,true, false);
	        chart.setBackgroundPaint(Color.LIGHT_GRAY);
	        chart.getTitle().setPaint(Color.black); 
	        CategoryPlot p = chart.getCategoryPlot(); 
	        p.setRangeGridlinePaint(Color.red); 
	        ChartPanel chartPanel = new ChartPanel(chart);
	        chartPanel.setBounds(59, 64, 428, 300);
	        chartPanel.setVisible(true);
			panel.setLayout(null);
	        panel.add(chartPanel);
		}
	}
}
