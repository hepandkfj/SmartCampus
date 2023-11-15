package org.app.controller.System.Permission;

import lombok.RequiredArgsConstructor;
import org.app.Annotation.Auth;
import org.app.Annotation.OperationLog;
import org.app.Annotation.Permission;
import org.app.service.System.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 用户控制器
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/system/user")
@Auth
class UserController {
    @Autowired
    protected SystemUserService service;

    /**
     * 用户列表
     */
    @GetMapping("index")
    @Permission("system:user, system:user:index")
    public Object index() {
        return service.getPageList();
    }

    /**
     * 回收站列表
     */
    @GetMapping("recycle")
    @Permission("system:user:recycle")
    public Object recycle() {
        return service.getPageListByRecycle();
    }

    /**
     * 新增一个用户
     */
    @PostMapping("save")
    @Permission("system:user:save")
    @OperationLog("新增一个用户")
    public Object save() {
        return service.save();
    }

    /**
     * 获取一个用户信息
     */
    @GetMapping("read/{id}")
    @Permission("system:user:read")
    public Object read(@PathVariable Integer id) {
        return service.read();
    }

    /**
     * 更新一个用户信息
     */
    @PutMapping("update/{id}")
    @Permission("system:user:update")
    @OperationLog("更新一个用户信息")
    public Object update(@PathVariable Integer id) {
        return service.update();
    }

    /**
     * 单个或批量删除用户到回收站
     */
    @DeleteMapping("delete")
    @Permission("system:user:delete")
    public Object delete() {
        return service.delete();
    }

    /**
     * 单个或批量真实删除用户 （清空回收站）
     */
    @DeleteMapping("realDelete")
    @Permission("system:user:realDelete")
    @OperationLog("单个或批量真实删除用户 （清空回收站）")
    public Object realDelete() {
        return service.realDelete();
    }

    /**
     * 单个或批量恢复在回收站的用户
     */
    @PutMapping("recovery")
    @Permission("system:user:recovery")
    @OperationLog("单个或批量恢复在回收站的用户")
    public Object recovery() {
        return service.recovery();
    }

    /**
     * 更改用户状态
     */
    @PutMapping("changeStatus")
    @Permission("system:user:changeStatus")
    @OperationLog("更改用户状态")
    public Object changeStatus() {
        return service.changeStatus();
    }

    /**
     * 清除用户缓存
     */
    @PostMapping("clearCache")
    @Permission("system:user:cache")
    public Object clearCache() {
        return service.clearCache();
    }

    /**
     * 设置用户首页
     */
    @PostMapping("setHomePage")
    @Permission("system:user:homePage")
    public Object setHomePage() {
        return service.setHomePage();
    }

    /**
     * 初始化用户密码
     */
    @PutMapping("initUserPassword")
    @Permission("system:user:initUserPassword")
    @OperationLog("初始化用户密码")
    public Object initUserPassword() {
        return service.initUserPassword();
    }

    /**
     * 更改用户资料，含修改头像 (不验证权限)
     */
    @PostMapping("updateInfo")
    public Object updateInfo() {
        return service.updateInfo();
    }

    /**
     * 修改密码 (不验证权限)
     */
    @PostMapping("modifyPassword")
    public Object modifyPassword() {
        return service.modifyPassword();
    }

}