package com.data.structures.algorithms.four;

public class SingleLinkedList {

  //先初始化一个头结点，头结点不要动
  private HeroNode head = new HeroNode(0, "", "");

  public void add(HeroNode node) {
    //head节点不可以动，因此我们需要一个辅助遍历temp
    HeroNode temp = head;
    //遍历链表找到，找到最后
    while (true) {
      //当什么情况下,说明链表带最后了
      if (temp.next == null) {
        break;
      }
      //如果没有找到，就将指针后移
      temp = temp.next;
    }
    temp.next = node;
  }


  //显示列表
  public void list() {
    //先判断列表是否为空
    if (head.next == null) {
      return;
    }
    //因为头结点不能动，因此需要一个辅助变量来变量
    HeroNode temp = head.next;
    while (true) {
      //如果为空
      if (temp == null) {
        break;
      } else {
        //输出节点的信息
        System.out.println(temp);
        //将temp后移
        temp = temp.next;
      }
    }
  }
}
