package org.app.controller.System.Permission;

import lombok.RequiredArgsConstructor;
import org.app.Annotation.Auth;
import org.app.Annotation.OperationLog;
import org.app.Annotation.Permission;
import org.app.service.System.SystemRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 角色控制器
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/system/role")
@Auth
class RoleController {
    @Autowired
    protected SystemRoleService service;

    /**
     * 角色分页列表
     */
    @GetMapping("index")
    @Permission("system:role, system:role:index")
    public Object index() {
        return service.getPageList();
    }

    /**
     * 回收站角色分页列表
     */
    @GetMapping("recycle")
    @Permission("system:role:recycle")
    public Object recycle() {
        return service.getPageListByRecycle();
    }

    /**
     * 通过角色获取菜单
     */
    @GetMapping("getMenuByRole/{id}")
    public Object getMenuByRole() {
        return service.getMenuByRole();
    }

    /**
     * 通过角色获取部门
     */
    @GetMapping("getDeptByRole/{id}")
    public Object getDeptByRole() {
        return service.getDeptByRole();
    }

    /**
     * 获取角色列表 (不验证权限)
     */
    @GetMapping("list")
    public Object list() {
        return service.getList();
    }

    /**
     * 新增角色
     */
    @PostMapping("save")
    @Permission("system:role:save")
    @OperationLog("新增角色")
    public Object save() {
        return service.save();
    }

    /**
     * 更新角色
     */
    @PutMapping("update/{id}")
    @Permission("system:role:update")
    @OperationLog("更新角色")
    public Object update() {
        return service.update();
    }

    /**
     * 更新用户菜单权限
     */
    @PutMapping("menuPermission/{id}")
    @Permission("system:role:menuPermission")
    @OperationLog("更新用户菜单权限")
    public Object menuPermission() {
        return service.update();
    }

    /**
     * 更新用户数据权限
     */
    @PutMapping("dataPermission/{id}")
    @Permission("system:role:dataPermission")
    @OperationLog("更新用户数据权限")
    public Object dataPermission() {
        return service.update();
    }

    /**
     * 单个或批量删除数据到回收站
     */
    @DeleteMapping("delete")
    @Permission("system:role:delete")
    public Object delete() {
        return service.delete();
    }

    /**
     * 单个或批量真实删除数据 （清空回收站）
     */
    @DeleteMapping("realDelete")
    @Permission("system:role:realDelete")
    @OperationLog("单个或批量真实删除数据 （清空回收站）")
    public Object realDelete() {
        return service.realDelete();
    }

    /**
     * 单个或批量恢复在回收站的数据
     */
    @PutMapping("recovery")
    @Permission("system:role:recovery")
    public Object recovery() {
        return service.recovery();
    }

    /**
     * 更改角色状态
     */
    @PutMapping("changeStatus")
    @Permission("system:role:changeStatus")
    @OperationLog("更改角色状态")
    public Object changeStatus() {
        return service.changeStatus();
    }

    /**
     * 数字运算操作
     */
    @PutMapping("numberOperation")
    @Permission("system:role:update")
    @OperationLog("数字运算操作")
    public Object numberOperation() {
        return service.numberOperation();
    }

}