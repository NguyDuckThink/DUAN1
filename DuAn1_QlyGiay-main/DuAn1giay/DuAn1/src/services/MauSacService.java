package services;

import java.util.List;
import models.MauSac;

public interface MauSacService {

    List<MauSac> getList();

    String add(MauSac ms);

    String update(String id, MauSac ten);

    String delete(String id);

}
