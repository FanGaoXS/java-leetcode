package cn.fangaoxs.day6.subject146;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/08/24/17:03
 * @Description:
 */

class LRUCache {

    private LinkedHashMap<Integer,Integer> map;

    /**
     * 初始化容量
     * @param capacity  容量
     */
    public LRUCache(int capacity){
        map = new LinkedHashMap<Integer,Integer>(capacity,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return map.size() > capacity; //移除最久未使用的元素
            }
        };
    }

    /**
     * 查找该key是否存在，存在则返回key对应的value
     * @param key       元素
     * @return
     */
    public int get(int key){
        return map.getOrDefault(key,-1);
    }

    /**
     * 如果key已经存在则改变其value，否则以key-value的方式插入元素
     * （在写入数据前判断容量是否已达上限，已达上限则需要在写入前删除最久未使用的数据值）
     * @param key
     * @param value
     */
    public void put(int key,int value){
        map.put(key,value);
    }

}
