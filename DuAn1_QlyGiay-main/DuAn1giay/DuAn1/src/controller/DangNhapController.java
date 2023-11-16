package controller;

import models.NhanVien;
import services.TaiKhoanService;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import services.impl.TaiKhoanServiceImpl;
import utilities.Auth;
import views.DangNhapJFrame;
import views.TrangChuJFrame;

public class DangNhapController {
    private JFrame jfrDangNhap;
    private JButton btnSubmit;
    private JTextField jtfTenDangNhap;
    private JTextField jtfMatKhau;
    private JLabel jlbMsg;

    private TaiKhoanService taiKhoanService = new TaiKhoanServiceImpl();

    public DangNhapController(JFrame jfrDangNhap,JButton btnSubmit,
            JTextField jtfTenDangNhap, JTextField jtfMatKhau, JLabel jlbMsg) {
        this.jfrDangNhap = jfrDangNhap;
        this.btnSubmit = btnSubmit;
        this.jtfTenDangNhap = jtfTenDangNhap;
        this.jtfMatKhau = jtfMatKhau;
        this.jlbMsg = jlbMsg;

        taiKhoanService = new TaiKhoanServiceImpl();
    }
    public void setEvent() {
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if (jtfTenDangNhap.getText().length() == 0
                            || jtfMatKhau.getText().length() == 0) {
                        jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc!");
                    } else {
                        NhanVien nv = taiKhoanService.login(jtfTenDangNhap.getText(), jtfMatKhau.getText());
                        if (nv == null) {
                            jlbMsg.setText("Tên đăng nhập và mật khẩu không đúng!");
                        } else {
                            Auth.user = nv;
                            jfrDangNhap.dispose();
                            TrangChuJFrame frame = new TrangChuJFrame();
                            frame.setVisible(true);
                        }
                    }
                } catch (Exception ex) {
                    jlbMsg.setText(ex.toString());
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
//                btnSubmit.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
//                btnSubmit.setBackground(new Color(100, 221, 23));
            }
        });

    }

}
