package com.data.structures.algorithms.three;

public class T01_SparseArray {

  public static void main(String[] args) {
    //创建一个原始的二维数组 11 * 11
    //0: 表示没有棋子, 1表示黑子, 2表示蓝子
    int chessArr1[][] = new int[11][11];
    chessArr1[1][2] = 1;
    chessArr1[2][3] = 2;
    chessArr1[4][5] = 2;
    System.out.println("原始二位数组....");
    for (int[] row : chessArr1) {
      for (int data : row) {
        System.out.printf("%d\t",data);
      }
      System.out.println();
    }

    //将二维数组转稀疏数组
    //1.先遍历二维数组, 得到非0数据的个数
    int sum = 0;
    for (int i = 0; i < 11; i++) {
      for (int j = 0; j < 11; j++) {
        if (chessArr1[i][j] != 0) {
          sum ++;
        }
      }
    }
    System.out.println("非零数据的个数: " + sum);

    //2.创建对应的稀疏数组
    int sparseArr[][] = new int[sum + 1][3];
    //给稀疏数组赋值
    sparseArr[0][0] = 11;
    sparseArr[0][1] = 11;
    sparseArr[0][2] = sum;

    //遍历二维数组, 将非0的值存放到sparseArr中
    int count = 0; //count用于记录是第几个非0数据
    for (int i = 0; i < 11; i++) {
      for (int j = 0; j < 11; j++) {
        if (chessArr1[i][j] != 0) {
          count++;
          sparseArr[count][0] = i;
          sparseArr[count][1] = j;
          sparseArr[count][2] = chessArr1[i][j];
        }
      }
    }

    //输出稀疏数组的形式
    System.out.println("输出稀疏数组....");
    for (int i = 0; i < sparseArr.length; i++) {
      System.out.printf("%d\t%d\t%d\t", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
      System.out.println();
    }

    //将稀疏数组 恢复成 原始的二维数组
    //1.读取稀疏数组一行一列,一行二列创建数组
    int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];

    //2.在读取稀疏数组后几行的数据(从第二行开始)
    for (int i = 1; i < sparseArr.length; i++) {
      System.out.println("======i=======" + i);
      chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
    }

    //输出恢复后的数组
    System.out.println("======输出恢复后的数组=====");
    for (int[] row : chessArr2) {
      for (int data : row) {
        System.out.printf("%d\t", data);
      }
      System.out.println();
    }
  }
}