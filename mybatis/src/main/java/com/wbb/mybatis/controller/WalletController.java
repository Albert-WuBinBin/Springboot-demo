package com.wbb.mybatis.controller;

import com.wbb.mybatis.bean.AccountWallet;
import com.wbb.mybatis.service.AccountWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private AccountWalletService accountWalletService;

    @RequestMapping(value =  "/update", method =  RequestMethod.POST)
    public String update(@RequestParam("openId")String openId,
                       @RequestParam("openType")String openType,
                       @RequestParam("amount")String amount){

        AccountWallet wallet = accountWalletService.selectByOpenId(openId);
        if(wallet == null){
            return "fail" ;
        }
        // 用户操作金额
        BigDecimal cash = BigDecimal.valueOf(Double.parseDouble(amount));
        cash.doubleValue();
        cash.floatValue();
        if (Integer.parseInt(openType) == 1) {
            wallet.setUserAmount(wallet.getUserAmount().add(cash));
        } else if (Integer.parseInt(openType) == 2) {
            wallet.setUserAmount(wallet.getUserAmount().subtract(cash));
        }
        int target = accountWalletService.updateAccountWallet(wallet);
        System.out.println("修改用户金额是否：" + (target == 1 ? "成功" : "失败"));
        if(target == 1){
            return "success";
        }
        else{
            return "fail";
        }
    }
}
