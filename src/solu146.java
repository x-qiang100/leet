import java.util.*;

/**
 * @author xq
 * @Date 2021/8/9 上午11:38
 * @ClassName solu146
 * @Description LRU缓存机制
 */

public class solu146 {

    class LRUCache {

        int size;
        int sec;
        int min;
        final int MAX;
        Map<Integer, int[]> map ;
        int[] ints ;
        public LRUCache(int capacity) {
            this.size = 0;
            this.sec = 0;
            this.min = 0;
            MAX = capacity;
            this.map = new HashMap<>();
            ints = new int[(int) (2e5+50)];
            Arrays.fill(ints, -1);
        }
        public int get(int key) {
            int[] val = map.get(key);
            if(val == null){
                return -1;
            }
            int old = val[1];
            ints[old] = -1;
            ints[sec] = key;
            val[1] = sec;
            map.put(key, val);

            updateMin();
            sec++;
            return val[0];
        }

        public void put(int key, int value) {
            int[] val = {value, sec};
            if(size < MAX ) {
                int[] olds = map.get(key);
                if(olds == null){
                    map.put(key, val);
                    updateMin();
                    size++;
                }else{
                    ints[olds[1]] = -1;
                    map.put(key, val);
                }
                ints[sec] = key;
            }else {
                int[] olds = map.get(key);
                if(olds != null){
                    map.put(key, val);
                    ints[olds[1]] = -1;
                }else{
                    int useless = ints[min];
                    int[] remove = map.remove(useless);
                    map.put(key, val);
                    ints[min] = -1;
                }
                updateMin();
                ints[sec] = key;
            }
            sec++;
        }

        private void updateMin(){
            while ( ints[min] == -1 && min < sec){
                min++;
            }
        }

    }

    public void test(){
        LRUCache lruCache = new LRUCache(2);
//        lruCache.put(1,1);
//        lruCache.put(2,2);
//        lruCache.get(1);
//        lruCache.put(3,3);
//        lruCache.get(2);
//        lruCache.put(4,4);
//        lruCache.put(3,3);
//
//        lruCache.get(1);
//        lruCache.get(3);
//        lruCache.get(4);

//        LRUCache lruCache = new LRUCache(2);
//        lruCache.put(2,1);
//        lruCache.put(1,1);
//        lruCache.put(2,3);
//        lruCache.put(4,1);
//        lruCache.get(1);
//        lruCache.get(2);

//        LRUCache lruCache = new LRUCache(2);
        lruCache.get(2);
        lruCache.put(2,6);
        lruCache.get(1);
        lruCache.put(1,5);
        lruCache.put(1,2);
        lruCache.get(2);
        lruCache.put(3,2);
        lruCache.get(1);
        lruCache.get(2);
        lruCache.get(3);

    }

    public static void main(String[] args) {
        solu146 s = new solu146();
        s.test();



    }
}

