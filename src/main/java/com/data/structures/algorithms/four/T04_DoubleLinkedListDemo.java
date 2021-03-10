package com.data.structures.algorithms.four;

import java.nio.DoubleBuffer;

public class T04_DoubleLinkedListDemo {

  public static void main(String[] args) {
    //进行测试
    System.out.println("双向链表测试");
    //先创建节点
    HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
    HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
    HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
    HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

    //创建一个双向链表
    DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
    doubleLinkedList.add(hero1);
    doubleLinkedList.add(hero2);
    doubleLinkedList.add(hero3);
    doubleLinkedList.add(hero4);

    doubleLinkedList.list();

    //修改
    HeroNode2 newHeroNode = new HeroNode2(4, "hello", "world");
    doubleLinkedList.update(newHeroNode);
    System.out.println("修改后的链表情况");
    doubleLinkedList.list();

    //删除
    doubleLinkedList.del(3);
    System.out.println("删除后的链表情况....");
    doubleLinkedList.list();
  }

}
