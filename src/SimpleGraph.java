import java.util.*;

class Vertex {
    public int Value;
    public boolean Hit;

    public Vertex(int val) {
        Value = val;
        Hit = false;
    }
}

class SimpleGraph<T> {
    Vertex[] vertex;
    int[][] m_adjacency;
    int max_vertex;

    public SimpleGraph(int size) {
        max_vertex = size;
        m_adjacency = new int[size][size];
        vertex = new Vertex[size];
    }

    public ArrayList<Vertex> DepthFirstSearch(int VFrom, int VTo) {
        // Узлы задаются позициями в списке vertex.
        // Возвращается список узлов -- путь из VFrom в VTo.
        // Список пустой, если пути нет.

        Stack<Vertex> stack = new Stack<>();

        for (Vertex v : vertex) {
            v.Hit = false;
        }
        vertex[VFrom].Hit = true;
        stack.push(vertex[VFrom]);

        while (!stack.empty()) {
            int x = Arrays.asList(vertex).indexOf(stack.peek());
            if (IsEdge(x, VTo)) {
                stack.push(vertex[VTo]);
                break;
            }
            int j = 0;
            while (j < max_vertex) {
                if (IsEdge(x, j) && !vertex[j].Hit) {
                    vertex[j].Hit = true;
                    stack.push(vertex[j]);
                    break;
                }
                j++;
            }
            if (j == max_vertex) {
                stack.pop();
                if (stack.empty()) {
                    System.out.println("Путь не найден");
                }
            }
        }
        return new ArrayList<Vertex>(stack);
    }

    public ArrayList<Vertex> BreadthFirstSearch(int VFrom, int VTo) {
        // Узлы задаются позициями в списке vertex.
        // Возвращается список узлов -- путь из VFrom в VTo.
        // Список пустой, если пути нет.
        Queue<Vertex> queue = new LinkedList<>();
        ArrayList<Vertex> path = new ArrayList<>();
        int[] parent = new int[max_vertex];

        for (Vertex v : vertex) {
            v.Hit = false;
        }
        vertex[VFrom].Hit = true;
        queue.add(vertex[VFrom]);

        while (!queue.isEmpty()) {
            int x = Arrays.asList(vertex).indexOf(queue.poll());
            int j = 0;
            while (j < max_vertex) {

                if (IsEdge(x, j) && !vertex[j].Hit) {
                    vertex[j].Hit = true;
                    parent[j] = x;
                    System.out.println("parent " + j + " = " + parent[j]);
                    if (j == VTo) {
                        break;
                    }
                    queue.add(vertex[j]);
                }
                j++;
                if (j == max_vertex) {
                    if (queue.isEmpty()) {
                        break;
                    }
                }
            }
        }
        int i = VTo;
        while (i != VFrom) {
            path.add(vertex[i]);
            i = parent[i];
        }
        path.add(vertex[VFrom]);
        Collections.reverse(path);
        if (path.size()==1){
            path.clear();
        }
        return path;
    }

    public void AddVertex(int value) {
        // ваш код добавления новой вершины
        // с значением value
        // в незанятую позицию vertex
        int i;
        for (i = 0; i < max_vertex; i++) {
            if (vertex[i] == null) {
                break;
            }
        }
        vertex[i] = new Vertex(value);
    }

    // здесь и далее, параметры v -- индекс вершины
    // в списке  vertex
    public void RemoveVertex(int v) {
        // ваш код удаления вершины со всеми её рёбрами
        if (v < max_vertex) {
            vertex[v] = null;
            for (int i = 0; i < max_vertex; i++) {
                for (int j = 0; j < max_vertex; j++) {
                    if (i == v || j == v) {
                        m_adjacency[i][j] = 0;
                    }
                }
            }
        }
    }

    public boolean IsEdge(int v1, int v2) {
        // true если есть ребро между вершинами v1 и v2
        return v1 < max_vertex && v2 < max_vertex && m_adjacency[v1][v2] == 1 && m_adjacency[v2][v1] == 1;
    }

    public void AddEdge(int v1, int v2) {
        // добавление ребра между вершинами v1 и v2
        if (v1 < max_vertex && v2 < max_vertex) {
            m_adjacency[v1][v2] = 1;
            m_adjacency[v2][v1] = 1;
        }
    }

    public void RemoveEdge(int v1, int v2) {
        // удаление ребра между вершинами v1 и v2
        if (v1 < max_vertex && v2 < max_vertex) {
            m_adjacency[v1][v2] = 0;
            m_adjacency[v2][v1] = 0;
        }
    }
}