package org.app.controller.System.Monitor;


import lombok.RequiredArgsConstructor;
import org.app.Annotation.Auth;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 服务器监控
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/system/server")
@Auth
class ServerMonitorController {

//    @Autowired
//    protected SystemMonitorService service;

    /**
     * 获取服务器信息
     */

}