package com.datastruct.GeneralizedSuffixTree;

import java.util.HashMap;

/**
 * Created by fred_chen on 11/9/15.
 */
public class GSTNode
{
    private boolean isRoot;
    private GSTNode suffixLink;
    private HashMap<Integer, StringPiece> pieces;
    private HashMap<Character, GSTNode> children;

    public GSTNode()
    {
        isRoot = false;
        suffixLink = null;
        pieces = null;
        children = null;
    }

    public int addStringPiece(Integer id, StringPiece p)
    {
        int ret = 0;
        if (pieces == null)
        {
            pieces = new HashMap<>();
        }

        if (!pieces.containsKey(id))
        {
            pieces.put(id, p);
        }
        else
        {
            ret = -1;
        }

        return ret;
    }

    public GSTNode getSuffixLink()
    {
        return suffixLink;
    }

    public void setSuffixLink(GSTNode suffixLink)
    {
        this.suffixLink = suffixLink;
    }

    public boolean isRoot()
    {
        return isRoot;
    }

    public void setIsRoot(boolean isRoot)
    {
        this.isRoot = isRoot;
    }

    public HashMap<Integer, StringPiece> getPieces()
    {
        return pieces;
    }

    public void setPieces(HashMap<Integer, StringPiece> pieces)
    {
        this.pieces = pieces;
    }

    public HashMap<Character, GSTNode> getChildren()
    {
        return children;
    }

    public void setChildren(HashMap<Character, GSTNode> children)
    {
        this.children = children;
    }

    public void splitAt(int len) throws CloneNotSupportedException
    {
        GSTNode newNode = new GSTNode();

        Character c = null;

        for(Integer i: pieces.keySet())
        {
            StringPiece p = pieces.get(i);
            int splitPoint = p.getBegin() + len;
            if (c == null)
            {
                c = p.getCharAt(splitPoint);
            }
            StringPiece np = (StringPiece)p.clone();
            p.setBegin(splitPoint);
            np.setBegin(splitPoint);

            newNode.addStringPiece(i, np);
        }

        newNode.setChildren(children);
        children = new HashMap<>();
        children.put(c, newNode);

    }
}
