package org.app.controller.System.DataCenter;

import lombok.RequiredArgsConstructor;
import org.app.Annotation.Auth;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 信息管理控制器
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/system/queueMessage")
@Auth
class QueueMessageController {

}
