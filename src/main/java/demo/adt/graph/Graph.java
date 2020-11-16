package demo.adt.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年05月16日 22:00
 */
public class Graph {
    /**
     * 图
     */

    private ArrayList<String>  vertexList; // 存储顶点集合
    private int[][] edges; // 存储图对应的邻接矩阵
    private int numOfEdges; // 当前图有多少条边

    // 定义一个布尔数组，记录每个结点是否被访问过
    private boolean[] isVisited;

    public static void main(String[] args) {
        int n = 5; // 节点数5
        String[] vertexValue = {"A", "B", "C", "D", "E"};

        // 创建图对象
        Graph graph = new Graph(n); // 顶点数量n
        for (String val : vertexValue) {
            graph.insertVertex(val);
        }

        /**
         * 添加边
         * A-B
         * A-C
         * B-C
         * B-D
         * B-E
         */
        graph.insertEdge(0, 1, 1); // A-B
        graph.insertEdge(0, 2, 1); // A-C
        graph.insertEdge(1, 2, 1); // B-C
        graph.insertEdge(1, 3, 1); // B-D
        graph.insertEdge(1, 4, 1); // B-E

        graph.showGraph(); // 显示邻接矩阵

        // 深度遍历
        graph.dfs();
    }

    /**
     * 用边的数目构建一个图
     * @param n
     */
    public Graph(int n) {
        // 初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0; // 默认当前有0条边

        isVisited = new boolean[n];
    }

    // 插入顶点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 添加边
     * @param v1 表示点的下标，即第几个顶点
     * @param v2
     * @param weight 权值
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;

        numOfEdges++;
    }

    /**
     * 返回节点个数
     * @return
     */
    public int getNumOfVertex() {
        return vertexList.size();
    }

    /**
     * 返回边的个数
     * @return
     */
    public int getNumOfEdges() {
        return numOfEdges;
    }

    /**
     * 返回index对应下标的数据
     * @param index
     * @return
     */
    public String getValueByIndex(int index) {
        return vertexList.get(index);
    }

    // 返回两个顶点之间的权值
    public int getWidth(int v1, int v2) {
        return edges[v1][v2];
    }

    // 显示图对应的矩阵
    public void showGraph() {
        System.out.println("  " + vertexList.toString());
        for (int i = 0; i<vertexList.size(); i++) {
            System.out.print(vertexList.get(i) + " ");
            System.out.println(Arrays.toString(edges[i]));
        }
    }

    /**
     * 得到第一个邻接节点的下标
     * @param index
     * @return 如果存在就返回对应的下标，否则返回-1
     */
    private int getFirstNeighbor(int index) {
        for (int j = 0; j<vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    // 根据前一个结点的下标来获取下一个邻接结点
    private int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j<vertexList.size(); j++) {
            if (edges[v1][j] > 0)
                return j;
        }
        return -1;
    }

    /**
     * 深度优先算法
     */
    public void dfs(boolean[] isVisited, int i) {
        // 首先访问这个结点，输出
        System.out.print(getValueByIndex(i) + "=>");
        // 将这个结点设置为已访问
        isVisited[i] = true;

        // 访问这个结点的第一个邻接结点
        int w = getFirstNeighbor(i);
        while (w != -1) { // 第一个邻接结点存在
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }

            // 如果结点已经被访问过
            w = getNextNeighbor(i, w);
        }
    }

    private void dfs() {
        // 遍历所有结点， 进行dfs[回溯]
        for (int i = 0; i<getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }
}
