package com.data.structures.algorithms.four;

public class T02 {

  /**
   * 求单链表中有效节点的个数
   *
   * @param head 头结点
   * @return 数量
   */
  public static int getCount(HeroNode head) {
    if (head.next == null) {
      return 0;
    }

    int count = 0;
    HeroNode curNode = head.next;
    while (curNode != null) {
      count++;
      curNode = curNode.next;
    }

    return count;
  }

  /**
   * 查找单链表中的倒数第k个节点
   *
   * @param head 头结点
   * @param index 倒数第index个节点
   * @return 节点
   */
  public static HeroNode getLastIndexNode(HeroNode head, int index) {
    if (head.next == null) {
      return null;
    }
    //第一次遍历得到链表的长度
    int size = getCount(head);
    //第二次遍历size-index位置，就是我们倒数第k个节点
    //先做一个Index的校验
    if (index <= 0 || index > size) {
      return null;
    }
    HeroNode temp = head.next;
    for (int i = 0; i < size - index; i++) {
      temp = temp.next;
    }
    return temp;
  }
}
