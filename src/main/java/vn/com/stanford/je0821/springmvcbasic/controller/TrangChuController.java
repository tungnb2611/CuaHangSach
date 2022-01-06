package vn.com.stanford.je0821.springmvcbasic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vn.com.stanford.je0821.springmvcbasic.entity.Sach;
import vn.com.stanford.je0821.springmvcbasic.model.SachDao;

import java.util.List;

@Controller
public class TrangChuController {

    @Autowired
    SachDao sachDao;

    @RequestMapping(value = "/trangChu", method = RequestMethod.GET)
    public String hienThiTrangChuSach(Model model)
    {
      //Lấy danh sách
      List<Sach> lstSach = sachDao.layDanhSach();

      //Đưa vào model
      model.addAttribute("lstSach", lstSach);

      return "trangChuSach";
    }

    @RequestMapping(value = "/chiTiet/{ma}", method = RequestMethod.GET)
    public String hienThiChiTietSach(@PathVariable("ma")String ma, Model model)
    {
        Sach objSach = sachDao.layChiTiet(ma);

        if(objSach != null)
        {
            model.addAttribute("objSach", objSach);

            return "chiTietSach";
        }

        return "redirect:/trangChu";
    }

    @RequestMapping(value = "/quanly")
    public String trangQuanLySach()
    {
        return "trangQuanLy";
    }
}
