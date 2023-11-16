package services.impl;

import java.util.List;
import repositories.ThongKeRepository;
import repositories.ThongKeRepository;
import services.ThongKeService;
import viewmodels.ThongKeView;

public class ThongKeServiceImpl implements ThongKeService {

    private ThongKeRepository thongKeRepository = new ThongKeRepository();

    @Override
    public List<ThongKeView> getList(int nam) {
        return thongKeRepository.getList(nam);
    }

}
