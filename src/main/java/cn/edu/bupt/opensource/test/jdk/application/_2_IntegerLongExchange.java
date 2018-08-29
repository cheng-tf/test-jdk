package cn.edu.bupt.opensource.test.jdk.application;

/**
 * <p>Title: _2_IntegerLongExchange</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-26 23:02</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 写出输出结果
 *
 */
public class _2_IntegerLongExchange {

    public static void main(String[] args) {
        Long a = 1024L;
        int b = 1024;
        Integer c = null;
        System.out.println("(a == b) = " + (a==b));
        System.out.println("b.equals(a) = " + a.equals(b));
        System.out.println("(b == c) = " + (b==c));
    }

}
