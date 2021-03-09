package com.data.structures.algorithms.four;

import java.util.Stack;

public class T02 {

  /**
   * 求单链表中有效节点的个数
   *
   * @param head 头节点
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
   * @param head 头节点
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

  /**
   * 将单链表反转
   *
   * @param head 头节点
   */
  public static void reverseList(HeroNode head) { //  h, 1, 2, 3, 4
    //如果当前链表为空,或者只有一个节点,无需反转
    if (head.next == null || head.next.next == null) {
      return;
    }

    HeroNode cur = head.next; //定义一个辅助变量,遍历原来的链表 cur = 1
    System.out.println(cur);
    HeroNode next = null; // 指向当前节点cur的下一个节点
    HeroNode reverseHead = new HeroNode(0, "", "");
    //遍历原来的链表,每遍历一个节点,就将其取出,并放在新链表reverseHead的的最前端
    while (cur != null) {
      next = cur.next; //先暂时保存当前节点的下一个节点 next = 2
      cur.next = reverseHead.next; //将cur的下一个节点指向新的链表的最前端 2
      reverseHead.next = cur; //将cur连接到新的链表上
      cur = next; //让cur后移
    }

    head.next = reverseHead.next; //将head.next指向reverseHead.next, 实现单链表的反转
  }


  public static void reversePrint(HeroNode head) {
    if (head.next == null) {
      return;//链表为空
    }
    //创建一个栈, 将各个节点压入栈
    Stack<HeroNode> stack = new Stack<>();
    HeroNode cur = head.next;

    //将链表的所有节点压入栈
    while (cur != null) {
      stack.push(cur);
      cur = cur.next; // cur后移
    }

    //将栈中节点打印
    while (stack.size() > 0) {
      System.out.println(stack.pop());
    }
  }

  /**
   * 合并两个有序单链表,合并之后的链表依然有序
   */
  public static HeroNode mergeLinkList(HeroNode head1, HeroNode head2) {
    if (head1.next == null && head2.next == null) {
      return null;//两个链表都为空
    }
    if (head1 == null) {
      return head2;
    }
    if (head2 == null) {
      return head1;
    }
    HeroNode head = null; //新链表的头节点
    HeroNode current; // current节点指向新链表

    //1.让current指向head1和head2中较小的数据, 得到head节点
    if (head1.no < head2.no) {
      head = head1;
      current = head1;
      head1 = head1.next;
    } else {
      head = head2;
      current = head2;
      head2 = head2.next;
    }

    while (head1 != null && head2 != null) {
      if (head1.no < head2.no) {
        current.next = head1;
        current = current.next; //新链表中,current指针的下一个节点对应较小的那个数据
        head1 = head1.next; //current指针下移
      } else {
        current.next = head2;
        current = current.next;
        head2 = head2.next;
      }
    }

    //合并剩余的元素
    if (head1 != null) {
      //说明链表2遍历完成.是空的
      current.next = head1;
    }

    if (head2 != null) {
      //链表1遍历完成,是空的
      current.next = head2;
    }

    return head;

  }

  public static void main(String[] args) {
    SingleLinkedList singleLinkedList1 = new SingleLinkedList();
    SingleLinkedList singleLinkedList2 = new SingleLinkedList();

    for (int i = 0; i < 4; i++) {
      HeroNode heroNode = new HeroNode(i, String.valueOf(i), String.valueOf(i));
      singleLinkedList1.add(heroNode);
    }
    for (int i = 3; i < 8; i++) {
      HeroNode heroNode = new HeroNode(i, String.valueOf(i), String.valueOf(i));
      singleLinkedList2.add(heroNode);
    }

    SingleLinkedList singleLinkedList3 = new SingleLinkedList();
    HeroNode heroNode = mergeLinkList(singleLinkedList1.getHead(), singleLinkedList2.getHead());

  }
}
