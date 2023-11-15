package org.app.controller.System.DataCenter;


import lombok.RequiredArgsConstructor;
import org.app.Annotation.Auth;
import org.app.Annotation.OperationLog;
import org.app.Annotation.Permission;
import org.app.request.system.AttachmentRequest;
import org.app.service.System.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 文件管理控制器
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/system/attachment")
@Auth
class AttachmentController {
    @Autowired
    protected UploadFileService service;

    /**
     * 列表数据
     */
    @GetMapping("index")
    @Permission("system:attachment, system:attachment:index")
    public Object index(@RequestBody AttachmentRequest request) {
        return service.getPageList(request);
    }

    /**
     * 回收站列表数据
     */
    @GetMapping("recycle")
    @Permission("system:attachment:recycle")
    public Object recycle() {
        return service.getPageListByRecycle();
    }

    /**
     * 单个或批量删除附件
     */
    @DeleteMapping("delete")
    @Permission("system:attachment:delete")
    public Object delete() {
        return service.delete();
    }

    /**
     * 单个或批量真实删除文件 （清空回收站）
     */
    @DeleteMapping("realDelete")
    @Permission("system:attachment:realDelete")
    @OperationLog("单个或批量真实删除文件 （清空回收站）")
    public Object realDelete() {
        return service.realDelete();
    }

    /**
     * 单个或批量恢复在回收站的文件
     */
    @PutMapping("recovery")
    @Permission("system:attachment:recovery")
    public Object recovery() {
        return service.recovery();
    }

}
