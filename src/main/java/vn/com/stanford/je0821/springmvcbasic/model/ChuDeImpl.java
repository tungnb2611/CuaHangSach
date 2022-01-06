package vn.com.stanford.je0821.springmvcbasic.model;

import org.springframework.stereotype.Service;
import vn.com.stanford.je0821.springmvcbasic.entity.ChuDe;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service(value="chuDeDao")
public class ChuDeImpl implements ChuDeDao {

    /**
     * Hàm lấy danh sách chủ đề
     * @return
     */
    public List<ChuDe> layDanhSach()
    {
        //Khai báo danh sách
        List<ChuDe> lstChuDe = new ArrayList<>();

        //Khai báo kết nối
        Connection conn = null;
        Statement comm = null;
        try {

            conn = DataProvider.ketNoi();

            //Khai báo công việc
            String strSQL = "Select MaChuDe, TenChuDe from ChuDe";
            comm = conn.createStatement();

            //Thực hiện công việc và trả về kết quả
            ResultSet rs = comm.executeQuery(strSQL);

            //Xử lý đọc từng dòng để đưa về danh sách
            ChuDe objChuDe = null;

            while (rs.next())
            {
                //Khai báo 1 đối tượng
                objChuDe = new ChuDe();

                //Gán giá trị cho các thuộc tính
                objChuDe.setMaChuDe(rs.getString("MaChuDe"));
                objChuDe.setTenChuDe(rs.getString("TenChuDe"));

                //Thêm vào danh sách
                lstChuDe.add(objChuDe);
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

        return  lstChuDe;
    }

    /**
     * Hàm lấy chi tiết thông tin sách theo mã
     * @param maChuDe, Mã chủ đề
     * @return Đối tượng chứa các thông tin của chủ đề
     */
    public ChuDe layChiTiet(String maChuDe)
    {
        //Khai báo 1 đối tượng chủ đề
        ChuDe objChuDe = null;

        //Khai báo kết nối
        Connection conn = null;
        Statement comm = null;
        try {

            conn = DataProvider.ketNoi();

            //Khai báo công việc
            String strSQL = "Select MaChuDe, TenChuDe from ChuDe where MaChuDe='" + maChuDe + "'";

            comm = conn.createStatement();

            //Thực hiện công việc và trả về kết quả
            ResultSet rs = comm.executeQuery(strSQL);

            //Xử lý đọc từng dòng để đưa về danh sách

            if (rs.next())
            {
                //Khai báo 1 đối tượng
                objChuDe = new ChuDe();

                //Gán giá trị cho các thuộc tính
                objChuDe.setMaChuDe(rs.getString("MaChuDe"));
                objChuDe.setTenChuDe(rs.getString("TenChuDe"));

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

        return  objChuDe;
    }

    @Override
    public boolean themMoi(ChuDe obj) {
        return false;
    }

    @Override
    public boolean capNhat(ChuDe obj) {
        return false;
    }

    @Override
    public boolean xoa(String id) {
        return false;
    }
}
