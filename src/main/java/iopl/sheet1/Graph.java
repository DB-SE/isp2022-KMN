package iopl.sheet1;

import java.util.ArrayList;
import java.util.Arrays;
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
     *
     * @param vertex1ID graph id of vertex 1
     * @param vertex2ID vertex graph id of vertex 2
     * @return The edge between vertex 1 and vertex 2
     * @throws NoSuchElementException if the given vertex ids are not present in the graph
     */
    Edge addEdge(int vertex1ID, int vertex2ID) throws NoSuchElementException {

        Vertex v1 = this.vertices.stream().filter(v -> v.getId() == vertex1ID).findFirst().orElseThrow();
        Vertex v2 = this.vertices.stream().filter(v -> v.getId() == vertex2ID).findFirst().orElseThrow();

        if(!contains(v1,this.vertices)){
            this.vertices.add(v1);
        }
        if(!contains(v2,this.vertices)){
            this.vertices.add(v2);
        }



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

    boolean contains(Vertex v,List<Vertex> list){
        for (Vertex inList: list
             ) {
            if(inList.getId()==v.getId()){
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        this.edges.forEach(e -> sb.append(e).append("\n"));

        return sb.toString();
    }

    public void DFS(Vertex startVertex){
        DFS(startVertex.getId());
    }

    public void DFS(int startId) {
        boolean visited[] = new boolean[vertexCount]; //mark every vertex as unvisited


        DFSrecursive(startId, visited);
    }

    public void DFS(LabeledVertex startLabeled){
        DFS(startLabeled.getId());
    }

    private void DFSrecursive(int startId, boolean visited[]) {
        visited[startId] = true; //mark startpoint


        for (Vertex v: vertices
             ) {
            if(v.getId()==startId){
                System.out.print(v+" ");

            }


        }
       // System.out.print(startId + " ");



        for (Edge e : edges
        ) {
            Vertex[] currentVertices = e.getVertices();
            /*//System.out.println(e);
            System.out.println(Arrays.toString(visited));
            System.out.println("vertices" + this.vertices);

            System.out.println(Arrays.toString(currentVertices));
            System.out.println("starter" + currentVertices[0]);
            System.out.println(startId);

             */

            if (currentVertices[0].getId() == startId) {
                if (!visited[currentVertices[1].getId()]) {
                    DFSrecursive(currentVertices[1].getId(), visited);
                }
            } else if (currentVertices[1].getId() == startId) {
                if (!visited[currentVertices[0].getId()]) {
                    DFSrecursive(currentVertices[0].getId(), visited);
                }
            }


        }
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
