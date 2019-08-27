import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SimpleGraphTest {

    @Test
    void addVertex() {
        SimpleGraph graph = new SimpleGraph(5);
        graph.AddVertex(10);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
//        graph.AddVertex(4);
//        graph.AddVertex(5);

        assertEquals(10, graph.vertex[0].Value);
        assertEquals(1, graph.vertex[1].Value);
        assertEquals(2, graph.vertex[2].Value);
        assertEquals(3, graph.vertex[3].Value);
        assertNull(graph.vertex[4]);

        for (Vertex v : graph.vertex) {
            if (v == null) {
                System.out.println("null");
            } else
                System.out.println(v.Value);
        }
    }

    @Test
    void removeVertex() {
        SimpleGraph graph = new SimpleGraph(5);
        graph.AddVertex(10);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);

        assertEquals(10, graph.vertex[0].Value);
        assertEquals(1, graph.vertex[1].Value);
        assertEquals(2, graph.vertex[2].Value);
        assertEquals(3, graph.vertex[3].Value);
        assertNull(graph.vertex[4]);

        assertEquals(0, graph.m_adjacency[0][1]);
        assertEquals(0, graph.m_adjacency[0][2]);
        assertEquals(0, graph.m_adjacency[0][3]);
        assertEquals(0, graph.m_adjacency[1][0]);
        assertEquals(0, graph.m_adjacency[2][0]);
        assertEquals(0, graph.m_adjacency[3][0]);

        graph.AddEdge(0, 1);
        graph.AddEdge(0, 2);
        graph.AddEdge(0, 3);

        assertEquals(1, graph.m_adjacency[0][1]);
        assertEquals(1, graph.m_adjacency[0][2]);
        assertEquals(1, graph.m_adjacency[0][3]);
        assertEquals(1, graph.m_adjacency[1][0]);
        assertEquals(1, graph.m_adjacency[2][0]);
        assertEquals(1, graph.m_adjacency[3][0]);

        graph.RemoveVertex(1);

        assertEquals(0, graph.m_adjacency[0][1]);
        assertEquals(1, graph.m_adjacency[0][2]);
        assertEquals(1, graph.m_adjacency[0][3]);
        assertEquals(0, graph.m_adjacency[1][0]);
        assertEquals(1, graph.m_adjacency[2][0]);
        assertEquals(1, graph.m_adjacency[3][0]);

        System.out.println(Arrays.deepToString(graph.m_adjacency));
    }

    @Test
    void isEdge() {
        SimpleGraph graph = new SimpleGraph(5);
        graph.AddVertex(10);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);

        assertEquals(10, graph.vertex[0].Value);
        assertEquals(1, graph.vertex[1].Value);
        assertEquals(2, graph.vertex[2].Value);
        assertEquals(3, graph.vertex[3].Value);
        assertNull(graph.vertex[4]);

        assertEquals(0, graph.m_adjacency[0][1]);
        assertEquals(0, graph.m_adjacency[0][2]);
        assertEquals(0, graph.m_adjacency[0][3]);
        assertEquals(0, graph.m_adjacency[1][0]);
        assertEquals(0, graph.m_adjacency[2][0]);
        assertEquals(0, graph.m_adjacency[3][0]);

        graph.AddEdge(0, 1);
        graph.AddEdge(0, 2);
        graph.AddEdge(0, 3);

        assertEquals(1, graph.m_adjacency[0][1]);
        assertEquals(1, graph.m_adjacency[0][2]);
        assertEquals(1, graph.m_adjacency[0][3]);
        assertEquals(1, graph.m_adjacency[1][0]);
        assertEquals(1, graph.m_adjacency[2][0]);
        assertEquals(1, graph.m_adjacency[3][0]);

        assertTrue(graph.IsEdge(1, 0));
        assertTrue(graph.IsEdge(2, 0));
        assertTrue(graph.IsEdge(3, 0));
        assertFalse(graph.IsEdge(3, 1));
        assertFalse(graph.IsEdge(2, 1));
        assertFalse(graph.IsEdge(3, 2));

        graph.RemoveEdge(1, 0);

        assertEquals(0, graph.m_adjacency[0][1]);
        assertEquals(1, graph.m_adjacency[0][2]);
        assertEquals(1, graph.m_adjacency[0][3]);
        assertEquals(0, graph.m_adjacency[1][0]);
        assertEquals(1, graph.m_adjacency[2][0]);
        assertEquals(1, graph.m_adjacency[3][0]);

        assertFalse(graph.IsEdge(0, 1));
        assertFalse(graph.IsEdge(1, 0));
        assertTrue(graph.IsEdge(2, 0));
        assertTrue(graph.IsEdge(3, 0));

        System.out.println(Arrays.deepToString(graph.m_adjacency));
    }

    @Test
    void addEdge() {
        SimpleGraph graph = new SimpleGraph(5);
        graph.AddVertex(10);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);

        assertEquals(10, graph.vertex[0].Value);
        assertEquals(1, graph.vertex[1].Value);
        assertEquals(2, graph.vertex[2].Value);
        assertEquals(3, graph.vertex[3].Value);
        assertNull(graph.vertex[4]);

        assertEquals(0, graph.m_adjacency[0][1]);
        assertEquals(0, graph.m_adjacency[0][2]);
        assertEquals(0, graph.m_adjacency[0][3]);
        assertEquals(0, graph.m_adjacency[1][0]);
        assertEquals(0, graph.m_adjacency[2][0]);
        assertEquals(0, graph.m_adjacency[3][0]);

        graph.AddEdge(0, 1);
        graph.AddEdge(0, 2);
        graph.AddEdge(0, 3);

        assertEquals(1, graph.m_adjacency[0][1]);
        assertEquals(1, graph.m_adjacency[0][2]);
        assertEquals(1, graph.m_adjacency[0][3]);
        assertEquals(1, graph.m_adjacency[1][0]);
        assertEquals(1, graph.m_adjacency[2][0]);
        assertEquals(1, graph.m_adjacency[3][0]);

        System.out.println(Arrays.deepToString(graph.m_adjacency));
    }

    @Test
    void removeEdge() {
        SimpleGraph graph = new SimpleGraph(5);
        graph.AddVertex(10);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);

        assertEquals(10, graph.vertex[0].Value);
        assertEquals(1, graph.vertex[1].Value);
        assertEquals(2, graph.vertex[2].Value);
        assertEquals(3, graph.vertex[3].Value);
        assertNull(graph.vertex[4]);

        assertEquals(0, graph.m_adjacency[0][1]);
        assertEquals(0, graph.m_adjacency[0][2]);
        assertEquals(0, graph.m_adjacency[0][3]);
        assertEquals(0, graph.m_adjacency[1][0]);
        assertEquals(0, graph.m_adjacency[2][0]);
        assertEquals(0, graph.m_adjacency[3][0]);

        graph.AddEdge(0, 1);
        graph.AddEdge(0, 2);
        graph.AddEdge(0, 3);

        assertEquals(1, graph.m_adjacency[0][1]);
        assertEquals(1, graph.m_adjacency[0][2]);
        assertEquals(1, graph.m_adjacency[0][3]);
        assertEquals(1, graph.m_adjacency[1][0]);
        assertEquals(1, graph.m_adjacency[2][0]);
        assertEquals(1, graph.m_adjacency[3][0]);

        graph.RemoveEdge(1, 0);

        assertEquals(0, graph.m_adjacency[0][1]);
        assertEquals(1, graph.m_adjacency[0][2]);
        assertEquals(1, graph.m_adjacency[0][3]);
        assertEquals(0, graph.m_adjacency[1][0]);
        assertEquals(1, graph.m_adjacency[2][0]);
        assertEquals(1, graph.m_adjacency[3][0]);

        System.out.println(Arrays.deepToString(graph.m_adjacency));
    }

    @Test
    void depthFirstSearch() {
        SimpleGraph graph = new SimpleGraph(5);
        graph.AddVertex(10);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);


        graph.AddEdge(0, 1);
        graph.AddEdge(0, 2);
        graph.AddEdge(0, 3);
        graph.AddEdge(1, 3);
        graph.AddEdge(2, 3);
        graph.AddEdge(1, 4);
        graph.AddEdge(3, 4);

        ArrayList<Vertex> path = graph.DepthFirstSearch(0, 4);
        for (Vertex v : path) {
            System.out.println(v.Value);
        }
    }

    @Test
    void breadthFirstSearch() {
        SimpleGraph graph = new SimpleGraph(8);
        graph.AddVertex(10);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);
        graph.AddVertex(5);
        graph.AddVertex(6);
        graph.AddVertex(7);


        graph.AddEdge(0, 1);
        graph.AddEdge(0, 2);
        graph.AddEdge(0, 3);
        graph.AddEdge(1, 3);
        graph.AddEdge(2, 3);
        graph.AddEdge(3, 4);
        graph.AddEdge(2, 5);
        graph.AddEdge(4, 6);
        graph.AddEdge(1, 7);

        ArrayList<Vertex> path = graph.BreadthFirstSearch(0, 4);
        for (Vertex v : path) {
            System.out.println(v.Value);
        }

    }
}