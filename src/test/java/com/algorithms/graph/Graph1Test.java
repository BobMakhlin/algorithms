package com.algorithms.graph;

import org.junit.jupiter.api.Test;

class Graph1Test {
    @Test
    void test() {
        var graph = new Graph1();
        // Add edges: addEdge(source, destination, weight)
        graph.addEdge(1, 2, 4);
        graph.addEdge(1, 3, 1);
        graph.addEdge(3, 2, 2);
        graph.addEdge(2, 4, 5);
        graph.addEdge(3, 4, 8);

//        Dijkstra dijkstra = new Dijkstra();
//        int startNode = 1;
        var shortestPaths = graph.getShortestPath(1);
        var x = 1;
//
//        // Print shortest path distances from startNode
//        for (Map.Entry<Integer, Integer> entry : shortestPaths.entrySet()) {
//            System.out.println("Distance from node " + startNode + " to node " + entry.getKey() + " is " + entry.getValue());
//        }

    }
}