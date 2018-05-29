package com.king.service;

import com.king.entity.UserInfo;

import java.util.List;

/**
 * @author wangchangyong
 * @create 2018/05/23 14:40
 */
public interface UserInfoService {

    int deleteByPrimaryKey(Long id);

    int insert(UserInfo record);

    UserInfo selectByPrimaryKey(Long id);

    List<UserInfo> selectAll();

    int updateByPrimaryKey(UserInfo record);

    List<UserInfo> queryUserByPage(UserInfo userInfo);
}
