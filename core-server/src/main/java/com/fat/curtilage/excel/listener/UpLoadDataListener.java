package com.fat.curtilage.excel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.fat.curtilage.excel.dto.DataTransfer;

import java.util.ArrayList;
import java.util.List;

public class UpLoadDataListener extends AnalysisEventListener<DataTransfer> {
    List<String> filter = new ArrayList<>();
    @Override
    public void invoke(DataTransfer data, AnalysisContext context) {

        if (!filter.contains(data.getSecondField())) {
            if (filter.size()==0){
                System.out.println("<=========================>");
            }
            if (data.getSecondField().length()>30){
                throw new RuntimeException("长度超过或等于30字符！");
            }
            filter.add(data.getSecondField());
            System.out.println("alter index " + data.getFirstField() + " rename to " + data.getSecondField() + ";");
        }else {
            throw new RuntimeException("字段名重复！");
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        System.out.println("<=========================>");
        System.out.println("解析完成！");
    }
}
