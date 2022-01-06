package vn.com.stanford.je0821.springmvcbasic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.com.stanford.je0821.springmvcbasic.entity.ChuDe;
import vn.com.stanford.je0821.springmvcbasic.entity.Sach;
import vn.com.stanford.je0821.springmvcbasic.model.ChuDeDao;
import vn.com.stanford.je0821.springmvcbasic.model.SachDao;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SachController {

    @Autowired
    ChuDeDao chuDeDao;

    @Autowired
    SachDao sachDao;

    @RequestMapping(value = "/admin/qlsach", method = RequestMethod.GET)
    public String hienThiDanhSachSach(Model model)
    {
        //Lấy danh sách chủ đề
        List<ChuDe> lstChuDe1 = chuDeDao.layDanhSach();
        model.addAttribute("lstChuDe1", lstChuDe1);
        
           //Lấy danh sách sách trong hệ thống
        List<Sach> lstSach = sachDao.layDanhSach();

        model.addAttribute("lstSach", lstSach);

        return "QuanLyThongTinSach";
    }

    @RequestMapping(value = "/admin/timKiemSach", method = RequestMethod.POST)
    public String timKiemThongTinSach(@RequestParam(value = "tuKhoa", required = false) String tuKhoa,
                                      @RequestParam(value = "maChuDe", required = false) String maChuDe, Model model)
    {
        //Lấy danh sách chủ đề
        List<ChuDe> lstChuDe1 = chuDeDao.layDanhSach();
        model.addAttribute("lstChuDe1", lstChuDe1);

        model.addAttribute("maChuDe", maChuDe);
        model.addAttribute("tuKhoa", tuKhoa);
        System.out.println("Từ khóa: " + tuKhoa);
        System.out.println("Mã chủ đề: " + maChuDe);

        //Lấy danh sách sách trong hệ thống
        List<Sach> lstSach = sachDao.timKiemSach(tuKhoa, maChuDe);

        model.addAttribute("lstSach", lstSach);

        return "QuanLyThongTinSach";
    }

    @RequestMapping(value = "/admin/sach-them")
    public String hienThiThemSach(Model model)
    {
        model.addAttribute("sach", new Sach());
        return "themSach";
    }

    @RequestMapping(value = "/admin/themMoiSach", method = RequestMethod.POST)
    public String thucHienThemMoiSach(@ModelAttribute("sach") @Valid Sach objSach, BindingResult result, @RequestParam("fUpload")MultipartFile fUpload, HttpServletRequest request, Model model)
    {
        if(result.hasErrors())
        {
            model.addAttribute("thongBao", "Thực hiện cập nhật thông tin sách không thành công");
        }
        else {
            System.out.println("Mã sách: " + objSach.getMaSach());
            System.out.println("Tên sách: " + objSach.getTenSach());

            if (objSach != null) {
                String fileName = "";
                if (fUpload != null) {
                    fileName = fUpload.getOriginalFilename();

                    //Lấy đường dẫn từ web.xml
                    String path = request.getServletContext().getInitParameter("file-upload");

                    try {
                        //Tạo file và di chuyển vào thư mục
                        File file = new File(path, fileName);

                        //Ghi file
                        fUpload.transferTo(file);

                        //Gán tên ảnh để lưu vào db
                        objSach.setAnhSach(fileName);
                    } catch (IOException ex) {
                        System.err.println("Có lỗi khi upload file. Chi tiết: " + ex.getMessage());
                    }
                } //end fUpload

                Sach objSachOld = sachDao.layChiTiet(objSach.getMaSach());
                boolean isInsert = true;
                if (objSachOld != null) {
                    isInsert = false;
                    if (fileName.length() == 0) {
                        objSach.setAnhSach(objSachOld.getAnhSach());
                    }
                }
                boolean ketQua = false;
                if (isInsert) {
                    ketQua = sachDao.themMoi(objSach);
                } else {
                    ketQua = sachDao.capNhat(objSach);
                }

                if (ketQua) {
                    return "redirect:qlsach";
                }
            }
        }
        
        return "themSach";
    }
    @RequestMapping(value = "/admin/sach-sua/{ma}")
    public String hienThiChiTietSach(@PathVariable("ma")String ma, Model model)
    {
        //Lấy thông tin chi tiết sách
        Sach objSach = sachDao.layChiTiet(ma);
        //Đưa vào model để chuyển view phục vụ hiển thị
        model.addAttribute("sach", objSach);
        
        return "themSach";
    }

    @RequestMapping(value = "/admin/sach-xoa/{ma}")
    public String xoaThongTinSach(@PathVariable("ma")String ma, Model model)
    {
        if(ma!= null && !ma.isEmpty())
        {
            //Thực hiện xóa
           boolean ketQua = sachDao.xoa(ma);

           if(ketQua)
                return "redirect:/admin/qlsach";
        }

        return "QuanLyThongTinSach";
    }

    /**
     * Hàm lấy danh sách chủ đề để hiển thị lên giao diện
     * @return
     */
    @ModelAttribute("lstChuDe")
    public Map<String, String> layDanhSachChuDe()
    {
        Map<String, String> listChuDe = new HashMap<String, String>();

        //Lấy danh sách chủ đề từ db
        List<ChuDe> lstChuDe = chuDeDao.layDanhSach();

        for(ChuDe cd: lstChuDe)
        {
            listChuDe.put(cd.getMaChuDe(), cd.getTenChuDe());
        }

        return  listChuDe;
    }
}
