package com.datastruct.BinaryTree;

/**
 * Created by fred_chen on 7/3/15.
 */
public class BinaryTreeNode
{
    private Object obj;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode()
    {
        obj = null;
        left = null;
        right = null;
    }

    public Object getObj()
    {
        return obj;
    }

    public void setObj(Object obj)
    {
        this.obj = obj;
    }

    public BinaryTreeNode getLeft()
    {
        return left;
    }

    public void setLeft(BinaryTreeNode left)
    {
        this.left = left;
    }

    public BinaryTreeNode getRight()
    {
        return right;
    }

    public void setRight(BinaryTreeNode right)
    {
        this.right = right;
    }
}
