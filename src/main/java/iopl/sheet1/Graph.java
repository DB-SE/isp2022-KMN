package iopl.sheet1;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Base graph implementation based on the graph examples from the second lecture.
 */
class Graph {

    protected int vertexCount = 0;
    protected final List<Edge> edges = new ArrayList<>();
    protected final List<Vertex> vertices = new ArrayList<>();


    /**
     * @return A new vertex with an id already assigned.
     */
    Vertex addVertex() {

        Vertex v = this.createVertex();
        this.vertices.add(v);
        this.vertexCount++;
        return v;
    }

    /**
     * Adds two vertices and an edge inbetween.
     * @param vertex1ID graph id of vertex 1
     * @param vertex2ID vertex graph id of vertex 2
     * @return The edge between vertex 1 and vertex 2
     * @throws NoSuchElementException if the given vertex ids are not present in the graph
     */
    Edge addEdge(int vertex1ID, int vertex2ID) throws NoSuchElementException {

        Vertex v1 = this.vertices.stream().filter(v -> v.getId() == vertex1ID).findFirst().orElseThrow();
        Vertex v2 = this.vertices.stream().filter(v -> v.getId() == vertex2ID).findFirst().orElseThrow();
        this.vertices.add(v1);
        this.vertices.add(v2);

        Edge edge = this.createEdge(v1, v2);
        this.edges.add(edge);
        return edge;
    }

    // template
    protected Edge createEdge(Vertex v1, Vertex v2) {

        return new Edge(v1, v2);
    }


    // template
    protected Vertex createVertex() {

        return new Vertex(this.vertexCount);
    }


    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        this.edges.forEach(e -> sb.append(e).append("\n"));

        return sb.toString();
    }
}

class WeightedGraph extends Graph {

    private static double DEFAULT_WEIGHT = 1;

    public static void setDefaultWeight(double defaultWeight) {

        WeightedGraph.DEFAULT_WEIGHT = defaultWeight;
    }

    @Override
    protected Edge createEdge(Vertex v1, Vertex v2) {

       return new WeightedEdge(v1, v2, WeightedGraph.DEFAULT_WEIGHT);
    }
}


class LabeledGraph<T> extends Graph {

    @Override
    protected Vertex createVertex() {

        return new LabeledVertex<T>(this.vertexCount);
    }
}
