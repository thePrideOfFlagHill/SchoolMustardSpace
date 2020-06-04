package com.springboot.controller;

import com.springboot.service.FileUpAndDownService;
import com.springboot.service.LostAndFoundService;
import com.springboot.service.RentalOfGoodService;
import com.springboot.service.TaskService;
import com.springboot.utils.filetool.IStatusMessage;
import com.springboot.utils.filetool.ResponseResult;
import com.springboot.utils.filetool.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;


/**
 * FileUploadController
 * TODO
 * @description 所有的涉及文件流请求的接口
 * 这个模块暂时留空给221701412_theTuring最后处理
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.4.25
 */

@RestController
@CrossOrigin
@RequestMapping("/upload")
public class FileUploadController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadController.class);

    @Autowired
    private FileUpAndDownService fileUpAndDownService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private RentalOfGoodService rentalOfGoodService;

    @Autowired
    private LostAndFoundService lostAndFoundService;


    @RequestMapping(value = "/task/setFileUpload", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult setTaskFileUpload(@RequestParam(value = "file") MultipartFile file,
                                            @RequestParam(value = "id") String id) {

        ResponseResult result = new ResponseResult();
        try {
            Map<String, Object> resultMap = upload(file);
            if (!IStatusMessage.SystemStatus.SUCCESS.getMessage().equals(resultMap.get("result"))) {
                result.setCode(IStatusMessage.SystemStatus.PARAM.getCode());
                result.setMessage((String) resultMap.get("msg"));
                return result;
            }

            //图片上传成功即更新数据库对应的图片地址
            taskService.updateTaskImageUrl(resultMap.get("path").toString(),id);

            result.setData(resultMap);

        } catch (ServiceException e) {
            e.printStackTrace();
            LOGGER.error(">>>>>>图片上传异常，e={}", e.getMessage());
            result.setCode(IStatusMessage.SystemStatus.ERROR.getCode());
            result.setMessage(IStatusMessage.SystemStatus.ERROR.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/good/setFileUpload", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult setGoodFileUpload(@RequestParam(value = "file") MultipartFile file,
                                            @RequestParam(value = "id") String id) {

        ResponseResult result = new ResponseResult();
        try {
            Map<String, Object> resultMap = upload(file);
            if (!IStatusMessage.SystemStatus.SUCCESS.getMessage().equals(resultMap.get("result"))) {
                result.setCode(IStatusMessage.SystemStatus.PARAM.getCode());
                result.setMessage((String) resultMap.get("msg"));
                return result;
            }

            //图片上传成功即更新数据库对应的图片地址
            rentalOfGoodService.updateImg(resultMap.get("path").toString(),id);

            result.setData(resultMap);

        } catch (ServiceException e) {
            e.printStackTrace();
            LOGGER.error(">>>>>>图片上传异常，e={}", e.getMessage());
            result.setCode(IStatusMessage.SystemStatus.ERROR.getCode());
            result.setMessage(IStatusMessage.SystemStatus.ERROR.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/lostfound/setFileUpload", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult setLostFoundFileUpload(@RequestParam(value = "file") MultipartFile file,
                                                 @RequestParam(value = "id") String id) {

        ResponseResult result = new ResponseResult();
        try {
            Map<String, Object> resultMap = upload(file);
            if (!IStatusMessage.SystemStatus.SUCCESS.getMessage().equals(resultMap.get("result"))) {
                result.setCode(IStatusMessage.SystemStatus.PARAM.getCode());
                result.setMessage((String) resultMap.get("msg"));
                return result;
            }

            //图片上传成功即更新数据库对应的图片地址
            lostAndFoundService.updateImg(resultMap.get("path").toString(),id);

            result.setData(resultMap);

        } catch (ServiceException e) {
            e.printStackTrace();
            LOGGER.error(">>>>>>图片上传异常，e={}", e.getMessage());
            result.setCode(IStatusMessage.SystemStatus.ERROR.getCode());
            result.setMessage(IStatusMessage.SystemStatus.ERROR.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/task/setFilesUpload", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult setTaskFilesUpload(@RequestParam(value = "files") MultipartFile[] files,
                                             @RequestParam(value = "id") String id) {

        String tempPath = "";

        ResponseResult result = new ResponseResult();
        try {
            for(MultipartFile file : files){

                Map<String, Object> resultMap = upload(file);
                if (!IStatusMessage.SystemStatus.SUCCESS.getMessage().equals(resultMap.get("result"))) {
                    result.setCode(IStatusMessage.SystemStatus.PARAM.getCode());
                    result.setMessage((String) resultMap.get("msg"));
                    return result;
                }
                result.setData(resultMap);
                tempPath += resultMap.get("path").toString() + ",";
            }

            //图片上传成功即更新数据库对应的图片地址
            taskService.updateTaskImageUrl(tempPath,id);


        } catch (ServiceException e) {
            e.printStackTrace();
            LOGGER.error(">>>>>>图片上传异常，e={}", e.getMessage());
            result.setCode(IStatusMessage.SystemStatus.ERROR.getCode());
            result.setMessage(IStatusMessage.SystemStatus.ERROR.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/good/setFilesUpload", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult setGoodFilesUpload(@RequestParam(value = "files") MultipartFile[] files,
                                             @RequestParam(value = "id") String id) {

        String tempPath = "";

        ResponseResult result = new ResponseResult();
        try {
            for(MultipartFile file : files){

                Map<String, Object> resultMap = upload(file);
                if (!IStatusMessage.SystemStatus.SUCCESS.getMessage().equals(resultMap.get("result"))) {
                    result.setCode(IStatusMessage.SystemStatus.PARAM.getCode());
                    result.setMessage((String) resultMap.get("msg"));
                    return result;
                }
                result.setData(resultMap);
                tempPath += resultMap.get("path").toString() + ",";
            }

            //图片上传成功即更新数据库对应的图片地址
            taskService.updateTaskImageUrl(tempPath,id);

        } catch (ServiceException e) {
            e.printStackTrace();
            LOGGER.error(">>>>>>图片上传异常，e={}", e.getMessage());
            result.setCode(IStatusMessage.SystemStatus.ERROR.getCode());
            result.setMessage(IStatusMessage.SystemStatus.ERROR.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/lostfound/setFilesUpload", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult setLostFoundFilesUpload(@RequestParam(value = "file") MultipartFile[] files,
                                                  @RequestParam(value = "id") String id) {

        String tempPath = "";

        ResponseResult result = new ResponseResult();
        try {
            for(MultipartFile file : files){

                Map<String, Object> resultMap = upload(file);
                if (!IStatusMessage.SystemStatus.SUCCESS.getMessage().equals(resultMap.get("result"))) {
                    result.setCode(IStatusMessage.SystemStatus.PARAM.getCode());
                    result.setMessage((String) resultMap.get("msg"));
                    return result;
                }
                result.setData(resultMap);
                tempPath += resultMap.get("path").toString() + ",";
            }

            //图片上传成功即更新数据库对应的图片地址
            taskService.updateTaskImageUrl(tempPath,id);

        } catch (ServiceException e) {
            e.printStackTrace();
            LOGGER.error(">>>>>>图片上传异常，e={}", e.getMessage());
            result.setCode(IStatusMessage.SystemStatus.ERROR.getCode());
            result.setMessage(IStatusMessage.SystemStatus.ERROR.getMessage());
        }
        return result;
    }

    /**
     * 对于断点续传的一些思考
     */

    private Map<String, Object> upload(MultipartFile file) throws ServiceException {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        try {
            if (!file.isEmpty()) {
                Map<String, Object> picMap = fileUpAndDownService.uploadPicture(file);
                if (IStatusMessage.SystemStatus.SUCCESS.getMessage().equals(picMap.get("result"))) {
                    return picMap;
                } else {
                    returnMap.put("result", IStatusMessage.SystemStatus.ERROR.getMessage());
                    returnMap.put("msg", picMap.get("result"));
                }
            } else {
                LOGGER.info(">>>>>>上传图片为空文件");
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
