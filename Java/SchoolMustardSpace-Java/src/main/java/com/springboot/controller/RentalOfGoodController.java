package com.springboot.controller;

import com.springboot.service.RentalOfGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 会飞的大野鸡
 * @create 2020/4/30
 * TODO:
 */

@RestController
@CrossOrigin
@RequestMapping("/api/goods")
public class RentalOfGoodController {
    @Autowired
    private RentalOfGoodService rentalOfGoodService;
    
}
