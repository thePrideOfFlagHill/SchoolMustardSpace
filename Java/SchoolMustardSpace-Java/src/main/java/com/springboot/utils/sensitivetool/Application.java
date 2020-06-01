package com.springboot.utils.sensitivetool;

import com.springboot.domain.Word;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 会飞的大野鸡
 * @create 2020/6/1
 * TODO:
 */

public class Application {
    public static void main(String[] args){
        Set<Word> kws1 = new HashSet<Word>();
        kws1.add(new Word("黄色"));
        kws1.add(new Word("AV"));
        WordSeeker kwSeeker1 = new WordSeeker(kws1);
        String text1 = "这是一部黄色电影，也是一部AV电影";
        String r1 = kwSeeker1.replaceWords(text1);
        System.out.println("字符替换：" + r1);
        System.out.println(new Word("黄色"));
    }
}
