import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class AGraph {
	
	protected final List<Vertex> vertices = new ArrayList<Vertex>();
	protected final List<Edge> edges = new ArrayList<Edge>();
	
	public abstract void addEdge(Edge edge);
	
	public abstract void addVertex(Vertex vertex);
	
	public abstract int[][] calculateAdjacencyMatrix();
	
	public void printAdjacencyMatrix() {
		
		int[][] adjacencyMatrix = this.calculateAdjacencyMatrix();
		StringBuilder builder = new StringBuilder();
		
		for (int[] row : adjacencyMatrix) {
			builder.append(Arrays.toString(row)).append("\n");
		}
		
		System.out.println(builder.toString());
	}
	
	public List<Edge> getEdges() {
		return this.edges;
	}
	
	public List<Vertex> getVertices() {
		return this.vertices;
	}
}
