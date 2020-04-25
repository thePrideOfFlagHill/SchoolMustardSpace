package com.springboot.service;

import com.springboot.utils.filetool.ServiceException;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface FileUpAndDownService {

    Map<String, Object> uploadPicture(MultipartFile file) throws ServiceException;

}