package com.example.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.pojo.classTb;

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


    IPage<classTb> selectByPage(Page<classTb> classTbPage);
}
