package Common;

/**
 * @author xq
 * @Date 2021/8/2 下午9:38
 * @ClassName UnionFind
 * @Description 并查集实现
 */

public class UnionFind {
    private final int[] ints;
    private final int size;

    public UnionFind(int size) {
        this.size = size;
        this.ints = new int[size];
        for (int i = 0; i < size; i++) {
            ints[i] = i;
        }
    }

    public int getSize() {
        return size;
    }

    static void unionSet(UnionFind u, int x, int y){
        x = find(u, x);
        y = find(u, y);
        u.ints[y] = x;
    }

    static int find(UnionFind u, int x){
        int[] nums = u.ints;
        while (nums[x] != x){
            x = nums[x];
        }
        return x;
    }

    public static void main(String[] args) {
        UnionFind find = new UnionFind(10);
        UnionFind.unionSet(find, 2,5);
        UnionFind.unionSet(find, 1,2);
        System.out.println("UnionFind.find(find,1) = " + UnionFind.find(find, 1));
    }



}

