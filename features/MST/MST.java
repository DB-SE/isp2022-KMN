import java.util.ArrayList;
import java.util.List;

public class MST {

	private Graph graph;

	public void setGraph(Graph graph) {
		this.graph = graph;
	}

	public Graph calculate() {
		if (this.graph.getVertices().size() == 0) {
			System.err.println("Cannot perform search on graph of size 0");
			return null;
		}

		return iterativeMST();
	}

	private Graph iterativeMST() {
		
		final List<Vertex> visited = new ArrayList<Vertex>();
		final List<Vertex> vertices = graph.getVertices();
		final List<Edge> edges = graph.getEdges();
		
		Vertex v=vertices.get(0); //starte mit irgendeinem Punkt
		visited.add(v);
		
		while(visited.size()<vertices.size()){
		List<Edge> outgoingEdges=new ArrayList<Edge>();
		outgoingEdges=getPossibleEdges(visited);
		Edge e=findLowestEdge(outgoingEdges);
		
			if(!visited.contains(e.getTargetVertex())) {
			visited.add(e.getTargetVertex());
			} else {
			visited.add(e.getOriginVertex());
			}
		}
		
		return null;
	}

	private Edge findLowestEdge(List<Edge> outgoingEdges) {
			int minimum = Integer.MAX_VALUE;
			Edge lowest=null;
			
			for (Edge e: outgoingEdges) {
				if(e.getValue()<minimum) {
					minimum=e.getValue();
					lowest=e;
				}
			}
			return lowest;
		
		}

	private List<Edge> getPossibleEdges(List<Vertex> visited) {
		
		List<Edge> outgoingEdges = new ArrayList<Edge>();
		
		for (Edge e : this.graph.getEdges()) {
			if (visited.contains(e.getOriginVertex()) || (e.allowsTwoWayTraversal() && visited.contains(e.getTargetVertex()))) {
				outgoingEdges.add(e);
			}
		}

		return outgoingEdges;
	}

}