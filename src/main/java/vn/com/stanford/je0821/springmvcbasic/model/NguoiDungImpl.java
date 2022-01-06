package vn.com.stanford.je0821.springmvcbasic.model;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import vn.com.stanford.je0821.springmvcbasic.entity.NguoiDung;

import javax.persistence.TypedQuery;
import java.util.List;

@Service(value = "nguoiDungDao")
public class NguoiDungImpl implements NguoiDungDao {
    public List<NguoiDung> layDanhSach() {
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();

        Transaction tx = session.beginTransaction();

        TypedQuery<NguoiDung> query = session.createQuery(" from NguoiDung", NguoiDung.class);

        List<NguoiDung> lst = query.getResultList();

        tx.commit();

        return lst;
    }

    public NguoiDung layChiTiet(Integer ma) {
        // Khai báo 1 đối tượng người dùng
        NguoiDung objNguoiDung = null;
        //Kết nối đến db
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        //Lấy đối tượng sách theo mã
        objNguoiDung = (NguoiDung)session.get(NguoiDung.class, ma);
        tx.commit();

        return objNguoiDung;
    }

    public boolean themMoi(NguoiDung objNguoiDung) {
        // Kết nối đến db
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        // Thực hiện thêm mới thông tin
        session.save(objNguoiDung);
        tx.commit();
        return true;
    }

    public boolean capNhat(NguoiDung objNguoiDung) {
        // Kết nối đến db
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        // Thực hiện thêm mới thông tin
        session.update(objNguoiDung);
        tx.commit();
        return true;
    }

    public boolean xoa(Integer ma) {
        // Kết nối đến db
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        // Lấy đối tượng sách cần xoá
        NguoiDung objNguoiDung = (NguoiDung)session.get(NguoiDung.class, ma);

        if(objNguoiDung != null)
        {
            //Thực hiện xóa
            session.delete(objNguoiDung);
            tx.commit();
            return true;
        }
        return false;
    }


    /**
     * Hàm tìm kiếm theo thông tin người dùng
     */
    public List<NguoiDung> timKiemNguoiDung(String tuKhoa) {
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();

        Transaction tx = session.beginTransaction();

        TypedQuery<NguoiDung> query = session.
                createQuery(" from NguoiDung where (tenDangNhap like :ten or hoTen like :ten)",
                        NguoiDung.class);

        query.setParameter("ten", "%" + tuKhoa + "%");

        List<NguoiDung> lst = query.getResultList();

        tx.commit();

        return lst;
    }

    /**
     * Hàm lấy thông tin người dùng theo tên đăng nhập
     * @param tenDangNhap, tên đăng nhập cần lấy thông tin
     * @return Đối tượng người dùng
     */
    public NguoiDung kiemTraDangNhap(String tenDangNhap) {
        // Kết nối đến db qua hibernate
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        // Khởi 1 phiên giao dịch trong hibernate
        Transaction tx = session.beginTransaction();

        TypedQuery<NguoiDung> query = session.createQuery(" from NguoiDung where tenDangNhap = :ten", NguoiDung.class);

        //Thiết lập tham số
        query.setParameter("ten", tenDangNhap);

        // Lấy danh sách
        List<NguoiDung> lst = query.getResultList();

        tx.commit();

        if(lst.size() > 0)
        {
            return lst.get(0);
        }
        // Trả về kết quả
        return null;
    }
}
