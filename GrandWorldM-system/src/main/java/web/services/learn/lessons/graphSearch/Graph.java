package web.services.learn.lessons.graphSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 广度优先搜索
 */
public class Graph {

    private static int vertexAmount;
    private static List<Integer>[] adjacentList;

    public Graph(int vertexAmount) {
        this.vertexAmount = vertexAmount;
        adjacentList = new LinkedList[vertexAmount];
        for (int i = 0; i < vertexAmount; ++i) {
            adjacentList[i] = new LinkedList<>();
        }
    }

    private static Graph init(int vertexAmount) {
        Graph graph = new Graph(vertexAmount);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(3, 4);
        graph.addEdge(2, 5);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(6, 7);
        graph.addEdge(5, 7);
        return graph;
    }

    public static void main(String[] args) {
        init(8);
        breadthFirstSearch(0, 7);
    }

    public void addEdge(int start, int end) {
        this.adjacentList[start].add(end);
        this.adjacentList[end].add(start);
    }

    public static void breadthFirstSearch(int start, int end) {
        if (start == end) {
            return;
        }
        boolean[] visited = new boolean[vertexAmount];
        int[] prefix = new int[vertexAmount];
        for (int j = 0; j < vertexAmount; ++j) {
            prefix[j] = -1;
        }
        Queue<Integer> vertexQueue = new LinkedList<>();
        vertexQueue.offer(start);
        visited[start] = true;
        while (!vertexQueue.isEmpty()) {
            int currentVertex = vertexQueue.poll();
            for (int i = 0; i < adjacentList[currentVertex].size(); ++i) {
                int x = adjacentList[currentVertex].get(i);

                if (!visited[x]) {
                    prefix[x] = currentVertex;
                    if (x == end) {
                        print(prefix, start + 1, end);
                        System.out.print(end + " ");
                        return;
                    }
                    visited[x] = true;
                    vertexQueue.offer(x);
                }
            }
        }
    }

    private static void print(int[] prefix, int start, int end) {
        if (prefix[end] != -1 && end != start) {
            print(prefix, start, prefix[end]);
        }
        System.out.print(prefix[end] + " ");
    }
}
