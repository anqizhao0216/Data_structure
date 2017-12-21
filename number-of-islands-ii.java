/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */


// 一维数组和二维数组的转化
// 为什么要使用union find
// 1. bfs 时间，空间复杂度太高
// 2. 每执行一个operation，会影响周围的4个点，但是真正影响的岛的个数取决于这四个点在之前的
// 操作中是否已经相连，即需要判断两个点是否属于同一个集合之中，而这个功能是 union find 的
// 常用功能之一

// 时间复杂度是 K 为operations的个数 ， N， M 为二维数组的行与列的个数，
// 复杂度为O(4*K + N*M), N*M 是构建union find class 的时间复杂度
public class Solution {
    /*
     * @param n: An integer
     * @param m: An integer
     * @param operators: an array of point
     * @return: an integer array
     */
    private int[] dx = new int[]{0, 0, -1, 1};
    private int[] dy = new int[]{-1, 1, 0, 0};

    class UnionFind {
        int[] father = null;
        UnionFind(int n) {
            father = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }

        int find(int x) {
            if (father[x] == x) {
                return x;
            }
            return father[x] = find(father[x]);
        }

        void union(int a, int b) {
            int root_a = find(a);
            int root_b = find(b);
            if (root_a != root_b) {
                father[root_a] = root_b;
            }
        }
    }
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if (operators == null || operators.length == 0) return res;

        UnionFind uf = new UnionFind(n*m);
        int[] grid = new int[n*m];
        int count = 0;

        for (int i = 0; i < operators.length; i++) {

            // 如果是重复操作，count不变
            if (grid[operators[i].x * m + operators[i].y] != 1) {
                grid[operators[i].x * m + operators[i].y] = 1;
                count++;
            }

            for (int k = 0; k < 4; k++) {
                int x = dx[k] + operators[i].x;
                int y = dy[k] + operators[i].y;
                if (x >= 0 && x < n && y >= 0 && y < m && grid[x*m+y] == 1) {
                    int root_c = uf.find(operators[i].x * m + operators[i].y);
                    int root_n = uf.find(x*m+y);
                    if (root_c != root_n) {
                        count--;
                        uf.union(root_c, root_n);
                    }
                }
            }

            res.add(count);

        }

        return res;
    }
}
