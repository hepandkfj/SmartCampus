package org.app.controller.System.Permission;

import lombok.RequiredArgsConstructor;
import org.app.Annotation.Auth;
import org.app.Annotation.OperationLog;
import org.app.Annotation.Permission;
import org.app.service.System.SystemMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 菜单控制器
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/system/menu")
@Auth
class MenuController {
    @Autowired
    protected SystemMenuService service;

    /**
     * 菜单树列表
     */
    @GetMapping("index")
    @Permission("system:menu, system:menu:index")
    public Object index() {
        return service.getTreeList();
    }

    /**
     * 回收站菜单树列表
     */
    @GetMapping("recycle")
    @Permission("system:menu:recycle")
    public Object recycle() {
        return service.getTreeListByRecycle();
    }

    /**
     * 前端选择树（不需要权限）
     */
    @GetMapping("tree")
    public Object tree() {
        return service.getSelectTree();
    }

    /**
     * 新增菜单
     */
    @PostMapping("save")
    @Permission("system:menu:save")
    @OperationLog("新增菜单")
    public Object save() {
        return service.save();
    }

    /**
     * 更新菜单
     */
    @PutMapping("update/{id}")
    @Permission("system:menu:update")
    @OperationLog("更新菜单")
    public Object update(@PathVariable Integer id) {
        return service.update();
    }

    /**
     * 单个或批量删除菜单到回收站
     */
    @DeleteMapping("delete")
    @Permission("system:menu:delete")
    public Object delete() {
        return service.delete();
    }

    /**
     * 单个或批量真实删除菜单 （清空回收站）
     */
    @DeleteMapping("realDelete")
    @Permission("system:menu:realDelete")
    @OperationLog("单个或批量真实删除菜单 （清空回收站）")
    public Object realDelete() {
        return service.realDelete();
    }

    /**
     * 单个或批量恢复在回收站的菜单
     */
    @PutMapping("recovery")
    @Permission("system:menu:recovery")
    public Object recovery() {
        return service.recovery();
    }

    /**
     * 更改菜单状态
     */
    @PutMapping("changeStatus")
    @Permission("system:menu:update")
    @OperationLog("更改菜单状态")
    public Object changeStatus() {
        return service.changeStatus();
    }

    /**
     * 数字运算操作
     */
    @PutMapping("numberOperation")
    @Permission("system:menu:update")
    @OperationLog("数字运算操作")
    public Object numberOperation() {
        return service.numberOperation();
    }

}