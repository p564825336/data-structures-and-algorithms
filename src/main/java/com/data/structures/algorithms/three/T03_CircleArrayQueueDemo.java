package com.data.structures.algorithms.three;

import java.util.Scanner;

public class T03_CircleArrayQueueDemo {

  public static void main(String[] args) {

    //创建一个队列
    MyCircleArray queque = new MyCircleArray(4);//设置的4，队列有效数据最大是3
    char key = ' ';//接收用户输入
    Scanner scanner = new Scanner(System.in);
    boolean loop = true;
    while (loop) {
      System.out.println("s(show):显示队列");
      System.out.println("e(exit):退出程序");
      System.out.println("a(add):添加数据到队列");
      System.out.println("g(get):从队列取出数据");
      System.out.println("h(head):查看队列头的数据");
      key = scanner.next().charAt(0);//接收一个字符
      switch (key) {
        case 's':
          queque.showQueue();
          break;
        case 'a':
          System.out.println("输入一个数");
          int value = scanner.nextInt();
          queque.addQueue(value);
          break;
        case 'g':
          try {
            int res = queque.getQueue();
            System.out.println("从队列中取出的数是:" + res);
          } catch (Exception e) {
            System.out.println(e.getMessage());
          }
          break;
        case 'h'://查看队列头数据
          try {
            int res = queque.headQueue();
            System.out.printf("队列头的数据是%d\n", res);
          } catch (Exception e) {
            System.out.println(e.getMessage());
          }
          break;
        case 'e'://退出
          scanner.close();
          loop = false;
          break;
        default:
          break;
      }
    }
    System.out.println("程序退出");
  }

}

