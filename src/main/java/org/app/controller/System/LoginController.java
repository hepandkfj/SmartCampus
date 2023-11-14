package org.app.controller.System;

import lombok.RequiredArgsConstructor;
import org.app.Annotation.Auth;
import org.app.constant.LoginUser;
import org.app.request.LoginRequest;
import org.app.response.Result;
import org.app.service.System.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 后台 - 用户登录控制器
 *
 * @author HJS
 * @date 2023/09/23
 */
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/system")
public class LoginController {

    @Autowired
    private LoginService service;
//

    /**
     * 用户登录
     *
     * @return Object
     */
    @PostMapping("login")
    public Object login(@Validated @RequestBody LoginRequest login) {
        return service.login(login);
    }

    /**
     * 用户退出
     *
     * @return
     */
    @PostMapping("logout")
    @Auth
    public Result<?> logout() {
        return service.logout();
    }

    /**
     * 用户信息
     *
     * @return Object
     */
    @GetMapping("getInfo")
    @Auth
    public Object getInfo() {
        return service.getInfo(LoginUser.getId());
    }

    /**
     * 刷新token
     *
     * @return Object
     */
    @PostMapping("refresh")
    public Object refresh() {
        Map<String, String> array = new HashMap<>();
        String token = "1232";
        array.put("token", token);
        return array;
    }

    /**
     * 获取每日的必应背景图
     *
     * @return Object
     */
    @GetMapping("getBingBackgroundImage")
    public Object getBingBackgroundImage() {
        Map<String, String> array = new HashMap<>();
        array.put("url", "https://cn.bing.com");
        return array;
    }
}
