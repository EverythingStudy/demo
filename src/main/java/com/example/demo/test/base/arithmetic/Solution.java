package com.example.demo.test.base.arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.test.base.arithmetic
 * @ClassName: Solution
 * @Description
 * @Date 2020/12/1 16:51
 * @Author cly
 **/
public class Solution {
    //int[] result=new int[16];
    List<Integer> result=new ArrayList<>();
    public Integer[] searchRange(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                result.add(i);
            }
        }
        if(result.size()==0){
            result.add(-1);
            result.add(-1);
        }
        Integer[] ints=new Integer[result.size()];

        return result.toArray(ints);
    }
    public static void main(String[] args){
        System.out.println(512%10);
        int[] nums={5,7,7,8,8,10};
        Solution solution=new Solution();
        Integer[] sizes=solution.searchRange(nums, 8);
        for(int i=0;i<sizes.length;i++){
            System.out.println(sizes[i]);

        }
    }
  /**
   * @Author cly 
   * @method TODO 假设我们的环境只能存储得下 32 位的有符号整数，给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
   * TODO 请根据这个假设，如果反转后整数溢出那么就返回 0。
   * @Description //TODO lennon
   * @Date 18:32 2020/12/1
   * @Param 
   * @return 
   **/
    public int reverse(int x) {
        int temp=0;
        int remain;
        while(x!=0){
            remain=x%10;
            x=x/10;
            if(temp>Integer.MAX_VALUE/10||temp==Integer.MAX_VALUE) return 0;
            if(temp<Integer.MIN_VALUE/10||temp==Integer.MIN_VALUE) return 0;
            temp=temp*10+remain;
        }
        return temp;
    }
}
