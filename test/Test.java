import java.util.List;

public class Test {
	
	public static void main(String[] args) {
		testAdjacency();
		testPrint();
	}
	
	public static void testPrint() {
		
		AGraph g = setUpGraph();
		
		for (Vertex v : g.getVertices()) {
			System.out.println(v.getValue());
		}
	}
	
	public static void testAdjacency() {
		
		setUpGraph().printAdjacencyMatrix();
	}
	
	private static AGraph setUpGraph() {
		AGraph graph = new Graph();
		
		// add vertices
		for(int i=0; i<10; i++) {
			Vertex v = new Vertex();
			// uncomment if colored/labeled is enabled
			v.setColor("yellow");
			v.setLabel("test");
			graph.addVertex(new Vertex());
		}
		
		// add edges
		List<Vertex> vertices = graph.getVertices();
		for (int i = 0; i < 9; i++) {
			Edge edge = new Edge();
			// uncomment if weighted is enabled
			edge.setWeight(5);
			edge.setEdge(vertices.get(i), vertices.get(i+1));
			graph.addEdge(edge);
			
			if (i%2 == 0) {
				edge = new Edge();
				edge.setEdge(vertices.get(4), vertices.get(9-i));
				
				graph.addEdge(edge);
			}
		}
		return graph;
	}
}
