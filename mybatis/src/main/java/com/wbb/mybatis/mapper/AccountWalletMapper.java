package com.wbb.mybatis.mapper;

import com.wbb.mybatis.bean.AccountWallet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AccountWalletMapper {

    @Select(" select *  from account_wallet where user_open_id = #{openId}")
    AccountWallet selectByOpenId(@Param("openId") String openId);
    @Update("update account_wallet set user_amount = #{userAmount}, version = version + 1 where id =#{id,jdbcType=INTEGER} and version = #{version,jdbcType=INTEGER}")
    int updateAccountWallet(AccountWallet record);
}
