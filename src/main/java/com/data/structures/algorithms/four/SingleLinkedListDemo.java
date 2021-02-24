package com.data.structures.algorithms.four;

public class SingleLinkedListDemo {

  public static void main(String[] args) {
    //进行测试
    //先创建节点
    HeroNode hero1=new HeroNode(1, "宋江", "及时雨");
    HeroNode hero2=new HeroNode(2, "卢俊义", "玉麒麟");
    HeroNode hero3=new HeroNode(3, "吴用", "智多星");
    HeroNode hero4=new HeroNode(4, "林冲", "豹子头");

    SingleLinkedList singleLinkedList=new SingleLinkedList();
//    singleLinkedList.add(hero1);
//    singleLinkedList.add(hero2);
//    singleLinkedList.add(hero3);
//    singleLinkedList.add(hero4);

    singleLinkedList.addByOrder(hero1);
    singleLinkedList.addByOrder(hero4);
    singleLinkedList.addByOrder(hero3);
//    singleLinkedList.addByOrder(hero2);
    singleLinkedList.list();
  }

}
