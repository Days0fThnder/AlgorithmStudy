package leetCode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    private Deque<Integer> dequeue;
    private Map<Integer, Integer> map;
    private int capacity;

    public LRUCache(int capacity) {
        dequeue = new LinkedList<>();
        map = new HashMap<>();
        this.capacity = capacity;

    }

    public int get(int key) {
        if(map.containsKey(key)){
            dequeue.addFirst(map.get(key));
            if(dequeue.size() > capacity){
                dequeue.removeLast();
            }
            return map.get(key);
        }

        return -1;
    }

    public void put(int key, int value) {
        if(!map.containsKey(key)){
            if(dequeue.size() == capacity){
                Integer last = dequeue.removeLast();
                map.remove(last);
            }
            dequeue.addFirst(value);
            map.put(key, value);
        }else{
            dequeue.addFirst(value);
        }

    }

    public static void main(String [] args){
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));

    }
}
