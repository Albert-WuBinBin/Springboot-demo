package com.wbb.mybatisplus.service.impl;

import com.wbb.mybatisplus.bean.PersonInfo;
import com.wbb.mybatisplus.mapper.PersonInfoMapper;
import com.wbb.mybatisplus.service.IPersonInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wbb
 * @since 2019-01-14
 */
@Service
public class PersonInfoServiceImpl extends ServiceImpl<PersonInfoMapper, PersonInfo> implements IPersonInfoService {

}
