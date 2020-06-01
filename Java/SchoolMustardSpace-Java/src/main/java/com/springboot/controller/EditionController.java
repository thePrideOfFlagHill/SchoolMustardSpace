package com.springboot.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 会飞的大野鸡
 * @create 2020/6/1
 * TODO:
 */

@RestController
@CrossOrigin
@RequestMapping("/api/edition")
public class EditionController {
    private static String oldEdition = null;
    private static String newEdition = null;
}
