package com.leetcode.fred;

/**
 * Created by fred_chen on 7/2/15.
 */
public class FindMinInRotatedSortedArrayII
{
    //assume asc
    public static int findMin(int[] nums)
    {
        int min = Integer.MAX_VALUE;
        int len = nums.length;
        int left = 0;
        int right = nums.length - 1;
        int pos = (left + right) / 2;

        //        System.out.println("Array Len: "+len+"");


        while (true)
        {
            System.out.println("Left:[" + left + "][" + nums[left] + "] Pos :[" + pos + "][" + nums[pos] + "] Right:[" + right + "][" + nums[right] + "]");

            TREND scope_trend = getTrend(nums[pos], nums[left], nums[right]);
            if (scope_trend == TREND.BOTTOM)
            {
                right = pos;
                pos = (pos + left) / 2;
            }
            else if (scope_trend == TREND.TOP)
            {
                left = pos;
                pos = (pos + right) / 2;
            }
            else if (scope_trend == TREND.UP)
            {
                min = nums[left];
                System.out.println("1");
                break;
            }
            else if (scope_trend == TREND.FLAT)
            {
                if (left < pos && right > pos)
                {
                    right -= 1;
                    left += 1;
                }
                else
                {
                    min = nums[pos];
                    System.out.println("2");
                    break;
                }

            }
            else if (scope_trend == TREND.OTHER)
            {
                if (nums[left] < nums[pos] || nums[left] < nums[right])
                {
                    min = nums[left];
                    //System.out.println("3");
                    break;
                }
                else if (nums[left] > nums[pos] || nums[left] > nums[right])
                {
                    left += 1;
                    right = pos;
                    pos = (left + right)/2;
                }
                else
                {
                    //min = nums[right];
                    //System.out.println("4");
                }


            }
            else
            {
                System.out.println("Should not go here!");
            }


        }

        return min;

    }

    private static int getLeftPos(int pos, int length)
    {
        int left = pos - 1;
        if (left < 0)
        {
            left = length - 1;
        }

        return left;
    }

    private static int getRightPos(int pos, int length)
    {
        int right = pos + 1;
        if (right >= length)
        {
            right = 0;
        }

        return right;
    }

    enum TREND
    {
        BOTTOM, TOP, UP, DOWN, FLAT, OTHER
    }

    private static TREND getTrend(int pos, int left, int right)
    {
        if (pos < left && pos < right)
        {
            return TREND.BOTTOM;
        }
        else if (pos > left && pos > right)
        {
            return TREND.TOP;
        }
        else if (pos > left && pos < right)
        {
            return TREND.UP;
        }
        else if (pos < left && pos < right)
        {
            return TREND.DOWN;
        }
        else if (pos == left && pos == right)
        {
            return TREND.FLAT;
        }
        else
        {
            return TREND.OTHER;
        }

    }

    private static TREND getTrend(int pos, int[] nums)
    {
        int left = getLeftPos(pos, nums.length);
        int right = getRightPos(pos, nums.length);
        return getTrend(nums[pos], nums[left], nums[right]);
    }


    public static void main(String[] args)
    {
        int nums[] = {3,3,1};

        System.out.println("Min in Nums: [" + findMin(nums) + "]");
    }
}
