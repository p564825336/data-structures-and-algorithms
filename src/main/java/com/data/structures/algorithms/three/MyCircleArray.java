package com.data.structures.algorithms.three;

//使用数组模拟队列-编写一个ArrayQueue类
class MyCircleArray {

  private int maxSize;//表示数组的最大容量
  private int front;//队列头,front指向队列的第一个元素,初始值为0;
  private int rear;//队列尾,rear指向队列的最后一个元素的后一个位置,初始值为0
  private int[] arr;//该数据用于存放数据，模拟队列

  //创建队列的构造器
  public MyCircleArray(int arrMaxSize) {
    maxSize = arrMaxSize;
    arr = new int[maxSize];
  }

  //判断队列是否满
  public boolean isFull() {
    return (rear + 1) % maxSize == front;
  }

  //判断队列是否为空
  public boolean isEmpty() {
    return rear == front;
  }

  //添加数据到队列 1
  public void addQueue(int n) {
    //判断队列是否满
    if (isFull()) {
      System.out.println("队列满，不能加入数据~");
      return;
    }
    //直接将数据加入
    arr[rear] = n; // arr[0]=1, arr[1]=2, arr[2]=3
    rear = (rear + 1) % maxSize; // rear = (0+1)%4 = 1 , rear=(1+1)%4=2,  rear=(2+1)%4=3
  }

  //获取队列的数据，出队列
  public int getQueue() {
    //判断队列是否为空
    if (isEmpty()) {
      //通过抛出异常
      throw new RuntimeException("队列空，不能取数据");
    }
    //这里需要分析出front是指向队列的第一个元素
    //1.先把front对应的值保留到一个临时变量
    //2.将front后移,考虑取模
    //3.将临时保存的变量返回
    int value = arr[front];
    front = (front + 1) % maxSize;
    return value;
  }

  //显示队列的所有数据
  public void showQueue() {
    //遍历
    if (isEmpty()) {
      System.out.println("队列空，无数据");
      return;
    }
    //思路：从front开始遍历，遍历多少个元素
    for (int i = front; i < front + size(); i++) {
      System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
    }
  }

  //求出当前队列有效数据的个数
  public int size() {
    return (rear + maxSize - front) % maxSize;
  }

  //显示队列的头数据，注意不是取数据
  public int headQueue() {
    //判断
    if (isEmpty()) {
      throw new RuntimeException("队列空，无数据");
    }
    return arr[front];
  }
}