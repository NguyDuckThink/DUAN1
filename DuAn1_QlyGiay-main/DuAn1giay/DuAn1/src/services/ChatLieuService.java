package services;

import java.util.List;
import models.ChatLieu;

public interface ChatLieuService {

    List<ChatLieu> getList();

    String add(ChatLieu cl);
    
    
    String update(String maCL, ChatLieu tenCL);
    
    String delete(String tenCL);
}
