package vn.com.stanford.je0821.springmvcbasic.entity;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class Sach {

    @NotEmpty(message = "Bạn cần phải nhập mã sách")
    @Length(min = 1, max = 10, message = "Bạn cần phải nhập mã sách từ 1-10 kí tự")
    private String maSach;
    @NotEmpty(message = "Bạn cần phải nhập tên sách")
    private String tenSach;
    private String moTa;
    @NotEmpty(message = "Bạn cần phải nhập tên tác giả")
    private String tacGia;
    private String anhSach;
    private double giaSach;

    @NotBlank(message = "Bạn cần phải chọn chủ đề")
    private String maChuDe;

    private Date ngayTao;
    private Date ngayDuyet;
    private boolean daDuyet;

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayDuyet() {
        return ngayDuyet;
    }

    public void setNgayDuyet(Date ngayDuyet) {
        this.ngayDuyet = ngayDuyet;
    }

    public boolean isDaDuyet() {
        return daDuyet;
    }

    public void setDaDuyet(boolean daDuyet) {
        this.daDuyet = daDuyet;
    }

    
    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getAnhSach() {
        return anhSach;
    }

    public void setAnhSach(String anhSach) {
        this.anhSach = anhSach;
    }

    public double getGiaSach() {
        return giaSach;
    }

    public void setGiaSach(double giaSach) {
        this.giaSach = giaSach;
    }

    public String getMaChuDe() {
        return maChuDe;
    }

    public void setMaChuDe(String maChuDe) {
        this.maChuDe = maChuDe;
    }

}
