package com.example.demo.test.base.arithmetic;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.test.base.arithmetic
 * @ClassName: mp
 * @Description todo 冒泡排序
 * @Date 2020/10/14 19:14
 * @Author cly
 **/
public class mp {
    public static void main(String[] args) {
        int [] a={12,5,6};
        int n=a.length;
        for (int i=n-1;i>0;i--){
            for(int j=0;j<i;j++){
                int k=0;
                if(a[i]<a[j]){
                    k=a[i];
                    a[i]=a[j];
                    a[j]=k;
                }
            }
        }
        //5 6 12
        System.out.println(Arrays.toString(a));
    }
    /**
     * @Author cly
     * @method
     * @Description //TODO 斐波那契数列
     * @Date 14:23 2020/11/20
     * @Param
     * @return
     **/
    @Test
    public void fi(){
        System.out.println(get(10));
    }
    public long get(int n){
        if(n==0||n==1){
            return n;
        }else{
            return get(n-1)+get(n-2);
            }
        }
}
