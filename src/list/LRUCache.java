package list;
import java.util.*;

//这道题可以使用继承linkedhashmap来实现，重点是重写删除过期元素的方法
class LRUCache extends LinkedHashMap<Integer, Integer>{
    private int capacity;
    public LRUCache(int capacity) {
    	//true = 开启访问排序模式，只要调用 get() / put(已有key) 访问元素，
    	//节点会自动移动到双向链表末尾。配合删除方法即可满足要求
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }
    
    public int get(int key) {
         return super.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        super.put(key, value);
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
