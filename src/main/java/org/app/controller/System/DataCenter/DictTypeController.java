package org.app.controller.System.DataCenter;


import lombok.RequiredArgsConstructor;
import org.app.Annotation.Auth;
import org.app.Annotation.OperationLog;
import org.app.Annotation.Permission;
import org.app.service.System.SystemDictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 字典类型控制器
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/system/dictType")
@Auth
class DictTypeController {
    @Autowired
    protected SystemDictTypeService service;

    /**
     * 获取字典列表
     *
     * @return ResponseInterface
     * @throws \Psr\Container\ContainerExceptionInterface
     * @throws \Psr\Container\NotFoundExceptionInterface
     */
    @GetMapping("index")
    @Permission("system:dict, system:dict:index")
    public Object index() {
        return service.getPageList();
    }

    /**
     * 回收站列表
     */
    @GetMapping("recycle")
    @Permission("system:dict:recycle")
    public Object recycle() {
        return service.getPageListByRecycle();
    }

    /**
     * 新增字典类型
     */
    @PostMapping("save")
    @Permission("system:dict:save")
    @OperationLog("新增字典类型")
    public Object save() {
        return service.save();
    }

    /**
     * 获取一个字典类型数据
     */
    @GetMapping("read/{id}")
    @Permission("system:dict:read")
    public Object read(int $id) {
        return service.read();
    }

    /**
     * 更新一个字典类型
     */
    @PutMapping("update/{id}")
    @Permission("system:dict:update")
    @OperationLog("更新字典类型")
    public Object update() {
        return service.update();
    }

    /**
     * 单个或批量字典数据
     */
    @DeleteMapping("delete")
    @Permission("system:dict:delete")
    public Object delete() {
        return service.delete();
    }

    /**
     * 单个或批量真实删除字典数据 （清空回收站）
     */
    @DeleteMapping("realDelete")
    @Permission("system:dict:realDelete")
    @OperationLog("删除字典类型")
    public Object realDelete() {
        return service.realDelete();
    }

    /**
     * 单个或批量恢复在回收站的字典数据
     */
    @PutMapping("recovery")
    @Permission("system:dict:recovery")
    public Object recovery() {
        return service.recovery();
    }

    /**
     * 更改字典类型状态
     */
    @PutMapping("changeStatus")
    @Permission("system:dict:update")
    @OperationLog("修改字典类型状态")
    public Object changeStatus() {
        return service.changeStatus();
    }

}
