package com.wbb.mybatis.service.impl;

import com.wbb.mybatis.bean.AccountWallet;
import com.wbb.mybatis.mapper.AccountWalletMapper;
import com.wbb.mybatis.service.AccountWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountWalletServiceImpl implements AccountWalletService {

    @Autowired
    AccountWalletMapper accountWalletMapper;

    @Override
    public AccountWallet selectByOpenId(String openId) {
        return accountWalletMapper.selectByOpenId(openId);
    }

    @Override
    public int updateAccountWallet(AccountWallet record) {
        return accountWalletMapper.updateAccountWallet(record);
    }
}
