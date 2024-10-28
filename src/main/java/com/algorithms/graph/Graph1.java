package com.algorithms.graph;

import java.util.*;

public class Graph1 {
    class Node implements Comparable<Node> {
        int id;
        int distance;

        public Node(int id, int distance) {
            this.id = id;
            this.distance = distance;
        }

        // Comparable interface to use priority queues
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Node node = (Node) obj;
            return id == node.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    private final Map<Integer, List<Node>> adjList;

    public Graph1() {
        this.adjList = new HashMap<>();
    }

    // Add an edge with a weight between two nodes
    public void addEdge(int source, int destination, int weight) {
        this.adjList.computeIfAbsent(source, k -> new ArrayList<>()).add(new Node(destination, weight));
        // For an undirected graph, add the reverse edge as well
        this.adjList.computeIfAbsent(destination, k -> new ArrayList<>()).add(new Node(source, weight));
    }

    public List<Node> getNeighbors(int id) {
        return adjList.getOrDefault(id, new ArrayList<>());
    }

    public boolean containsNode(int id) {
        return adjList.containsKey(id);
    }

    public Map<Integer, Integer> getShortestPath(int startNode) {
        var dist = new HashMap<Integer, Integer>();

        for (var node : adjList.keySet()) {
            dist.put(node, Integer.MAX_VALUE);
        }
        dist.put(startNode, 0);

        var queue = new PriorityQueue<Integer>();
        queue.add(startNode);

        while (!queue.isEmpty()) {
            var nodeId = queue.poll();
            for (var neighborNode : getNeighbors(nodeId)) {
                var newDist = dist.get(nodeId) + neighborNode.distance;
                if (newDist < dist.get(neighborNode.id)) {
                    dist.put(neighborNode.id, newDist);
                    queue.add(neighborNode.id);
                }
            }
        }

        return dist;
    }
}
