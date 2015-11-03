package com.datastruct.TrieTree;

/**
 * Created by fred_chen on 10/26/15.
 */
public class TrieTree
{
    private TrieTreeNode root;

    public TrieTree()
    {
        this.root = new TrieTreeNode();
    }

    public void insert(String s)
    {
        TrieTreeNode node = root;
        for(Character c: s.toCharArray())
        {
            if (!node.hasChild(c))
            {
                node.addChild(c);
            }

            node = node.getChild(c);
        }

        node.addReference();
    }

    public int search(String s)
    {
        TrieTreeNode node = root;
        boolean isFind = true;
        for(Character c: s.toCharArray())
        {
            if (!node.hasChild(c))
            {
                isFind = false;
                break;
            }
            else
            {
                node = node.getChild(c);
            }
        }

        if (isFind)
        {
            return node.getReference();
        }
        else
        {
            return -1;
        }
    }
}
