


package org.app.controller.System.Monitor;


import lombok.RequiredArgsConstructor;
import org.app.Annotation.Auth;
import org.app.Annotation.Permission;
import org.app.service.System.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 在线用户监控
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/system/onlineUser")
@Auth
class OnlineUserMonitorController {
    @Autowired
    protected SystemUserService service;

    /**
     * 获取在线用户列表
     */
    @GetMapping("index")
    @Permission("system:onlineUser, system:onlineUser:index")
    public Object getPageList() {
        return service.getOnlineUserPageList();
    }

    /**
     * 强退用户
     */
    @PostMapping("kick")
    @Permission("system:onlineUser:kick")
    public Object kickUser() {
        return service.kickUser();
    }
}