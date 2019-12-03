package com.cpy.onsiteinform.mngapi.cpy.controller;

import com.cpy.onsiteinform.framework.ApiResponse;
import com.cpy.onsiteinform.framework.BaseController;
import com.cpy.onsiteinform.util.UploadUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Carl
 * @ClassName UploadController
 * @Description
 * @date 2019-11-13 21:58
 **/
@Api("上传")
@RestController
@RequestMapping("mng/api/cpyUpload")
public class UploadController extends BaseController {

    /**
     * 上传
     */
    @ApiOperation("上传")
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public ApiResponse<String> uploadFile(@RequestParam("file") MultipartFile file) {
        String upload = UploadUtil.htmlUpload(file);
        return success(upload);
    }
}
