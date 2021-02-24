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

  public void addByOrder(HeroNode node) {
    //因为头节点不能动，因此我们仍然通过一个辅助指针（变量）来帮助我们找到添加的位置，
    //因为单链表，我们找到的temp是位于 添加位置的第一个节点，否则插入不了
    HeroNode temp = head;
    boolean flag = false; //flag标志添加的编号是否存在，默认为false
    while (true) {
      //当什么情况下,说明链表带最后了
      if (temp.next == null) {
        System.out.println("===============null");
        break;
      }
      System.out.println("========" + temp.next);
      if (temp.next.no > node.no) {//位置找到,在temp后面插入
        break;
      } else if (temp.next.no == node.no) { //说明将要添加的heroNode的编号已经存在
        flag = true; //说明编号存在
        break;
      }
      //后移,遍历当前链表
      temp = temp.next;
    }
    if (flag) {
      System.out.printf("编号 %d 已经存在，不能再添加~\n", node.no);
    } else {
      //插入到链表中，temp的后面
      node.next = temp.next;
      temp.next = node;
    }
  }

  //修改节点的信息，根据no编号来修改，即no编号不能改
  public void update(HeroNode newHeroNode) {
    //判空
    if (head.next == null) {
      System.out.println("链表为空");
      return;
    }
    //找到需要修改的节点，根据no编号
    //定义一个辅助变量
    HeroNode temp = head.next;
    boolean flag = false; //表示是否找到该节点
    while (true) {
      if (temp == null) {
        break; //已经遍历完链表
      }
      if (temp.no == newHeroNode.no) {
        //找到
        flag = true;
        break;
      }
      temp = temp.next;
    }
    //根据flag 判断是否找到要修改的节点
    if (flag) {
      temp.name = newHeroNode.name;
      temp.nickName = newHeroNode.nickName;
    } else { //没有找到
      System.out.printf("编号 %d 不存在，不能修改~", newHeroNode.no);
    }
  }

  //删除链表
  //思路
  //1.head 不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
  //2.说明我们在比较时，是 temp.next.no 和 需要删除的节点的no 比较
  public void del(int no) {
    //辅助链表
    HeroNode temp = head;
    boolean flag = false; //标志是否找到待删除的节点

    while (true) {
      if (temp.next == null) { //已经到链表最后
        break;
      }
      if (temp.next.no == no) {
        //找到待删除节点的前一个节点temp
        flag = true;
        break;
      }
      temp = temp.next; //后移
    }

    if (flag) {
      //删除节点
      temp.next = temp.next.next;
    } else {
      System.out.printf("要删除的 %d 节点不存在\n", no);
    }
  }

  public HeroNode getHead() {
    return head;
  }


}
