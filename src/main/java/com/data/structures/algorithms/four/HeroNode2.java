package com.data.structures.algorithms.four;

public class HeroNode2 {

  public int no;
  public String name;
  public String nickName;
  public HeroNode2 next;//指向下一个节点,默认null
  public HeroNode2 pre;//指向前一个节点,默认null

  public HeroNode2(int no, String name, String nickName) {
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
