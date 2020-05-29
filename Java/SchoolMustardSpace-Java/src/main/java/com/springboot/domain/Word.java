package com.springboot.domain;

/**
 * @author 会飞的大野鸡
 * @create 2020/5/28
 * TODO:
 */

public class Word {
    private int id;
    private String type = null;
    private String word;
    private String pre = null;
    private String sufix = null;
    private int wordLength = 0;

    public Word(){}

    public Word(String word) {
        this.word = word;
        this.wordLength = word.length();
    }
    public Word(String word, String pre, String sufix) {
        this(word);
        this.pre = pre;
        this.sufix = sufix;
    }

    public Word(String word , String type , int id){
        this.id = id;
        this.word = word;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getWordLength() {
        return wordLength;
    }

    public void setWordLength(int wordLength) {
        this.wordLength = wordLength;
    }

    public String getPre() {
        return pre;
    }

    public void setPre(String pre) {
        this.pre = pre;
    }

    public String getSufix() {
        return sufix;
    }

    public void setSufix(String sufix) {
        this.sufix = sufix;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((word == null) ? 0 : word.hashCode());
        result = prime * result + wordLength;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Word other = (Word) obj;
        if (word == null) {
            if (other.word != null)
                return false;
        } else if (!word.equals(other.word))
            return false;
        if (wordLength != other.wordLength)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "KeyWord [word=" + word + ", wordLength=" + wordLength + "]";
    }
}
