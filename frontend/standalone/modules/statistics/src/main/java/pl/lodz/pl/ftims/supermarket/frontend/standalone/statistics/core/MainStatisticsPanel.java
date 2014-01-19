	

    package pl.lodz.pl.ftims.supermarket.frontend.standalone.statistics.core;
     
    import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
     
     
    public class MainStatisticsPanel extends JPanel implements ActionListener{
            private static final long serialVersionUID = 1L;
            private JButton bSave1, bSave2;
            private JFreeChart costChart, soldChart;
     
            public MainStatisticsPanel() {
                    setLayout(new BorderLayout(0, 0));
     
                    DrawChart drawChart = new DrawChart();
     
                    JTabbedPane tabbedPane = new JTabbedPane();
                    add(tabbedPane);
                   
                    JPanel panel = new JPanel();
                    tabbedPane.addTab("Koszta", null, panel, null);
                    costChart = drawChart.XYLineChart();
                    panel.add(drawChart.drawXYLineChart());
                    JButton bSave = new JButton("Zapisz");
                    bSave.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent e) {
                    		JFileChooser fc = new JFileChooser();
                    		if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                    			File file = fc.getSelectedFile();
                    			try {
                    				ChartUtilities.saveChartAsPNG(file, costChart, 700, 450);
                    			} catch (IOException e1) {
                    				e1.printStackTrace();
                    			}
                   			}
                   		}
                    });
                    panel.add(bSave);
                    
                   
                    JPanel panel_1 = new JPanel();
                    tabbedPane.addTab("Sprzedane towary", null, panel_1, null);
                    panel_1.add(drawChart.drawPieChart());
                    soldChart = drawChart.PieChart();
                    JButton bSave2 = new JButton("Zapisz");
                    bSave2.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent e) {
                    		JFileChooser fc = new JFileChooser();
                    		if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                    			File plik = fc.getSelectedFile();
                    			try {
                    				ChartUtilities.saveChartAsPNG(plik, soldChart, 700, 450);
                    			} catch (IOException e1) {
                    				e1.printStackTrace();
                    			}
                   			}
                   		}
                    });
                    panel_1.add(bSave2);
                    
                   
                    JPanel panel_2 = new JPanel();
                    tabbedPane.addTab("Wykres pierścień", null, panel_2, null);
                    panel_2.add(drawChart.drawRingChart());
                   
                    JPanel panel_3 = new JPanel();
                    tabbedPane.addTab("Wykres czasowy", null, panel_3, null);
                    panel_3.add(drawChart.drawTimeSeriesChart());
                   
                    JPanel panel_4 = new JPanel();
                    tabbedPane.addTab("Wykres słupkowy", null, panel_4, null);
                    panel_4.add(drawChart.drawBarChart());
            }

			@Override
			public void actionPerformed(ActionEvent e) {
			}
    }