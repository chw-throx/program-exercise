package com.datastruct.KMP;

/**
 * Created by fred_chen on 11/10/15.
 */
public class KMP
{
    public static int[] getNextArray(String p)
    {
        int len = p.length();
        int next[] = new int[len];
        next[0] = -1;
        next[1] = 0;
        int cursor = 2;
        int flag = 0;
        int value = 0;

        while (cursor <= len -1)
        {
            if (p.charAt(cursor - 1) == p.charAt(flag))
            {
                ++flag;
                ++value;
            }
            else
            {
                if (flag != 0)
                {
                    flag = 0;
                    value = 0;

                    if (p.charAt(cursor - 1) == p.charAt(flag))
                    {
                        ++flag;
                        ++value;
                    }
                }
            }
            next[cursor] = value;
            ++cursor;
        }

        return next;
    }

    public static int kmpMatch(String s, String p)
    {
        int ret = -1;
        int i = 0;
        int j = 0;

        int[] next = getNextArray(p);
        while ( i < s.length() - p.length()+1)
        {
            if (s.charAt(i) == p.charAt(j))
            {
                if (j == p.length() -1)
                {
                    ret = i - j;
                    break;
                }
                else
                {
                    ++i;
                    ++j;
                }
            }
            else
            {
                if (j != 0)
                {
                    j = next[j];
                }
                else
                {
                    ++i;
                }
            }

        }




        return ret;
    }

    public static int[] getNext(String p)
    {
        int len = p.length();
        int next[] = new int[len];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < len - 1)
        {
            if (k == -1 || p.charAt(j) == p.charAt(k))
            {
                ++k;
                ++j;
                next[j] = k;
            }
            else
            {
                k = next[k];
            }
        }

        return next;
    }

    public static void displayNextArray(int next[])
    {
        String p = "[";
        for(int i:next)
        {
            p += i + ",";
        }
        p += "]";

        System.out.println(p);
    }

    public static void main(String[] args)
    {
        String s = "AAAAAAABAAAAAA";
        String str2p = "[";
        for(char c:s.toCharArray())
        {
            str2p+= c + ",";
        }
        str2p += "]";
        String p = "BA";

        System.out.println(str2p);
        KMP.displayNextArray(KMP.getNext(s));
        KMP.displayNextArray(KMP.getNextArray(s));
        System.out.println(KMP.kmpMatch(s, p));
    }
}
