package com.datastruct.KMP;

/**
 * Created by fred_chen on 11/10/15.
 */
public class ViolentMatch
{
    public static int match(String s, String p)
    {
        int ret = -1;

        for(int i = 0; i < s.length() - p.length() + 1; ++i)
        {
            boolean isFind = true;
            for(int j = 0; j < p.length();++j)
            {
                if (s.charAt(i+j) != p.charAt(j))
                {
                    isFind = false;
                    break;
                }
            }

            if (isFind)
            {
                ret = i;
                break;
            }
        }

        return ret;
    }
}
