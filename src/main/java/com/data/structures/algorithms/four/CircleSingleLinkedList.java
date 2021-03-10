package com.data.structures.algorithms.four;


/**
 * 创建环形单向链表
 */
public class CircleSingleLinkedList {

  //创建一个first节点,当前没有编号
  private Boy first = null;

  //添加Boy节点, 构建成一个环形的链表
  public void addBoy(int nums) {
    //nums做一个数据校验
    if (nums < 1) {
      System.out.println("nums的值不正确");
      return;
    }
    Boy curBoy = null; //辅助指针, 帮助构建环形链表
    //使用for来创建环形链表
    for (int i = 0; i <= nums; i++) {
      //根据编号,创建Boy节点
      Boy boy = new Boy(i);

      //如果是第一个Boy
      if (i == 1) {
        first = boy;
        first.setNext(first); //构成环
        curBoy = first; //让curBoy指向第一个小孩
      } else {
        curBoy.setNext(boy);
        boy.setNext(first);
        curBoy = boy;
      }
    }
  }

  //遍历当前的环形链表
  public void showBoy() {
    //判断链表是否为空
    if (first == null) {
      System.out.println("链表为空...");
      return;
    }

    //因为first不能动,需要使用一个辅助指针完成遍历
    Boy curBoy = first;
    while (true) {
      System.out.printf("小孩的编号 %d \n", curBoy.getNo());
      if (curBoy.getNext() == first) { //说明遍历已经完成
        break;
      }
      curBoy = curBoy.getNext(); //curBoy后移
    }
  }

  /**
   * 根据用户输入, 计算小孩出圈的顺序
   * @param startNo 从第几个小孩开始数数
   * @param countNum 表示数几下
   * @param nums 表示最初有多少小孩在圈中
   */
  public void countBoy(int startNo, int countNum, int nums) {
    //先对数据进行校验
    if (first == null || startNo < 1 || startNo > nums) {
      System.out.println("参数输入有误, 请重新输入");
      return;
    }
  }
}
