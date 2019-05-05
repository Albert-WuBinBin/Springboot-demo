package com.wbb.mybatis.service;

import com.wbb.mybatis.bean.AccountWallet;

public interface AccountWalletService {

    AccountWallet selectByOpenId(String openId);

    int updateAccountWallet(AccountWallet record);
}
