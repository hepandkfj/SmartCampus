package org.app.controller.System.DataCenter;


import lombok.RequiredArgsConstructor;
import org.app.Annotation.Auth;
import org.app.Annotation.DeleteCache;
import org.app.Annotation.OperationLog;
import org.app.Annotation.Permission;
import org.app.service.System.SystemDictDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 字典类型控制器
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/system/dataDict")
@Auth
class DictDataController {

    @Autowired
    protected SystemDictDataService service;

    /**
     * 列表
     */
    @GetMapping("index")
    @Permission("system:dict, system:dict:index")
    public Object index() {
        return service.getPageList();
    }

    /**
     * 快捷查询一个字典
     */
    @GetMapping("list")
    public Object list() {
        return service.getList();
    }

    /**
     * 快捷查询多个字典
     */
    @GetMapping("lists")
    public Object lists() {
        return service.getLists();
    }

    /**
     * 清除字典缓存
     */
    @PostMapping("clearCache")
    @Permission("system:dict:clearCache")
    @OperationLog("清除字典缓存")
    public Object clearCache() {
        return service.clearCache();
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
    @DeleteCache("Dict:*")
    public Object save() {
        return service.save();
    }

    /**
     * 获取一个字典类型数据
     */
    @GetMapping("read/{id}")
    @Permission("system:dict:read")
    public Object read() {
        return service.read();
    }

    /**
     * 更新一个字典类型
     */
    @PutMapping("update/{id}")
    @Permission("system:dict:update")
    @OperationLog("更新一个字典类型")
    @DeleteCache("Dict:*")
    public Object update() {
        return service.update();
    }

    /**
     * 单个或批量字典数据
     */
    @DeleteMapping("delete")
    @Permission("system:dict:delete")
    @DeleteCache("Dict:*")
    public Object delete() {
        return service.delete();
    }

    /**
     * 单个或批量真实删除字典 （清空回收站）
     */
    @DeleteMapping("realDelete")
    @Permission("system:dict:realDelete")
    @OperationLog("单个或批量真实删除字典 （清空回收站）")
    @DeleteCache("Dict:*")
    public Object realDelete() {
        return service.realDelete();
    }

    /**
     * 单个或批量恢复在回收站的字典
     */
    @PutMapping("recovery")
    @Permission("system:dict:recovery")
    @DeleteCache("Dict:*")
    public Object recovery() {
        return service.recovery();
    }

    /**
     * 更改字典状态
     */
    @PutMapping("changeStatus")
    @Permission("system:dict:update")
    @OperationLog("更改字典状态")
    @DeleteCache("Dict:*")
    public Object changeStatus() {
        return service.changeStatus();
    }

    /**
     * 数字运算操作
     */
    @PutMapping("numberOperation")
    @Permission("system:dict:update")
    @OperationLog("数字运算操作")
    public Object numberOperation() {
        return service.numberOperation();
    }
}
