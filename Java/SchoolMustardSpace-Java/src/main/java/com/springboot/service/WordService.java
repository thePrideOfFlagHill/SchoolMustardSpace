package com.springboot.service;

import com.springboot.domain.Word;

import java.util.List;

/**
 * @author 会飞的大野鸡
 * @create 2020/5/29
 * TODO:
 */

public interface WordService {
    String addWord(String word);

    String deleteWordByInt(int id);

    String deleteWordByString(int chioce , String something);

    List<Word> getWords();

    boolean checkRepeat(String word);

    String updateWord(String word , String newWord);
}
