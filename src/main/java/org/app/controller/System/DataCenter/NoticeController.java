package org.app.controller.System.DataCenter;


import lombok.RequiredArgsConstructor;
import org.app.Annotation.Auth;
import org.app.Annotation.OperationLog;
import org.app.Annotation.Permission;
import org.app.service.System.SystemNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 通知管理控制器
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/system/notice")
@Auth
class NoticeController {
    @Autowired
    protected SystemNoticeService service;

    /**
     * 列表
     */
    @GetMapping("index")
    @Permission("system:notice, system:notice:index")
    public Object index() {
        return service.getPageList();
    }

    /**
     * 回收站列表
     */
    @GetMapping("recycle")
    @Permission("system:notice:recycle")
    public Object recycle() {
        return service.getPageListByRecycle();
    }

    /**
     * 新增
     */
    @PostMapping("save")
    @Permission("system:notice:save")
    @OperationLog("新增")
    public Object save() {
        return service.save();
    }

    /**
     * 读取数据
     */
    @GetMapping("read/{id}")
    @Permission("system:notice:read")
    public Object read() {
        return service.read();
    }

    /**
     * 更新
     */
    @PutMapping("update/{id}")
    @Permission("system:notice:update")
    @OperationLog("更新")
    public Object update() {
        return service.update();
    }

    /**
     * 单个或批量删除数据到回收站
     */
    @DeleteMapping("delete")
    @Permission("system:notice:delete")
    public Object delete() {
        return service.delete();
    }

    /**
     * 单个或批量真实删除数据 （清空回收站）
     */
    @DeleteMapping("realDelete")
    @Permission("system:notice:realDelete")
    @OperationLog("单个或批量真实删除数据 （清空回收站）")
    public Object realDelete() {
        return service.realDelete();
    }

    /**
     * 单个或批量恢复在回收站的数据
     */
    @PutMapping("recovery")
    @Permission("system:notice:recovery")
    public Object recovery() {
        return service.recovery();
    }

}
