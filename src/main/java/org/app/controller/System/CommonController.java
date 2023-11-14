package org.app.controller.System;


import org.app.response.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * 公共方法控制器
 *
 * @author HJS
 * @date 2023/09/23
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/system/common")
public class CommonController {


    @GetMapping("getNoticeList")
    public Object getNoticeList() {


        return new ArrayList<>();
    }

    @GetMapping("clearAllCache")
    public Result<?> clearAllCache() {
        return Result.success();
    }


}
