
package viewmodels;


public class KhachHangView {
    private String idKhachHang;
    private String tenKhachHang;
    private String soDienThoai;
    private String diaChi;

    public KhachHangView() {
    }

    public KhachHangView(String idKhachHang, String tenKhachHang, String soDienThoai, String diaChi) {
        this.idKhachHang = idKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
    }

    public String getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(String maKhachHang) {
        this.idKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
   
}
