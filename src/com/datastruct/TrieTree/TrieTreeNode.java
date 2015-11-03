package com.datastruct.TrieTree;

import java.util.HashMap;

/**
 * Created by fred_chen on 10/26/15.
 */
public class TrieTreeNode
{
    private boolean isKey;
    private int count;
    private HashMap<Character, TrieTreeNode> children;

    public TrieTreeNode()
    {
        this.isKey = false;
        this.count = 0;
        this.children = new HashMap<>();
    }

    public boolean hasChild(Character c)
    {
        if (children.containsKey(c))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void addChild(Character c)
    {
        if (!hasChild(c))
        {
            children.put(c, new TrieTreeNode());
        }
    }

    public TrieTreeNode getChild(Character c)
    {
        if (hasChild(c))
        {
            return children.get(c);
        }
        else
        {
            return null;
        }
    }

    public int addReference()
    {
        return ++count;
    }

    public int getReference()
    {
        return count;
    }


}
