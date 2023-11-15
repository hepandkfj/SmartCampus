package org.app.controller.System.Monitor;


import lombok.RequiredArgsConstructor;
import org.app.Annotation.Auth;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 缓存监控
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/system/cache")
@Auth
class CacheMonitorController {
//    @Autowired
//    protected CacheMonitorService service;


}