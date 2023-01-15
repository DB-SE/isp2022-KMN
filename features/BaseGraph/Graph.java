import java.util.List;
import java.util.ArrayList;


public class Graph {
	
	protected final List<Vertex> vertices = new ArrayList<Vertex>();
	protected final List<Edge> edges = new ArrayList<Edge>();
	
	public void addEdge(Edge edge) {
		this.edges.add(edge);
	}

	public void addVertex(Vertex vertex) {
		this.vertices.add(vertex);
	}
	
	public List<Edge> getEdges() {
		return this.edges;
	}
	
	public List<Vertex> getVertices() {
		return this.vertices;
	}
}