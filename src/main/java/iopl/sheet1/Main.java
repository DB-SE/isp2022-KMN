package iopl.sheet1;

import java.util.Arrays;

import iopl.sheet1.Graph.EdgeType;
import iopl.sheet1.Graph.Matrix;

public class Main {
	
	public static void main(String[] args) {
		
		
		// --------------------------------Create Graphs
		
		//#if BaseGraph && !WeightedGraph && !LabeledGraph && !ColoredGraph 
//@		Graph graph = new Graph();
		//#endif
		//#if WeightedGraph && !LabeledGraph && !ColoredGraph 
		WeightedGraph graph = new WeightedGraph();
		//#endif
		//#if ColoredGraph && WeightedGraph && !LabeledGraph 
//@		WeightedColoredGraph<Colors> graph = new WeightedColoredGraph();
		//#endif
		//#if LabeledGraph && WeightedGraph && !ColoredGraph 
//@				WeightedLabeledGraph<String> graph = new WeightedLabeledGraph<>();
				//#endif
		//#if LabeledGraph && !WeightedGraph && !ColoredGraph 
//@		LabeledGraph<String> graph = new LabeledGraph<>();
		//#endif
		//#if LabeledGraph && ColoredGraph && !WeightedGraph 
//@		ColoredLabeledGraph<Colors, String> graph = new ColoredLabeledGraph<>();
		//#endif
		//#if LabeledGraph && ColoredGraph && WeightedGraph 
//@		WeightedColoredLabeledGraph<Colors, String> graph = new WeightedColoredLabeledGraph<>();
		//#endif
		
		
		//-------------------------------------
		
		
		//----------------------------Create Vertices
		//#if !LabeledGraph  && !ColoredGraph 
		graph.addVertex();
		graph.addVertex();
		graph.addVertex();
		graph.addVertex();
		graph.addVertex();
		graph.addVertex();
		graph.addVertex();
		graph.addVertex(); // 8 vertexes
		//#endif
		
		
		//#if LabeledGraph && !ColoredGraph 
//@		LabeledVertex<String> v = (LabeledVertex<String>) graph.addVertex();
//@		v.setLabel("cat");
//@		v = (LabeledVertex<String>) graph.addVertex();
//@		v.setLabel("test");
//@		v = (LabeledVertex<String>) graph.addVertex();
//@		v.setLabel("tree");
//@		v = (LabeledVertex<String>) graph.addVertex();
//@		v.setLabel("book");
//@		v = (LabeledVertex<String>) graph.addVertex();
//@		v.setLabel("chest");
//@		v = (LabeledVertex<String>) graph.addVertex();
//@		v.setLabel("christmas");
//@		v = (LabeledVertex<String>) graph.addVertex();
//@		v.setLabel("help");
//@		v = (LabeledVertex<String>) graph.addVertex();
//@		v.setLabel("page");
		//#endif
		
		//#if ColoredGraph && !LabeledGraph 
//@				ColoredVertex<Colors> v = (ColoredVertex<Colors>) graph.addVertex();
//@				v.setColor(Colors.Black);
//@				v = (ColoredVertex<Colors>) graph.addVertex();
//@				v.setColor(Colors.Blue);
//@				v = (ColoredVertex<Colors>) graph.addVertex();
//@				v.setColor(Colors.Green);
//@				v = (ColoredVertex<Colors>) graph.addVertex();
//@				v.setColor(Colors.Brown);
//@				v = (ColoredVertex<Colors>) graph.addVertex();
//@				v.setColor(Colors.Yellow);
//@				v = (ColoredVertex<Colors>) graph.addVertex();
//@				v.setColor(Colors.Pink);
//@				v = (ColoredVertex<Colors>) graph.addVertex();
//@				v.setColor(Colors.Purple);
//@				v = (ColoredVertex<Colors>) graph.addVertex();
//@				v.setColor(Colors.Red);
		//#endif
		
		//#if ColoredGraph && LabeledGraph 
//@		ColoredLabeledVertex<Colors,String> v = (ColoredLabeledVertex<Colors,String>) graph.addVertex();
//@		v.setLabel("cat");
//@		v.setColor(Colors.Black);
//@		v = (ColoredLabeledVertex<Colors,String>) graph.addVertex();
//@		v.setLabel("test");
//@		v.setColor(Colors.Blue);
//@		v = (ColoredLabeledVertex<Colors,String>) graph.addVertex();
//@		v.setLabel("tree");
//@		v.setColor(Colors.Green);
//@		v = (ColoredLabeledVertex<Colors,String>) graph.addVertex();
//@		v.setLabel("book");
//@		v.setColor(Colors.Brown);
//@		v = (ColoredLabeledVertex<Colors,String>) graph.addVertex();
//@		v.setLabel("chest");
//@		v.setColor(Colors.Yellow);
//@		v = (ColoredLabeledVertex<Colors,String>) graph.addVertex();
//@		v.setLabel("christmas");
//@		v.setColor(Colors.Pink);
//@		v = (ColoredLabeledVertex<Colors,String>) graph.addVertex();
//@		v.setLabel("help");
//@		v.setColor(Colors.Purple);
//@		v = (ColoredLabeledVertex<Colors,String>) graph.addVertex();
//@		v.setLabel("page");
//@		v.setColor(Colors.Red);
		//#endif
				
		//---------------------------------
		//------------------------------------Create Edges
		
		graph.addEdge(4, 1);
		graph.addEdge(0, 2);
		graph.addEdge(3, 2);
		graph.addEdge(3, 5);
		graph.addEdge(5, 6);
		graph.addEdge(6, 4);
		graph.addEdge(2, 4);
		graph.addEdge(0, 5);
		graph.addEdge(5, 7);
		
	
		//#if WeightedGraph
		WeightedEdge edge = (WeightedEdge) graph.addEdge(4, 1);
		edge.setWeight(3.14);
		edge = (WeightedEdge) graph.addEdge(0, 2);
		edge.setWeight(-1);
		edge = (WeightedEdge) graph.addEdge(3, 2);
		edge.setWeight(10.10);
		edge = (WeightedEdge) graph.addEdge(3, 5);
		edge.setWeight(7);
		edge = (WeightedEdge) graph.addEdge(5, 6);
		edge.setWeight(-10);
		edge = (WeightedEdge) graph.addEdge(6, 4);
		edge.setWeight(23);
		edge = (WeightedEdge) graph.addEdge(2, 4);
		edge.setWeight(4);
		edge = (WeightedEdge) graph.addEdge(0, 5);
		edge.setWeight(12);
		edge = (WeightedEdge) graph.addEdge(5, 7);
		edge.setWeight(15);
		//#endif
		



		
		
		//----------------DFS
		
		System.out.println("======DFS=====");
		
		
		//#if UndirectedEdge 
//@
//@		System.out.print("DFS(0): ");
//@		graph.DFS(0, Graph.DebugMode.On, Graph.SearchMode.DepthFirstSearch, Graph.EdgeType.Undirected);
//@		System.out.println("");
//@
//@		System.out.print("DFS(4): ");
//@		graph.DFS(4, Graph.DebugMode.On, Graph.SearchMode.DepthFirstSearch, Graph.EdgeType.Undirected);
//@		System.out.println("");
//@
//@		System.out.print("DFS(7): ");
//@		graph.DFS(7, Graph.DebugMode.On, Graph.SearchMode.DepthFirstSearch, Graph.EdgeType.Undirected);
//@		
		//#endif 
		
		//#if DirectedEdge 
		
		System.out.print("DFS(0): ");
		graph.DFS(0, Graph.DebugMode.On, Graph.SearchMode.DepthFirstSearch, Graph.EdgeType.Directed);
		System.out.println("");

		System.out.print("DFS(4): ");
		graph.DFS(4, Graph.DebugMode.On, Graph.SearchMode.DepthFirstSearch, Graph.EdgeType.Directed);
		System.out.println("");

		System.out.print("DFS(7): ");
		graph.DFS(7, Graph.DebugMode.On, Graph.SearchMode.DepthFirstSearch, Graph.EdgeType.Directed);

		//#endif
		
		//-----------------------------------------
		
		//----------------------------------Perform MST
		//#if MST 
		System.out.println("");
		System.out.println("");
		System.out.println("======MST=====");
		
		//#if UndirectedEdge 
//@		var mst = graph.getAMinimumSpanningTree(Graph.EdgeType.Undirected);
//@		System.out.println(mst.getSumWeight());
		//#endif
		//#if DirectedEdge 
		var mst = graph.getAMinimumSpanningTree(Graph.EdgeType.Directed);
		System.out.println(mst.getSumWeight());
		//#endif
		//#endif
		
		//#if DefaultMatrix
//@		System.out.println("");
			//#if UndirectedEdge 
//@			graph.getAdjMatr(EdgeType.Undirected, Matrix.Unweighted);
			//#endif
			//#if DirectedEdge 
//@			graph.getAdjMatr(EdgeType.Directed, Matrix.Unweighted);
			//#endif
		//#endif
		
		//#if WeightedMatrix 
			System.out.println("");
			//#if UndirectedEdge 
//@			graph.getAdjMatr(EdgeType.Undirected,Matrix.Weighted);
			//#endif
			//#if DirectedEdge 
			graph.getAdjMatr(EdgeType.Directed,Matrix.Weighted);
			//#endif
		//#endif
		

	}
	

}
