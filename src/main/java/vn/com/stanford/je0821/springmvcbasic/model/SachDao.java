package vn.com.stanford.je0821.springmvcbasic.model;

import vn.com.stanford.je0821.springmvcbasic.entity.Sach;

import java.util.List;

public interface SachDao extends HanhDong<Sach, String> {

    public List<Sach> timKiemSach(String tuKhoa, String maChuDe);
}