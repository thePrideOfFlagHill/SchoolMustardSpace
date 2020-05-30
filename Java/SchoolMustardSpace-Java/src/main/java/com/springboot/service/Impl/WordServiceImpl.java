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
        return 1;
    }

    public int deleteWordByInt(int id){
        return 1;
    }

    public int deleteWordByString(String something){
        return 1;
    }

    public List<Word> getWords(){
        return null;
    }

    public boolean checkRepeat(String word){
        return true;
    }

    public int updateWord(String word){
        return 1;
    }
}
