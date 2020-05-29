package com.springboot.controller;

import com.springboot.domain.Word;
import com.springboot.mapper.WordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 会飞的大野鸡
 * @create 2020/5/29
 * TODO:
 */

@RestController
@CrossOrigin
@RequestMapping("/api")
public class WordController {
    @Autowired
    private WordMapper wordMapper;

    @GetMapping("/words")
    public void a(){
        List<Word> words = wordMapper.getWords();
        System.out.println(words);
    }
}
