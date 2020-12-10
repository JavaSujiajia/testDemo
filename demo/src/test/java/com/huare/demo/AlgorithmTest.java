package com.huare.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 文件描述
 *
 * @author 苏佳
 * @date 2020年12月04日 9:16
 * 算法学习测试类
 * <p>
 * 甲乙丙丁决定玩一个报数的游戏来打发时间。游戏规则为四个人从1开始轮流进行报数，
 * 但如果需要报出的数是7的倍数或含有数字7则直接跳过。
 * 此外大家约定，在总共报出了n个数后（不计入被跳过的数）游戏结束。
 * 现在需要你来帮忙统计，游戏过程中每个人各自跳过了几次。
 * <p>
 * 从标准输入读入数据。
 * 输入仅一行，包含一个正整数n，表示报出了多少个数后游戏结束。
 * <p>
 * 输出到标准输出。
 * 输出共四行，每行一个整数，依次表示甲乙丙丁四人在游戏过程中跳过的次数。
 */
@SpringBootTest
public class AlgorithmTest {

    @Test
    public void testWhen7() {
        when7(25);
    }

    public void when7(int n) {

        int c = n / 4;
        System.out.println("甲乙丙丁循环次数为：" + c);
        System.out.println("整次循环完毕之后剩余：" + n % 4);

        int guoCiShu = 0;
        for (int i = 0; i < c; i++) {
            int a = i * c;

        }

    }

}
