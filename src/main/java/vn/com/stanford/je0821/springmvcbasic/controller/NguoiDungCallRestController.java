package vn.com.stanford.je0821.springmvcbasic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NguoiDungCallRestController {

    @RequestMapping(value = "/call-rest")
    public String hienThiCallRestful()
    {
        return "SuDungGoiApi";
    }
}
