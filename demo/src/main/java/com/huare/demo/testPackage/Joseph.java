package com.huare.demo.testPackage;

import java.util.Scanner;

/**
 * 文件描述
 *
 * @author sujia
 * @date 2020年12月02日 13:36
 */
public class Joseph {

    public static void test(String[] s, int k, int m) {
        int len = s.length;
        String a = "";
        int index = 0;
        if (k > len) {
            throw new RuntimeException("队列当前学生数量为" + len + "个，无法从第" + k + "个学生开始报数");
        }
        if (s.length == 1) {
            a = s[0];
            System.out.println("当前出列的学生：" + a);
            return;
        }
        for (int i = 0; i < m; i++) {
            if ((k + i - 1) < len) {
                a = s[k + i - 1];
                index = k + i - 1;
            } else {
                boolean flag = true;
                int b = (k + i - 1) - len;
                while (flag) {
                    if (b >= len) {
                        b = b - len;
                    } else {
                        flag = false;
                    }
                }
                a = s[b];
                index = b;
            }
        }
        System.out.println("当前出列的学生：" + a);

        System.arraycopy(s, (index + 1), s, index, (len - index - 1));
        String[] s1 = new String[len - 1];
        System.arraycopy(s, 0, s1, 0, s1.length);

        if (index == len - 1) {
            index = 0;
        }
        Joseph.test(s1, index + 1, m);
    }


    public static void main(String[] args) {
        String[] s = {"张天宇", "苏可佳", "伍庆港", "贺向天", "崔鹏熙", "王阔"};
        System.out.println("当前队列的学生有：");
        for (String s1 : s) {
            System.out.print(s1 + " ");
        }
        System.out.println();
        System.out.println("----------------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请传入数字表示开始报数的学生位置：");
        int index = Integer.parseInt(scanner.nextLine());
        System.out.println("请传入数字表示报到该数的学生出列：");
        int m = Integer.parseInt(scanner.nextLine());

        System.out.println("准备完毕，开始报数...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Joseph.test(s, index, m);
    }

}
