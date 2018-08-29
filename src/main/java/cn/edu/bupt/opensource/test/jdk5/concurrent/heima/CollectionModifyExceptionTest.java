package cn.edu.bupt.opensource.test.jdk5.concurrent.heima;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <p>Title: CollectionModifyExceptionTest</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-05-31 23:28</p>
 *
 * @author ChengTengfei
 * @version 1.0
 */
public class CollectionModifyExceptionTest {

    public static void main(String[] args) {

        // 同步集合

        new ConcurrentHashMap<String, Integer>();

        new HashSet<String>();

        new HashMap<String, Integer>();

        Collection users = new CopyOnWriteArrayList();
        //new ArrayList();
        users.add(new User("张三",28));
        users.add(new User("李四",25));
        users.add(new User("王五",31));
        Iterator itrUsers = users.iterator();
        while(itrUsers.hasNext()){
            System.out.println("aaaa");
            User user = (User)itrUsers.next();
            if("李四".equals(user.getName())){
                users.remove(user);
                //itrUsers.remove();
            } else {
                System.out.println(user);
            }
        }
    }

}
