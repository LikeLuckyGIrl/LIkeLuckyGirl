package com.example.demo.service;

import com.example.demo.demos.web.number_user;
import com.example.demo.pojo.classTb;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

public interface ClassTbService {
    List<classTb> selectAll();

    List<classTb> selectByClassification(String classification);

    List<classTb> selectId(Integer id);

    /*List<number_user> select_number();*/

    List<classTb> selectcad();

    List<classTb> selectabc(String ss);

    void post(String classname,String classification, String url1, String url2, String url3, String particulars);

    void delete(Integer id);
}
