package com.fat.curtilage.excel.listener.analysis;

import com.fat.curtilage.excel.dto.DataInsert1;
import com.fat.curtilage.excel.listener.utils.AgencyCodeGenerate;

public class ReadForInsert {
    public static void Insert1(DataInsert1 data,StringBuilder builder){
        builder.append("insert into API_CNXCLMBUSI.PRPDAGENCYDIRECTORY (ID, AGENCYCODE, AGENCYTYPE, AGENCYNAME, MAKECOMADDRESS, CERTIFICATELEVEL, AGENTTYPE, BUSINESSTYPE, CHARGEFLAG, WORKCODE, WORKNAME, CONTACTNAME, AGENCYSCOPETYPE, PHONENUMBER, MOBILENUMBER, FAXNUMBER, ADDRESS, POSTCODE, EMAIL, STATUS, SOURCEFLAG, FLAG, REMARK, WORKCLASSCODE, WORKADDRESS, INSERTTIMEFORHIS, OPERATETIMEFORHIS, PARTITIONKEY, BIRTHDAY, GENDER, OLDAGENCYNAME, TECTITLE, PROBACK, CONTACT) values ("+data.getNumber()+", '"+ AgencyCodeGenerate.AgencyCode(String.valueOf(data.getNumber()),"G") +"', 'G', '"+data.getCompanyName()+"', null, '07', null, null, '0', null, null, '"+data.getLink() +"', null, '"+data.getPhone()+"', '"+data.getPhone()+"', null, '"+data.getAddress()+"', null, null, '1', null, null, null, '01,02,04,07,09,12,13,06,99,19', '000000', sysdate, sysdate, sysdate, null, null, null, null, null, null);\n");
    }
}
