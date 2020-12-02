package com.huare.demo;

import com.huare.demo.entity.User;
import com.huare.demo.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private UserServiceImpl userService;

    @Test
    void contextLoads() {
        User byId = userService.findById(1);
        System.out.println(byId.toString());
    }

    @Test
    public void test01(){
        List<User> users = userService.selectAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void test02(){

        //定义红球池
        int[] redPool = new int[33];
        //添加红球数字
        for (int i = 0; i < redPool.length; i++) {
            redPool[i] = i + 1;
        }

        int[] bluePool = new int[16];
        for (int i = 0; i < bluePool.length; i++) {
            redPool[i] = i + 1;
        }

        int[] redBalls = new int[6];
        int x;


    }

    @Test
    public void  Test007(){
        //定义红球池
        int[] redpool = new int[33];
        //添加红球数字
        for (int i = 0; i < redpool.length; i++) {
            redpool[i] = i + 1;
        }
        //定义篮球池
        int[] bluepool=new int[16];
        for (int j = 0; j < bluepool.length; j++) {
            bluepool[j] = j + 1;
        }
        //定义被选中的红球
        int[] redballs =new int[6];
        int x;
        A: for (int i = 0; i < redballs.length; i++) {
            x = new Random().nextInt(33);
            for (int j = 0; j <= i; j++) {
                //去重过程
                //判断当前循环取出的红球是否跟前几次取出的一样
                //如果一样 大循环A向后退一次，重新取出红球
                if (redballs[j] == redpool[x]) {
                    i--;
                    continue A;
                }
            }
            //如果不一样，则把取出的红球池中取出的红球放入红球数组中
            redballs[i] = redpool[x];
        }
        //取出篮球
        int a = bluepool[new Random().nextInt(16)];
        //利用冒泡排序对红球进行排序
        int temp;
        for (int i = 0; i < redballs.length-1; i++) {
            for (int j = 0; j < redballs.length-i-1; j++) {
                if (redballs[j]>redballs[j+1]) {
                    temp=redballs[j+1];
                    redballs[j+1]=redballs[j];
                    redballs[j]=temp;
                }
            }
        }
        System.out.print("红球：" + Arrays.toString(redballs));
        System.out.println(",蓝球：" +a);
    }


    @Test
    public void test30Num(){
        int x;
        int c =0;
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            x = new Random().nextInt(99);
            c+=x;
            values.add(x);
        }
        System.out.println(values);
        System.out.println(c);
    }
}
