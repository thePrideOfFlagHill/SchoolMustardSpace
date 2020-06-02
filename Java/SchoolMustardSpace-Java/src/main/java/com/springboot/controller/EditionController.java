package com.springboot.controller;

import com.springboot.service.FileUpAndDownService;
import com.springboot.utils.filetool.IStatusMessage;
import com.springboot.utils.filetool.ResponseResult;
import com.springboot.utils.filetool.ServiceException;
import com.springboot.utils.jsontool.JsonResult;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 会飞的大野鸡
 * @create 2020/6/1
 * TODO:
 */

@RestController
@CrossOrigin
@RequestMapping("/api/edition")
public class EditionController {
    private static String edition = null;
    private static String path = null;

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadController.class);

    @Autowired
    private FileUpAndDownService fileUpAndDownService;

    /**
     * 上传安卓文件并设置版本号
     * @param file
     * @param newEdition
     * @return
     */
    @PostMapping("/upload")
    public ResponseResult uploadd(@RequestParam("file")MultipartFile file , @RequestParam("edition")String newEdition) throws ServiceException {
        ResponseResult result = new ResponseResult();
        try {
            Map<String, Object> resultMap = upload(file);
            if (!IStatusMessage.SystemStatus.SUCCESS.getMessage().equals(resultMap.get("result"))) {
                result.setCode(IStatusMessage.SystemStatus.PARAM.getCode());
                result.setMessage((String) resultMap.get("msg"));
                return result;
            }
            result.setData(resultMap);
            path = (String) result.getData().get("path");
            edition = newEdition;

        } catch (ServiceException e) {
            e.printStackTrace();
            LOGGER.error(">>>>>>文件上传异常，e={}", e.getMessage());
            result.setCode(IStatusMessage.SystemStatus.ERROR.getCode());
            result.setMessage(IStatusMessage.SystemStatus.ERROR.getMessage());
        }

        return result;
    }

    @GetMapping("/getEdition")
    public JsonResult newEdition(){
        return JsonResult.build(200, "succeed" , edition);
    }

    /**
     * 检查版本号是否一致，不一致时返回下载地址
     * @param newEdition
     * @return
     */
    @GetMapping("/checkForNew")
    public JsonResult check(@RequestParam("edition")String newEdition){
        String edi = edition;
        System.out.println(edi);
        if (!newEdition.equals(edi)){
            return JsonResult.build( 100, "update" , path);
        }
        return JsonResult.build(200 , "updated" , null);
    }

    @GetMapping("/t")
    public JsonResult chec(@RequestParam("edition")String newEdition){
        return JsonResult.build(200 , newEdition , edition);
    }



    private Map<String, Object> upload(MultipartFile file) throws ServiceException {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        try {
            if (!file.isEmpty()) {
                Map<String, Object> picMap = fileUpAndDownService.uploadPicture2(file);
                if (IStatusMessage.SystemStatus.SUCCESS.getMessage().equals(picMap.get("result"))) {
                    return picMap;
                } else {
                    returnMap.put("result", IStatusMessage.SystemStatus.ERROR.getMessage());
                    returnMap.put("msg", picMap.get("result"));
                }
            } else {
                LOGGER.info(">>>>>>上传文件为空文件");
                returnMap.put("result", IStatusMessage.SystemStatus.FILE_UPLOAD_NULL.getMessage());
                returnMap.put("msg", IStatusMessage.SystemStatus.FILE_UPLOAD_NULL.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException(IStatusMessage.SystemStatus.ERROR.getMessage());
        }
        return returnMap;
    }

}
