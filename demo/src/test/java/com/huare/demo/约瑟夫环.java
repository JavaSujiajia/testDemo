package com.huare.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 文件描述
 *
 * @author sujia
 * @date 2020年12月04日 9:50
 * <p>
 * 如果有一列数位置规定为1-41
 * 每三个数就删除这个数字
 * 然后最后剩两张
 * 请找出这两个位置
 */
@SpringBootTest
public class 约瑟夫环 {

    @Test
    public void test01() {

        int[] aa = new int[41];
        int[] ints = setArray(aa);

        for (int i = 0; i < ints.length; i++) {
            int anInt = ints[i];
            System.out.println(anInt);
        }

    }

    public int[] setArray(int[] aa) {
        for (int i = 0; i < 41; i++) {
            aa[i] = i + 1;
        }
        return aa;
    }


}
