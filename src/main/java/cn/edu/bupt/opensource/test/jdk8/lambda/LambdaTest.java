package cn.edu.bupt.opensource.test.jdk8.lambda;

import org.junit.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Title: LambdaTest</p>
 * <p>Description: Lambda测试类</p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-05-08 17:31</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class LambdaTest {

    // 匿名内部类
    @Test
    public void test1() {
        // JDK1.8之前，匿名内部类的替换
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before Java8, too much code for too little to do");
            }
        }).start();
        // JDK1.8之后
        new Thread(
                () -> System.out.println("In Java8, Lambda expression rocks !!!")
        ).start();
    }

    // 事件处理
    @Test
    public void test2() {
        // Java 8之前：
        JButton show =  new JButton("Show");
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Event handling without lambda expression is boring");
            }
        });
        // Java 8方式：
        show.addActionListener(
                (e) -> {
                    System.out.println("Light, Camera, Action !! Lambda expressions Rocks");
                }
        );
    }

    // 列表迭代
    @Test
    public void test3() {
        // Java 8之前：
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        for (String feature : features) {
            System.out.println(feature);
        }
        // Java 8之后：
        features.forEach(n -> System.out.println(n));
        // 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
        // 看起来像C++的作用域解析运算符
        features.forEach(System.out::println);
    }

}