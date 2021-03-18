package com.fat.curtilage.excel.listener.utils;

public class AgencyCodeGenerate {
    public static String AgencyCode(String id,String type){
        String agencyCode = "020000" + type;
        switch (id.length()){
            case 1:
                agencyCode = agencyCode + "000000" + id;
                break;
            case 2:
                agencyCode = agencyCode + "00000" + id;
                break;
            case 3:
                agencyCode = agencyCode + "0000" + id;
                break;
            case 4:
                agencyCode = agencyCode + "000" + id;
                break;
            case 5:
                agencyCode = agencyCode + "00" + id;
                break;
            case 6:
                agencyCode = agencyCode + "0" + id;
                break;
            case 7:
                agencyCode = agencyCode + id;
                break;
        }
        return agencyCode;
    }
}
