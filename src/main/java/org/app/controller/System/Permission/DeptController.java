package org.app.controller.System.Permission;

import lombok.RequiredArgsConstructor;
import org.app.Annotation.Auth;
import org.app.Annotation.OperationLog;
import org.app.Annotation.Permission;
import org.app.service.System.SystemDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @description: 部门管理
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/system/dept")
@Auth
class DeptController {
    @Autowired
    protected SystemDeptService service;

    /**
     * 部门树列表
     */
    @GetMapping("index")
    @Permission("system:dept, system:dept:index")
    public Object index() {
        return service.getTreeList();
    }

    /**
     * 回收站部门树列表
     */
    @GetMapping("recycle")
    @Permission("system:dept:recycle")
    public Object recycleTree() {
        return service.getTreeListByRecycle();
    }

    /**
     * 前端选择树（不需要权限）
     */
    @GetMapping("tree")
    public Object tree() {
        return service.getSelectTree();
    }

    @GetMapping("getLeaderList")
    @Permission("system:dept, system:dept:index")
    public Object getLeaderList() {
        return service.getLeaderList();
    }

    /**
     * 新增部门
     */
    @PostMapping("save")
    @Permission("system:dept:save")
    @OperationLog("新增部门")
    public Object save() {
        return service.save();
    }

    /**
     * 新增部门领导
     */
    @PostMapping("addLeader")
    @Permission("system:dept:update")
    @OperationLog("新增部门领导")
    public Object addLeader() {
        return service.addLeader();
    }

    /**
     * 删除部门领导
     */
    @DeleteMapping("delLeader")
    @Permission("system:dept:delete")
    @OperationLog("删除部门领导")
    public Object delLeader() {
        return service.delLeader();
    }

    /**
     * 更新部门
     */
    @PutMapping("update/{id}")
    @Permission("system:dept:update")
    @OperationLog("更新部门")
    public Object update(@PathVariable Integer id) {
        return service.update();
    }

    /**
     * 单个或批量删除部门到回收站
     */
    @DeleteMapping("delete")
    @Permission("system:dept:delete")
    public Object delete() {
        return service.delete();
    }

    /**
     * 单个或批量真实删除部门 （清空回收站）
     */
    @DeleteMapping("realDelete")
    @Permission("system:dept:realDelete")
    @OperationLog("单个或批量真实删除部门 （清空回收站）")
    public Object realDelete() {
        return service.realDel();
    }

    /**
     * 单个或批量恢复在回收站的部门
     */
    @PutMapping("recovery")
    @Permission("system:dept:recovery")
    public Object recovery() {
        return service.recovery();
    }

    /**
     * 更改部门状态
     */
    @PutMapping("changeStatus")
    @Permission("system:dept:changeStatus")
    @OperationLog("更改部门状态")
    public Object changeStatus() {
        return service.changeStatus();
    }

    /**
     * 数字运算操作
     */
    @PutMapping("numberOperation")
    @Permission("system:dept:update")
    @OperationLog("数字运算操作")
    public Object numberOperation() {
        return service.numberOperation();
    }

}