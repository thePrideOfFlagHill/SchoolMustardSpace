package com.springboot.service.Impl;

import com.springboot.domain.Word;
import com.springboot.mapper.WordMapper;
import com.springboot.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.List;

/**
 * @author 会飞的大野鸡
 * @create 2020/5/29
 * TODO:
 */

@Service
public class WordServiceImpl implements WordService {

    @Autowired
    private WordMapper wordMapper;

    public int addWord(String word){
        return wordMapper.addWord(word);
    }

    public int deleteWordByInt(int id){
        return wordMapper.deleteById(id);
    }

    public int deleteWordByString(int chioce ,String something){
        if (chioce == 1){
            return wordMapper.deleteByWord(something);
        }
        if (chioce == 2){
            return wordMapper.deleteByType(something);
        }
        return 0;
    }

    public List<Word> getWords(){
        return wordMapper.getWords();
    }

    public boolean checkRepeat(String word){
        return wordMapper.checkRepeat(word);
    }

    public int updateWord(String word , String newWord){
        return wordMapper.updateWord(word , newWord);
    }
}
