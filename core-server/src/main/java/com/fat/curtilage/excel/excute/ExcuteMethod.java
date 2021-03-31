package com.fat.curtilage.excel.excute;

import com.alibaba.excel.EasyExcel;
import com.fat.curtilage.excel.dto.DataInsert1;
import com.fat.curtilage.excel.listener.GenerateInsertListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class ExcuteMethod {

    public static void main(String[] args) {
        String pathName = "C:\\Users\\Asura\\Desktop\\亚太财险2020-2021年度商业险及水险合作公估机构.xlsx";
        File localStarFile = new File(pathName);
        try {
//            UpLoadDataListener listener = new UpLoadDataListener();
            GenerateInsertListener listener = new GenerateInsertListener();
            InputStream inputStream = new FileInputStream(localStarFile);
            EasyExcel.read(inputStream, DataInsert1.class, listener).sheet().doRead();
        }catch (Exception e){
            System.out.println("本地文件输入异常！");
            e.printStackTrace();
        }
    }
}
