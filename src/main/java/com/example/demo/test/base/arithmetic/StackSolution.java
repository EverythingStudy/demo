package com.example.demo.test.base.arithmetic;

import java.util.Stack;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.test.base.arithmetic
 * @ClassName: StackSolution
 * @Description //TODO STACK栈
 * @Date 2020/11/18 14:58
 * @Author cly
 **/
public class StackSolution {
    Stack<Integer> ele=new Stack<>();
    Stack<Integer> min=new Stack<>();

    //入栈，元素先保存，判断当前入栈的数据与栈中最小值相比较谁最小，如果当前的小，入栈min，否则不变
    public void push(int node) {
        ele.push(node);
        if(min.isEmpty()){
            min.push(node);
        }else{
            if(min.peek()>node){
                min.push(node);
            }
        }
    }
    //出栈，将出栈的元素放到一个变量中，判断是否是最小元素，如果是则将保存最小元素的栈中数据弹出
    public void pop() {
        int topData = ele.peek();
        ele.pop();
        if(topData==this.min()){
            min.pop();
        }
    }
    //获取最小值，如果占中有数据，则是最小值，如果没有，则栈已经被弹空
    public int min() {
        System.out.println("e=="+ele.toString());
        System.out.println("m=="+min.toString());
        if(min.isEmpty()){
            return Integer.MAX_VALUE;
        }else{
            return min.peek();
        }
    }



    public static void main(String[] args) {
        StackSolution stackSolution=new StackSolution();
        stackSolution.push(2);
        stackSolution.push(4);
        stackSolution.push(3);
        stackSolution.push(1);
        stackSolution.push(5);
        System.out.println(stackSolution.min());
    }
}
