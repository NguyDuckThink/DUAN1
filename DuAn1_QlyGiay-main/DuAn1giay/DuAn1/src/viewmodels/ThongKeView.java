
package viewmodels;


public class ThongKeView {
    private String thang;
    private double doanhThu;

    public ThongKeView() {
    }

    public ThongKeView(String thang, double doanhThu) {
        this.thang = thang;
        this.doanhThu = doanhThu;
    }

    public String getThang() {
        return thang;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    public double getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(double doanhThu) {
        this.doanhThu = doanhThu;
    }
    
}
