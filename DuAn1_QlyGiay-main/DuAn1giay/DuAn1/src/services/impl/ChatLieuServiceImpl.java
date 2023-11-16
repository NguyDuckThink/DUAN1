package services.impl;

import java.util.List;
import models.ChatLieu;
import repositories.ChatLieuRepository;
import repositories.ChatLieuRepository;
import services.ChatLieuService;

public class ChatLieuServiceImpl implements ChatLieuService {

    ChatLieuRepository chatLieuRepository = new ChatLieuRepository();

    @Override
    public List<ChatLieu> getList() {
        return chatLieuRepository.getList();
    }

    @Override
    public String add(ChatLieu cl) {
        ChatLieu NewCL = chatLieuRepository.getChatLieuByTen(cl.getTen());
        if (cl.getTen().isEmpty()) {
            return "Tên thuộc tính không được để trống!";
        }
        if (NewCL != null) {
            return "Tên chất liệu đã tồn tại!";
        }
        if (chatLieuRepository.add(cl)) {
            return "Thêm thành công!";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String delete(String tenCL) {
        if (chatLieuRepository.delete(tenCL)) {
            return "Xóa thành công!";
        } else {
            return "Xóa thất bại";
        }
    }

    @Override
    public String update(String id, ChatLieu tenCL) {
        ChatLieu NewCL = chatLieuRepository.getChatLieuByTen(tenCL.getTen());
        if (tenCL.getTen().isEmpty()) {
            return "Tên thuộc tính không được để trống!";
        }
        if (NewCL != null) {
            return "Tên chất liệu đã tồn tại!";
        }
        if (chatLieuRepository.update(id, tenCL)) {
            return "Cập nhật thành công!";
        } else {
            return "Cập nhật thất bại";
        }
    }
}
