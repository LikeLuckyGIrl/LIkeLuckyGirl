package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.demos.web.number_user;
import com.example.demo.mapper.classTbMapper;
import com.example.demo.pojo.classTb;
import com.example.demo.service.ClassTbService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ClassTbServiceimpl implements ClassTbService {
    @Resource
    classTbMapper mapper;
    @Override
    public List<classTb> selectAll() {
        return mapper.selectList(null);
    }
    @Override
    public List<classTb> selectByClassification(String classification) {
        QueryWrapper<classTb> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(classTb::getClassification,classification);
        return mapper.selectList(queryWrapper);
    }

    @Override
    public List<classTb> selectId(Integer id) {
        QueryWrapper<classTb> quWrapper = new QueryWrapper<>();
        quWrapper.lambda().eq(classTb::getId,id);
        return mapper.selectList(quWrapper);
    }


/*
    @Override
    public List<number_user> select_number() {
        QueryWrapper<classTb> queryWrapper = new QueryWrapper<classTb>();
        queryWrapper.select();
        List<classTb> data = mapper.selectList(queryWrapper);


        long number1_count = data
                .stream()
                .filter(ClassTb -> ClassTb.getClassification().equals("娱乐"))
                .collect(Collectors.counting());
        long number2_count = data
                .stream()
                .filter(ClassTb -> ClassTb.getClassification().equals("国际"))
                .collect(Collectors.counting());
        long number3_count = data
                .stream()
                .filter(ClassTb -> ClassTb.getClassification().equals("体育"))
                .collect(Collectors.counting());


        List<number_user> ret = Arrays.asList(new number_user(
                Arrays.asList("娱乐", "国际", "体育"),
                "目标值",
                Arrays.asList(number1_count, number2_count, number3_count)
        ));

        return ret;
    }
*/
    @Override
    public List<classTb> selectcad() {
        return mapper.selectcad();
    }

    @Override
    public List<classTb> selectabc(String ss) {
        QueryWrapper<classTb> wrapper = new QueryWrapper<>();
        wrapper.like("classname", ss);
        List<classTb> users = mapper.selectList(wrapper);
        return users;
    }

    @Override
    public void post(String classname,String classification, String url1, String url2, String url3, String particulars){
        classTb User = new classTb();
        User.setClassname(classname);
        User.setClassification(classification);
        User.setUrl1(url1);
        User.setUrl2(url2);
        User.setUrl3(url3);
        User.setParticulars(particulars);
        mapper.insert(User);
    }

    @Override
    public void delete(Integer id) {
        mapper.deleteById(id);
    }


}
