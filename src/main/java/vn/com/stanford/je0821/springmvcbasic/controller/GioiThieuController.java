package vn.com.stanford.je0821.springmvcbasic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GioiThieuController {

    @RequestMapping(value = "/hello")
    public String loiGioiThieu(Model model)
    {   //Xử lý công việc
        model.addAttribute("gioiThieu", "Làm việc với Spring MVC - Stanford.com.vn");
        return "GioiThieu";
    }
}
