package vn.com.stanford.je0821.springmvcbasic.entity;

import javax.persistence.*;

@Entity
@Table(name="NguoiDung")
public class NguoiDung {

    private int userId;
    private String username;

    private String password;

    private String hoTen;
    private String dienThoai;
    private String email;
    private String diaChi;
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="userId", unique = true, nullable = false)
    public int getUserId() {
        return userId;
    }
    @Column(name="tenDangNhap", nullable = true, length = 50)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Column(name="matKhau", nullable = true, length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    @Column(name="hoTen", nullable = false, length = 30)
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    @Column(name="dienThoai", nullable = true, length = 20)
    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    @Column(name="email", nullable = true, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="diaChi", nullable = true, length = 150)
    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
