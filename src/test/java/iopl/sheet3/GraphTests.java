package iopl.sheet3;

import org.junit.jupiter.api.Test;

import iopl.sheet3.Graph;

import iopl.sheet3.Graph.DebugMode;

import iopl.sheet3.Graph.SearchMode;

import java.util.Arrays;
/*
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
	public void testWeightedLabeledGraph() {
		
		System.out.println("======WEIGHTED LABELED GRAPH=====");
		WeightedLabeledGraph<String> g = new WeightedLabeledGraph<>();
		
		LabeledVertex<String> v = (LabeledVertex<String>) g.addVertex();
		v.setLabel("A");
		v = (LabeledVertex<String>) g.addVertex();
		v.setLabel("B");
		v = (LabeledVertex<String>) g.addVertex();
		v.setLabel("C");
		v = (LabeledVertex<String>) g.addVertex();
		v.setLabel("D");
		
		WeightedEdge edge = (WeightedEdge) g.addEdge(0, 1);
		edge.setWeight(3.14);
		edge = (WeightedEdge) g.addEdge(1, 3);
		edge.setWeight(-1);
		edge = (WeightedEdge) g.addEdge(2, 0);
		edge.setWeight(10.10);
		
		System.out.println(g);
	}
	
	@Test
	public void testWeightedLabeledGraphDFS() {
		
		System.out.println("======WEIGHTED LABELED GRAPH DFS=====");
		WeightedLabeledGraph<String> g = new WeightedLabeledGraph<>();
		
		LabeledVertex<String> v = (LabeledVertex<String>) g.addVertex();
		v.setLabel("A");
		v = (LabeledVertex<String>) g.addVertex();
		v.setLabel("B");
		v = (LabeledVertex<String>) g.addVertex();
		v.setLabel("C");
		v = (LabeledVertex<String>) g.addVertex();
		v.setLabel("D");
		
		WeightedEdge edge = (WeightedEdge) g.addEdge(0, 1);
		edge.setWeight(3.14);
		edge = (WeightedEdge) g.addEdge(1, 3);
		edge.setWeight(-1);
		edge = (WeightedEdge) g.addEdge(2, 0);
		edge.setWeight(10.10);
		
		g.DFS(1, DebugMode.On, SearchMode.DepthFirstSearch, EdgeType.Undirected);
		System.out.println("");
		g.DFS(1, DebugMode.On, SearchMode.DepthFirstSearch, EdgeType.Directed);
		System.out.println("");
	}
	
	@Test
	public void testWeightedLabeledGraphMST() {
		
		System.out.println("======WEIGHTED LABELED GRAPH MST=====");
		WeightedLabeledGraph<String> g = new WeightedLabeledGraph<>();
		
		LabeledVertex<String> v = (LabeledVertex<String>) g.addVertex();
		v.setLabel("A");
		v = (LabeledVertex<String>) g.addVertex();
		v.setLabel("B");
		v = (LabeledVertex<String>) g.addVertex();
		v.setLabel("C");
		v = (LabeledVertex<String>) g.addVertex();
		v.setLabel("D");
		
		WeightedEdge edge = (WeightedEdge) g.addEdge(0, 1);
		edge.setWeight(3.14);
		edge = (WeightedEdge) g.addEdge(1, 3);
		edge.setWeight(-1);
		edge = (WeightedEdge) g.addEdge(2, 0);
		edge.setWeight(10.10);
		
		WeightedGraph lg = g.getAMinimumSpanningTree(Graph.EdgeType.Undirected);
		System.out.println(lg);
		System.out.println("sum: " + lg.getSumWeight());
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
		g.DFS(0, Graph.DebugMode.On, Graph.SearchMode.DepthFirstSearch, Graph.EdgeType.Undirected);
		System.out.println("");

		System.out.print("DFS(4): ");
		g.DFS(4, Graph.DebugMode.On, Graph.SearchMode.DepthFirstSearch, Graph.EdgeType.Undirected);
		System.out.println("");

		System.out.print("DFS(7): ");
		g.DFS(7, Graph.DebugMode.On, Graph.SearchMode.DepthFirstSearch, Graph.EdgeType.Undirected);

		none.DFS(0, Graph.DebugMode.On, Graph.SearchMode.DepthFirstSearch, Graph.EdgeType.Undirected);

		one.DFS(1, Graph.DebugMode.On, Graph.SearchMode.DepthFirstSearch, Graph.EdgeType.Undirected);

		System.out.println("");
		System.out.println("");
	}

	@Test
	public void testDFSdirected(){
		System.out.println("======DFS - Directed/Undirected=====");

		Graph g = new Graph();
		g.addVertex();
		g.addVertex();
		g.addVertex();
		g.addVertex();
		g.addVertex();


		g.addEdge(0, 1);
		g.addEdge(2, 1);
		g.addEdge(3, 1);
		g.addEdge(3, 4);


		System.out.print("DFS(0) - Undirected: ");
		g.DFS(0, Graph.DebugMode.On, Graph.SearchMode.DepthFirstSearch, Graph.EdgeType.Undirected);
		System.out.println("");

		System.out.print("DFS(0) - Directed: ");
		g.DFS(0, Graph.DebugMode.On, Graph.SearchMode.DepthFirstSearch, Graph.EdgeType.Directed);
		System.out.println("");

		System.out.println("");
		System.out.println("");

		System.out.println("======DFS - Directed/Undirected with Label=====");

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

		stringGraph.addEdge(0, 1);
		stringGraph.addEdge(2, 1);
		stringGraph.addEdge(3, 1);
		stringGraph.addEdge(3, 4);


		System.out.print("DFS(0) - Undirected(Labeled): ");
		stringGraph.DFS(0, Graph.DebugMode.On, Graph.SearchMode.DepthFirstSearch, Graph.EdgeType.Undirected);
		System.out.println("");

		System.out.print("DFS(0) - Directed(Labeled): ");
		stringGraph.DFS(0, Graph.DebugMode.On, Graph.SearchMode.DepthFirstSearch, Graph.EdgeType.Directed);
		System.out.println("");

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
		stringGraph.DFS(0, Graph.DebugMode.On, Graph.SearchMode.DepthFirstSearch, Graph.EdgeType.Undirected);
		System.out.println("");

		System.out.print("DFS- Label(4): ");
		stringGraph.DFS(4, Graph.DebugMode.On, Graph.SearchMode.DepthFirstSearch, Graph.EdgeType.Undirected);
		System.out.println("");

		System.out.print("DFS- Label(7): ");
		stringGraph.DFS(7, Graph.DebugMode.On, Graph.SearchMode.DepthFirstSearch, Graph.EdgeType.Undirected);

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
		wg.DFS(0, Graph.DebugMode.On, Graph.SearchMode.DepthFirstSearch, Graph.EdgeType.Undirected);
		System.out.println("");

		System.out.print("DFS- Label(1): ");
		wg.DFS(1, Graph.DebugMode.On, Graph.SearchMode.DepthFirstSearch, Graph.EdgeType.Undirected);
		System.out.println("");

		System.out.print("DFS- Label(3): ");
		wg.DFS(3, Graph.DebugMode.On, Graph.SearchMode.DepthFirstSearch, Graph.EdgeType.Undirected);

		System.out.println("");
		System.out.println("");

	}

	@Test
	public void testMSTUndirected() {
		System.out.println("====== MST Uni =====");

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

		var mst = wg.getAMinimumSpanningTree(Graph.EdgeType.Undirected);
		System.out.println(mst.getSumWeight());
		System.out.println("");
	}
	
	@Test
	public void testMSTDirected() {
		System.out.println("====== MST Directed =====");

		WeightedGraph wg = new WeightedGraph();
		wg.addVertex();
		wg.addVertex();
		wg.addVertex();
		wg.addVertex();

		WeightedEdge edge = (WeightedEdge) wg.addEdge(0, 1);
		edge.setWeight(1);
		edge = (WeightedEdge) wg.addEdge(1, 2);
		edge.setWeight(2);
		edge = (WeightedEdge) wg.addEdge(3, 2);
		edge.setWeight(3);
		edge = (WeightedEdge) wg.addEdge(3, 0);
		edge.setWeight(5);
		edge = (WeightedEdge) wg.addEdge(2, 0);
		edge.setWeight(10);
		edge = (WeightedEdge) wg.addEdge(1, 3);
		edge.setWeight(20);

		var mst = wg.getAMinimumSpanningTree(Graph.EdgeType.Directed);
		System.out.println(mst.getSumWeight());
		System.out.println("");
	}
}
*/