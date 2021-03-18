package com.fat.curtilage.excel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.fat.curtilage.excel.dto.DataInsert;
import com.fat.curtilage.excel.dto.DataInsert1;
import com.fat.curtilage.excel.listener.analysis.ReadForInsert;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;

public class CompareDataListener extends AnalysisEventListener<DataInsert1> {
    private StringBuilder builder = new StringBuilder();
    private long startPoint;
    private long endPoint;
    @Override
    public void invoke(DataInsert1 data, AnalysisContext context) {
        //2020-03-17
        ReadForInsert.Insert1(data,builder);
  }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        super.invokeHeadMap(headMap, context);
        System.out.println("解析到一条头数据："+headMap.toString());
        System.out.println("<=========================>执行开始！");
        //执行开始计时
        startPoint = System.currentTimeMillis();
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        String text = builder.toString();
        if (!StringUtils.hasText(text)){
            return;
        }
        boolean flag = false;
        File outFile = new File("C:\\Users\\Asura\\Desktop\\字典核对\\2021-03-17-公估机构数据导入.txt");
        try {
        if (!outFile.exists()){
             flag = outFile.createNewFile();
        }
        Assert.isTrue(flag,"创建输出的本地文件失败！");
        FileOutputStream outStream = new FileOutputStream(outFile);
        outStream.write(text.getBytes());
        }catch (Exception e){
            System.out.println("输出到本地文件异常！");
            e.printStackTrace();
        }
        endPoint = System.currentTimeMillis();
        System.out.println("<=========================>执行结束！");
        System.out.println("读取持续时长："+(endPoint-startPoint));
    }
}
