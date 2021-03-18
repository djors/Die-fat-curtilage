package com.fat.curtilage.excel.excute;

import com.alibaba.excel.EasyExcel;
import com.fat.curtilage.excel.dto.DataInsert;
import com.fat.curtilage.excel.dto.DataInsert1;
import com.fat.curtilage.excel.listener.CompareDataListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class ExcuteMethod {

    public static void main(String[] args) {
//        File localStarFile = new File("C:\\Users\\Asura\\Desktop\\测试环境搭建\\数据库\\ssz_user_indexes.xlsx");
        File localStarFile = new File("C:\\Users\\Asura\\Desktop\\亚太财险2020-2021年度商业险及水险合作公估机构.xlsx");
        try {
//            UpLoadDataListener listener = new UpLoadDataListener();
            CompareDataListener  listener = new CompareDataListener();
            InputStream inputStream = new FileInputStream(localStarFile);
            EasyExcel.read(inputStream, DataInsert1.class, listener).sheet().doRead();
        }catch (Exception e){
            System.out.println("本地文件输入异常！");
            e.printStackTrace();
        }
    }
}
