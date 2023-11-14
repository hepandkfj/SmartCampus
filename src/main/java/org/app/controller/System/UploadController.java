package org.app.controller.System;


import org.app.Annotation.OperationLog;
import lombok.RequiredArgsConstructor;
import org.app.Annotation.RBody;
import org.app.service.System.UploadFileService;
import org.app.ValidaGroups.ImageR;
import org.app.request.UploadRequest;
import org.app.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 后台 - 文件上传控制器
 *
 * @author HJS
 * @date 2023/09/23
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/system")
//@Auth
@Validated
public class UploadController {

    @Autowired
    private UploadFileService service;

    /**
     * 上传文件
     *
     * @return
     */
    @PostMapping("uploadFile")
    @OperationLog("上传文件")
    public Object uploadFile() {
        return Result.success();
    }

    /**
     * 上传图片
     */
    @PostMapping("uploadImage")
    @OperationLog("上传图片")
    public Object uploadImage(@Validated(ImageR.class) @RBody UploadRequest param) {
        return service.upload(param.getImage(), param.getPath());
    }

    /**
     * 分块上传
     */
    @PostMapping("chunkUpload")
    @OperationLog("分块上传")
    public Object chunkUpload() {
        return Result.success();
    }

    /**
     * 保存网络图片
     */
    @PostMapping("saveNetworkImage")
    @OperationLog("保存网络图片")
    public Object saveNetworkImage() {
        return Result.success();
    }

    /**
     * 获取当前目录所有文件和目录
     *
     * @return
     */
    @GetMapping("getAllFiles")
    public Object getAllFiles() {
        return Result.success();
    }

    /**
     * 通过ID获取文件信息
     *
     * @return
     */
    @GetMapping("getFileInfoById")
    public Object getFileInfoById() {
        return Result.success();
    }

    /**
     * 通过HASH获取文件信息
     *
     * @return
     */
    @GetMapping("getFileInfoByHash")
    public Object getFileInfoByHash() {
        return Result.success();
    }

    /**
     * 根据id下载文件
     *
     * @return
     */
    @GetMapping("downloadById")
    public Object downloadById() {
        return Result.success();
    }

    /**
     * 根据hash下载文件
     *
     * @return
     */
    @GetMapping("downloadByHash")
    public Object downloadByHash() {
        return Result.success();
    }


}
