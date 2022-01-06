package vn.com.stanford.je0821.springmvcbasic.model;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import vn.com.stanford.je0821.springmvcbasic.entity.Sach;

import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service(value = "sachDao")
public class SachImpl implements SachDao {

    /**
     * Hàm lấy danh sách sách
     * @return
     */
    public List<Sach> layDanhSach()
    {
        // Khai báo 1 danh sách
        List<Sach> lstSach = new ArrayList<Sach>();

        //Kết nối đến db qua hibernate
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        //Khởi tạo 1 transaction
        Transaction tx = session.beginTransaction();

        TypedQuery<Sach> query = session.createQuery("from Sach", Sach.class);

        //Lấy danh sách
        lstSach = query.getResultList();

        tx.commit();

        return lstSach;
    }

    /**
     * Hàm tìm kiếm thông tin sách theo từ khóa, mã chủ đề
     * @param tuKhoa, Từ khóa cần tìm kiếm
     * @param maChuDe, Chủ đề sách
     * @return Danh sách sách thỏa mãn điều kiện
     */
    public List<Sach> timKiemSach(String tuKhoa, String maChuDe)
    {
        //Khai báo danh sách
        List<Sach> lstSach = new ArrayList<>();

        //Khai báo kết nối
        Connection conn = null;
        Statement comm = null;
        try {

            conn = DataProvider.ketNoi();

            //Khai báo công việc
            String strSQL = "Select MaSach, TenSach, MoTa, TacGia, GiaSach, AnhSach from Sach where 1=1";

            if(!tuKhoa.isEmpty())
            {
                strSQL += " AND (MaSach ='" + tuKhoa + "' OR TenSach like '%" + tuKhoa + "%' OR TacGia like '%" + tuKhoa + "%' OR MoTa like '%" + tuKhoa + "%')";
            }

            if(!maChuDe.isEmpty())
            {
                strSQL += " AND MaChuDe = '" + maChuDe + "'";
            }

            comm = conn.createStatement();

            //Thực hiện công việc và trả về kết quả
            ResultSet rs = comm.executeQuery(strSQL);

            //Xử lý đọc từng dòng để đưa về danh sách
            Sach objSach = null;

            while (rs.next())
            {
                //Khai báo 1 đối tượng
                objSach = new Sach();

                //Gán giá trị cho các thuộc tính
                objSach.setMaSach(rs.getString("MaSach"));
                objSach.setTenSach(rs.getString("TenSach"));
                objSach.setTacGia(rs.getString("TacGia"));
                objSach.setMoTa(rs.getString("MoTa"));
                objSach.setGiaSach(rs.getDouble("GiaSach"));
                objSach.setAnhSach(rs.getString("AnhSach"));

                //Thêm vào danh sách
                lstSach.add(objSach);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            if(comm != null)
            {
                try {
                    comm.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(conn != null)
            {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return  lstSach;
    }

    /**
     * Hàm lấy chi tiết thông tin sách theo mã
     * @param maSach, Mã sách
     * @return Đối tượng chứa các thông tin của sách
     */
    public Sach layChiTiet(String maSach)
    {
        //Khai báo 1 đối tượng sách
        Sach objSach = null;

        //Khai báo kết nối
        Connection conn = null;
        Statement comm = null;
        try {

            conn = DataProvider.ketNoi();

            //Khai báo công việc
            String strSQL = "Select MaSach, TenSach, MoTa, TacGia, GiaSach, AnhSach, MaChuDe from Sach where maSach='" + maSach + "'";

            comm = conn.createStatement();

            //Thực hiện công việc và trả về kết quả
            ResultSet rs = comm.executeQuery(strSQL);

            //Xử lý đọc từng dòng để đưa về danh sách

            if (rs.next())
            {
                //Khai báo 1 đối tượng
                objSach = new Sach();

                //Gán giá trị cho các thuộc tính
                objSach.setMaSach(rs.getString("MaSach"));
                objSach.setTenSach(rs.getString("TenSach"));
                objSach.setTacGia(rs.getString("TacGia"));
                objSach.setMoTa(rs.getString("MoTa"));
                objSach.setGiaSach(rs.getDouble("GiaSach"));
                objSach.setAnhSach(rs.getString("AnhSach"));
                objSach.setMaChuDe(rs.getString("MaChuDe"));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            if(comm != null)
            {
                try {
                    comm.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(conn != null)
            {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return  objSach;
    }

    /**
     * Hàm thêm mới thông tin sách
     * @param objSach
     * @return
     */
    public boolean themMoi(Sach objSach)
    {
        Connection conn = null;

        PreparedStatement comm = null;

        try {
            conn = DataProvider.ketNoi();

            //Khai báo công việc
            String strInsert = "Insert into Sach(MaSach, TenSach, MoTa, GiaSach, TacGia, MaChuDe, AnhSach) values(?,?,?,?,?,?,?)";

            comm = conn.prepareStatement(strInsert);

            //Truyền giá trị cho các tham số
            comm.setString(1, objSach.getMaSach());
            comm.setString(2, objSach.getTenSach());
            comm.setString(3, objSach.getMoTa());
            comm.setDouble(4, objSach.getGiaSach());
            comm.setString(5, objSach.getTacGia());
            comm.setString(6, objSach.getMaChuDe());
            comm.setString(7, objSach.getAnhSach());
            return comm.executeUpdate() > 0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            if(comm != null)
            {
                try {
                    comm.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(conn != null)
            {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return false;
    }

    /**
     * Hàm cập nhật thông tin sách
     * @param objSach
     * @return
     */
    public boolean capNhat(Sach objSach)
    {
        Connection conn = null;

        PreparedStatement comm = null;

        try {
            conn = DataProvider.ketNoi();

            //Khai báo công việc
            String strUpdate = "Update Sach set TenSach=?, MoTa = ?, GiaSach = ?, TacGia = ?, MaChuDe = ?, AnhSach = ? where MaSach = ?";

            comm = conn.prepareStatement(strUpdate);

            //Truyền giá trị cho các tham số
            comm.setString(1, objSach.getTenSach());
            comm.setString(2, objSach.getMoTa());
            comm.setDouble(3, objSach.getGiaSach());
            comm.setString(4, objSach.getTacGia());
            comm.setString(5, objSach.getMaChuDe());
            comm.setString(6, objSach.getAnhSach());
            comm.setString(7, objSach.getMaSach());
            return comm.executeUpdate() > 0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            if(comm != null)
            {
                try {
                    comm.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(conn != null)
            {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return false;
    }

    /**
     * Hàm xóa thông tin sách trong db
     * @param maSach
     * @return True nếu thành công, False nếu thất bại
     */
    public boolean xoa(String maSach)
    {
        Connection conn = null;

        PreparedStatement comm = null;

        try {
            conn = DataProvider.ketNoi();

            //Khai báo công việc
            String strDelete = "Delete from Sach where MaSach = ?";

            comm = conn.prepareStatement(strDelete);

            //Truyền giá trị cho các tham số
            comm.setString(1, maSach);

            return comm.executeUpdate() > 0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            if(comm != null)
            {
                try {
                    comm.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(conn != null)
            {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return false;
    }
}
