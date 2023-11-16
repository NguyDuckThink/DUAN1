
package application;

import java.util.List;
import javax.swing.SizeSequence;
import models.MauSac;
import models.Size;
import services.MauSacService;
import services.SizeService;
import services.impl.MauSacServiceImpl;
import views.DangNhapJFrame;
import views.SanPhamJPanel;
import views.TrangChuJFrame;


public class Main {
    public static void main(String[] args) {
        DangNhapJFrame dangNhapJFrame = new DangNhapJFrame();
        dangNhapJFrame.setResizable(false);
        dangNhapJFrame.setLocationRelativeTo(null);
        dangNhapJFrame.setVisible(true);
        
//            TrangChuJFrame trangchu = new TrangChuJFrame();
//            trangchu.setVisible(true);
//            MauSacService mauSacService = new MauSacServiceImpl();
//            List<MauSac>  listMs = mauSacService.getList();
//            for (MauSac ms : listMs) {
//            System.out.println(ms.getId()+"  "+ms.getTen());
////          
       
            
            
    }
}
