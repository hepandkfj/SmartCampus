package org.app.controller.System.Permission;

import lombok.RequiredArgsConstructor;
import org.app.Annotation.Auth;
import org.app.Annotation.OperationLog;
import org.app.Annotation.Permission;
import org.app.service.System.SystemPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 岗位控制器
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/system/post")
@Auth
class PostController {
    @Autowired
    protected SystemPostService service;

    /**
     * 岗位分页列表
     */
    @GetMapping("index")
    @Permission("system:post, system:post:index")
    public Object index() {
        return service.getPageList();
    }

    /**
     * 岗位回收站分页列表
     */
    @GetMapping("recycle")
    @Permission("system:post:recycle")
    public Object recycle() {
        return service.getPageListByRecycle();
    }

    /**
     * 获取岗位列表
     */
    @GetMapping("list")
    public Object list() {
        return service.getList();
    }

    /**
     * 保存数据
     */
    @PostMapping("save")
    @Permission("system:post:save")
    @OperationLog("保存数据")
    public Object save() {
        return service.save();
    }

    /**
     * 获取一条数据信息
     */
    @GetMapping("read/{id}")
    @Permission("system:post:read")
    public Object read(int $id) {
        return service.read();
    }

    /**
     * 更新数据
     */
    @PutMapping("update/{id}")
    @Permission("system:post:update")
    @OperationLog("更新数据")
    public Object update() {
        return service.update();
    }

    /**
     * 单个或批量删除数据到回收站
     */
    @DeleteMapping("delete")
    @Permission("system:post:delete")
    public Object delete() {
        return service.delete();
    }

    /**
     * 单个或批量真实删除数据 （清空回收站）
     */
    @DeleteMapping("realDelete")
    @Permission("system:post:realDelete")
    @OperationLog("单个或批量真实删除数据 （清空回收站）")
    public Object realDelete() {
        return service.realDelete();
    }

    /**
     * 单个或批量恢复在回收站的数据
     */
    @PutMapping("recovery")
    @Permission("system:post:recovery")
    public Object recovery() {
        return service.recovery();
    }

    /**
     * 更改岗位状态
     */
    @PutMapping("changeStatus")
    @Permission("system:post:changeStatus")
    @OperationLog("更改岗位状态")
    public Object changeStatus() {
        return service.changeStatus();
    }

    /**
     * 数字运算操作
     */
    @PutMapping("numberOperation")
    @Permission("system:post:update")
    @OperationLog("数字运算操作")
    public Object numberOperation() {
        return service.numberOperation();
    }

}