package com.algorithms.graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GraphTest {
    private Graph graph;

    @BeforeEach
    public void setUp() {
        graph = new Graph();
    }

    @Test
    public void testAddVertex() {
        assertTrue(graph.addVertex("A"));
        assertTrue(graph.getReadonlyAdjacencyList().containsKey("A"));

        // Should return false if trying to add a duplicate vertex
        assertFalse(graph.addVertex("A"));
    }

    @Test
    public void testAddEdge() {
        graph.addVertex("A");
        graph.addVertex("B");

        assertTrue(graph.addEdge("A", "B"));
        assertTrue(graph.getReadonlyAdjacencyList().get("A").contains("B"));
        assertTrue(graph.getReadonlyAdjacencyList().get("B").contains("A"));

        // Should return false if any vertex does not exist
        assertFalse(graph.addEdge("A", "C"));
    }

    @Test
    public void testRemoveEdge() {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B");

        assertTrue(graph.removeEdge("A", "B"));
        assertFalse(graph.getReadonlyAdjacencyList().get("A").contains("B"));
        assertFalse(graph.getReadonlyAdjacencyList().get("B").contains("A"));

        // Should return false if any vertex does not exist
        assertFalse(graph.removeEdge("A", "C"));
    }

    @Test
    public void testRemoveVertex() {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B");

        assertTrue(graph.removeVertex("A"));
        assertFalse(graph.getReadonlyAdjacencyList().containsKey("A"));
        assertFalse(graph.getReadonlyAdjacencyList().get("B").contains("A"));

        // Should return false if the vertex does not exist
        assertFalse(graph.removeVertex("C"));
    }
}