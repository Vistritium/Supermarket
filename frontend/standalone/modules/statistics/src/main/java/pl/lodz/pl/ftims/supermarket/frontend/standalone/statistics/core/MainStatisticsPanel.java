	

    package pl.lodz.pl.ftims.supermarket.frontend.standalone.statistics.core;
     
    import java.awt.BorderLayout;
    import javax.swing.JPanel;
    import javax.swing.JTabbedPane;
     
     
    public class MainStatisticsPanel extends JPanel{
            private static final long serialVersionUID = 1L;
     
            public MainStatisticsPanel() {
                    setLayout(new BorderLayout(0, 0));
     
                    DrawChart drawChart = new DrawChart();
     
                    JTabbedPane tabbedPane = new JTabbedPane();
                    add(tabbedPane);
                   
                    JPanel panel = new JPanel();
                    tabbedPane.addTab("Koszta", null, panel, null);
                    panel.add(drawChart.drawXYLineChart());
                   
                    JPanel panel_1 = new JPanel();
                    tabbedPane.addTab("Sprzedane towary", null, panel_1, null);
                    panel_1.add(drawChart.drawPieChart());
                   
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
    }

