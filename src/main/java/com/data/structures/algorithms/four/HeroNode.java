package com.data.structures.algorithms.four;

public class HeroNode {

  public int no;
  public String name;
  public String nickName;
  public HeroNode next;//指向下一个节点

  public HeroNode(int no, String name, String nickName) {
    this.no = no;
    this.name = name;
    this.nickName = nickName;
  }

  @Override
  public String toString() {
    return "HeroNode{" +
        "no=" + no +
        ", name='" + name + '\'' +
        ", nickName='" + nickName + '\'' +
        '}';
  }
}
