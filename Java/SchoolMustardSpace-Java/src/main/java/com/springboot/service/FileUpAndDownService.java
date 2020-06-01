package com.springboot.service;

import com.springboot.utils.filetool.ServiceException;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * FileUpAndDownService
 * TODO
 * @description FileUpAndDownService
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.4.25
 */
public interface FileUpAndDownService {

    Map<String, Object> uploadPicture(MultipartFile file) throws ServiceException;

    Map<String, Object> uploadPicture2(MultipartFile file) throws ServiceException;
}