package com.algorithms.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {
    private final HashMap<String, List<String>> adjacencyList = new HashMap<>();

    public HashMap<String, List<String>> getReadonlyAdjacencyList() {
        return new HashMap<>(adjacencyList);
    }

    public boolean addVertex(String vertex) {
        if (adjacencyList.containsKey(vertex)) {
            return false;
        }
        adjacencyList.put(vertex, new ArrayList<>());
        return true;
    }

    public boolean addEdge(String vertexA, String vertexB) {
        var vertexAEdges = adjacencyList.get(vertexA);
        var vertexBEdges = adjacencyList.get(vertexB);
        if (vertexAEdges == null || vertexBEdges == null) {
            return false;
        }
        vertexAEdges.add(vertexB);
        vertexBEdges.add(vertexA);
        return true;
    }

    public boolean removeEdge(String vertexA, String vertexB) {
        var vertexAEdges = adjacencyList.get(vertexA);
        var vertexBEdges = adjacencyList.get(vertexB);
        if (vertexAEdges == null || vertexBEdges == null) {
            return false;
        }
        vertexAEdges.removeIf(x -> x.equals(vertexB));
        vertexBEdges.removeIf(x -> x.equals(vertexA));
        return true;
    }

    public boolean removeVertex(String vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            return false;
        }
        var edges = adjacencyList.get(vertex);
        for (var connectedVertex : edges) {
            var connectedVertexEdges = adjacencyList.get(connectedVertex);
            connectedVertexEdges.removeIf(x -> x.equals(vertex));
        }
        adjacencyList.remove(vertex);
        return true;
    }
}
