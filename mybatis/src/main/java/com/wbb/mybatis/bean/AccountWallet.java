package com.wbb.mybatis.bean;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
public class AccountWallet {

    private Integer id;
    private String userOpenId;
    private BigDecimal userAmount;
    private Integer version;
}
