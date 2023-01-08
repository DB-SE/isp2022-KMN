import java.util.ArrayList; 
import java.util.List; 
import java.util.Stack; 


public  class  DFS {
	
	
	private AGraph graph;

	

	public void setGraph(AGraph graph) {
		this.graph = graph;
	}

	
	
	public List<Vertex> calculcate(Vertex startVertex, boolean debug) {
		
		if (this.graph.getVertices().size() == 0) {
			System.err.println("Cannot perform search on graph of size 0");
			return null;
		}
		
		if (!this.graph.getVertices().contains(startVertex)) {
			System.err.println("The provided vertex is not part of the graph");
			return null;
		}
		
		return iterativeDFS(startVertex, debug);
	}

	
	
	
	private List<Vertex> iterativeDFS(Vertex startVertex, boolean debug) {
		
		final Stack<Vertex> stack = new Stack<Vertex>();
		final List<Vertex> visited = new ArrayList<Vertex>();
		
		stack.push(startVertex);
		
		while (!stack.empty()) {
			
			final Vertex top = stack.pop();
			
			if (!visited.contains(top)) {
				
				if (debug) System.out.println(top.toString().concat(" "));
				
				visited.add(top);
				final List<Vertex> neighbours = getNeighboursOf(top);
				
				for (Vertex n : neighbours) {
					stack.push(n);
				}
			}
		}
		
		return visited;
	}

	


	private List<Vertex> getNeighboursOf(Vertex vertex) {
		
		List<Edge> outgoingEdges = new ArrayList<Edge>();
		for (Edge e : this.graph.getEdges()) {
			if (e.getOriginVertex() == vertex || (e.allowsTwoWayTraversal() && e.getTargetVertex() == vertex)) {
				outgoingEdges.add(e);
			}
		}
		List<Vertex> neighbours = new ArrayList<Vertex>();
		
		for (Edge e : outgoingEdges) {
			if (e.getOriginVertex() == vertex) {
				neighbours.add(e.getTargetVertex());
			}
			else {
				neighbours.add(e.getOriginVertex());
			}
		}
		
		return neighbours;
	}


}
