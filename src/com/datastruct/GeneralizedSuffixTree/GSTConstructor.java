package com.datastruct.GeneralizedSuffixTree;

/**
 * Created by fred_chen on 11/9/15.
 */
public class GSTConstructor
{
    private GSTNode needSuffixLinkNode;
    private TripleTuple tuple;
    private int position;
    private int reminder;

    public GSTConstructor()
    {
        needSuffixLinkNode = null;
        tuple = new TripleTuple();
        position = 0;
        reminder = 0;
    }

    class TripleTuple
    {
        public GSTNode activeNode;
        public Character activeEdge;
        public int activeLength;
    }
}
