package com.data.structures.algorithms.four;

import java.util.Stack;

/**
 * 从尾到头打印单链表
 */
public class T03 {

  public static void main(String[] args) {
    //栈的方式
    Stack<String> stack = new Stack<>();
    //入栈
    stack.add("a");
    stack.add("b");
    stack.add("c");

    while (stack.size() > 0) {
      System.out.println("取出数据: " + stack.pop()); //把栈顶取出
    }
  }

}
