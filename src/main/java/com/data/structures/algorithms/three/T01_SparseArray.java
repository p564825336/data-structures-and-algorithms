package com.data.structures.algorithms.three;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        System.out.printf("%d\t", data);
      }
      System.out.println();
    }

    //将二维数组转稀疏数组
    //1.先遍历二维数组, 得到非0数据的个数
    int sum = 0;
    for (int i = 0; i < 11; i++) {
      for (int j = 0; j < 11; j++) {
        if (chessArr1[i][j] != 0) {
          sum++;
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

    saveSparse(sparseArr);
    int[][] ints = readSparse();
    System.out.println("输出读取磁盘的稀疏数组....");
    for (int i = 0; i < ints.length; i++) {
      System.out.printf("%d\t%d\t%d\t", ints[i][0], ints[i][1], ints[i][2]);
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

  public static void saveSparse(int[][] sparseArr) {
    System.out.println("===========sparseArr.length==========" + sparseArr.length);
    FileWriter fileWriter = null;
    try {
      File file = new File("sparseArr.txt");
      if (!file.exists()) {
        file.createNewFile();
      }
      fileWriter = new FileWriter(file);
      for (int i = 0; i < sparseArr.length; i++) {
        //6.数据前两列加入","
        for (int j = 0; j < sparseArr[0].length - 1; j++) {
          fileWriter.write(sparseArr[i][j] + ",");
        }
        //7.数组最后一列后面不加","
        fileWriter.write(sparseArr[i][sparseArr[0].length - 1] + "");
        //8.加上换行符
        fileWriter.write("\n");
      }
      fileWriter.flush();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        //11.如果writeFile不为空，就将其关闭
        if (fileWriter != null) {
          fileWriter.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  //读取磁盘中的文件，转换为稀疏数组
  public static int[][] readSparse() {
    //1.声明一个字符输入流
    FileReader reader = null;
    //2.声明一个字符输入缓冲流
    BufferedReader readerBuf = null;
    //3.声明一个二维数组
    int[][] sparseArr = null;
    try {
      //4.指定reader的读取路径
      reader = new FileReader("sparseArr.txt");
      //5.通过BufferedReader包装字符输入流
      readerBuf = new BufferedReader(reader);
      //6.创建一个集合，用来存放读取的文件的数据
      List<String> strList = new ArrayList<>();
      //7.用来存放一行的数据
      String lineStr;
      //8.逐行读取txt文件中的内容
      while ((lineStr = readerBuf.readLine()) != null) {
        //9.把读取的行添加到list中
        strList.add(lineStr);
      }
      //10.获取文件有多少行
      int lineNum = strList.size();
      String s = strList.get(0);
      String[] split = s.split("\\,");
      //11.根据文件行数创建对应的数组
      sparseArr = new int[lineNum][split.length];
      //12.记录输出当前行
      int count = 0;
      //13.循环遍历集合，将集合中的数据放入数组中
      for (String str : strList) {
        //14.将读取的str按照","分割，用字符串数组来接收
        String[] ss = str.split("\\,");
        for (int i = 0; i < ss.length; i++) {
          sparseArr[count][i] = Integer.valueOf(ss[i]);
        }
        //15.将行数 + 1
        count++;
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      //16.关闭字符输入流
      try {
        if (reader != null) {
          reader.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      //17.关闭字符输入缓冲流
      try {
        if (readerBuf != null) {
          readerBuf.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    //18.返回稀疏数组
    return sparseArr;
  }
}
