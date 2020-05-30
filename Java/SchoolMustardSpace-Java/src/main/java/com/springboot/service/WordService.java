package com.springboot.service;

import com.springboot.domain.Word;

import java.util.List;

/**
 * @author 会飞的大野鸡
 * @create 2020/5/29
 * TODO:
 */

public interface WordService {
    int addWord(String word);

    int deleteWordByInt(int id);

    int deleteWordByString(int chioce , String something);

    List<Word> getWords();

    boolean checkRepeat(String word);

    int updateWord(String word , String newWord);
}
