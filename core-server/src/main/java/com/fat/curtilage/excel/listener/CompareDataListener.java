package com.fat.curtilage.excel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.fat.curtilage.excel.dto.DataInsert;
import com.fat.curtilage.excel.dto.DataInsert1;
import com.fat.curtilage.excel.listener.utils.AgencyCodeGenerate;
import org.springframework.util.Assert;

import java.io.File;
import java.io.FileOutputStream;

public class CompareDataListener extends AnalysisEventListener<DataInsert1> {
    StringBuilder builder = new StringBuilder();
    @Override
    public void invoke(DataInsert1 data, AnalysisContext context) {
        if (data.getNumber()==1700) {
            System.out.println("<=========================>执行开始！");
        }
        builder.append("insert into API_CNXCLMBUSI.PRPDAGENCYDIRECTORY (ID, AGENCYCODE, AGENCYTYPE, AGENCYNAME, MAKECOMADDRESS, CERTIFICATELEVEL, AGENTTYPE, BUSINESSTYPE, CHARGEFLAG, WORKCODE, WORKNAME, CONTACTNAME, AGENCYSCOPETYPE, PHONENUMBER, MOBILENUMBER, FAXNUMBER, ADDRESS, POSTCODE, EMAIL, STATUS, SOURCEFLAG, FLAG, REMARK, WORKCLASSCODE, WORKADDRESS, INSERTTIMEFORHIS, OPERATETIMEFORHIS, PARTITIONKEY, BIRTHDAY, GENDER, OLDAGENCYNAME, TECTITLE, PROBACK, CONTACT) values ("+data.getNumber()+", '"+ AgencyCodeGenerate.AgencyCode(String.valueOf(data.getNumber()),"G") +"', 'G', '"+data.getCompanyName()+"', null, '07', null, null, '0', null, null, '"+data.getLink() +"', null, '"+data.getPhone()+"', '"+data.getPhone()+"', null, '"+data.getAddress()+"', null, null, '1', null, null, null, '01,02,04,07,09,12,13,06,99,19', '000000', sysdate, sysdate, sysdate, null, null, null, null, null, null);\n");
  }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        String text = builder.toString();
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
        System.out.println("<=========================>执行结束！");
    }
}
