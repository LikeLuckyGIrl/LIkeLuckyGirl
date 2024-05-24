package com.example.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.demos.web.number_user;
import com.example.demo.pojo.classTb;
import com.example.demo.service.ClassTbService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.omg.CORBA.INTERNAL;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
@Api(tags = "新闻")
@CrossOrigin
@RestController
public class ClassTbController {

    @Resource
    ClassTbService classTbService;

    //@Resource ClassTbMapper classTbMapper//
    @ApiOperation(value = "查询全部")
    @GetMapping("selectAll")
    public List<classTb> selectAll(){
        return classTbService.selectAll();
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "classification",value = "分类",required = true)
    })
    @ApiOperation(value = "分类")
    @GetMapping("selectByClassification")
    public List<classTb> selectByClassification(@RequestParam String classification){
        return classTbService.selectByClassification(classification);
    }
@ApiOperation(value = "根据id查内容")
    @GetMapping("selectId")
    public List<classTb> selectId(@RequestParam Integer id){
        return classTbService.selectId(id);
    }
/*
    @GetMapping("select_number")
    public List<number_user> select_number(){
        return classTbService.select_number();
    }
*/
    @ApiOperation(value = "柱状图用")
    @GetMapping("selectcad")
    public List<classTb> selectcad(){
        return classTbService.selectcad();
    }

    @ApiOperation(value = "模糊查询")
    @GetMapping("selectabc")
    public List<classTb> selectabc(@RequestParam String ss){
        return classTbService.selectabc(ss);
    }

    @ApiOperation(value = "添加")
    @PostMapping("post")
    public void post(@RequestParam String classname,@RequestParam String classification,@RequestParam String url1,@RequestParam String url2,@RequestParam String url3,@RequestParam String particulars){
        classTbService.post(classname,classification,url1,url2,url3,particulars);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("delete")
    public void delete(@RequestParam Integer id){
        classTbService.delete(id);
    }

    @ApiOperation(value = "分页")
    @GetMapping("selectByPage")
    public IPage<classTb> selectByPage(@RequestParam Integer current, @RequestParam Integer size){
        return classTbService.selectByPage(new Page<classTb>(current,size));
    }

}
