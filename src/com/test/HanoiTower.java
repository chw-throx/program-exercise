package com.test;

import java.util.Stack;

/**
 * Created by fred_chen on 7/3/15.
 */
public class HanoiTower
{
    private Stack<Integer> A, B, C;

    public HanoiTower()
    {
        A = new Stack<>();
        B = new Stack<>();
        C = new Stack<>();

        A.push(5);
        A.push(4);
        A.push(3);
        A.push(2);
        A.push(1);
    }

    public void move(Stack<Integer> src, Stack<Integer> tag, Stack<Integer> tmp, int size)
    {
        if (size == 1)
        {
            tag.push(src.pop());
        }
        else
        {
            move(src, tmp, tag, size -1);
        }
    }

    public void hanoiTest()
    {
        move(A, B, C, A.size());
    }

    public void display()
    {
        System.out.println("A:");
        for(Integer i: A)
        {
            System.out.print(i + ", ");
        }
        System.out.println("");
        System.out.println("B:");
        for(Integer i: B)
        {
            System.out.print(i + ", ");
        }
        System.out.println("");
        System.out.println("C:");
        for(Integer i: C)
        {
            System.out.print(i + ", ");
        }
        System.out.println("");
    }


    public static void main(String[] args)
    {
        HanoiTower hanoi = new HanoiTower();
        hanoi.display();
        hanoi.hanoiTest();
        hanoi.display();

    }
}
