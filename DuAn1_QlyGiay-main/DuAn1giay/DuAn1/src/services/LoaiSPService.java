package services;

import java.util.List;
import models.LoaiSP;

public interface LoaiSPService {

    List<LoaiSP> getList();

    String add(LoaiSP lsp);

    String update(String id, LoaiSP tenLSP);

    String delete(String id);
}
