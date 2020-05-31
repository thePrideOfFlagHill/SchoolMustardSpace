package com.springboot.utils.sensitivetool;

import com.springboot.domain.Word;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * @author 会飞的大野鸡
 * @create 2020/5/31
 * TODO:
 */

public class WordUtil {

    public static Word getKeyWord(String word, Map<String, Object> endTag) {
        Word tmp = new Word(word);
        return tmp;
    }

    public static Map<String, Map> makeTreeByWord(Map<String, Map> tree, String word,
                                                  Word KeyWord) {
        if (StringUtils.isEmpty(word)) {
            tree.putAll(EndTagUtil.buind(KeyWord));
            return tree;
        }
        String next = word.substring(0, 1);
        Map<String, Map> nextTree = tree.get(next);
        if (nextTree == null) {
            nextTree = new HashMap<String, Map>();
        }
        // 递归构造树结构
        tree.put(next, makeTreeByWord(nextTree, word.substring(1), KeyWord));
        return tree;
    }

    private static Word checkPattern(Word kw, String pre, String sufix) {
        if (StringUtils.isNotBlank(kw.getPre()) && StringUtils.isNotBlank(kw.getSufix())) {
            if (null == pre || null == sufix) {
                return null;
            }
            if (!pre.matches(kw.getPre()) || !sufix.matches(kw.getSufix())) {
                return null;
            }
        } else if (StringUtils.isNotBlank(kw.getPre()) && StringUtils.isBlank(kw.getSufix())) {
            if (null == pre) {
                return null;
            }
            if (!pre.matches(kw.getPre())) {
                return null;
            }
        } else if (StringUtils.isBlank(kw.getPre()) && StringUtils.isNotBlank(kw.getSufix())) {
            if (null == sufix) {
                return null;
            }
            if (!sufix.matches(kw.getSufix())) {
                return null;
            }
        }
        return kw;
    }

    public static Word getSensitiveWord(String append, String pre,
                                           Map<String, Map> nextWordsTree, String text) {
        if (nextWordsTree == null || nextWordsTree.isEmpty()) {
            return null;
        }

        Map<String, Object> endTag = nextWordsTree.get(EndTagUtil.TREE_END_TAG);
        // 原始文本已到末尾
        if (StringUtils.isEmpty(text)) {
            // 如果有结束符，则表示匹配成功，没有，则返回null
            if (endTag != null) {
                return checkPattern(getKeyWord(append, endTag), pre, null);
            } else {
                return null;
            }
        }

        String next = text.substring(0, 1);
        String suffix = text.substring(0, 1);
        Map<String, Map> nextTree = nextWordsTree.get(next);

        // 没有遇到endTag，继续匹配
        if (endTag == null) {
            if (nextTree != null && nextTree.size() > 0) {
                // 没有结束标志，则表示关键词没有结束，继续往下走。
                return getSensitiveWord(append + next, pre, nextTree, text.substring(1));
            }

            // 如果没有下一个匹配的字，表示匹配结束！
            return null;
        }

        // 有下一个匹配的词则继续匹配，一直取到最大的匹配关键字
        Word tmp = null;
        if (nextTree != null && nextTree.size() > 0) {
            // 如果大于0，则表示还有更长的词，继续往下找
            tmp = getSensitiveWord(append + next, pre, nextTree, text.substring(1));
            if (tmp == null) {
                // 没有更长的词，则就返回这个词。在返回之前，先判断它是模糊的，还是精确的
                tmp = getKeyWord(append, endTag);
            }
            return checkPattern(tmp, pre, suffix);
        }

        // 没有往下的词了，返回该关键词。
        return checkPattern(getKeyWord(append, endTag), pre, suffix);

    }


    static class EndTagUtil implements Serializable {
        public static final String TREE_END_TAG = "end";

        public static Map<String, Map> buind(Word KeyWord) {
            Map<String, Map> endTag = new HashMap<String, Map>();
            endTag.put(TREE_END_TAG, new HashMap<String, String>());
            return endTag;
        }

    }


}
