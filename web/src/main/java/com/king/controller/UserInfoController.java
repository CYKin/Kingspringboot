package com.king.controller;

import com.king.config.Config;
import com.king.entity.UserInfo;
import com.king.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wangchangyong
 * @create 2018/05/14 16:13 *
 * @RestController等同于@Controller和@ResponseBody
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private Config config;

    @GetMapping(value = "/removeUser")
    public void deleteById(Long id){
        userInfoService.deleteByPrimaryKey(id);
    }

    @PostMapping(value = "/insertUser", produces = "application/json;charset=UTF-8")
    public void insert(@RequestBody UserInfo record){
        record.setUserName(config.getUserName());
        record.setPassword(config.getPassword());
        userInfoService.insert(record);
    }

    @GetMapping(value = "/selectUserById")
    public UserInfo selectByPrimaryKey(Long id){
        return userInfoService.selectByPrimaryKey(id);
    }

    @PostMapping(value = "/selectAllUser")
    public List<UserInfo> selectAll(){
        return userInfoService.selectAll();
    }

    @PostMapping(value = "/updateUser")
    public void updateUser(@RequestBody UserInfo record){
        userInfoService.updateByPrimaryKey(record);
    }

    @PostMapping(value = "/queryUserByPage", produces = "application/json;charset=UTF-8")
    public List<UserInfo> queryUserByPage(@RequestBody UserInfo userInfo){
        return userInfoService.queryUserByPage(userInfo);
    }


}
