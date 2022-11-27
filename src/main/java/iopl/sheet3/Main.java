package iopl.sheet3;


public class Main {
	
	public static void main(String[] args) {
		
		
		// --------------------------------Create Graph
		
	
	Graph graph = new Graph();
		
		
		
		//-------------------------------------
		
		
		//----------------------------Create Vertices
		//#if BaseGraph && !LabeledGraph && !ColoredGraph  
//@		graph.addVertex();
//@		graph.addVertex();
//@		graph.addVertex();
//@		graph.addVertex();
//@		graph.addVertex();
//@		graph.addVertex();
//@		graph.addVertex();
//@		graph.addVertex(); // 8 vertexes
		//#endif
		
		
		//#if LabeledGraph && !ColoredGraph 
//@		graph.addVertex("cat");
//@		graph.addVertex("test");
//@		graph.addVertex("tree");
//@		graph.addVertex("book");
//@		graph.addVertex("chest");
//@		graph.addVertex("christmas");
//@		graph.addVertex("help");
//@		graph.addVertex("page");
		//#endif
		
		//#if ColoredGraph && !LabeledGraph 
				graph.addVertex(Color.Black);
				graph.addVertex(Color.Blue);
				graph.addVertex(Color.Green);
				graph.addVertex(Color.Brown);
				graph.addVertex(Color.Yellow);
				graph.addVertex(Color.Pink);
				graph.addVertex(Color.Purple);
				graph.addVertex(Color.Red);
		//#endif
		
		//#if ColoredGraph && LabeledGraph 
//@		graph.addVertex(Color.Black, "cat");
//@		graph.addVertex(Color.Blue, "test");
//@		graph.addVertex(Color.Green, "tree");
//@		graph.addVertex(Color.Brown, "book");
//@		graph.addVertex(Color.Yellow, "chest");
//@		graph.addVertex(Color.Pink, "christmas");
//@		graph.addVertex(Color.Purple, "help");
//@		graph.addVertex(Color.Red, "page");
		//#endif
				
		//---------------------------------
		//------------------------------------Create Edges
		
		//#if !WeightedGraph 
		graph.addEdge(4, 1);
		graph.addEdge(0, 2);
		graph.addEdge(3, 2);
		graph.addEdge(3, 5);
		graph.addEdge(5, 6);
		graph.addEdge(6, 4);
		graph.addEdge(2, 4);
		graph.addEdge(0, 5);
		graph.addEdge(5, 7);
		//#endif
		
	
		//#if WeightedGraph
//@		graph.addEdge(4, 1, 3.14);
//@		graph.addEdge(0, 2, -1);
//@		graph.addEdge(3, 2, 10.10);
//@		graph.addEdge(3, 5, 7);
//@		graph.addEdge(5, 6, -10);
//@		graph.addEdge(6, 4, 23);
//@		graph.addEdge(2, 4, 4);
//@		graph.addEdge(0, 5, 12);
		//#endif
		



		
		
		//----------------DFS
		
		System.out.println("======DFS=====");
		
		
		

		System.out.print("DFS(0): ");
		graph.DFS(0, Graph.DebugMode.On, Graph.SearchMode.DepthFirstSearch);
		System.out.println("");

		System.out.print("DFS(4): ");
		graph.DFS(4, Graph.DebugMode.On, Graph.SearchMode.DepthFirstSearch);
		System.out.println("");

		System.out.print("DFS(7): ");
		graph.DFS(7, Graph.DebugMode.On, Graph.SearchMode.DepthFirstSearch);
		
		
	
		
		//-----------------------------------------
		
		//----------------------------------Perform MST
		//#if MST 
//@		System.out.println("");
//@		System.out.println("");
//@		System.out.println("======MST=====");
//@		var mst = graph.getAMinimumSpanningTree();
//@		System.out.println(mst.getSumWeight());
		//#endif
		
		//#if DefaultMatrix || WeightedMatrix 
		System.out.println("");
		System.out.println("");
		System.out.println("======Matrix=====");
			graph.getAdjMatr();
		//#endif
			
		

	}
	

}
