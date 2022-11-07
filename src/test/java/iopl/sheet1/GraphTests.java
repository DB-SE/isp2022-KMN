package iopl.sheet1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

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

		System.out.println("======LABELED GRAP=====");

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

	@Test
	public void testDFS() {

		System.out.println("======DFS=====");

		Graph none = new Graph();

		Graph one = new Graph();
		one.addVertex();

		Graph g = new Graph();
		g.addVertex();
		g.addVertex();
		g.addVertex();
		g.addVertex();
		g.addVertex();
		g.addVertex();
		g.addVertex();
		g.addVertex(); // 8 vertexes

		g.addEdge(4, 1);
		g.addEdge(0, 2);
		g.addEdge(3, 2);
		g.addEdge(3, 5);
		g.addEdge(5, 6);
		g.addEdge(6, 4);
		g.addEdge(2, 4);
		g.addEdge(0, 5);
		g.addEdge(5, 7);

		System.out.print("DFS(0): ");
		g.DFS(0, Graph.DebugMode.On, Graph.SearchMode.DepthFirstSearch);
		System.out.println("");

		System.out.print("DFS(4): ");
		g.DFS(4, Graph.DebugMode.On, Graph.SearchMode.DepthFirstSearch);
		System.out.println("");

		System.out.print("DFS(7): ");
		g.DFS(7, Graph.DebugMode.On, Graph.SearchMode.DepthFirstSearch);

		none.DFS(0, Graph.DebugMode.On, Graph.SearchMode.DepthFirstSearch);

		one.DFS(1, Graph.DebugMode.On, Graph.SearchMode.DepthFirstSearch);

		System.out.println("");
		System.out.println("");

	}

	@Test
	public void testDFSlabel() {

		System.out.println("======DFS - Label=====");

		LabeledGraph<String> stringGraph = new LabeledGraph<>();

		// not safe
		LabeledVertex<String> v = (LabeledVertex<String>) stringGraph.addVertex();
		v.setLabel("cat");
		v = (LabeledVertex<String>) stringGraph.addVertex();
		v.setLabel("test");
		v = (LabeledVertex<String>) stringGraph.addVertex();
		v.setLabel("tree");
		v = (LabeledVertex<String>) stringGraph.addVertex();
		v.setLabel("book");
		v = (LabeledVertex<String>) stringGraph.addVertex();
		v.setLabel("chest");
		v = (LabeledVertex<String>) stringGraph.addVertex();
		v.setLabel("bird");
		v = (LabeledVertex<String>) stringGraph.addVertex();
		v.setLabel("cow");
		v = (LabeledVertex<String>) stringGraph.addVertex();
		v.setLabel("pen");

		stringGraph.addEdge(4, 1);
		stringGraph.addEdge(0, 2);
		stringGraph.addEdge(3, 2);
		stringGraph.addEdge(3, 5);
		stringGraph.addEdge(5, 6);
		stringGraph.addEdge(6, 4);
		stringGraph.addEdge(2, 4);
		stringGraph.addEdge(0, 5);
		stringGraph.addEdge(5, 7);

		System.out.print("DFS- Label(0): ");
		stringGraph.DFS(0, Graph.DebugMode.On, Graph.SearchMode.DepthFirstSearch);
		System.out.println("");

		System.out.print("DFS- Label(4): ");
		stringGraph.DFS(4, Graph.DebugMode.On, Graph.SearchMode.DepthFirstSearch);
		System.out.println("");

		System.out.print("DFS- Label(7): ");
		stringGraph.DFS(7, Graph.DebugMode.On, Graph.SearchMode.DepthFirstSearch);

		System.out.println("");
		System.out.println("");

	}

	@Test
	public void testDFSweighted() {

		System.out.println("======DFS - weighted=====");

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

		System.out.print("DFS- Label(0): ");
		wg.DFS(0, Graph.DebugMode.On, Graph.SearchMode.DepthFirstSearch);
		System.out.println("");

		System.out.print("DFS- Label(1): ");
		wg.DFS(1, Graph.DebugMode.On, Graph.SearchMode.DepthFirstSearch);
		System.out.println("");

		System.out.print("DFS- Label(3): ");
		wg.DFS(3, Graph.DebugMode.On, Graph.SearchMode.DepthFirstSearch);

		System.out.println("");
		System.out.println("");

	}

	@Test
	public void testMST() {
		System.out.println("====== MST =====");

		WeightedGraph wg = new WeightedGraph();
		wg.addVertex();
		wg.addVertex();
		wg.addVertex();
		wg.addVertex();

		WeightedEdge edge = (WeightedEdge) wg.addEdge(0, 1);
		edge.setWeight(1);
		edge = (WeightedEdge) wg.addEdge(1, 2);
		edge.setWeight(2);
		edge = (WeightedEdge) wg.addEdge(2, 3);
		edge.setWeight(3);
		edge = (WeightedEdge) wg.addEdge(3, 0);
		edge.setWeight(5);
		edge = (WeightedEdge) wg.addEdge(0, 2);
		edge.setWeight(10);
		edge = (WeightedEdge) wg.addEdge(3, 1);
		edge.setWeight(20);

		var mst = wg.getAMinimumSpanningTree();
		System.out.println(mst.getSumWeight());
	}
}
