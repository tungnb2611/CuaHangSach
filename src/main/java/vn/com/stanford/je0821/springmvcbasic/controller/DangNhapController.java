package vn.com.stanford.je0821.springmvcbasic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import vn.com.stanford.je0821.springmvcbasic.entity.NguoiDung;
import vn.com.stanford.je0821.springmvcbasic.model.NguoiDungDao;

import javax.servlet.http.HttpSession;

@Controller
public class DangNhapController {

    @Autowired
    NguoiDungDao nguoiDungDao;
    
    /**
     * Hiển thị giao diện đăng nhập hệ thống
     * @return
     */
    @RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
    public String hienThiDangNhap(Model model)
    {
        model.addAttribute("user", new NguoiDung());
        return "DangNhap";
    }

    /**
     * Hàm xử lý khi nhấn nút đăng nhập trên hệ thống
     * @param user
     * @param model
     * @return
     */
    @RequestMapping(value = "/thucHienDangNhap", method = RequestMethod.POST)
    public String thucHienDangNhapHeThong(@ModelAttribute("user")NguoiDung user, Model model, HttpSession session)
    {
        System.out.println("Tên đăng nhập là: " + user.getUsername());
        System.out.println("Mật khẩu: " + user.getPassword());

        //Lấy thông tin từ db
        NguoiDung objUser = nguoiDungDao.kiemTraDangNhap(user.getUsername());

        if(objUser != null)
        {
            String matKhauDb = objUser.getPassword();

            //Nếu đúng mật khẩu
            if(objUser.getPassword().equals(matKhauDb))//Nếu đăng nhập thành công
            {
                //Lưu thông tin vào session
                session.setAttribute("userOnline", user.getUsername());

                return "redirect:admin/QuanLy";
            }
            else
            {
                model.addAttribute("thongBao", "Mật khẩu không đúng. Bạn vui lòng kiểm tra lại");
            }
        }
        else
        {
            model.addAttribute("thongBao", "Tài khoản không tồn tại. Bạn vui lòng kiểm tra lại");
        }
        
        model.addAttribute("user", user);

        return "DangNhap";
    }


    @RequestMapping(value = "/dang-nhap1", method = RequestMethod.GET)
    public String hienThiDangNhap1(@ModelAttribute("user") NguoiDung user, @RequestParam(value="error", required = false) final String error, Model model)
    {
        //Nếu có lỗi
        if(error != null && !error.isEmpty())
        {
            model.addAttribute("message", "Đăng nhập không thành công. Chi tiết: " + error);
        }

        model.addAttribute("user", user);
        return "DangNhap1";
    }

    @RequestMapping(value = "/thucHienDangNhap1", method = RequestMethod.POST)
    public String thucHienDangNhapHeThong1(@ModelAttribute("user")NguoiDung user, Model model)
    {
        System.out.println("Tên đăng nhập là: " + user.getUsername());
        System.out.println("Mật khẩu: " + user.getPassword());

        model.addAttribute("user", user);
        model.addAttribute("message", "Đăng nhập thành công");

        return "DangNhap1";
    }

    @RequestMapping("/admin/QuanLy")
    public String quanLy()
    {
        return "QuanLy";
    }

    @RequestMapping("/dangXuat1")
    public String dangXuat(Model model)
    {
        model.addAttribute("user", new NguoiDung());
        model.addAttribute("message", "Đăng xuất thành thành công");
        return "DangNhap1";
    }

}
