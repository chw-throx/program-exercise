package com.datastruct.Sunday;

import com.datastruct.GeneralizedSuffixTree.StringPiece;

import java.util.HashMap;

/**
 * Created by fred_chen on 11/11/15.
 */
public class Sunday
{
    private static HashMap<Character, Integer> getOffSetToTail(String s)
    {
        HashMap<Character, Integer> map2return = new HashMap<>();
        int endIndex = s.length() - 1;
        for(int i = endIndex; i >=0; --i)
        {
            Character c = s.charAt(i);
            int value = endIndex - i ;
            if (!map2return.containsKey(c))
            {
                map2return.put(c, value);
            }
        }

        return map2return;
    }

    public static int match(String s, String p)
    {
        int ret = -1;

        HashMap<Character, Integer> valueMap = getOffSetToTail(p);
        for(int i = 0; i < s.length() - p.length()+1;)
        {
            //System.out.println("i: " + i);
            int current = i;
            int tail = i + p.length();
            boolean isFind = true;
            for(int j = 0; j < p.length() ;)
            {
                //System.out.println("j: " + j);
                if (s.charAt(current) != p.charAt(j))
                {
                    isFind = false;
                    //System.out.print("i:[" + i + "] Charactor " + s.charAt(tail));
                    if (valueMap.containsKey(s.charAt(tail)))
                    {
                        i += valueMap.get(s.charAt(tail)) + 1;
                        //System.out.println("Next i1 " + i);
                    }
                    else
                    {
                        i += p.length() + 1;
                    }
                    //displayString(s);
                    break;


                }
                else
                {
                    ++current;
                    ++j;
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

    public static void displayString(String s)
    {
        String str = "";
        String idx = "";
        for(int i = 0; i < s.length(); ++i)
        {
            str += "["+s.charAt(i)+"]";
            idx += "["+i+"]";
        }
        System.out.println(str);
        System.out.println(idx);
    }

    public static void main(String[] args)
    {
        String s = "1223AB4ABC66D88ABDABCDee";
        String p = "ABCD";

        System.out.println(match(s, p));
    }
}
