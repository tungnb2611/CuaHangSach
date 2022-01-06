package vn.com.stanford.je0821.springmvcbasic.model;

import org.springframework.stereotype.Service;
import vn.com.stanford.je0821.springmvcbasic.entity.NguoiDung;

public interface NguoiDungDao extends HanhDong<NguoiDung, Integer> {
    public NguoiDung kiemTraDangNhap(String tenDangNhap);
}
