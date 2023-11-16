
package controller;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import services.ThongKeService;
import services.impl.ThongKeServiceImpl;
import viewmodels.ThongKeView;

public class ThongKeController {


    private ThongKeService thongKeService = null;

    public ThongKeController() {
        this.thongKeService = new ThongKeServiceImpl();
    }

    public void setDataToChart1(JPanel jpnItem,int nam ) {
        List<ThongKeView> listItem = thongKeService.getList(nam);

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (listItem != null) {
            for (ThongKeView item : listItem) {
                dataset.addValue(item.getDoanhThu(), "Doanh Thu", item.getThang());
            }
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Doanh thu chi tiết".toUpperCase(),
                "Tháng", "Doanh thu(VND)",
                dataset, PlotOrientation.VERTICAL, false, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 300));

        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }

}
