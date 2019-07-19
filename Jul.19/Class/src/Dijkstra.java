import java.util.ArrayList;
import java.util.Arrays;

/**
 * Dijkstra有向图-Java实现
 *
 */
public class Dijkstra {
    public static void main(String[] args) {
/*String data = "6 9 1 2 1 1 3 12 2 3 9 2 4 3 3 5 5 4 3 4 4 5 13 4 6 15 5 6 4";
  以空格分隔
*/
        String data = "6 8 1 3 10 1 5 30 1 6 100 2 3 5 3 4 50 4 6 10 5 6 60 5 4 20";
        ArrayList<Integer> datas = new ArrayList<Integer>();
        for (String s : data.split(" ")) {
            datas.add(Integer.valueOf(s));

            //读入n和m，n表示顶点个数，m表示边的条数
            int n = datas.get(0);
            int m = datas.get(1);
            final int INF = 10000;
            int min = 10000;
            int[][] e = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        e[i][j] = 0;
                    } else {
                        e[i][j] = INF;
                    }
                }
            }
            for (int i = 2; i < datas.size(); i += 3) {
                e[datas.get(i) - 1][datas.get(i + 1) - 1] = datas.get(i + 2);
            }

            int begin = 0;
            //初始化dis数组，这里是begin顶点到其余各个顶点的初始路程
            int[] dis = e[begin];
            System.out.println("------------------dis数组--------------------------");
            System.out.println(Arrays.toString(dis));
            int[] book = new int[n];
            // 记录最短路径
            String[] path = new String[n];
            for (int i = 0; i < n; i++) {
                book[i] = 0;
                path[i] = (begin + 1) + " --> " + (i + 1);
            }
            book[begin] = 1;

            int u = 0;
            for (int i = 0; i < n - 1; i++) {
                min = INF;
                for (int j = 0; j < n; j++) {
                    if (book[j] == 0 && dis[j] < min) {
                        min = dis[j];
                        u = j;
                    }
                }
                /*Dijkstra算法核心*/
                book[u] = 1;
                for (int v = 0; v < n; v++) {
                    if (e[u][v] < INF && dis[v] > dis[u] + e[u][v]) {
                        dis[v] = dis[u] + e[u][v];
                        path[v] = path[u] + " --> " + (v + 1);
                    }
                }
            }

            System.out.println("---------------以" + (begin + 1) + "为起点的图的最短路径为-------------------");
            System.out.println(Arrays.toString(dis));
            System.out.println("");
            for (int i = 0; i < n; i++) {
                System.out.println(path[i] + "  =  " + dis[i]);
            }
        }
    }
}
