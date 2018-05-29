package com.king.service.impl;

import com.github.pagehelper.PageHelper;
import com.king.mapper.UserInfoMapper;
import com.king.entity.UserInfo;
import com.king.service.UserInfoService;
import com.king.utils.JacksonUtil;
import com.king.cache.RedisOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author wangchangyong
 * @create 2018/05/23 14:41
 */
@Service(value = "userInfoServiceImpl")
public class UserInfoServiceImpl implements UserInfoService{

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private RedisOperation redisOperation;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserInfo record) {
        int userInfo = userInfoMapper.insert(record);
        if(userInfo>0){
            redisOperation.setValue(record.getId().toString(), JacksonUtil.objectToJson(record),10, TimeUnit.HOURS);
        }
        return userInfo;
    }

    @Override
    public UserInfo selectByPrimaryKey(Long id) {
        //return userInfoMapper.selectByPrimaryKey(id);
        return JacksonUtil.jsonToPojo((String) redisOperation.getValue(id.toString()),UserInfo.class);
    }

    @Override
    public List<UserInfo> selectAll() {
        return userInfoMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(UserInfo record) {
        return userInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<UserInfo> queryUserByPage(UserInfo userInfo) {
        //开始分页
        PageHelper.startPage(userInfo.getCurrentPage(),userInfo.getPageSize());
        return userInfoMapper.queryUserByPage(userInfo);
    }
}
