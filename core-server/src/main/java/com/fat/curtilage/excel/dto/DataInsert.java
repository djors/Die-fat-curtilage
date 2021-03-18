package com.fat.curtilage.excel.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DataInsert {
    Long id;
    String comCode;
    String riskCode;
    BigDecimal avgaMount;
}
