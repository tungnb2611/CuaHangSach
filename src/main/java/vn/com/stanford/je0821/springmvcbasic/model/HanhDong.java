package vn.com.stanford.je0821.springmvcbasic.model;

import java.util.List;

public interface HanhDong<T, idT> {

    List<T> layDanhSach();

    T layChiTiet(idT id);

    boolean themMoi(T obj);

    boolean capNhat(T obj);

    boolean xoa(idT id);
}
