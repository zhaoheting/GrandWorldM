package web.services.learn.lessons.graphSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 广度优先搜索
 */
public class Graph {

    private int vertexAmount;
    private List<Integer>[] adjacentList;

    public Graph(int amount) {
        this.vertexAmount = amount;
        for (int i = 0; i < amount; i++) {
            this.adjacentList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int s, int t) {
        adjacentList[s].add(t);
        adjacentList[t].add(s);
    }

    public void bfs(int start, int des) {
        //visited[i] = true, 则不用再往队列里面放
        boolean[] visited = new boolean[vertexAmount];
        Queue<Integer> vertexQueue = new LinkedList<>();
        int[] previous = new int[vertexAmount];
        for (int current : previous) {
            current = -1;
        }
        vertexQueue.offer(start);
        visited[0] = true;
        while (!vertexQueue.isEmpty()) {
            int current = vertexQueue.poll();
            for (int j = 0; j < adjacentList[current].size(); ++j) {
                int currentChild = adjacentList[current].get(j);
                if (!visited[currentChild]) {
                    previous[currentChild] = current;
                    if (current == des) {
                        printVertex(previous, start, des);
                        return;
                    }
                }
                vertexQueue.offer(currentChild);
                visited[current] = true;
            }
        }
    }

    public void printVertex(int[] previous, int start, int current) {
        int previousVertex = previous[current];
        if (previousVertex != -1 && current != start) {
            printVertex(previous, start, previousVertex);
        }
        System.out.println(current + " ");
    }
}
