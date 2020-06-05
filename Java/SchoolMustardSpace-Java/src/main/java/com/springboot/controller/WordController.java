package com.springboot.controller;

import com.springboot.constant.Constant;
import com.springboot.domain.Word;
import com.springboot.service.WordService;
import com.springboot.utils.jsontool.JsonResult;
import com.springboot.utils.sensitivetool.WordSeeker;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 会飞的大野鸡
 * @create 2020/5/29
 * TODO:
 */

@RestController
@CrossOrigin
@RequestMapping("/api/words")
public class WordController {
    public static WordSeeker wordSeeker;

    @Autowired
    private WordService wordService;

    @GetMapping("/setWords")
    public void setWordSeeker(){
        Set<Word> kws1 = new HashSet<Word>();
        List<Word> words = wordService.getWords();
        for (int i = 0 ; i < words.size() ; i++){
            kws1.add(words.get(i));
        }
        wordSeeker = new WordSeeker(kws1);
    }

    @GetMapping("/query/all")
    public JsonResult getWords(){
        List<Word> words = wordService.getWords();
        return JsonResult.build(200 , "succeed" , words);
    }

    @PostMapping("/delete/id")
    public JsonResult deleteById(@RequestBody Map<String , String> resMap){
        String msg = wordService.deleteWordByInt(Integer.parseInt(resMap.get("id")));
        if(msg.equals("succeed")){
            return JsonResult.build(200,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @PostMapping("/delete/type")
    public JsonResult deleteByType(@RequestBody Map<String , String> resMap){
        String msg = wordService.deleteWordByString(2 , resMap.get("type").toString());
        if(msg.equals("succeed")){
            return JsonResult.build(200,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @PostMapping("/delete/word")
    public JsonResult deleteByWord(@RequestBody Map<String , String> resMap){
        String msg = wordService.deleteWordByString(1 , resMap.get("word").toString());
        if(msg.equals("succeed")){
            return JsonResult.build(200,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @GetMapping("/insert")
    public JsonResult addWords(@Param("word")String word){
        boolean exist = wordService.checkRepeat(word);
        if (exist){
            return JsonResult.errorMsg(Constant.MSG_FAIL);
        }
        String msg = wordService.addWord(word);
        if(msg.equals("succeed")){
            return JsonResult.build(200,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }

    @PostMapping("/update")
    public JsonResult update(@RequestBody Map<String , String> resMap){
        String word = resMap.get("word");
        String newWord = resMap.get("newWord");
        String msg = wordService.updateWord(word , newWord);
        if(msg.equals("succeed")){
            return JsonResult.build(200,msg,null);
        }
        else return JsonResult.errorMsg(msg);
    }
}
