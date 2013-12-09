package pl.lodz.pl.ftims.supermarket.frontend.standalone.statistics.core;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import javax.swing.JButton;




public class MainStatisticsPanel extends JPanel {
	public MainStatisticsPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel centralPanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		add(centralPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.PAGE_END);
		centralPanel.setLayout(new BorderLayout(0, 0));
		
		DrawChart drawChart = new DrawChart();
		centralPanel.add(drawChart.drawFinanceChart());
	}
}
