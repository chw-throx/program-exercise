package com.datastruct.SuffixTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by fred_chen on 10/27/15.
 */
public class SuffixTreeNode
{
    private boolean isRoot;
    private int indexInArray;
    private SuffixTreeNode suffixLink;
    private int begin;
    private int end;
    private HashMap<Character, Integer> children;

    class TextFragment
    {
        public int begin;
        public int end;
        public int textId;

        public TextFragment(int begin, int end, int textId)
        {
            this.begin = begin;
            this.end = end;
            this.textId = textId;
        }
    }

    public SuffixTreeNode()
    {
        init();
        reSet(-1, -1);
    }

    public SuffixTreeNode(int beginIndex, int endIndex)
    {
        init();
        reSet(beginIndex, endIndex);
    }

    private void init()
    {
        this.isRoot = false;
        this.suffixLink = null;
        this.children = new HashMap<>();
    }

    public int getIndexInArray()
    {
        return indexInArray;
    }

    public void setIndexInArray(int indexInArray)
    {
        this.indexInArray = indexInArray;
    }

    public void reSet(int begin, int end)
    {
        this.begin = begin;
        this.end = end;
    }

    public boolean addChild(Character c, int index)
    {
        if (children.containsKey(c))
        {
            return false;
        }
        else
        {
            this.children.put(c, index);
            return true;
        }
    }

    public boolean containsKeys(Character c)
    {
        return children.containsKey(c);
    }

    public int getNode(Character c)
    {
        if (children.containsKey(c))
        {
            return children.get(c);
        }
        else
        {
            return -1;
        }
    }

    public void setSuffixLink(SuffixTreeNode node)
    {
        this.suffixLink = node;
    }

    public SuffixTreeNode getSuffixLink()
    {
        return suffixLink;
    }

    public SuffixTreeNode setRoot()
    {
        this.isRoot = true;
        return this;
    }

    public boolean isRoot()
    {
        return isRoot;
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
}
