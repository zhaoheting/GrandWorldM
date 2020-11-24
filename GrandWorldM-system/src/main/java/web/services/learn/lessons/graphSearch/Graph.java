package web.services.learn.lessons.graphSearch;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private int vertexAmount;
    private List<Integer>[] adjacentList;

    public Graph(int amount) {
        this.vertexAmount = amount;
        for (int i = 0; i < amount; i++) {
            this.adjacentList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int s, int t){
        adjacentList[s].add(t);
        adjacentList[t].add(s);
    }

    public void bfs(int s, int t){

    }
}
