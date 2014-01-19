package pl.lodz.pl.ftims.supermarket.frontend.standalone.statistics.core;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;

import pl.lodz.pl.ftims.supermarket.frontend.standalone.core.Stale;

public class MainStatisticsPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JFreeChart costChart, soldChart, ringChart, timeChart, barChart;

	/*
	 * private JButton bSave, bSave1, bSave2; private JComboBox cbYear, cbYear1,
	 * cbYear2; private JLabel lYear, lYear1, lYear2;
	 */

	public MainStatisticsPanel() {
		if (Stale.getInstance().getAccessLevel() == 0
				|| Stale.getInstance().getAccessLevel() == 1
				|| Stale.getInstance().getAccessLevel() == 2) {
			setLayout(new BorderLayout(0, 0));

			final DrawChart drawChart = new DrawChart();

			JTabbedPane tabbedPane = new JTabbedPane();
			add(tabbedPane);

			JPanel panel = new JPanel();
			JPanel panel_button = new JPanel();
			final JPanel panel_chart = new JPanel();
			panel.add(panel_button, BorderLayout.NORTH);
			panel.add(panel_chart, BorderLayout.SOUTH);

			tabbedPane.addTab("Koszta", null, panel, null);
			costChart = drawChart.XYLineChart(2014);
			panel_chart.add(drawChart.drawXYLineChart(2014));
			JLabel lYear = new JLabel("Wybierz rok");
			final JComboBox cbYear = new JComboBox();
			cbYear.addItem("2010");
			cbYear.addItem("2011");
			cbYear.addItem("2012");
			cbYear.addItem("2013");
			cbYear.addItem("2014");
			cbYear.setSelectedIndex(4);
			cbYear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int year = Integer.parseInt(cbYear.getSelectedItem()
							.toString());
					panel_chart.removeAll();
					panel_chart.revalidate();
					panel_chart.repaint();
					panel_chart.add(drawChart.drawXYLineChart(year));
					costChart = drawChart.XYLineChart(year);
				}
			});
			JButton bSave = new JButton("Zapisz");
			bSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser fc = new JFileChooser();
					if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
						File file = fc.getSelectedFile();
						try {
							ChartUtilities.saveChartAsPNG(file, costChart, 700,
									450);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			panel_button.add(lYear);
			panel_button.add(cbYear);
			panel_button.add(bSave);

			JPanel panel_1 = new JPanel();
			JPanel panel_button1 = new JPanel();
			final JPanel panel_chart1 = new JPanel();
			panel_1.add(panel_button1, BorderLayout.NORTH);
			panel_1.add(panel_chart1, BorderLayout.SOUTH);
			tabbedPane.addTab("Sprzedane towary", null, panel_1, null);
			// panel_1.add(drawChart.drawPieChart(2014));
			soldChart = drawChart.PieChart(2014);
			panel_chart1.add(drawChart.drawPieChart(2014));
			JLabel lYear1 = new JLabel("Wybierz rok");
			final JComboBox cbYear1 = new JComboBox();
			cbYear1.addItem("2010");
			cbYear1.addItem("2011");
			cbYear1.addItem("2012");
			cbYear1.addItem("2013");
			cbYear1.addItem("2014");
			cbYear1.setSelectedIndex(4);
			cbYear1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int year = Integer.parseInt(cbYear1.getSelectedItem()
							.toString());
					panel_chart1.removeAll();
					panel_chart1.revalidate();
					panel_chart1.repaint();
					panel_chart1.add(drawChart.drawPieChart(year));
					soldChart = drawChart.PieChart(year);
				}
			});
			JButton bSave1 = new JButton("Zapisz");
			bSave1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser fc = new JFileChooser();
					if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
						File plik = fc.getSelectedFile();
						try {
							ChartUtilities.saveChartAsPNG(plik, soldChart, 700,
									450);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			panel_button1.add(lYear1);
			panel_button1.add(cbYear1);
			panel_button1.add(bSave1);

			JPanel panel_2 = new JPanel();
			JPanel panel_button2 = new JPanel();
			final JPanel panel_chart2 = new JPanel();
			panel_2.add(panel_button2, BorderLayout.NORTH);
			panel_2.add(panel_chart2, BorderLayout.SOUTH);
			tabbedPane.addTab("Wykres pierścień", null, panel_2, null);
			ringChart = drawChart.RingChart(2013);
			panel_chart2.add(drawChart.drawRingChart(2013));
			JLabel lYear2 = new JLabel("Wybierz rok");
			final JComboBox cbYear2 = new JComboBox();
			cbYear2.addItem("2010");
			cbYear2.addItem("2011");
			cbYear2.addItem("2012");
			cbYear2.addItem("2013");
			cbYear2.addItem("2014");
			cbYear2.setSelectedIndex(3);
			cbYear2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int year = Integer.parseInt(cbYear2.getSelectedItem()
							.toString());
					panel_chart2.removeAll();
					panel_chart2.revalidate();
					panel_chart2.repaint();
					panel_chart2.add(drawChart.drawRingChart(year));
					ringChart = drawChart.RingChart(year);
				}
			});
			JButton bSave2 = new JButton("Zapisz");
			bSave2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser fc = new JFileChooser();
					if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
						File plik = fc.getSelectedFile();
						try {
							ChartUtilities.saveChartAsPNG(plik, ringChart, 700,
									450);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			panel_button2.add(lYear2);
			panel_button2.add(cbYear2);
			panel_button2.add(bSave2);

			JPanel panel_3 = new JPanel();
			final JPanel panel_chart3 = new JPanel();
			JPanel panel_button3 = new JPanel();
			panel_3.add(panel_button3, BorderLayout.NORTH);
			panel_3.add(panel_chart3, BorderLayout.SOUTH);
			tabbedPane.addTab("Historia kosztów", null, panel_3, null);
			timeChart = drawChart.TimeSeriesChart();
			panel_chart3.add(drawChart.drawTimeSeriesChart());
			JButton bSave3 = new JButton("Zapisz");
			bSave3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser fc = new JFileChooser();
					if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
						File plik = fc.getSelectedFile();
						try {
							ChartUtilities.saveChartAsPNG(plik, timeChart, 700,
									450);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			panel_button3.add(bSave3);

			JPanel panel_4 = new JPanel();
			final JPanel panel_chart4 = new JPanel();
			JPanel panel_button4 = new JPanel();
			panel_4.add(panel_button4, BorderLayout.NORTH);
			panel_4.add(panel_chart4, BorderLayout.SOUTH);
			tabbedPane.addTab("Całkowity czas pracy", null, panel_4, null);
			barChart = drawChart.BarChart();
			panel_chart4.add(drawChart.drawBarChart());
			JButton bSave4 = new JButton("Zapisz");
			bSave4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser fc = new JFileChooser();
					if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
						File plik = fc.getSelectedFile();
						try {
							ChartUtilities.saveChartAsPNG(plik, barChart, 700,
									450);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			panel_button4.add(bSave4);
		} else {
			setLayout(new BorderLayout(0, 0));
			JPanel panel = new JPanel();
			add(panel);
			JLabel lError = new JLabel(
					"Nie posiadasz wystarczających uprawnień do wglądu w statystyki!");
			panel.add(lError);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}