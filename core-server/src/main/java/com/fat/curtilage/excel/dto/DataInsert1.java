package com.fat.curtilage.excel.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class DataInsert1 {
    @ExcelProperty("序号")
    Long number;
    @ExcelProperty("公估机构名称")
    String companyName;
    @ExcelProperty("合作类别")
    String cooperationType;
    @ExcelProperty("联系地址")
    String address;
    @ExcelProperty("联系人")
    String link;
    @ExcelProperty("电话")
    String phone;
    @ExcelProperty("服务区域")
    String serviceField;
    @ExcelProperty("等级")
    String grade;
}
