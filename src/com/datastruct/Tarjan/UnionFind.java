package com.datastruct.Tarjan;

/**
 * Created by fred_chen on 11/2/15.
 */
public class UnionFind
{
    private int father[];
    private int count;

    public UnionFind(int count)
    {
        this.count = count;
        this.father = new int[count];
        init();
    }

    private void init()
    {
        for(int i = 0; i < count; ++i)
        {
            father[i] = i;
        }
    }

    public int find(int x)
    {
        if (x >=0 && x <count)
        {
            return father[x];
        }
        else
        {
            return -1;
        }
    }
}
