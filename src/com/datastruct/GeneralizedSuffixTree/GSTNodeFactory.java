package com.datastruct.GeneralizedSuffixTree;

import java.util.ArrayList;

/**
 * Created by fred_chen on 11/9/15.
 */
public class GSTNodeFactory
{
    private static ArrayList<GSTNode[]> GSTNodePool;
    private static int SIZE;
    private static int row_num;
    private static int row;
    private static int col;
    private static final int MAX_COL = 20;

    static
    {
        GSTNodePool = new ArrayList<>();
        row = 0;
        col = 0;
        row_num = 0;
    }

    public static void initPool(int size)
    {
        SIZE = size;
        do
        {
            allocNodes();
            size -= MAX_COL;
        }while (size > 0);
    }

    public static void allocNodes()
    {
        GSTNodePool.add(new GSTNode[MAX_COL]);
        ++row_num;
    }

    public static GSTNode getNewNode()
    {
        GSTNode node2return = GSTNodePool.get(row)[col];
        if (++col == MAX_COL)
        {
            col = 0;
            if (++row == row_num)
            {
                allocNodes();
            }
        }

        return node2return;
    }
}
