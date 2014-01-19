package pl.lodz.pl.ftims.supermarket.frontend.standalone.statistics.core;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import backend.api.Statistics;
import backend.core.model.FinanceRegister;
import backend.core.model.Monitoring;

public class DrawChart {

	private Statistics statistics = new Statistics();

	XYSeries createFinanceXYSeries() {
		XYSeries xy = new XYSeries("Kwota");
		int[] months = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		for (int i = 0; i < statistics.getFinanceRegisterRecords().size(); i++) {
			switch (statistics.getFinanceRegisterRecords().get(i).getData()
					.getMonth()) {
			case 0:
				months[0] += statistics.getFinanceRegisterRecords().get(i)
						.getPrice();
				break;
			case 1:
				months[1] += statistics.getFinanceRegisterRecords().get(i)
						.getPrice();
				break;
			case 2:
				months[2] += statistics.getFinanceRegisterRecords().get(i)
						.getPrice();
				break;
			case 3:
				months[3] += statistics.getFinanceRegisterRecords().get(i)
						.getPrice();
				break;
			case 4:
				months[4] += statistics.getFinanceRegisterRecords().get(i)
						.getPrice();
				break;
			case 5:
				months[5] += statistics.getFinanceRegisterRecords().get(i)
						.getPrice();
				break;
			case 6:
				months[6] += statistics.getFinanceRegisterRecords().get(i)
						.getPrice();
				break;
			case 7:
				months[7] += statistics.getFinanceRegisterRecords().get(i)
						.getPrice();
				break;
			case 8:
				months[8] += statistics.getFinanceRegisterRecords().get(i)
						.getPrice();
				break;
			case 9:
				months[9] += statistics.getFinanceRegisterRecords().get(i)
						.getPrice();
				break;
			case 10:
				months[10] += statistics.getFinanceRegisterRecords().get(i)
						.getPrice();
				break;
			case 11:
				months[11] += statistics.getFinanceRegisterRecords().get(i)
						.getPrice();
				break;
			}
		}

		for (int i = 0; i < 12; i++) {
			xy.add((int) i + 1, (float) months[i]);
		}
		return xy;
	}

	DefaultPieDataset createProductPieDataset() {

		DefaultPieDataset pieDataset = new DefaultPieDataset();
		int[] months = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		for (int i = 0; i < statistics.getRecords().size(); i++) {
			System.out.println("miesiąc: "
					+ statistics.getRecords().get(i).getDate().getMonth());
			switch (statistics.getRecords().get(i).getDate().getMonth()) {
			case 0:
				months[0]++;
				break;
			case 1:
				months[1]++;
				break;
			case 2:
				months[2]++;
				break;
			case 3:
				months[3]++;
				break;
			case 4:
				months[4]++;
				break;
			case 5:
				months[5]++;
				break;
			case 6:
				months[6]++;
				break;
			case 7:
				months[7]++;
				break;
			case 8:
				months[8]++;
				break;
			case 9:
				months[9]++;
				break;
			case 10:
				months[10]++;
				break;
			case 11:
				months[11]++;
				break;
			}
		}

		pieDataset.setValue("Styczeń", months[0]);
		pieDataset.setValue("Luty", months[1]);
		pieDataset.setValue("Marzec", months[2]);
		pieDataset.setValue("Kwiecień", months[3]);
		pieDataset.setValue("Maj", months[4]);
		pieDataset.setValue("Czerwiec", months[5]);
		pieDataset.setValue("Lipiec", months[6]);
		pieDataset.setValue("Sierpień", months[7]);
		pieDataset.setValue("Wrześień", months[8]);
		pieDataset.setValue("Październik", months[9]);
		pieDataset.setValue("Listopad", months[10]);
		pieDataset.setValue("Grudzień", months[11]);

		return pieDataset;
	}

	public ChartPanel drawXYLineChart() {
		final JFreeChart chart = XYLineChart();
		final ChartPanel chartPanel = new ChartPanel(chart);

		return chartPanel;
	}

	public ChartPanel drawPieChart() {
		final JFreeChart chart = PieChart();
		final ChartPanel chartPanel = new ChartPanel(chart);

		return chartPanel;
	}

	public ChartPanel drawRingChart() {

		DefaultPieDataset dane = new DefaultPieDataset();
		dane.setValue("produkt A", 20);
		dane.setValue("produkt B", 25);
		dane.setValue("produkt C", 10);
		dane.setValue("produkt D", 45);

		final JFreeChart chart = ChartFactory.createRingChart("Wykres kołowy ",
				dane, true, true, false);

		final ChartPanel chartPanel = new ChartPanel(chart);

		return chartPanel;
	}

	public ChartPanel drawTimeSeriesChart() {

		TimeSeries pop2 = new TimeSeries("Population2", Day.class);
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		pop2.add(new Day(2, 1, 2008), 200);
		pop2.add(new Day(2, 2, 2008), 250);
		pop2.add(new Day(2, 3, 2008), 250);
		pop2.add(new Day(2, 4, 2008), 275);
		pop2.add(new Day(2, 5, 2008), 225);
		dataset.addSeries(pop2);
		// Wykres typu TimeSeries
		JFreeChart chart = ChartFactory.createTimeSeriesChart("Wykres", "Date",
				"Y - lable", dataset, true, true, false);
		XYPlot plot = chart.getXYPlot();
		DateAxis axis = (DateAxis) plot.getDomainAxis();
		axis.setDateFormatOverride(new SimpleDateFormat("dd-MM-yyyy"));

		final ChartPanel chartPanel = new ChartPanel(chart);

		return chartPanel;
	}

	public ChartPanel drawBarChart() {

		// Dane
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(6, "Profit", "Jane");
		dataset.setValue(7, "Profit", "Tom");
		dataset.setValue(8, "Profit", "Jill");
		dataset.setValue(5, "Profit", "John");
		dataset.setValue(12, "Profit", "Fred");
		// Tworzy wykres typu Bar - słupkowy
		JFreeChart chart = ChartFactory.createBarChart("Wykres typu Bar",
				"X -lable", "Y -lable", dataset, PlotOrientation.VERTICAL,
				false, true, false);

		final ChartPanel chartPanel = new ChartPanel(chart);

		return chartPanel;
	}

	public JFreeChart XYLineChart() {
		final XYSeriesCollection data = new XYSeriesCollection(
				createFinanceXYSeries());
		final JFreeChart chart = ChartFactory.createXYLineChart("Koszta",
				"Miesiąc", "Kwota", data, PlotOrientation.VERTICAL, true, true,
				true);

		return chart;
	}

	public JFreeChart PieChart() {
		int year = 2013;
		final JFreeChart chart = ChartFactory.createPieChart(
				"Ilość sprzedanych produktów w roku: " + year,
				createProductPieDataset(), true, true, true);
		PiePlot plot = (PiePlot) chart.getPlot();
		PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
				"{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat(
						"0%"));
		plot.setLabelGenerator(gen);
		return chart;
	}
}
