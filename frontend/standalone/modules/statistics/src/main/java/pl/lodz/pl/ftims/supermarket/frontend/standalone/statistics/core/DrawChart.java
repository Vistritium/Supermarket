package pl.lodz.pl.ftims.supermarket.frontend.standalone.statistics.core;

import java.util.Iterator;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import backend.api.Statistics;
import backend.core.model.Monitoring;
import backend.core.model.MonitoringWorkers;
import backend.core.model.FinanceRegister;

public class DrawChart {
	private
		Statistics statistics = new Statistics();
		
		XYSeries createFinanceXYSeries() {
			XYSeries xy = new XYSeries("price");
			/*
			for(FinanceRegister financeRegister  : statistics.getFinanceRegisterRecord())
				xy.add(financeRegister.getData().getDay() ,financeRegister.getPrice());
				*/
			
			//example data
			for(float i = 0; i<20; i=i+(float)3.24)
				xy.add((float)i, (int)i*i);
			return xy;
		}

	public
	ChartPanel  drawFinanceChart() {
			final XYSeriesCollection data = new XYSeriesCollection(createFinanceXYSeries());
			final JFreeChart chart = ChartFactory.createXYLineChart(
		            "Finance",
		            "Date", 
		            "Price", 
		            data,
		            PlotOrientation.VERTICAL,
		            true,
		            true,
		            true
			);
			
			final ChartPanel chartPanel = new ChartPanel(chart);
			
			return chartPanel;
		}
	
	public ChartPanel  drawFinanceChart2() {
		
		DefaultPieDataset dane = new DefaultPieDataset();
		dane.setValue("produkt A", 20); 
		dane.setValue("produkt B", 25);
		dane.setValue("produkt C", 10);
		dane.setValue("produkt D", 45);
		
		final JFreeChart chart = ChartFactory.createPieChart
				("Wykres kołowy ", 
				dane, 
				true, 
				true, 
				false 
			);
		 
			
			final ChartPanel chartPanel = new ChartPanel(chart);
			
			return chartPanel;
		}
}
