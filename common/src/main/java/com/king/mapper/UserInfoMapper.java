package com.king.mapper;

import com.king.entity.UserInfo;
import com.king.utils.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wangchangyong
 * @create 2018/05/23 14:07
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    List<UserInfo> queryUserByPage(UserInfo userInfo);
}
