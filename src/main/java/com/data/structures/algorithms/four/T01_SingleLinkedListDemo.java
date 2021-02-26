package com.data.structures.algorithms.four;

public class T01_SingleLinkedListDemo {

  public static void main(String[] args) {
    //进行测试
    //先创建节点
    HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
    HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
    HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
    HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

    SingleLinkedList singleLinkedList = new SingleLinkedList();
//    singleLinkedList.add(hero1);
//    singleLinkedList.add(hero2);
//    singleLinkedList.add(hero3);
//    singleLinkedList.add(hero4);

    singleLinkedList.addByOrder(hero1);
    singleLinkedList.addByOrder(hero2);
    singleLinkedList.addByOrder(hero3);
    singleLinkedList.addByOrder(hero4);
    singleLinkedList.list();

//    singleLinkedList.update(new HeroNode(3, "xxx", "yyy"));
//
//    System.out.println("修正后：");
    //显示
//    singleLinkedList.list();
//    int count = T02.getCount(singleLinkedList.getHead());
//    System.out.println("个数: " + count);

//    HeroNode lastIndexNode = T02.getLastIndexNode(singleLinkedList.getHead(), 3);
//    System.out.println("倒数第index个:　" + lastIndexNode);

    System.out.println( "============================");
//    T02.reverseList(singleLinkedList.getHead());
//    singleLinkedList.list();
    T02.reversePrint(singleLinkedList.getHead());

    singleLinkedList.del(1);
    singleLinkedList.del(4);
    System.out.println("删除后：");
//    //显示
//    singleLinkedList.list();
  }

}
