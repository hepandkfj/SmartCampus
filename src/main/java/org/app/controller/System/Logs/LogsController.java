package org.app.controller.System.Logs;


import lombok.RequiredArgsConstructor;
import org.app.Annotation.Auth;
import org.app.service.System.SystemLoginLogService;
import org.app.service.System.SystemOperLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 日志控制器
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/system/logs")
@Auth
class LogsController {
    /**
     * 登录日志服务
     */
    @Autowired
    protected SystemLoginLogService loginLogService;

    /**
     * 操作日志服务
     */
    @Autowired
    protected SystemOperLogService operaLogService;

}
