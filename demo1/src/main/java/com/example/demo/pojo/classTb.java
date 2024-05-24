package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class classTb {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "标题")
    private String classname;
    @ApiModelProperty(value = "分类")
    private String classification;
    @ApiModelProperty(value = "图片1")
    private String url1;
    @ApiModelProperty(value = "图片2")
    private String url2;
    @ApiModelProperty(value = "图片3")
    private String url3;
    @ApiModelProperty(value = "时间")
    private String updatetime;
    @ApiModelProperty(value = "正文")
    private String particulars;
    private Integer shu;
}
