package com.datastruct.SuffixTree;

import java.util.ArrayList;

/**
 * Created by fred_chen on 10/26/15.
 */
public class SuffixTree
{
    private String text;
    private ArrayList<SuffixTreeNode> tree;
    private int current_index;
    private SuffixTreeNode root;
    private int endIndex;

    public SuffixTree(SuffixTreeNode root)
    {
        this.root = root;
        root.setIndexInArray(0);
        current_index = 1;
        tree.add(root);
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public SuffixTreeNode getRoot()
    {
        return root;
    }

    public SuffixTreeNode insertNewNode(int begin, int end, int textId)
    {
        tree.add(new SuffixTreeNode(begin, end, textId));
        ++current_index;
        root.setIndexInArray(current_index);
        return tree.get(current_index);
    }

    public SuffixTreeNode getNodeByIndex(int index)
    {
        if ( index > current_index && index < 0)
        {
            return null;
        }
        else
        {
            return tree.get(index);
        }
    }

}
