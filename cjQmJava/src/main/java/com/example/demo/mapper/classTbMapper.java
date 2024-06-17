package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.classTb;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
@Repository
public interface classTbMapper extends BaseMapper<classTb> {
    @Select("SELECT classification, COUNT(*) AS shu FROM class_tb GROUP BY classification")
    List<classTb> selectcad();
}
