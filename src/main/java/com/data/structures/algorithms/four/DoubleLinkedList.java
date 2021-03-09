package com.data.structures.algorithms.four;

/**
 * 创建一个双向链表
 */
public class DoubleLinkedList {

  //初始化一个头结点,头结点不要动,不存放具体的数据
  private HeroNode2 head = new HeroNode2(0, "", "");

  //返回头结点
  public HeroNode2 getHead() {
    return head;
  }

  //显示链表(遍历)
  public void list() {
    //判断链表是否为空
    if (head.next == null) {
      System.out.println("链表为空");
      return;
    }

    //头节点不能动,需要一个辅助变量遍历
    HeroNode2 temp = head.next;
    while (true) {
      // 判断是否到链表最后
      if (temp == null) {
        break;
      }
      //输出节点的信息
      System.out.println(temp);
      //将temp后移
      temp = temp.next;
    }
  }

  //添加一个节点
  public void add(HeroNode2 heroNode2) {
    //head头节点不能动,需要一个辅助变量 temp
    HeroNode2 temp = head;

    //遍历链表,找到最后
    while (true) {
      //找到链表的最后
      if (temp.next == null) {
        break;
      }
      //如果没有找到最后,将temp后移
      temp = temp.next;
    }

    //退出循环后,temp指向链表的最后
    //形成一个双向链表
    temp.next = heroNode2;
    heroNode2.pre = temp;
  }

  //修改一个节点,双向链表节点修改和单向链表一样
  public void update(HeroNode2 newHeroNode2) {
    //判断是否为空
    if (head.next == null) {
      System.out.println("链表为空...");
      return;
    }

    //找到需要修改的节点,根据no编号
    //定义一个辅助变量
    HeroNode2 temp = head.next;
    boolean flag = false;//表示是否找到该节点
    while (true) {
      if (temp == null) {
        break;//已经遍历完链表
      }
      if (temp.no == newHeroNode2.no) {
        //找到
        flag = true;
        break;
      }
      temp = temp.next;
    }

    //根据flag判断是否找到要修改的节点
    if (flag) {
      temp.name = newHeroNode2.name;
      temp.nickName = newHeroNode2.nickName;
    } else {
      System.out.printf("没有找到编号%d的节点,不能修改\n", newHeroNode2.no);
    }
  }

  //从双向链表中删除一个节点
  //1.对于双向链表,可以直接找到要删除的节点, 2.找到后,自我删除即可
  public void del(int no) {
    if (head.next == null) {
      System.out.println("链表为空...");
      return;
    }
    HeroNode2 temp  = head.next; //辅助变量
    boolean flag = false; //标志是否找到待删除节点
    while (true) {
      if (temp == null) {
        break;
      }
      if (temp.no == no) {
        //找到待删除的节点前一个节点temp
        flag = true;
        break;
      }
      temp  = temp.next; //temp后移,遍历
    }

    if (flag) {
      temp.pre.next = temp.next;
      //如果是最后一个节点,就不需要执行下面代码,否则会空指针
      if (temp.next != null) {
        temp.next.pre = temp.pre;
      }
    } else {
      System.out.println();
    }
  }
}
