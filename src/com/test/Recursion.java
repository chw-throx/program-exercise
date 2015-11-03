package com.test;

/**
 * Created by fred_chen on 7/3/15.
 */
public class Recursion
{
    public static int testRecursion(int a)
    {
        if (a > 1)
        {
            return testRecursion(a);
        }
        else
        {
            return 1;
        }
    }


    public static void main(String[] args)
    {
        System.out.println(testRecursion(4));
    }
}
