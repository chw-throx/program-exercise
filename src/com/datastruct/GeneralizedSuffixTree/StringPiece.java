package com.datastruct.GeneralizedSuffixTree;

/**
 * Created by fred_chen on 11/6/15.
 */
public class StringPiece
{

    private String text;
    private int begin;
    private int end;

    public StringPiece(String text, int begin, int end)
    {
        this.text = text;
        this.begin = begin;
        this.end = end;
    }

    public char getCharAt(int index)
    {
        return text.charAt(index);
    }

    public int getLength()
    {
        if (end != -1)
        {
            return end - begin;
        }
        else
        {
            return Integer.MAX_VALUE;
        }
    }

    public String getText()
    {
        return text.substring(begin, end);
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public int getBegin()
    {
        return begin;
    }

    public void setBegin(int begin)
    {
        this.begin = begin;
    }

    public int getEnd()
    {
        return end;
    }

    public void setEnd(int end)
    {
        this.end = end;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return (StringPiece)super.clone();
    }
}
