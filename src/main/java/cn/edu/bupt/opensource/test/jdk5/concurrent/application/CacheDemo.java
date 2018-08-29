package cn.edu.bupt.opensource.test.jdk5.concurrent.application;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <p>Title: CacheDemo</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-05-31 21:46</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class CacheDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }

    private Map<String, Object> cache = new HashMap<>();

    private ReadWriteLock rwl = new ReentrantReadWriteLock();

    public  Object getData(String key){
        rwl.readLock().lock();
        Object value;
        try {
            value = cache.get(key);
            // DCL
            if(value == null) {
                rwl.readLock().unlock();
                rwl.writeLock().lock();
                try {
                    if(value == null){
                        value = "aaaa";   //实际失去queryDB();
                    }
                } finally {
                    rwl.writeLock().unlock();
                }
                rwl.readLock().lock();
            }
        } finally {
            rwl.readLock().unlock();
        }
        return value;
    }



}
