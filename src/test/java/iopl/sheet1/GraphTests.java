package iopl.sheet1;

import org.junit.jupiter.api.Test;

// not really tests, just playing around a bit to see if something breaks...
class GraphTests {

    @Test
    public void testRegularGraph() {

        System.out.println("======REGULAR GRAPH=====");

        Graph g = new Graph();
        g.addVertex();
        g.addVertex();
        g.addVertex();

        g.addEdge(0, 1);
        g.addEdge(0, 2);

        System.out.println(g);
    }


    @Test
    public void testLabeledGraph() {

        System.out.println("======LABELED GRAPH=====");

        LabeledGraph<String> stringGraph = new LabeledGraph<>();

        // not safe
        LabeledVertex<String> v = (LabeledVertex<String>) stringGraph.addVertex();
        v.setLabel("cat");
        v = (LabeledVertex<String>) stringGraph.addVertex();
        v.setLabel("test");

        stringGraph.addEdge(0, 1);
        stringGraph.addEdge(0, 0);

        System.out.println(stringGraph);
    }


    @Test
    public void testWeightedGraph() {

        System.out.println("======WEIGHTED GRAPH=====");

        WeightedGraph wg = new WeightedGraph();
        wg.addVertex();
        wg.addVertex();
        wg.addVertex();
        wg.addVertex();

        WeightedEdge edge = (WeightedEdge) wg.addEdge(0, 1);
        edge.setWeight(3.14);
        edge = (WeightedEdge) wg.addEdge(1, 3);
        edge.setWeight(-1);
        edge = (WeightedEdge) wg.addEdge(2, 0);
        edge.setWeight(10.10);

        System.out.println(wg);
    }
}
