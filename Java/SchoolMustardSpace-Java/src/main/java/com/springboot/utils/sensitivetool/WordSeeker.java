package com.springboot.utils.sensitivetool;

import com.springboot.domain.Word;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 会飞的大野鸡
 * @create 2020/5/31
 * TODO:
 */

public class WordSeeker {
    private Set<Word> sensitiveWords;

    private Map<String, Map> wordsTree = new ConcurrentHashMap<String, Map>();

    private int wordLeastLen = 0;

    public WordSeeker(Set<Word> sensitiveWords) {
        this.sensitiveWords = sensitiveWords;
        reloadKWSeeker();
    }

    public void reloadKWSeeker() {
        wordLeastLen = new DataInit().generalTree(sensitiveWords, wordsTree);
    }

    public void addWord(Word... newWord) {
        if (newWord != null && newWord.length > 0) {
            for (Word kw : newWord) {
                if (StringUtils.isNotEmpty(kw.getWord())) {
                    sensitiveWords.add(kw);
                }
            }
            reloadKWSeeker();
        }
    }

    public void clear() {
        sensitiveWords.clear();
        reloadKWSeeker();
    }

    public boolean contains(String word) {
        if (sensitiveWords.isEmpty() || StringUtils.isEmpty(word)) {
            return false;
        }
        return sensitiveWords.contains(word);
    }

    public int size() {
        return sensitiveWords == null ? 0 : sensitiveWords.size();
    }

    public boolean remove(String word) {
        if (sensitiveWords.isEmpty() || StringUtils.isEmpty(word)) {
            return false;
        }
        return sensitiveWords.remove(new Word(word));
    }

    public String replaceWords(String text) {
        return process(wordsTree, text ,wordLeastLen);
    }

    public String process(Map<String, Map> wordsTree, String text,
                          int minLen) {
        StringBuffer result = new StringBuffer("");
        String pre = null;// 词的前面一个字
        while (true) {
            if (wordsTree == null || wordsTree.isEmpty() || StringUtils.isEmpty(text)) {
                return result.append(text).toString();
            }
            if (text.length() < minLen) {
                return result.append(text).toString();
            }
            String chr = text.substring(0, 1);
            text = text.substring(1);
            Map<String, Map> nextWord = wordsTree.get(chr);
            // 没有对应的下一个字，表示这不是关键词的开头，进行下一个循环
            if (nextWord == null) {
                result.append(chr);
                pre = chr;
                continue;
            }

            Word kw = WordUtil.getSensitiveWord(chr, pre, nextWord, text);
            // 没有匹配到完整关键字，下一个循环
            if (kw == null) {
                result.append(chr);
                pre = chr;
                continue;
            }

            // 处理片段
            result.append("***");
            // 从text中去除当前已经匹配的内容，进行下一个循环匹配
            text = text.substring(kw.getWordLength() - 1);
            pre = kw.getWord().substring(kw.getWordLength() - 1, kw.getWordLength());
            continue;
        }
    }


    private static class DataInit {

        /**
         * 生成的临时词库树。用于在最后生成的时候一次性替换，尽量减少对正在查询时的干扰
         */
        private Map<String, Map> wordsTreeTmp = new HashMap<String, Map>();

        public int generalTree(Set<Word> sensitiveWords, Map<String, Map> wordsTree) {
            if (sensitiveWords == null || sensitiveWords.isEmpty() || wordsTree == null) {
                return 0;
            }

            wordsTreeTmp.clear();
            int len = 0;
            for (Word kw : sensitiveWords) {
                if (len == 0) {
                    len = kw.getWordLength();
                } else if (kw.getWordLength() < len) {
                    len = kw.getWordLength();
                }
                WordUtil
                        .makeTreeByWord(wordsTreeTmp, StringUtils.trimToEmpty(kw.getWord()), kw);
            }
            wordsTree.clear();
            wordsTree.putAll(wordsTreeTmp);
            return len;
        }
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "KWSeeker [sensitiveWords=" + sensitiveWords + ", wordsTree=" + wordsTree
                + ", wordLeastLen=" + wordLeastLen + "]";
    }
}
