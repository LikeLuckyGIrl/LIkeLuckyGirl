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
    private String className;
    @ApiModelProperty(value = "分类")
    private String classification;
    @ApiModelProperty(value = "图片1")
    private String urlOne;
    @ApiModelProperty(value = "图片2")
    private String urlTwo;
    @ApiModelProperty(value = "图片3")
    private String urlThree;
    @ApiModelProperty(value = "时间")
    private String updateTime;
    @ApiModelProperty(value = "正文")
    private String particulars;
    private Integer shu;
}
