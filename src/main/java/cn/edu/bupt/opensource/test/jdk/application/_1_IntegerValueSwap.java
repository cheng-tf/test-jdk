package cn.edu.bupt.opensource.test.jdk.application;

import java.lang.reflect.Field;

/**
 * <p>Title: _1_IntegerValueSwap</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-26 21:54</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 要求：写一个函数，交换整数a和b的值
 *
 */
public class _1_IntegerValueSwap {

    /**
     * 交换整数的值：基于反射
     */
    private static void swap(Integer a, Integer b) {
        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            // field.set问题：由于自动拆装箱、缓存导致结果错误
            int temp = a;
            field.setInt(a, b);
            field.setInt(b, temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        swap(a, b);
        // a=2;b=1
        System.out.println("a = " + a + "; b = " + b);
    }

}
