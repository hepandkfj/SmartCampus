package org.app.controller.System.DataCenter;


import lombok.RequiredArgsConstructor;
import org.app.Annotation.Auth;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/system/dataMaintain")
@Auth
class DataMaintainController {

}