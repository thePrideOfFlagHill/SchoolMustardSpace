package com.springboot.service.Impl;

import com.springboot.constant.Constant;
import com.springboot.domain.Word;
import com.springboot.mapper.WordMapper;
import com.springboot.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 会飞的大野鸡
 * @create 2020/5/29
 * TODO:
 */

@Service
public class WordServiceImpl implements WordService ,Constant {

    @Autowired
    private WordMapper wordMapper;

    public String addWord(String word){
        return wordMapper.addWord(word) == 1 ? Constant.MSG_SUCCEED : Constant.MSG_FAIL;
    }

    public String deleteWordByInt(int id){
        return wordMapper.deleteById(id) == 1 ? Constant.MSG_SUCCEED : Constant.MSG_FAIL;
    }

    public String deleteWordByString(int chioce ,String something){
        if (chioce == 1){
            return wordMapper.deleteByWord(something) == 1 ? Constant.MSG_SUCCEED : Constant.MSG_FAIL;
        }
        if (chioce == 2){
            return wordMapper.deleteByType(something) == 1 ? Constant.MSG_SUCCEED : Constant.MSG_FAIL;
        }
        return null;
    }

    public List<Word> getWords(){
        return wordMapper.getWords();
    }

    public boolean checkRepeat(String word){
        return wordMapper.checkRepeat(word);
    }

    public String updateWord(String word , String newWord){
        return wordMapper.updateWord(word , newWord) == 1 ? Constant.MSG_SUCCEED : Constant.MSG_FAIL;
    }
}
