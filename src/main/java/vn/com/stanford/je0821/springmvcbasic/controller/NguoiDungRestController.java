package vn.com.stanford.je0821.springmvcbasic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.stanford.je0821.springmvcbasic.entity.NguoiDung;
import vn.com.stanford.je0821.springmvcbasic.model.NguoiDungDao;

import java.util.List;

@RestController
public class NguoiDungRestController {

    @Autowired
    NguoiDungDao nguoiDungDao;

    @RequestMapping(value = "/nguoidungs", produces = {"application/json"}, method = RequestMethod.GET)
    public ResponseEntity<List<NguoiDung>> layTatCaNguoiDung()
    {
        //Lấy danh sách
        List<NguoiDung> lstNguoiDung = nguoiDungDao.layDanhSach();

        return new ResponseEntity<List<NguoiDung>>(lstNguoiDung, HttpStatus.OK);
    }

    @RequestMapping(value = "/nguoidungs/{id}", produces = {"application/json"}, method = RequestMethod.GET)
    public ResponseEntity<Object> layChiTietNguoiDung(@PathVariable int id)
    {
         NguoiDung objUser = nguoiDungDao.layChiTiet(id);

         if(objUser != null)
         {
             return new ResponseEntity<Object>(objUser, HttpStatus.OK);
         }

         return new ResponseEntity<Object>("Không tìm thấy người dùng", HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/nguoidungs", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.POST)
    public ResponseEntity<Object> themMoiNguoiDung(@RequestBody NguoiDung objUser)
    {
        nguoiDungDao.themMoi(objUser);
        return new ResponseEntity<Object>(objUser, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/nguoidungs/{id}", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.PUT)
    public ResponseEntity<Object> capNhatNguoiDung(@PathVariable int id, @RequestBody NguoiDung objUser)
    {
        nguoiDungDao.capNhat(objUser);
        return new ResponseEntity<Object>(objUser, HttpStatus.OK);
    }

    @RequestMapping(value = "/nguoidungs/{id}", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.DELETE)
    public ResponseEntity<Object> xoaNguoiDung(@PathVariable int id)
    {
        NguoiDung objUser = nguoiDungDao.layChiTiet(id);

        if(objUser != null)
        {
            nguoiDungDao.xoa(id);

            return  new ResponseEntity<Object>(objUser, HttpStatus.OK);
        }
        return new ResponseEntity<Object>("Không xóa được người dùng", HttpStatus.NOT_FOUND);
    }
}
