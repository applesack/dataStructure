package 数据结构.图;

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
    public int getNumOfEdges() {
        return vertexList.size();
    }

    /**
     * 返回边的个数
     * @return
     */
    public int getNumofEdges() {
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

}
